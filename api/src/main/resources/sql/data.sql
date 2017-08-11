
INSERT INTO T_USER (ID,CREATE_TIME,CREATE_USER,CREATE_USERIP,DELETED,UPDATE_TIME,UPDATE_USER,UPDATE_USERIP,VERSION,age,email,first_name,last_name,location,mobile_phone,password,time_zone,token,user_name,active)
VALUES ('9B18591A-C518-4CDE-BA3B-9ADC3145D677',sysdate,'SYSTEM','127.0.0.1','0',sysdate,'SYSTEM','127.0.0.1','0','25','test@test.com','FirstTest','LastTest','TR','5331234565','Password','TR','Token','test','YES');

-- INSERT INTO T_CUSTOMER (ID,CREATE_TIME,CREATE_USER,CREATE_USERIP,DELETED,UPDATE_TIME,UPDATE_USER,UPDATE_USERIP,VERSION,is_individual,company_name,first_name,last_name,email,mobile_phone,password,time_zone,address,token,profession,active)
-- VALUES ('9B18591A-C518-4CDE-BA3B-9ADC3145D678',SYSDATE,'SYSTEM','127.0.0.1','0',SYSDATE,'SYSTEM','127.0.0.1','0','YES','Dr. Semih Unaldi','Dr. Semih','Unaldi','semihunaldi@gmail.com','5331234567','password','Tr','Istanbul','token','Doctor','YES');

-- INSERT INTO T_CUSTOMER_APPOINTMENT (ID,CREATE_TIME,DELETED,customer_id,appointment_name,appointment_location,appointment_coordinates,approvement_needed)
-- VALUES('9B18591A-C518-4CDE-BA3B-9ADC3145D679',SYSDATE,'0','9B18591A-C518-4CDE-BA3B-9ADC3145D678','Doctors appointment','Istanbul','X,Y','NO');






commit;




