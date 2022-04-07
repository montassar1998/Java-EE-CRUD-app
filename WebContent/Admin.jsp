<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
<style>
* {
  box-sizing: border-box;
}

.column {
  float: left;
  width: 33.33%;
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

<h2>Panneau d'administrateur</h2>

<div class="row">
  <div class="column" >
    <h2>Insertion</h2>
    
    <form method="POST" action="insertion">
    <fieldset>
    <legend>Direction</legend>
	<label>Nom</label>
	<input type="text" name="Nom_direction"><br>
	<label>Email</label>
	<input type="email" name="Email_Direction"><br>
	<input type="submit" value="inserer direction" name="b1"><br>
	<label ><% if (request.getAttribute("data1")!=null){
		out.println(request.getAttribute("data1")); }%></label>
	</fieldset>
	 </form>
	 
	 <form method="POST" action="insertion">
	 <fieldset>
	 <legend>Partenaire</legend>
	<label>Nom</label>
	<input type="text" name="Nom_P"><br>
	<label>Email</label>
	<input type="email" name="Email_P"><br>
	<input type="submit" value="inserer partenaire" name="b2"><br>
	<label ><% if (request.getAttribute("data2")!=null)
		out.println(request.getAttribute("data2")); %></label>
	</fieldset>
	 </form>
	 
	 <form method="POST" action="insertion">
	 <fieldset>
	 <legend>Thème</legend>
	<label>Nom</label>
	<input type="text" name="Nom_T"><br>
	<input type="submit" value="inserer theme" name="b3"><br>
	<label ><% if (request.getAttribute("data3")!=null)
		out.println(request.getAttribute("data3")); %></label>
	</fieldset>
	 </form>
    
    
  </div>
  <div class="column" >
    <h2>Recherche</h2>
    <form method="POST" action="insertion">
    <fieldset>
    
  <legend>Type de Recherche</legend><br>
  <select name="nomR">
  <option>Direction</option>
  <option>Partenaire</option>
  <option>Thème</option>
  </select><br>
  <label>Nom</label><br>
  <input type="text" name="cle"><br>
  <input type="submit" value="Rechercher" name="b4">
  <label><% if (request.getAttribute("data4")!=null)
		out.println(request.getAttribute("data4")); %></label>
  </fieldset>
  </form>
    
  </div>
  
  
  
  <div class="column" >
    <h2>Suppression</h2>
   <form method="POST" action="insertion">
    <fieldset>
    
  <legend>Type à supprimer</legend><br>
  <select name="nomS">
  <option>Direction</option>
  <option>Partenaire</option>
  <option>Thème</option>
  </select><br>
  <label>Nom</label><br>
  <input type="text" name="cle2"><br>
  <input type="submit" value="Supprimer" name="b5">
  <label><% if (request.getAttribute("data5")!=null)
		out.println(request.getAttribute("data5")); %></label>
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
