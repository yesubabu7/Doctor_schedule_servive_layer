package base.dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import base.daos.UserDAO;
import base.models.User;

public class UserDAL implements UserDAO {

	private static ArrayList<User> users = new ArrayList<>();

	public UserDAL() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "yesu";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);

			Statement st = connection.createStatement();
			String query = "select uid, uname, upass from venu_users";
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3)));
			}

			rs.close();
			st.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public ArrayList<User> getAllUsers() {
		return users;
	}

	@Override
	public User getUserById(String uId) {
		return users.get(Integer.parseInt(uId) - 1);
	}

}
