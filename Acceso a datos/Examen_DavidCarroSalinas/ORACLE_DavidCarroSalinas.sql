SET SERVEROUTPUT ON;
CREATE TYPE T_DEP AS OBJECT (
    dept_no  number(2) ,
    dnombre  VARCHAR2(15),
    loc      VARCHAR2(15),

    MEMBER FUNCTION GET_DNOMBRE RETURN VARCHAR2;
)
CREATE OR REPLACE TYPE BODY T_DEP AS

    MEMBER FUNCTION GET_DNOMBRE RETURN VARCHAR2 IS
    BEGIN
        RETURN DNOMBRE;
    END;
END;
/

--------------------

CREATE TYPE T_EMP AS OBJECT (
    emp_no    number(4)  ,
    apellido  VARCHAR2(10),
    oficio    VARCHAR2(10),
    dir       number(4),
    fecha_alt DATE      ,
    salario   number(6,2),
    comision  number(6,2),
    dept_no   T_DEP,

    MEMBER FUNCTION GET_APELLIDO RETURN VARCHAR2,
    MEMBER FUNCTION GET_SALARIO RETURN number;

)



CREATE OR REPLACE TYPE BODY T_EMP AS

    MEMBER FUNCTION GET_APELLIDO RETURN VARCHAR2 IS
    BEGIN
        RETURN APELLIDO;
    END;
    MEMBER FUNCTION GET_SALARIO RETURN number IS
    BEGIN
        RETURN SALARIO;
    END;
END;
/

--------------------

CREATE TYPE V_EMPLE AS VARRAY(20) OF T_EMP;

--------------------

CREATE TABLE TAB_DEP (
    depto T_DEP,
    varray V_EMPLE
)

--------------------

create or replace NONEDITIONABLE PROCEDURE INSERFILAS AS 

BEGIN
    DECLARE 
    lista V_EMPLE;
    empleado T_EMP;
    departamento T_DEP;
        BEGIN
            lista := V_EMPLE();

            FOR dep IN (SELECT * FROM departamentos) LOOP
                
                departamento := T_DEP(dep.dept_no, dep.dnombre, dep.loc);

                FOR emp IN (SELECT * FROM empleados E WHERE dep.dept_no = E.dept_no) LOOP
                    lista.EXTEND;
                    empleado := T_EMP(emp.emp_no, emp.apellido, emp.oficio, emp.dir, emp.fecha_alt, emp.salario, emp.comision, departamento);
                    lista(lista.COUNT):= empleado;
                END LOOP;

            INSERT INTO TAB_DEP VALUES (departamento, lista);

            END LOOP;
        END;
END INSERFILAS;

--------------------
SET SERVEROUTPUT ON;
DECLARE
    CURSOR C IS SELECT * FROM TAB_DEP;
    depto T_DEP;
    lista V_EMPLE;
BEGIN
    lista := V_EMPLE();
    FOR I IN C LOOP
        depto := I.depto;
        DBMS_OUTPUT.PUT_LINE('Departamento: ' || depto.GET_DNOMBRE);
        lista := I.varray;
        FOR j IN 1..lista.COUNT LOOP
            DBMS_OUTPUT.PUT_LINE('Empleado: ' || lista(j).GET_APELLIDO || ', ' || lista(j).GET_SALARIO);
        END LOOP;
    END LOOP;
END;
/
