use actix_web::{
    web::{Data, Json, Path},
    HttpResponse, Result,
};
// use actix_web::web::{Data, Path,Json};
use crate::models::admin;
use crate::MysqlPool;
// use diesel::result::Error;

pub async fn get_all_admin(pool: Data<MysqlPool>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let admins = admin::get_all(&connection).unwrap();
    Ok(HttpResponse::Ok().json(admins))
}

pub async fn get_admin_by_account(
    pool: Data<MysqlPool>,
    account: Path<String>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let admin = admin::get_one(&connection, account.as_str()).unwrap();
    Ok(HttpResponse::Ok().json(admin))
}

pub async fn update_admin(
    pool: Data<MysqlPool>,
    account: Path<String>,
    new_admin: Json<admin::Admin>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = admin::update(&connection, account.as_str(), new_admin.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn insert_admin(
    pool: Data<MysqlPool>,
    new_admin: Json<admin::Admin>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = admin::insert(&connection, new_admin.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn delete_admin(pool: Data<MysqlPool>, account: Path<String>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let result = admin::delete(&connection, account.as_str());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}
