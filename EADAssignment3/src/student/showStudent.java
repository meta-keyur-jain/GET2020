package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Keyur
 *This class is used to show the details of all the students
 */
@WebServlet("/showStudent")
public class showStudent extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		out.print("<html><body><table>");

		try {
			conn = javaConnection.initializeDatabase();
			String sql = "select * from studentdetail";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				int id = rs.getInt("id");
				out.print("<tr><td>" + rs.getInt("id") + "</td>" + "<td>"
						+ rs.getString("FirstName") + "</td>" + "<td>"
						+ rs.getString("LasstName") + "</td>" + "<td>"
						+ rs.getString("FatherName") + "</td>" + "<td>"
						+ rs.getString("EmailId") + "</td>" + "<td>"
						+ rs.getInt("class") + "</td>" + "<td>"
						+ rs.getInt("age") + "</td>"
						+ "<td><a href = updatestudent.jsp?id=" + id
						+ "&firstName=" + rs.getString("FirstName")
						+ "&lastName=" + rs.getString("LasstName")
						+ "&fatherName=" + rs.getString("FatherName")
						+ "&emailId=" + rs.getString("EmailId") + "&age="
						+ rs.getInt("age") + "&className="
						+ rs.getInt("class") + "&><button>" + "Update"
						+ "</button></a>" + "</td></tr>");

			}

			out.println("</table>");
			out.println("</body></html>");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
