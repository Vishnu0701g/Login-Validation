package com.page.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.page.models.User;
import com.app.util.DBConnection;
import com.page.dao.UserDao;

public class UserDaoImpl implements UserDao{

	private String INSERT_USER_QUERY="INSERT into `user`(`fname`,`lname`,`email`,`phnum`,`password`,`age`,`gender`) values (?,?,?,?,?,?,?)";
	private String GET_USER_PASSWORD="SELECT * from `user` where `email`=?";
	private String GET_USER_QUERY="SELECT * from `user` where `email`=?";

	@Override
	public int addUser(User user) {
		int result = 0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USER_QUERY);)
		{
			preparedStatement.setString(1,user.getFname());
			preparedStatement.setString(2,user.getLname());
			preparedStatement.setString(3,user.getEmail());
			preparedStatement.setString(4,user.getPhnum());
			preparedStatement.setString(5,user.getPassword());
			preparedStatement.setInt(6,user.getAge());
			preparedStatement.setString(7,user.getGender());

			result = preparedStatement.executeUpdate();



		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;


	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String emailEntered) {
		User user=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(GET_USER_QUERY);)
			{
			preparedStatement.setString(1,emailEntered);
				
				
				ResultSet resultSet  = preparedStatement.executeQuery();
				while(resultSet.next()) {
					String fname = resultSet.getString("fname");
					String lname = resultSet.getString("lname");
					String password = resultSet.getString("password");
					String email = resultSet.getString("email");
					String phnum = resultSet.getString("phnum");
					int age = resultSet.getInt("age");
					String gender = resultSet.getString("gender");
				
					user=new User(fname, lname,email, phnum,password, age, gender);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub

	}
	@Override
	public String getUserPassword(String emailEntered) {
		String password="";
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(GET_USER_PASSWORD);)
		{
			preparedStatement.setString(1,emailEntered);


			ResultSet resultSet  = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String fname = resultSet.getString("fname");
				String lname = resultSet.getString("lname");
				String email= resultSet.getString("email");
				String phonenumber = resultSet.getString("phnum");
				password = resultSet.getString("password");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");

			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	@Override
	public boolean isEmailRegistered(String email) {
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(GET_USER_PASSWORD);)
		{
			preparedStatement.setString(1,email);
			ResultSet resultSet  = preparedStatement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
