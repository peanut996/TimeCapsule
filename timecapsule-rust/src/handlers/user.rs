use actix_web::{
    web::{Data, Json, Path},
    HttpResponse, Result,
};
// use actix_web::web::{Data, Path,Json};
use crate::models::user;
use crate::MysqlPool;
// use diesel::result::Error;

pub async fn get_all_user(pool: Data<MysqlPool>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let users = user::get_all(&connection).unwrap();
    Ok(HttpResponse::Ok().json(users))
}

pub async fn get_user_by_username(
    pool: Data<MysqlPool>,
    username: Path<String>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let user = user::get_one(&connection, username.as_str()).unwrap();
    Ok(HttpResponse::Ok().json(user))
}

pub async fn update_user(
    pool: Data<MysqlPool>,
    account: Path<String>,
    new_user: Json<user::User>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = user::update(&connection, account.as_str(), new_user.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn insert_user(
    pool: Data<MysqlPool>,
    new_user: Json<user::User>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = user::insert(&connection, new_user.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn delete_user(pool: Data<MysqlPool>, account: Path<String>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let result = user::delete(&connection, account.as_str());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}
