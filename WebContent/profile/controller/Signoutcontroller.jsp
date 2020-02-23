<% 
session.removeAttribute("user_session");
session.setAttribute("login_message", "Sign out successfully");
%>
<script type="text/javascript">
	window.location.href = "http://localhost:8080/Login_Project/profile/view/Home.jsp";
</script>