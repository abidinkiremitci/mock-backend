drop table t_user if exists;
drop table t_customer if exists;
drop table t_appointment if exists;
drop table t_customer_appointment if exists;
drop table t_customer_schedule if exists;


create table t_user
(
  id varchar(255) not null,
  create_time timestamp,
  create_user varchar(255),
  create_userip varchar(255),
  deleted varchar(255),
  update_time timestamp,
  update_user varchar(255),
  update_userip varchar(255),
  version integer,
  age integer,
  email varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  location varchar(255),
  mobile_phone varchar(255),
  password varchar(255),
  time_zone varchar(255),
  token varchar(255),
  user_name varchar(255),
  active varchar (10),
  primary key (id)
);
alter table t_user add constraint T_USER_USER_NAME_UNIQUE unique (user_name);
alter table t_user add constraint T_USER_EMAIL_UNIQUE unique (email);
alter table t_user add constraint T_USER_ACTIVE_CHK CHECK (active IN ('YES','NO'));
