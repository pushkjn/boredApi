CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS bored (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    external_id uuid DEFAULT uuid_generate_v4() UNIQUE,
    activity VARCHAR(30) NOT NULL,
    challenge INTEGER NOT NULL
);