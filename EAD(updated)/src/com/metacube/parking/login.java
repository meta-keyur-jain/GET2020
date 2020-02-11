package com.metacube.parking;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * This servlet is for authentication of password and email.
 */
@WebServlet("/login")
public class login extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		String emailId = req.getParameter("email");
		String password = req.getParameter("password");
		if (emailId == "" || password == "") {
			res.sendRedirect("login.html");
		}
		Connection con;
		PreparedStatement st = null, st1 = null;
		int id = 1;
		try {
			con = javaConnection.initializeDatabase();
			String sql = "select * from userdetail where email=?";
			st = con.prepareStatement(sql);
			st.setString(1, req.getParameter("email"));
			ResultSet rs = st.executeQuery();
			rs.next();

			String sql1 = "select * from vechiledetail where empid=?";
			st1 = con.prepareStatement(sql1);
			st1.setInt(1, rs.getInt("id"));
			ResultSet rs1 = st1.executeQuery();
			rs1.next();

			if (password.equals(rs.getString("password"))) {
				HttpSession session = req.getSession();
				session.setAttribute("email", emailId);
				session.setAttribute("id", rs.getInt("id"));
				session.setAttribute("name", rs.getString("fullName"));
				session.setAttribute("gender", rs.getString("gender"));
				session.setAttribute("contactno", rs.getString("contactNo"));
				session.setAttribute("organisation",
						rs.getString("organisation"));
				session.setAttribute("vechileName",
						rs1.getString("vechileName"));
				session.setAttribute("vechileType",
						rs1.getString("vechileType"));
				session.setAttribute("vechileNo", rs1.getString("vechileno"));
				session.setAttribute("vechileIdentity",
						rs1.getString("identification"));

				res.sendRedirect("showAfterLogin.jsp");
			} else {
				res.sendRedirect("login.html?id=" + id + "");

			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
