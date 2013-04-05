-- Table: customer
CREATE TABLE customer
(
  id serial NOT NULL,
  name character varying(100) NOT NULL,
  pw character varying(10) NOT NULL,
  balance numeric DEFAULT 100000,
  CONSTRAINT customer_pkey PRIMARY KEY (id)
)

-- Table: orders
CREATE TABLE orders
(
  order_id serial NOT NULL,
  product_id integer,
  customer_id integer,
  memo text,
  orderdate date DEFAULT now(),
  ordertime time without time zone DEFAULT now(),
  CONSTRAINT orders_pkey PRIMARY KEY (order_id),
  CONSTRAINT orders_customer_id_fkey FOREIGN KEY (customer_id)
      REFERENCES customer (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT orders_product_id_fkey FOREIGN KEY (product_id)
      REFERENCES products (product_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)


-- Table: products

-- DROP TABLE products;

CREATE TABLE products
(
  product_id serial NOT NULL,
  name text NOT NULL,
  price numeric,
  amount integer NOT NULL DEFAULT 0,
  describe text,
  CONSTRAINT products_pkey PRIMARY KEY (product_id),
  CONSTRAINT products_price_check CHECK (price > 0::numeric)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products
  OWNER TO test;
