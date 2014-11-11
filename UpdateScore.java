package com.wipro.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateScore
 */
public class UpdateScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String url,user,password;
	public void init(ServletConfig config){
		url = config.getServletContext().getInitParameter("url");
		user = config.getInitParameter("user");
		password = config.getInitParameter("password");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btname = request.getParameter("btname");
		String battingTeamScore = request.getParameter("btscore");
		String batsmanName = request.getParameter("btsname");
		String batsmanScore = request.getParameter("btm_score");
		String bowlingTeamName = request.getParameter("bowtname");
		String bowlingTeamScore = request.getParameter("bowscore");
		String bowlerName = request.getParameter("bowname");
		String overNumber = request.getParameter("ovno");
		
		Connection con = DBConnectionFactory.getConnection(url, user, password);
		System.out.println(con);
		try {
			con.setAutoCommit(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				try {
			PreparedStatement s = con.prepareStatement("update cricket set  BATTING_TEAM_NAME=?,BATTING_TEAM_SCORE=?,BATSMAN_NAME=?,BATSMAN_SCORE=?,BOWLING_TEAM_NAME=?,BOWLING_TEAM_SCORE=?,BOWLER_NAME=?,OVER_NO=? where id=101");
			s.setString(1, btname);
			s.setInt(2, Integer.parseInt(battingTeamScore));
			s.setString(3, batsmanName);
			s.setInt(4, Integer.parseInt(batsmanScore));
			s.setString(5, bowlingTeamName);
			s.setInt(6, Integer.parseInt(bowlingTeamScore));
			s.setString(7, bowlerName);
			s.setDouble(8, Double.parseDouble(overNumber));
			s.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

}
