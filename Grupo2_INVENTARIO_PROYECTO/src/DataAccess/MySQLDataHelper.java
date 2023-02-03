/*  Copyright (C) 2K23, patmic
 *  pat_mic@hotmail.com
 *  Version 1.0
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <b> SQLiteDataHelper, </b> permite la gestion y el acceso a los datos a una
 * base de datos SQLite3
 */
public abstract class MySQLDataHelper {
    private static String DBPathConnection = null;
    private static Connection conn = null;

    public MySQLDataHelper(String dbPathConnection) {
        // Definir la cadena de conneccion : jdbc:sqlite:data\\TinderPet.db
        if (!dbPathConnection.isEmpty())
            MySQLDataHelper.DBPathConnection = dbPathConnection;
    }

    /**
     * getDBConnection, obtiene el cadena de coneccion a la base de datos
     * 
     * @return
     */
    protected String getDBConnection() {
        return DBPathConnection;
    }

    /**
     * <b>connSQLITE</b>, permite crear una sola instancia-Singeton para la
     * coneccion a la base de datos
     * 
     * @return retorna coneccion a la base de datos definida en el contructor
     * @throws SQLException
     */
    protected static Connection getConnection() throws SQLException {
        if (conn == null)
            conn = DriverManager.getConnection(DBPathConnection);
        return conn;
    }

    protected static ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        // try {
        conn = getConnection(); // jdbc:sqlite:data\\TinderPet.db
        stmt = conn.createStatement(); // CRUD : select * ...
        rs = stmt.executeQuery(sql); //
        // }
        // catch (SQLException e) {
        // System.out.println(e.getMessage());
        // throw new AppException(APP.GLOBAL.DB_EXCEPTION,"Failed to connect to
        // database", e);
        // }
        return rs;
    }

    // public void onOpen(SQLiteDatabase db) {}
    // /**
    // * Close any open database object.
    // */
    // public synchronized void close() {
    // if (mIsInitializing) throw new IllegalStateException("Closed during
    // initialization");
    // if (mDatabase != null && mDatabase.isOpen()) {
    // mDatabase.close();
    // mDatabase = null;
    // }
    // }
}

/*
 * ref:
 * https://android.googlesource.com/platform/frameworks/base/+/master/core/java/
 * android/database/sqlite/SQLiteOpenHelper.java
 */