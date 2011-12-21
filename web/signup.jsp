<jsp:include page="header.jps"/>

<body>
	<form method="POST" action="signup"> <!-- exécute servlet signup -->
		Nom: <input type="text" name="nom" />
		Prénom: <input type="text" name="prenom" />
		Email: <input type="text" name="email" />
		Password<input type="text" name="password" />
		Confirmer le password: <input type="text" name="confirmation" />
		<input type="submit" name="Valider" />
	</form>
</body>
</html>