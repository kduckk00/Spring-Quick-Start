<%@page contentType="text/html; charset=EUC-KR"%>

<%
	// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
	session.invalidate();

	// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
	response.sendRedirect("login.jsp");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>