# Microservicios para EduTech Innovators SPA

Este proyecto implementa una arquitectura de microservicios para la plataforma educativa de EduTech Innovators SPA.

## Estructura del Proyecto

El proyecto está organizado en los siguientes microservicios:

- **usuario-service**: Gestión de usuarios (puerto 8001)
- **rol-service**: Gestión de roles (puerto 8002)
- **curso-service**: Gestión de cursos (puerto 8003)
- **permiso-service**: Gestión de permisos (puerto 8080)

## Requisitos

- Java 21
- Maven
- MySQL
- Git

## Configuración de Base de Datos

Antes de ejecutar los servicios, asegúrate de crear las siguientes bases de datos en MySQL:

```sql
CREATE DATABASE usuariosdb;
CREATE DATABASE rolesdb;
CREATE DATABASE cursosdb;
CREATE DATABASE permisosdb;
```

## Ejecución del Proyecto

### Opción 1: Ejecución individual de servicios

1. Clona el repositorio:
   ```
   git clone <url-repositorio>
   cd micro-servicios/code
   ```

2. Para cada servicio (usuario-service, rol-service, curso-service, permiso-service):
   ```
   cd <nombre-servicio>
   mvn clean install
   mvn spring-boot:run
   ```

### Opción 2: Ejecución con script

Puedes usar el script proporcionado para iniciar todos los servicios:

```
./start-services.bat    # Windows
./start-services.sh     # Linux/Mac
```

## Endpoints Disponibles

### Usuario Service (Puerto 8001)

- `GET /usuario`: Listar todos los usuarios
- `GET /usuario/{id}`: Obtener usuario por ID
- `POST /usuario`: Crear nuevo usuario
- `DELETE /usuario/{id}`: Eliminar usuario
- `GET /usuario/rol/{usuarioId}`: Obtener roles de un usuario

### Rol Service (Puerto 8002)

- `GET /rol`: Listar todos los roles
- `GET /rol/{id}`: Obtener rol por ID
- `POST /rol`: Crear nuevo rol
- `GET /rol/usuario/{usuarioId}`: Listar roles por ID de usuario

### Curso Service (Puerto 8003)

- `GET /curso`: Listar todos los cursos
- `GET /curso/{id}`: Obtener curso por ID
- `POST /curso`: Crear nuevo curso
- `PUT /curso/{id}`: Actualizar curso existente
- `DELETE /curso/{id}`: Eliminar curso
- `GET /curso/instructor/{instructorId}`: Listar cursos por instructor
- `GET /curso/categoria/{categoriaId}`: Listar cursos por categoría

### Permiso Service (Puerto 8080)

- `GET /permiso`: Listar todos los permisos
- `GET /permiso/{id}`: Obtener permiso por ID
- `POST /permiso`: Crear nuevo permiso
- `GET /permiso/rol/{rolId}`: Listar permisos por rol
- `POST /permiso/asignar`: Asignar permiso a rol

## Recomendaciones de Clean Code

Para mantener el código limpio y evitar antipatrones:

1. **Separación de responsabilidades**: Mantener la estructura Controller-Service-Repository
2. **Evitar hardcodear URLs**: Usar propiedades configurables
3. **Manejo adecuado de excepciones**: Implementar GlobalExceptionHandler
4. **DTOs para transferencia de datos**: Separar entidades de dominio de objetos de transferencia
5. **Validación de entrada**: Usar Bean Validation (javax.validation)
6. **Documentación de API**: Implementar Swagger/OpenAPI

## Próximos Pasos

- Implementación de API Gateway
- Registro y descubrimiento de servicios con Eureka
- Configuración centralizada con Config Server
- Circuit Breaker con Resilience4j
- Monitoreo con Prometheus y Grafana
