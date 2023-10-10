package conn.ads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainAds {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/hmw101023";
		String user = "root";
		String pass = "";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter the ad name: ");
			String title = input.nextLine();
			
			System.out.println("Enter the amount: ");
			int amount = input.nextInt();
			
			String published_at = "2020-6-13 19:24:56";
			
			String insertAdQuery = "insert into ads_table(title, amount, published_at) values " + "('" + title + "','" + amount +"','" + published_at + "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(insertAdQuery);
			
			String updateQuery = "update ads_table set amount = '98405' where title = 'Amazon: Before Alexa'";
			Statement stmt2 = conn.createStatement();
			stmt2.executeUpdate(updateQuery);
			
			String deleteQuery = "delete from ads_table where amount < 80000";
			Statement stmt3 = conn.createStatement();
			stmt3.executeUpdate(deleteQuery);
			
			String readAllQuery = "select * from ads_table";
			Statement stmt4 = conn.createStatement();
			ResultSet rs = stmt4.executeQuery(readAllQuery);
			while(rs.next()) {
				System.out.println(rs.getString("title") + " " + rs.getString("amount") + " " + rs.getString("published_at"));
			}
			
			conn.close();
			input.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
