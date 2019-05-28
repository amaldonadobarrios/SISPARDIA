package test;

import java.sql.Connection;

import dao.AccesoBD;

public class TestConexion {

	public static void main(String[] args) {
		try {

			Connection con = AccesoBD.getConnection();
			System.out.println("conexion exitosa");
			con.close();
		} catch (Exception e) {

			System.out.println("Error");
		}

	}

}


//conexion exitosa  con oracle