import java.sql.*;
	import com.mysql.cj.jdbc.Driver;
public class Demo1 {
		

		public static void main(String[] args) throws SQLException {
			String url = "jdbc:mysql://localhost:3306/practicedb";
			String userName = "root";
			String password = "root";
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement stmt = con.prepareStatement(password); {
			//stmt.executeUpdate("insert into student values(104,'Likki','Java',85)");
			//stmt.executeUpdate("insert into student values(105,'As','Python',75)");
			//stmt.executeUpdate("insert into student values(106,'Arvind','AI',98)");
			stmt.executeUpdate("update student set marks='95' where id='103'");
			stmt.executeUpdate("update student set name='Priya' where id='103'");
			stmt.executeUpdate("update student set skill='ML' where id='103'");
			stmt.executeUpdate("delete from student where id=105");
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
	}


}
