package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hospitalmanagment.entity.User;



public class Userdao{
	
	Connection con;
	
	public Userdao(Connection con1) {
		con=con1;
		System.out.println("userdao"+con);
	}
	
	
	public boolean insert(User um) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			System.out.println("userdao");
			String query = "insert into userdata(email_id,fname,password) values(?,?,?)";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, um.getEmail());
			pst.setString(2, um.getFname());
			pst.setString(3, um.getPassword());
			

			if (pst.executeUpdate() != 0) {
				System.out.println("Inserted");
			} else {
				System.out.println("Insertion Fail");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return false;
	}
	
	public User loginByemail(String em, String ps) {
		User u = null;

		try {
			String q = "select * from userdata where email_id=? and password=?";
			PreparedStatement pst = this.con.prepareStatement(q);
			pst.setString(1, em);
			pst.setString(2, ps);
			ResultSet r = pst.executeQuery();

			if (r.next()) {
				u = new User();
				u.setEmail(r.getString("email_id"));
				u.setFname(r.getString("fname"));
				
				u.setPassword(r.getString("password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;

	}
	
	public boolean checkOldPassword(String userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from userdata where email_id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, oldPassword);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean changePassword(String email, String newPassword) {
		boolean f = false;

		try {
			String sql = "update userdata set password=? where email_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, email);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}



	
}
