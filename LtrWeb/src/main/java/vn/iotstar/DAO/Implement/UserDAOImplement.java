package vn.iotstar.DAO.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.Configs.DBConnectMySQL;
import vn.iotstar.DAO.IUserDAO;
import vn.iotstar.Models.UserModel;

public class UserDAOImplement implements IUserDAO {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String query = "select * from users";
		List<UserModel> list = new ArrayList<>();
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("images"),
						rs.getInt("roleid"), rs.getString("phone"), rs.getDate("createDate")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String query = "SELECT * FROM users where id = ? ";
		UserModel user = null;
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("images"),
						rs.getInt("roleid"), rs.getString("phone"), rs.getDate("createDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void insert(UserModel user) {
		List<UserModel> users = findAll();
		String query = "insert into users (username, password, email,"
				+ "fullname, images, roleid, phone, createDate)" + " values (?,?,?,?,?,?,?,?)";
		for (UserModel existingUser : users) {
			if (existingUser.getUserName().equals(user.getUserName())) {
				break;
			}
		}
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWord());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getImages());
			ps.setInt(6, user.getRoleid());
			ps.setString(7, user.getPhone());
			ps.setDate(8, user.getCreatedDate());
			ps.executeUpdate();
			System.out.println("Đã tạo tài khoản thành công");
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePassword(String email, String newPassword) {
		String query = "update users set password = ? where email= ?";

		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newPassword);
			ps.setString(2, email);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public UserModel findByUserName(String username) {
		String query = "SELECT * FROM users where username = ? ";
		UserModel user = null;
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("fullname"), rs.getString("images"),
						rs.getInt("roleid"), rs.getString("phone"), rs.getDate("createDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from users where email = ?";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "select * from users where username = ?";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "select * from users where phone = ?";
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}
	

	public void updateProfile(String fullname, String phone, String path_image, String username) {
		String query = "update users set fullname = ?, phone = ?, images = ? where username = ?";

		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, phone);
			ps.setString(3, path_image);
			ps.setString(4, username);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) {
		try {
			UserDAOImplement userDao = new UserDAOImplement();
			new DBConnectMySQL();
			System.out.println(userDao.findAll());
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
	}
}
