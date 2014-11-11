package com.wipro.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Score {
	@SuppressWarnings("finally")
	public static ScoreVO getScore(String url,String user,String pass){
		Connection con = DBConnectionFactory.getConnection(url, user, pass);
		System.out.println("The connection is:"+con);
		ScoreVO sc = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from cricket");
			ResultSet rs = ps.executeQuery();
			sc = new ScoreVO();
			while(rs.next()){
				sc.setBattingTeamName(rs.getString(1));
				sc.setBattingTeamScore(rs.getInt(2));
				sc.setBatsmanName(rs.getString(3));
				sc.setBatsmanScore(rs.getInt(4));
				sc.setBowlingTeamName(rs.getString(5));
				sc.setBowlingTeamScore(rs.getInt(6));
				sc.setBowlerName(rs.getString(7));
				sc.setOverNumber(rs.getDouble(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sc;
		}
		
	}

}
