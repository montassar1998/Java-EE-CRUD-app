<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.*" %>
    <%
    String user=request.getParameter("user");
    String pwd=request.getParameter("pwd");
    
    String R=request.getParameter("role");
    
    
    Connection con=null;
    Statement st=null;
    
    Statement s2=null;
    String exist="";
    
    
    try 
    {
    
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
    st=con.createStatement();
    exist="select Login from user where Login='"+user+"';";
    s2 = con.createStatement();
    ResultSet resultat=s2.executeQuery(exist);
    
    if(resultat.next()==false)
    {
    	String qry="insert into user values(null,'"+user+"','"+pwd+"','"+R+"')";
    	st.executeUpdate(qry);
    	out.print("Vous êtes inscrit  !!!");}
    else{
    	out.print("Ce nom d'utilisateur a déjà un compte");	

    }
    }
    
    
    
    catch (Exception ex)
    {
    	out.print(ex.getMessage());
    }
    
    %>
