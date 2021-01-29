# Prevención de SQL Injection

## Objetivos 

- Proporcionar una guía clara, simple y práctica para prevenir fallas de inyección de SQL dentro del backend.
- Definir buenas practicas dentro del proyecto para evitar estos tipos de ataques.

## Defensas

### Validación de datos de entrada

> Garantiza los comandos SQL no sean recibidos ni procesados antes de realizar acciones contra la Base de Datos

El validar la data que es recibida en nuestros endpoints además de evitar fallas en la aplicación y en la Base de Datos, nos permite evitar procesar comandos maliciosos dentro de las consultas que se hacen a la Base de Datos.

*Los siguientes ejemplos muestran una implementación correcta* ✔:

```java
@Data
@Builder
public class CalificacionDTO implements Serializable {
    @Min(value = 1)
    @Max(value = 200)
    private Integer edad;
    @EnumValidator(enumClass = GeneroType.class, message = "invalid sex")
    private String sexo;
}

public enum GeneroType {
    MASCULINO,
    FEMENINO
}
```

*Los siguientes ejemplos muestran una implementación incorrecta* ❌:
```java
@Data
@Builder
public class CalificacionDTO implements Serializable {
    private Integer edad;
    private String sexo; //El atacante podría ingresar comandos sql maliciosos
}
```


### Usar Prepared Statements con consultas parametrizadas

> Garantiza que un atacante no pueda cambiar la intención de una consulta, incluso si inserta comandos SQL

Las consultas parametrizadas nos obliga a definir primero todo el código SQL y luego pasar cada parámetro a la consulta. Este estilo de codificación permite que la base de datos distinga entre código y datos, independientemente de la entrada del usuario.

*Los siguientes ejemplos muestran una implementación correcta* ✔:

```java
@Autowired
private DatabaseClient connection;

/**
* SELECT
**/
connection.sql("select nombre, apellido from persona where id=:id")
.bind("id", parametro1)
.fetch();

/**
* INSERT
**/
connection.sql("insert into persona (nombre, apellido, celular) values (:nombre, :apellido, :celular)")
.bind("nombre", parametro1)
.bind("apellido", parametro2)
.bindNull("celular", String.class) // Especial para datos nulos
.fetch();

/**
* UPDATE
**/
connection.sql("update persona set nombre=:nombre where id=:id")
.bind("nombre", parametro1)
.bind("id", parametro2)
.fetch();

/**
* DELETE
**/
connection.sql("delete from persona where id=:id")
.bind("id", parametro1)
.fetch();

```

*Los siguientes ejemplos muestran una implementación incorrecta* ❌:

```java
@Autowired
private DatabaseClient connection;

/**
* SELECT
**/
connection.sql("select nombre, apellido from persona where id=" + parametro1)
.fetch();

/**
* INSERT
**/
connection.sql("insert into persona (nombre, apellido, celular) values (" + parametro1 + "," + parametro2 + ", NULL)")
.fetch();

/**
* UPDATE
**/
connection.sql("update persona set nombre=" + parametro1 + " where id=" + parametro2)
.fetch();

/**
* DELETE
**/
connection.sql("delete from persona where id=:id")
.bind("id", parametro1)
.fetch();
```

## Referencias

- Paluch, M. J. B. (2020, 16 septiembre). Spring Data R2DBC - Reference Documentation. Recuperado de https://docs.spring.io/spring-data/r2dbc/docs/1.1.4.RELEASE/reference/html/#r2dbc.datbaseclient.binding
- SQL Injection Prevention - OWASP Cheat Sheet Series. (2020). Recuperado de https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html

