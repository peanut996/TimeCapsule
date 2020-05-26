use timecapsule_rust::server_setup;

#[actix_rt::main]
async fn main() -> std::io::Result<()> {
    server_setup().await
}
