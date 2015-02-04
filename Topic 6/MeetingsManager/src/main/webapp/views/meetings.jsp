<%@ include file="/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h2>Meetings</h2>
    <c:forEach items="${model.meetings}" var="meet">
    	<h3>Meeting:</h3>
    	<h4>&nbsp&nbsp Attendees:</h4>    	
    	<c:forEach items="${meet.attendees}" var="at">
   		&nbsp&nbsp&nbsp&nbsp<c:out value="${at.lastName}"/>, <c:out value="${at.firstName}"/><br>
    	</c:forEach>
    	<h4>&nbsp&nbsp Room:</h4>
    	&nbsp&nbsp&nbsp&nbsp<c:out value="${meet.room.nameRoom}"/> 
    	<h4>&nbsp&nbsp Date:</h4>
    	&nbsp&nbsp&nbsp&nbsp<c:out value="${meet.dateSlot}"/>
    	<h4>&nbsp&nbsp Time slot:</h4>
    	&nbsp&nbsp&nbsp&nbsp Before <c:out value="${meet.timeBefore}"/>hs to <c:out value="${meet.timeTo}"/>hs  
    </c:forEach>
  </body>
</html>