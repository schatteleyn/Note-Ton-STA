<jsp:include page="header.jps"/>

<body>
	<form method="POST" action="signup"> <!-- ex�cute servlet signup -->
		<input type="text" name="Nom" />
		<input type="text" name="Pr�nom" />
		<input type="text" name="Email" />
		<input type="text" name="Password" />
		<input type="text" name="Confirmation password" />
		<input type="submit" name="S'enregistrer" />
	</form>
</body>
</html>