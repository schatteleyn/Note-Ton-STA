<jsp:include page="header.jps"/>
<body>
	<table>
		<tr>
			<th>Subject: </th>
			<th>Campus: </th>
			<th>Beginning: </th>
			<th>Ending: </th>
			<th>Status: </th>
		</tr>
		<c:forEach items="${interventions}" var="intervention">
                <tr>
                        <td>${intervention.subject }</td>
                        <td>${intervention.campus.name }</td>
                        <td>${intervention.beginning }</td>
                        <td>${intervention.ending }</td>
                        <td>${intervention.status }</td>
                </tr>
		</c:forEach>
	</table>
	<a href="newIntervention.jps">Create a new intervention</a>
</body>
</html>