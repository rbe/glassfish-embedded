package eu.artofcoding.test.glassfish;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class Database {

    @Resource(name = "java:app/jdbc/embeddedDS")
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

}
