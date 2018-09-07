<!-- 画面ID： B0101 -->
<!-- 画面名： Homepage(Reader) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<c:url value='/js/jquery.bxslider.min.js'/>"></script>
<script type="text/javascript">
$(document).ready(function() {

	$('.bxslider').bxSlider({

	  infiniteLoop: false,
	  hideControlOnEnd: true
	});

});
  /*********************************************************************
   * Categoryリンクの押下処理
   *********************************************************************/
  function doCategoryLink(categoryCode) {
    //hiddenに値を設定
    $("#hidCategoryCode").val(categoryCode);
    doSubmit("b0101Form");
  }

</script>
<form:form id="b0101Form" method="post" modelAttribute="b0101Dto">
<div id="entries">
	<div id="showmenu">
  		<ul>
  		  <c:forEach items="${b0101Dto.categoryList}" var="category" varStatus="status">
    		<li <c:if test="${category.code == b0101Dto.condDto.categoryID}">
    			style="background-color:#661111"
    			</c:if>>
    			<a href='javascript:void(0);'
                 onclick="doCategoryLink('${category.code}');return false;" class="showmenu_li">
                 <c:out value="${category.codeName}" escapeXml="false"></c:out>
                </a>
    		</li>
    	  </c:forEach>
  		</ul>
	</div>
  <div id="bookshow">
	<ul class="bxslider">
	  <c:forEach items="${searchResult}" var="bookInfo" varStatus="status">
		<div class="bookcontent">
			<table width="85%">
						<tr>
						  <td width="20%"></td>
						  <td width="65%"></td>
						  <td width="15%"></td>
						</tr>
						<tr>
						　　	<td class="orderComment" colspan="3">
								<c:out value="${bookInfo.categoryName}" escapeXml="false"></c:out>
							</td>
							<td></td>
							<td></td>
						</tr>
					   	<tr>
					   	　 <td></td>
					   	  <td colspan="2">
					   	     <h1><c:out value="${bookInfo.bookTitle}" escapeXml="false"></c:out></h1>
					   	  </td>
					   	  <td></td>
					   	</tr>
					   	<tr>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   	</tr>
					   	<tr>
					   	  <td>
					   	  	著者
					   	  </td>
					   	  <td>
					   	    <c:out value="${bookInfo.author}" escapeXml="false"></c:out>
					   	  </td>
					   	  <td rowspan="9" >
					   	  	<img src="<c:url value="${bookInfo.coverImgUrl}"/>" height="220"/>
					   	  </td>
					   	</tr>
					   	<tr>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   	</tr>
					   	<tr>
					   		<td>出版社</td>
					   		<td><c:out value="${bookInfo.publisher}" escapeXml="false"></c:out></td>
					   		<td></td>
					   	</tr>
					   	<tr>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   		<td>&nbsp;</td>
					   	</tr>
					   	<tr>
					   	  <td colspan="2">
					   	  	<c:out value="${bookInfo.description}" escapeXml="false"></c:out>
					   	  </td>
					   	  <td>
						  </td>
					   	  <td>
					   	  </td>
					   </tr>
			</table>
		</div>
	  </c:forEach>
	</ul>
  </div>
</div>
  <!-- 指定されたCategoryCode -->
  <form:hidden id="hidCategoryCode" path="condDto.categoryID" />
</form:form>
