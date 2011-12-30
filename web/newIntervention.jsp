<jsp:include page="header.jps"/>
<%@page import="simon.entity.Campus"%>
<%@page import="java.util.List"%>
<body>
    <% List<Campus> listCampus = (List<Campus>) request.getAttribute("list_campus"); %>
    
	<form method="POST" action="intervention">
		Sujet: <input type="text" name="sujet" />
		Campus: <select name="campus">
                            <% for(Campus campus : listCampus) {%>
                            
                            <option name="<%= campus.getId() %>"><%= campus.getName() %></option>
                            
                            <% } %>
			</select>
		De: <input type="text" name="from" id="from"/>
		A: <input type="text" name="to" id="to"/>
                Description: <textarea name="confirmation" ></textarea>
		<input type="submit" name="Valider" />
	</form>
        <script>
            $(document).ready(function() {
              $("#from").click(function(){
                  this.datepicker(); 
              });
              $("#to").click(function(){
                  this.datepicker(); 
              });            
           });
        </script>
</body>
</html>