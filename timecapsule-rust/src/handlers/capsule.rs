use actix_web::{
    web::{Data, Json, Path},
    HttpResponse, Result,
};
// use actix_web::web::{Data, Path,Json};
use crate::models::capsule;
use crate::MysqlPool;
// use diesel::result::Error;

pub async fn get_all_capsule(pool: Data<MysqlPool>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let capsules = capsule::get_all(&connection).unwrap();
    Ok(HttpResponse::Ok().json(capsules))
}

pub async fn get_capsule_by_uuid(
    pool: Data<MysqlPool>,
    uuid: Path<String>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let capsule = capsule::get_one(&connection, uuid.as_str()).unwrap();
    Ok(HttpResponse::Ok().json(capsule))
}

pub async fn update_capsule(
    pool: Data<MysqlPool>,
    uuid: Path<String>,
    new_capsule: Json<capsule::Capsule>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = capsule::update(&connection, uuid.as_str(), new_capsule.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn insert_capsule(
    pool: Data<MysqlPool>,
    new_capsule: Json<capsule::Capsule>,
) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();
    let result = capsule::insert(&connection, new_capsule.into_inner());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}

pub async fn delete_capsule(pool: Data<MysqlPool>, uuid: Path<String>) -> Result<HttpResponse> {
    let connection = pool
        .get()
        .map_err(|e| HttpResponse::InternalServerError().json(e.to_string()))
        .unwrap();

    let result = capsule::delete(&connection, uuid.as_str());
    match result {
        Ok(_) => Ok(HttpResponse::Ok().body("success")),
        _ => Ok(HttpResponse::InternalServerError().body("fail")),
    }
}
