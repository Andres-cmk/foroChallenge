# Proyecto API Foro
![Badge-Spring](https://github.com/user-attachments/assets/ba794d99-1a6a-4939-bd23-314bfc41fd98)


![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)

## 📝 Descripción

Este proyecto es una API REST para gestionar un foro de discusión. Proporciona funcionalidad para gestionar usuarios, topicos, respuesta y autenticación basada en JWT. Está desarrollado en Java utilizando el framework Spring Boot y una base de datos MySQL

---

## ✨ Características principales

- ✅ **Gestión de usuarios**: Registro y autenticación de usuarios
- 🔐 **Autenticación**: Sistema basado en JWT para proteger las rutas.
- 📂 **Gestión de topicos**: Crear, listar, actualizar y eliminar temas.
- 💬 **Gestión de respuesas**: Añadir comentarios a los temas.
- 🔒 **Seguridad**: Validación de tokens y control de acceso por roles.
- 📰 **Perfiles**: Crear Perfiles.
- 👨‍🎓 **Cursos**: Creacion de cursos asi como listarlos y demas.

---

## 📋 Requisitos

- ☕ **Java 17** o superior
- 🛠️ **Maven 3.8** o superior
- 🐬 **MySQL**

---

## 🚀 Instalación

1. 📂 Clona este repositorio:
   ```bash
   git clone https://github.com/Andres-cmk/foroChallenge.git
--

## 🛠️ Tecnolgias Usadas
- **Framework**: Spring Boot
- **Base de datos**: MySQL
- **Seguridad**: Spring Security + JWT
- **Validacion**:Startet Validation

--

## 👨‍💻 Aclaraciones
  Para cuando se requiere crear topicos se debe propocionar algunos datos de las relaciones como autor **Usuario** o 
  curso de la entdiad **Curso**. Se implemento para que si no se encuentra registrado, se registre automaticamente sin que
  el cliente lo haga manuelamente.

  Cabe aclarar que no va funcionar en todos los escenearios, lo mejor es que se agreguen datos a las relaciones, es decir, 
  si voy agregar un topico, que al menos haya un usuario registrado en la base, al igual que en curso y perfil.

--

## 👀 Entradas
```
--> Topico: 

{
  "titulo": "Introducción a Spring Boot",
  "status": "Activo",
  "autor": "autor@example.com",
  "curso": "Desarrollo Backend"
}

--> Curso:

{
  "nombre": "Desarrollo Backend",
  "categoria": "Tecnología"
}

{
  "nombre": "Inteligencia Artificial",
  "categoria": "Ciencia de Datos"
}

{
  "nombre": "Gestión de Proyectos",
  "categoria": "Administración"
}

--> Usuario: 

{
  "nombre": "Juan Pérez",
  "correo": "juan.perez@example.com",
  "password": "password123",
  "perfil": [
    {
      "categoria": "Administrador"
    },
    {
      "categoria": "Instructor"
    }
  ]
}

{
  "nombre": "Paola Romero",
  "correo": "paola.romero@example.com",
  "password": "paola1334",
  "perfil": [
    {
      "categoria": "Analista"
    },
    {
      "categoria": "AI"
    }
  ]
}

--> Perfil: 

{
        "per_id": 1,
        "per_categoria": "Analista"

}

{
        "per_id": 2,
        "per_categoria": "AI"
}
{
        "per_id": 3,
        "per_categoria": "Desarrollador Back-end"
}
---
