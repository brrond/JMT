DROP TABLE session;
DROP TABLE account;

CREATE TABLE account (
	user_id SERIAL PRIMARY KEY,
	email VARCHAR(255) UNIQUE NOT NULL,
	username VARCHAR(63) UNIQUE NOT NULL,
	password VARCHAR(63) NOT NULL,
	date_of_registration DATE NOT NULL,
	photo VARCHAR(255)
);

CREATE TABLE session (
	session_id SERIAL PRIMARY KEY,
	user_id INT,
	date DATE NOT NULL,
	time TIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES account (user_id)
);

ALTER TABLE session ADD COLUMN speed FLOAT;