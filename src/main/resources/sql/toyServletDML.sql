USE toy_servletswithdb;

INSERT INTO USERDATA (USER_UID, NAME, ID, PASSWORD, PHONE_NUMBER, BIRTHDAY, EMAIL, SMS_AD, EMAIL_AD)
VALUES ('U1', '마키', 'marky01', '11101', '010-1597-1753', '1992-01-04', 'marky01@naver.com', true, false);

INSERT INTO USERDATA (USER_UID, NAME, ID, PASSWORD, PHONE_NUMBER, BIRTHDAY, EMAIL, SMS_AD, EMAIL_AD)
VALUES ('U2', '리키', 'riky02', '11102', '010-7597-4865', '1988-08-11', 'riky02@naver.com', false, false);

INSERT INTO USERDATA (USER_UID, NAME, ID, PASSWORD, PHONE_NUMBER, BIRTHDAY, EMAIL, SMS_AD, EMAIL_AD)
VALUES ('U3', '데이비', 'davy03', '11103', '010-1597-4535', '2002-11-04', 'davy03@naver.com', false, true);

INSERT INTO USERDATA (USER_UID, NAME, ID, PASSWORD, PHONE_NUMBER, BIRTHDAY, EMAIL, SMS_AD, EMAIL_AD)
VALUES ('U4', '티미', 'timy04', '11104', '010-5649-1597', '2000-05-30', 'timy04@naver.com', true, true);

INSERT INTO USERDATA (USER_UID, NAME, ID, PASSWORD, PHONE_NUMBER, BIRTHDAY, EMAIL, SMS_AD, EMAIL_AD)
VALUES ('U5', '죠니', 'jony05', '11105', '010-7533-1744', '1985-07-07', 'jony05@naver.com', true, false);

-- -- -- QUESTION_LIST -- -- -- 
INSERT INTO QUESTION_LIST(QUESTION_UID, QUESTION, ORDERS)
VALUES ('Q1', '현재 사용중인 제품을 선택해주세요.', '1');

INSERT INTO QUESTION_LIST(QUESTION_UID, QUESTION, ORDERS)
VALUES ('Q2', '현재 사용중인 제품의 가격이 적당하다고 생각하십니까?', '2');

INSERT INTO QUESTION_LIST(QUESTION_UID, QUESTION, ORDERS)
VALUES ('Q3', '사용중인 제품의 음향은 만족스러우신가요?', '3');

INSERT INTO QUESTION_LIST(QUESTION_UID, QUESTION, ORDERS)
VALUES ('Q4', '사용중인 제품의 디자인은 만족스러우신가요?', '4');

INSERT INTO QUESTION_LIST(QUESTION_UID, QUESTION, ORDERS)
VALUES ('Q5', '사용중인 제품은 사용이 편리한가요?', '5');



-- -- --  ANSWERLIST -- -- --

INSERT INTO ANSWER_LIST(ANSWER_UID, ANSWER, ORDERS)
VALUES ('A1', '전혀 아니다', '1'), ('A2', '아니다', '2'), ('A3', '보통이다', '3'), ('A4', '그렇다', '4'),
('A5', '매우 그렇다', '5'),('A6', '무선이어폰', '6'),('A7', '헤드셋', '7'),('A8', '유선이어폰', '8');


 -- -- --  QA_DATA -- -- -- 
 
INSERT INTO QA_DATA(QUESTION_UID, ANSWER_UID)
VALUES ('Q1', 'A6'),('Q1', 'A7'),('Q1', 'A8'),
('Q2', 'A1'),('Q2', 'A2'),('Q2', 'A3'),('Q2', 'A4'),('Q2', 'A5'),
('Q3', 'A1'),('Q3', 'A2'),('Q3', 'A3'),('Q3', 'A4'),('Q3', 'A5'),
('Q4', 'A1'),('Q4', 'A2'),('Q4', 'A3'),('Q4', 'A4'),('Q4', 'A5'),
('Q5', 'A1'),('Q5', 'A2'),('Q5', 'A3'),('Q5', 'A4'),('Q5', 'A5');



--  -- --
INSERT INTO SURVEY_DATA(QUESTION_UID, ANSWER_UID, USER_UID)
VALUES ('Q1', 'A6', 'U1'), ('Q2','A2','U1'), ('Q3','A3','U1'), ('Q4','A2','U1'), ('Q5','A1','U1');
INSERT INTO SURVEY_DATA(QUESTION_UID, ANSWER_UID, USER_UID)
VALUES ('Q1', 'A6', 'U2'), ('Q2','A1','U2'), ('Q3','A1','U2'), ('Q4','A1','U2'), ('Q5','A1','U2');
INSERT INTO SURVEY_DATA(QUESTION_UID, ANSWER_UID, USER_UID)
VALUES ('Q1', 'A7', 'U3'), ('Q2','A5','U3'), ('Q3','A4','U3'), ('Q4','A5','U3'), ('Q5','A4','U3');
INSERT INTO SURVEY_DATA(QUESTION_UID, ANSWER_UID, USER_UID)
VALUES('Q1', 'A8', 'U4'), ('Q2','A3','U4'), ('Q3','A3','U4'), ('Q4','A4','U4'), ('Q5','A3','U4');
INSERT INTO SURVEY_DATA(QUESTION_UID, ANSWER_UID, USER_UID)
VALUES('Q1', 'A8', 'U5'), ('Q2','A4','U5'), ('Q3','A3','U5'), ('Q4','A4','U5'), ('Q5','A5','U5');