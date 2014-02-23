insert into role values ('ROLE_USER', 'User');
insert into role values ('ROLE_ADMIN', 'Administrator');
insert into role values ('ROLE_REMOTE', 'Remote User');

insert into app_user values (1, 'admin', 'Administrator', '691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2012-06-04 01:00:00');
insert into app_user values (2, 'user','Calvin','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','user','2012-06-04 02:00:00');
insert into app_user values (3, 'remote', 'Remote User', '2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','user','2012-06-04 02:00:00');

insert into user_role_detail values (1,'ROLE_ADMIN');
insert into user_role_detail values (1,'ROLE_USER');
insert into user_role_detail values (2,'ROLE_ADMIN');
insert into user_role_detail values (2,'ROLE_USER');
insert into user_role_detail values (3,'ROLE_REMOTE');
insert into user_role_detail values (3,'ROLE_USER');

insert into category values ('Java', null);
insert into category values ('Spring', null);
insert into category values ('JPA', null);
insert into category values ('Spring Batch', 'Spring');
insert into category values ('Spring Integration', 'Spring');
insert into category values ('Spring Webflow', 'Spring');
insert into category values ('Spring Roo', 'Spring');
insert into category values ('Hibernate', 'JPA');
insert into category values ('Eclipse Link', 'JPA');
insert into category values ('Collections', 'Java');
insert into category values ('JSR-303', 'Java');

insert into entry values (null, 'inited subject', 'so this is a test, just check', '2011-10-21','Spring', 'Spring Webflow', 'clarence', '2011-10-21', 'clarence', '2011-10-21', 0);