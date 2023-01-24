create database personas;
use personas;

CREATE TABLE `lista_personas` (
  `id` int NOT NULL AUTO_INCREMENT primary key,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `edad` tinyint NOT NULL,
  `identificacion` bigint NOT NULL,
  `correo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefono` bigint NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

update lista_personas set nombre = "Santiago Torres", edad = 18,
identificacion = 1000603175, correo = "st147086@gmail.com",
telefono = 3007526311 where id = 1;

select * from lista_personas;

-- insert into lista_personas(nombre, edad, identificacion, correo, telefono) values
-- ("Nuevo", 19, 1000603175, "st147086@gmail.com", 300);

delete from lista_personas where id = 3;
drop table lista_personas;
