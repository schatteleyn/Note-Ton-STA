<jsp:include page="header.jps"/>
	<table>
		<tr>
                    <th>Subject: </th>
                    <th>Beginning: </th>
                    <th>Ending: </th>
                    <th>Status: </th>
                </tr>
		<c:forEach items="${interventions}" var="intervention">
			<tr>
                            <td><a href="intervention/detail?intervention=${intervention.id }">${intervention.subject}</a></td>
                            <td><fmt:formatDate value="${intervention.beginning}" pattern="dd MMMM YYYY"></td>
                            <td><fmt:formatDate value="${intervention.ending}" pattern="dd MMMM YYYY"></td>
                            <c:choose>
                                    <c:when test="${ intervention.from > now }">
                                            Attended
                                    </c:when>
                                    <c:when test="${ intervention.to < now }">
                                            Done
                                    </c:when>
                                    <c:otherwise>
                                            In progress
                                    </c:otherwise>
                            </c:choose>
                        </tr>
		</c:forEach>
	</table>
</body>
</html>