<%@page import="simon.entity.Intervention"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jps"/>

    <body>
        <div>
            <table>
                <tr>
                    <th>Subject</th>
                    <th>Begin</th>
                    <th>End</th>
                    <th>Status</th>
                </tr>
                <% for(Intervention intervention : listIntervention) {%>
                <tr>
                    <td><%= intervention.getSubject() %></td>
                    <td><%= intervention.getBeginning() %></td>
                    <td><%= intervention.getEnding() %></td>
                    <td><%= intervention.status() %></td> <!-- à calculer dans le servlet: ending-beginning -->
                </tr>
                <% } %>
            </table>
            
        </div>
    </body>
</html>
