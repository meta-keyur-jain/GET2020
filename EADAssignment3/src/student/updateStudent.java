package student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author Keyur
 *This class is used to change the existing value in the database.
 */
@WebServlet("/updateStudent")
public class updateStudent extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		Integer idNo = Integer.parseInt(req.getParameter("id"));
		studentclass obj = new studentclass();
		obj.setid(idNo);
		obj.setFirstName(req.getParameter("firstName"));
		obj.setLastName(req.getParameter("lastName"));
		obj.setFatherName(req.getParameter("fatherName"));
		obj.setEmailId(req.getParameter("emailId"));
		obj.setClassName(Integer.valueOf(req.getParameter("class")));
		obj.setAge(Integer.valueOf(req.getParameter("age")));

		// Initialize the database
		Connection con;
		try {
			con = javaConnection.initializeDatabase();
			String query = "update studentdetail SET FirstName=?,LasstName=?,FatherName=?,EmailId=?,class=?,age=? where id=?";
			PreparedStatement st = con.prepareStatement(query);

			st.setString(1, obj.getFirstName());
			st.setString(2, obj.getLastName());
			st.setString(3, obj.getFatherName());
			st.setString(4, obj.getEmailId());
			st.setInt(5, obj.getClassName());
			st.setInt(6, obj.getAge());
			st.setInt(7, obj.getid());

			// Execute the insert command using executeUpdate()
			// to make changes in database
			st.executeUpdate();

			// Close all the connections
			st.close();
			con.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
