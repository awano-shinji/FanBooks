<!-- 画面ID： S0101 -->
<!-- 画面名：MOL User -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
var userObj = eval(${s0101Dto.userNameList});
$(document).ready(function() {

    /*********************************************************************
     * 「"Mol User"」ドロップダウンの設定処理
     *********************************************************************/
     if ($("#drpUser").length > 0) {
         $("#drpUser").append("<option value=''>Select</option>");
         var userStr = '';
         $.each(userObj, function (i, n)
           {
          if (this.userType == "1") {
            userStr = userStr + "<option value='" + html_encode(this.loginID) + "'>" + html_encode(this.loginID) + "</option>";
            }
        });
         $("#drpUser").append(userStr);
         if ($("#txtLoginID").val() != "") {
           setTimeout(function() {
             if ('${buttonMode}' == 'add') {
               $("#btnAdd").attr("disabled", false);
               $("#btnModify").attr("disabled", true);
             } else {
               $("#drpUser").val($("#txtLoginID").val());
               $("#drpUser").trigger("change");
               $("#btnAdd").attr("disabled", true);
               $("#btnModify").attr("disabled", false);
               $("#btnBack").attr("disabled", false);
             }
           }, 1);

         }
     } else {

         $("#btnModify").attr("disabled", false);
         $("#btnBack").attr("disabled", false);
     }
     /*********************************************************************
      * エラー処理
      *********************************************************************/
      $("#drpUser").css("width", "100%");
      if ('${errorMsg}' != "") {
        alert('${errorMsg}');
      }
    /*********************************************************************
     * 「"Mol User"」ドロップダウンのchange処理
     *********************************************************************/
    $("#drpUser").change(function () {

      if (trim($("#drpUser").val()) == '') {
        $("#txtUserName").val("");
        $("#txtLoginID").val("");
        $("#drpStatus").val("1");
        $("#txtEmail").val("");
        $("#hidLastUpdate").val("");
        $("#btnAdd").attr("disabled", false);
        $("#btnModify").attr("disabled", true);
      } else {
        $.each(userObj, function (i, n)
           {
            if (this.loginID == $("#drpUser").val())
              {
              $("#txtUserName").val(this.userName);
              $("#txtLoginID").val(this.loginID);
              $("#drpStatus").val(this.status);
              $("#txtEmail").val(this.email);
              $("#hidLastUpdate").val(this.lastUpdate);
              }
            });
          $("#btnAdd").attr("disabled", true);
          $("#btnModify").attr("disabled", false);

        }
       });
    /*********************************************************************
     * Addリンクの押下処理
     *********************************************************************/
      $('#btnAdd').click(function() {
          // 入力チェック
         if (!doCheck()) {
             return false;
          }
          $("#s0101Form").attr("action", '<c:url value="/s0101/add.do"/>');
          doSubmit("s0101Form");
      });
      /*********************************************************************
       * Modifyリンクの押下処理
       *********************************************************************/
        $('#btnModify').click(function() {
        // 入力チェック
        if (!doCheck()) {
          return false;
        }
        // Modify の場合、キー項目変更チェック
        if (!checkKeyModify($("#drpUser"), $("#txtLoginID"), "LoginID")) {
           return false;
        }
        $("#s0101Form").attr("action", '<c:url value="/s0101/modify.do"/>');
           doSubmit("s0101Form");
        });
       /*********************************************************************
       * Backリンクの押下処理
       *********************************************************************/
        $('#btnBack').click(function() {

        $("#s0101Form").attr("action", '<c:url value="/p0101/back.do"/>');
           doSubmit("s0101Form");
        });
        /*********************************************************************
         * 共通チェック処理
         *********************************************************************/
         function doCheck(){
           // 入力チェック
           if (!commonChk($('#txtLoginID'), 16, 1, 1)) {
               return false;
           }
           if (!commonChk($('txtPassword'), 16, 1, 1)) {
               return false;
           }
           /*if (!commonChk($('#txtUserName'), 64, 1, 1)) {
             return false;
           }*/
           if (!commonChk($('#drpStatus'), 1, 1, 0)) {
               return false;
           }
           if (!commonChk($('#txtEmail'), 1024, 0, 6)) {
               return false;
           }
           return true;
        }
});
/*********************************************************************
 * ラジオボタンのChange処理
 *********************************************************************/
function changeDisplay(userTypeIn) {
  $("#drpUser").html("");
  $("#drpUser").append("<option value=''>Select</option>");
  var userStr = '';
  $.each(userObj, function (i, n)
      {
       if (this.userType == userTypeIn) {
         userStr = userStr + "<option value='" + html_encode(this.loginID) + "'>" + html_encode(this.loginID) + "</option>";
          }
      });
  $("#drpUser").append(userStr);
  $("#drpUser").triggerHandler("change");
}
</script>
<form:form id="s0101Form" method="post" action="s0101.do" modelAttribute="s0101Dto">
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
                  <c:if test="${s0101Dto.modeType == 'profile'}">
                    My Profile
                    </c:if>
                    <c:if test="${s0101Dto.modeType != 'profile'}">
                    ユーザ登録・更新
                    </c:if></td>
                </tr>

                <c:if test="${s0101Dto.modeType == 'molUser'}">
                  <tr>
                    <td></td>
                    <td colspan=3>
                    <form:radiobutton path="userType" value="1" onclick='changeDisplay("1")'
                        checked="flase" style="width:15px" />閲覧者
                    <form:radiobutton path="userType" value="2"
                        onclick='changeDisplay("2")' style="width:15px" />資料管理者</td>
                  </tr>
                  <tr>
                    <td valign="top" class="label">既存のユーザ</td>
                    <td><form:select path="" id="drpUser" /></td>
                  </tr>
                  <tr>
                    <td class="mustinputlabel">Login ID</td>
                    <td><form:input path="loginID" maxlength="16" id="txtLoginID" />
                  </tr>
                </c:if>
                <c:if test="${s0101Dto.modeType != 'molUser'}">
                  <tr>
                    <td class="label">Login ID</td>
                    <td>
                      <p>
                        <c:out value="${s0101Dto.loginID}" />
                      </p>
                      <form:hidden path="loginID" />
                    </td>
                  </tr>
                </c:if>
                <tr>
                  <td class="mustinputlabel">氏名</td>
                  <td><form:input path="userName" maxlength="64" id="txtUserName" /></td>
                  <c:if test="${s0101Dto.modeType != 'profile'}">
                    <td class="mustinputlabel">状態</td>
                    <td><form:select path="status" id="drpStatus" items="${s0101Dto.statusList}" itemValue="code"
                        itemLabel="codeName" />
                    </td>
                  </c:if>
                </tr>
                <c:if test="${s0101Dto.modeType != 'molUser'}">
                <tr>
                  <td class="label">Password</td>
                  <td colspan="3">
                  <form:input path="Password" maxlength="1024" id="txtPassword"  /></td>
                </tr>
                </c:if>
                <tr>
                  <td class="label">EMail</td>
                  <td colspan="3">
                  <form:input path="email" maxlength="1024" id="txtEmail"  /></td>
                </tr>
                <tr>
                  <td colspan="4" align="center"><br>
                  <c:if test="${s0101Dto.modeType == 'molUser'}">
                      <input value="Add" type="button" name="btnAdd" id="btnAdd" style="width: 80px">
                    </c:if> <input value="Modify" type="button" name="btnModify" disabled id="btnModify"  style="width: 80px">
                    <input value="Back" type="button" name="btnBack" disabled id="btnBack"  style="width: 80px"></td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <form:hidden path="modeType" />
  <form:hidden id="hidLastUpdate" path="lastUpdate" />
</form:form>

