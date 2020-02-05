package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent")
public class addStudent extends HttpServlet {

	/**
	 * This class is used to add the student details to database
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		boolean flag = true;
		String checkEmail = req.getParameter("emailId");
		studentclass obj = new studentclass();
		obj.setFirstName(req.getParameter("firstName"));
		obj.setLastName(req.getParameter("lastName"));
		obj.setFatherName(req.getParameter("fatherName"));
		obj.setEmailId(req.getParameter("emailId"));
		obj.setClassName(Integer.valueOf(req.getParameter("class")));
		obj.setAge(Integer.valueOf(req.getParameter("age")));

		// Initialize the database and add values to database
		Connection con;
		try {
			con = javaConnection.initializeDatabase();

			PreparedStatement st = con
					.prepareStatement("insert into studentdetail values(id,?,?,?,?,?,?)");
			PrintWriter out = res.getWriter();

			st.setString(1, obj.getFirstName());
			st.setString(2, obj.getLastName());
			st.setString(3, obj.getFatherName());
			st.setString(4, obj.getEmailId());
			st.setInt(5, obj.getClassName());
			st.setInt(6, obj.getAge());

			// check Email that it is already exists or not
			String sql = "select * from studentdetail";
			Statement stmt = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("EmailId").equalsIgnoreCase(checkEmail)) {
					out.println("<html><body><b>Email Already Exists!!!!"
							+ "</b><br><a href=index.html><button>Home</button></a></body></html>");
					flag = false;
					break;
				}

			}

			
			if (flag) {
				st.executeUpdate();

				// Close all the connections
				st.close();
				con.close();

				out.println("<html><body><b>You are Successfully Registered"
						+ "</b><br><a href=index.html><button>Home</button></a></body></html>");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
}
