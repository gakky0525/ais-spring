-- Project Name : AIS
-- Date/Time    : 2018/02/17 7:43:31
-- Author       : fhideaki
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

drop table KARTE_LIB if exists;
-- カルテ貸出
create table KARTE_LIB (
  KARTE_LIB_ID serial
  , PATIENT_ID integer not null
  , PATIENT_NAME vARCHAR2(60) not null
  , PATIENT_KANA vARCHAR2(120) not null
  , BIRTH_DATE DATE not null
  , AGE integer not null
  , SEX character(1) not null
  , ABO character(2)
  , ADDR character(255)
  , TEL character(15)
  , ENTRY_DATE DATE
  , LEAVE_DATE DATE
  , DEPARTMENT vARCHAR2(30) not null
  , TAKE_DATE DATE
  , RETURN_DATE DATE
  , TAKE_TO vARCHAR2(30)
  , STATUS character(1) not null
  , constraint KARTE_LIB_PKC primary key (KARTE_LIB_ID)
) ;

comment on table KARTE_LIB is 'カルテ貸出';
comment on column KARTE_LIB.KARTE_LIB_ID is 'カルテ貸出ID';
comment on column KARTE_LIB.PATIENT_ID is '患者ID';
comment on column KARTE_LIB.PATIENT_NAME is '患者名';
comment on column KARTE_LIB.PATIENT_KANA is '患者名カナ';
comment on column KARTE_LIB.BIRTH_DATE is '患者誕生日';
comment on column KARTE_LIB.AGE is '患者年齢';
comment on column KARTE_LIB.SEX is '患者性別';
comment on column KARTE_LIB.ABO is '患者血液型';
comment on column KARTE_LIB.ADDR is '患者住所';
comment on column KARTE_LIB.TEL is '患者電話番号';
comment on column KARTE_LIB.ENTRY_DATE is '入院日';
comment on column KARTE_LIB.LEAVE_DATE is '退院日';
comment on column KARTE_LIB.DEPARTMENT is '診療科';
comment on column KARTE_LIB.TAKE_DATE is '貸出日';
comment on column KARTE_LIB.RETURN_DATE is '返却日';
comment on column KARTE_LIB.TAKE_TO is '貸出先';
comment on column KARTE_LIB.STATUS is '貸出状況';
