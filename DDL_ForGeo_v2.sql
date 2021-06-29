CREATE TABLE site_location(
id BIGSERIAL PRIMARY KEY,
latitude FLOAT,
longitude FLOAT
);

CREATE TABLE address(
id BIGSERIAL PRIMARY KEY,
type VARCHAR(24),
line_1 VARCHAR(80),
line_2 VARCHAR(80),
line_3 VARCHAR(80),
town_city VARCHAR(80),
country VARCHAR(80),
zip_postal VARCHAR(6),
site_location_id BIGINT REFERENCES "site_location"(id) ON DELETE SET NULL
);