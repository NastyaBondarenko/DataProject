CREATE TABLE data (
    "id" INTEGER PRIMARY KEY,
    "data" VARCHAR NOT NULL,
    "updated_time" TIMESTAMP(0) WITHOUT TIME ZONE
);

CREATE SEQUENCE data_id_sequence OWNED BY data.id;
ALTER SEQUENCE data_id_sequence INCREMENT BY 50;

