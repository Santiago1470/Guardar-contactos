# Guardar-contactos

Proyecto desarrollado en Java y con MySQL, es un programa para guardar contactos y almacenarlos en bases de datos para un mayor ordenamiento y mejor acceso a los datos. Programa desarrollado de forma independiente y con el propósito de practicar de acuerdo a los conocimientos adquiridos hasta el momento.

¿Qué hay dentro del proyecto al momento de descargarlo?
Al momento de descargar el proyecto habrán dos archivos principales, los cuales son:
1. BDPersonas: es un archivo .sql, el cual contiene las líneas para crear la base de datos correspondiente y la tabla para listar los contactos creados al usar el programa.
2. ConsultarPersonas/ConsultaPersonas: es la carpeta que contendrá todo el proyecto Java, y dentro de la carpeta "src" estará el código fuente principal del programa.

¿Cómo usarlo?
1. En el archivo BDPersonas están las líneas para crear lo correspondiente a la base de datos, se deben ejecutar las tres primeras líneas del archivo y en el orden en el que se encuentran, desde arriba hacia abajo.
2. Para ejecutar el programa se debe importar en algún IDE o editor de código y con el respectivo JDK y JRE.
2. Al momento de tener creada la base de datos, se debe ejecutar el programa y allí se pedirá el respectivo enlace o URL de la base de datos. Ejemplo: jdbc:mysql://localhost:3306/personas?autoRecinnet=true&useSSL=false . También, se pedirá el usuario y la respectiva contraseña de la base de datos a la que se quiere conectar de acuerdo al enlace o URL escrito.
3. Al ejecutar el programa y ya conectada de forma correcta la base de datos, se podrá hacer uso de las opciones de "AGREGAR", "MODIFICAR" y "ELIMINAR".
4. Para hacer uso de la opción "AGREGAR" simplemente será necesario escribir los datos de la persona que se desea agregar.
5. Para hacer uso de las opciones "MODIFICAR" y "ELIMINAR" se debe primero buscar en la parte derecha de la pantalla según la identificación, número de teléfono o correo electrónico, la búsqueda debe ser exacta, es decir, si hay un contacto con identificación: 1234567890, entonces se debe buscar por identificación y en el campo para escribir debe ir: 1234567890, cuando se le dé "BUSCAR" se buscará el contacto con ese filtro y automáticamente se rellenarán los datos para eliminar o modificar el contacto seleccionado.
