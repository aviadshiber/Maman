package techflix;

import org.junit.*;

import static org.junit.Assert.*;
import static techflix.business.MovieRating.*;
import static techflix.business.ReturnValue.*;
import techflix.business.*;
import static techflix.Solution.*;

import java.util.ArrayList;

public class DBRandomTest_1000Operations
{
    @BeforeClass
    public static void createTables()
    {
        Solution.dropTables();
        Solution.createTables();
    }

    @AfterClass
    public static void dropTables()
    {
        Solution.dropTables();
    }
    
    

    public void test1()
    {
        ReturnValue returnValue;
        Viewer returnedViewer, viewerObj;
        Movie returnedMovie, movieObj;
        int returnedInt;
        ArrayList<Integer> returnedArrayList;
        
		returnValue = addView(61126814, 45858531);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(86868227, 87123232);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(11375436, 89292656);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(14666258);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(15341973, 45062357);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(19599767);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(76027762);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(61240054, 93580079);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("GA30NZORE6KKUVIYMOR1");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(35756246, 18333466);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(35756246, 31167937);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("6SWDSE5YEAUDCNSTW6EC");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(35756246, 99997485);
		assertEquals(0, returnedArrayList.size());

		returnedMovie = getMovie(34199703);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedInt = getMovieLikesCount(77179617);
		assertEquals(0, returnedInt);

		returnValue = addMovieRating(35756246, 99550294, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("B4EREPORF8XXP56LWNR9"); movieObj.setDescription("394WKC156DIL2JXFKHMS");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(35756246, 39105221, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieLikesCount(39105221);
		assertEquals(0, returnedInt);

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("1QH08M56JMYU8B6JR16M"); movieObj.setDescription(null);
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("D1HVL12OHA2GJSDROKVM");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("70POLJNAG9Y36RIEJQ7N");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(35756246, 39105221);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(35756246, 39105221, DISLIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(35756246, 39105221, DISLIKE);
		assertEquals(OK, returnValue);

		returnValue = addView(35756246, 39105221);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(35756246, 39105221, DISLIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("J94YIXV09RAXU4K365M6");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(35756246, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(35756246, 39105221, LIKE);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("L601OC4TTUWZRT1MNJC7"); movieObj.setDescription("HPBL5TLQRBUTRDENQL82");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("9ATFKCW94K359380GZNY");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(35756246, 15490939);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnedInt = getMovieViewCount(15490939);
		assertEquals(0, returnedInt);

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setDescription("MZ2MQUQVCXOTJB5GK6S2");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("AU5ISCQ4N8LPNJ2PT1WJ"); movieObj.setDescription(null);
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(35756246, 15490939, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(73618722, 39105221);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(35756246, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(35756246, 39105221, LIKE);
		assertEquals(OK, returnValue);

		returnedMovie = getMovie(58952908);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("4D7MFT7TMP2PIB0GOQRH"); movieObj.setDescription("0P9QTX6R6A6ACVN36AC1");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("EMPND3RUMZNX5VFHJ0O7");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = removeView(35756246, 39105221);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setDescription("R1KVEWW3Q8REU23I79HW");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(35756246, 39105221);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69613227);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(35756246);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(51072185, 89862928);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35756246), returnedArrayList.get(0));

		returnValue = addView(35756246, 39105221);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(35756246);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(35756246); viewerObj.setName("R9JLYCWHRZ84S1TA6PV0");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(18859073); viewerObj.setName("DZG212XENO2UH4NW32K9");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(18859073);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(18859073);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(18859073);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(18859073); viewerObj.setName("2B0XPQKWVGKKIV0ID6C2");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("L601OC4TTUWZRT1MNJC7"); movieObj.setDescription("R1KVEWW3Q8REU23I79HW");
		returnedMovie = getMovie(15490939);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = getMoviesRecommendations(18859073);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(18859073); viewerObj.setName("I5SYFZ6I6OIG4WRNL7IF");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedInt = getMovieViewCount(15490939);
		assertEquals(0, returnedInt);

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("2KYEQJC20L40K3AZZRAM"); movieObj.setDescription("TJRZ70FNEVHTCZKGMHXT");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(18859073, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(18859073, 15490939);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(18859073);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(18859073); viewerObj.setName("I5SYFZ6I6OIG4WRNL7IF");
		returnedViewer = getViewer(18859073);
		assertEquals(viewerObj, returnedViewer);

		returnValue = addMovieRating(18859073, 39105221, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(18859073);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(18859073, 39105221);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(18859073); viewerObj.setName("1WXA900OKMQM7PTPVQ8V");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(13229328); viewerObj.setName("1Y0QTOWKJ2XNW7H5OFT9");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("3ZQ8D5H8Q5C9LINHQP2K"); movieObj.setDescription("ZFRXRI6PHMYA8CH66JMI");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(10016353, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(64242120, 15490939);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(3156864);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(34855218);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(39105221);
		assertEquals(0, returnedInt);

		returnedArrayList = getMoviesRecommendations(89730325);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(63740780);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(15490939);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("27F8R89X82LV32JFHQSZ");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("4U7B0R6X39DF4OX6O132");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("CTTOPLIZ572G47H4HBUN");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(80255060, 39105221);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("B4EREPORF8XXP56LWNR9"); movieObj.setDescription("MZ2MQUQVCXOTJB5GK6S2");
		returnedMovie = getMovie(39105221);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(80255060, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(80255060, 39105221);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("RCTAQO43CE2JM63BZPZP"); movieObj.setDescription("YMVDVHBV4LT8Z69ULPOE");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("JWYXD3J5LJL4I7YFLWV3");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(80255060, 39105221);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("NQLJ77CIT4EED8CDCJ8B");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(80255060, 15490939, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(80255060, 15490939);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("SK0U4OH3H38F6WUWRGTV");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("ZIKTOQTRZST0M40W4228");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedInt = getMovieViewCount(39105221);
		assertEquals(1, returnedInt);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(39105221);
		assertEquals(0, returnedInt);

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(39809139, 39105221);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("TRYADTV8ZTCW77V5U2QB");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(0));

		returnedArrayList = getConditionalRecommendations(80255060, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(39105221);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(39809139, 39105221);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("FXS2UZ3LAH148W5IR8RI");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(80255060, 39105221);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("XHBFQO7FJGCVKAOPYO7L");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("4OUSUWZU8RYKUCLKZCCA"); movieObj.setDescription("KZXZ0W86J67DLH1TAN2A");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(39809139, 39105221);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39105221); movieObj.setName("0TE8ZECAW0QYV5VN5OIE"); movieObj.setDescription("N4NYINLDIZ70HJROXAMU");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(80255060, 15490939, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(39809139, 15490939);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(80255060, 15490939, DISLIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("BGORVQLTR3JSFYPCTO8C");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("3AXIQJDL98JMOMOPC872");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(39809139, 15490939, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(2, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(1));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(2, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(1));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(2, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(1));

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("YDGBU0L7PGN409N9REYT");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(80255060), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(80255060, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(21900675, 15490939);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("38RUDSR36NPCBD4WULRU");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(80255060, 15490939);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("F3E9TN8QVF75EHPJ1LC6"); movieObj.setDescription("QYJ62SROR2OM8QWRE4ZS");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(80255060, 15490939);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("D0T8SVA7F9HUEXJPEMQT");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("EPX4667HT9B5TNQPO8G3");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("W4QCEXI8Q8JG98C8KXVF");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		returnedArrayList = getConditionalRecommendations(39809139, 64550066);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(39809139, 15490939);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = removeMovieRating(39809139, 10895254);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("27F8R89X82LV32JFHQSZ");
		returnedViewer = getViewer(80255060);
		assertEquals(viewerObj, returnedViewer);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("UF6YFCI89DUXZFD3P76H");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("ZIKTOQTRZST0M40W4228");
		returnedViewer = getViewer(39809139);
		assertEquals(viewerObj, returnedViewer);

		returnValue = addView(80255060, 56407118);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(39809139, 15490939);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(80255060);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(80255060, 15490939);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(80255060);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(80255060); viewerObj.setName("6VN0N1GKBQND6U4NQV0B");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(39809139, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(39809139, 15490939);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(15490939);
		assertEquals(1, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("ZIKTOQTRZST0M40W4228");
		returnedViewer = getViewer(39809139);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		returnedInt = getMovieLikesCount(15490939);
		assertEquals(1, returnedInt);

		returnValue = addView(39809139, 15490939);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(39809139, 15490939);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(15490939); movieObj.setName("0KOKG2D2DLJRSZHDMDWB"); movieObj.setDescription("5134K9SYJ7N20I3HDB6K");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(39809139, 54496953, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("SE08HE0KD7AM81VFPHFF");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(94047759); movieObj.setDescription("SRA51CZEBLIF7QBV7TTA");
		returnValue = updateMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeMovieRating(39809139, 89328318);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(39809139);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("FK7OONTPML99EMQI0HD8");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedInt = getMovieLikesCount(72768388);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(39809139, 43145379);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(39809139, 17260702, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(65324748); movieObj.setName("AHRT3F4ORBN6G2XPHW7K"); movieObj.setDescription("35WZ6W5NAHYK8LQ7DZOX");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedInt = getMovieLikesCount(65324748);
		assertEquals(0, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("BA8J68GR6W3OJSRLSSKE");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(39809139, 7215851);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(39809139, 65324748);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("OZEPNDB48E7FWPCD7TT6");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(39809139, 65324748, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(39809139, 65324748);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(39809139, 65324748, DISLIKE);
		assertEquals(OK, returnValue);

		returnValue = addView(11745308, 65324748);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		returnValue = addView(39809139, 65324748);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(39809139);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(13050323, 65324748);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(65324748); movieObj.setName("AHRT3F4ORBN6G2XPHW7K"); movieObj.setDescription("35WZ6W5NAHYK8LQ7DZOX");
		returnedMovie = getMovie(65324748);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(39809139), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(35744702); viewerObj.setName("AUCCSK5KY64A1Q833P35");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(65324748); movieObj.setName("D9T2MGKD9FT19GY8WQ7X"); movieObj.setDescription(null);
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(3062915); movieObj.setDescription("Z8LQSAA06SR6L6F03TU9");
		returnValue = updateMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(35744702, 96020141);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(39809139, 10893881);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(35744702);
		assertEquals(0, returnedArrayList.size());

		returnedMovie = getMovie(72281920);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(35744702, 43250229);
		assertEquals(0, returnedArrayList.size());

		returnedMovie = getMovie(85183281);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(35744702, 94412688, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieDislikesCount(89149192);
		assertEquals(0, returnedInt);

		returnedMovie = getMovie(6061717);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedArrayList = getMoviesRecommendations(35744702);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(60577707); movieObj.setName("Z3K9RDBCC84WXV18RVDP"); movieObj.setDescription("YVU1LRNC61PNF4N0TP1Z");
		returnValue = deleteMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(36026327);
		assertEquals(0, returnedInt);

		returnValue = addView(35744702, 24688844);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(39809139, 39605870);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(35744702, 11561920);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(39809139, 2699219, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(39809139, 36135666, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(35744702);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(35744702); viewerObj.setName("AUCCSK5KY64A1Q833P35");
		returnedViewer = getViewer(35744702);
		assertEquals(viewerObj, returnedViewer);

		returnValue = removeMovieRating(35744702, 95965431);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(35744702, 99652280);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(32299627);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(35744702); viewerObj.setName("AUCCSK5KY64A1Q833P35");
		returnedViewer = getViewer(35744702);
		assertEquals(viewerObj, returnedViewer);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("Z34FVZJDH5JESFDMBWA4"); movieObj.setDescription("JK9WCDZG2C9GREXIQ630");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addView(35744702, 80877435);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(37686862);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(80877435);
		assertEquals(1, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("YTJD8PK6HFXII3AY5XFD");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName(null); movieObj.setDescription("PMLMJ293GAAEA74HKLSW");
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getConditionalRecommendations(39809139, 80877435);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(39809139); viewerObj.setName("3XNJR0BZ6WRG6IJOB2IW");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(35744702, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(80877435);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(35744702, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35744702), returnedArrayList.get(0));

		returnedArrayList = getConditionalRecommendations(35744702, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(35744702);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("36PEOM4DJLXXMAG18P03"); movieObj.setDescription("2C3Q4OCDX7IM9VQT0A5O");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(35744702, 80877435, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(35744702), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(35744702); viewerObj.setName("4N11SG19AYZSQV24HT39");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("Z34FVZJDH5JESFDMBWA4"); movieObj.setDescription("JK9WCDZG2C9GREXIQ630");
		returnedMovie = getMovie(80877435);
		assertEquals(movieObj, returnedMovie);

		returnedInt = getMovieViewCount(80877435);
		assertEquals(0, returnedInt);

		returnValue = addMovieRating(69051855, 80877435, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("348JXK8X0XLZ0P8H6M62"); movieObj.setDescription("FAO0K93BMAIE36H8A8XA");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(16363505);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setDescription("9TZ5L0C5E36M6ZQN478G");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(50231537);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("0DT314YIXD1LY0XXR35Q"); movieObj.setDescription("J9CRXQC2CK2LDMDI76IE");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setDescription("OBSYO4ETAP2MF66VE7JZ");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("Z34FVZJDH5JESFDMBWA4"); movieObj.setDescription("OBSYO4ETAP2MF66VE7JZ");
		returnedMovie = getMovie(80877435);
		assertEquals(movieObj, returnedMovie);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("4S54QR9CKHTN1FP7Q5CU"); movieObj.setDescription("WBG5F5PZRVFQPMYU5KOH");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(30886040, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("MNTJ2UR7VFXY0219X2FM"); movieObj.setDescription("65MXTQ7FOZ4I02VYA8XE");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(88232023); viewerObj.setName("7GBF1DW70747MYBO3SDD");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(19057802); viewerObj.setName("GP18Q61FG0YIGT9XFU4C");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(36966134);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName(null); movieObj.setDescription("B4JISPDJWCO04XWDLQTA");
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getSimilarViewers(20462324);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(39212859);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(56621243, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(73038629);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(55895372);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(80877435);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(2825757); viewerObj.setName(null);
		returnValue = createViewer(viewerObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnValue = removeView(31796525, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(94181229); viewerObj.setName("ACTFOMMUZX6UNG6U9J94");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("T17TA644YMB79ZEUU7OD"); movieObj.setDescription("Y3HVDCYP37EZDAPIO5I7");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(94181229, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(94181229, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(94181229, 80877435);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(63540300); movieObj.setName("UMY7BSI0XULTQIQ3OT1S"); movieObj.setDescription(null);
		returnValue = deleteMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(94181229), returnedArrayList.get(0));

		returnedArrayList = getConditionalRecommendations(94181229, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(80877435);
		assertEquals(0, returnedInt);

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(94181229); viewerObj.setName("71ZJIF18XT1Z1CSMWPW1");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(94181229);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("Z34FVZJDH5JESFDMBWA4"); movieObj.setDescription("OBSYO4ETAP2MF66VE7JZ");
		returnedMovie = getMovie(80877435);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(94181229), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(94181229);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(94181229); viewerObj.setName("ACTFOMMUZX6UNG6U9J94");
		returnedViewer = getViewer(94181229);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(94181229), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(94181229);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("INQVAI6JUHZPGHYNB7NN"); movieObj.setDescription("TKYR0WJZQQ2PVIHJ43WI");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("1JMARRW885GJ2U1MZDCK"); movieObj.setDescription("9QK7M79NJE1NAVD3UT04");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(94181229); viewerObj.setName("OM7RNTWETDG1WEF3MB4Y");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(94181229);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(94181229, 80877435);
		assertEquals(OK, returnValue);

		returnValue = addView(94181229, 62813714);
		assertEquals(OK, returnValue);

		returnValue = addView(94181229, 80877435);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("UEO5N171CYSVEW3HOK4W"); movieObj.setDescription("LBAFJGEI0Y5J5YXE831B");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedInt = getMovieViewCount(53562647);
		assertEquals(0, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(94181229), returnedArrayList.get(0));

		returnValue = removeView(94181229, 80877435);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(94181229);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(94181229); viewerObj.setName("VY62R7H0Y33UPN3HX248");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setDescription("18751CM5BE8NA4JS46C6");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(77445552, 62813714, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(98055029);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(80224503);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(93572663);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(53291701, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(12456319);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(48736331, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(66809439);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(89431010);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(32909415); viewerObj.setName("1BXW3BQT5SUKOSQXF9ZV");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(56055021, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(319768, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(72453495);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(17107820);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(89926182, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(95494967); viewerObj.setName(null);
		returnValue = createViewer(viewerObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getSimilarViewers(52205651);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setDescription("R6TB9ATUNK84DTT5LI2U");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addView(88914583, 80877435);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("9WL9OA8LSTI0MP85XMUE"); movieObj.setDescription("VMDNRGT95SBV52SGRMXB");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(42082436);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(83640967, 80877435, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(23568295, 80877435);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("BZE5YI2S00XWY3XB502F"); movieObj.setDescription("I79WPZCNX81FPNWDZDT9");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(4998458);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(5365548, 62813714, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("11EQ8GLGPY4PKOMZJROG");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(12224651);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("9JG2J2JQQ8K0ESBBM3OE");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedInt = getMovieLikesCount(62813714);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("IPIBKIAOT10AB74GGGFE");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(43578123, 62813714);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("Z878FT9JNEXNP7KXR8NN");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("R71LYK5GZ5FT6GR4RD16");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(43578123), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(43578123), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(43578123);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(43578123, 80877435);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(13895145);
		assertEquals(0, returnedInt);

		movieObj = new Movie(); movieObj.setId(80877435); movieObj.setName("RK7T621EPNVZ7CHG9L2R"); movieObj.setDescription("Y8U3SVMLEKGDJ51XRLXQ");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(43578123, 62813714, DISLIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(43578123), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("5SPMPYQE5HPC5FM9ISBT"); movieObj.setDescription("9VWA2BGEVEXWBYNF9DCA");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("Z7LC40ANGHOC44A6Q17D");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(43578123), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("B6U0G2Z36420NLHKSDSC");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(43578123); viewerObj.setName("12WEQVXYD0VNP0EV2BSD");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(56772314, 62813714, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(87310334);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("5MBIMP2RPYRUMTDWABLX"); movieObj.setDescription("UHDTZJ5NWTM8JKCN5NW5");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(13320722);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(62813714);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(80729184); viewerObj.setName("0ADOQBECXNCL1H31OU4V");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(56305361, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(98417112, 62813714);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(45840347); movieObj.setName("S5ZEGYQHCJXXLHR5PCGH"); movieObj.setDescription("U23CTGPHWCMU6IKIT9WW");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addView(3292938, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeMovieRating(70772444, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("O5B30GVKYCQ1OYZ7W947"); movieObj.setDescription("FVTFYWX8ADHTBD9569XO");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = removeMovieRating(19083250, 32704715);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(68756259, 45840347);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(91840759, 62813714, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedViewer = getViewer(23484213);
		assertEquals(Viewer.badViewer(), returnedViewer);

		returnedArrayList = getConditionalRecommendations(85268035, 45840347);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(12401128);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(42391726); viewerObj.setName(null);
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(24981038, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeView(82505379, 45840347);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeView(11287494, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("JCZDPRF3AYLK5AEKF861"); movieObj.setDescription("7VQKFLSXHN8Z0PD3YNZM");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(15825734); viewerObj.setName("83DR3AD3MBSSKT2UN977");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(45840347); movieObj.setName("EYG75ELZAIAIMO2C3NIY"); movieObj.setDescription("M8TI8XBO6MOO4RVBBWOH");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(95705174);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(34567887, 45840347);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(25651924, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(87026118, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(96726728, 45840347);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(79010306, 45840347);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeMovieRating(20673587, 45840347);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(48109115); viewerObj.setName("XY4Y5UA59A9X98BDYKZS");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(92479198);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(49210961); viewerObj.setName("LNZ2O7AY8X0XLSFFZ8IB");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieViewCount(62813714);
		assertEquals(0, returnedInt);

		returnedMovie = getMovie(17384490);
		assertEquals(Movie.badMovie(), returnedMovie);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(62813714);
		assertEquals(0, returnedInt);

		returnedArrayList = getMoviesRecommendations(60270019);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(54546592, 47337086, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(8052538);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(38500003, 45840347);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(55123276);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(52145455, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(70493325, 45840347);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(65364449, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(39046143); viewerObj.setName("3B4844YFQLX8F1FWUSPY");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(99389695);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(20142793, 45840347, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(71288890, 45840347, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("FAXO315LXQQ0IB7ZTOOU");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("WPJXWTYBV2Y8X487MECR");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedInt = getMovieDislikesCount(62813714);
		assertEquals(0, returnedInt);

		returnValue = addMovieRating(72850838, 45840347, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("RHDGOKH33JK29QCE7VL8");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(72850838, 45840347);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("FAXO315LXQQ0IB7ZTOOU");
		returnedViewer = getViewer(72850838);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(72850838, 45840347);
		assertEquals(OK, returnValue);

		returnValue = addView(72850838, 62813714);
		assertEquals(OK, returnValue);

		returnValue = removeView(72850838, 45840347);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("M1XHP3H8VLNOVQ3C8IHQ"); movieObj.setDescription("RFQEZSF72BBWSRC8J87M");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("FAXO315LXQQ0IB7ZTOOU");
		returnedViewer = getViewer(72850838);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(45840347); movieObj.setName("K840VL3Q6MQQD72L4GBI"); movieObj.setDescription("PTAFG7M77IMUACO37DKC");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedInt = getMovieViewCount(62813714);
		assertEquals(1, returnedInt);

		returnValue = removeMovieRating(72850838, 62813714);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(72850838, 62813714);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("KLD2DU3ZYFDOTT80P5AG");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(72850838, 62813714);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("INQVAI6JUHZPGHYNB7NN"); movieObj.setDescription("Z7LC40ANGHOC44A6Q17D");
		returnedMovie = getMovie(62813714);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(62813714);
		assertEquals(0, returnedInt);

		returnValue = addView(72850838, 62813714);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnedInt = getMovieLikesCount(62813714);
		assertEquals(0, returnedInt);

		returnValue = addMovieRating(72850838, 62813714, LIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("ZED9P4MJK845BRHZMZXB");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("EK8FBSATWSY4U8B6XYLQ"); movieObj.setDescription("ZX3EGINS6G4EWI30AFRF");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("7T4FB6DU2192A83029TE");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("BBHV2IZT35FYVIVORA5U");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("LAARL65I2SE5JLPN2V2S");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(54804532);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(72850838, 62813714, DISLIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("DNEMBTMXD5MLSZW3EZWS");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(72850838, -76723679);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("JBAGD0WGUCZTE6LK981C"); movieObj.setDescription("GV7XDFG1YG6UAXY9QP1K");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(72850838, 62813714);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnedInt = getMovieDislikesCount(62813714);
		assertEquals(1, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("WEY8X7WFZYG4Z1RV471M");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("5FEFHJSCI78RENQND5FS"); movieObj.setDescription("00F5BYDL6W9MBSA0DEBZ");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName(null);
		returnValue = createViewer(viewerObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("WEY8X7WFZYG4Z1RV471M");
		returnedViewer = getViewer(72850838);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnValue = addView(72850838, 89446979);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(72850838), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("6I9SIEANOBG309CVZRJS");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("INQVAI6JUHZPGHYNB7NN"); movieObj.setDescription("6I9SIEANOBG309CVZRJS");
		returnedMovie = getMovie(62813714);
		assertEquals(movieObj, returnedMovie);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("A21C231HBTEBXRWEG9UU");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("0QODUCO5ATWP97HQQIRM");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(72850838, 2651251);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(72850838, 62813714);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("SURMAE0CGR9HGEBHB0TP"); movieObj.setDescription("4MPL5Y72CBW5PJTINA5B");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("B2KHICIGL849W0GIR828");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setDescription("SBQSHYF8SY17NUXWKJ4Y");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("WYZN1IX37QQNNWLU3NJZ"); movieObj.setDescription("FH467JTE2C9ZEFZH3CX6");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(72850838, 62813714);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(72850838, 62813714, DISLIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("A21C231HBTEBXRWEG9UU");
		returnedViewer = getViewer(72850838);
		assertEquals(viewerObj, returnedViewer);

		returnValue = addMovieRating(72850838, 62813714, DISLIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("2Y045DP6XQNF8CGAKL0O");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(72850838, 62813714);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(62813714); movieObj.setName("TC7OP4FERGVXY1NRFEOT"); movieObj.setDescription("EYJXUBDB1QUX2UYNAEH7");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(72850838);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(68611418); movieObj.setDescription("TXDU0K9MPQLQ5G6WUXZG");
		returnValue = updateMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(72850838); viewerObj.setName("63WK4D2GBHZ94SQMJKEM");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(55881895, 75635495);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(27117427, 52190308, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(27845787, 62279938);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(21494792);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName("5M80OAOZNW49OIIIH9U5"); movieObj.setDescription("YQX791NHAOKXPSZGZD8W");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(59602654);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(71822533, 68901311);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(60518568, 68901311);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(47151443);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(78863122, 68901311);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(50287183, 68901311);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(25051337, 68901311);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(88099423); viewerObj.setName("Z0AULZU11OK89HACHAPT");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(27972260);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(15905139); viewerObj.setName("XMJ6HE848ZAH54U9KJ06");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(21248193); viewerObj.setName("AD2C0MMC785GTEIVFPIL");
		returnValue = deleteViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieLikesCount(68901311);
		assertEquals(0, returnedInt);

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setDescription("1EB2C6GCYI7FSW6A1TZH");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(4789613);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(17664248); viewerObj.setName("EP6AXLD0WFC1202NB2LI");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = removeView(82137693, 68901311);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(18550140); viewerObj.setName("XDQM63WUILA94VTE9SI4");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(18550140, 68901311);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(18550140, 68901311);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("RTLQH0IFENH96GFJA2NP");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("F8UJ8K7Y3VQ76C58P8VZ"); movieObj.setDescription("5M2LXBFWN9PAH7A6WK7K");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(18550140);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(82345265, 37397400);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("07YU0J4RAO0RHV2R6UJG");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedInt = getMovieDislikesCount(37397400);
		assertEquals(0, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("2HXYXMQWUEISO6G7DY46"); movieObj.setDescription("TX9THWC9XMI0PFYPN1U9");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("9V8PC3WBGVGCR65ZFQ3W");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(18550140, 37397400, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieViewCount(37397400);
		assertEquals(1, returnedInt);

		returnedArrayList = getConditionalRecommendations(18550140, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedInt = getMovieViewCount(68901311);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(18550140); viewerObj.setName("1DWZF2LMU9QHUP7SI68E");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(45454235, 68901311);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(68901311);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName("5M80OAOZNW49OIIIH9U5"); movieObj.setDescription("1EB2C6GCYI7FSW6A1TZH");
		returnedMovie = getMovie(68901311);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedInt = getMovieViewCount(68901311);
		assertEquals(0, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("TGZWM7O221PCKTHOKU77");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(82345265, 68901311, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName(null);
		returnValue = createViewer(viewerObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName(null); movieObj.setDescription("O9I3PJYTNC897D2LTKXU");
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getConditionalRecommendations(82345265, 68901311);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(82345265, 37397400, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(50164139, 68901311);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setDescription("VIL7G1QNP9BZXPM26ISG");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(82345265, 68901311);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(68901311);
		assertEquals(0, returnedInt);

		returnedInt = getMovieDislikesCount(37397400);
		assertEquals(0, returnedInt);

		returnValue = removeMovieRating(82345265, 37397400);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("9V8PC3WBGVGCR65ZFQ3W");
		returnedViewer = getViewer(82345265);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getConditionalRecommendations(82345265, 68901311);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName("PRT6MP69BK23WF7TU8Q7"); movieObj.setDescription("DALOYGY1GZALUZ1WNL9O");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnValue = addMovieRating(82345265, 37397400, DISLIKE);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(82345265, 37397400, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnValue = addMovieRating(82345265, 23537477, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(82345265, 37397400);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName("JC2UVNE032P2WMKLF74W"); movieObj.setDescription("35DPLFJEO27NTN8JUEWI");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedInt = getMovieDislikesCount(37397400);
		assertEquals(0, returnedInt);

		returnedInt = getMovieDislikesCount(37397400);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(82345265, 68901311, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("CTJ0MU8H6X3R5P1XWVQK"); movieObj.setDescription("JVG2PQGE342FKN7D4YGV");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(68901311); movieObj.setName("AQEMPX04COLXZ43W40PQ"); movieObj.setDescription("DUNNLUKS9RFXNBUCK9A3");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setDescription("MMNQCUKG795M6QSUE03B");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("21ASFKGCF7OM2RB78EEC");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(18756827);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setDescription("LLX78HZLXRIF1YV8L1VX");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("SWEEOFYXYWHJYHEXE1XZ");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(82345265, 24708193);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("VV88SV6C9P9PWJHJMBQN");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedInt = getMovieLikesCount(37397400);
		assertEquals(1, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnValue = addMovieRating(82345265, 37397400, LIKE);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(82345265, 37397400, DISLIKE);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("WBALL987A36ABEBMLXM7"); movieObj.setDescription("7DP9JZ93SQ2POKX2CDCF");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(82345265, 24407248);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("TX7UNIAKZBV1MLMJ8WG3");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(82345265, 37397400, DISLIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(82345265, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("VYPWBYNQQ0WTZH58TY3W");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(81224372);
		assertEquals(0, returnedInt);

		returnValue = addView(82345265, 37397400);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(82345265);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("Y1IASJR9R7UOLT6HGFA8"); movieObj.setDescription("AUI95FVE1H9JK38Y63S4");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(82345265), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(82345265); viewerObj.setName("00R7UMSO8NOY8AFTK7G2");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("YM3QXSF5Y1FYZH1ZMO7U"); movieObj.setDescription("L5N7904WY9FXBBLV6WJI");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(13896154, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("F8UJ8K7Y3VQ76C58P8VZ"); movieObj.setDescription("LLX78HZLXRIF1YV8L1VX");
		returnedMovie = getMovie(37397400);
		assertEquals(movieObj, returnedMovie);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("O4DH3HDNI10EEXT9M3LI"); movieObj.setDescription("DIIAHO2I4R9SCRW7EGII");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(62968763, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(60533040, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(37397400);
		assertEquals(0, returnedInt);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(5250656, 37397400);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("8SE8MP02DXW5F9IYFGUF"); movieObj.setDescription("L230Z7I9M3P7JVEK362Q");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(8668902, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(2800394);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(16688362);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(92535758, 37397400);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(20382422, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("V31VFN4R322BNBE24AR6");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = removeMovieRating(69787440, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("V31VFN4R322BNBE24AR6");
		returnedViewer = getViewer(69787440);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setDescription("YRZEJNCVK45O88BLVL42");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addView(69787440, 37397400);
		assertEquals(OK, returnValue);

		returnValue = removeMovieRating(69787440, 37397400);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(69787440, 37397400);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		returnedInt = getMovieViewCount(37397400);
		assertEquals(1, returnedInt);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("5IRDV2DNAHHPJ7P2PEM4");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("O27Q9OY5X1TEIJJPF5DF"); movieObj.setDescription("NOXZB62VCKF0YBRORNTD");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(69787440, 37397400, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setDescription("VZZYY605JGY40AUHTC3A");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("OHLKTCLHUAM9UL2FTVFV"); movieObj.setDescription("2EF1W6203VRQ5TWLREH9");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(69787440, 37397400);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(37397400); movieObj.setName("OX66R3NT8N7PQIAJ8K4K"); movieObj.setDescription("1C75SVVZOL4U1I4FUZ6L");
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("45YQ9TXWM8V24U4QEVFP"); movieObj.setDescription("0AH3E0WJQSXGAESG8755");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setDescription("8QD09JWLCG432D5XACWS");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("U57UIJMTMBJ3DBYXVL0O");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("1B80RKZEZW61NJ787EUY");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(69787440, 39461617, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(48399891);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("7WSUT1QNXM4YETOQL2VV");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(69787440, 39461617);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(69787440, 39461617);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("YBH60VGGS2RA4HVB1U9P"); movieObj.setDescription("OA8MKPBTPTC52VY766NY");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = removeMovieRating(69787440, -79269222);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(69787440, 39461617);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("3KNTDH968ZRW7E5AR3XQ"); movieObj.setDescription("W2DJF8F6YFYO50M8ZHGI");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("N386ZYE2ESYOOFH8LVLK");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = addView(69787440, 39461617);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(69787440, 39461617);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(69787440, 39461617, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(69787440, 39461617);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("93D8X6AT0QWFKIXANLGI");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedViewer = getViewer(84023139);
		assertEquals(Viewer.badViewer(), returnedViewer);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(39461617);
		assertEquals(0, returnedInt);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(69787440, 39461617, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieLikesCount(39461617);
		assertEquals(0, returnedInt);

		returnValue = addMovieRating(69787440, 39461617, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(69787440, 39461617);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(69787440, 39461617, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		returnValue = removeView(69787440, 39461617);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setDescription("FRI58GWCNE28MIP62CB7");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(69787440, 39461617);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(69787440, 39461617);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("XIRUPOH7PFQ0JFRS0P4Y");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("Q5CO9BJQ0YH3YO3Q6ZY6"); movieObj.setDescription("FFIVIN0X5HX1O2Q5ED5I");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = removeMovieRating(69787440, 39461617);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("NQ5SWAAQ8IZ6WH8RF1VF"); movieObj.setDescription("JZXY55XWD4CVL80ULEQY");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("2KOK7K0JFEND6EBVZ8RG"); movieObj.setDescription(null);
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("11U9I6L6NJKJBG2XUOWL"); movieObj.setDescription("UV95I66P4F99OTSU2FT7");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(39461617);
		assertEquals(0, returnedInt);

		returnValue = addView(69787440, 39461617);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(69787440, 39461617);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(69787440, 39461617);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(69787440, 39461617, DISLIKE);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setDescription("SUGOF321DVHEIP901E1W");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnValue = addView(13913522, 39461617);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(69787440), returnedArrayList.get(0));

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName(null); movieObj.setDescription("2Y8X4WS7HFHCHK7A2OFC");
		returnValue = createMovie(movieObj);
		assertEquals(BAD_PARAMS, returnValue);

		returnedArrayList = getConditionalRecommendations(69787440, 39461617);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(39461617); movieObj.setName("03SQDFD8TY1QZGHSBN72"); movieObj.setDescription(null);
		returnValue = deleteMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(69787440, 21085119);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(47676094, 96954979);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(69787440, 78183940, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("N386ZYE2ESYOOFH8LVLK");
		returnedViewer = getViewer(69787440);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(69787440, 54268979);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(28560904); movieObj.setName("EZ5ZT9WGTT1W8F6GV65T"); movieObj.setDescription("CJNREIV5GECJCTPQWRPG");
		returnValue = deleteMovie(movieObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("H27EECDHEPEFS2AFUMKV");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(69787440, 12069419);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(69787440);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(31259004);
		assertEquals(0, returnedInt);

		returnedArrayList = getConditionalRecommendations(69787440, 77399962);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("9D13RF3JJ6H2NKO7X6YR");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(69787440); viewerObj.setName("MYZI9JWYQTN9CFKQEVPE");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(89573764); viewerObj.setName(null);
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(12275944);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("70VH4LQWT977DH1EHUGN");
		returnValue = createMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setDescription("19F59DQDAC1Q8NNVKT7K");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(45841674);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("RZA9B84QI138KEP0MO8J");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(27828236);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("OS8EZGVRWTR9KZFYXA3D");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(27828236, 88680500);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(27828236);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("6CTYFGWGSH9E5LFAP0F3");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(27828236);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(27828236, 88680500, DISLIKE);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("1TPQX4KKRX6DXKHBH2DC");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(27828236, 88680500);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(27828236, 88680500);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(25671289, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieViewCount(88680500);
		assertEquals(1, returnedInt);

		returnedInt = getMovieViewCount(88680500);
		assertEquals(1, returnedInt);

		returnedInt = getMovieViewCount(88680500);
		assertEquals(1, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("7CFXV0EQN4BHWH3OTTRX");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(27828236);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(27828236), returnedArrayList.get(0));

		returnValue = removeView(27828236, 88680500);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(27828236);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("DNTSJ5FL3QT9OV2HBR1J");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = addMovieRating(27828236, 12803629, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedInt = getMovieViewCount(88680500);
		assertEquals(0, returnedInt);

		returnedArrayList = getMoviesRecommendations(27828236);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("04CF4K4M6H68WGLRLYK3");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(27828236, 88680500, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(27828236, 88680500, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(27828236, 88680500, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(27828236);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(27828236, 88680500);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("19F59DQDAC1Q8NNVKT7K");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		viewerObj = new Viewer(); viewerObj.setId(27828236); viewerObj.setName("DGSMBAVBZVADRBQWPKLA");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(1609085, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(25377152);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(524491, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(85056732, 88680500, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("CDMICA587KS1T8COEPEM"); movieObj.setDescription("8HTIODEQ8TSJEJ8SRUMA");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(10037649, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(98009829);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(20177183);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(64321028, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("BBLSEFJRPZKYXLSTF5Q7"); movieObj.setDescription("S4FCSFQ3Y785E4QF8PUS");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addView(8178401, 58966792);
		assertEquals(NOT_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("U5OV8YR94ZO09EV8PB72"); movieObj.setDescription("318STTQ8VYRZEXJNLMP5");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnValue = addMovieRating(51768560, 88680500, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(90303031);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(73796193, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(19136829); viewerObj.setName("98Q1LV20ABI7MVE2G0U9");
		returnValue = updateViewer(viewerObj);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(27108375);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(13351708);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(60274468);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(20619000); viewerObj.setName("N6X9SMCBT04Q0H97CW0V");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(20619000);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(20619000, 88680500, LIKE);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getSimilarViewers(20619000);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeMovieRating(20619000, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addMovieRating(20619000, 88680500, DISLIKE);
		assertEquals(NOT_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(20619000); viewerObj.setName("7QR7ES80HA59QV6PD659");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(20619000);
		assertEquals(0, returnedArrayList.size());

		returnValue = addView(20619000, 88680500);
		assertEquals(OK, returnValue);

		returnValue = addView(20619000, 88680500);
		assertEquals(ALREADY_EXISTS, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setDescription("EWXIM8NBS0G5SM4W5XS5");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("EWXIM8NBS0G5SM4W5XS5");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = getSimilarViewers(20619000);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(20619000, 88680500);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("EWXIM8NBS0G5SM4W5XS5");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("EWXIM8NBS0G5SM4W5XS5");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("EWXIM8NBS0G5SM4W5XS5");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		returnedArrayList = getConditionalRecommendations(20619000, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(20619000);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieLikesCount(88680500);
		assertEquals(0, returnedInt);

		returnedInt = getMovieViewCount(88680500);
		assertEquals(1, returnedInt);

		returnedArrayList = getConditionalRecommendations(20619000, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(20619000);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setDescription("MUR6NWV6SM18YP0KMKA1");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(20619000);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(20619000);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(20619000); viewerObj.setName("3525EIA2BID2XB4C5LE3");
		returnValue = deleteViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = removeView(53497519, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnValue = addView(82310414, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(12885887);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(96183502);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(88680500);
		assertEquals(0, returnedInt);

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setDescription("VBAQ0O5J2A6GIJ15ATIN");
		returnValue = updateMovie(movieObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(3530023, 88680500);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName("CP8HA93E6K3PKW2HC0A7");
		returnValue = createViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnedArrayList = getSimilarViewers(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getSimilarViewers(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("9Y4326ML8XW02EFZV1OO"); movieObj.setDescription("VBAQ0O5J2A6GIJ15ATIN");
		returnedMovie = getMovie(88680500);
		assertEquals(movieObj, returnedMovie);

		returnValue = addView(45212595, 88680500);
		assertEquals(OK, returnValue);

		returnValue = removeMovieRating(45212595, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(45212595), returnedArrayList.get(0));

		returnValue = removeMovieRating(45212595, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = getConditionalRecommendations(45212595, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(45212595), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("EEF0O4TLDGI59M5F0IUF"); movieObj.setDescription("FEPUDB5FN9A929GLTA79");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(45212595), returnedArrayList.get(0));

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(45212595, 88680500, LIKE);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedInt = getMovieDislikesCount(88680500);
		assertEquals(0, returnedInt);

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName("CP8HA93E6K3PKW2HC0A7");
		returnedViewer = getViewer(45212595);
		assertEquals(viewerObj, returnedViewer);

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName("R34OPZYG7PZXPSI8JMVT");
		returnValue = updateViewer(viewerObj);
		assertEquals(OK, returnValue);

		returnValue = removeMovieRating(45212595, 88680500);
		assertEquals(OK, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName("CHZXIICMGLGWR0EM7KFK");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnValue = addMovieRating(45212595, 88680500, LIKE);
		assertEquals(OK, returnValue);

		returnValue = addView(28329751, 88680500);
		assertEquals(NOT_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(1, returnedArrayList.size());
		assertEquals(Integer.valueOf(45212595), returnedArrayList.get(0));

		returnValue = removeMovieRating(45212595, 88680500);
		assertEquals(OK, returnValue);

		returnedArrayList = getConditionalRecommendations(45212595, 88680500);
		assertEquals(0, returnedArrayList.size());

		returnValue = removeView(45212595, 88680500);
		assertEquals(OK, returnValue);

		returnedArrayList = getMoviesRecommendations(45212595);
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		movieObj = new Movie(); movieObj.setId(88680500); movieObj.setName("ELKIA3LHDK3W0JDE1TVF"); movieObj.setDescription("J2CV6OYD6HFJ3Z7NDOFA");
		returnValue = createMovie(movieObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		returnedArrayList = mostInfluencingViewers();
		assertEquals(0, returnedArrayList.size());

		returnedArrayList = getConditionalRecommendations(45212595, 88680500);
		assertEquals(0, returnedArrayList.size());

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName("OXIQCDD2LITXUUM2WFX6");
		returnValue = createViewer(viewerObj);
		assertEquals(ALREADY_EXISTS, returnValue);

		viewerObj = new Viewer(); viewerObj.setId(45212595); viewerObj.setName(null);
		returnValue = createViewer(viewerObj);
		assertEquals(BAD_PARAMS, returnValue);

    }
    

    
    @Test
    public void test()
    {
        
		test1();
    }
}
