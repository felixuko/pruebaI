PRUEBA TECNICA

Endpoints:

-puntuacion de los anuncios: http://localhost:8080/rating

-listado para los usuarios:  http://localhost:8080/userList

-anuncios para un responsable de calidad: http://localhost:8080/irrelevant


Para este proyecto he utilizado Spring Boot por la facilidad que aporta a la hora de desarrollar aplicaciones web model/vista/controlador, repositorios CRUD y servicios inyectables.

La bbdd es una base de datos emebebida h2 cuyos datos se insertan en cada recarga de contexto a través de la clase AnunciosBootstrap. Existe un listener para los anuncios que se encarga de actualizar el rating en cada insercion/modificacion de estos llamado AnuncioEntityListener.

Para calcular la puntuacion (rating) de los anuncios existe el servicio RatingService, que a su vez se compone de 3 servicios:

-PictureQualityService: calcula la puntuacion asociada a la calidad de las fotos.

-DescriptionQualityService: calcula la puntuacion asociada a la calidad de la descripcion.

-CompletedQualityService: calcula la puntuacion asociada a su completitud.

Para los endpoints se ha usado dos controladores de Spring, uno para los empleados de calidad y otro para los usuarios de idealista:

-QualityController: Es el controlador para los empleados de calidad. Dentro se definen el epoints para rating, que devuelve una lista con todos los anuncios y sus ratings, y el endpoint para los anuncios irrelevantes, que devuelve la lista de todos los anuncios considerados irrelevantes ordenados por fecha

-UserController: Es el controlador para los usuarios de idealista. Dentro contiene el endpoint para el listado de anuncios ordenados por rating (de mayor a menor) y excluyendo los anuncios irrelevantes.


Decisiones tomadas en el desarrollo:
Para implementar la solucion de este ejercicio en un primer momento estableci un servicio que calculaba la puntuacion de los auncios en caliente para cada petición, pero luego decidi que era mejor guardarlo en el modelo de datos puesto que este no responde a agentes externos al propio modelo de datos del anuncio en cuestion. Si en el futuro hubiese agentes externos a dicho calculo (como por ejemplo la hora del dia) se añadiria otro servicio para calcularlo, pero la puntuacion asociada a la informacion del anuncio solo se calcularía en las inserciones/updates.
Al no ser valorada la interfaz gráfica he decido hacer los controladores REST que devolviesen las estructuras de datos en formato JSON indentado para una mejor legibilidad.
La ordenacion en el listado de usuarios se hace en la query porque entiendo que las buquedas se haran con paginacion en un futuro. En el listado de anuncios irrelevantes la ordenacion se hace a posteriori porque no lo he considerado necesario en este caso.
