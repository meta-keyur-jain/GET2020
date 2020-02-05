package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author Keyur
 *This class is used to sort the data on basis of class of student
 */
@WebServlet("/studentFilter")
public class studentFilter extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("<html><body><table>");

		try {
			conn = javaConnection.initializeDatabase();
			String sql = "SELECT * FROM studentdetail" + " ORDER BY class ASC";
			;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				out.print("<tr><td>" + rs.getInt("id") + "</td>" + "<td>"
						+ rs.getString("FirstName") + "</td>" + "<td>"
						+ rs.getString("LasstName") + "</td>" + "<td>"
						+ rs.getString("FatherName") + "</td>" + "<td>"
						+ rs.getString("EmailId") + "</td>" + "<td>"
						+ rs.getInt("class") + "</td>" + "<td>"
						+ rs.getInt("age") + "</td></tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
