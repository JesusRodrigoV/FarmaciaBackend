# PersonaBACKEND
### Axl y Andrei 
Requieren:
- [Maven 3](https://maven.apache.org)
- PostgreSQL
Iniciar y hacer correr la clase :
```
src\main\java\com\farmacia\gestion\BackendApplication.java
```
o tambien:
```shell
mvn spring-boot:run
```
Si todo salio correcto, en siguiente archivo :
```
src\main\resources\application.properties
```
Comentar las ultimas tres lineas del archivo
```
#spring.jpa.generate-ddl=true
#spring.jpa.hibernate.ddl-auto=create-drop
#spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```
En postgre y en la base de datos creada farmacia-db ejecutar el archivo datos.sql
```
datos.sql
```
Todo sale correcto y pueden ver datos en el frontend

Frontend se ejecuta con un simple
```
npm install
```
```
ng serve
```

Y listo falta diseño y eso 
Pero por ahora buenas noches

### Running port
- default spring boot config
  http://localhost:8080/

### Swagger url
- default swagger url
  http://localhost:8080/swagger-ui/
