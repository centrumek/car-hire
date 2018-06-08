delete from users_roles;
delete from roles;
delete from users;
delete from HIRES;
delete from CARS;
delete from CUSTOMERS;

 INSERT INTO users(ID, USERNAME, PASSWORD, enabled, firstname, lastname)
 VALUES (1,'admin', '$2a$04$AiszkJJxjxwP5X0VhWh99OZo55n/CqusJtudHwdUCRNJw0o5uUeXW', true, 'Tomasz', 'Madej');
 INSERT INTO users(ID, USERNAME, PASSWORD, enabled, firstname, lastname)
 VALUES (2,'user', '$2a$04$AiszkJJxjxwP5X0VhWh99OZo55n/CqusJtudHwdUCRNJw0o5uUeXW', true, 'Michal', 'Nowak');

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
         (4,'Opel','Vectra','black','Super auto', 4, 110),
         (5,'Volkswagen','Passat','gold','Super auto', 4, 90),
         (6,'Volkswagen','Polo','silver','Super auto', 4, 55),
         (7,'Renault','Megan','silver','Super auto', 4, 110),
         (8,'Renault','Clio','silver','Super auto', 4, 90),
         (9,'Fiat','Punto','silver','Super auto', 4, 70),
         (10,'Fiat','Doblo','silver','Super auto', 2, 150),
         (11,'Skoda','Fabia','silver','Super auto', 4, 40);

INSERT INTO CUSTOMERS(ID,FIRSTNAME,LASTNAME,EMAIL,PHONE)
	VALUES	(1,'Mateusz','Kopec','ematkop@host.pl','123456789'),
                (2,'Artur','Majdak','eartmaj@host.pl','123456789'),
                (3,'Bartlomiej','Sanak','esanaba@host.pl','123456789'),
                (4,'Dominik','Suder','edomsud@host.pl','123456789'),
                (5,'Marek','Gancarz','emaganc@host.pl','123456789'),
                (6,'Magdalena','Bandula','emagban@host.pl','123456789'),
                (7,'Pawel','Potaczala','pawel9111@host.pl','123456789'),
                (8,'Roger','Barlik','roger@host.com','123456789'),
                (9,'Marcin','Wojtiuk','emawojt@host.pl','123456789'),
                (10,'Marcin','Lewandowski','ezlewma@host.pl','123456789'),
                (11,'Robert','Podsiadlo','epodrob@host.pl','123456789'),
                (12,'Jakub','Wozniak','ajakwoz@host.pl','123456789'),
                (13,'Piotr','Duda','epiduda@host.pl','123456789'),
                (14,'King','Loza','ekinloz@host.pl','123456789'),
                (15,'Krzysztof','Sajewicz','ekrzsaj@host.pl','123456789'),
                (16,'Witold','Wisniewski','enierob@host.pl','123456789'),
                (17,'Pawel','Janik','epawjan@host.pl','123456789'),
                (18,'Lukasz','Kutrzeba','test@host.pl','123456789'),
                (19,'Lukasz','Drapala','elukadr@host.pl','123456789'),
                (20,'Piotr','Deren','user@host.pl','123456789');

INSERT INTO HIRES(ID,HIRE_DATE,RETURN_DATE,CUSTOMER_ID,CAR_ID,NOTE)
	VALUES	(1,'2020-12-12','2020-12-30',1,6,'Super rezerweacja'),
                (2,'2020-12-12','2020-12-30',2,5,'Super rezerweacja'),
                (3,'2020-12-12','2020-12-30',3,4,'Super rezerweacja'),
                (4,'2020-12-12','2020-12-30',4,3,'Super rezerweacja'),
                (5,'2020-12-12','2020-12-30',5,2,'Super rezerweacja'),
                (6,'2020-12-12','2020-12-30',6,1,'Super rezerweacja');
