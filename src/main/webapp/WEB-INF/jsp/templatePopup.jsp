<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%><%
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%
%><%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%
%>
<link rel="stylesheet" href="<c:url value='/css/import.css'/>" type="text/css" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<script type="text/javascript" src="<c:url value='/js/jquery-latest.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ui.core.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ui.widget.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.ui.datepicker.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.dataTables.min.js'/>"></script>
<!-- Menu  -->
<script type="text/javascript" src="<c:url value='/js/jquery.easing.1.3.js'/>"></script>
<!-- jQuery Editable Combobox  -->
<script type="text/javascript" src="<c:url value='/js/jquery.jec-1.3.3.js'/>"></script>
<!-- 画面入力チェック  -->
<script type="text/javascript" src="<c:url value='/js/bpcheck.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/mol.js'/>"></script>
<title>FatasyBookshelf</title>
<base target="_self" />
</head>
<body style="width: 90%; height: 100%">


<tiles:insertAttribute name="check" />
    <tiles:insertAttribute name="body" />
    <input id="comParamTokenKey" type="hidden" value="${tokenKey}" />
</body>
</html>
