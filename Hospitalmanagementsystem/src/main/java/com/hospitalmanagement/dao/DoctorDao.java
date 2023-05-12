package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospitalmanagment.entity.Doctor;

public class DoctorDao {
	Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con=con;
	}
	public boolean registerDoctor(Doctor d) {
		boolean f = false;
		try {
			String query = "insert into doctor(fullname,dob,qualification,specialist,email,mobno,password) values(?,?,?,?,?,?,?)";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobno());
			pst.setString(7, d.getPassword());
			
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	public List<Doctor> getAllDoctor() {
		List<Doctor> list = new ArrayList<Doctor>();
		Doctor d = null;
		try {

			String sql = "select * from doctor order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		
	public Doctor getDoctorById(int id) {
		Doctor d = null;
		try {

			String sql = "select * from doctor where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	public boolean updateDoctor(Doctor d) {
		boolean f = false;
		try {
			String query = "update doctor set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobno=?,password=? where id=?";
			PreparedStatement pst = this.con.prepareStatement(query);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobno());
			pst.setString(7, d.getPassword());
			pst.setInt(8, d.getId());
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
		
	}
	public boolean deleteDoctor(int id) {
		boolean f = false;
		try {
			String query = "delete from doctor where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}


			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public Doctor login(String email, String psw) {
		Doctor d = null;
		try {

			String sql = "select * from doctor where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, psw);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				d = new Doctor();
				d = new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobno(rs.getString(7));
				d.setPassword(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return d;
	}
	
	public int countDoctor() {
		int i = 0;
		try {
			String sql = "select * from doctor";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointment() {
		int i = 0;
		try {
			String sql = "select * from appointment";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countAppointmentByDocotrId(int did) {
		int i = 0;
		try {
			String sql = "select * from appointment where doctor_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, did);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countUSer() {
		int i = 0;
		try {
			String sql = "select * from userdata";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public int countSpecialist() {
		int i = 0;
		try {
			String sql = "select * from specialist";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;
	}

	public boolean checkOldPassword(int userid, String oldPassword) {
		boolean f = false;

		try {
			String sql = "select * from doctor where id=? and password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userid);
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

	public boolean changePassword(int userid, String newPassword) {
		boolean f = false;

		try {
			String sql = "update doctor set password=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setInt(2, userid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean editDoctorProfile(Doctor d) {
		boolean f = false;

		try {
			String sql = "update doctor set fullname=?,dob=?,qualification=?,specialist=?,email=?,mobno=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getFullname());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getMobno());
			ps.setInt(7, d.getId());
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
