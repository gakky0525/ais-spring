drop table DEPARTMENT_MST if exists;

create table DEPARTMENT_MST (
  DEPARTMENT_MST_ID serial not null
  , NAME VArchar(60) not null
  , constraint DEPARTMENT_MST_PKC primary key (DEPARTMENT_MST_ID)
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
  , TAKE_DATE DATE
  , RETURN_DATE DATE
  , TAKE_TO char(60)
  , STATUS character(1) not null
  , constraint KARTE_LIB_PKC primary key (KARTE_LIB_ID)
) ;

alter table KARTE_LIB
  add constraint KARTE_LIB_FK1 foreign key (DEPARTMENT_MST_ID) references DEPARTMENT_MST(DEPARTMENT_MST_ID);

comment on table DEPARTMENT_MST is '診療科マスタ';
comment on column DEPARTMENT_MST.DEPARTMENT_MST_ID is '診療科マスタID';
comment on column DEPARTMENT_MST.NAME is '名前';

comment on table KARTE_LIB is 'カルテ貸出';
comment on column KARTE_LIB.KARTE_LIB_ID is 'カルテ貸出ID';
comment on column KARTE_LIB.PATIENT_ID is '患者ID';
comment on column KARTE_LIB.PATIENT_NAME is '患者名';
comment on column KARTE_LIB.PATIENT_KANA is '患者名カナ';
comment on column KARTE_LIB.BIRTH_DATE is '患者誕生日';
comment on column KARTE_LIB.AGE is '患者年齢';
comment on column KARTE_LIB.SEX is '患者性別';
comment on column KARTE_LIB.DEPARTMENT_MST_ID is '診療科マスタID';
comment on column KARTE_LIB.ENTRY_DATE is '入院日';
comment on column KARTE_LIB.LEAVE_DATE is '退院日';
comment on column KARTE_LIB.TAKE_DATE is '貸出日';
comment on column KARTE_LIB.RETURN_DATE is '返却日';
comment on column KARTE_LIB.TAKE_TO is '貸出先';
comment on column KARTE_LIB.STATUS is '貸出状況';