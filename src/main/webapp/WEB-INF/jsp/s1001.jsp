<!-- 画面ID： S1001 -->
<!-- 画面名： Change Password -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
  <script type="text/javascript">
  $(document).ready(function() {
      if ('${closeFlg}' == "true") {
          window.close();
      }
     if ('${errorMsg}' != "") {
         alert('${errorMsg}');
     }

  /*********************************************************************
   * Changeボタンの押下処理
   *********************************************************************/
   $('#btnModify').click(function() {
       // パスワード必須チェック
       if (!commonChk($("#oldPassword"), 16, true, 1)) {
           return false;
       }
       if (!commonChk($("#newPassword"), 16, true, 1)) {
           return false;
       }
       if (!commonChk($("#confirmPassword"), 16, true, 1)) {
           return false;
       }
       // 新パスワードの複雑度チェック
       if (!passChk($("#newPassword"), '<fmt:message key="W0009"/>')) {
           return false;
       }
       // New PasswordとConfirm New Passwordは同じ出ない場合
       if ($("#newPassword").val() != $("#confirmPassword").val()) {
           alert('<fmt:message key="W0010"/>');
           return false;
       }
       
       // サブミットする
		if(confirm('<fmt:message key="R0010"/>')) {
		    $("#s1001Form").attr("action", '<c:url value="/s1001/modify.do"/>');
     		doSubmit("s1001Form");
     	}
      });
   
   /*********************************************************************
    * Cancelボタンの押下処理
    *********************************************************************/
    $('#btnCancel').click(function() {
        window.close();
    });
  });
    </script>

<form:form id="s1001Form" method="post" modelAttribute="s1001Dto">
<div id="${s1001Dto.divType }">
    <table class="wrapper">
      <tbody>
        <tr>
          <td valign="top" align="left">
            <table class="input">
              <tbody>
                <tr>
                  <td width="10%"></td>
                  <td width="30%"></td>
                  <td width="20%"></td>
                  <td width="30%"></td>
                </tr>
                <tr class="subTitle">
                  <td colspan="4" class="subTitle">
                    Change Password
                  </td>
                </tr>
                <tr>
                  <td/>
                  <td class="mustinputlabel" >
                    Old Password
                  </td>
                  <td >
                    <form:input type="password"  path="oldPassword" id="oldPassword" maxlength="16"/>
                  </td>
                </tr>
                <tr>
                <td/>
                 <td class="mustinputlabel" >
                    New Password
                  </td>
                  <td >
                  	<form:input type="password"  path="newPassword" id="newPassword" maxlength="16"/>
                  </td>
                </tr>
                <tr>
                <td/>
                  <td class="mustinputlabel" >
                    Confirm New Password
                  </td>
                  <td >
                    <form:input type="password"  path="confirmNewPassword" id="confirmPassword" maxlength="16"/>
                  </td>
                </tr>
                <tr>
                  <td colspan="4" align="center">
                    <br>
                    <input value="Change" type="button" id="btnModify"
                    style="width:80px" >
                    <c:if test="${s1001Dto.divType == 'popup'}"> 
                       <input  value="Cancel" type="button" id="btnCancel"
                    style="width:80px">
                    </c:if>
                    
                  </td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
</div>
<!-- ログインID -->
  <form:hidden path="loginID" />
  <form:hidden path="divType" />
</form:form>