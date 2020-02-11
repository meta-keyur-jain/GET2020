package com.metacube.parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * This servlet is used to add the vehicle details.
 */
@WebServlet("/vechiledetail")
public class vechiledetail extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		Connection con;
		try {

			String emailId = req.getParameter("email");
			con = javaConnection.initializeDatabase();
			String sql = "select * from userdetail where email=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, req.getParameter("email"));
			ResultSet rs = st.executeQuery();
			rs.next();

			int empId = rs.getInt("id");
			String vechileName = req.getParameter("vechilename");
			String vechileType = req.getParameter("vechiletype");
			String vechileNo = req.getParameter("vechileno");
			String vechileIdentification = req
					.getParameter("vechileidentification");
			st = con.prepareStatement("insert into vechiledetail values(?,?,?,?,?)");
			st.setInt(1, empId);
			st.setString(2, vechileName);
			st.setString(3, vechileType);
			st.setString(4, vechileNo);
			st.setString(5, vechileIdentification);
			st.executeUpdate();

			if (vechileType.equalsIgnoreCase("cycle")) {

				HttpSession session = req.getSession();
				session.setAttribute("vechile", "Cycle");
				session.setAttribute("priceDaily", 5);
				session.setAttribute("priceMonthly", 100);
				session.setAttribute("priceYearly", 500);
				res.sendRedirect("vechilePrice.jsp");
			} else if (vechileType.equalsIgnoreCase("motorCycle")) {

				HttpSession session = req.getSession();
				session.setAttribute("vechile", "MotorCycle");
				session.setAttribute("priceDaily", 10);
				session.setAttribute("priceMonthly", 200);
				session.setAttribute("priceYearly", 1000);
				res.sendRedirect("vechilePrice.jsp");

			} else if (vechileType.equalsIgnoreCase("fourWheelers")) {
				HttpSession session = req.getSession();
				session.setAttribute("vechile", "FourWheeler");
				session.setAttribute("priceDaily", 20);
				session.setAttribute("priceMonthly", 500);
				session.setAttribute("priceYearly", 3500);
				res.sendRedirect("vechilePrice.jsp");

			}
			// Close all the connections
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
