<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 50%;
  padding: 10px;
  height: 300px; 
}


.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
</head>
<body>
<header>
            <img src="logo.png" style="margin-left: 35%"/>
        </header>

<h2>Panneau de Responsable</h2>
<%!
public void insert(int y,String fin,String title,int ind,String p,String inf,String state){
	System.out.println("Success");
	
}
%>

<%

Connection con=null;
Statement st0,st1,st2=null;
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
st0=con.createStatement();
st1=con.createStatement();
st2=con.createStatement();
String req_dir ="select Nom_direction from Direction;";
String req_Prt ="select Nom_P from Partner;";
String req_th ="select Nom_T from Theme;";
ResultSet dir = st0.executeQuery(req_dir);
ResultSet Prt = st1.executeQuery(req_Prt);
ResultSet Thema = st2.executeQuery(req_th);
int a=2020;int b = 2020;


%>

<div class="row">
  <div class="column" >
    <h2>Ajouter une Activité</h2>
    
    <form method="POST" action="Trait_res" >
    <fieldset>
    <legend>Informations sur l'activité</legend>
	<label>Année de l'Activité</label>
	<select name="i1">
        <%  while(a-2020<=20){ %>
            <option><%=a%></option>
        <% a++;} %>
    </select><br>
	<label>Direction de :</label>
	<select name="i2">
        <%  while(dir.next()){ %>
            <option><%=dir.getString("Nom_direction")%></option>
        <%} %>
    </select><br>
    <label>En partenariat avec  :</label>
	<select name="i3">
        <%  while(Prt.next()){ %>
            <option><%=Prt.getString("Nom_P")%></option>
        <%} %>
    </select><br>
    <label>sur le théme de  :</label>
	<select name="i4">
        <%  while(Thema.next()){ %>
            <option><%=Thema.getString("Nom_T")%></option>
        <%} %>
    </select><br>
    <label>Source financière  :</label>
	<input type="text" name="i5">
	<br>
	<label>Intitulé  :</label>
	<input type="text" name="i6">
	<br>
	
	<label>Indicateur  :</label>
	<select name="i7">
		<% int ta = 0;
		int step = 5;
		while(ta<=100){%>
		<option><%=ta %>%</option><%ta+=step;} %>
	</select><br>
	<label>Période  :</label>
	<select name="i8">
		<option>T1</option>
		<option>T2</option>
		<option>T3</option>
		<option>T4</option>
	</select>
	<br>
	<label>Source d'Information  :</label>
	<input type="text" name="i9"><br>
	<label>Etat  :</label>
	<select name="i10">
		<option>En cours</option>
		<option>Non réalisé</option>
		<option>Achevé</option>
	</select><br>
	<input type="submit" value="inserer_dans_Direction" name="b1" ><br>
	<label><% if (request.getAttribute("dataR")!=null)
		out.println(request.getAttribute("dataR")); %></label>
	</fieldset>
	 </form>
    
  </div>
  <div class="column" >
    <h2>Recherche</h2>
    <form method="POST" action="Trait_res">
    <fieldset>
    
  <legend>Modification de l'Etat </legend><br>
  
  <label>Année</label>
  <select name="j1">
        <%  while(b-2020<=20){ %>
            <option><%=b%></option>
        <% b++;} %>
    </select><br>
    <label>Nouveau Etat  :</label>
	<select name="j2">
		<option>En cours</option>
		<option>Non réalisé</option>
		<option>Achevé</option>
	</select><br>
    
  <input type="submit" value="Modifier" name="b2"><br>
  <label ><% if (request.getAttribute("dataM")!=null)
		out.println(request.getAttribute("dataM")); %></label>
  </fieldset>
  </form>
  </div>
</div>
 <footer>
            <p style="margin-top:20%;">FIXE/FAX : 71881110</p>
            <a href="https://www.facebook.com/NewTechnologies/">Page Facebook</a>
        </footer>
</body>
</html>
