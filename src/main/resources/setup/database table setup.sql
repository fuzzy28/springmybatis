
  CREATE TABLE "M_ROLE" 
   (	"ROLEID" NUMBER NOT NULL ENABLE, 
	"ROLENAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	 CONSTRAINT "M_ROLE_PK" PRIMARY KEY ("ROLEID")
   );
   



  CREATE TABLE "M_USER" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"NAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(20 BYTE), 
	"DEPARTMENTNAME" VARCHAR2(20 BYTE), 
	"EMPLOYEEID" VARCHAR2(20 BYTE), 
	"DELFLAG" NUMBER(1), 
	"CREDATE" VARCHAR2(20 BYTE), 
	"CRETIME" VARCHAR2(20 BYTE), 
	"CREPERSON" VARCHAR2(20 BYTE), 
	"CREPROID" VARCHAR2(20 BYTE), 
	 CONSTRAINT "M_USER_PK" PRIMARY KEY ("ID")
   );
   
   
  CREATE SEQUENCE  "SEQ_M_USER"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


	  CREATE OR REPLACE TRIGGER "TRG_M_USER" 
	BEFORE INSERT ON M_USER
	FOR EACH ROW
	BEGIN
		IF :new.ID IS NULL THEN
			SELECT SEQ_M_USER.nextval INTO :new.ID FROM DUAL;
		END IF;
	END;
			
	/
	ALTER TRIGGER "TRG_M_USER" ENABLE;
	 

  CREATE TABLE "M_USERROLE" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"USERID" NUMBER NOT NULL ENABLE, 
	"ROLEID" NUMBER NOT NULL ENABLE, 
	 CONSTRAINT "M_USERROLE_PK" PRIMARY KEY ("ID"), 
	 CONSTRAINT "M_USERROLE_M_ROLE_FK1" FOREIGN KEY ("ROLEID")
	  REFERENCES "M_ROLE" ("ROLEID") ENABLE, 
	 CONSTRAINT "M_USERROLE_M_USER_FK1" FOREIGN KEY ("USERID")
	  REFERENCES "M_USER" ("ID") ENABLE
   );

   INSERT INTO "M_ROLE" (ROLEID, ROLENAME) VALUES ('1', 'ADMIN');
   INSERT INTO "M_ROLE" (ROLEID, ROLENAME) VALUES ('2', 'USER');
   
   INSERT INTO "M_USER" (NAME, PASSWORD, DEPARTMENTNAME, EMPLOYEEID, DELFLAG) VALUES ('JOEL', '12345', 'SDD1', '123312', '0')
   INSERT INTO "M_USERROLE" (ID, USERID, ROLEID) VALUES ('1', '1', '1')
   COMMIT;