package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.ReturnValue;
import techflix.business.Viewer;

import static org.junit.Assert.assertEquals;
import static techflix.business.ReturnValue.*;

public class CrudAPITests extends AbstractTest {
    @Test
    public void viewerCreateOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        res = Solution.createViewer(viewer1);
        assertEquals(OK, res);
        res = Solution.createViewer(viewer2);
        assertEquals(OK, res);
    }

    @Test
    public void viewerCreateBadParamsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(-1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(0);

        Viewer viewer3 = new Viewer();
        viewer3.setName(null);
        viewer3.setId(1);

        res = Solution.createViewer(viewer1);
        assertEquals(BAD_PARAMS, res);
        res = Solution.createViewer(viewer2);
        assertEquals(BAD_PARAMS, res);
        res = Solution.createViewer(viewer3);
        assertEquals(BAD_PARAMS, res);
    }

    @Test
    public void viewerCreateAlreadyExistsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(1);

        res = Solution.createViewer(viewer1);
        assertEquals(OK, res);
        res = Solution.createViewer(viewer2);
        assertEquals(ALREADY_EXISTS, res);
    }

    @Test
    public void viewerGetOKTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        res = Solution.createViewer(viewer1);
        Viewer retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
    }

    @Test
    public void viewerGetBadViewerTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        res = Solution.createViewer(viewer1);
        retViewer = Solution.getViewer(2);
        assertEquals(Viewer.badViewer(), retViewer);
        retViewer = Solution.getViewer(-1);
        assertEquals(Viewer.badViewer(), retViewer);
    }

    @Test
    public void viewerDeleteOKTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        res = Solution.createViewer(viewer1);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
        res = Solution.deleteViewer(viewer1);
        assertEquals(OK, res);
        retViewer = Solution.getViewer(1);
        assertEquals(Viewer.badViewer(), retViewer);
    }

    @Test
    public void viewerDeleteNotExistsTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        res = Solution.createViewer(viewer1);
        res = Solution.deleteViewer(viewer2);
        assertEquals(NOT_EXISTS, res);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
    }

    @Test
    public void viewerUpdateOKTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(1);

        res = Solution.createViewer(viewer1);
        res = Solution.updateViewer(viewer2);
        assertEquals(OK, res);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer2, retViewer);
    }

    @Test
    public void viewerUpdateNotExistsTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        res = Solution.createViewer(viewer1);
        res = Solution.updateViewer(viewer2);
        assertEquals(NOT_EXISTS, res);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
    }

    @Test
    public void viewerUpdatePrecedenceTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName(null);
        viewer2.setId(2);

        res = Solution.createViewer(viewer1);
        res = Solution.updateViewer(viewer2);
        assertEquals(NOT_EXISTS, res);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
    }

    @Test
    public void viewerUpdateBadParamsTest() {
        ReturnValue res;
        Viewer retViewer;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName(null);
        viewer2.setId(1);

        res = Solution.createViewer(viewer1);
        res = Solution.updateViewer(viewer2);
        assertEquals(BAD_PARAMS, res);
        retViewer = Solution.getViewer(1);
        assertEquals(viewer1, retViewer);
    }

    @Test
    public void movieCreateOKTest() {
        ReturnValue res;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(2);

        res = Solution.createMovie(movie1);
        assertEquals(OK, res);
        res = Solution.createMovie(movie2);
        assertEquals(OK, res);
    }

    @Test
    public void movieCreateBadParamsTest() {
        ReturnValue res;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(-1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(0);

        Movie movie3 = new Movie();
        movie3.setName(null);
        movie3.setDescription("Step 1: funko pop");
        movie3.setId(1);

        Movie movie4 = new Movie();
        movie4.setName("How to spend 700k");
        movie4.setDescription(null);
        movie4.setId(1);

        res = Solution.createMovie(movie1);
        assertEquals(BAD_PARAMS, res);
        res = Solution.createMovie(movie2);
        assertEquals(BAD_PARAMS, res);
        res = Solution.createMovie(movie3);
        assertEquals(BAD_PARAMS, res);
        res = Solution.createMovie(movie4);
        assertEquals(BAD_PARAMS, res);
    }

    @Test
    public void movieCreateAlreadyExistsTest() {
        ReturnValue res;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(1);

        res = Solution.createMovie(movie1);
        assertEquals(OK, res);
        res = Solution.createMovie(movie2);
        assertEquals(ALREADY_EXISTS, res);
    }

    @Test
    public void movieGetOKTest() {
        ReturnValue res;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        res = Solution.createMovie(movie1);
        Movie retMovie = Solution.getMovie(1);
        assertEquals(movie1, retMovie);
    }

    @Test
    public void movieGetBadMovieTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        res = Solution.createMovie(movie1);
        retMovie = Solution.getMovie(2);
        assertEquals(Movie.badMovie(), retMovie);
        retMovie = Solution.getMovie(-1);
        assertEquals(Movie.badMovie(), retMovie);
    }

    @Test
    public void movieDeleteOKTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        res = Solution.createMovie(movie1);
        res = Solution.deleteMovie(movie1);
        assertEquals(OK, res);
        retMovie = Solution.getMovie(1);
        assertEquals(Movie.badMovie(), retMovie);
    }

    @Test
    public void movieDeleteNotExistsTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(2);

        res = Solution.createMovie(movie1);
        res = Solution.deleteMovie(movie2);
        assertEquals(NOT_EXISTS, res);
        retMovie = Solution.getMovie(1);
        assertEquals(movie1, retMovie);
    }

    @Test
    public void movieUpdateOKTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(1);

        res = Solution.createMovie(movie1);
        res = Solution.updateMovie(movie2);
        assertEquals(OK, res);
        retMovie = Solution.getMovie(1);
        assertEquals(movie2.getDescription(), retMovie.getDescription());
        assertEquals(movie1.getName(), retMovie.getName());
    }

    @Test
    public void movieUpdateNotExistsTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");

        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription("As sure as Kilimanjaro rises like Olympus above the Serengeti");
        movie2.setId(2);

        res = Solution.createMovie(movie1);
        res = Solution.updateMovie(movie2);
        assertEquals(NOT_EXISTS, res);
        retMovie = Solution.getMovie(1);
        assertEquals(movie1, retMovie);
    }

    @Test
    public void movieUpdatePrecedenceTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription(null);
        movie2.setId(2);

        res = Solution.createMovie(movie1);
        res = Solution.updateMovie(movie2);
        assertEquals(NOT_EXISTS, res);
        retMovie = Solution.getMovie(1);
        assertEquals(movie1, retMovie);
    }

    @Test
    public void movieUpdateBadParamsTest() {
        ReturnValue res;
        Movie retMovie;
        Movie movie1 = new Movie();
        movie1.setName("How to spend 700k");
        movie1.setDescription("Step 1: funko pop");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Toto by Africa - Documentary");
        movie2.setDescription(null);
        movie2.setId(1);

        res = Solution.createMovie(movie1);
        res = Solution.updateMovie(movie2);
        assertEquals(BAD_PARAMS, res);
        retMovie = Solution.getMovie(1);
        assertEquals(movie1, retMovie);
    }

}
