package org.sachin.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sac.mod.UserDetails;
import org.hibernate.*;

/**
 * Servlet implementation class Adduseraction
 */
@WebServlet("/Adduseraction")
public class Adduseraction extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduseraction() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
        String userid = request.getParameter("uid");
        String username = request.getParameter("uname");
		//out.println("Hi your ID is "+userid+" and Name is "+username+"");

        UserDetails user = new UserDetails();
        user.setUid(userid);
        user.setUname(username);

        //creating configuration object  
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  

        //creating seession factory object  
        SessionFactory factory = cfg.buildSessionFactory();

        Session sess = factory.openSession();

        sess.beginTransaction();

        sess.save(user);

        sess.getTransaction().commit();

        out.println("Hi your ID is " + userid + " and Name is " + username + "");

    }

}
