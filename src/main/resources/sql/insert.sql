INSERT INTO roles(id, name) VALUES (1000,'ADMIN');
INSERT INTO roles(id, name) VALUES (1001,'USER');

INSERT INTO groups(id, name) VALUES (1000,'ADMIN');
INSERT INTO groups(id, name) VALUES (1001,'USER');

INSERT INTO groups_roles(group_id, roles_id) VALUES (1000, 1000);
INSERT INTO groups_roles(group_id, roles_id) VALUES (1000, 1001);
INSERT INTO groups_roles(group_id, roles_id) VALUES (1001, 1001);

INSERT INTO account(id, enabled, last_log, login, user_name, password, password_restarted, id_group)
    VALUES (1000, true, current_date, 'admin', 'admin',md5('admin'), false, 1000);