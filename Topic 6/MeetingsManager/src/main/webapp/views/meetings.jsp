<%@ include file="/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h2>Meetings</h2>
    <c:forEach items="${model.meetings}" var="meet">
    	<h3>Meeting:</h3>
    	<h4>Attendees:</h4>    	
    	<c:forEach items="${meet.attendees}" var="at">
   		<c:out value="${at.lastName}"/>, <c:out value="${at.firstName}"/><br>
    	</c:forEach>
    	<h4>Room:</h4>
    	<c:out value="${meet.room.nameRoom}"/> 
    	<h4>Date:</h4>
    	<c:out value="${meet.dateSlot}"/>
    	<h4>Time slot:</h4>
    	Before <c:out value="${meet.timeBefore}"/>hs to <c:out value="${meet.timeTo}"/>hs  
    </c:forEach>
  </body>
</html>