<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="message" required="true"%>
<html>
  <body>
    <div id="pageheader">
      <jsp:invoke fragment="header"/>
    </div>
    <div id="body">
      <h2>Welcome Page</h2>
      <%  
          if (message != null ) {
      %>
      <h3><%= message %></h3>
      <% } else { %>
      <h3>You are not logged in.</h3>
      <% } %>
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
    </div>
  </body>
</html>
