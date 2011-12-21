<%@page import="simon.entity.Campus"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jps"/>
    
<body>
    
    <% List<Campus> listCampus = (List<Campus>) request.getAttribute("list_campus"); %>
	<h2>Bienvenue sur Note Ton STA</h2>
		<p>Ce site te permet de noter ton STA, ou bien de voir les statistiques par intervenants et campus.</p>
		<p>Choisissez un campus: <br/>
		<form>
			<select name="campus" id="campus">
                            <% for(Campus campus : listCampus) {%>
                            
                            <option name="<%= campus.getName() %>"><%= campus.getName() %></option>
                            
                            <% } %>
			</select>
                        
		</form>
		</p>
                <script>
    $(function(){
      
      $('#campus').bind('change', function () {
          var campus = $(this).val(); 
          if (campus) { 
              window.location = "intervention/" + campus; 
          }
          return false;
      });
    });
</script>
		<p>Si vous êtes un intervenant et que vous avez déjà un compte, <a href="login.jsp">authentifiez-vous</a> pour gérez vos interventions.<br />
		Si vous n'avez pas encore de comptes, <a href="signup.jsp">inscrivez-vous.</a></p>
</body>
</html>