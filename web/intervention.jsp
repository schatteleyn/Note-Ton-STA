<jsp:include page="header.jps"/>
<body>
	<table>
		<tr>
                    <th>Subject: </th>
                    <th>Beginning: </th>
                    <th>Ending: </th>
                    <th>Status: </th>
                </tr>
		<c:forEach items="${interventions}" var="intervention">
			<tr><td><a href="intervention/detail?intervention=${intervention.id }">${intervention.subject}</a></td><td>${intervention.beginning}</td><td>${intervention.ending}</td><td>${intervention.status} </td></tr>
		</c:forEach>
	</table>
</body>
</html>