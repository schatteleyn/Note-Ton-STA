<%@page import="simon.entity.Campus"%>
<%@page import="simon.entity.Campus"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jps"/>
    
<body>
    
    <% List<Campus> listCampus = (List<Campus>) request.getAttribute("list_campus"); %>
	<h2>Bienvenue sur Note Ton STA</h2>
		<p>Ce site te permet de noter ton STA, ou bien de voir les statistiques par intervenants et campus.</p>
		<p>Choisissez un campus: <br/>
		<form>
			<select name="campus">
                            <% for(Campus campus : listCampus) {%>
                            
                            <option name="<%= campus.getId() %>"><%= campus.getName() %></option>
                            
                            <% } %>
			</select>
                        
		</form>
		</p>
		<p>Si vous �tes un intervenant et que vous avez d�j� un compte, <a href="login.jsp">authentifiez-vous</a> pour g�rez vos interventions.<br />
		Si vous n'avez pas encore de comptes, <a href="signup.jsp">inscrivez-vous.</a></p>
</body>
</html>