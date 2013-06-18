package eu.artofcoding.test.glassfish;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/database"})
public class DatabaseServlet extends HttpServlet {

    @EJB
    private Database database;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataSource dataSource = database.getDataSource();
        try (PrintWriter writer = resp.getWriter()) {
            try (Connection conn = dataSource.getConnection()) {
                DatabaseMetaData metaData = conn.getMetaData();
                writer.println(String.format("%s: Database product is %s %s", this.getClass().getName(), metaData.getDatabaseMinorVersion(), metaData.getDatabaseProductVersion()));
            } catch (SQLException e) {
                writer.println("Cannot determine database product");
            }
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
