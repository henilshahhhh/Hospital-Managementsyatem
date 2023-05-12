package com.hospitalmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hospitalmanagment.entity.Appointment;

public class AppointmentDao {
	Connection con;

	public AppointmentDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addAppointment(Appointment ap) {
		boolean f = false;

		try {

			String sql = "insert into appointment(fullname,gender,age,appoin_date,email,phone,diseases,doctor_id,address,status) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ap.getFullName());
			ps.setString(2, ap.getGender());
			ps.setString(3, ap.getAge());
			ps.setString(4, ap.getAppoinDate());
			ps.setString(5, ap.getEmail());
			ps.setString(6, ap.getPhNo());
			ps.setString(7, ap.getDiseases());
			ps.setInt(8, ap.getDoctorId());
			ps.setString(9, ap.getAddress());
			ps.setString(10, ap.getStatus());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointmentByLoginUser(String email) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where email=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setFullName(rs.getString(2));
				ap.setGender(rs.getString(3));
				ap.setAge(rs.getString(4));
				ap.setAppoinDate(rs.getString(5));
				ap.setEmail(rs.getString(6));
				ap.setPhNo(rs.getString(7));
				ap.setDiseases(rs.getString(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setAddress(rs.getString(10));
				ap.setStatus(rs.getString(11));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public List<Appointment> getAllAppointmentByDoctorLogin(int id) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment where doctor_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setFullName(rs.getString(2));
				ap.setGender(rs.getString(3));
				ap.setAge(rs.getString(4));
				ap.setAppoinDate(rs.getString(5));
				ap.setEmail(rs.getString(6));
				ap.setPhNo(rs.getString(7));
				ap.setDiseases(rs.getString(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setAddress(rs.getString(10));
				ap.setStatus(rs.getString(11));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Appointment getAllAppointmentById(int id) {
		Appointment ap = null;

		try {

			String sql = "select * from appointment where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setFullName(rs.getString(2));
				ap.setGender(rs.getString(3));
				ap.setAge(rs.getString(4));
				ap.setAppoinDate(rs.getString(5));
				ap.setEmail(rs.getString(6));
				ap.setPhNo(rs.getString(7));
				ap.setDiseases(rs.getString(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setAddress(rs.getString(10));
				ap.setStatus(rs.getString(11));
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ap;
	}
	
	public boolean updateCommentStatus(int id, int doctId, String comm) {
		boolean f = false;
		try {
			String sql = "update appointment set status=? where id=? and doctor_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, comm);
			ps.setInt(2, id);
			ps.setInt(3, doctId);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment ap = null;

		try {

			String sql = "select * from appointment order by id desc";
			PreparedStatement ps = con.prepareStatement(sql);
		

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();
				ap.setId(rs.getInt(1));
				ap.setFullName(rs.getString(2));
				ap.setGender(rs.getString(3));
				ap.setAge(rs.getString(4));
				ap.setAppoinDate(rs.getString(5));
				ap.setEmail(rs.getString(6));
				ap.setPhNo(rs.getString(7));
				ap.setDiseases(rs.getString(8));
				ap.setDoctorId(rs.getInt(9));
				ap.setAddress(rs.getString(10));
				ap.setStatus(rs.getString(11));
				list.add(ap);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}






}
