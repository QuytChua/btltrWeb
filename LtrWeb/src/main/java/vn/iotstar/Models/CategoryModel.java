package vn.iotstar.Models;

public class CategoryModel {
	private int categotyid;
	private String categoryname;
	private String images;
	private String status;
	public CategoryModel() {
		super();
	}

	public CategoryModel(int categotyid, String categoryname, String images, String status) {
		super();
		this.categotyid = categotyid;
		this.categoryname = categoryname;
		this.images = images;
		this.status = status;
	}
	
	public CategoryModel(String categoryname, String images, String status) {
		super();
		this.categoryname = categoryname;
		this.images = images;
		this.status = status;
	}

	public int getCategotyid() {
		return categotyid;
	}

	public void setCategotyid(int categotyid) {
		this.categotyid = categotyid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
