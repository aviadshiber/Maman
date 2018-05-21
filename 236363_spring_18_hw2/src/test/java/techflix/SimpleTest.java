package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;
import techflix.data.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static techflix.business.ReturnValue.OK;

public class SimpleTest extends AbstractTest {

    @Test
    public void simpleTestCreateUser() {
        Solution.clearTables();
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
        v2.setName("aviad");
        v2.setId(2);
        actual = Solution.createViewer(v2);
        assertEquals(OK, actual);
        printTable("viewers");
        actual=Solution.addView(1,1);
        assertEquals(ReturnValue.OK,actual);
        actual=Solution.addView(1,1);
        assertEquals(ReturnValue.ALREADY_EXISTS,actual);
        System.out.println(Solution.addView(1,2).toString());
        printTable("ranks");
        Solution.removeView(1,2);
        actual=Solution.addView(2,1);
        printTable("ranks");
        assertEquals(2,(int)Solution.getMovieViewCount(1));
        System.out.println(Solution.addMovieRating(1,1,MovieRating.LIKE));
        printTable("ranks");
       // System.out.println(Solution.removeMovieRating(1,1));

        assertEquals(1,Solution.getMovieLikesCount(1));
        assertEquals(0,Solution.getMovieDislikesCount(1));
        printTable("ranks");
        printTable("viewers");
        printTable("movies");
        System.out.println("the id of the first viewer how is similar to 1:"+ Solution.getSimilarViewers(1).get(0));
        System.out.println("the id of the first viewer how is similar to 2:"+ Solution.getSimilarViewers(2).get(0));
        System.out.println("most Influencing Viewers:");
        Solution.mostInfluencingViewers().forEach(id -> System.out.println(id));
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
