package com.gteamtrials.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CodeCompilerServlet extends HttpServlet implements Servlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--> doPost()");
		String javaCode = req.getParameter("javaCode");
		String logMessage = "Compilou?"; //compileAndRun(javaCode);
		
		//req.setAttribute("logMessage", logMessage);		
		req.getRequestDispatcher("/ok.html").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("--> doGet()");
		req.getRequestDispatcher("/ok.html").forward(req, resp);
	}

}
