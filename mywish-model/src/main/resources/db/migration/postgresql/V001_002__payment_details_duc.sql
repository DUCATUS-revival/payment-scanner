CREATE TABLE payment_details_duc (
  id SERIAL PRIMARY KEY ,
  cart_id BIGINT,
  rx_address VARCHAR(66),
  amount NUMERIC (78, 0),
  rx_amount NUMERIC (78, 0),
  shop VARCHAR(66),
  status VARCHAR(20)
);