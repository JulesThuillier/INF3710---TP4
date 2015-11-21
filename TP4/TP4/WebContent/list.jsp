<%@ page import="java.util.*" %>
<html>
<head>
    <title>Affichage de la liste des sorties � venir</title>
</head>
<body>
    <h1>Affichage de la liste des sorties � venir</h1>
    <a href="sortie?option=new">Nouvelle Sortie</a>
    </br>
    <table border="1">
        <th>Heure</th>
        <th>Titre</th>
        <th>Organisateur</th>
<%  List<String[]> sorties = (List<String[]>)request.getAttribute("sorties");
    ListIterator<String[]> iterator = sorties.listIterator();
    while(iterator.hasNext()) {
        String[] maSortie = iterator.next(); %>
        
        <tr>
            <td><a href="sortie?option=update&id=<%= maSortie[0] %>"><%= maSortie[3] %></a></td>
            <td><a href="sortie?option=update&id=<%= maSortie[0] %>"><%= maSortie[1] %></a></td>
            <td><a href="sortie?option=update&id=<%= maSortie[0] %>"><%= maSortie[4] %></a></td>
        </tr>
<%  }%>
    </table>
</body>
</html>