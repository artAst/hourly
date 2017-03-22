INSERT INTO hourly_province (province_id, name) VALUES (1, "Metro Manila");
INSERT INTO hourly_city (city_id, name) VALUES (1, "Quezon City");

INSERT INTO hourly_address (address_id, address, date_created, last_edited, city_id, province_id) VALUES (1, "Brgy Sto Cristo Q.C.", NOW(), NOW(), 1, 1);

INSERT INTO hourly_company (company_id, company_name, date_created, last_edited) VALUES (1, "Company 1", NOW(), NOW());

INSERT INTO hourly_dept (department_id, department_name, date_created, last_edited, address, company_id) VALUES (1, "Department 1", NOW(), NOW(), 1, 1);

INSERT INTO hourly_rate (rate_id, amount, date_created, last_edited, `type`) VALUES (1, 9000.00, NOW(), NOW(), 'test type');

INSERT INTO hourly_employee (employee_id, first_name, last_name, date_created, last_edited, address, department_id, rate, employee_type) VALUES (1, "Nanix", "Maloi", NOW(), NOW(), 1, 1, 1, 'REGULAR');


-- password is 'password'
INSERT INTO hourly_account (reference_id, username, password, enabled, credentials_expired, expired, locked, version, created_by, created_at, updated_by, updated_at) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), NULL, NULL);
-- password is 'operations'
INSERT INTO hourly_account (reference_id, username, password, enabled, credentials_expired, expired, locked, version, created_by, created_at, updated_by, updated_at) VALUES ('7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', true, false, false, false, 0, 'user', NOW(), NULL, NULL);

INSERT INTO hourly_role (role_id, code, label, ordinal, effective_at, expires_at, created_at) VALUES (1, 'ROLE_USER', 'User', 0, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO hourly_role (role_id, code, label, ordinal, effective_at, expires_at, created_at) VALUES (2, 'ROLE_ADMIN', 'Admin', 1, '2015-01-01 00:00:00', NULL, NOW());
INSERT INTO houtly_role (role_id, code, label, ordinal, effective_at, expires_at, created_at) VALUES (3, 'ROLE_SYSADMIN', 'System Admin', 2, '2015-01-01 00:00:00', NULL, NOW());

INSERT INTO hourly_account_role (account_id, role_id) SELECT a.acct_id, r.role_id FROM hourly_account a, hourly_role r WHERE a.username = 'user' and r.role_id = 1;
INSERT INTO hourly_account_role (account_id, role_id) SELECT a.acct_id, r.role_id FROM hourly_account a, hourly_role r WHERE a.username = 'operations' and r.role_id = 2;