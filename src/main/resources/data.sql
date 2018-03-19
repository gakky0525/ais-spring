insert into DEPARTMENT_MST (DEPARTMENT_MST_ID, name) values(1, '内科');
insert into DEPARTMENT_MST (DEPARTMENT_MST_ID, name) values(2, '外科');

insert into TAKE_TO_MST (TAKE_TO_MST_ID, name) values(1, '貸出先１');
insert into TAKE_TO_MST (TAKE_TO_MST_ID, name) values(2, '貸出先２');

insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ABO, ADDR, TEL, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (1, '藤沢秀晃', 'フジサワ　ヒデアキ', '1979-01-19', 38, '男', 'A', '神奈川県鎌倉市笛田3-36-46 サンティ107', '090-2143-3116', '2017-11-20', '2017-11-21', 1, '2017-12-10', '2016-12-30', 1, '1');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (2, '長岐由樹', 'ナガキ　ユキ', '1986-5-25', 31, '女', '2017-11-20', '2017-11-21', 1, '2017-12-10', '2016-12-30', 2, '1');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (3, 'テスト患者１', 'テスト　カンジャ１', '1956-1-1', 61, '男', '2016-12-15', '2016-12-25', 2, '2017-12-10', '2016-12-30', 1, '0');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (4, 'テスト患者2', 'テスト　カンジャ2', '1966-1-1', 51, '女', '2016-12-15', '2016-12-25', 2, '2017-12-10', '2016-12-30', 1, '0');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (5, 'テスト患者3', 'テスト　カンジャ3', '1976-1-1', 41, '男', '2016-12-15', '2016-12-25', 2, '2017-12-10', '2016-12-30', null, '0');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (6, 'テスト患者4', 'テスト　カンジャ4', '1996-1-1', 21, '女', '2016-12-15', '2016-12-25', 2, '2017-12-10', '2016-12-30', null, '0');
insert into karte_lib (PATIENT_ID, PATIENT_NAME, PATIENT_KANA, BIRTH_DATE, AGE, SEX, ENTRY_DATE, LEAVE_DATE, DEPARTMENT_MST_ID, TAKE_DATE, RETURN_DATE, TAKE_TO_MST_ID, STATUS) values (7, 'テスト患者5', 'テスト　カンジャ5', '2006-1-1', 11, '男', '2016-12-15', '2016-12-25', 2, '2017-12-10', '2016-12-30', null, '0');
