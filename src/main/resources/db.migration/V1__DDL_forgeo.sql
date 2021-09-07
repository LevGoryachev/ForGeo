CREATE TABLE constructions(
id BIGSERIAL PRIMARY KEY,
code_number VARCHAR(80),
name VARCHAR(80),
description TEXT
);


CREATE TABLE locations(
id BIGSERIAL PRIMARY KEY,
latitude FLOAT,
longitude FLOAT,
postal_address VARCHAR(80),
constr_address VARCHAR(80),
linear BOOLEAN NOT NULL DEFAULT false
);