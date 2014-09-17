package com.w1nter.TinyLAN_Tower.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.w1nter.TinyLAN_Tower.NetworkTracker;

/**
 * Servlet implementation class TowerServlet
 */
//@WebServlet("/TowerServlet")
public class TowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NetworkTracker tracker;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TowerServlet() {
        super();
        tracker = new NetworkTracker();
        tracker.start();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("Hello Wold, this Servlet is working.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
