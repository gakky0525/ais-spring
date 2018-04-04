drop table DEPARTMENT_MST if exists;

-- 診療科マスタ
create table DEPARTMENT_MST (
  DEPARTMENT_MST_ID serial not null
  , NAME VArchar(60) not null
  , constraint DEPARTMENT_MST_PKC primary key (DEPARTMENT_MST_ID)
) ;

drop table TAKE_TO_MST if exists;

-- 貸出先マスタ
create table TAKE_TO_MST (
  TAKE_TO_MST_ID serial not null
  , NAME VArchar(60) not null
  , constraint TAKE_TO_MST_PKC primary key (TAKE_TO_MST_ID)
) ;

drop table DOCTOR_MST if exists;

-- 医者マスタ
create table DOCTOR_MST (
  DOCTOR_MST_ID serial not null
  , NAME VArchar(60) not null
  , constraint DOCTOR_MST_PKC primary key (DOCTOR_MST_ID)
) ;

drop table BUILDING_MST if exists;

-- 病棟マスタ
create table BUILDING_MST (
  BUILDING_MST_ID serial not null
  , NAME VArchar(60) not null
  , constraint BUILDING_MST_PKC primary key (BUILDING_MST_ID)
) ;

-- カルテ貸出
drop table KARTE_LIB if exists;

create table KARTE_LIB (
  KARTE_LIB_ID serial
  , PATIENT_ID integer not null
  , PATIENT_NAME vARCHAR2(60) not null
  , PATIENT_KANA vARCHAR2(120) not null
  , BIRTH_DATE DATE not null
  , AGE integer not null
  , SEX character(1) not null
  , ABO character(2)
  , ADDR varchar(255)
  , TEL varchar(15)
  , DEPARTMENT_MST_ID integer not null
  , ENTRY_DATE DATE
  , LEAVE_DATE DATE
  , DIE_DATE DATE
  , LEAVE_DEPARTMENT_MST_ID integer
  , TAKE_TO_MST_ID integer
  , FAMILY_DOCTOR_MST_ID integer
  , BUILDING_MST_ID integer
  , LEAVE_BUILDING_MST_ID integer
  , DOCTOR_MST_ID1 integer
  , DOCTOR_MST_ID2 integer
  , DISSECTION_FLG char(1)
  , LETTER_FLG char(1)
  , AMBULANCE_FLG char(1)
  , OUTCOME varchar(10)

  , TAKE_DATE DATE
  , RETURN_DATE DATE
  , STATUS character(1) not null
  , constraint KARTE_LIB_PKC primary key (KARTE_LIB_ID)
) ;

alter table KARTE_LIB
  add constraint KARTE_LIB_FK1 foreign key (DEPARTMENT_MST_ID) references DEPARTMENT_MST(DEPARTMENT_MST_ID);

alter table KARTE_LIB
  add constraint KARTE_LIB_FK2 foreign key (TAKE_TO_MST_ID) references TAKE_TO_MST(TAKE_TO_MST_ID);

alter table KARTE_LIB
  add constraint KARTE_LIB_FK3 foreign key (LEAVE_DEPARTMENT_MST_ID) references DEPARTMENT_MST(DEPARTMENT_MST_ID);
