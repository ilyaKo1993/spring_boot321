INSERT INTO roles (id, name)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'USER');

INSERT INTO `test`.`users`
(`id`,
 `age`,
 `last_name`,
 `login`,
 `name`,
 `password`)
VALUES (1, 18, 'admin', 'admin', 'admin', '$2a$12$a7gePTs3PFiG/b3x8ht.zuqTBUX2hQQ/dEn0XdiFO0zWG5R6GRY4u');
INSERT INTO `test`.`users`
(`id`,
 `age`,
 `last_name`,
 `login`,
 `name`,
 `password`)
VALUES (2, 20, 'user', 'user', 'user', '$2a$12$lzLi9XxOxS5Rijs2SriNWuHWt63r2DNziNkPnDqrMba./PHu8hVK2');
INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id)
VALUES (2, 2);
