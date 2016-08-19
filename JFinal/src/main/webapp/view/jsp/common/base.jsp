<%
	String absoluteUrl = request.getScheme() + "://" 
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getServletContext().getContextPath() + "/";
%>
<base href="<%=absoluteUrl%>">