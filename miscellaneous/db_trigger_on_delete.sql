/*On hs_customer_prediction*/


trigger function :-

CREATE OR REPLACE FUNCTION public.trgfunc_insert_cust_history_records() 
RETURNS trigger LANGUAGE 'plpgsql' COST 100 VOLATILE NOT LEAKPROOF 
AS $BODY$ 
BEGIN Insert into hs_customer_prediction_history(
  id, age, job, marital, education, balance, 
  housing, loan, contact, day, month, 
  duration, campaign, previous, poutcome, 
  deposit, deletion_time
) 
values 
  (
    OLD.id, 
    OLD.age, 
    OLD.job, 
    OLD.marital, 
    OLD.education, 
    OLD.balance, 
    OLD.housing, 
    OLD.loan, 
    OLD.contact, 
    OLD.day, 
    OLD.month, 
    OLD.duration, 
    OLD.campaign, 
    OLD.previous, 
    OLD.poutcome, 
    OLD.deposit, 
    (
      select 
        now() at time zone 'EST'
    )
  );
RETURN NULL;
END;
$BODY$;



/*Create Trigger to execute trigger function*/

CREATE TRIGGER trg_on_delete_customer_data
    AFTER DELETE
    ON hs_customer_prediction
    -- execute the trigger function
    FOR EACH ROW
    EXECUTE PROCEDURE public.trgfunc_insert_cust_history_records();


/*On hs_loan_prediction*/


trigger function :-

CREATE OR REPLACE FUNCTION public.trgfunc_insert_loan_history_records() 
RETURNS trigger LANGUAGE 'plpgsql' COST 100 VOLATILE NOT LEAKPROOF 
AS $BODY$ 
BEGIN Insert into hs_loan_prediction_history(
  loan_id, gender, married, dependents, education, self_employed, 
  applicantincome, coapplicantincome, loanamount, loan_amount_term, credit_history, 
  property_area, loan_status, deletion_time
) 
values 
  (
    OLD.loan_id, 
    OLD.gender, 
    OLD.married, 
    OLD.dependents, 
    OLD.education, 
    OLD.self_employed, 
    OLD.applicantincome, 
    OLD.coapplicantincome, 
    OLD.loanamount, 
    OLD.loan_amount_term, 
    OLD.credit_history, 
    OLD.property_area, 
    OLD.loan_status, 
    (
      select 
        now() at time zone 'EST'
    )
  );
RETURN NULL;
END;
$BODY$;



/*Create Trigger to execute trigger function*/

CREATE TRIGGER trg_on_delete_loan_data
    AFTER DELETE
    ON hs_loan_prediction
    -- execute the trigger function
    FOR EACH ROW
    EXECUTE PROCEDURE public.trgfunc_insert_loan_history_records();