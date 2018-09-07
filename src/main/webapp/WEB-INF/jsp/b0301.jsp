<!-- 画面ID: B0301 -->
<!-- 画面名: Homepage(Book Keeper) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
$(document).ready(function(){
	/*********************************************************************
     * Book一覧の設定処理
     *********************************************************************/
    bookTable = $("#bookResult").dataTable({
    	"bPaginate" : false,
    	"bFilter" : false,
    	"bInfo" : false,
    	"oLanguage" : {
    		"sEmptyTable" : "<br>"
    	},
    	"bLengthChange" : false
    });

	/*********************************************************************
     * 一覧のソート順の回復処理
     *********************************************************************/
     if ($("#hidSort1").val() != '') {
         bookTable.fnSort(eval($("#hidSort1").val()));
       } else {
         bookTable.fnSort([ [ 0, 'asc', 0 ] ]);
       }

	 /*********************************************************************
     * 検索リンクの押下処理
     *********************************************************************/
     $('#btnSearch').click(function(){
    	 $("#b0301Form").attr("action",'<c:url value="/b0301/search.do"/>');
    	 doSubmit("b0301Form");
     });
});
     /*********************************************************************
      * BookIDリンクの押下処理
      *********************************************************************/
      function doBookLink(lastUpdate, bookID) {
    	 $("#b0301Form").attr("action",
    			 '<c:url value="/b0302.do"/>');
    	 doLinkComm(bookID, lastUpdate);
     }

     /*********************************************************************
      * リンク押下の共通処理
      *********************************************************************/
     function doLinkComm(bookID, lastUpdate) {
    	 //hiddenに値を設定
    	 $("#hidLastUpdate").val(lastUpdate);
    	 $("#hidBookID").val(bookID);
    	 $("#hidSort1").val(convertSortStr($(bookTable.fnSettings().aaSorting)));
    	 doSubmit("b0301Form");
     }

</script>
<form:form id="b0301Form" method="post" modelAttribute="b0301Dto">
<h1> Hello World </h1>
 <div id="entries">
  <table class="wrapper">
	  <tbody>
        <tr>
          <td>
            <table width="100%">
              <tr>
                <td valign="top" align="center">
                  <table class="input" align="center">
                    <tbody>
                      <tr>
                        <td width="20%"></td>
                        <td width="30%"></td>
                        <td width="20%"></td>
                        <td width="30%"></td>
                        <td width="20%"></td>
                        <td width="20%"></td>
                        <td width="30%"></td>
                        <td width="20%"></td>
                      </tr>
                      <tr class="subTitle">
                        <td colspan="9" class="subTitle">資料検索</td>
                      </tr>
                      <tr>
                        <td class="label">資料名</td>
                        <td ><form:input type="text" path="condDto.bookTitle" maxlength="64" /></td>
                        <td class="label">分類</td>
                        <td><form:select path="condDto.categoryID" items="${b0301Dto.condDto.categoryList}" itemValue="code" itemLabel="codeName" /></td>
                      </tr>
                      <tr>
                        <td colspan="4" align="center"><input value="検索" type="button" id="btnSearch" style="width: 80px"></td>
                      </tr>
                    </tbody>
                  </table>
                </td>
              </tr>
             </tbody>
            </table>
          </td>
        </tr>
        <tr>
         <td><table width="100%">
         <tbody>
          <tr class="subTitle">
           <td class="subTitle">検索結果</td>
          </tr>
          <tr>
           <td>
            <table class="tablesorter" id="bookResult">
             <thead>
              <tr>
                          <th width="8%">No</th>
                          <th width="12%">資料ＩＤ</th>
                          <th width="45%">資料名</th>
                          <th width="20%">分類</th>
                          <th width="15%">イメージ</th>
                          <th width="20%">著者</th>
                          <th width="20%">出版社</th>
                          <th width="45%">コメント</th>
                          <th width="15%">登録日</th>

              </tr>
             </thead>
             <tbody>
			  <c:forEach items="${searchResult}" var="bookInfo" varStatus="status">
			   <tr class="break-word">
			    <td align="left">${status.index + 1}</td>
			    <td align="left"><a href='javascript:void(0);'
			      onclick="doBookLink('${bookInfo.lastUpdate}','${bookInfo.bookID}');return false;">
			      <c:out value="${bookInfo.bookID}" escapeXml="false"></c:out></a>
			    </td>
			    <td align="left"><c:out value="${bookInfo.bookTitle}" escapeXml="false"></c:out></td>
			    <td align="left"><c:out value="${bookInfo.categoryName}"></c:out></td>
			    <td align="left"><c:out value="${bookInfo.bookCover}" escapeXml="false"></c:out></td>
			    <td align="left"><c:out value="${bookInfo.author}" escapeXml="false"></c:out></td>
			    <td align="left"><c:out value="${bookInfo.publisher}" escapeXml="false"></c:out></td>
			    <td align="left"><c:out value="${bookInfo.description}" escapeXml="false"></c:out></td>
			    <td align="left">
			    	<fmt:formatDate value="${bookInfo.regDate}" pattern="MM/dd/yyyy" var="parsedRegDate" />
			    	<c:out value="${parsedRegDate}" escapeXml="false"></c:out>
			    </td>
			   </tr>
			  </c:forEach>
			 </tbody>
			</table>
		   </td>
		  </tr>
		  <tr>
		   <td>&nbsp;</td>
		  </tr>
		 </tbody>
		</table></td>
	</tr>
  </tbody>
</table>
</div>
<!-- 指定されたBookのLastUpdate -->
<form:hidden id="hidLastUpdate" path="bookInfo.lastUpdate" />
<!-- 指定されたbookID -->
<form:hidden id="hidBookID" path="bookInfo.bookID" />
<!-- 指定されたhidSort1 -->
<form:hidden id="hidSort1" path="listRecoveryDto.sort1" />
<!-- 遷移先画面ID -->
<form:hidden id="hidSakiID" path="listRecoveryDto.sakiID" />
</form:form>