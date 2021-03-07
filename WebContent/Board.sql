/*HTML 테이블 --> 지움

create table html
(
   html_num number not null primary key, /*글번호*/
   html_writer varchar(10) not null, /*작성자*/
   html_sub varchar2(50) not null, /*제목*/
   html_content varchar2(4000) not null, /*내용*/
   html_file varchar2(100) not null, /*첨부파일*/
   html_re_ref number not null, /*관련글번호 -> 왜 있는 거지 아직 몰라*/
   html_re_lev number not null, /*답글 레벨*/
   html_re_step number not null, /*관련글 중 출력 순서 -> 왜 있는 거지 아직 몰라2*/
   html_date date default sysdate, /*작성일*/
   html_viewcount number not null, /*조회수*/
   delyn char(1)default 'N', 
   html_ip varchar2(20) not null /*어... 아이피 추적용?*/
);

drop table html;*/


/*유저 정보 테이블*/
create table user_if
(
   user_num number not null primary key, /*회원고유번호*/
   user_id varchar(10) not null, /*아이디*/
   user_pwd varchar(20) not null, /*비밀번호*/
   user_name varchar(10) not null, /*닉네임*/
   user_e_mail varchar2(100) not null, /*이메일*/
   user_date date default sysdate, /*회원가입일*/
   adminyn char(1) not null, /*관리자냐*/
   delyn char(1)default 'N' /*난 이걸 모르지만 일단 넣는다*/
);

/*게시판만들기 테이블*/
create table MVC2
(
   MVC2_num number not null primary key, /*글번호*/
   user_num number not null, /*작성자*/
   MVC2_sub varchar2(50) not null, /*제목*/
   MVC2_content varchar2(4000) not null, /*내용*/
   MVC2_file varchar2(100) not null, /*첨부파일*/
   MVC2_re_ref number not null, /*관련글번호 -> 왜 있는 거지 아직 몰라*/
   MVC2_re_lev number not null, /*답글 레벨*/
   MVC2_re_step number not null, /*관련글 중 출력 순서 -> 왜 있는 거지 아직 몰라2*/
   MVC2_date date default sysdate, /*작성일*/
   MVC2_viewcount number not null, /*조회수*/
   delyn char(1)default 'N', /*난 이걸 모르지만 일단 넣는다*/ 
   html_ip varchar2(20) not null /*어... 아이피 추적용?*/
);

/*회원 번호 1부터*/
create sequence user_num_seq
increment by 1
start with 1;

/*글 번호 1부터*/
create sequence MVC2_num_seq
increment by 1
start with 1;

/*회원 테이블 회원번호 게시판 번호로 보내기*/
alter table MVC2 /*MVC2 테이블을 바꾸겠다*/
add CONSTRAINT user_MVC2num FOREIGN key(user_num) /*회원_번호를 포린키로 해서  회원_MVC2번호로 바꾸겠다*/
REFERENCES user_if(user_num);/*회원정보 테이블에 있는 회원_번호를 이용하겠다.*/


/*user_if table에 user_e_mail2 컬럼을 추가할 것이다 */
alter table user_if add user_e_mail2 varchar2(100);

/*MVC2테이블에 컬럼추가*/
ALTER TABLE MVC2 ADD MVC2_writer VARCHAR(20);
ALTER TABLE MVC2 ADD MVC2_catagory VARCHAR(20);

select * from MVC2 A where MVC2_num=1;
