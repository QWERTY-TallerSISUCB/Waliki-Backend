-- tables
-- Table: Transaccion
CREATE TABLE Transaccion (
    id_transaccion serial  NOT NULL,
    fecha_hora timestamp  NOT NULL,
    usuario_id_usuario int  NOT NULL,
    costo_total int  NOT NULL,
    CONSTRAINT Transaccion_pk PRIMARY KEY (id_transaccion)
);

-- Table: cuenta_bancaria
CREATE TABLE cuenta_bancaria (
    id_c_bancaria serial  NOT NULL,
    cuenta int  NOT NULL,
    CVS int  NOT NULL,
    exp int  NOT NULL,
    estado boolean  NOT NULL,
    CONSTRAINT cuenta_bancaria_pk PRIMARY KEY (id_c_bancaria)
);

-- Table: persona
CREATE TABLE persona (
    id_persona serial  NOT NULL,
    nombre_completo varchar(100)  NOT NULL,
    fecha_nacimiento varchar(100)  NOT NULL,
    CONSTRAINT persona_pk PRIMARY KEY (id_persona)
);

-- Table: producto
CREATE TABLE producto (
    id_producto serial  NOT NULL,
    nombre_producto varchar(100)  NOT NULL,
    stock int  NOT NULL,
    precio money  NOT NULL,
    caracteristicas varchar(100)  NOT NULL,
    tipo_producto int  NOT NULL,
    disponible boolean  NOT NULL DEFAULT true,
    CONSTRAINT producto_pk PRIMARY KEY (id_producto)
);

-- Table: productos_transaccion
CREATE TABLE productos_transaccion (
    id_producto_transaccion int  NOT NULL,
    producto_id_producto int  NOT NULL,
    Transaccion_id_transaccion int  NOT NULL,
    cantidad int  NOT NULL,
    CONSTRAINT productos_transaccion_pk PRIMARY KEY (id_producto_transaccion)
);

-- Table: usuario
CREATE TABLE usuario (
    id_usuario serial  NOT NULL,
    nombreusuario int  NOT NULL,
    contrasenia varchar(100)  NOT NULL,
    tipo_usuario int  NULL DEFAULT 1,
    persona_id_persona int  NOT NULL,
    direccion varchar(60)  NOT NULL,
    cuenta_bancaria_id_c_bancaria int  NOT NULL,
    CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);

-- foreign keys
-- Reference: Transaccion_usuario (table: Transaccion)
ALTER TABLE Transaccion ADD CONSTRAINT Transaccion_usuario
    FOREIGN KEY (usuario_id_usuario)
    REFERENCES usuario (id_usuario)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: productos_transaccion_Transaccion (table: productos_transaccion)
ALTER TABLE productos_transaccion ADD CONSTRAINT productos_transaccion_Transaccion
    FOREIGN KEY (Transaccion_id_transaccion)
    REFERENCES Transaccion (id_transaccion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: productos_transaccion_producto (table: productos_transaccion)
ALTER TABLE productos_transaccion ADD CONSTRAINT productos_transaccion_producto
    FOREIGN KEY (producto_id_producto)
    REFERENCES producto (id_producto)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: usuario_cuenta_bancaria (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_cuenta_bancaria
    FOREIGN KEY (cuenta_bancaria_id_c_bancaria)
    REFERENCES cuenta_bancaria (id_c_bancaria)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: usuario_persona (table: usuario)
ALTER TABLE usuario ADD CONSTRAINT usuario_persona
    FOREIGN KEY (persona_id_persona)
    REFERENCES persona (id_persona)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

