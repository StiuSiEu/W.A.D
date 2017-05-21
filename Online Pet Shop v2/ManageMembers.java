import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageMembers {

	private static Connection conn;

	private static void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("Connected to MySQL server");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ManageMembers.getConnection();

		ManageMembers.deleteAll();

		ManageMembers.insert(1, "Cosmin");
		ManageMembers.insert(2, "Gabriel");

		short count = ManageMembers.getList();

		if (count == 0)
			System.out.println("There are no members");
		else
			System.out.println("There are " + count + " members in the DB");

		ManageMembers.closeConnection();

	}

	private static int getList() {
		PreparedStatement ps = conn.prepareStatement("select * from memebers");
		ResultSet rs = ps.executeQuery();

		int count = 0;

		while (rs.next()) {
			count++;
			System.out.println("ID: " + rs.getInt("id") + " -> Name:" + rs.getString("name"));
		}
		return count;
	}

	private static void insert(int id, String name) {
		PreparedStatement ps = conn.prepareStatement("insert into memebers (id, name) values (?, ?)");
		ps.setInt(1, x);
		ps.setString(2, name);
		ps.executeUpdate();
		System.out.println("Member " + name + " has been added to DB");
	}

	private static void deleteAll() throws SQLException {
		PreparedStatement ps = conn.prepareStatement("delete from memebers");
		ps.executeUpdate();
		System.out.println("Deleted all memebers data");
	}
	
	private static void deleteMember(String name){
		PreparedStatement ps = conn.prepareStatement("delete from members where name = " + name);
		ps.executeUpdate();
		System.out.println("Deleted member: " + name);
	}
	
	private static void updatePrivileges(String name, String role){
		PreparedStatement ps = conn.prepareStatement("update members set role = " + role + " where name = " + name);
		ps.executeUpdate();
	}

	private static void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			// do nothing
		}
	}

}
