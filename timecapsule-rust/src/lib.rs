#[macro_use]
extern crate diesel;
extern crate dotenv;
extern crate uuid;

pub mod handlers;
pub mod models;
pub mod schema;

use crate::handlers::{admin, capsule, user};
use crate::models::{admin::Admin, capsule::Capsule, user::User};
use actix_web::{error, middleware::Logger, web, App, FromRequest, HttpResponse, HttpServer};
use diesel::{
    prelude::*,
    r2d2::{ConnectionManager, Pool, PoolError, PooledConnection},
};
use dotenv::dotenv;
use env_logger::Env;
use std::env;

pub fn establish_connection() -> MysqlConnection {
    dotenv().ok();

    let database_url = env::var("DATABASE_URL").expect("DATABASE_URL must be set");
    MysqlConnection::establish(&database_url)
        .unwrap_or_else(|_| panic!("Error connecting to {}", database_url))
}

type MysqlPool = Pool<ConnectionManager<MysqlConnection>>;
type MysqlPooledConnection = PooledConnection<ConnectionManager<MysqlConnection>>;

// get a connection pool
pub fn get_connection_pool() -> Result<MysqlPool, PoolError> {
    dotenv().ok();
    let database_url = env::var("DATABASE_URL").expect("DATABASE_URL must be set");
    let manager = ConnectionManager::<MysqlConnection>::new(&database_url);
    Pool::builder().max_size(15).build(manager)
}

pub async fn server_setup() -> std::io::Result<()> {
    env_logger::from_env(Env::default().default_filter_or("info")).init();
    
    let pool = get_connection_pool().unwrap_or_else(|_| panic!("Get poor error"));

    HttpServer::new(move || {
        App::new()
            .data(pool.clone())
            .wrap(Logger::default())
            .service(
                web::scope("/user")
                    .app_data(web::Json::<User>::configure(|cfg| {
                        cfg.error_handler(|err, _req| {
                            error::InternalError::from_response(
                                err,
                                HttpResponse::Conflict().finish(),
                            )
                            .into()
                        })
                    }))
                    .route("/", web::get().to(user::get_all_user))
                    .route("/", web::post().to(user::insert_user))
                    .route("/{username}", web::get().to(user::get_user_by_username))
                    .route("/{username}", web::put().to(user::update_user))
                    .route("/{username}", web::delete().to(user::delete_user)),
            )
            .service(
                web::scope("/capsule")
                    .app_data(web::Json::<Capsule>::configure(|cfg| {
                        cfg.limit(4096).error_handler(|err, _req| {
                            // create custom error response
                            error::InternalError::from_response(
                                err,
                                HttpResponse::Conflict().finish(),
                            )
                            .into()
                        })
                    }))
                    .route("/", web::get().to(capsule::get_all_capsule))
                    .route("/", web::post().to(capsule::insert_capsule))
                    .route("/{uuid}", web::get().to(capsule::get_capsule_by_uuid))
                    .route("/{uuid}", web::put().to(capsule::update_capsule))
                    .route("/{uuid}", web::delete().to(capsule::delete_capsule)),
            )
            .service(
                web::scope("/admin")
                    .app_data(web::Json::<Admin>::configure(|cfg| {
                        cfg.limit(4096).error_handler(|err, _req| {
                            // create custom error response
                            error::InternalError::from_response(
                                err,
                                HttpResponse::Conflict().finish(),
                            )
                            .into()
                        })
                    }))
                    .route("/", web::get().to(admin::get_all_admin))
                    .route("/", web::post().to(admin::insert_admin))
                    .route("/{account}", web::get().to(admin::get_admin_by_account))
                    .route("/{account}", web::put().to(admin::update_admin))
                    .route("/{account}", web::delete().to(admin::delete_admin)),
            )
    })
    .bind("127.0.0.1:8088")?
    .run()
    .await
}
