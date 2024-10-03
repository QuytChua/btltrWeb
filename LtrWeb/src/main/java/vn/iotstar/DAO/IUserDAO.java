package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Models.UserModel; 

public interface IUserDAO {
	List<UserModel> findAll();

	UserModel findById(int id);

	void insert(UserModel user);

	void updatePassword(String email, String NewPassword);

	UserModel findByUserName(String username);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);

	boolean checkExistEmail(String email);
	
	void updateProfile(String fullname, String phone, String images, String username);

}
