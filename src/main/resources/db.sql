delete from users_roles;
delete from roles;
delete from users;

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