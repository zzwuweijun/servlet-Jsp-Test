package com.sz.pojo;

public class User {
	
	private int id;
	private String uname;
	private String pwd;
	private String sex;
	private int age;
	private String birth;
	
	public User(int id, String uname, String pwd, String sex, int age, String birth) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
		this.birth = birth;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", sex=" + sex + ", age=" + age + ", birth="
				+ birth + "]";
	}


	

}
