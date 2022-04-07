<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

 
<HTML>
    <HEAD>
        <TITLE>Afficher les activités </TITLE>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
    </HEAD>
 
    <BODY>
    <header>
            <img src="logo.png" style="margin-left: 35%"/>
        </header>
        <H1>Tables des Activités de l'année courante </H1>
        <FORM NAME="form1" METHOD="POST">
 
        <% 
            int current = 1;
            if(request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }
 			Connection connection=null;
            Class.forName("com.mysql.jdbc.Driver");
		    connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
 
            Statement statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
 
            ResultSet resultset = 
                statement.executeQuery("select Direction,Theme,Etat from activity"); 
 
            if(current < 1){
                current = 1;
            }
 
            resultset.last();
            int rows = resultset.getRow();
            if(current <= rows){
                resultset.absolute(current);
            }    
        %>
 
            <TABLE BORDER="1">
                <TR>
                    <TH>Code Direction</TH>
                    <TH>Code Theme</TH>
                    <TH>Etat</TH>
                    
                </TR>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                    <TD> <%= resultset.getString(2) %> </TD>
                    <TD> <%= resultset.getString(3) %> </TD>
                    
                </TR>
            </TABLE>
            <BR>
            <INPUT TYPE="HIDDEN" NAME="hidden" VALUE="<%= current %>">
            
            
        </FORM>
 
        <footer>
            <p style="margin-top:20%;">FIXE/FAX : 71881110</p>
            <a href="https://www.facebook.com/NewTechnologies/">Page Facebook</a>
        </footer>
    </BODY>
</HTML>