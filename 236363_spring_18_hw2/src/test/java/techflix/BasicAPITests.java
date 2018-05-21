package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;

import static org.junit.Assert.assertEquals;
import static techflix.business.ReturnValue.ALREADY_EXISTS;
import static techflix.business.ReturnValue.NOT_EXISTS;
import static techflix.business.ReturnValue.OK;

public class BasicAPITests extends AbstractTest {
    @Test
    public void viewAddOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");

        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(22);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);

        res = Solution.addView(1, 11);
        assertEquals(OK, res);
        res = Solution.addView(2, 11);
        assertEquals(OK, res);
        res = Solution.addView(1, 22);
        assertEquals(OK, res);
        res = Solution.addView(2, 22);
        assertEquals(OK, res);
    }

    @Test
    public void viewAddNotExistsTest() {
        ReturnValue res;
        res = Solution.addView(1, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addView(-1, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addView(1, -11);
        assertEquals(NOT_EXISTS, res);
    }

    @Test
    public void viewAddAlreadyExistsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(22);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);

        res = Solution.addView(2, 11);
        res = Solution.addView(2, 11);
        assertEquals(ALREADY_EXISTS, res);
    }

    @Test
    public void viewRemoveOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);


        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        res = Solution.removeView(1, 11);
        assertEquals(OK, res);
    }

    @Test
    public void viewRemoveNotExistsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);


        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        res = Solution.removeView(345345, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.removeView(1, 345345);
        assertEquals(NOT_EXISTS, res);
        res = Solution.removeView(345345, 345345);
        assertEquals(NOT_EXISTS, res);
        res = Solution.removeView(-1, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.removeView(1, -1);
        assertEquals(NOT_EXISTS, res);
        res = Solution.removeView(1, 11);
        assertEquals(OK, res);
    }

    @Test
    public void viewGetMovieViewCountExistsTest() {
        ReturnValue res;
        int count = -1;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(22);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);

        count = Solution.getMovieViewCount(11);
        assertEquals(0, count);
        res = Solution.addView(1, 11);
        count = Solution.getMovieViewCount(11);
        assertEquals(1, count);
        res = Solution.addView(2, 11);
        count = Solution.getMovieViewCount(11);
        assertEquals(2, count);
        res = Solution.removeView(1, 11);
        count = Solution.getMovieViewCount(11);
        assertEquals(1, count);
        res = Solution.removeView(2, 11);
        count = Solution.getMovieViewCount(11);
        assertEquals(0, count);
    }

    @Test
    public void viewGetMovieViewCountNotExistsTest() {
        ReturnValue res;
        int count = -1;

        count = Solution.getMovieViewCount(11);
        assertEquals(0, count);
        count = Solution.getMovieViewCount(22);
        assertEquals(0, count);

    }

    @Test
    public void viewAddMovieRatingOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(22);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);

        res = Solution.addView(1, 11);
        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        assertEquals(OK, res);
        res = Solution.addView(1, 11);
        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);
        assertEquals(OK, res);
    }

    @Test
    public void viewAddMovieRatingNotExistsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addMovieRating(324234, 11, MovieRating.LIKE);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addMovieRating(1, 324234, MovieRating.LIKE);
        assertEquals(NOT_EXISTS, res);
    }

    @Test
    public void viewRemoveMovieRatingOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        res = Solution.removeMovieRating(1, 11);
        assertEquals(OK, res);
    }

    @Test
    public void viewRemoveMovieRatingNotExistsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.removeMovieRating(1, 11);
        assertEquals(NOT_EXISTS, res);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.removeMovieRating(1, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addView(1, 11);
        res = Solution.removeMovieRating(1, 11);
        assertEquals(NOT_EXISTS, res);
        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        res = Solution.removeMovieRating(1, 11);
        assertEquals(OK, res);
    }

    @Test
    public void viewRemoveMovieRatingIsCorrect(){
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createMovie(movie1);

        res = Solution.addView(1, 11);
        assertEquals(new Integer(1),Solution.getMovieViewCount(11));
        assertEquals(0,Solution.getMovieLikesCount(11));
        assertEquals(0,Solution.getMovieDislikesCount(11));

        res = Solution.removeMovieRating(1, 11);
        assertEquals(new Integer(1),Solution.getMovieViewCount(11));
        assertEquals(0,Solution.getMovieLikesCount(11));
        assertEquals(0,Solution.getMovieDislikesCount(11));

        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        assertEquals(new Integer(1),Solution.getMovieViewCount(11));
        assertEquals(1,Solution.getMovieLikesCount(11));
        assertEquals(0,Solution.getMovieDislikesCount(11));

        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);

        assertEquals(new Integer(1),Solution.getMovieViewCount(11));
        assertEquals(0,Solution.getMovieLikesCount(11));
        assertEquals(1,Solution.getMovieDislikesCount(11));

    }

    @Test
    public void viewGetMovieLikesCountExistsTest() {
        ReturnValue res;
        int count = -1;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);

        count = Solution.getMovieLikesCount(11);
        assertEquals(0, count);
        res = Solution.addView(1, 11);
        count = Solution.getMovieLikesCount(11);
        assertEquals(0, count);
        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);
        count = Solution.getMovieLikesCount(11);
        assertEquals(0, count);

        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        count = Solution.getMovieLikesCount(11);
        assertEquals(1, count);
        res = Solution.addView(2, 11);
        res = Solution.addMovieRating(2, 11, MovieRating.LIKE);
        count = Solution.getMovieLikesCount(11);
        assertEquals(2, count);

        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);
        count = Solution.getMovieLikesCount(11);
        assertEquals(1, count);
        res = Solution.removeMovieRating(2, 11);
        count = Solution.getMovieLikesCount(11);
        assertEquals(0, count);
    }

    @Test
    public void viewGetMovieLikesCountNotExistsTest() {
        ReturnValue res;
        int count = -1;

        count = Solution.getMovieLikesCount(11);
        assertEquals(0, count);
        count = Solution.getMovieLikesCount(22);
        assertEquals(0, count);

    }

    @Test
    public void viewGetMovieDislikesCountExistsTest() {
        ReturnValue res;
        int count = -1;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(11);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createMovie(movie1);

        count = Solution.getMovieDislikesCount(11);
        assertEquals(0, count);
        res = Solution.addView(1, 11);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(0, count);
        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(0, count);

        res = Solution.addMovieRating(1, 11, MovieRating.DISLIKE);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(1, count);
        res = Solution.addView(2, 11);
        res = Solution.addMovieRating(2, 11, MovieRating.DISLIKE);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(2, count);

        res = Solution.addMovieRating(1, 11, MovieRating.LIKE);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(1, count);
        res = Solution.removeMovieRating(2, 11);
        count = Solution.getMovieDislikesCount(11);
        assertEquals(0, count);
    }

    @Test
    public void viewGetMovieDislikesCountNotExistsTest() {
        ReturnValue res;
        int count = -1;

        count = Solution.getMovieDislikesCount(11);
        assertEquals(0, count);
        count = Solution.getMovieDislikesCount(22);
        assertEquals(0, count);

    }

}
