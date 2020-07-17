INSERT into roles(id, created, status, updated, name) VALUES
(1, now(), 'ACTIVE', now(), 'ROLE_USER'),
(2, now(), 'ACTIVE', now(), 'ROLE_ADMIN'),
(3, now(), 'ACTIVE', now(), 'ROLE_EMPLOYER');

ALTER SEQUENCE roles_id_seq RESTART WITH 4;
ALTER SEQUENCE users_id_seq RESTART WITH 1004;

-- У user password = 12341234
-- Эти польхователи для тестирования ролей

INSERT into users(id, created, status, updated, email, password, token) values
(1001, now(), 'ACTIVE', now(), 'user@gmail.com', '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq',
 'zxcvbbnmffdfdfdfdfsdfdsf');
INSERT into user_roles(user_id, role_id) VALUES (1001, 1);

INSERT into users(id, created, status, updated, email, password, token) values
(1002, now(), 'ACTIVE', now(), 'admin@gmail.com', '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq',
 'zxcvbbnmffdfdfdfdfsddddd');
INSERT into user_roles(user_id, role_id) VALUES (1002, 2);

INSERT into users(id, created, status, updated, email, password, token) values
(1003, now(), 'ACTIVE', now(), 'employer@gmail.com', '$2a$10$8eowpHtDac.AwKlEZYKMKuxOFC2FzQciEY9AvWWYtd3QpzA.M5HNq',
 'zxcvbbnmffdfdfdfdfsfffff');
INSERT into user_roles(user_id, role_id) VALUES (1003, 3);
