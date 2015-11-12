<%@ page import="java.util.*" %>
<html>
<head>
    <title>Liste des �quipes</title>
</head>
<body>
    <h1>Liste des �quipes</h1>
    <a href="equipe?option=new">Nouvelle</a>
    <table border="1">
        <th>Id</th>
        <th>Nom</th>
        <th>Pays</th>
<%  List<String[]> equipes = (List<String[]>)request.getAttribute("equipes");
    ListIterator<String[]> iterator = equipes.listIterator();
    while(iterator.hasNext()) {
        String[] monEquipe = iterator.next();%>
        <tr>
            <td><%= monEquipe[0] %></td>
            <td><%= monEquipe[1] %></td>
            <td><%= monEquipe[2] %></td>
        </tr>
<%  }%>
    </table>
</body>
</html>