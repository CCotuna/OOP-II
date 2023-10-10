package conn.fitness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainFItness {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hmw101023";
		String user = "root";
		String pass = "";
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);
			 Scanner input = new Scanner(System.in)){
		
		System.out.println("Enter your name: ");
		String name = input.nextLine();
		
		System.out.println("Enter your email: ");
		String email = input.nextLine();
		
		System.out.println("Enter your fitness goal: ");
		String fitgoal = input.nextLine();
		
		System.out.println("Enter your age: ");
		int age = input.nextInt();
		
		
		
		String insertFitnessQuery = "insert into fitness_table(name, email, age, fitness_goals) values " + "('" + name+ "','" + email +"','" + age+ "','" + fitgoal + "')";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(insertFitnessQuery);
		
		String updateQuery = "update fitness_table set fitness_goals = 'Maintain a good discipline' where userID = 1";
		Statement stmt4 = conn.createStatement();
		stmt4.executeUpdate(updateQuery);
		
		String deleteQuery = "delete from fitness_table where fitness_goals = ''";
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(deleteQuery);
		
		String readAllQuery = "select * from fitness_table";
		Statement stmt3 = conn.createStatement();
		ResultSet rs = stmt3.executeQuery(readAllQuery);
		while(rs.next()) {
			System.out.println(rs.getString("name") + " " + rs.getString("age") + " " + rs.getString("fitgoal"));
		}
		
		conn.close();
		input.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
