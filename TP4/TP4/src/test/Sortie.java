package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@WebServlet("/")
public class Sortie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Database database = new Database();

	/**
	 * Fonction appelé lors d'un GET
	 * Par exemple lorsqu'on clique sur un lien, ou qu'on veut charger une page
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		if(option.equals("list")){
			List<String[]> sorties = listSorties();
			request.setAttribute("sorties", sorties);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}
		else if(option.equals("new")){
			request.getRequestDispatcher("/new.jsp").forward(request, response);
		}
		
		else if(option.equals("update")){
			String id = request.getParameter("id");
			request.setAttribute("sortie", getSortiebyID(id));
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		}
	}

	/**
	 * Fonction appelé lors d'un POST (validation de form notamment)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		if(option.equals("Nouvelle Sortie")){
			String message = creerSortie(request);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(option.equals("Modifier")){
			String message = updateSortie(request);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else if(option.equals("S'inscrire")){
			String message = creerSortie(request);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * Fonction permettant de créer une nouvelle sortie
	 * Realise un INSERT INTO sur Sortie dans la BDD
	 * @param request
	 * @return la reposne du serveur
	 */
	public String creerSortie(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String date = request.getParameter("date");
		
		date += ":00";
		System.out.println(date);
		
		String responsable = request.getParameter("responsable");
		String genre = request.getParameter("genre");
		String description = request.getParameter("description");
		String adresse = request.getParameter("adresse");
		String participantsMax = request.getParameter("participantsMax");
		String sql = "INSERT INTO Sortie VALUES ("+id+", '"+nom+"', TO_DATE('"+date+"', 'YYYY-MM-DD HH24:MI:SS'), '"+responsable+"', '"+genre+"', '"+description+"', '"+adresse+"', "+participantsMax+")";
	//	String sql2 = "INSERT INTO Sortie VALUES (12, 'cdsj', TO_DATE('2017-10-01 11:13:00', 'YYYY-MM-DD HH24:MI:SS'), 'jules', 'cien', 'desccc', 'addd', 2)";
	//	System.out.println(sql);
		database.connect();
		Statement stmt = database.getStatement();
		int resp = database.executeSql(stmt, sql);
		database.commit();
		database.closeStatement(stmt);
		database.closeConnection();
		String message = "Modifiees: "+resp;
		return message;
	}
	
	/**
	 * Fonction pour mettre à jour les champs d'une sortie
	 * Realise un UPDATE sur Sortie dans la BDD
	 * @param request
	 * @return
	 */
	public String updateSortie(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String date = request.getParameter("date");
		
		date += ":00";
		System.out.println(date);
		
		String responsable = request.getParameter("responsable");
		String genre = request.getParameter("genre");
		String description = request.getParameter("description");
		String adresse = request.getParameter("adresse");
		String participantsMax = request.getParameter("participantsMax");
		String sql = "UPDATE Sortie SET nom='"+nom+"', dte=TO_DATE('"+date+"', 'YYYY-MM-DD HH24:MI:SS'), responsable='"+responsable+"', genre='"+genre+"', description='"+description+"', adresse='"+adresse+"', participantsmax="+participantsMax+" WHERE idSort = "+id;
		System.out.println(sql);
		database.connect();
		Statement stmt = database.getStatement();
		int resp = database.executeSql(stmt, sql);
		database.commit();
		database.closeStatement(stmt);
		database.closeConnection();
		String message = "Modifiees: "+resp;
		return message;
	}
	
	/**
	 * Fonction pour s'inscrire à une sortie
	 * Realise un INSERT INTO sur Inscription dans la BDD
	 * @param request
	 * @return
	 */
	public String suscribe(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String date = request.getParameter("date");
		
		date += ":00";
		System.out.println(date);
		
		String responsable = request.getParameter("responsable");
		String genre = request.getParameter("genre");
		String description = request.getParameter("description");
		String adresse = request.getParameter("adresse");
		String participantsMax = request.getParameter("participantsMax");
		String sql = "INSERT INTO Sortie VALUES ("+id+", '"+nom+"', TO_DATE('"+date+"', 'YYYY-MM-DD HH24:MI:SS'), '"+responsable+"', '"+genre+"', '"+description+"', '"+adresse+"', "+participantsMax+")";
		System.out.println(sql);
		database.connect();
		Statement stmt = database.getStatement();
		int resp = database.executeSql(stmt, sql);
		database.commit();
		database.closeStatement(stmt);
		database.closeConnection();
		String message = "Modifiees: "+resp;
		return message;
	}
	
	/**
	 * Fonction pour lister les sorties existanes
	 * Realise un SELECT sur Sortie dans la BDD
	 * @return liste des sorties, sous la forme d'une liste de tableau de string de ce format : { id, nom, cal, time, responsable}
	 */
	public List<String[]> listSorties() {
		String sql = "SELECT idSort, dte, nom, responsable  FROM Sortie ORDER BY dte";
		database.connect();
		Statement stmt = database.getStatement();
		ResultSet rs = database.executeSelect(stmt, sql);
		List<String[]> sorties = new ArrayList<String[]>();
		try {
			while(rs.next()) {
				String id = rs.getString("idSort");
				String nom = rs.getString("nom");
				Timestamp date = rs.getTimestamp("dte");

				SimpleDateFormat printFormat2 = new SimpleDateFormat("HH'h'mm");	
				String time = printFormat2.format(date);
				
				SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd");				

				String cal = printFormat.format(date);
				
				String responsable = rs.getString("responsable");
				
				sorties.add(new String[] { id, nom, cal, time, responsable});
			}
			database.closeStatement(stmt);
			database.closeConnection();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return sorties;
	}
	
	/**
	 * Fonction pour retrouver une sortie par son id dans la BDD
	 * Realise un SELECT sur Sortie dans la BDD
	 * @param id
	 * @return un tableaux de string contenant : {idSortie, nom, date, responsable, genre, description, adresse, participantsmax}
	 */
	public String[] getSortiebyID(String id) {
		String sql = "SELECT * FROM Sortie WHERE idSort = "+id+" ORDER BY dte";
		database.connect();
		Statement stmt = database.getStatement();
		ResultSet rs = database.executeSelect(stmt, sql);
		List<String[]> sorties = new ArrayList<String[]>();
		try {
			while(rs.next()) {
				String idSortie = rs.getString("idSort");
				String nom = rs.getString("nom");
				String responsable = rs.getString("responsable");
				String genre = rs.getString("genre");
				String description = rs.getString("description");
				String adresse = rs.getString("adresse");
				String participantsmax = rs.getString("participantsmax");

				Timestamp datets = rs.getTimestamp("dte");
				SimpleDateFormat printFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");				
	
				String date = printFormat.format(datets);
						
				return new String[] { idSortie, nom, date, responsable, genre, description, adresse, participantsmax};
			}
			database.closeStatement(stmt);
			database.closeConnection();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return new String[] { };
	}
}
