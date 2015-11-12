<%@ page import="java.util.*" %>
<html>
<head>
    <title>Nouvelle �quipe</title>
</head>
<body>
    <h1>Nouvelle �quipe</h1>
    <%= request.getAttribute("message")%>
    <form name="equipe" action="equipe" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" size="3" maxlength="3"></td>
        </tr>
        <tr>
            <td>Nom:</td>
            <td><input type="text" name="nom" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Pays:</td>
            <td>
                <select name="pays">
<%  List<String[]> pays = (List<String[]>)request.getAttribute("pays");
    ListIterator<String[]> iterator = pays.listIterator();
    while(iterator.hasNext()) {
        String[] monPays = iterator.next();%>
                    <option value="<%= monPays[0] %>"><%= monPays[1] %></option>
<%  }%>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
				<input type="submit" value="Insert" name="option">
				<input type="reset" value="Reset">
				<a href="equipe?option=list">Liste</a>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>