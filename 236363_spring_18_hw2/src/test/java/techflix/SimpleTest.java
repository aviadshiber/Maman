package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.ReturnValue;
import techflix.business.Viewer;
import techflix.data.DBConnector;

import javax.swing.text.View;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static techflix.business.ReturnValue.OK;

public class SimpleTest extends AbstractTest {

    @Test
    public void simpleTestCreateUser() {
        Solution.dropTables();
        Solution.createTables();
        Movie m1 = new Movie();
        m1.setId(1);
        m1.setName("shrek");
        m1.setDescription("stam text");

        Solution.createMovie(m1);
        printTable("movies");
        Movie m2=Solution.getMovie(1);
        assertEquals(m1.getId(), m2.getId());
        assertEquals(m1.getName(), m2.getName());
        assertEquals(Solution.getMovie(100),Movie.badMovie());
        Movie m3 = new Movie();
        m3.setId(2);
        m3.setName("aladin");
        m3.setDescription("stam text");
        Solution.createMovie(m3);
        printTable("movies");
//        Solution.deleteMovie(m3);
//        printTable("movies");
        m3.setDescription("kids movie");
        Solution.updateMovie(m3);
        printTable("movies");



        Viewer viewer1 = new Viewer();
        viewer1.setName("viewer1");
        viewer1.setId(1);
        ReturnValue actual = Solution.createViewer(viewer1);
        assertEquals(OK, actual);
        Viewer v2 = Solution.getViewer(1);
        assertEquals(Solution.getViewer(100),Viewer.badViewer());
        assertEquals(viewer1.getId(), v2.getId());
        assertEquals(viewer1.getName(), v2.getName());
        printTable("viewers");
//        Solution.deleteViewer(viewer1);
//        printTable("viewers");
        v2.setName("shahar");
        Solution.updateViewer(v2);
        printTable("viewers");

        actual=Solution.addView(1,1);
        assertEquals(ReturnValue.OK,actual);
        actual=Solution.addView(1,1);
        assertEquals(ReturnValue.ALREADY_EXISTS,actual);
        printTable("ranks");

    }

    private static void printTable(String table) {
        try (Connection conn = DBConnector.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement("select * from " + table)) {
                DBConnector.printResults(st.executeQuery());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
