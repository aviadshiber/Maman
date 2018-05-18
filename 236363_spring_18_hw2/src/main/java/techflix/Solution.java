package techflix;

import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;
import techflix.data.DBConnector;
import techflix.data.PostgresSQLErrorCodes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Solution {

    public static void createTables()
    {

    }


    public static void clearTables()
    {

    }


    public static void dropTables()
    {

    }


    public static ReturnValue createViewer(Viewer viewer)
    {

        return null;
    }

    public static ReturnValue deleteViewer(Viewer viewer)
    {

        return null;
    }

    public static ReturnValue updateViewer(Viewer viewer)
    {

        return null;
    }

    public static Viewer getViewer(Integer viewerId)
    {

        return null;
    }


    public static ReturnValue createMovie(Movie movie)
    {

        return null;
    }

    public static ReturnValue deleteMovie(Movie movie)
    {

        return null;
    }

    public static ReturnValue updateMovie(Movie movie)
    {
        return null;
    }

    public static Movie getMovie(Integer movieId)
    {

        return null;
    }



    public static ReturnValue addView(Integer viewerId, Integer movieId)
    {

        return null;
    }

    public static ReturnValue removeView(Integer viewerId, Integer movieId)
    {

        return null;
    }

    public static Integer getMovieViewCount(Integer movieId)
    {

        return null;
    }


    public static ReturnValue addMovieRating(Integer viewerId, Integer movieId, MovieRating rating)
    {

        return null;
    }

    public static ReturnValue removeMovieRating(Integer viewerId, Integer movieId)
    {

        return null;
    }

    public static int getMovieLikesCount(int movieId)
    {

        return -1;
    }

    public static int getMovieDislikesCount(int movieId)
    {

        return -1;
    }

    public static ArrayList<Integer> getSimilarViewers(Integer viewerId)
    {

        return null;
    }


    public static ArrayList<Integer> mostInfluencingViewers()
    {

        return null;
    }


    public static ArrayList<Integer> getMoviesRecommendations(Integer viewerId)
    {

            return null;
    }


    public static ArrayList<Integer> getConditionalRecommendations(Integer viewerId, int movieId)
    {

        return null;
    }

}


