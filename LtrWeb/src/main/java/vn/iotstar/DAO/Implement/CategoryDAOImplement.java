package vn.iotstar.DAO.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.Configs.DBConnectMySQL;
import vn.iotstar.DAO.ICategoryDAO;
import vn.iotstar.Models.CategoryModel;

public class CategoryDAOImplement implements ICategoryDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<CategoryModel> findAll() {
		String query = "select * from categories";
		List<CategoryModel> categories = new ArrayList<>();
		try {
			conn = DBConnectMySQL.getDatabaseConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
						category.setCategotyid(rs.getInt("categoryid")); 
						category.setCategoryname(rs.getString("categoryname")); 
						category.setImages(rs.getString("images"));
						category.setStatus(rs.getString("status"));
			}
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public CategoryModel findAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CategoryModel> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
