<%@ page import="java.util.*" %>
<html>
<head>
    <title>Inscription � une sortie</title>
</head>
<body>
    <h1>Inscription � une sortie</h1>
    <form name="sortie" action="sortie" method="post">
    <table>
    	
        <tr>
            <td>Sortie:</td>
            <td><input type="text" name="sortie" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Pseudonyme:</td>
            <td><input type="text" name="pseudo" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Date (yyyy-MM-dd HH:mm):</td>
            <td><input type="text" name="date" size="30" maxlength="80"></td>
        </tr>
        <tr>
            <td>Invite:</td>
            <td><input type="text" name="invite" size="2" maxlength="2"></td>
        </tr>
        <tr>
            <td colspan="2">
            	<input type="submit" value="Modifier" name="update">
            	<input type="submit" value="S'inscrire" name="suscribe">
				<input type="submit" value="Ajouter commentaire" name="comment">
				<input type="reset" value="Reset">
            </td>
        </tr>
    </table>
    </form>
</body>
</html>