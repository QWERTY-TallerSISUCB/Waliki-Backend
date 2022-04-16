-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-04-16 04:18:37.726

-- tables
-- Table: BANK_ACCOUNT
CREATE TABLE BANK_ACCOUNT (
                              id_c_bancaria serial  NOT NULL,
                              account int  NOT NULL,
                              CVS int  NOT NULL,
                              status boolean  NOT NULL,
                              CONSTRAINT BANK_ACCOUNT_pk PRIMARY KEY (id_c_bancaria)
);

-- Table: PRODUCT
CREATE TABLE PRODUCT (
                         product_id serial  NOT NULL,
                         name_product varchar(100)  NOT NULL,
                         stock int  NOT NULL,
                         unit_price decimal(2,2)  NOT NULL,
                         about varchar(100)  NOT NULL,
                         product_type int  NOT NULL,
                         status varchar(20)  NOT NULL,
                         size varchar(10)  NOT NULL,
                         weight int  NOT NULL,
                         CONSTRAINT PRODUCT_pk PRIMARY KEY (product_id)
);

-- Table: PRODUCT_TRANSACTION
CREATE TABLE PRODUCT_TRANSACTION (
                                     p_t_id int  NOT NULL,
                                     product_id_fk int  NOT NULL,
                                     transaction_id_fk int  NOT NULL,
                                     quantity int  NOT NULL,
                                     CONSTRAINT PRODUCT_TRANSACTION_pk PRIMARY KEY (p_t_id)
);

-- Table: TRANSACTION
CREATE TABLE TRANSACTION (
                             transaction_id serial  NOT NULL,
                             date timestamp  NOT NULL,
                             user_id_fk int  NOT NULL,
                             total_cost int  NOT NULL,
                             CONSTRAINT TRANSACTION_pk PRIMARY KEY (transaction_id)
);

-- Table: USER
CREATE TABLE "USER" (
                        user_id serial  NOT NULL,
                        user_name int  NOT NULL,
                        password varchar(100)  NOT NULL,
                        user_type int  NULL DEFAULT 1,
                        address varchar(60)  NOT NULL,
                        bank_account_id_fk int  NOT NULL,
                        person_name int  NOT NULL,
                        email varchar(250)  NOT NULL,
                        CONSTRAINT USER_pk PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: Transaccion_usuario (table: TRANSACTION)
ALTER TABLE TRANSACTION ADD CONSTRAINT Transaccion_usuario
    FOREIGN KEY (user_id_fk)
        REFERENCES "USER" (user_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: productos_transaccion_Transaccion (table: PRODUCT_TRANSACTION)
ALTER TABLE PRODUCT_TRANSACTION ADD CONSTRAINT productos_transaccion_Transaccion
    FOREIGN KEY (transaction_id_fk)
        REFERENCES TRANSACTION (transaction_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: productos_transaccion_producto (table: PRODUCT_TRANSACTION)
ALTER TABLE PRODUCT_TRANSACTION ADD CONSTRAINT productos_transaccion_producto
    FOREIGN KEY (product_id_fk)
        REFERENCES PRODUCT (product_id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: usuario_cuenta_bancaria (table: USER)
ALTER TABLE "USER" ADD CONSTRAINT usuario_cuenta_bancaria
    FOREIGN KEY (bank_account_id_fk)
        REFERENCES BANK_ACCOUNT (id_c_bancaria)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

