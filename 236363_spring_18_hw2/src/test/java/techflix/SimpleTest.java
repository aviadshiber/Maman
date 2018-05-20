package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.ReturnValue;
import techflix.business.Viewer;

import static org.junit.Assert.assertEquals;
import static techflix.business.ReturnValue.OK;

public class SimpleTest extends  AbstractTest {

    @Test
    public void simpleTestCreateUser()
    {
        Solution.dropTables();
        Solution.createTables();
        Movie m=new Movie();
        m.setId(1);m.setName("aviad");
        Solution.createMovie(m);
        m=Solution.getMovie(1);
        assertEquals(m.getId(), 1);
//        Viewer viewer1 = new Viewer();
//        viewer1.setName("viewer1");
//        viewer1.setId(1);
//        ReturnValue actual = Solution.createViewer(viewer1);
//        assertEquals(OK, actual);


    }

}
