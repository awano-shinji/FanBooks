<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {

	    // Cookieチェック
        if (!isCookieEnabled()) {
          alert('<fmt:message key="W0016"/>');
        }
	    // エラー処理
	    if ('${errorMsg}' != "") {
	        if ('${errorMsg}' == '<fmt:message key="E0001"/>' 
	            ||'${errorMsg}' ==  '<fmt:message key="E0004"/>') {
	           alert('${errorMsg}');

	        } else if ('${errorMsg}' == '<fmt:message key="E0003"/>'){
	          alert('${errorMsg}');
              window.showModalDialog("<c:url value='/s1001.do?loginID="
                        + $("#loginID").val()
                        + "&t=" + (new Date()).getTime()
                        + "'/>",'',
                "dialogHeight:250px; dialogWidth:715px");
	        } else {
	          if (confirm('${errorMsg}')) {
	            $("#hidRemark").attr("value", "1");
	          } else {
	            $("#hidRemark").attr("value", "0");
	          }
	          $("#l0101Form").attr("action", '<c:url value="/l0101.do"/>');
	          doSubmit("l0101Form");
	        }
	    }
        if($('#hidRunFlag').val() == '0'){
            alert('<fmt:message key="E0008"/>');
        }
	    /*********************************************************************
	     * Loginリンクの押下処理
	     *********************************************************************/
	    $('#btnLogin').click(function() {

	            // 入力チェック
	            if (!commonChk($('#loginID'), 16, 1, 1)) {
	                return false;
	            }
	            if (!commonChk($('#password'), 16, 1, 1)) {
                    return false;
                }
	            $("#l0101Form").attr("action", '<c:url value="/l0101.do"/>');
	            doSubmit("l0101Form");

		});
	    /*********************************************************************
	     * Password入力後処理     Added by Tatsumi 20130517
	     *********************************************************************/
	    $('#password').keypress(function(event) {
				if(event.keyCode==13){
	            	// 入力チェック
	            	if (!commonChk($('#loginID'), 16, 1, 1)) {
	                	return false;
	            	}
		            if (!commonChk($('#password'), 16, 1, 1)) {
	                    return false;
	                }
		            $("#l0101Form").attr("action", '<c:url value="/l0101.do"/>');
		            doSubmit("l0101Form");
				}
		});

	});
</script>
<form:form id="l0101Form" method="post" modelAttribute="userInfo">
  <div align="center" valign="middle">
    <table border=1>
      <tbody>
        <tr>
          <td valign="top" align="center">
            <table >
              <tbody>
              	<tr class="subTitle">
                  <td colspan="4" class="mainTitle"></td>
                </tr>
                <tr class="subTitle">
                  <td colspan="4" class="login"></td>
                </tr>
                <tr>
                  <td width="35%"></td>
                  <td class="label" width="10%">LoginID</td>
                  <td width="20%"><form:input type="text" id="loginID" path="loginID" maxlength="16" /></td>
                  <td width="35%"></td>
                </tr>
                <tr>
                  <td></td>
                  <td class="label">Password</td>
                  <td><form:input type="password" path="password1" id="password" maxlength="16" /></td>
                </tr>
                <tr>
                  <td colspan="4" align="center"><br>
                  <input value="Login" type="button" id="btnLogin" style="width: 80px"></td>
                </tr>
                <tr>
                  <td colspan="4" align="center">
                  <font size="7">
                  　ワクワク立ち読みサイト
                  </font>
                  <br>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <input id="hidRunFlag" type="hidden" value="${runFlag}" />
  <form:hidden id="hidRemark" path="remark" />
</form:form>

