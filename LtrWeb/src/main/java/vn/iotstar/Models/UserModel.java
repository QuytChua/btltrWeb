package vn.iotstar.Models;

import java.sql.Date;
@SuppressWarnings("serial")
public class UserModel  {
	
		private int id;
		private String userName;
		private String passWord;
		private String email;
		private String fullName;
		private String images;
		private int roleid;
		private String phone;
		private Date createdDate;

		public UserModel() {

		}

		public UserModel(String userName, String passWord, String email, String fullName, String images, int roleid,
				String phone, Date createdDate) {
			super();
			this.userName = userName;
			this.passWord = passWord;
			this.email = email;
			this.fullName = fullName;
			this.images = images;
			this.roleid = roleid;
			this.phone = phone;
			this.createdDate = createdDate;
		}

		public UserModel(int id, String userName, String passWord, String email, String fullName, String images, int roleid,
				String phone, Date createdDate) {
			super();
			this.id = id;
			this.userName = userName;
			this.passWord = passWord;
			this.email = email;
			this.fullName = fullName;
			this.images = images;
			this.roleid = roleid;
			this.phone = phone;
			this.createdDate = createdDate;
		}

		@Override
		public String toString() {
			return "UserModel [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
					+ ", fullName=" + fullName + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
					+ ", createdDate=" + createdDate + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFullName() {
			return fullName;
		}

		public void setFullName(String fullName) {
			this.fullName = fullName;
		}

		public String getImages() {
			return images;
		}

		public void setImages(String avatar) {
			this.images = images;
		}

		public int getRoleid() {
			return roleid;
		}

		public void setRoleid(int roleid) {
			this.roleid = roleid;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

}
