<jsp:include page="header.jps"/>
    
	<form method="POST" action="intervention">
            <input type="hidden" name="intervId" value="<c:out value='${intervId}' />" />
		Sujet: <input type="text" name="sujet" value="<c:if test='${not empty subject}'><c:out value='${subject}' /></c:if>" />
                <c:if test="${ not empty error_subject}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_subject}" /></span>
                </c:if>
		Campus: <select name="campus">
                    <c:forEach items="${CampusList}" var="campusOpt">
                            <c:choose>
                                <c:when test="${(not empty campus) && (campus == campusOpt.id) }">
                                        <option value="<c:out value="${campusOpt.id}" />" selected><c:out value="${campusOpt.name}" /></option>
                                </c:when>
                                <c:otherwise>
                                        <option value="<c:out value="${campusOpt.id}" />"><c:out value="${campusOpt.name}" /></option>
                                </c:otherwise>
                            </c:choose>
                    </c:forEach>
			</select>
		De: <input type="text" name="from" id="from" value="<c:out value='${beginning}' />"/>
		A: <input type="text" name="to" id="to" value="<c:out value='${ending}' />"/>
                Description: 
                <textarea name='description'><c:if test="${not empty description }"><c:out value="${description}" /></c:if></textarea>
                <c:if test="${ not empty error_description}">
                        <span style='color : #FF0000; font-weight : bold;'><c:out value="${error_description}" /></span>
                </c:if>
		<input type="submit" name="Valider" />
	</form>
                       
        <script>
            $(document).ready(function() {
              $("#from").click(function(){
                  this.datepicker();
                  dateFormat : "yy-mm-dd";
              });
              $("#to").click(function(){
                  this.datepicker(); 
                  dateFormat : "yy-mm-dd";
              });            
           });
        </script>
</body>
</html>