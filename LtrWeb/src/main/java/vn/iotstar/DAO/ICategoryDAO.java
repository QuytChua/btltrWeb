package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Models.CategoryModel;

public interface ICategoryDAO {
	List<CategoryModel> findAll();
	CategoryModel findAll(int id);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	List<CategoryModel> search(String keyword);
}