-- Ejercicio 8:

SET SERVEROUTPUT ON;

CREATE TYPE TABLA_ANIDADA AS TABLE OF DIRECCION;

CREATE TABLE EJ_TABLA_ANIDADA (
ID NUMBER(2),
APELLIDOS VARCHAR2(35),
DIREC TABLA_ANIDADA )
NESTED TABLE DIREC STORE AS DIREC_ANIDADA;




INSERT INTO EJ_TABLA_ANIDADA (ID, APELLIDOS, DIREC)
VALUES (1, 'García', TABLA_ANIDADA(
    DIRECCION('Calle Mayor 123', 'Madrid', 28001),
    DIRECCION('Calle Sol 45', 'Barcelona', 08002),
    DIRECCION('Avda Libertad 22', 'Salamanca', 37001),
    DIRECCION('Calle Gran Vía 89', 'Sevilla', 41002),
    DIRECCION('P. Castellana 100', 'Salamanca', 37004)
));


INSERT INTO EJ_TABLA_ANIDADA (ID, APELLIDOS, DIREC)
VALUES (2, 'Martínez', TABLA_ANIDADA(
    DIRECCION('Plaza Cataluña 1', 'Barcelona', 08001),
    DIRECCION('Avenida Diagonal 100', 'Barcelona', 08003),
    DIRECCION('Calle Mayor 10', 'Madrid', 28013),
    DIRECCION('Calle Serrano 55', 'Salamanca', 28006),
    DIRECCION('Calle Gran Vía 150', 'Madrid', 28013)
));


INSERT INTO EJ_TABLA_ANIDADA (ID, APELLIDOS, DIREC)
VALUES (3, 'López', TABLA_ANIDADA(
    DIRECCION('Avda Argentina 15', 'Sevilla', 41011),
    DIRECCION('Calle Tetuán 30', 'Valencia', 46002),
    DIRECCION('Calle San Fernando 10', 'Sevilla', 41004),
    DIRECCION('Calle Colón 20', 'Valencia', 46004),
    DIRECCION('Avenida del Puerto 5', 'Valencia', 46021)
));

-- Identificador, apellidos y dirección completa de todas las filas de la tabla.
SELECT TA.ID, TA.APELLIDOS, D.CALLE AS CALLE, D.CIUDAD AS CIUDAD, D.COD_POSTAL AS COD_POSTAL 
FROM EJ_TABLA_ANIDADA TA,
TABLE(TA.DIREC) D;

-- Calles de la fila cuyo ID es 1 cuya ciudad sea Salamanca.

SELECT DIREC.CALLE
FROM EJ_TABLA_ANIDADA ta
JOIN TABLE(ta.direc) DIREC ON ta.ID = 1 AND DIREC.CIUDAD = 'Salamanca';

-- Todos los datos de las direcciones del ID 2.

SELECT DIREC.CALLE, DIREC.CIUDAD, DIREC.COD_POSTAL
FROM EJ_TABLA_ANIDADA ta
JOIN TABLE(ta.direc) DIREC ON ta.ID = 2;


-- Número de direcciones que tiene en cada ciudad el ID 1.

SELECT CIUDAD, COUNT(*) AS NUMERO_DIRECCIONES
FROM EJ_TABLA_ANIDADA ta
JOIN TABLE(ta.direc) DIREC ON ta.ID = 1 
GROUP BY CIUDAD;

--Ciudad con más direcciones que tiene el ID 1.

SELECT CIUDAD
FROM (
    SELECT CIUDAD, COUNT(*) AS NUMERO_DIRECCIONES
    FROM EJ_TABLA_ANIDADA ta
    JOIN TABLE(ta.direc) DIREC ON ta.ID = 1 
    GROUP BY CIUDAD
    ORDER BY COUNT(*) DESC
)
FETCH FIRST ROW ONLY;

-- Bloque PL/SQL que muestra el nombre de las calles de cada Apellidos.

DECLARE
    v_apellidos VARCHAR2(35);
BEGIN
    FOR rec IN (SELECT APELLIDOS, DIREC.CALLE
                FROM EJ_TABLA_ANIDADA, TABLE(DIREC) DIREC)
    LOOP
        DBMS_OUTPUT.PUT_LINE('Apellido: ' || rec.APELLIDOS || ', Calle: ' || rec.CALLE);
    END LOOP;
END;
/



-- Ejercicio 9:

CREATE OR REPLACE PROCEDURE INSERTAR_DIRECCION(
    identificador IN NUMBER,
    direccion IN DIRECCION
)
IS
    v_count NUMBER;
BEGIN
    -- Comprobar el identificador
    SELECT COUNT(*)
    INTO v_count
    FROM EJ_TABLA_ANIDADA
    WHERE ID = identificador;

    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('El identificador no existe.');
        RETURN;
    END IF;

    -- Comprobar si la tabla anidada no es null y si lo es hacer update y no insert
    SELECT COUNT(*)
    INTO v_count
    FROM EJ_TABLA_ANIDADA
    WHERE ID = identificador AND DIREC IS NOT NULL;

    IF v_count = 0 THEN
        
        UPDATE EJ_TABLA_ANIDADA
        SET DIREC = TABLA_ANIDADA(direccion)
        WHERE ID = identificador;
        DBMS_OUTPUT.PUT_LINE('Se actualizó la dirección existente.');
    ELSE
        -- Se comprueba la dirección
        SELECT COUNT(*)
        INTO v_count
        FROM EJ_TABLA_ANIDADA E
        JOIN TABLE(E.DIREC) D
        ON E.ID = identificador AND D.CALLE = direccion.CALLE AND D.CIUDAD = direccion.CIUDAD AND D.COD_POSTAL = direccion.COD_POSTAL;

        IF v_count > 0 THEN
            DBMS_OUTPUT.PUT_LINE('La dirección ya existe en la tabla.');
        ELSE
            -- Se inserta la dirección
            INSERT INTO TABLE(SELECT DIREC FROM EJ_TABLA_ANIDADA WHERE ID = identificador)
            VALUES (direccion);
            DBMS_OUTPUT.PUT_LINE('Se ha insertado la dirección correctamente.');
        END IF;
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/