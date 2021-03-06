CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE IF NOT EXISTS  users(
                      id uuid DEFAULT uuid_generate_v4(),
                      first_name varchar(255) not null,
                      last_name varchar(255) not null,
                      username varchar(255) not null unique,
                      email varchar(255) not null unique,
                      password varchar(255) not null unique,
                      gender varchar(16) not null,
                      urole varchar(16) not null,
                      phone varchar(16),
                      locked boolean default false,
                      enabled boolean default false,
                      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                      updated_at TIMESTAMP,
                      deleted_at TIMESTAMP,
                      primary key(id)
);

CREATE TABLE IF NOT EXISTS  confirmation_token(
    id serial primary key not null,
    token varchar(255) not null,
    expires_at TIMESTAMP,
    confirmed_at TIMESTAMP,
    user_id uuid,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    CONSTRAINT fk_user_id
    FOREIGN KEY(user_id)
    REFERENCES users(id) on delete cascade
);
