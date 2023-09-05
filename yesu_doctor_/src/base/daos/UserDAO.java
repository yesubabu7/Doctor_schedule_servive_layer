package base.daos;

import java.util.ArrayList;

import base.models.User;

public interface UserDAO {

	public ArrayList<User> getAllUsers();

	public User getUserById(String uId);

}
