drop table if exists `selling_item` cascade;
drop table if exists `item_category` cascade;

create table `item_category`
(
    `id`         bigint not null auto_increment,
    `name`       varchar(255),
    `priority`   integer,
    `created_at` datetime(6),
    `updated_at` datetime(6),
    primary key (`id`)
) engine = InnoDB;

create table `selling_item`
(
    `id`           bigint not null auto_increment,
    `category_id`  bigint,
    `name`         varchar(255),
    `price`        integer,
    `description`  longtext,
    `profile_path` longtext,
    `status`       enum ('A','D','SO'),
    `created_at`   datetime(6),
    `updated_at`   datetime(6),
    primary key (`id`)
) engine = InnoDB;

insert into item_category (name, priority)
values ('순두부', 1);
insert into item_category (name, priority)
values ('셋트메뉴', 2);
insert into item_category (name, priority)
values ('음료', 3);

insert into selling_item(category_id, name, price, description, profile_path, status)
values (1, '순두부', 10000, '순두부 찌게', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (1, '햄치즈 순두부', 11000, '햄이랑 치즈 들어감. 순두부 찌게', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (1, '해물 순두부', 12000, '해물 순두부 찌게', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (2, '순두부 셋트', 17000, '순두부 + 생선', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (2, '햄치즈 순두부 셋트', 17000, '햄치즈 순두부 + 생선', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (2, '해물 순두부 셋트', 18000, '해물 순두부 + 생선', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (3, '콜라', 2000, '청량감 goat', 'path', 'A');

insert into selling_item(category_id, name, price, description, profile_path, status)
values (3, '사이다', 2000, '청량감 goat 2', 'path', 'A');