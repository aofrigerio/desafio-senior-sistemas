CREATE SCHEMA IF NOT EXISTS sales;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS sales.product (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   name VARCHAR (50) NOT NULL,
   type VARCHAR (10) NOT NULL,
   price NUMERIC
);

CREATE TABLE IF NOT EXISTS sales.order (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   customer VARCHAR (50) NOT NULL,
   status VARCHAR (10) NOT NULL,
   off NUMERIC,
   total NUMERIC
);

CREATE TABLE IF NOT EXISTS sales.item_order (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   order_id UUID NOT NULL,
   product_id UUID NOT NULL,
   quantity NUMERIC
);