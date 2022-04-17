-- USERS

INSERT INTO users (id, email, name, password, decline_reason)
VALUES (111, 'test@test.com', 'sayal adhikari', '$2a$10$zJIH0vqVbEiie5qXKLv2/OSSBhfOFcQeKG6jbShEFRKfom84vCuU2', 'no reason'); --123

--ROLES
INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'CLIENT');


INSERT INTO users_roles (user_id, roles_id)
VALUES (111, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (111, 2);


