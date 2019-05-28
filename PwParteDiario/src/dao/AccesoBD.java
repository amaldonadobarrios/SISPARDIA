package dao;

import java.sql.*;

public class AccesoBD {
	public static Connection getConnection() throws Exception {
        Connection cn = null;
        try {
            //1- cargar driver en memoria
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            //url de la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            // obtener la conexion
            cn = DriverManager.getConnection(url, "hr", "hr");

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
        return cn;
    }
}
