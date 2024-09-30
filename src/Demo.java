import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class Demo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/practicedb";
		String userName = "root";
		String password = "root";
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection(url, userName, password);
		Statement stmt = con.createStatement();{
		int rowsEffected= stmt.executeUpdate("update student set marks='95' where id='102'");
		System.out.println("No.of rows effected: "+rowsEffected);
		ResultSet rs = stmt.executeQuery("select * from student");
		System.out.println("id\t name \t skill \t marks");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString(2);
			String skill = rs.getString(3);
			int marks = rs.getInt(4);
			System.out.println(id + " " + name + " " + skill + " " + marks + " ");
		}
		rs.close();
		stmt.close();
		con.close();

	}
	}}
