

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;



/**
 * Servlet implementation class Trait_res
 */
@WebServlet("/Trait_res")
public class Trait_res extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trait_res() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String exist="";
		
		
		Connection con=null;
	    Statement st=null;
	    
	    if(request.getParameter("b1")!=null) {
	    try 
	    {
	    Class.forName("com.mysql.jdbc.Driver");
	    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
	    st=con.createStatement();
	    Statement st0,st1,st2=null;

	    st0=con.createStatement();
	    st1=con.createStatement();
	    st2=con.createStatement();
	    String i2=request.getParameter("i2");
	    String i3=request.getParameter("i3");
	    String i4=request.getParameter("i4");
	   
	    String req_dir ="select Code_direction from direction where Nom_direction='"+i2+"';";
	    String req_Prt ="select Code_P from partner where Nom_P='"+i3+"';";
	    String req_th ="select Code_T from theme where Nom_T='"+i4+"';";
	    ResultSet dir = st0.executeQuery(req_dir);
	    ResultSet Prt = st1.executeQuery(req_Prt);
	    ResultSet Thema = st2.executeQuery(req_th);
	    if(dir.next()==true&&Prt.next()==true&&Thema.next()==true)
	    	{String i1=request.getParameter("i1");
	    	String i5=request.getParameter("i5");
	    	String i6=request.getParameter("i6");
	    	String i7=request.getParameter("i7");
	    	i7=i7.substring(0, i7.length()-1);
	    	String i8=request.getParameter("i8");
	    	String i9=request.getParameter("i9");
	    	String i10=request.getParameter("i10");
			 String Re="insert into activity(`Code_activité`, `Direction`, `Annee`, `Theme`, `Intitule`, `Indicateur`, `Source_information`, `Periode`, `Partenaire`, `Source_fin`, `Etat`) values(null,"+Integer.parseInt(dir.getString("Code_direction"))+","+Integer.parseInt(i1)+","+Integer.parseInt(Thema.getString("Code_T"))+",'"+i6+"',"+Integer.parseInt(i7)+",'"+i9+"','"+i8+"',"+Integer.parseInt(Prt.getString("Code_P"))+",'"+i5+"','"+i10+"')";
			 
			 Statement insertion=con.createStatement();
			 insertion.executeUpdate(Re);
			 request.setAttribute("dataR", "Activité insérée avec succés !");
			 request.getRequestDispatcher("Responsable.jsp").forward(request, response);
			 con.commit();
		}}
	    
	 
	    
	    
	    catch (Exception ex)
	    {
	    	out.print(ex.getMessage());
	    }
	    }
	    
	    else if(request.getParameter("b2")!=null) {
	    	try 
		    {
		    Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_j2ee","root","");
		    st=con.createStatement();
		    String newstate=request.getParameter("j2");
		    String year=request.getParameter("j1");
		    String req="Update activity set Etat='"+newstate+"' where Annee="+Integer.parseInt(year)+";";
		    st.executeUpdate(req);
		    
		    request.setAttribute("dataM", "Activité modifiée avec succés !");
			 request.getRequestDispatcher("Responsable.jsp").forward(request, response);
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    }
	    	catch (Exception ex)
		    {
		    	out.print(ex.getMessage());
		    }
	    	
	    	
	    	
	    	
	    	
	    }
	
	   
		
		
		
		
		
		
		
	
	}
}
