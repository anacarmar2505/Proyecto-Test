package com.ecodeup.test;

import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO {
	private Conexion con;
	
	public TestDAO(String jdbcURL, String jdbcUserName, String jdbcPassword)throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		//con.connection();
		System.out.println("Se imprime la conexión "+con.getJdbcConection());
	}
	
	public boolean registrar(Articulo a) {
		boolean estado = false;
		Statement stm;
		
		String sql = "INSERT INTO articulos VALUES(null,'"+a.getNombre()+"','"+a.getDescripcion()+"',"+a.getPrecio()+")";
		
		try {
			con.conexion();
			stm=con.getJdbcConection().createStatement();
			stm.executeUpdate(sql);
			estado = true;
			stm.close();
			con.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			estado = false;
			e.printStackTrace();
		}
		
		return estado;
		
	}

}
