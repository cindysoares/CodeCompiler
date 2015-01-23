<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Code Compiler</title>
</head>
<%
	//String code = request.getParameter("javaCode");
	//String logMessage = request.getParameter("logMessage");
 %>
<body>
	<p>Input your Java source code and click in 'Compile and Run' to test your code.</p>
	<form action="codeCompilerServlet" method="POST" >
		<table width="100%">
			<tr height="10%">
				<td><b>Java code:</b></td>
				<td></td>
				<td><b>Log messages:</b></td>
			</tr>
			<tr height="90%">
				<td valign="top" width="42%">
					<textarea name="javaCode" style="width:100%; height: 500px;" ></textarea>
				</td>
				<td valign="top" width="16%">
					<input type="submit" value="Compile and Run" />
				</td>
				<td valign="top" width="42%">
					<textbox name="logMessage" style="width:100%; height: 500px;" ></textbox>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>