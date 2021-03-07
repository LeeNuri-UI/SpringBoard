/*HTML ���̺� --> ����

create table html
(
   html_num number not null primary key, /*�۹�ȣ*/
   html_writer varchar(10) not null, /*�ۼ���*/
   html_sub varchar2(50) not null, /*����*/
   html_content varchar2(4000) not null, /*����*/
   html_file varchar2(100) not null, /*÷������*/
   html_re_ref number not null, /*���ñ۹�ȣ -> �� �ִ� ���� ���� ����*/
   html_re_lev number not null, /*��� ����*/
   html_re_step number not null, /*���ñ� �� ��� ���� -> �� �ִ� ���� ���� ����2*/
   html_date date default sysdate, /*�ۼ���*/
   html_viewcount number not null, /*��ȸ��*/
   delyn char(1)default 'N', 
   html_ip varchar2(20) not null /*��... ������ ������?*/
);

drop table html;*/


/*���� ���� ���̺�*/
create table user_if
(
   user_num number not null primary key, /*ȸ��������ȣ*/
   user_id varchar(10) not null, /*���̵�*/
   user_pwd varchar(20) not null, /*��й�ȣ*/
   user_name varchar(10) not null, /*�г���*/
   user_e_mail varchar2(100) not null, /*�̸���*/
   user_date date default sysdate, /*ȸ��������*/
   adminyn char(1) not null, /*�����ڳ�*/
   delyn char(1)default 'N' /*�� �̰� ������ �ϴ� �ִ´�*/
);

/*�Խ��Ǹ���� ���̺�*/
create table MVC2
(
   MVC2_num number not null primary key, /*�۹�ȣ*/
   user_num number not null, /*�ۼ���*/
   MVC2_sub varchar2(50) not null, /*����*/
   MVC2_content varchar2(4000) not null, /*����*/
   MVC2_file varchar2(100) not null, /*÷������*/
   MVC2_re_ref number not null, /*���ñ۹�ȣ -> �� �ִ� ���� ���� ����*/
   MVC2_re_lev number not null, /*��� ����*/
   MVC2_re_step number not null, /*���ñ� �� ��� ���� -> �� �ִ� ���� ���� ����2*/
   MVC2_date date default sysdate, /*�ۼ���*/
   MVC2_viewcount number not null, /*��ȸ��*/
   delyn char(1)default 'N', /*�� �̰� ������ �ϴ� �ִ´�*/ 
   html_ip varchar2(20) not null /*��... ������ ������?*/
);

/*ȸ�� ��ȣ 1����*/
create sequence user_num_seq
increment by 1
start with 1;

/*�� ��ȣ 1����*/
create sequence MVC2_num_seq
increment by 1
start with 1;

/*ȸ�� ���̺� ȸ����ȣ �Խ��� ��ȣ�� ������*/
alter table MVC2 /*MVC2 ���̺��� �ٲٰڴ�*/
add CONSTRAINT user_MVC2num FOREIGN key(user_num) /*ȸ��_��ȣ�� ����Ű�� �ؼ�  ȸ��_MVC2��ȣ�� �ٲٰڴ�*/
REFERENCES user_if(user_num);/*ȸ������ ���̺� �ִ� ȸ��_��ȣ�� �̿��ϰڴ�.*/


/*user_if table�� user_e_mail2 �÷��� �߰��� ���̴� */
alter table user_if add user_e_mail2 varchar2(100);

/*MVC2���̺� �÷��߰�*/
ALTER TABLE MVC2 ADD MVC2_writer VARCHAR(20);
ALTER TABLE MVC2 ADD MVC2_catagory VARCHAR(20);

select * from MVC2 A where MVC2_num=1;
