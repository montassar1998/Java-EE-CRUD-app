

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class insertion
 */
@SuppressWarnings("unused")
@WebServlet("/insertion")
public class insertion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String valeur="";
		
		
		
		
		
		
		
			if(request.getParameter("b1")!=null) {
			String x=request.getParameter("Nom_direction");
			String y=request.getParameter("Email_Direction");
			Connection con=null;
		    Statement st=null;
		    Statement s2=null;
		    String exist="";
		    try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st=con.createStatement();
		    exist="select Nom_direction,Email_direction from direction where Nom_direction='"+x+"';";
		    s2 = con.createStatement();
		    ResultSet resultat=s2.executeQuery(exist);
		    if(resultat.next()==false)
		    {
		    	String qry="insert into direction values(null,'"+y+"','"+x+"')";
		    	st.executeUpdate(qry);
		    	request.setAttribute("data1","Donn�es ins�r�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);}
		    else{
		    	request.setAttribute("data1","Donn�es d�ja existe");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);	}
		    }
		    catch (Exception ex)
		    {
		    	out.print(ex.getMessage());
		    }
			
			}
			
			
			
			
			
			
		
		
		
		
		
		
		else if(request.getParameter("b2")!=null) {
			String z=request.getParameter("Nom_P");
			String w=request.getParameter("Email_P");
			Connection con1=null;
		    Statement st3=null;
		    Statement s4=null;
		    String exist1="";
		    try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st3=con1.createStatement();
		    exist1="select Nom_P,Email_P from partner where Nom_P='"+z+"';";
		    s4 = con1.createStatement();
		    ResultSet resultat=s4.executeQuery(exist1);
		    if(resultat.next()==false)
		    {
		    	String qry="insert into partner values(null,'"+z+"','"+w+"')";
		    	st3.executeUpdate(qry);
		    	request.setAttribute("data2","Donn�es ins�r�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);}
		    else{
		    	request.setAttribute("data2","Donn�es d�ja existe");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);}
		    }
		    catch (Exception ex)
		    {
		    	out.print(ex.getMessage());
		    }
		
			}
			
			
			
			
			
			
			
			
			
			
			
		else if(request.getParameter("b3")!=null) {
			
			String i=request.getParameter("Nom_T");
			Connection con2=null;
		    Statement st5=null;
		    Statement s6=null;
		    String exist2="";
		    try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st5=con2.createStatement();
		    exist2="select Nom_T from theme where Nom_T='"+i+"';";
		    s6 = con2.createStatement();
		    ResultSet resultat=s6.executeQuery(exist2);
		    if(resultat.next()==false)
		    {
		    	String qry="insert into theme values(null,'"+i+"')";
		    	st5.executeUpdate(qry);
		    	request.setAttribute("data3","Donn�es ins�r�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);}
		    else{
		    	request.setAttribute("data3","Donn�es d�ja existe");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);	}
		    }
		    catch (Exception ex)
		    {
		    	out.print(ex.getMessage());
		    }
	
			}
			
			
			
			
			
			
			
			
			
		
		
		else if(request.getParameter("b4")!=null) {
			
			String how=request.getParameter("nomR");
			String cle=request.getParameter("cle");
			Connection con3=null;
		    Statement st7=null;
		    Statement s8=null;
		    String exist3="";
		    try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st7=con3.createStatement();
		    
		    if(how.equals("Direction")) {
		    	exist3="select Nom_direction,Email_direction from direction where Nom_direction='"+cle+"';";
		    	s8=con3.createStatement();
		    	ResultSet resultat=s8.executeQuery(exist3);
		    	if(resultat.next()== true) {
		    		String qry="select Nom_direction,Email_direction from direction where Nom_direction='"+cle+"';";
		    		st7.executeQuery(qry);
		    		request.setAttribute("data4","Donn�es trouv�es !");
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		    	else request.setAttribute("data4","Donn�es non trouv�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    	
		    	
		    	
		    }
		    else if(how.equals("Partenaire")) {
		    	exist3="select Nom_P,Email_P from partner where Nom_P='"+cle+"';";
		    	s8=con3.createStatement();
		    	ResultSet resultat=s8.executeQuery(exist3);
		    	if(resultat.next()== true) {
		    		String qry="select Nom_P,Email_P from partner where Nom_P='"+cle+"';";
		    		st7.executeQuery(qry);
		    		request.setAttribute("data4","Donn�es trouv�es !");
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		    	else request.setAttribute("data4","Donn�es non trouv�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    	
		    	
		    	
		    }
		    
		    
		    
		    else {
		    	exist3="select Nom_T from theme where Nom_T='"+cle+"';";
		    	s8=con3.createStatement();
		    	ResultSet resultat=s8.executeQuery(exist3);
		    	if(resultat.next()== true) {
		    		String qry="select Nom_T from theme where Nom_T='"+cle+"';";
		    		st7.executeQuery(qry);
		    		request.setAttribute("data4","Donn�es trouv�es !");
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		    	else request.setAttribute("data4","Donn�es non trouv�es !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    	
		    	
		    	
		    
		    }
		     }
		    catch (Exception ex)
		    {
		    	out.print(ex.getMessage());
		    }
		
			}
			
			
			
			
			
		
		    
		    
		
		    
		    
		    
			
			
			
		
		
		
		
		
		
		
		
		
		else if(request.getParameter("b5")!=null) {
			String who=request.getParameter("nomS");
			String cle2=request.getParameter("cle2");
			Connection con4=null;
		    Statement st8=null;
		    Statement s9=null;
		    String exist4="";
		    try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con4=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st8=con4.createStatement();
		    
		    if(who.equals("Direction")) {
		    	exist4="select Nom_direction,Email_direction from direction where Nom_direction='"+cle2+"';";
		    	s9=con4.createStatement();
		    	ResultSet resultat=s9.executeQuery(exist4);
		    	if(resultat.next()== true) {
		    		String qry="delete from direction where Nom_direction='"+cle2+"';";
		    		st8.executeUpdate(qry);
		    		request.setAttribute("data5","Donn�e Supprim�e !");
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		    	else request.setAttribute("data5","Donn�e n\'existe pas !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    	
		    	
		    	
		    }
		    else if(who.equals("Partenaire")) {
		    	exist4="select Nom_P,Email_P from partner where Nom_P='"+cle2+"';";
		    	s9=con4.createStatement();
		    	ResultSet resultat=s9.executeQuery(exist4);
		    	if(resultat.next()== true) {
		    		String qry="delete from partner where Nom_P='"+cle2+"';";
		    		st8.executeUpdate(qry);
		    		request.setAttribute("data5","Donn�es Supprim�es !");
					request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		    	else request.setAttribute("data5","Donn�e n\'existe pas !");
				request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    	}
		    
		    
		    
		    else if(who.equals("Th�me")){
		    	s9=con4.createStatement();
		    		String qry="DELETE from theme where Nom_T='"+cle2+"';";
		    		int res = st8.executeUpdate(qry);
		    		out.println("Donn�es Supprim�es !");
		    		if(res==0) {
		    			request.setAttribute("data5", "donn�e n\'existe pas");
		    		}else {
		    			request.setAttribute("data5", "donn�e supprim�e");
		    		
		    			
		    		}
		    		request.getRequestDispatcher("Admin.jsp").forward(request, response);
		    		}
		     }
		    catch (Exception ex) {
		    
		    	out.print(ex.getMessage());
		    }
			
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			out.close();
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	}

}
