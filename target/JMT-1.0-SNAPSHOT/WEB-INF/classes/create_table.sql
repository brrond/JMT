DROP TABLE session;
DROP TABLE stat;
DROP TABLE account;

CREATE TABLE account (
	user_id SERIAL PRIMARY KEY,
	email VARCHAR(255) UNIQUE NOT NULL,
	username VARCHAR(63) UNIQUE NOT NULL,
	password VARCHAR(63) NOT NULL,
	date_of_registration DATE NOT NULL,
	photo VARCHAR(255)
);

CREATE TABLE stat (
	stat_id INT NOT NULL, 
	right_plus INT DEFAULT(0),
	right_minus INT DEFAULT(0),
	right_mul INT DEFAULT(0),
	right_div INT DEFAULT(0),
	wrong_plus INT DEFAULT(0),
	wrong_minus INT DEFAULT(0),
	wrong_mul INT DEFAULT(0),
	wrong_div INT DEFAULT(0),
	FOREIGN KEY(stat_id) REFERENCES account (user_id)
);

CREATE TABLE session (
	session_id SERIAL PRIMARY KEY,
	user_id INT,
	date_time TIMESTAMP NOT NULL,
	right_plus INT DEFAULT(0),
	right_minus INT DEFAULT(0),
	right_mul INT DEFAULT(0),
	right_div INT DEFAULT(0),
	wrong_plus INT DEFAULT(0),
	wrong_minus INT DEFAULT(0),
	wrong_mul INT DEFAULT(0),
	wrong_div INT DEFAULT(0),
	FOREIGN KEY(user_id) REFERENCES account (user_id)
);
