# Sistema de Gestión Odontológico 🦷

Sistema backend desarrollado para la administración integral de un consultorio odontológico, permitiendo gestionar pacientes, odontólogos y turnos de manera eficiente, segura y escalable.

El proyecto fue diseñado siguiendo buenas prácticas de desarrollo backend con una arquitectura limpia basada en Spring Boot, aplicando validaciones de negocio para evitar conflictos de horarios y optimizar la organización del consultorio.

---

# 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot 4
- Maven
- MySQL
- Docker
- Docker Compose

---

# 📌 Características Principales

## 👨‍⚕️ Gestión de Odontólogos
- Registro, modificación y eliminación de odontólogos
- Asignación de horarios laborales
- Control de disponibilidad
- Prevención de solapamientos de horarios

## 🧑‍🤝‍🧑 Gestión de Pacientes
- Registro completo de pacientes
- Actualización de información personal
- Asociación de cobertura médica
- Consulta de datos del paciente

## 📅 Gestión de Turnos
- Creación y administración de turnos
- Validación automática de disponibilidad
- Asociación entre paciente y odontólogo
- Control de horarios ocupados

## ✅ Validaciones de Negocio
- Restricción de turnos duplicados
- Prevención de conflictos de horarios
- Validaciones de integridad de datos
- Manejo de errores y respuestas controladas

---

# 🏗️ Arquitectura y Diseño

El proyecto fue desarrollado utilizando:

- Arquitectura en capas (MVC)
- Patrón DTO para transferencia segura de datos
- REST API
- Separación de responsabilidades
- Buenas prácticas en organización de código

---

# 🐳 Docker y Despliegue

La aplicación cuenta con configuración completa para despliegue utilizando Docker.

Incluye:
- `Dockerfile`
- `docker-compose.yml`
- Variables de entorno configurables
- Base de datos MySQL containerizada

Esto permite levantar el entorno completo de forma rápida y sencilla.

---

# ⚙️ Configuración del Proyecto

## Clonar el repositorio

```bash
git clone https://github.com/santiagozerda/SistemaDeGestionOdontologico.git
```

## Acceder al proyecto

```bash
cd SistemaDeGestionOdontologico
```

## Configurar variables de entorno

Ejemplo:

```env
DB_URL=you_url_database
DB_USER_NAME=you_username
DB_PASSWORD=you_password
```

## Levantar contenedores

```bash
docker compose up --build
```

---

# 📂 Estructura General

```bash
src
 ┣ 📂 controller
 ┣ 📂 service
 ┣ 📂 repository
 ┣ 📂 dto
 ┣ 📂 entity
 ┣ 📂 config
 ┗ 📂 exception
```

---

# 🔮 Mejoras Futuras

- Implementación de autenticación y autorización con Spring Security + JWT
- Historial clínico odontológico
- Gestión de roles y permisos
- Documentación con Swagger/OpenAPI
- Tests unitarios e integración
- Deploy cloud

---

# 💡 Desafío Técnico

Uno de los principales desafíos fue implementar una lógica robusta de validación de horarios para evitar solapamientos en la asignación de turnos y horarios laborales de los odontólogos, garantizando la integridad de la información y una correcta disponibilidad dentro del sistema.

---

# 📖 Objetivo del Proyecto

Este proyecto fue desarrollado como práctica avanzada de backend orientada a escenarios reales de negocio, aplicando principios de escalabilidad, organización y mantenimiento de software.

---

# 👨‍💻 Autor

Desarrollado por Santiago Zerda

- GitHub: https://github.com/santiagozerda
- Repositorio: https://github.com/santiagozerda/SistemaDeGestionOdontologico.git
