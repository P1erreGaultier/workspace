package com.poney;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;


public class PonyGame extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
        out.println("<HTML><HEAD><TITLE>");
        out.println("Playing");
        out.println("</TITLE></HEAD><BODY>");
        out.println("MERGUEZ");
        HttpSession session=req.getSession();
        Poney p = ((Poney) session.getAttribute("pony"));
        p.play();
        if (!(p.cpt > 5)) {
            out.println(p.toString());
            out.println("<FORM action=\"PonyGame\" method=\"get\">");
            out.println("<INPUT type=\"submit\" value=\"OK\">");
            out.println("</FORM>");
        } else {
            out.println("Game Over\n");
            out.println(p.getStockageDegueu().toString());

        }
        
        out.println("</BODY></HTML>");
        out.close();
	}
}
