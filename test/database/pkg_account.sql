connect db@orcl12

-----------------------------------
--ORCL12---------------------------
-----------------------------------
create table ACCOUNT_TO (account_id int primary key, balance number(12,2) not null);




connect db@orcl10
-----------------------------------
--ORCL10---------------------------
-----------------------------------

create database link TO_ORCL12 connect to DB identified by "1" using 'EPBYMINW6854:1521/ORCL';


create table ACCOUNT_FROM (account_id int primary key, balance number(12,2) not null);


create or replace package pkg_account is

  -- Author  : 
  -- Created : 3/13/2017 12:12:26 PM
  -- Purpose : 
  
  -- Public function and procedure declarations
  procedure transfer_balance(in_account_id int, in_amount number);

end pkg_account;
/


create or replace package body pkg_account is

  procedure transfer_balance(in_account_id int, in_amount number)
  is
    v_balance number(12,2);    
  begin
    begin
      select f.balance
        into v_balance
        from db.account_from f 
        where f.account_id = in_account_id
        for update;
     exception 
       when no_data_found then 
         raise_application_error(-20001, 'Can not find account_id = "'||in_account_id||'" on sender side.');
     end;   
      
    if (v_balance < in_amount)  then
      raise_application_error(-20002, 'Not enough balance on account_id = "'||in_account_id||'" on sender side.');
    end if;             
    
    begin
      select f.balance
        into v_balance 
        from db.account_to@to_orcl12 f
        where f.account_id = in_account_id
        for update;
     exception 
       when no_data_found then 
         raise_application_error(-20003, 'Can not find account_id = "'||in_account_id||'" on receiver side.');
     end;   

    --Transfer balance
    update db.account_from f  
       set f.balance = f.balance - in_amount 
     where f.account_id = in_account_id;              

    update db.account_to@to_orcl12 f  
       set f.balance = f.balance + in_amount 
     where f.account_id = in_account_id;              
    
    commit;
    
    exception 
      when others then
        rollback;
        raise;  
  end;       

end pkg_account;
/
