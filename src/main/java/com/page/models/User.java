package com.page.models;

public class User {
	private String fname;
	private String lname;
	private String email;
	private String phnum;
	private String password;
	private String cpassword ;
	private int age;
	private String gender;
	public User() {
		
	}
	
	public User(String fname, String lname, String email, String phnum, String password, int age, String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phnum = phnum;
		this.password = password;
		this.age = age;
		this.gender = gender;
	}

	public User(String fname, String lname, String email, String phnum, String password, String cpassword, int age,
			String gender) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phnum = phnum;
		this.password = password;
		this.cpassword = cpassword;
		this.age = age;
		this.gender = gender;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		
		return "User ["+fname+" "+lname+" ]";
	}

}





//
//<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Schools</title>
//<meta name="viewport" content="width=device-width, initial-scale=1.0">
//    
//<link rel="stylesheet" href="cards.css">
//</head>
//<body>
//   <!-- <jsp:include page="navbar.jsp" /> --> 
//
//    <div class="banner-container">
//        <img src="https://placehold.co/1200x300/6c63ff/ffffff?text=Delicious+Food+Delivered+To+You" alt="Food Banner" class="banner-image">
//    </div>
//
//    <main class="content-wrapper">
//        <h1 class="section-heading">Schools</h1>
//
//      
//    </main>
//
//   
//
//</body>
//</html>
