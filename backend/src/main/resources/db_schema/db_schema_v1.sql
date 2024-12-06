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

alter table `selling_item`
    add constraint `FK7gq8oplhwromvbp8qet1fy2c0`
        foreign key (`category_id`)
            references `item_category` (`id`);