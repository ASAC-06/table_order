drop table if exists `order_line_item` cascade;
drop table if exists `selling_item` cascade;
drop table if exists `item_category` cascade;
drop table if exists `order` cascade;

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

create table `order`
(
    `id`                    bigint not null auto_increment,
    `order_number`          bigint,
    `table_number`          integer,
    `total_amount`          integer,
    `total_price`           integer,
    `payments_status`       enum ('CANCEL','COMPLETE','READY'),
    `tos_payments_row_data` longtext,
    `paid_at`               datetime(6),
    `confirmed_at`          datetime(6),
    `created_at`            datetime(6),
    `updated_at`            datetime(6),
    primary key (`id`)
) engine = InnoDB;

create table `order_line_item`
(
    `id`         bigint not null auto_increment,
    `item_id`    bigint,
    `order_id`   bigint,
    `item_name`  varchar(255),
    `item_price` integer,
    `amount`     integer,
    `created_at` datetime(6),
    `updated_at` datetime(6),
    primary key (`id`)
) engine = InnoDB;

alter table `selling_item`
    add constraint `FK7gq8oplhwromvbp8qet1fy2c0`
        foreign key (`category_id`)
            references `item_category` (`id`);

alter table `order_line_item`
    add constraint `FK20m958i30ouo7gy3ck0pn8m3l`
        foreign key (`order_id`)
            references `order` (`id`);

alter table `order_line_item`
    add constraint `FKtnbqa3xvj5ku4y4xfdj1vusbn`
        foreign key (`item_id`)
            references `selling_item` (`id`);