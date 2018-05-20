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
import java.util.Map;

public class Solution {

    public static final String ISLIKED = "isliked";
    /* TABLES */
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
    public static final String RANK_VIEWID_COL = "viewid";
    public static final String RANK_MOVIEID_COL = "movieid";

    public static void createTables() {
        createViewerTable();
        createMovieTable();
        createRankTable();
    }

    public static void clearTables() {
        clearTable(RANKS);
        clearTable(MOVIES);
        clearTable(VIEWERS);
    }


    public static void dropTables() {
        dropTable(RANKS);
        try {
            execute(String.format("DROP TYPE IF EXISTS %s", LIKED));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dropTable(MOVIES);
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
        return updateRecord(VIEWERS, VIEWER_NAME_COL, viewer.getName(), VIEWER_ID_COL, viewer.getId());
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
        return addRecord(RANKS, viewerId, movieId);
    }


    public static ReturnValue removeView(Integer viewerId, Integer movieId) {
        return removeRecord(RANKS, viewerId, movieId);
    }


    public static Integer getMovieViewCount(Integer movieId) {
        return extractCount(
                String.format("SELECT COUNT(viewid) FROM %s WHERE movieid=%d",
                        RANKS, movieId)
        );
    }


    public static ReturnValue addMovieRating(Integer viewerId, Integer movieId, MovieRating rating) {
        try {
            String rateStatus = rating != null ? "'" + rating.toString() + "'" : null;
            int affectedRows = executeAndUpdate(
                    String.format(
                            "UPDATE %s SET %s =%s WHERE %s = %d AND %s = %d",
                            RANKS, ISLIKED, rateStatus, RANK_VIEWID_COL, viewerId, RANK_MOVIEID_COL, movieId
                    )
            );
            if (0 == affectedRows) return ReturnValue.NOT_EXISTS;
        } catch (SQLException e) {
            return ReturnValue.ERROR;
        }
        return ReturnValue.OK;
    }


    public static ReturnValue removeMovieRating(Integer viewerId, Integer movieId) {
        return addMovieRating(viewerId, movieId, null);
    }

    public static int getMovieLikesCount(int movieId) {
        return countRating(MovieRating.LIKE, movieId);

    }


    public static int getMovieDislikesCount(int movieId) {
        return countRating(MovieRating.DISLIKE, movieId);
    }

    public static ArrayList<Integer> getSimilarViewers(Integer viewerId) {
        String subQuery = new StringBuilder()
                .append("SELECT COUNT(other.viewid),other.viewid \n")
                .append("FROM ranks AS other INNER JOIN ranks ON(ranks.movieid = other.movieid)\n")
                .append("WHERE ranks.viewid=%d AND other.viewid!=%d\n")
                .append("GROUP BY other.viewid").toString();
        String mainQuery = new StringBuilder()
                .append("SELECT temprank.viewid FROM (")
                .append(subQuery)
                .append(")AS temprank ")
                .append("WHERE temprank.count*1.0/(SELECT COUNT(viewid) FROM ranks WHERE viewid = %d) >= 0.75\n")
                .append("ORDER BY temprank.viewid ASC").toString();
        String query = String.format(mainQuery, viewerId, viewerId, viewerId);
        return extractIdsFromQuery(query);
    }


    public static ArrayList<Integer> mostInfluencingViewers() {
        String query = new StringBuilder()
                .append("SELECT viewid\n")
                .append("FROM ranks\n")
                .append("GROUP BY viewid \n")
                .append("ORDER BY COUNT(viewid) DESC,COUNT(isliked) DESC, viewid ASC\n")
                .append("LIMIT 10").toString();
        return extractIdsFromQuery(query);
    }


    public static ArrayList<Integer> getMoviesRecommendations(Integer viewerId) {

        return null;
    }


    public static ArrayList<Integer> getConditionalRecommendations(Integer viewerId, int movieId) {

        return null;
    }

    //------------------------------------------- PRIVATE METHODS ------------------------------------------------

    private static ArrayList<Integer> extractIdsFromQuery(String query) {
        try (Connection connection = DBConnector.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet rs = preparedStatement.executeQuery()) {
                    return resultSetToList(rs);
                }
            }
        } catch (SQLException e) {
        }

        return new ArrayList<>();
    }

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
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
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
            return ReturnValue.ERROR;
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
            execute(
                    String.format("CREATE TABLE %s (%s integer NOT NULL,%s text NOT NULL, PRIMARY KEY (%s),CHECK(%s>0))"
                            , VIEWERS, VIEWER_ID_COL, VIEWER_NAME_COL, VIEWER_ID_COL, VIEWER_ID_COL)
            );
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
            //execute(String.format("DROP TYPE IF EXISTS %s", LIKED));
            execute(String.format("CREATE TYPE %s AS ENUM('%s','%s')", LIKED, MovieRating.LIKE.toString(), MovieRating.DISLIKE.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            execute(new StringBuilder()
                    .append("CREATE TABLE ranks(\n")
                    .append("viewid integer NOT NULL ,\n")
                    .append("movieid integer NOT NULL ,\n")
                    .append("isliked liked,\n")
                    .append("CONSTRAINT pk_MovieAndView PRIMARY KEY (movieid,viewid),\n")
                    .append("CONSTRAINT fk_movie FOREIGN KEY (movieid)\n")
                    .append("REFERENCES movies (mid)\n")
                    .append("ON UPDATE CASCADE\n")
                    .append("ON DELETE CASCADE,\n")
                    .append("CONSTRAINT fk_viewrs FOREIGN KEY (viewid)\n")
                    .append("REFERENCES viewers (vid)\n")
                    .append("ON UPDATE CASCADE\n")
                    .append("ON DELETE CASCADE\n")
                    .append(")").toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMovieTable() {
        try {
            String query = String.format(
                    "CREATE TABLE %s (%s integer NOT NULL,%s text,%s text NOT NULL,PRIMARY KEY (%s),CHECK(%s>0))",
                    MOVIES, MOVIE_ID_COL, MOVIE_NAME_COL, MOVIE_DESCRIPTION_COL, MOVIE_ID_COL, MOVIE_ID_COL
            );
            execute(query);
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
            return ReturnValue.ERROR;
        }

        return ReturnValue.OK;
    }

    private static ArrayList<Integer> resultSetToList(ResultSet rs) throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getInt(1));
        }
        return list;
    }


}


