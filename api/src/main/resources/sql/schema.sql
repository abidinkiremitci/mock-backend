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

-- create table t_customer
-- (
--   id varchar(255) not null,
--   create_time timestamp,
--   create_user varchar(255),
--   create_userip varchar(255),
--   deleted varchar(255),
--   update_time timestamp,
--   update_user varchar(255),
--   update_userip varchar(255),
--   version integer,
--   is_individual varchar(10),
--   company_name varchar(255),
--   first_name varchar(255),
--   last_name varchar(255),
--   email varchar(255),
--   mobile_phone varchar(255),
--   password varchar(255),
--   time_zone varchar(255),
--   address varchar(255),
--   token varchar(255),
--   profession varchar(255),
--   active VARCHAR (10),
--   primary key (id)
-- );
-- alter table t_customer add constraint T_CUSTOMER_EMAIL_UNIQUE unique (email);
-- ALTER TABLE t_customer ADD CONSTRAINT T_CUSTOMER_ACTIVE_CHK CHECK (active IN ('YES','NO'));
-- ALTER TABLE t_customer ADD CONSTRAINT T_CUSTOMER_INDIVIDUAL_CHK CHECK (is_individual IN ('YES','NO'));
--
--
-- create table t_customer_appointment
-- (
--   id varchar(255) not null,
--   create_time timestamp,
--   deleted varchar(255),
--   customer_id varchar(255),
--   appointment_name varchar(255),
--   appointment_location varchar(255),
--   appointment_coordinates varchar(255),
--   approvement_needed varchar(50),
--   primary key (id)
-- );
-- alter table t_customer_appointment add constraint T_CUS_APPOINTMENT_CUS_FK foreign key (customer_id) references t_customer(id);
-- ALTER TABLE t_customer_appointment ADD CONSTRAINT T_CUS_APP_APPRV_CHK CHECK (approvement_needed IN ('YES','NO'));
--
--
-- create table t_appointment
-- (
--   id varchar(255) not null,
--   create_time timestamp,
--   create_user varchar(255),
--   create_userip varchar(255),
--   deleted varchar(255),
--   update_time timestamp,
--   update_user varchar(255),
--   update_userip varchar(255),
--   version integer,
--
--   appointment_name varchar(255),
--   appointment_start_date timestamp,
--   appointment_end_date timestamp,
--   reminder_date timestamp,
--   notes varchar(255),
--   is_approved varchar(255),
--   customer_appointment_id varchar(255),
--   user_id varchar(255),
--   time_zone varchar(255),
--   primary key (id)
-- );
-- ALTER TABLE t_appointment ADD CONSTRAINT T_APPOINTMENT_ACTIVE_CHK CHECK (is_approved IN ('YES','NO'));
-- alter table t_appointment add constraint T_CUS_APPOINTMENT__FK foreign key (customer_appointment_id) references t_customer_appointment(id);
-- alter table t_appointment add constraint T_APPOINTMENT_USER_FK foreign key (user_id) references t_user(id);
--
--
-- create table t_customer_schedule
-- (
--   id varchar(255) not null,
--   create_time timestamp,
--   deleted varchar(255),
--   customer_appointment_id varchar(255),
--   year number(10),
--   week_number number(10),
--   week_id varchar(255),
--   customer_week TEXT ,
--   primary key (id)
-- );
-- alter table t_customer_schedule add constraint T_CUS_SCHEDULE_CUS_APP_FK foreign key (customer_appointment_id) references t_customer_appointment(id);