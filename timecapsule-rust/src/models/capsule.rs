extern crate serde;
use crate::{schema::*, MysqlPooledConnection};
use chrono::*;
use diesel::{prelude::*, result::Error};
use serde::{Deserialize, Serialize};

#[derive(Queryable, Debug, AsChangeset, Insertable, Deserialize, Serialize)]
#[table_name = "capsule"]
pub struct Capsule {
    pub id: i64,
    pub content: String,
    pub createtime: NaiveDateTime,
    pub opentime: NaiveDateTime,
    pub username: String,
    pub uuid: String,
    pub warncontent: Option<String>,
    pub email: String,
}

#[derive(Insertable)]
#[table_name = "capsule"]
pub struct NewCapsule {
    pub content: String,
    pub createtime: NaiveDateTime,
    pub opentime: NaiveDateTime,
    pub username: String,
    pub uuid: String,
    pub warncontent: Option<String>,
    pub email: String,
}

pub fn get_all(connection: &MysqlPooledConnection) -> Result<Vec<Capsule>, Error> {
    use crate::schema::capsule::dsl::*;

    let capsules = capsule.load::<Capsule>(connection)?;
    Ok(capsules.into())
}

pub fn get_one(connection: &MysqlPooledConnection, capsule_uuid: &str) -> Result<Capsule, Error> {
    use crate::schema::capsule::dsl::*;

    let the_capsule = capsule
        .filter(uuid.eq(capsule_uuid))
        .first::<Capsule>(connection)?;
    Ok(the_capsule.into())
}

pub fn insert(connection: &MysqlPooledConnection, new_capsule: Capsule) -> Result<usize, Error> {
    use crate::schema::capsule::dsl::*;

    diesel::insert_into(capsule)
        .values(&new_capsule)
        .execute(connection)
}

pub fn update(
    connection: &MysqlPooledConnection,
    capsule_uuid: &str,
    new_capsule: Capsule,
) -> Result<usize, Error> {
    use crate::schema::capsule::dsl::*;

    diesel::update(capsule)
        .filter(uuid.eq(capsule_uuid))
        .set(&new_capsule)
        .execute(connection)
}

pub fn delete(connection: &MysqlPooledConnection, capsule_uuid: &str) -> Result<usize, Error> {
    use crate::schema::capsule::dsl::*;
    diesel::delete(capsule)
        .filter(uuid.eq(capsule_uuid))
        .execute(connection)
}

#[cfg(test)]
pub mod tests {
    #[test]
    fn crud_capsule() {
        use crate::*;
        // use diesel::prelude::*;
        use crate::models::capsule::{Capsule, NewCapsule};
        use crate::schema::capsule::dsl::*;
        use crate::uuid::Uuid;
        use chrono::Utc;

        let connection = establish_connection();

        // Insert
        let new_capsule = NewCapsule {
            content: String::from("This is a REST implemented by Diesel and Actix-Web"),
            createtime: Utc::now().naive_utc(),
            opentime: Utc::now().naive_utc(),
            username: String::from("Rust_Test"),
            uuid: Uuid::new_v4().to_string(),
            warncontent: Some(String::from("Warning!")),
            email: String::from("example@gmail.com"),
        };
        diesel::insert_into(capsule)
            .values(&new_capsule)
            .execute(&connection)
            .expect("Insert Failed");

        // Query
        capsule
            .filter(username.eq("Rust_Test"))
            .first::<Capsule>(&connection)
            .expect("Error loading Capsule.");

        // Update
        let mut old_capsule = capsule
            .filter(username.eq("Rust_Test"))
            .first::<Capsule>(&connection)
            .expect("Find Failed.");
        old_capsule.content = String::from("Hello Rust!");

        diesel::update(capsule)
            .filter(username.eq(old_capsule.username.clone()))
            .set(&old_capsule)
            .execute(&connection)
            .expect("Update Failed.");

        // Delete
        diesel::delete(capsule)
            .filter(username.eq("Rust_Test"))
            .execute(&connection)
            .expect("Delete Failed.");
    }
}
