table! {
    admin (id) {
        id -> Bigint,
        account -> Varchar,
        password -> Varchar,
        description -> Nullable<Varchar>,
        avatar -> Nullable<Varchar>,
    }
}

table! {
    capsule (id) {
        id -> Bigint,
        content -> Varchar,
        createtime -> Timestamp,
        opentime -> Timestamp,
        username -> Varchar,
        uuid -> Varchar,
        warncontent -> Nullable<Varchar>,
        email -> Varchar,
    }
}

table! {
    user (id) {
        id -> Bigint,
        username -> Varchar,
        password -> Varchar,
        nickname -> Nullable<Varchar>,
        email -> Varchar,
        createtime -> Nullable<Timestamp>,
        updatetime -> Nullable<Timestamp>,
        avatar -> Nullable<Varchar>,
    }
}

allow_tables_to_appear_in_same_query!(admin, capsule, user,);
