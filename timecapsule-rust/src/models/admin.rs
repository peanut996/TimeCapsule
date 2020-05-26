extern crate serde;
use crate::{schema::*, MysqlPooledConnection};
use diesel::{prelude::*, result::Error};
use serde::{Deserialize, Serialize};
#[derive(Queryable, Debug, AsChangeset, Deserialize, Serialize, Insertable)]
#[table_name = "admin"]
pub struct Admin {
    pub id: i64,
    pub account: String,
    pub password: String,
    pub description: Option<String>,
    pub avatar: Option<String>,
}

#[derive(Insertable)]
#[table_name = "admin"]
pub struct NewAdmin {
    pub account: String,
    pub password: String,
    pub description: Option<String>,
    pub avatar: Option<String>,
}

pub fn get_all(connection: &MysqlPooledConnection) -> Result<Vec<Admin>, Error> {
    use crate::schema::admin::dsl::*;

    let admins = admin.load::<Admin>(connection)?;
    Ok(admins.into())
}

pub fn get_one(connection: &MysqlPooledConnection, admin_account: &str) -> Result<Admin, Error> {
    use crate::schema::admin::dsl::*;

    let the_admin = admin
        .filter(account.eq(admin_account))
        .first::<Admin>(connection)?;
    Ok(the_admin.into())
}

pub fn insert(connection: &MysqlPooledConnection, new_admin: Admin) -> Result<usize, Error> {
    use crate::schema::admin::dsl::*;

    diesel::insert_into(admin)
        .values(&new_admin)
        .execute(connection)
}

pub fn update(
    connection: &MysqlPooledConnection,
    admin_account: &str,
    new_admin: Admin,
) -> Result<usize, Error> {
    use crate::schema::admin::dsl::*;

    diesel::update(admin)
        .filter(account.eq(admin_account))
        .set(&new_admin)
        .execute(connection)
}

pub fn delete(connection: &MysqlPooledConnection, admin_account: &str) -> Result<usize, Error> {
    use crate::schema::admin::dsl::*;
    diesel::delete(admin)
        .filter(account.eq(admin_account))
        .execute(connection)
}

#[cfg(test)]
pub mod tests {
    #[test]
    fn crud_admin() {
        use crate::*;
        // use diesel::prelude::*;
        use crate::models::admin::{Admin, NewAdmin};
        use crate::schema::admin::dsl::*;

        let connection = establish_connection();

        // Insert
        let new_admin = NewAdmin {
            account: String::from("Rust_Test"),
            password: String::from("password"),
            description: Some(String::from("Diesel")),
            avatar: Some(String::from("None")),
        };
        diesel::insert_into(admin)
            .values(&new_admin)
            .execute(&connection)
            .expect("Insert Failed");

        // Query
        admin
            .filter(account.eq("Rust_Test"))
            .first::<Admin>(&connection)
            .expect("Error loading Admin.");

        // Update
        let mut old_admin = admin
            .filter(account.eq("Rust_Test"))
            .first::<Admin>(&connection)
            .expect("Find Failed.");
        old_admin.password = String::from("this is second password.");

        diesel::update(admin)
            .filter(account.eq(old_admin.account.clone()))
            .set(&old_admin)
            .execute(&connection)
            .expect("Update Failed.");

        // Delete
        diesel::delete(admin)
            .filter(account.eq("Rust_Test"))
            .execute(&connection)
            .expect("Delete Failed.");
    }
}
