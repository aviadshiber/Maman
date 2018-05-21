package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;

import static org.junit.Assert.assertEquals;

public class AdditionalTests extends AbstractTest {
    @Test
    public void onDeleteCascadeViewerTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        assertEquals(new Integer(1), Solution.getMovieViewCount(11));

        res = Solution.deleteViewer(viewer1);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));
    }

    @Test
    public void onDeleteCascadeMovieTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        assertEquals(new Integer(1), Solution.getMovieViewCount(11));

        res = Solution.deleteMovie(movie1);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));
    }

    @Test
    public void onDeleteViewDeleteRatingTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        assertEquals(new Integer(1), Solution.getMovieViewCount(11));
        res = Solution.removeView(1, 11);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));

        res = Solution.addView(1, 11);
        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        assertEquals(1, Solution.getMovieLikesCount(11));
        res = Solution.removeView(1, 11);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));
        assertEquals(0, Solution.getMovieLikesCount(11));

        res = Solution.addView(1, 11);
        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);
        assertEquals(1, Solution.getMovieDislikesCount(11));
        res = Solution.removeView(1, 11);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));
        assertEquals(0, Solution.getMovieDislikesCount(11));
    }

    @Test
    public void viewOnlyOnceTest(){
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        assertEquals(new Integer(1), Solution.getMovieViewCount(11));
        res = Solution.addView(1, 11);
        assertEquals(new Integer(1), Solution.getMovieViewCount(11));
        res = Solution.removeView(1, 11);
        assertEquals(new Integer(0), Solution.getMovieViewCount(11));
    }

}
