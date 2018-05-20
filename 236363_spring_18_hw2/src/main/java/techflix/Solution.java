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
import java.util.List;

public class Solution {

    public static final String WATCHED = "watched";
    public static final String MOVIES = "movies";
    public static final String RANKS = "ranks";
    public static final String VIEWERS = "viewers";

    public static void createTables() {
        createViewerTable();
        createMovieTable();
        createWatchedTable();
        createRankTable();
    }

    public static void clearTables() {
        clearTable(WATCHED);
        clearTable(MOVIES);
        clearTable(RANKS);
        clearTable(VIEWERS);
    }


    public static void dropTables() {
        dropTable(WATCHED);
        dropTable(MOVIES);
        dropTable(RANKS);
        dropTable(VIEWERS);
    }

    public static ReturnValue createViewer(Viewer viewer) {
        try {
            execute(String.format("INSERT INTO %s(\n" +
                    "\tvid, vname)\n" +
                    "\tVALUES (%d, '%s');", VIEWERS, viewer.getId(), viewer.getName()));
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue deleteViewer(Viewer viewer) {
        return deleteRecord(VIEWERS, "vid", viewer.getId());
    }

    private static ReturnValue updateRecord(String tableName, String columnToUpdate, String value, String idColumn, int id) {
        try {
            int affectedRows = executeAndUpdate(
                    String.format("UPDATE %s SET %s='%s' WHERE %s=%d;"
                            , tableName, columnToUpdate, value, idColumn, id));
            if (affectedRows == 0) {
                return ReturnValue.NOT_EXISTS;
            }
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue updateViewer(Viewer viewer) {
        return updateRecord(VIEWERS, "vname", viewer.getName(), "vid", viewer.getId());
    }

    public static Viewer getViewer(Integer viewerId) {
        Viewer viewer = Viewer.badViewer();
        try {
            ResultSet rs = executeQuery(String.format("SELECT * FROM %s WHERE vid=%d", VIEWERS, viewerId));
            if (rs.next()) {
                viewer.setId(Integer.valueOf(rs.getString("vid")));
                viewer.setName(rs.getString("vname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return viewer;
    }


    public static ReturnValue createMovie(Movie movie) {
        try {
            execute(String.format("INSERT INTO %s(\n" +
                    "\tmid, mname,description)\n" +
                    "\tVALUES (%d, '%s','%s');", MOVIES, movie.getId(), movie.getDescription()));
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue deleteMovie(Movie movie) {
        return deleteRecord(MOVIES, "mid", movie.getId());
    }

    public static ReturnValue updateMovie(Movie movie) {
        return updateRecord(MOVIES, "description", movie.getDescription(), "mid", movie.getId());
    }

    public static Movie getMovie(Integer movieId) {
        Movie movie = Movie.badMovie();
        try {
            ResultSet rs = executeQuery(String.format("SELECT * FROM %s WHERE mid=%d", MOVIES, movieId));
            if (rs.next()) {
                movie.setId(Integer.valueOf(rs.getString("mid")));
                movie.setName(rs.getString("mname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    private static ReturnValue addRecord(String tableName, Integer viewid, Integer movieid) {
        try {
            execute(String.format("INSERT INTO %s (viewid, movieid) VALUES (%d, %d);", tableName, viewid, movieid));
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue addView(Integer viewerId, Integer movieId) {
        return addRecord(WATCHED, viewerId, movieId);
    }

    private static ReturnValue removeRecord(String tableName, Integer viewid, Integer movieid) {
        try {
            int r = executeAndUpdate(String.format("DELETE FROM %s WHERE viewid = %d AND movieid = %d", tableName, viewid, movieid));
            if (r == 0) return ReturnValue.NOT_EXISTS;
        } catch (SQLException e) {
            return handleException(e);
        }
        return ReturnValue.OK;
    }

    public static ReturnValue removeView(Integer viewerId, Integer movieId) {
        return removeRecord(WATCHED, viewerId, movieId);
    }


    public static Integer getMovieViewCount(Integer movieId) {
        try {
            ResultSet rs = executeQuery(String.format("SELECT COUNT(viewid) FROM %s WHERE movieid=%d", WATCHED, movieId));
            if (rs.next()) {
                return Integer.valueOf(rs.getString("count"));
            }
        } catch (SQLException e) { }
        return 0;
    }


    public static ReturnValue addMovieRating(Integer viewerId, Integer movieId, MovieRating rating) {
        return addRecord(RANKS, viewerId, movieId, rating);
    }

    private static ReturnValue addRecord(String tableName, Integer viewid, Integer movieid, MovieRating rating) {
        try {
            execute(String.format("INSERT INTO %s (viewid, movieid,isliked) VALUES (%d, %d,'%s') ON CONFLICT DO UPDATE;", tableName, viewid, movieid, rating.toString()));
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue removeMovieRating(Integer viewerId, Integer movieId) {
        return removeRecord(RANKS, viewerId, movieId);
    }

    public static int getMovieLikesCount(int movieId) {
        return countRating(MovieRating.LIKE,movieId);

    }

    private static int countRating(MovieRating islike,Integer movieId) {
        try {
            ResultSet rs=executeQuery(String.format("SELECT COUNT(movieid) FROM %s WHERE isliked='%s' AND movieid=%d",RANKS,islike.toString(), movieId));
            if(rs.next())
                return Integer.valueOf(rs.getString("count"));
        } catch (SQLException e) {}
        return 0;
    }

    public static int getMovieDislikesCount(int movieId) {
        return countRating(MovieRating.DISLIKE,movieId);
    }

    public static ArrayList<Integer> getSimilarViewers(Integer viewerId) {

        return null;
    }


    public static ArrayList<Integer> mostInfluencingViewers() {

        return null;
    }


    public static ArrayList<Integer> getMoviesRecommendations(Integer viewerId) {

        return null;
    }


    public static ArrayList<Integer> getConditionalRecommendations(Integer viewerId, int movieId) {

        return null;
    }

    //------------------------------------------
    private static int executeAndUpdate(String query) throws SQLException {
        int affectedRows = 0;
        try (Connection conn = DBConnector.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(
                    String.format(query))
            ) {
                affectedRows = statement.executeUpdate();
            }
        }
        return affectedRows;
    }

    private static int clearTable(String tableName) {
        try {
            return executeAndUpdate(String.format("DELETE FROM %s", tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void execute(String query) throws SQLException {
        try (Connection conn = DBConnector.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.execute();
            }
        }
    }


    private static void createViewerTable() {
        try {
            execute("CREATE TABLE viewers(\n" +
                    "vid integer NOT NULL,\n" +
                    "vname text  NOT NULL,\n" +
                    "PRIMARY KEY (vid),\n" +
                    "CHECK(vid>0)\n" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dropTable(String tableName) {
        try {
            execute(String.format("DROP TABLE IF EXISTS %s", tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createRankTable() {
        try {
            execute("CREATE TYPE liked AS ENUM('LIKE','DISLIKE')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            execute("CREATE TABLE ranks(\n" +
                    "viewid integer NOT NULL UNIQUE,\n" +
                    "movieid integer NOT NULL UNIQUE,\n" +
                    "isliked liked,\n" +
                    "CONSTRAINT fk_movie FOREIGN KEY (movieid)\n" +
                    "REFERENCES movies (mid)\n" +
                    "ON UPDATE CASCADE\n" +
                    "ON DELETE CASCADE,\n" +
                    "CONSTRAINT fk_viewrs FOREIGN KEY (viewid)\n" +
                    "REFERENCES viewers (vid)\n" +
                    "ON UPDATE CASCADE\n" +
                    "ON DELETE CASCADE\n" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMovieTable() {
        try {
            execute("CREATE TABLE movies(\n" +
                    "mid integer NOT NULL,\n" +
                    "mname text,\n" +
                    "PRIMARY KEY (mid),\n" +
                    "CHECK(mid>0)\n" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createWatchedTable() {
        try {
            execute("CREATE TABLE watched(\n" +
                    "viewid integer NOT NULL UNIQUE,\n" +
                    "movieid integer NOT NULL UNIQUE,\n" +
                    "CONSTRAINT fk_movie FOREIGN KEY (movieid)\n" +
                    "REFERENCES movies (mid)\n" +
                    "ON UPDATE CASCADE\n" +
                    "ON DELETE CASCADE,\n" +
                    "CONSTRAINT fk_viewrs FOREIGN KEY (viewid)\n" +
                    "REFERENCES viewers (vid)\n" +
                    "ON UPDATE CASCADE\n" +
                    "ON DELETE CASCADE\n" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ReturnValue handleException(SQLException e) {
        int eValue = Integer.valueOf(e.getSQLState());
        if (PostgresSQLErrorCodes.CHECK_VIOLATION.getValue() == eValue)
            return ReturnValue.BAD_PARAMS;
        else if (PostgresSQLErrorCodes.UNIQUE_VIOLATION.getValue() == eValue)
            return ReturnValue.ALREADY_EXISTS;
        else if (PostgresSQLErrorCodes.NOT_NULL_VIOLATION.getValue() == eValue)
            return ReturnValue.BAD_PARAMS;
        else if (PostgresSQLErrorCodes.FOREIGN_KEY_VIOLATION.getValue() == eValue)
            return ReturnValue.NOT_EXISTS;
        else return ReturnValue.ERROR;
    }

    private static ResultSet executeQuery(String query) throws SQLException {
        try (Connection conn = DBConnector.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                return statement.executeQuery();
            }
        }
    }

    private static ReturnValue deleteRecord(String tableName, String idColumn, int id) {
        try {
            int affectedRows = executeAndUpdate(
                    String.format("DELETE FROM %s WHERE %s = %d;"
                            , tableName, idColumn, id));
            if (affectedRows == 0) {
                return ReturnValue.NOT_EXISTS;
            }
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }
    private static List<Integer> ResultSetToList(ResultSet rs) throws SQLException {
        List<Integer> list=new ArrayList<>();
        while(rs.next()){
            list.add(rs.getInt(1));
        }
        return list;
    }
}


