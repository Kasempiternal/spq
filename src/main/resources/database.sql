DROP SCHEMA IF EXISTS ParkingDB;
DROP USER IF EXISTS 'spq'@'localhost';

CREATE SCHEMA ParkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';

GRANT ALL ON productosDB.* TO 'spq'@'localhost';