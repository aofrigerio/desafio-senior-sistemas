CREATE SCHEMA IF NOT EXISTS sales;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS sales.products (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   name VARCHAR (50) NOT NULL,
   type VARCHAR (10) NOT NULL,
   price NUMERIC
);

CREATE TABLE IF NOT EXISTS sales.orders (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   customer VARCHAR (50) NOT NULL,
   status VARCHAR (10) NOT NULL,
   off NUMERIC,
   total NUMERIC
);

CREATE TABLE IF NOT EXISTS sales.items_orders (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
   created TIMESTAMP NOT NULL,
   updated TIMESTAMP NOT NULL,   
   order_id UUID NOT NULL,
   product_id UUID NOT NULL,
   quantity NUMERIC,
   total NUMERIC,
   CONSTRAINT fk_order
      FOREIGN KEY(order_id) 
	  REFERENCES sales.orders(id),
	CONSTRAINT fk_product
      FOREIGN KEY(product_id) 
	  REFERENCES sales.products(id)	  
	  
);