<%@page import="simon.entity.Intervention"%>
<jsp:include page="header.jps"/>

<body>
    
    <h2><%= intervention.getSubject() %></h2>
    
    <p>From <%= intervention.getBeginning() %> to <%= intervention.getEnding() %> <br />
    Campus: <%= intervention.getCampus() %></p>
    
    <p><%= intervention.getDescription() %></p>
    
    <p>
        <ul>
            <li>Number of marks: </li>
            <li>Speaker mark: </li>
            <li>Slides mark: </li>
            <li>Global event mark: </li>
        </ul>
    </p>
    
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
        
        <a href="#" data-controls-modal="modal-from-dom" data-backdrop="true" data-keyboard="true">Evaluate</a>
        
    </body>
</html>
