<%@page import="simon.entity.Campus"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jps"/>

<body>
    <% List<Campus> listCampus = (List<Campus>) request.getAttribute("list_campus"); 
       Intervention intervention = 
    %>
    
	<form method="POST" action="intervention">
		Sujet: <input type="text" name="sujet" value="\<%= intervention.getValue(); %\>"/>
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