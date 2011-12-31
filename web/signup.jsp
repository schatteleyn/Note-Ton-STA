<jsp:include page="header.jps"/>
	<form method="POST" action="signup">
		Last Name: <input type='text' name='nom' value="<c:if test='${not empty FirstName}'><c:out value='${FirstName}' /></c:if>" />
                <c:if test="${ not empty error_FirstName}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_FirstName}" /></span>
                </c:if>
		First Name: <input type='text' name='prenom' value="<c:if test='${not empty LastName}'><c:out value='${LastName}' /></c:if>" />
                <c:if test="${ not empty error_LastName}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_LastName}" /></span>
                </c:if>
                
		Email: <input type='text' name='email' value="<c:if test='${not empty email}'><c:out value='${email}' /></c:if>" />
                <c:if test="${ not empty error_email}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_email}" /></span>
                </c:if>
		Password: <input type='password' name='password' value="<c:if test='${not empty password}'><c:out value='${password}' /></c:if>" />
                <c:if test="${ not empty error_password}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_password}" /></span>
                </c:if>
		Password confirmation: <input type="text" name="confirmation" value="<c:if test='${not empty confirmation}'><c:out value='${confirmation}' /></c:if>" />
                <c:if test="${ not empty error_confirmation}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_confirmation}" /></span>
                </c:if>
		<input type="submit" name="Valider" />
	</form>
</body>
</html>