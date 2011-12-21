<%@page import="simon.entity.Campus"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jps"/>

<body>
    <% List<Campus> listCampus = (List<Campus>) request.getAttribute("list_campus"); %>
    
	<form method="POST" action="intervention">
		Sujet: <input type="text" name="sujet" />
		Campus: <select name="campus">
                            <% for(Campus campus : listCampus) {%>
                            
                            <option name="<%= campus.getId() %>"><%= campus.getName() %></option>
                            
                            <% } %>
			</select>
		De: <input type="text" name="from" />
		A: <input type="text" name="to" />
                Description: <textarea name="confirmation" ></textarea>
		<input type="submit" name="Valider" />
	</form>
</body>
</html>