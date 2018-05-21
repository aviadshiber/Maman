package techflix;

import org.junit.Test;
import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdvancedAPITests extends AbstractTest {
    @Test
    public void getSimilarViewersTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Itamar_loves_bamba");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Guy6");
        viewer2.setId(2);

        Viewer viewer3 = new Viewer();
        viewer3.setName("Elad");
        viewer3.setId(3);

        Viewer viewer4 = new Viewer();
        viewer4.setName("Damn Daniel");
        viewer4.setId(4);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Mayhem at the library");
        movie2.setDescription("Nowhere to sit");
        movie2.setId(22);

        Movie movie3 = new Movie();
        movie3.setName("Zack and Miri make a compiler");
        movie3.setDescription("Romance/Comedy");
        movie3.setId(33);

        Movie movie4 = new Movie();
        movie4.setName("Infinitesimal war");
        movie4.setDescription("for every epsilon there exists a delta...");
        movie4.setId(44);

        Movie movie5 = new Movie();
        movie5.setName("Dude, where is Omer Adam ?");
        movie5.setDescription("Festival in chaos");
        movie5.setId(55);

        Movie movie6 = new Movie();
        movie6.setName("The Matrix");
        movie6.setDescription("Transpose !");
        movie6.setId(66);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createViewer(viewer3);
        res = Solution.createViewer(viewer4);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);
        res = Solution.createMovie(movie3);
        res = Solution.createMovie(movie4);
        res = Solution.createMovie(movie5);
        res = Solution.createMovie(movie6);

        res = Solution.addView(1, 11);
        res = Solution.addView(1, 22);
        res = Solution.addView(1, 33);
        res = Solution.addView(1, 44);

        res = Solution.addView(2, 11);
        res = Solution.addView(2, 44);
        res = Solution.addView(2, 55);

        res = Solution.addView(3, 11);
        res = Solution.addView(3, 33);
        res = Solution.addView(3, 44);
        res = Solution.addView(3, 55);

        ArrayList<Integer> itamarsList = Solution.getSimilarViewers(1);
        assertEquals(new Integer(3), itamarsList.get(0));
        ArrayList<Integer> guysList = Solution.getSimilarViewers(2);
        assertEquals(new Integer(3), guysList.get(0));
        ArrayList<Integer> eladsList = Solution.getSimilarViewers(3);
        assertEquals(new Integer(1), eladsList.get(0));
        assertEquals(new Integer(2), eladsList.get(1));
        ArrayList<Integer> damnDanielslist = Solution.getSimilarViewers(4);
        assertEquals(0, damnDanielslist.size());

    }

    @Test
    public void mostInfluencingViewersTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Ned Stark");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Robert Baratheon");
        viewer2.setId(2);

        Viewer viewer3 = new Viewer();
        viewer3.setName("Jaime Lannister");
        viewer3.setId(3);

        Viewer viewer4 = new Viewer();
        viewer4.setName("Cersei Lannister");
        viewer4.setId(4);

        Viewer viewer5 = new Viewer();
        viewer5.setName("Daenerys Targaryen");
        viewer5.setId(5);

        Viewer viewer6 = new Viewer();
        viewer6.setName("Jorah Mormont");
        viewer6.setId(6);

        Viewer viewer7 = new Viewer();
        viewer7.setName("Littlerfinger");
        viewer7.setId(7);

        Viewer viewer8 = new Viewer();
        viewer8.setName("Viserys Targaryen");
        viewer8.setId(8);

        Viewer viewer9 = new Viewer();
        viewer9.setName("Jon Snow");
        viewer9.setId(9);

        Viewer viewer10 = new Viewer();
        viewer10.setName("Sansa Stark");
        viewer10.setId(10);

        Viewer viewer11 = new Viewer();
        viewer11.setName("Arya Stark");
        viewer11.setId(11);

        Viewer viewer12 = new Viewer();
        viewer12.setName("Robb Stark");
        viewer12.setId(12);

        Viewer viewer13 = new Viewer();
        viewer13.setName("Theon Greyjoy");
        viewer13.setId(13);

        Viewer viewer14 = new Viewer();
        viewer14.setName("Bran Stark");
        viewer14.setId(14);

        Viewer viewer15 = new Viewer();
        viewer15.setName("Joffrey Baratheon");
        viewer15.setId(15);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(11);

        Movie movie2 = new Movie();
        movie2.setName("Mayhem at the library");
        movie2.setDescription("Nowhere to sit");
        movie2.setId(22);

        Movie movie3 = new Movie();
        movie3.setName("Zack and Miri make a compiler");
        movie3.setDescription("Romance/Comedy");
        movie3.setId(33);

        Movie movie4 = new Movie();
        movie4.setName("Infinitesimal war");
        movie4.setDescription("for every epsilon there exists a delta...");
        movie4.setId(44);

        Movie movie5 = new Movie();
        movie5.setName("Dude, where is Omer Adam ?");
        movie5.setDescription("Festival in chaos");
        movie5.setId(55);

        Movie movie6 = new Movie();
        movie6.setName("The Matrix");
        movie6.setDescription("Transpose !");
        movie6.setId(66);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createViewer(viewer3);
        res = Solution.createViewer(viewer4);
        res = Solution.createViewer(viewer5);
        res = Solution.createViewer(viewer6);
        res = Solution.createViewer(viewer7);
        res = Solution.createViewer(viewer8);
        res = Solution.createViewer(viewer9);
        res = Solution.createViewer(viewer10);
        res = Solution.createViewer(viewer11);
        res = Solution.createViewer(viewer12);
        res = Solution.createViewer(viewer13);
        res = Solution.createViewer(viewer14);
        res = Solution.createViewer(viewer15);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);
        res = Solution.createMovie(movie3);
        res = Solution.createMovie(movie4);
        res = Solution.createMovie(movie5);
        res = Solution.createMovie(movie6);

        res = Solution.addView(15, 11);
        res = Solution.addView(15, 22);
        res = Solution.addView(15, 33);
        res = Solution.addView(15, 44);
        res = Solution.addMovieRating(15, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(15, 22, MovieRating.DISLIKE);
        res = Solution.addMovieRating(15, 33, MovieRating.DISLIKE);

        res = Solution.addView(13, 33);
        res = Solution.addView(13, 44);
        res = Solution.addView(13, 55);
        res = Solution.addView(13, 66);
        res = Solution.addMovieRating(13, 33, MovieRating.LIKE);
        res = Solution.addMovieRating(13, 44, MovieRating.LIKE);

        res = Solution.addView(14, 33);
        res = Solution.addView(14, 44);
        res = Solution.addView(14, 55);
        res = Solution.addView(14, 66);
        res = Solution.addMovieRating(14, 33, MovieRating.LIKE);
        res = Solution.addMovieRating(14, 44, MovieRating.LIKE);

        res = Solution.addView(7, 33);
        res = Solution.addView(7, 44);
        res = Solution.addView(7, 55);
        res = Solution.addMovieRating(7, 33, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 44, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 55, MovieRating.LIKE);

        res = Solution.addView(6, 33);
        res = Solution.addView(6, 44);
        res = Solution.addView(6, 55);
        res = Solution.addMovieRating(6, 33, MovieRating.DISLIKE);
        res = Solution.addMovieRating(6, 44, MovieRating.DISLIKE);
        res = Solution.addMovieRating(6, 55, MovieRating.DISLIKE);

        res = Solution.addView(1, 33);
        res = Solution.addView(1, 44);
        res = Solution.addView(1, 55);
        res = Solution.addMovieRating(1, 33, MovieRating.LIKE);

        res = Solution.addView(8, 44);
        res = Solution.addView(8, 55);
        res = Solution.addView(8, 66);
        res = Solution.addMovieRating(8, 55, MovieRating.DISLIKE);

        res = Solution.addView(9, 44);

        ArrayList<Integer> lst = Solution.mostInfluencingViewers();
        assertEquals(new Integer(15), lst.get(0));
        assertEquals(new Integer(13), lst.get(1));
        assertEquals(new Integer(14), lst.get(2));
        assertEquals(new Integer(6), lst.get(3));
        assertEquals(new Integer(7), lst.get(4));
        assertEquals(new Integer(1), lst.get(5));
        assertEquals(new Integer(8), lst.get(6));
        assertEquals(new Integer(9), lst.get(7));
    }

    @Test
    public void getMoviesRecommendationsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Ned Stark");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Robert Baratheon");
        viewer2.setId(2);

        Viewer viewer3 = new Viewer();
        viewer3.setName("Jaime Lannister");
        viewer3.setId(3);

        Viewer viewer4 = new Viewer();
        viewer4.setName("Cersei Lannister");
        viewer4.setId(4);

        Viewer viewer5 = new Viewer();
        viewer5.setName("Daenerys Targaryen");
        viewer5.setId(5);

        Viewer viewer6 = new Viewer();
        viewer6.setName("Jorah Mormont");
        viewer6.setId(6);

        Viewer viewer7 = new Viewer();
        viewer7.setName("Littlerfinger");
        viewer7.setId(7);

        Viewer viewer8 = new Viewer();
        viewer8.setName("Viserys Targaryen");
        viewer8.setId(8);

        Viewer viewer9 = new Viewer();
        viewer9.setName("Jon Snow");
        viewer9.setId(9);

        Viewer viewer10 = new Viewer();
        viewer10.setName("Sansa Stark");
        viewer10.setId(10);

        Viewer viewer11 = new Viewer();
        viewer11.setName("Arya Stark");
        viewer11.setId(11);

        Viewer viewer12 = new Viewer();
        viewer12.setName("Robb Stark");
        viewer12.setId(12);

        Viewer viewer13 = new Viewer();
        viewer13.setName("Theon Greyjoy");
        viewer13.setId(13);

        Viewer viewer14 = new Viewer();
        viewer14.setName("Bran Stark");
        viewer14.setId(14);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Mayhem at the library");
        movie2.setDescription("Nowhere to sit");
        movie2.setId(2);

        Movie movie3 = new Movie();
        movie3.setName("Zack and Miri make a compiler");
        movie3.setDescription("Romance/Comedy");
        movie3.setId(3);

        Movie movie4 = new Movie();
        movie4.setName("Infinitesimal war");
        movie4.setDescription("for every epsilon there exists a delta...");
        movie4.setId(4);

        Movie movie5 = new Movie();
        movie5.setName("Dude, where is Omer Adam ?");
        movie5.setDescription("Festival in chaos");
        movie5.setId(5);

        Movie movie6 = new Movie();
        movie6.setName("The Matrix");
        movie6.setDescription("Transpose !");
        movie6.setId(6);

        Movie movie7 = new Movie();
        movie7.setName("Börek and the beast");
        movie7.setDescription("Gedara's Börek");
        movie7.setId(7);

        Movie movie8 = new Movie();
        movie8.setName("Tinky Winky Land");
        movie8.setDescription("Revenge of the Sun Baby");
        movie8.setId(8);

        Movie movie9 = new Movie();
        movie9.setName("Grown Downs");
        movie9.setDescription("Atuda");
        movie9.setId(9);

        Movie movie10 = new Movie();
        movie10.setName("The Lord of the Pings");
        movie10.setDescription("ping -c 1 127.0.0.1 ; echo $?");
        movie10.setId(10);

        Movie movie11 = new Movie();
        movie11.setName("Iron Meh 3");
        movie11.setDescription("Because I'm Batman");
        movie11.setId(11);

        Movie movie12 = new Movie();
        movie12.setName("The Dark Night");
        movie12.setDescription("Matam 3 submission is upon us");
        movie12.setId(12);

        Movie movie13 = new Movie();
        movie13.setName("Log(n)");
        movie13.setDescription("His time has come");
        movie13.setId(13);

        Movie movie14 = new Movie();
        movie14.setName("Die Hard : P=NP");
        movie14.setDescription("Nobody can find the answer. Will John McClane succeed ?");
        movie14.setId(14);

        Movie movie15 = new Movie();
        movie15.setName("Deadly Transpose");
        movie15.setDescription("Starring : Algebra 1 Staff");
        movie15.setId(15);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createViewer(viewer3);
        res = Solution.createViewer(viewer4);
        res = Solution.createViewer(viewer5);
        res = Solution.createViewer(viewer6);
        res = Solution.createViewer(viewer7);
        res = Solution.createViewer(viewer8);
        res = Solution.createViewer(viewer9);
        res = Solution.createViewer(viewer10);
        res = Solution.createViewer(viewer11);
        res = Solution.createViewer(viewer12);
        res = Solution.createViewer(viewer13);
        res = Solution.createViewer(viewer14);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);
        res = Solution.createMovie(movie3);
        res = Solution.createMovie(movie4);
        res = Solution.createMovie(movie5);
        res = Solution.createMovie(movie6);
        res = Solution.createMovie(movie7);
        res = Solution.createMovie(movie8);
        res = Solution.createMovie(movie9);
        res = Solution.createMovie(movie10);
        res = Solution.createMovie(movie11);
        res = Solution.createMovie(movie12);
        res = Solution.createMovie(movie13);
        res = Solution.createMovie(movie14);
        res = Solution.createMovie(movie15);

        res = Solution.addView(1, 3);
        res = Solution.addView(1, 6);
        res = Solution.addView(1, 8);
        res = Solution.addView(1, 15);

        res = Solution.addView(2, 3);
        res = Solution.addView(2, 5);
        res = Solution.addView(2, 7);
        res = Solution.addView(2, 8);
        res = Solution.addView(2, 9);
        res = Solution.addView(2, 12);
        res = Solution.addView(2, 15);

        res = Solution.addView(3, 3);
        res = Solution.addView(3, 4);
        res = Solution.addView(3, 7);
        res = Solution.addView(3, 8);
        res = Solution.addView(3, 9);
        res = Solution.addView(3, 11);
        res = Solution.addView(3, 15);

        res = Solution.addView(4, 3);
        res = Solution.addView(4, 5);
        res = Solution.addView(4, 7);
        res = Solution.addView(4, 8);
        res = Solution.addView(4, 9);
        res = Solution.addView(4, 15);

        res = Solution.addView(5, 6);
        res = Solution.addView(5, 7);
        res = Solution.addView(5, 8);
        res = Solution.addView(5, 11);
        res = Solution.addView(5, 13);
        res = Solution.addView(5, 15);

        res = Solution.addView(6, 3);
        res = Solution.addView(6, 5);
        res = Solution.addView(6, 6);
        res = Solution.addView(6, 7);
        res = Solution.addView(6, 8);
        res = Solution.addView(6, 9);
        res = Solution.addView(6, 13);
        res = Solution.addView(6, 14);

        res = Solution.addView(7, 3);
        res = Solution.addView(7, 5);
        res = Solution.addView(7, 6);
        res = Solution.addView(7, 8);
        res = Solution.addView(7, 9);
        res = Solution.addView(7, 15);

        res = Solution.addView(8, 4);
        res = Solution.addView(8, 6);
        res = Solution.addView(8, 7);
        res = Solution.addView(8, 8);
        res = Solution.addView(8, 12);
        res = Solution.addView(8, 13);
        res = Solution.addView(8, 15);

        res = Solution.addView(9, 1);
        res = Solution.addView(9, 3);
        res = Solution.addView(9, 6);
        res = Solution.addView(9, 7);
        res = Solution.addView(9, 8);
        res = Solution.addView(9, 13);

        res = Solution.addView(10, 3);
        res = Solution.addView(10, 4);
        res = Solution.addView(10, 7);
        res = Solution.addView(10, 8);
        res = Solution.addView(10, 10);
        res = Solution.addView(10, 14);
        res = Solution.addView(10, 15);

        res = Solution.addView(11, 3);
        res = Solution.addView(11, 5);
        res = Solution.addView(11, 6);
        res = Solution.addView(11, 8);
        res = Solution.addView(11, 11);
        res = Solution.addView(11, 12);
        res = Solution.addView(11, 14);

        res = Solution.addView(12, 3);
        res = Solution.addView(12, 6);
        res = Solution.addView(12, 8);
        res = Solution.addView(12, 11);
        res = Solution.addView(12, 12);
        res = Solution.addView(12, 15);

        res = Solution.addView(13, 1);
        res = Solution.addView(13, 5);
        res = Solution.addView(13, 6);
        res = Solution.addView(13, 8);


        res = Solution.addMovieRating(1, 8, MovieRating.LIKE);

        res = Solution.addMovieRating(2, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(3, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(3, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(3, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(4, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(5, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(5, 7, MovieRating.DISLIKE);
        res = Solution.addMovieRating(5, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(6, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 7, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(6, 6, MovieRating.DISLIKE);

        res = Solution.addMovieRating(7, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(7, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(7, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(8, 4, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 6, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(9, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(9, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(10, 4, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 10, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(10, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(11, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 6, MovieRating.DISLIKE);

        res = Solution.addMovieRating(12, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(12, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(12, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 8, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(13, 1, MovieRating.LIKE);
        res = Solution.addMovieRating(13, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(13, 8, MovieRating.LIKE);

        ArrayList<Integer> lst1 = Solution.getMoviesRecommendations(1);
        System.out.println("getMoviesRecommendations ids are:");
        lst1.forEach(id-> System.out.println(id));
        assertEquals(new Integer(9), lst1.get(0));
        assertEquals(new Integer(5), lst1.get(1));
        assertEquals(new Integer(12), lst1.get(2));
        assertEquals(new Integer(11), lst1.get(3));
        assertEquals(new Integer(13), lst1.get(4));
        assertEquals(new Integer(14), lst1.get(5));
        assertEquals(new Integer(4), lst1.get(6));
        assertEquals(new Integer(7), lst1.get(7));
        assertEquals(new Integer(10), lst1.get(8));
        assertEquals(new Integer(1), lst1.get(9));

        ArrayList<Integer> lst2 = Solution.getMoviesRecommendations(2);
        assertEquals(0, lst2.size());

        ArrayList<Integer> lst3 = Solution.getMoviesRecommendations(3);
        assertEquals(0, lst3.size());

        ArrayList<Integer> lst4 = Solution.getMoviesRecommendations(4);
        assertEquals(new Integer(12), lst4.get(0));
        assertEquals(new Integer(13), lst4.get(1));
        assertEquals(new Integer(14), lst4.get(2));
        assertEquals(new Integer(4), lst4.get(3));
        assertEquals(new Integer(6), lst4.get(4));
        assertEquals(new Integer(11), lst4.get(5));

        ArrayList<Integer> lst5 = Solution.getMoviesRecommendations(5);
        assertEquals(new Integer(4), lst5.get(0));
        assertEquals(new Integer(12), lst5.get(1));

        ArrayList<Integer> lst6 = Solution.getMoviesRecommendations(6);
        assertEquals(0, lst6.size());

        ArrayList<Integer> lst7 = Solution.getMoviesRecommendations(7);
        assertEquals(new Integer(7), lst7.get(0));
        assertEquals(new Integer(12), lst7.get(1));
        assertEquals(new Integer(13), lst7.get(2));
        assertEquals(new Integer(14), lst7.get(3));

        ArrayList<Integer> lst8 = Solution.getMoviesRecommendations(8);
        assertEquals(0, lst8.size());

        ArrayList<Integer> lst9 = Solution.getMoviesRecommendations(9);
        assertEquals(new Integer(5), lst9.get(0));
        assertEquals(new Integer(9), lst9.get(1));
        assertEquals(new Integer(14), lst9.get(2));

        ArrayList<Integer> lst10 = Solution.getMoviesRecommendations(10);
        assertEquals(0, lst10.size());

        ArrayList<Integer> lst11 = Solution.getMoviesRecommendations(11);
        assertEquals(0, lst11.size());

        ArrayList<Integer> lst12 = Solution.getMoviesRecommendations(12);
        assertEquals(new Integer(14), lst12.get(0));
        assertEquals(new Integer(5), lst12.get(1));

        ArrayList<Integer> lst13 = Solution.getMoviesRecommendations(13);
        assertEquals(new Integer(9), lst13.get(0));
        assertEquals(new Integer(14), lst13.get(1));
        assertEquals(new Integer(7), lst13.get(2));
        assertEquals(new Integer(11), lst13.get(3));
        assertEquals(new Integer(12), lst13.get(4));
        assertEquals(new Integer(13), lst13.get(5));
        assertEquals(new Integer(3), lst13.get(6));
        assertEquals(new Integer(15), lst13.get(7));

        ArrayList<Integer> lst14 = Solution.getMoviesRecommendations(14);
        assertEquals(0, lst14.size());

    }

    @Test
    public void getConditionalRecommendationsTest() {
        ReturnValue res;
        Viewer viewer1 = new Viewer();
        viewer1.setName("Ned Stark");
        viewer1.setId(1);

        Viewer viewer2 = new Viewer();
        viewer2.setName("Robert Baratheon");
        viewer2.setId(2);

        Viewer viewer3 = new Viewer();
        viewer3.setName("Jaime Lannister");
        viewer3.setId(3);

        Viewer viewer4 = new Viewer();
        viewer4.setName("Cersei Lannister");
        viewer4.setId(4);

        Viewer viewer5 = new Viewer();
        viewer5.setName("Daenerys Targaryen");
        viewer5.setId(5);

        Viewer viewer6 = new Viewer();
        viewer6.setName("Jorah Mormont");
        viewer6.setId(6);

        Viewer viewer7 = new Viewer();
        viewer7.setName("Littlerfinger");
        viewer7.setId(7);

        Viewer viewer8 = new Viewer();
        viewer8.setName("Viserys Targaryen");
        viewer8.setId(8);

        Viewer viewer9 = new Viewer();
        viewer9.setName("Jon Snow");
        viewer9.setId(9);

        Viewer viewer10 = new Viewer();
        viewer10.setName("Sansa Stark");
        viewer10.setId(10);

        Viewer viewer11 = new Viewer();
        viewer11.setName("Arya Stark");
        viewer11.setId(11);

        Viewer viewer12 = new Viewer();
        viewer12.setName("Robb Stark");
        viewer12.setId(12);

        Viewer viewer13 = new Viewer();
        viewer13.setName("Theon Greyjoy");
        viewer13.setId(13);

        Viewer viewer14 = new Viewer();
        viewer14.setName("Bran Stark");
        viewer14.setId(14);

        Movie movie1 = new Movie();
        movie1.setName("Kalkar Kid");
        movie1.setDescription("Starring Najeeb Chan");
        movie1.setId(1);

        Movie movie2 = new Movie();
        movie2.setName("Mayhem at the library");
        movie2.setDescription("Nowhere to sit");
        movie2.setId(2);

        Movie movie3 = new Movie();
        movie3.setName("Zack and Miri make a compiler");
        movie3.setDescription("Romance/Comedy");
        movie3.setId(3);

        Movie movie4 = new Movie();
        movie4.setName("Infinitesimal war");
        movie4.setDescription("for every epsilon there exists a delta...");
        movie4.setId(4);

        Movie movie5 = new Movie();
        movie5.setName("Dude, where is Omer Adam ?");
        movie5.setDescription("Festival in chaos");
        movie5.setId(5);

        Movie movie6 = new Movie();
        movie6.setName("The Matrix");
        movie6.setDescription("Transpose !");
        movie6.setId(6);

        Movie movie7 = new Movie();
        movie7.setName("Börek and the beast");
        movie7.setDescription("Gedara's Börek");
        movie7.setId(7);

        Movie movie8 = new Movie();
        movie8.setName("Tinky Winky Land");
        movie8.setDescription("Revenge of the Sun Baby");
        movie8.setId(8);

        Movie movie9 = new Movie();
        movie9.setName("Grown Downs");
        movie9.setDescription("Atuda");
        movie9.setId(9);

        Movie movie10 = new Movie();
        movie10.setName("The Lord of the Pings");
        movie10.setDescription("ping -c 1 127.0.0.1 ; echo $?");
        movie10.setId(10);

        Movie movie11 = new Movie();
        movie11.setName("Iron Meh 3");
        movie11.setDescription("Because I'm Batman");
        movie11.setId(11);

        Movie movie12 = new Movie();
        movie12.setName("The Dark Night");
        movie12.setDescription("Matam 3 submission is upon us");
        movie12.setId(12);

        Movie movie13 = new Movie();
        movie13.setName("Log(n)");
        movie13.setDescription("His time has come");
        movie13.setId(13);

        Movie movie14 = new Movie();
        movie14.setName("Die Hard : P=NP");
        movie14.setDescription("Nobody can find the answer. Will John McClane succeed ?");
        movie14.setId(14);

        Movie movie15 = new Movie();
        movie15.setName("Deadly Transpose");
        movie15.setDescription("Starring : Algebra 1 Staff");
        movie15.setId(15);

        res = Solution.createViewer(viewer1);
        res = Solution.createViewer(viewer2);
        res = Solution.createViewer(viewer3);
        res = Solution.createViewer(viewer4);
        res = Solution.createViewer(viewer5);
        res = Solution.createViewer(viewer6);
        res = Solution.createViewer(viewer7);
        res = Solution.createViewer(viewer8);
        res = Solution.createViewer(viewer9);
        res = Solution.createViewer(viewer10);
        res = Solution.createViewer(viewer11);
        res = Solution.createViewer(viewer12);
        res = Solution.createViewer(viewer13);
        res = Solution.createViewer(viewer14);
        res = Solution.createMovie(movie1);
        res = Solution.createMovie(movie2);
        res = Solution.createMovie(movie3);
        res = Solution.createMovie(movie4);
        res = Solution.createMovie(movie5);
        res = Solution.createMovie(movie6);
        res = Solution.createMovie(movie7);
        res = Solution.createMovie(movie8);
        res = Solution.createMovie(movie9);
        res = Solution.createMovie(movie10);
        res = Solution.createMovie(movie11);
        res = Solution.createMovie(movie12);
        res = Solution.createMovie(movie13);
        res = Solution.createMovie(movie14);
        res = Solution.createMovie(movie15);

        res = Solution.addView(1, 3);
        res = Solution.addView(1, 6);
        res = Solution.addView(1, 8);
        res = Solution.addView(1, 15);

        res = Solution.addView(2, 3);
        res = Solution.addView(2, 5);
        res = Solution.addView(2, 7);
        res = Solution.addView(2, 8);
        res = Solution.addView(2, 9);
        res = Solution.addView(2, 12);
        res = Solution.addView(2, 15);

        res = Solution.addView(3, 3);
        res = Solution.addView(3, 4);
        res = Solution.addView(3, 7);
        res = Solution.addView(3, 8);
        res = Solution.addView(3, 9);
        res = Solution.addView(3, 11);
        res = Solution.addView(3, 15);

        res = Solution.addView(4, 3);
        res = Solution.addView(4, 5);
        res = Solution.addView(4, 7);
        res = Solution.addView(4, 8);
        res = Solution.addView(4, 9);
        res = Solution.addView(4, 15);

        res = Solution.addView(5, 6);
        res = Solution.addView(5, 7);
        res = Solution.addView(5, 8);
        res = Solution.addView(5, 11);
        res = Solution.addView(5, 13);
        res = Solution.addView(5, 15);

        res = Solution.addView(6, 3);
        res = Solution.addView(6, 5);
        res = Solution.addView(6, 6);
        res = Solution.addView(6, 7);
        res = Solution.addView(6, 8);
        res = Solution.addView(6, 9);
        res = Solution.addView(6, 13);
        res = Solution.addView(6, 14);

        res = Solution.addView(7, 3);
        res = Solution.addView(7, 5);
        res = Solution.addView(7, 6);
        res = Solution.addView(7, 8);
        res = Solution.addView(7, 9);
        res = Solution.addView(7, 15);

        res = Solution.addView(8, 4);
        res = Solution.addView(8, 6);
        res = Solution.addView(8, 7);
        res = Solution.addView(8, 8);
        res = Solution.addView(8, 12);
        res = Solution.addView(8, 13);
        res = Solution.addView(8, 15);

        res = Solution.addView(9, 1);
        res = Solution.addView(9, 3);
        res = Solution.addView(9, 6);
        res = Solution.addView(9, 7);
        res = Solution.addView(9, 8);
        res = Solution.addView(9, 13);

        res = Solution.addView(10, 3);
        res = Solution.addView(10, 4);
        res = Solution.addView(10, 7);
        res = Solution.addView(10, 8);
        res = Solution.addView(10, 10);
        res = Solution.addView(10, 14);
        res = Solution.addView(10, 15);

        res = Solution.addView(11, 3);
        res = Solution.addView(11, 5);
        res = Solution.addView(11, 6);
        res = Solution.addView(11, 8);
        res = Solution.addView(11, 11);
        res = Solution.addView(11, 12);
        res = Solution.addView(11, 14);

        res = Solution.addView(12, 3);
        res = Solution.addView(12, 6);
        res = Solution.addView(12, 8);
        res = Solution.addView(12, 11);
        res = Solution.addView(12, 12);
        res = Solution.addView(12, 15);

        res = Solution.addView(13, 1);
        res = Solution.addView(13, 5);
        res = Solution.addView(13, 6);
        res = Solution.addView(13, 8);


        res = Solution.addMovieRating(1, 8, MovieRating.LIKE);

        res = Solution.addMovieRating(2, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(2, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(3, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(3, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(3, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(4, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(4, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(5, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(5, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(5, 7, MovieRating.DISLIKE);
        res = Solution.addMovieRating(5, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(6, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 7, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(6, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(6, 6, MovieRating.DISLIKE);

        res = Solution.addMovieRating(7, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 9, MovieRating.LIKE);
        res = Solution.addMovieRating(7, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(7, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(7, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(8, 4, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 6, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 13, MovieRating.LIKE);
        res = Solution.addMovieRating(8, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(9, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(9, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(10, 4, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 10, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(10, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(10, 7, MovieRating.DISLIKE);

        res = Solution.addMovieRating(11, 8, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 14, MovieRating.LIKE);
        res = Solution.addMovieRating(11, 6, MovieRating.DISLIKE);

        res = Solution.addMovieRating(12, 11, MovieRating.LIKE);
        res = Solution.addMovieRating(12, 12, MovieRating.LIKE);
        res = Solution.addMovieRating(12, 3, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 6, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 8, MovieRating.DISLIKE);
        res = Solution.addMovieRating(12, 15, MovieRating.DISLIKE);

        res = Solution.addMovieRating(13, 1, MovieRating.LIKE);
        res = Solution.addMovieRating(13, 5, MovieRating.LIKE);
        res = Solution.addMovieRating(13, 8, MovieRating.LIKE);
        SimpleTest.printTable("viewers");
        SimpleTest.printTable("movies");
        SimpleTest.printTable("ranks");
        ArrayList<Integer> lst1_8 = Solution.getConditionalRecommendations(1, 8);
        System.out.println("getConditionalRecommendations ids are:");
        lst1_8.forEach(id-> System.out.println(id));
        assertEquals(new Integer(9), lst1_8.get(0));
        assertEquals(new Integer(5), lst1_8.get(1));
        assertEquals(new Integer(12), lst1_8.get(2));
        assertEquals(new Integer(13), lst1_8.get(3));
        assertEquals(new Integer(14), lst1_8.get(4));
        assertEquals(new Integer(4), lst1_8.get(5));
        assertEquals(new Integer(11), lst1_8.get(6));
        assertEquals(new Integer(7), lst1_8.get(7));
        assertEquals(new Integer(10), lst1_8.get(8));
        assertEquals(new Integer(1), lst1_8.get(9));

        ArrayList<Integer> lst1_9 = Solution.getConditionalRecommendations(1, 9);
        assertEquals(0, lst1_9.size());

        ArrayList<Integer> lst2_8 = Solution.getConditionalRecommendations(2, 8);
        assertEquals(0, lst2_8.size());

        ArrayList<Integer> lst4_7 = Solution.getConditionalRecommendations(4, 7);
        assertEquals(3, lst4_7.size());
        assertEquals(new Integer(12), lst4_7.get(0));
        assertEquals(new Integer(4), lst4_7.get(1));
        assertEquals(new Integer(11), lst4_7.get(2));

        ArrayList<Integer> lst5_6 = Solution.getConditionalRecommendations(5, 6);
        ArrayList<Integer> lst5_11 = Solution.getConditionalRecommendations(5, 11);
        ArrayList<Integer> lst5_12 = Solution.getConditionalRecommendations(5, 12);
        assertEquals(0, lst5_6.size());
        assertEquals(0, lst5_11.size());
        assertEquals(0, lst5_12.size());


        ArrayList<Integer> lst7_3 = Solution.getConditionalRecommendations(7, 3);
        assertEquals(3, lst7_3.size());
        assertEquals(new Integer(7), lst7_3.get(0));
        assertEquals(new Integer(13), lst7_3.get(1));
        assertEquals(new Integer(14), lst7_3.get(2));

        ArrayList<Integer> lst13_1 = Solution.getConditionalRecommendations(13, 1);
        assertEquals(0, lst13_1.size());


    }

}
