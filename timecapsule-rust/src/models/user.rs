extern crate serde;
use crate::{schema::*, MysqlPooledConnection};
use chrono::*;
use diesel::{prelude::*, result::Error};
use serde::{Deserialize, Serialize};

#[derive(Queryable, Debug, AsChangeset, Serialize, Deserialize, Insertable)]
#[table_name = "user"]
pub struct User {
    pub id: i64,
    pub username: String,
    pub password: String,
    pub nickname: Option<String>,
    pub email: String,
    pub createtime: Option<NaiveDateTime>,
    pub updatetime: Option<NaiveDateTime>,
    pub avatar: Option<String>,
}

#[derive(Insertable)]
#[table_name = "user"]
pub struct NewUser {
    pub username: String,
    pub password: String,
    pub nickname: Option<String>,
    pub email: String,
    pub avatar: Option<String>,
}

pub fn get_all(connection: &MysqlPooledConnection) -> Result<Vec<User>, Error> {
    use crate::schema::user::dsl::*;

    let users = user.load::<User>(connection)?;
    Ok(users.into())
}

pub fn get_one(connection: &MysqlPooledConnection, user_username: &str) -> Result<User, Error> {
    use crate::schema::user::dsl::*;

    let the_user = user
        .filter(username.eq(user_username))
        .first::<User>(connection)?;
    Ok(the_user.into())
}

pub fn insert(connection: &MysqlPooledConnection, new_user: User) -> Result<usize, Error> {
    use crate::schema::user::dsl::*;

    diesel::insert_into(user)
        .values(&new_user)
        .execute(connection)
}

pub fn update(
    connection: &MysqlPooledConnection,
    user_username: &str,
    new_user: User,
) -> Result<usize, Error> {
    use crate::schema::user::dsl::*;

    diesel::update(user)
        .filter(username.eq(user_username))
        .set(&new_user)
        .execute(connection)
}

pub fn delete(connection: &MysqlPooledConnection, user_username: &str) -> Result<usize, Error> {
    use crate::schema::user::dsl::*;
    diesel::delete(user)
        .filter(username.eq(user_username))
        .execute(connection)
}

#[cfg(test)]
pub mod tests {
    #[test]
    fn crud_user() {
        use crate::*;
        // use diesel::prelude::*;
        use crate::models::user::{NewUser, User};
        use crate::schema::user::dsl::*;

        let connection = establish_connection();

        // Insert
        let new_user = NewUser {
            username: String::from("Rust_Test"),
            password: String::from("password"),
            nickname: Some(String::from("Diesel")),
            email: String::from("None"),
            avatar: Some(String::from("None")),
        };
        diesel::insert_into(user)
            .values(&new_user)
            .execute(&connection)
            .expect("Insert Failed");

        // Query
        user.filter(username.eq("Rust_Test"))
            .first::<User>(&connection)
            .expect("Error loading User.");

        // Update
        let mut old_user = user
            .filter(username.eq("Rust_Test"))
            .first::<User>(&connection)
            .expect("Find Failed.");
        old_user.password = String::from("this is second password.");

        diesel::update(user)
            .filter(username.eq(old_user.username.clone()))
            .set(&old_user)
            .execute(&connection)
            .expect("Update Failed.");

        // Delete
        diesel::delete(user)
            .filter(username.eq("Rust_Test"))
            .execute(&connection)
            .expect("Delete Failed.");
    }
}
