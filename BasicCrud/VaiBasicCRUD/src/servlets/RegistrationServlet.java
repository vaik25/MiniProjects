package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class RegistrationServlet extends HttpServlet {
	DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		saveUser(req);
		resp.setContentType("text/plain");
		PrintWriter pw=resp.getWriter();
		pw.print("User Saved Successfully");
		
	}
	public void saveUser(HttpServletRequest req)
	{
		Entity e = new Entity("User");
		e.setProperty("firstname",req.getParameter("fName"));
		e.setProperty("lastname",req.getParameter("lName"));
		e.setProperty("mail",req.getParameter("email"));
		e.setProperty("pass",req.getParameter("password"));
		e.setProperty("ph",req.getParameter("phone"));
		ds.put(e);
	}
	
}
