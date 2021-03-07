-- ########################################################################
-- # Executar este script com o usuário visto_user
-- ########################################################################

USE visto_db;

-- ########################################################################
-- # Exclui as tabelas a serem criadas
-- ########################################################################

DROP TABLE IF EXISTS remaining_days;
DROP TABLE IF EXISTS allocations;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS vehicles;

-- ########################################################################
-- # Efetua a criação da tabela de clientes
-- ########################################################################

CREATE TABLE IF NOT EXISTS customers (
	id			INT UNSIGNED		NOT NULL		PRIMARY KEY		AUTO_INCREMENT,
	code		INT UNSIGNED		NOT NULL,
	name		VARCHAR(100)		NOT NULL,
	status		CHAR(1)				NOT NULL		DEFAULT			'A',
	created_at	TIMESTAMP			NOT NULL		DEFAULT			CURRENT_TIMESTAMP,
	updated_at	TIMESTAMP			NULL			ON UPDATE		CURRENT_TIMESTAMP
);

CREATE INDEX customers_code_index ON customers(code);

CREATE INDEX customers_status_index ON customers(status);

-- ########################################################################
-- # Efetua a criação da tabela de veículos
-- ########################################################################

CREATE TABLE IF NOT EXISTS vehicles (
	id			INT UNSIGNED		NOT NULL		PRIMARY KEY		AUTO_INCREMENT,
	plate		VARCHAR(10)			NOT NULL,
	brand		VARCHAR(50)			NULL,
	model		VARCHAR(50)			NULL,
	status		CHAR(1)				NOT NULL		DEFAULT			'A',
	created_at	TIMESTAMP			NOT NULL		DEFAULT			CURRENT_TIMESTAMP,
	updated_at	TIMESTAMP			NULL			ON UPDATE		CURRENT_TIMESTAMP
);

CREATE INDEX vehicles_plate_index ON vehicles(plate);

CREATE INDEX vehicles_status_index ON vehicles(status);

-- ########################################################################
-- # Efetua a criação da tabela de alocações
-- ########################################################################

CREATE TABLE IF NOT EXISTS allocations (
	id				INT UNSIGNED		NOT NULL		PRIMARY KEY		AUTO_INCREMENT,
	id_customer		INT UNSIGNED		NOT NULL,
	id_vehicle		INT UNSIGNED		NOT NULL,
	start_date		TIMESTAMP			NOT NULL,
	end_date		TIMESTAMP			NOT NULL,
	status			CHAR(1)				NOT NULL		DEFAULT			'A',
	created_at		TIMESTAMP			NOT NULL		DEFAULT			CURRENT_TIMESTAMP,
	updated_at		TIMESTAMP			NULL			ON UPDATE		CURRENT_TIMESTAMP,
	FOREIGN KEY 	(id_customer) 		REFERENCES 		customers (id),
	FOREIGN KEY 	(id_vehicle) 		REFERENCES 		vehicles (id)
);

CREATE INDEX allocations_id_customer_id_vehicle_index ON allocations(id_customer, id_vehicle);

CREATE INDEX allocations_status_index ON allocations(status);

-- ########################################################################
-- # Efetua a criação da tabela de dias restantes
-- ########################################################################

CREATE TABLE IF NOT EXISTS remaining_days (
	id				INT UNSIGNED		NOT NULL		PRIMARY KEY		AUTO_INCREMENT,
	id_allocation	INT UNSIGNED		NOT NULL,
	id_customer		INT UNSIGNED		NOT NULL,
	start_date		TIMESTAMP			NOT NULL,
	end_date		TIMESTAMP			NOT NULL,
	remaining_days	INT UNSIGNED		NOT NULL,
	status			CHAR(1)				NOT NULL		DEFAULT			'A',
	created_at		TIMESTAMP			NOT NULL		DEFAULT			CURRENT_TIMESTAMP,
	updated_at		TIMESTAMP			NULL			ON UPDATE		CURRENT_TIMESTAMP,
	FOREIGN KEY 	(id_customer) 		REFERENCES 		customers (id)
);

CREATE INDEX remaining_days_id_allocation_index ON remaining_days(id_allocation);

CREATE INDEX remaining_days_id_customer_index ON remaining_days(id_customer);
