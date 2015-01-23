<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- %@ page import="com.gteamtrials.CodeCompiler" %-->
<jsp:useBean id="compiler" class="com.gteamtrials.CodeCompiler"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java Code Compiler</title>
</head>
<style>
.textarea, .textbox {
    width: 200px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box; 
}
</style>
<body>
	<p>Input your Java source code, click in 'Compile and Run' to test your code.</p>
	<form action="index.jsp" method="POST">
		<table width="100%">
			<tr height="10%">
				<td><b>Java code:</b></td>
				<td></td>
				<td><b>Log messages:</b></td>
			</tr>
			<tr height="90%">
				<td valign="top" width="40%"><textarea name="code" style="width:100%; height: 500px;"/></td>
				<td valign="top" width="10%"><input type="submit" value="Compile and Run" /><br><br></td>
				<td valign="top" width="40%"><textbox type="text" name="code" style="width:100%; height: 500px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>