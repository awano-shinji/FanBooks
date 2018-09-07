<!-- 画面ID： L0103 -->
<!-- 画面名：MainFrame -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
 <ul class="acc">
  <li class="info">
    <ul class="clearfix">
        <c:choose>
            <c:when test="${menuUser.userType == '0' }">
                <li class="lefttitle">Site Manager</li>
            </c:when>
            <c:when test="${menuUser.userType == '1' }">
                <li><FONT face="Verdana, Arial" size=1><B><c:out value="${systemDate}"/></B></FONT></li>
                <li class="lefttitle">Reader</li>
                <li class="leftsubtitle"><c:out value="${menuUser.userName}" escapeXml="true"/>    様</li>
                <li class="leftcompany">Edu.SJI</li>
            </c:when>
            <c:when test="${menuUser.userType == '2' }">
                <li><FONT face="Verdana, Arial" size=1><B><c:out value="${systemDate}"/></B></FONT></li>
                <li class="lefttitle">Book Keeper</li>
                <li class="leftsubtitle"><c:out value="${menuUser.userName}" escapeXml="true"/>    閣下</li>
                <li class="leftcompany">Edu.SJI</li>
            </c:when>
            <c:when test="${menuUser.userType == '3' }">
                <li><FONT face="Verdana, Arial" size=1><B><c:out value="${systemDate}"/></B></FONT></li>
                <li class="lefttitle">Supplier</li>
                <li class="leftsubtitle"><c:out value="${menuUser.userName}" escapeXml="true"/></li>
            </c:when>
            <c:otherwise>
               <li></li>
               <li></li>
            </c:otherwise>
        </c:choose>
    </ul>
   </li>
   <c:forEach items="${menuGroup}" var="subGroup" varStatus="status">
  <li class="open"><p ><c:out value="${subGroup[0].menuGroup}"/></p>
    <ul class="clearfix">
   <c:forEach items="${subGroup}" var="menuInfo" varStatus="status"> 
     <li><a href='<c:url value="${menuInfo.url}"/>'><c:out value="${menuInfo.menuName}"/></a></li>
    </c:forEach>
    </ul>
   </li>
   </c:forEach>
  </ul>
