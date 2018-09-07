<!-- 画面ID： B0302 -->
<!-- 画面名： Doc Register -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

$(document).ready(function() {

	/*********************************************************************
	* SingleBookモードの時はBookIDをdisable
	*********************************************************************/
	if($('#hidModeType').val()=="singleBook"){
		$("#txtBookID").attr("readOnly", true);
	}

	/*********************************************************************
	* 入力補助カレンダー
	*********************************************************************/
	$("#txtRegDate").datepicker();

	/*********************************************************************
	* 登録ボタン押下処理
	*********************************************************************/
	$('#btnAdd').click(function() {
		// 入力チェック
		if (!doCheck()) {
			return false;
		}
	$("#b0302Form").attr("action", '<c:url value="/b0302/add.do"/>');
		doSubmit("b0302Form");
	});

	/*********************************************************************
	* 更新ボタン押下処理
	*********************************************************************/
	$('#btnModify').click(function() {
		// 入力チェック
		if (!doCheck()) {
			return false;
		}
		$("#b0302Form").attr("action", '<c:url value="/b0302/modify.do" />');
		doSubmit("b0302Form");
	});

	/*********************************************************************
	* 削除ボタン押下処理
	*********************************************************************/
	$('#btnDelete').click(function() {
		//Warning and confirming before delete.
		var r=confirm('<fmt:message key="W0021"/>');
		if (r==true){
			$("#b0302Form").attr("action", '<c:url value="/b0302/delete.do"/>');
    		doSubmit("b0302Form");
		}
	});


	/*********************************************************************
	* 戻るボタン押下処理
	*********************************************************************/
	$('#btnBack').click(function() {

		$("#b0302Form").attr("action", '<c:url value="/b0301/back.do"/>');
		doSubmit("b0302Form");
	});

	// エラー処理
    if ('${errorMsg}' != "") {
		alert('${errorMsg}');
	}
});

/*********************************************************************
 * 共通チェック処理
 *********************************************************************/

 function doCheck(){
     // 入力チェック
     if (!commonChk($('#txtBookID'), 50, 1, 1)) {
         return false;
     }
     if (!commonChk($('#txtBookTitle'), 1024, 1, 0)) {
         return false;
     }
     return true;
  }
</script>
<form:form id="b0302Form" method="post" action="b0302.do" modelAttribute="b0302Dto" enctype="multipart/form-data">
  <div id="entries">
    <table class="wrapper">
      <tbody>
        <tr>
          <td valign="top" align="left">
            <table class="input">
              <tbody>
                <tr>
                  <td width="20%"></td>
                  <td width="30%"></td>
                  <td width="20%"></td>
                  <td width="30%"></td>
                </tr>
                <tr class="subTitle">
                  <td colspan="4" class="subTitle">
                    資料登録・更新
                    </td>
                </tr>
                  <tr>
                    <td class="mustinputlabel">分類</td>
                    <td><form:select path="categoryID" id="drpCategory" items="${b0302Dto.categoryList}" itemValue="code"
                        itemLabel="codeName" />
                    </td>
                    <td class="label" colspan="1">
                      <c:if test="${b0302Dto.modeType == 'singleBook'}">
                    	資料ID：&nbsp;&nbsp;<c:out value="${b0302Dto.bookID}"/>
                    	<form:hidden id="hidBookID"  path="bookID" />
                      </c:if>
                    </td>
                    <td class="break-word" colspan="1" rowspan="6" >
                      <c:if test="${b0302Dto.modeType == 'singleBook'}">
                    	<img src="<c:url value="${b0302Dto.coverImgUrl}"/>" height="220"/>
                      </c:if>
                    </td>
                  </tr>
                  <tr>
                    <td class="mustinputlabel">資料名</td>
                    <td colspan="2">
                     <form:input path="bookTitle" maxlength="256" id="txtBookTitle"  />
                    </td>
                  </tr>
                  <tr>
                    <td class="label">著者</td>
                    <td colspan="2">
                     <form:input path="author" maxlength="256" id="txtAuthor"  />
                    </td>
                  </tr>
                  <tr>
                    <td class="label">出版社</td>
                    <td colspan="2">
                     <form:input path="publisher" maxlength="256" id="txtPublisher"  />
                    </td>
                  </tr>
                  <tr>
                    <td class="label">コメント</td>
                    <td colspan="2">
                     <form:textarea path="description" maxlength="1024" id="txtDescription" rows="10"/>
                    </td>
                  </tr>
				  <tr>
                    <td class="label">資料イメージ</td>
                    <td colspan="2">
                     <form:input type="file" path="mpFile" id="mpFile"/>
                     <form:hidden id="hidCoverImgID"  path="coverImgID" />
                    </td>
                  </tr>
				  <tr>
                    <td class="label">登録日</td>
                    <td colspan="1">
                     <fmt:formatDate value="${regDate}" pattern="MM/dd/yyyy" />
                     <form:input path="regDate" maxlength="1024" id="txtRegDate"  />
                    </td>
                  </tr>
                  <tr>
					<c:if test="${b0302Dto.modeType == 'reg'}">
						<td colspan="4" align="center"><br>
							<input value="登録" type="button" name="btnAdd" id="btnAdd" style="width: 80px"></td>
					</c:if>
				  </tr>
				  <tr>
				  	<c:if test="${b0302Dto.modeType == 'singleBook'}">
				  		<td colspan="4" align="center">
				  			<input value="更新" type="button" name="btnModify" id="btnModify"  style="width: 80px">
					 		<input value="削除" type="button" name="btnDelete" id="btnDelete"  style="width: 80px">
					 		<input value="戻る" type="button" name="btnBack" id="btnBack"  style="width: 80px"></td>
				  	</c:if>
				  </tr>
              </tbody>
            </table>
            <tr>
              <td>&nbsp;</td>
            </tr>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <form:hidden id="hidModeType"  path="modeType" />
  <form:hidden id="hidLastUpdate" path="lastUpdate" />
</form:form>