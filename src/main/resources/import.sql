delete from users_roles;
delete from roles;
delete from users;
delete from CARS;

 INSERT INTO users(ID, USERNAME, PASSWORD, enabled, firstname, lastname)
 VALUES (1,'admin', '$2a$04$AiszkJJxjxwP5X0VhWh99OZo55n/CqusJtudHwdUCRNJw0o5uUeXW', true, 'Admin', 'Adminovic');
 INSERT INTO users(ID, USERNAME, PASSWORD, enabled, firstname, lastname)
 VALUES (2,'user', '$2a$04$AiszkJJxjxwP5X0VhWh99OZo55n/CqusJtudHwdUCRNJw0o5uUeXW', true, 'User', 'Userovski');

 INSERT INTO ROLES (ID, ROLE)
 VALUES (1,'ROLE_ADMIN');
 INSERT INTO ROLES (ID, ROLE)
 VALUES (2,'ROLE_USER');

 INSERT INTO USERS_ROLES (USER_ID, ROLE_ID)
 VALUES (1,1);
 INSERT INTO USERS_ROLES (USER_ID, ROLE_ID)
 VALUES (2,2);

INSERT INTO CARS(ID, CAR_BRAND, CAR_MODEL, COLOR, NOTE, NUMBER_OF_SEATS, PRICE_PER_DAY)
  VALUES (1,'Ford','Fiesta','silver','Good car for small family', 5, 80),
         (2,'Mazda','RX5','black','Good car for car lovers', 2, 140),
         (3,'Fiat','125p','red','Good car for car passionates', 4, 50),
         (4,'Opel','Vectra','black','', 4, 110),
         (5,'Volkswagen','Passat','gold','', 4, 90),
         (6,'Volkswagen','Polo','silver','', 4, 55),
         (7,'Renault','Megan','silver','', 4, 110),
         (8,'Renault','Clio','silver','', 4, 90),
         (9,'Fiat','Punto','silver','', 4, 70),
         (10,'Fiat','Doblo','silver','', 2, 150),
         (11,' 90v c 8Skoda','Fabia','silver','', 4, 40);