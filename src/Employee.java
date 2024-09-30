import java.sql.*;
import com.mysql.cj.jdbc.Driver;
public class Employee {
	public static void main(String[] args) throws SQLException {
	String url = "jdbc:mysql://localhost:3306/practicedb";
	String userName = "root";
	String password = "root";
	Driver d = new Driver();
	DriverManager.registerDriver(d);
	Connection con1 = DriverManager.getConnection(url, userName, password);
	Statement stmt = con1.createStatement();{
	int rowsEffected= stmt.executeUpdate("update Employee set sal='95000' where id='12'");
	System.out.println("No.of rows effected: "+rowsEffected);
	ResultSet rs = stmt.executeQuery("select * from Employee");
	System.out.println("id\t name \t name \t sal");
	while (rs.next()) {
		int id = rs.getInt("id");
		String name = rs.getString(2);
		int sal = rs.getInt(3);
		System.out.println(id + " " + name + " " + sal + " " );
	}
	rs.close();
	stmt.close();
	con1.close();

}
}}