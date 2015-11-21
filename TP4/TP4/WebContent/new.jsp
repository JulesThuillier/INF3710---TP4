<%@ page import="java.util.*" %>
<html>
<head>
    <title>Création d'une nouvelle sortie</title>
</head>
<body>
    <h1>Création d'une nouvelle sortie</h1>
    <form name="sortie" action="sortie" method="post">
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
            <td>Date (yyyy-MM-dd HH:mm):</td>
            <td><input type="text" name="date" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Responsable:</td>
            <td><input type="text" name="responsable" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Genre:</td>
            <td><input type="text" name="genre" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><textarea name="description" rows="4" cols="50"></textarea></td>
        </tr>
        <tr>
            <td>Adresse:</td>
            <td><input type="text" name="adresse" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Participants:</td>
            <td><input type="text" name="participantsMax" size="30" maxlength="2"></td>
        </tr>
        <tr>
            <td colspan="2">
				<input type="submit" value="Nouvelle Sortie" name="option">
				<input type="reset" value="Reset">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>