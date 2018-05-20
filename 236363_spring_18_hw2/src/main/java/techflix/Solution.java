package techflix;

import techflix.business.Movie;
import techflix.business.MovieRating;
import techflix.business.ReturnValue;
import techflix.business.Viewer;
import techflix.data.DBConnector;
import techflix.data.PostgresSQLErrorCodes;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /* TABLES */
    private static final String WATCHED = "watched";
    private static final String MOVIES = "movies";
    private static final String RANKS = "ranks";
    private static final String VIEWERS = "viewers";
    private static final String LIKED = "liked";
    /* COLUMNS */
    private static final String VIEWER_NAME_COL = "vname";
    private static final String VIEWER_ID_COL = "vid";
    private static final String MOVIE_ID_COL = "mid";
    private static final String MOVIE_DESCRIPTION_COL = "description";
    private static final String MOVIE_NAME_COL = "mname";
    public static final String COUNT_COL = "count";

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
            execute(
                    String.format("INSERT INTO %s (%s,%s) VALUES(%s,'%s')",
                            VIEWERS, VIEWER_ID_COL, VIEWER_NAME_COL,
                            viewer.getId(), viewer.getName())
            );
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue deleteViewer(Viewer viewer) {
        return deleteRecord(VIEWERS, VIEWER_ID_COL, viewer.getId());
    }


    public static ReturnValue updateViewer(Viewer viewer) {
        return updateRecord(VIEWERS, VIEWER_NAME_COL, viewer.getName(),VIEWER_ID_COL, viewer.getId());
    }

    public static Viewer getViewer(Integer viewerId) {
        Viewer viewer = Viewer.badViewer();
        Map<String, String> viewerRecord = extractRecord(VIEWERS, VIEWER_ID_COL, viewerId);
        if (!viewerRecord.isEmpty()) {
            viewer.setId(viewerId);
            viewer.setName(viewerRecord.get(VIEWER_NAME_COL));
        }
        return viewer;
    }


    public static ReturnValue createMovie(Movie movie) {
        try {
            execute(
                    String.format("INSERT INTO %s (%s,%s,%s) VALUES(%d,'%s','%s')"
                            , MOVIES, MOVIE_ID_COL, MOVIE_NAME_COL, MOVIE_DESCRIPTION_COL,
                            movie.getId(), movie.getName(), movie.getDescription()
                    )
            );
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    public static ReturnValue deleteMovie(Movie movie) {
        return deleteRecord(MOVIES, MOVIE_ID_COL, movie.getId());
    }

    public static ReturnValue updateMovie(Movie movie) {
        return updateRecord(MOVIES, MOVIE_DESCRIPTION_COL, movie.getDescription(), MOVIE_ID_COL, movie.getId());
    }


    public static Movie getMovie(Integer movieId) {
        Movie movie = Movie.badMovie();
        Map<String, String> movieRecord = extractRecord(MOVIES, MOVIE_ID_COL, movieId);
        if (!movieRecord.isEmpty()) {
            movie.setId(movieId);
            movie.setName(movieRecord.get(MOVIE_NAME_COL));
            movie.setDescription(movieRecord.get(MOVIE_DESCRIPTION_COL));
        }
        return movie;
    }


    public static ReturnValue addView(Integer viewerId, Integer movieId) {
        return addRecord(WATCHED, viewerId, movieId);
    }


    public static ReturnValue removeView(Integer viewerId, Integer movieId) {
        return removeRecord(WATCHED, viewerId, movieId);
    }


    public static Integer getMovieViewCount(Integer movieId) {
        return extractCount(
                String.format("SELECT COUNT(viewid) FROM %s WHERE movieid=%d",
                                WATCHED, movieId)
        );
    }


    public static ReturnValue addMovieRating(Integer viewerId, Integer movieId, MovieRating rating) {
        return addRecord(RANKS, viewerId, movieId, rating);
    }


    public static ReturnValue removeMovieRating(Integer viewerId, Integer movieId) {
        return removeRecord(RANKS, viewerId, movieId);
    }

    public static int getMovieLikesCount(int movieId) {
        return countRating(MovieRating.LIKE, movieId);

    }


    public static int getMovieDislikesCount(int movieId) {
        return countRating(MovieRating.DISLIKE, movieId);
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

    //------------------------------------------- PRIVATE METHODS ------------------------------------------------
    private static Integer extractCount(String query) {
        try (Connection conn = DBConnector.getConnection()) {
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        return Integer.valueOf(rs.getString(COUNT_COL));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static Map<String, String> extractRecord(String table_name, String idCol, Integer id) {
        Map<String, String> map = new HashMap<>();
        try (Connection connection = DBConnector.getConnection()) {
            String query = String.format("SELECT * FROM %s WHERE %s=%d", table_name, idCol, id);
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        final ResultSetMetaData metaData = rs.getMetaData();
                        for (int i = 0; i <= metaData.getColumnCount(); i++) {
                            map.put(metaData.getColumnLabel(i), rs.getString(i));
                        }

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
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

    private static ReturnValue addRecord(String tableName, Integer viewid, Integer movieid) {
        try {
            execute(
                    String.format("INSERT INTO %s (viewid, movieid) VALUES (%d, %d);"
                    , tableName, viewid, movieid)
            );
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    private static ReturnValue removeRecord(String tableName, Integer viewid, Integer movieid) {
        try {
            int r = executeAndUpdate(
                    String.format("DELETE FROM %s WHERE viewid = %d AND movieid = %d",
                            tableName, viewid, movieid)
            );
            if (r == 0) return ReturnValue.NOT_EXISTS;
        } catch (SQLException e) {
            return handleException(e);
        }
        return ReturnValue.OK;
    }

    private static ReturnValue addRecord(String tableName, Integer viewid, Integer movieid, MovieRating rating) {
        try {
            execute(String.format("INSERT INTO %s (viewid, movieid,isliked) VALUES (%d, %d,'%s') ON CONFLICT DO UPDATE", tableName, viewid, movieid, rating.toString()));
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    private static int countRating(MovieRating islike, Integer movieId) {

        return extractCount(
                String.format("SELECT COUNT(movieid) FROM %s WHERE isliked='%s' AND movieid=%d",
                        RANKS, islike.toString(), movieId)
        );


    }

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
            execute(String.format("DROP TABLE IF EXISTS %s CASCADE", tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createRankTable() {
        try {
            execute(String.format("DROP TYPE IF EXISTS %s", LIKED));
            execute(String.format("CREATE TYPE %s AS ENUM('%s','%s')", LIKED, MovieRating.LIKE.toString(), MovieRating.DISLIKE.toString()));
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


    private static ReturnValue deleteRecord(String tableName, String idColumn, int id) {
        try {
            int affectedRows = executeAndUpdate(
                    String.format("DELETE FROM %s WHERE %s = %d"
                            , tableName, idColumn, id));
            if (affectedRows == 0) {
                return ReturnValue.NOT_EXISTS;
            }
        } catch (SQLException e) {
            return handleException(e);
        }

        return ReturnValue.OK;
    }

    private static List<Integer> resultSetToList(ResultSet rs) throws SQLException {
        List<Integer> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getInt(1));
        }
        return list;
    }


}


