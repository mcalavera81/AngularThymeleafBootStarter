INSERT INTO user(id, username, password, active) VALUES (1,'user', '$2a$10$HRVHua5FGuOqakTODK2Nq.YR87xZx0kBNR7OEpZsaLXz84pw76TDe', TRUE);
INSERT INTO user(id, username, password, active) VALUES (2,'admin', '$2a$10$ev41hs73jm6azPkMd1qfWOMMrg0SnQW/MuJyM6lYdr9WS7CV5QhQG', TRUE);


INSERT INTO role(id, role) VALUES(1, 'USER');
INSERT INTO role(id, role) VALUES(2, 'ADMIN');

INSERT INTO user_role(user_id, role_id) VALUES(1, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 1);
INSERT INTO user_role(user_id, role_id) VALUES(2, 2);


INSERT INTO container(id, name) VALUES (1, 'paco');
INSERT INTO container(id, name) VALUES (2, 'carmen');
INSERT INTO container(id, name) VALUES (3, 'manuel');
INSERT INTO container(id, name) VALUES (4, 'ana');

INSERT INTO feature(name, value, container_id) VALUES ('color de ojos','azules', 1);
INSERT INTO feature(name, value, container_id) VALUES ('color de casa','roja', 1);
INSERT INTO feature(name, value, container_id) VALUES ('color de ojos','verdes', 2);
INSERT INTO feature(name, value, container_id) VALUES ('color de reloj','negro', 2);
INSERT INTO feature(name, value, container_id) VALUES ('color de coche','negro', 3);
INSERT INTO feature(name, value, container_id) VALUES ('color de pelo','rojo', 3);
INSERT INTO feature(name, value, container_id) VALUES ('color de casa','azul', 3);
INSERT INTO feature(name, value, container_id) VALUES ('color de coche','amarillo', 4);
INSERT INTO feature(name, value, container_id) VALUES ('color de casa','verde', 4);
INSERT INTO feature(name, value, container_id) VALUES ('color de reloj','azul', 4);

