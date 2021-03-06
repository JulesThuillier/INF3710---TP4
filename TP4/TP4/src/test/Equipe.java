package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/equipe")
public class Equipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		if(option.equals("list")){
			List<String[]> equipes = list();
			request.setAttribute("equipes", equipes);
			request.getRequestDispatcher("/list.jsp").forward(request, response);
		}
		else if(option.equals("new")){
			List<String[]> pays = selectPays();
			request.setAttribute("pays", pays);
			request.getRequestDispatcher("/new.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
		if(option.equals("Insert")){
			String message = insert(request);
			request.setAttribute("message", message);
			List<String[]> pays = selectPays();
			request.setAttribute("pays", pays);
			request.getRequestDispatcher("/new.jsp").forward(request, response);
		}
	}

	public String insert(HttpServletRequest request) {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String pays = request.getParameter("pays");
		String sql = "INSERT INTO Equipe VALUES ('"+id+"', '"+nom+"', '"+pays+"')";
		database.connect();
		Statement stmt = database.getStatement();
		int resp = database.executeSql(stmt, sql);
		database.closeStatement(stmt);
		database.closeConnection();
		String message = "Modifi�es: "+resp;
		return message;
	}

	public List<String[]> list() {
		String sql = "SELECT idEq, nom, pays FROM Equipe ORDER BY nom";
		database.connect();
		Statement stmt = database.getStatement();
		ResultSet rs = database.executeSelect(stmt, sql);
		List<String[]> equipes = new ArrayList<String[]>();
		try {
			while(rs.next()) {
				String idEq = rs.getString("idEq");
				String nom = rs.getString("nom");
				String pays = rs.getString("pays");
				equipes.add(new String[] { idEq, nom, pays });
			}
			database.closeStatement(stmt);
			database.closeConnection();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return equipes;
	}

	public List<String[]> selectPays() {
		String sql = "SELECT idPays, nom FROM Pays ORDER BY nom";
		database.connect();
		Statement stmt = database.getStatement();
		ResultSet rs = database.executeSelect(stmt, sql);
		List<String[]> pays = new ArrayList<String[]>();
		try {
			while(rs.next()) {
				String idPays = rs.getString("idPays");
				String nom = rs.getString("nom");
				pays.add(new String[] { idPays, nom });
			}
			database.closeStatement(stmt);
			database.closeConnection();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return pays;
	}

}
