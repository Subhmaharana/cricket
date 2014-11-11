<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.web.Score,com.wipro.web.ScoreVO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "scott";
	String password = "tiger";
	ScoreVO sc = Score.getScore(url, user, password);
%>
<h2>Batting Team Name: <%=sc.getBattingTeamName() %></h2>
<h2>Batting Team Score: <%=sc.getBattingTeamScore() %></h2>
<h2>Batsman Name : <%=sc.getBatsmanName() %></h2>
<h2>Batsman Score : <%=sc.getBatsmanScore() %></h2>
<h2>Bowling Team Name : <%=sc.getBowlingTeamName() %></h2>
<h2>Bowling Team Score : <%=sc.getBowlingTeamScore() %></h2>
<h2>Bowler Name : <%=sc.getBowlerName() %></h2>
<h2>Over : <%=sc.getOverNumber() %></h2>
</body>
</html>
