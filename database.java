create database javaproject;
use javaproject;

show project;

//tables creation
// Action

drop table user_login;

delete from user_login;

create table user_login
(
 u_id int primary key,
 u_name varchar(100),
 u_password varchar(150),
 u_mobile numeric(65),
 u_email varchar(150),
 u_address varchar(100)
 );
 
 insert into user_login values(1,'sandesh','12345678','9307260568','divekarsandesh34@gmail.com','At post varvand tal daund dist pune');
 
 insert into user_login values(2,'dipa','12121212','9158108734','divekardipa34@gmail.com','At post varvand tal daund dist pune');
 
 select * from user_login;
 
 update user set u_name='sandesh' where u_id=1; 

update user set u_password='12345678' where u_id=1;

update user set u_name='sandesh',u_password='12345678',u_mobile='9307260568',u_email='divekarsandesh34@gmail.com'
,'At post varvand tal daund dist pune' where u_id=1;

delete from user_login;


drop table donor;

delete from donor;

create table test0 
(
 d_id int primary key,
 Fname varchar(100),
 FFname varchar(150),
 Mname varchar(150),
 Date_Birth date,
 M_no numeric(65),
 Gender varchar(100),
 Email varchar(150),
 Blood_group varchar(100),
 City varchar(100),
 Address varchar(100)
 );
 insert into test0 values(1,'sandesh shivaji divekar','shivaji','rajashri','2001-03-27','9307260568','Male','divekarsandesh34@gmail.com','A+','varvand','At Post varvand tal daund dist pune');
 
 
 insert into test0 values(2,'suraj kishor divekar','kishor','manisha','1999-07-14','9158108734','Male','divekarsuraj34@gmail.com','B+','varvand','At Post varvand tal daund dist pune');
 
 insert into test0 values(3,'om sahil sane','sahil','nisha','2000-04-20','9158851584','Male','saneom14@gmail.com','A+','varvand','At Post patas tal daund dist pune');
 
 select * from donor;
 
 update donor set Fname='sandesh',FFname='shivaji',Mname='rajashri',Date_Birth='2021-03-27',Mno='9307260568',Gender='male',Email='divekarsandesh34@gmail.com',Blood_group='A+',City='varvand',Address='At post varvand tal daund dist pune' where d_id=1;
 
 delete from donor where d_id=1;
 
 //
 
 
 
/* update test0 set d_id='" +t1.getText()+"', FFname='" +t2.getText()+"', Fname=" +t3.getText()+"', 
 Mname='" +t4.getText()+"', M_no='" +t5.getText()+"', Gender='" +cb1.getSelectedIndex()+"', 
 Email='" +t6.getText()"', Blood_group='" +cb2.getSelectedIndex()+"', city='" +t7.getText()+"', Address='" +t8.getText()+"'
where Date_Birth="+calb.setText()"; 
where Date_Birth="+calb.setText()"; */
 
 
 sql = "update test0 set FFname = '" +t2.getText()+"', Fname = "+t3.getText()+
 "', Mname = "+t4.getText()+"', Date_Birth = "+calb.getText()+"', M_no = "+t5.getText()+
 "', Gender = "+cb1.getSelectedIndex()+", Email = '"+t6.getText()+"', Blood_group = "+cb2.getSelectedIndex()+
 "', city = "+t7.getText()+"', Address = "+t8.getText()+" where d_id = "+t1.getText();
 
 
 
 
 
 
 
 
 
 
 
 
 create table blood
 (
  b_id int primary key,
  b_group varchar(100),
  b_bank varchar(150),
  b_cells varchar(100),
  b_desc varchar(100)
  );
  
  insert into blood values(1,'A+','sai blood bank','white','liquid');
  
  insert into blood values(1,'B+','om blood bank ','red','solid');
  
  insert into blood values(2,'A-','sai blood bank','platelets','liquid');
  
  select * from blood;
  
   update blood set b_group='A+',b_bank='sai blood bank',b_cells='white',b_desc='liquid' where b_id=1;
 
  delete from donor where b_id=1;
 
 
  
  create table patient
  (
   p_id int primary key,
   p_name varchar(100),
   p_mobile numeric(100),
   p_email varchar(150),
   p_add varchar(100)
   );
 
   insert into patient values(1,'sandesh','9307260568','divekarsandesh34@gmail.com','At post varvand tal daund dist pune');
   
   insert into patient values(1,'Ajinkys','9158108734','divekarajinkya50@gmail.com','At post varvand tal daund dist pune');
  
   insert into patient values(1,'om','9158851584','divekarom14@gmail.com','At post varvand tal daund dist pune');
  
   select * from patient;
   
   update patient set p_name='sandesh',p_mobile='9307260568',p_email='divekarsandesh34@gmail.com',p_add='At post varvand tal daund dist pune' where p_id=1;
 
   delete from patient where p_id=1;
 
  
  create table blood_group
  (
   bg_id int primary key,
   d_id int foregin key,
   p_id int foregin key,
   bg_type varchar(100)
   );
	
	
	insert into blood_group values(1,1,1,'A+');
	
	insert into blood_group values(2,2,2,'B+');
	
	select * from blood_group;
	
	update blood_group set bg_id='1',d_id='1',p_id='1',bg_type='A+' where bg_id=1;
	
	delete from blood_group where bg_id=1;
	
	create table blood_cells
	(
	 bc_id int primary key,
	 d_id int foregin key,
	 p_id int foregin key,
	 bc_type varchar(100)
	 );
	
	insert into blood_cells values(1,1,1,'red');
	
	insert into blood_cells values(1,1,1,'white');
	
	select * from blood_cells;
	
	update blood_cells set bc_id='1',d_id='1',p_id='1',bc_type='red' where bc_id=1;
	
	delete from blood_cells where bc_id=1;
	
	
	
	
	create table stock
    (
	 stk_id int primary key,
	 unit numeric(60),
	 Blood_Group varchar(100),
	 stk_number numeric(50)
	 );
	 
	 
     insert into stock values(11,100,'A+','12');
	 
	 insert into stock values(12,'50','B+','12');
	 
	 insert into stock values(13,'800','AB+','13');
	 
	 update stock set stk_id='1',stk_blood='A+',stk_name='A+',stk_number='11' where stk_id=1;

     delete from stock where stk_id=1;	

	 create table order 
	 (
	  o_id int primary key,
	  o_type varchar(100),
	  o_number numeric(150)
	  );
	  
	 insert into order values(1,'ABC group','111');
	 
	 insert into order values(2,'PDF group','112');
	 
	 update stock set o_id='1',o_type='ABC group',o_number='111' where stk_id=1;
	 
	 delete from order where o_id=1;	
	  
	create table donor_transactions
	(
	 donor_trans_id int primary key,
	 donor_id int foreign key,
	 health_condition varchar(100),,
	 date date
	 );
	 
	 insert into donor_transactions values(1,1,'clear','2021-07-03');
	 
	 insert into donor_transactions values(1,1,'normal','2020-05-03');
	 
	 update donor_transactions set donor_trans_id=1,donor_id=1,health_condition='clear' where donor_trans_id=1;
	 
	 delete from donor_transactions where donor_trans_id=1;	
	  
	 
	 create table recipient
	 (
	  recepient_id primary key,
	  donor_id foreign key,
	  blood_id foreign key,
	  name varchar(100),
	  contact_number numeric(100)
	  );
	  
	  insert into recipient values(1,1,1,'packing list','9307260568');
	  
	  insert into recipient values(1,1,1,'packing slip','9158108734');
	  
	  update recipient set recepient_id=1,donor_id=1,blood_id=1,name='packing list',contact_number='9307260568' where recipient_id=1;
	 
	  delete from recipient where recipient_id=1;	
	  
	  create table recipient_transaction
	  (
	   recipient_transaction_id primary key,
	   recipient_id int foreign key,
	   recipient_request varchar(100),
	   date date,
	   donor_id int foreign key
	   );
	   
	   insert into recipient_transaction values(1,1,'openemail','2021-04-03',1);
	   
	   insert into recipient_transaction values(1,1,'clickcompose','2020-04-03',1);
	   
	   update recipient_transaction set recepient_transaction_id=1,recipient_id=1,recipient_request='openemail',date='2021-04-03',donor_id=1 where recipient_transaction_id=1;
	   
	   
	   delete from recipient_transaction where recipient_transaction_id=1;	
	  
	   