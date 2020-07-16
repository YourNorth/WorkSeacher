INSERT into roles(id, created, status, updated, name) VALUES
(1, now(), 'ACTIVE', now(), 'ROLE_USER'),
(2, now(), 'ACTIVE', now(), 'ROLE_ADMIN'),
(3, now(), 'ACTIVE', now(), 'ROLE_EMPLOYER');

ALTER SEQUENCE roles_id_seq RESTART WITH 4;
