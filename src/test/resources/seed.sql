INSERT INTO user(id, username, password, active) VALUES (1,'publisher1', '$2a$10$RC1.YFSL8o2vCIg6kB3fjuBB639BdjY6AD8rIw9oyWJLws/1Q6Lku', TRUE);
INSERT INTO role(id, role) VALUES(1, 'USER');
INSERT INTO user_role(user_id, role_id) VALUES(1, 1);


INSERT INTO container(id, name) VALUES (1, 'paco');
INSERT INTO container(id, name) VALUES (2, 'carmen');
INSERT INTO container(id, name) VALUES (3, 'manuel');

INSERT INTO feature(id, name, value, container_id) VALUES (1,'color de ojos','azul claro', 1);
INSERT INTO feature(id, name, value, container_id) VALUES (2, 'color de casa','roja', 1);
INSERT INTO feature(id, name, value, container_id) VALUES (3, 'color de reloj','azul oscuro', 1);
INSERT INTO feature(id, name, value, container_id) VALUES (4,'color de casa','azul oscuro', 3);
INSERT INTO feature(id, name, value, container_id) VALUES (5,'color de reloj','negro claro', 3);

