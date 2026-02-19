# contactoJV_CM_TrabajoBimestral
Trabajo bimestral de Aplicacion Movil, Base de datos SqlLite, con Android Studio.

DESAFÍO DE DESARROLLO ANDROID:
Aplicación Móvil de Gestión de Contactos con Autenticación.
 
DESCRIPCIÓN
Desarrollo de Aplicación Móvil de Gestión de Contactos con Autenticación y Base de Datos Local 
Link: https://github.com/jflvlayaga-oss/contactoJV_CM_TrabajoBimestral.git 

Introducción
Este trabajo bimestral consiste en el desarrollo de una aplicación móvil para la gestión de contactos. La aplicación permite el registro y autenticación de usuarios, así como la administración completa de contactos mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Además, incorpora búsqueda dinámica en tiempo real y control de sesión.
El objetivo principal fue implementar una aplicación funcional con persistencia local de datos, arquitectura estructurada y una interfaz gráfica moderna basada en Material Design 3.
Tecnologías Utilizadas
•	Lenguaje: Kotlin
•	UI: Jetpack Compose
•	Base de datos local: Room (SQLite)
•	Arquitectura: MVVM (Model – View – ViewModel)
•	Navegación: Navigation Compose
•	Programación asíncrona: Coroutines y Flow
•	Diseño: Material3

Arquitectura del Sistema
Se implementó una arquitectura MVVM para separar responsabilidades:
Model
Incluye:
•	Contact (Entidad de contactos)
•	User (Entidad de usuarios)
DAO (Data Access Object)
•	ContactDao
•	UserDao
Estos permiten ejecutar consultas SQL a través de Room.
Database
•	AppDatabase
Administra las entidades y provee acceso a los DAO.
ViewModel
•	ContactViewModel
•	UserViewModel
Se encargan de la lógica de negocio y comunicación entre la base de datos y la interfaz.
UI
Pantallas desarrolladas:
•	Login
•	Registro
•	Lista de contactos
•	Agregar contacto
•	Editar contacto

 
Proyecto:
Creación de Proyecto:

 
Ilustración 1 Nuevo Proyecto en Android Studio
Estructura de nuestra Aplicación:
 
Ilustración 2 Interfaz Android Studio, estructura del proyecto creado.
 
Agregamos nuestra dependencia.
 
Ilustración 3 Dependencias del proyecto.
Crear estructura de navegación
Crear carpeta ui.login
 
Ilustración 4 Creación Carpeta login
Creación archivo LoginScreen.kt
 
Ilustración 5 Nuevo archivo .kt para login

 
Creamos el archivo y editamos los parámetros.
 
Ilustración 6 Creacion pantalla login
Pantalla de login.
 
Ilustración 7 Pantalla del resultado en la creación de login.




Base de datos.
Creamos la entidad Contact dentro de la carpeta data. 
Clase Contact
Creamos la tabla:
contacts
Con columnas:
•	id
•	nombres
•	telefono
•	email
•	empresa

 
Ilustración 8 clase contactos.
 
Creación del DAO (ContactDao), comunicación con la base de datos.

 
Ilustración 9 Comunicación con la base de datos.
Creamos la base de datos SqlLite.
Base de datos contact_database

 
Ilustración 10 Base de datos SqlLite
Creamos la clase ContactViewModel, siendo la capa que conecta la interfaz con la base de datos usando corrutinas y Flow.
 
Ilustración 11 Clase ContactViewModel
Creamos la pantalla que muestra la lista de contactos utilizando LazyColumn y conectándola al ViewModel mediante Flow para que los datos se actualicen automáticamente.
Crear pantalla Agregar Contacto
Creamos la pantalla para agregar nuevos contactos, la conectamos al ViewModel para insertar datos en la base SQLite y configuramos la navegación para movernos entre pantallas
 
Ilustración 12 Pantalla Agregar contacto.
 
Crear entidad User
 
Ilustración 13 Creación entidad user
Modificamos la interfaz user.
 
Ilustración 14 Creación interfaz user.
 
Creamos la clase User
 
Ilustración 15 Creación Clase User
Transformamos LoginScreen para que utilice UserViewModel y valide credenciales contra la base de datos, agregando también un botón de registro y mensajes de error; lo hicimos para implementar autenticación real en lugar de navegación automática y sirve para impedir el acceso si el usuario no existe o la contraseña es incorrecta.
 
Ilustración 16 Funcion de registro de usuario.
Creamos RegisterScreen para permitir crear nuevos usuarios con validación de confirmación de contraseña y conexión al UserViewModel
 
Ilustración 17 Interfaz de registro de usuario.
Luego la conectamos al sistema de navegación, agregamos la ruta.
 
Ilustración 18 Ruta para función de registro
Comprobación Usuario no existe.
 
Ilustración 19 Pantalla login, Usuario no existe
Registro de usuario.
 
Ilustración 20 Pantalla registro de usuario.
Esto crea el usuario que permite el acceso.
 
Ilustración 21 Pantalla login correcto, vista contactos.

 
Opción de búsqueda.

Actualizamos ContactListScreen para conectarla al StateFlow reactivo del ContactViewModel agregando un campo de búsqueda que actualiza dinámicamente la consulta y filtra la lista en tiempo real.
 
Ilustración 22 ContactListScreen, Campo de busqueda
 
Ilustración 23 Pantalla de busqueda.
Realizamos la búsqueda en el emulador.
 
Ilustración 24 Pantalla, resultado busqueda exitosa
Extras:
Cierre de sesión.
Agregamos un TopAppBar con un botón Cerrar sesión que navega a la pantalla de login limpiando el back stack mediante popUpTo inclusivo
 
Ilustración 25 Función de cierre de sesión.
Pantalla Cierre sesión:
 
Ilustración 26 Pantalla contactos con funcion cierre de sesión.
 
Una vez realizado el cierre de sesión regresa al login.
 
Ilustración 27 Pantalla del login.
Extra para Crud con Edit y Delete.
Ampliamos la lista de contactos agregando un menú contextual con opciones de editar y eliminar, conectando la eliminación al ViewModel y creando una nueva pantalla de edición que permite modificar y guardar nuevamente el contacto en la base de datos.
 
Ilustración 28 Función Edit y Detele.
 
Ilustración 29 Flujo de pantallas edición de contacto.
Realizamos la actualización del contacto y verificamos.
 
Ilustración 30 Pantalla Actualización  de contacto realizada.
Opción Eliminar.
 
Ilustración 31 Pantalla de contacto eliminado.


Conclusiones
•	El desarrollo permitió aplicar principios modernos de desarrollo Android, incluyendo arquitectura MVVM, programación reactiva con Flow, persistencia con Room y diseño declarativo con Compose. La aplicación demuestra un correcto manejo de autenticación, gestión de datos y navegación segura.
•	El proyecto cumple con los requisitos funcionales establecidos y presenta una base sólida para futuras mejoras como encriptación de contraseñas, almacenamiento en la nube o integración con API REST.
