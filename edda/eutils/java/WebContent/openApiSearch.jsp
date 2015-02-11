<%-- Set the content type header with the JSP directive --%>
<%@ page contentType="application/json; charset=UTF-8" %>

<%-- Set the content disposition header --%>
<%
   // Returns all employees (active and terminated) as json.
   response.setContentType("application/json");
   response.setHeader("Content-Disposition", "inline");
%>
[
   {"label":"item 1", "value":"item 1", "id": 1},
   {"label":"item 2", "value":"item 2", "id": 2},
   {"label":"item 3", "value":"item 3", "id": 3}
]
