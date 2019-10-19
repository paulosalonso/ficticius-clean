insert into Role(roleAuthority) values 
    ('ADMIN'),
    ('USER');

insert into Privilege(description) values
    ('Administrator'),
    ('User');

insert into PrivilegeRole values
    (1, 1),
    (2, 2);

insert into UserEntity (username, password, active) values
    ('admin', '$2a$10$HSRg3ynBHiHJAdejqmbFw.pmBGeOVXpTjyP1VzUnrlzmfLBqKg6DG', 1), -- BCryptPasswordEncoder encrypted 'admin' password
    ('user', '$2a$10$A85m39IXdKCedUpqk/6iceV2DQvlS8.07bcquGMv9TI7E04XuMi0i', 1); -- BCryptPasswordEncoder encrypted 'user' password

insert into UserPrivilege values
    (1, 1),
    (2, 2);