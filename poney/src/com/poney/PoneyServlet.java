package com.poney;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;


public class PoneyServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		HttpSession session=req.getSession();
		Poney j=null;
		session.setAttribute("pony",j=new Poney("MERGUEZ"));
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
	 	out.println("<HTML><HEAD><TITLE>");
	 	out.println("MERGUEZ");
	 	out.println("</TITLE></HEAD><BODY>");
	 	out.println("LAUNCH BIATCH?");
		out.println("<FORM action=\"PonyGame\" method=\"get\">");
	    out.println("<INPUT type=\"submit\" value=\"OK\">");
	    out.println("<P>");
		out.println("</FORM>");
		out.println("</BODY></HTML>");
		out.close();
	}
	
	
}
