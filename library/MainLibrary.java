package conn.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainLibrary {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/hmw101023";
		String user = "root";
		String pass = "";
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);
			 Scanner input = new Scanner(System.in)){
		
		System.out.println("Enter the author's name: ");
		String author = input.nextLine();
		
		System.out.println("Enter the genre: ");
		String genre = input.nextLine();
		
		System.out.println("Enter an amount which you would donate: ");
		int price = input.nextInt();
		
		String insertBooksQuery = "insert into books_table(author, genre, price) values " + "('" + author + "','" + genre +"','" + price+ "')";
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(insertBooksQuery);
		
		String updateQuery = "update books_table set author = 'Mark' where bookID = 5";
		Statement stmt2 = conn.createStatement();
		stmt2.executeUpdate(updateQuery);
		
		String deleteQuery = "delete from books_table where price < 40000";
		Statement stmt3 = conn.createStatement();
		stmt3.executeUpdate(deleteQuery);
		
		String readAllQuery = "select * from books_table";
		Statement stmt4 = conn.createStatement();
		ResultSet rs = stmt4.executeQuery(readAllQuery);
		while(rs.next()) {
			System.out.println(rs.getString("author") + " " + rs.getString("genre") + " " + rs.getString("price"));
		}
		
		conn.close();
		input.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
