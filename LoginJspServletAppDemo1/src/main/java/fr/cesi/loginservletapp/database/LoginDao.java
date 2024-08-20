package fr.cesi.loginservletapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import fr.cesi.loginservletapp.bean.LoginBean;

public class LoginDao {
	public boolean validate(LoginBean loginBean)throws ClassNotFoundException{
		boolean status = false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bdd_logindemo1?serverTimezone=UTC", "root", "Guinee1958.");
				PreparedStatement preparedStatement  = connection .prepareStatement(
						"SELECT * FROM login WHERE username = ? and password = ?")
				){
			
			preparedStatement.setString(1, loginBean.getUsername());
			preparedStatement.setString(2, loginBean.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	private void printSQLExeception(SQLException ex) {
		for(Throwable e : ex) {
			if(e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLstate: " + ((SQLException)e).getSQLState());
				System.err.println("SQLstate: " + ((SQLException)e).getErrorCode());
				System.err.println("Message :"+e.getMessage());
				Throwable t = ex.getCause();
				while(t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
