<jsp:include page="header.jps"/>
    <div>  
    <h2><c:out value="${ subject}" /></h2>
    
    <p>From <c:out value="${ beginning}" /> to <c:out value="${ ending }"/> <br />
    Campus: <c:out value="${ campus}" /></p>
    
    <p><c:out value="${ description}" /></p>
    
    <p>
        <ul>
            <li>Number of marks: <c:out value="${ totalMarks }" /></li>
            <li>Speaker mark: <c:out value="${ speakerMarks }" /></li>
            <li>Slides mark: <c:out value="${ slideMarks }" /></li>
            <li>Global event mark: <c:out value="${ globalMarks }" /></li>
        </ul>
    </p>
    </div>
    <div>
    <script type="text/javascript">
        var chart;
        $(document).ready(function() {
            chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'chart_container',
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: 'Grades\' chart'
                },
                tooltip: {
                    formatter: function() {
                        return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
                    }
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            color: '#000000',
                            connectorColor: '#000000',
                            formatter: function() {
                                return '<b>'+ this.point.name +'</b>: '+ Math.round(this.percentage * 100) / 100 +' %';
                            }
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'Grades',
                    data: [
                        ${intervention.StringChart}
                    ]
                }]
            });
            $('#modal-from-dom').modal({ backdrop: true });
            $('#evaluate').click(function(){
                $('#modal-from-dom').modal('toggle');
                return false;
            });
        });

    </script>
    </div>
    <div id="chart_container"></div>
<script type="text/javascript">
    $(function(){
        $('#modal-from-dom').modal({ backdrop: true });
        $('#evaluate').click(function(){
            $('#my-modal').modal('toggle');
            return false;
        });
    });
</script>

    <!-- grading -->
        <div id="modal-from-dom" class="modal hide fade">
            <div class="modal-body">
                <form method="POST" action="">
                    ID Booster: <input type="text" name="idBooster"/>
                    <h3>About the speaker</h3>
                    <table class="bordered-table">
                        <tr>
                            <td></td>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                        </tr>
                        <tr>
                            <td>His knowledge of the subject: </td>
                            <td><input type="radio" id="1" name="note1" /></td>
                            <td><input type="radio" id="2" name="note1" /></td>
                            <td><input type="radio" id="3" name="note1" /></td>
                            <td><input type="radio" id="4" name="note1" /></td>
                            <td><input type="radio" id="5" name="note1" /></td>
                        </tr>
                        <tr>
                            <td>His teaching abilities: </td>
                            <td><input type="radio" id="1" name="note2" /></td>
                            <td><input type="radio" id="2" name="note2" /></td>
                            <td><input type="radio" id="3" name="note2" /></td>
                            <td><input type="radio" id="4" name="note2" /></td>
                            <td><input type="radio" id="5" name="note2" /></td>
                        </tr>
                        <tr>
                            <td>The quality of answers: </td>
                            <td><input type="radio" id="1" name="note3" /></td>
                            <td><input type="radio" id="2" name="note3" /></td>
                            <td><input type="radio" id="3" name="note3" /></td>
                            <td><input type="radio" id="4" name="note3" /></td>
                            <td><input type="radio" id="5" name="note3" /></td>
                        </tr>
                    </table>
                    <h3>About the slides</h3>
                    <table class="bordered-table">
                        <tr>
                            <td></td>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                            <td>4</td>
                            <td>5</td>
                        </tr>
                        <tr>
                            <td>The reachness of the content: </td>
                            <td><input type="radio" id="1" name="note4" /></td>
                            <td><input type="radio" id="2" name="note4" /></td>
                            <td><input type="radio" id="3" name="note4" /></td>
                            <td><input type="radio" id="4" name="note4" /></td>
                            <td><input type="radio" id="5" name="note4" /></td>
                        </tr>
                        <tr>
                            <td>The format/layout: </td>
                            <td><input type="radio" id="1" name="note5" /></td>
                            <td><input type="radio" id="2" name="note5" /></td>
                            <td><input type="radio" id="3" name="note5" /></td>
                            <td><input type="radio" id="4" name="note5" /></td>
                            <td><input type="radio" id="5" name="note5" /></td>
                        </tr>
                        <tr>
                            <td>The examples: </td>
                            <td><input type="radio" id="1" name="note6" /></td>
                            <td><input type="radio" id="2" name="note6" /></td>
                            <td><input type="radio" id="3" name="note6" /></td>
                            <td><input type="radio" id="4" name="note6" /></td>
                            <td><input type="radio" id="5" name="note6" /></td>
                        </tr>
                    </table>
                    Comments: <textarea name="comments"></textarea>
                </form>
                
                </div>
                <div class="modal-footer">
                      <a href="#" class="btn primary">Send</a>
                </div>
        </div>
        
        <a id="evaluate" href="${pageContext.servletContext.contextPath}/viewIntervention?id=${intervention.id}">Evaluate</a>
        
    </body>
</html>
