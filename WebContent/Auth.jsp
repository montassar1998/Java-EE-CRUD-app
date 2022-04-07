<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.*" %>
    <html><head><title>traitement</title><meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css"></head><body>
    <%
    String user=request.getParameter("user");
    String pwd=request.getParameter("pwd");
    
    Connection con=null;
    Statement st=null;
    
    Statement s2=null;
    String exist="";
    
    
    try 
    {
    
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
    st=con.createStatement();
    exist="select Login,role from user where Login='"+user+"';";
    s2 = con.createStatement();
    ResultSet resultat=s2.executeQuery(exist);
    
    if(resultat.next()==true)
    { 
    	if(resultat.getString("role").equals("Administrateur")){ response.sendRedirect("Admin.jsp");}
    	else if(resultat.getString("role").equals("Responsable de la direction")){response.sendRedirect("Responsable.jsp");}
    	else {response.sendRedirect("Directeur.jsp");}
    	
   	}
    else 
    	out.print("compte introuvable ! ");
    
    
    
    }
    
    
    
    catch (Exception ex)
    {
    	out.print(ex.getMessage());
    }
    
    %></body>
    </html>
