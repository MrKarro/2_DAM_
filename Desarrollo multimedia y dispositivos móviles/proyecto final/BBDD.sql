CREATE TABLE Usuario (
  identificador INT(3) NOT NULL AUTO_INCREMENT,
  dni VARCHAR(9) NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  login VARCHAR(20) NOT NULL,
  password VARCHAR(32) NOT NULL,
  trabajador TINYINT(1) DEFAULT 0,
  bloqueado TINYINT(1) DEFAULT 0,
  PRIMARY KEY (identificador)
);

CREATE TABLE Director (
  identificador INT(3) NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE,
  PRIMARY KEY (identificador)
);

CREATE TABLE Pelicula (
  identificador INT(3) NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(100) NOT NULL,
  duracion TIME,
  anho INT(4),
  portada VARCHAR(200),
  director INT(3),
  disponible TINYINT(1) DEFAULT 1,
  PRIMARY KEY (identificador),
  FOREIGN KEY (director) REFERENCES Director(identificador)
);





CREATE TABLE Alquiler (
  identificador INT(3) NOT NULL AUTO_INCREMENT,
  id_pelicula INT(3) NOT NULL,
  id_usuario INT(3) NOT NULL,
  fecha_alquiler DATE NOT NULL,
  fecha_devolucion DATE,
  extendido TINYINT(1) DEFAULT 0,
  PRIMARY KEY (identificador),
  FOREIGN KEY (id_pelicula) REFERENCES Pelicula(identificador),
  FOREIGN KEY (id_usuario) REFERENCES Usuario(identificador)
);

INSERT INTO Usuario (dni, nombre, login, password, trabajador, bloqueado) VALUES
('12345678A', 'Cliente1', 'Cli1', '123456', 0, 0),
('87654321B', 'Cliente2', 'Cli2', '123456', 0, 0),
('98765432C', 'Trabajador1', 'Tra1', '123456', 1, 0);

INSERT INTO Director (nombre, fecha_nacimiento) VALUES
('Peter Jackson', '1961-10-31'),
('Francis Ford Coppola', '1939-04-07'),
('Christopher Nolan', '1970-07-30');


INSERT INTO Pelicula (titulo, duracion, anho, portada, director, disponible) VALUES
('El Senhor de los Anillos: La Comunidad del Anillo', '03:12:00', 2001, 'portada_lotr.jpg', 1, 1),
('El Padrino', '02:55:00', 1972, 'portada_padrino.jpg', 2, 1),
('Interstellar', '02:58:00', 2014, 'portada_interstellar.jpg', 3, 1);




INSERT INTO Alquiler (id_pelicula, id_usuario, fecha_alquiler, fecha_devolucion) VALUES
(1, 1, '2024-02-04', '2024-02-11'),
(2, 2, '2024-02-05', '2024-02-12'),
(3, 3, '2024-02-06', '2024-02-13');




