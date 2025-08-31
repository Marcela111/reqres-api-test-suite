Conjunto de pruebas de API de Reqres
Este proyecto contiene un conjunto completo de pruebas automatizadas de API para la API pública reqres.in, desarrolladas utilizando Java, Maven y Rest Assured.

🚀 Empezando
Estas instrucciones te permitirán obtener una copia del proyecto y ejecutarlo en tu máquina local para fines de desarrollo y pruebas.

Requisitos Previos
Java Development Kit (JDK): Versión 17 o superior.

Apache Maven: Versión 3.8.1 o superior.

Git: Para clonar el repositorio.

Instalación
Clona el repositorio:

Intento

git clone https://github.com/tu-usuario/reqres-api-test-suite.git
cd reqres-api-test-suite
Verifica la configuración del proyecto:
Ejecuta el siguiente comando de Maven para asegurarte de que todas las dependencias se descarguen y el proyecto esté configurado correctamente.

Intento

mvn clean install
💻 Cómo Ejecutar las Pruebas
Para ejecutar todo el conjunto de pruebas, utiliza el comando de Maven clean test. Este comando primero limpiará el directorio de salida del proyecto y luego ejecutará todas las pruebas en la carpeta src/test/java.

Intento

mvn clean test
Reportes de Pruebas
Una vez que la ejecución de las pruebas finalice, Maven generará un reporte detallado en el directorio target/surefire-reports. Puedes ver los resultados abriendo el archivo index.html en tu navegador web.

🧪 Estructura del Proyecto
src/test/java/com/mycompany/api/RestAssuredSetup.java: Esta clase contiene la configuración global para Rest Assured, incluyendo la URI base de la API. Asegura que todas las pruebas tengan un punto de partida consistente.

src/test/java/com/mycompany/api/UserApiTests.java: (Este debe ser el nombre de tus clases de prueba, por ejemplo, UserApiGetTests, UserApiPostTests, etc.) Contiene los métodos de prueba reales para los diferentes endpoints de la API, como GET, POST, PUT y DELETE.

pom.xml: El archivo Project Object Model de Maven, que gestiona las dependencias del proyecto (Rest Assured, JUnit) y el ciclo de vida de la construcción.

🛠️ Construido Con
Está seguro- Una potente librería de Java para probar APIs REST.

JUnit 5- El framework de pruebas utilizado para escribir y ejecutar las pruebas.

Experto- Una herramienta de automatización de construcción y gestión de proyectos.