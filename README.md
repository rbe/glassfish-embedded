# glassfish-embedded

Test of embedded GlassFish 4 using Maven 3

## Run

First build project and start GlassFish:

    $ mvn package embedded-glassfish:run

Point your browser to

    http://localhost:8282/glassfish-embedded

Start a MySQL on localhost:3306, for connection details see `src/main/webapp/WEB-INF/glassfish-resources.xml`
and point your browser to

    http://localhost:8282/glassfish-embedded/database

Have fun.
