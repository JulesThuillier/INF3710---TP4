<%@ page import="java.util.*" %>
<html>
<head>
    <title>Modification d'une sortie</title>
</head>
<body>
    <h1>Modification d'une sortie</h1>
    <form name="sortie" action="sortie" method="post">
    <%  String[] sortie = (String[])request.getAttribute("sortie"); %>
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" size="30" maxlength="80" value="<%= sortie[0] %>"></td>
        </tr>
        <tr>
            <td>Nom:</td>
            <td><input type="text" name="nom" size="30" maxlength="80" value="<%= sortie[1] %>"></td>
        </tr>
        <tr>
            <td>Date (yyyy-MM-dd HH:mm):</td>
            <td><input type="text" name="date" size="30" maxlength="80" value="<%= sortie[2] %>"></td>
        </tr>
        <tr>
            <td>Responsable:</td>
            <td><input type="text" name="responsable" size="30" maxlength="80" value="<%= sortie[3] %>"></td>
        </tr>
        <tr>
            <td>Genre:</td>
            <td><input type="text" name="genre" size="30" maxlength="80" value="<%= sortie[4] %>"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" rows="4" cols="50" ><%= sortie[5] %></textarea></td>
        </tr>
        <tr>
            <td>Adresse:</td>
            <td><input type="text" name="adresse" size="30" maxlength="80" value="<%= sortie[6] %>"></td>
        </tr>
        <tr>
            <td>Participants:</td>
            <td><input type="text" name="participantsMax" size="30" maxlength="2" value="<%= sortie[7] %>"></td>
        </tr>
        <tr>
            <td colspan="2">
            	<input type="submit" value="Modifier" name="option">
            	<input type="submit" value="S'inscrire" name="option">
				<input type="submit" value="Ajouter commentaire" name="option">
				<input type="reset" value="Reset">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>