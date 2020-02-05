package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Keyur
 *This class is used to search the student on the basis of its first and last name
 */
@WebServlet("/searchStudent")
public class searchStudent extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("<html><body><table>");

		try {
			String fname = req.getParameter("firstName");
			String lname = req.getParameter("lastName");
			conn = javaConnection.initializeDatabase();
			String query = "select * from studentdetail where FirstName LIKE '%"
					+ fname + "%' OR LasstName LIKE '%" + lname + "%' ";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				out.print("<tr><td>" + rs.getInt("id") + "</td>" + "<td>"
						+ rs.getString("FirstName") + "</td>" + "<td>"
						+ rs.getString("LasstName") + "</td>" + "<td>"
						+ rs.getString("FatherName") + "</td>" + "<td>"
						+ rs.getString("EmailId") + "</td>" + "<td>"
						+ rs.getInt("class") + "</td>" + "<td>"
						+ rs.getInt("age") + "</td>");

			}
			out.println("</table>");
			out.println("</body></html>");
			conn.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
