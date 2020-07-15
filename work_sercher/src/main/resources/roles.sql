INSERT into roles(id, created, status, updated, name) VALUES
(1, now(), 'ACTIVE', now(), 'USER'),
(2, now(), 'ACTIVE', now(), 'ADMIN'),
(3, now(), 'ACTIVE', now(), 'EMPLOYER');

ALTER SEQUENCE roles_id_seq RESTART WITH 4;
