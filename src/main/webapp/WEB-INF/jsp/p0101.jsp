<!-- 画面ID： P0101 -->
<!-- 画面名： Homepage(SiteManager) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
  $(document).ready(function() {
    /*********************************************************************
     * Homepage(SiteManager)一覧の設定処理
     *********************************************************************/
    userTable = $("#userResult").dataTable({
      "bPaginate" : false,
      "bFilter" : false,
      "bInfo" : false,
      "oLanguage" : {
        "sEmptyTable" : " <br>"
      },
      "bLengthChange" : false
    });

    /*********************************************************************
     * 画面の検索処理
     *********************************************************************/
    $('#btnSearch').click(function() {
      $("#p0101Form").attr("action", '<c:url value="/p0101/search.do"/>');
      doSubmit("p0101Form");
    });

    /*********************************************************************
     * 一覧のソート順の回復処理
     *********************************************************************/
    if ($("#hidSort1").val() != '') {
      userTable.fnSort(eval($("#hidSort1").val()));
    } else {
      //userTable.fnSort([ [ 1, 'asc', 0 ] ]);
      userTable.fnSort([ [ 0, 'asc', 0 ] ]);
    }
    
    /*********************************************************************
     * errorMsg空ではない場合、errorMsgを表示する
     *********************************************************************/
    if ('${param.errorMsg}' != "") {
      alert('${param.errorMsg}');
    }
  });
  /*********************************************************************
   * UserNameリンクの押下処理
   *********************************************************************/
  function doUserLink(theObj, lastUpdate, userType) {
    var loginID = theObj[0].parentNode.children[1].value;
    // 該当ユーザのUserTypeが「1:Operator」または「2:の場合、MOL　User画面へ遷移する。
    if (userType == "1" || userType == "2") {
      $("#p0101Form").attr("action",
          '<c:url value="/s0101.do?modeType=listUser"/>');
      doLinkComm(loginID, lastUpdate, "S0101");
    }

  }
  /*********************************************************************
   * リンク押下の共通処理
   *********************************************************************/
  function doLinkComm(loginID, lastUpdate, sakiID) {
    $("#hidLoginID").val(loginID);
    $("#hidLastUpdate").val(lastUpdate);
    $("#hidMotoID").attr("value", "P0101");
    $("#hidSakiID").val(sakiID);
    $("#hidMotoAction").val("/p0101/back");
    $("#hidSort1").val(convertSortStr($(userTable.fnSettings().aaSorting)));
    doSubmit("p0101Form");
  }
</script>
<form:form id="p0101Form" method="post" modelAttribute="p0101Dto">
  <div id="entries">
    <table class="wrapper">
      <tbody>
        <tr>
          <td>
            <table width="100%">
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
                        <td colspan="4" class="subTitle">ユーザ検索</td>
                      </tr>
                      <tr>
                        <td class="label">氏名</td>
                        <td ><form:input type="text" path="condDto.name" maxlength="64" /></td>
                        <td class="label" >Login ID</td>
                        <td ><form:input type="text" path="condDto.loginID" maxlength="16" /></td>
                      </tr>
                      <tr>
                        <td class="label">ユーザ種類</td>
                        <td><form:select path="condDto.type" items="${p0101Dto.condDto.typeList}" itemValue="code" itemLabel="codeName" /></td>
                        <td class="label">状態</td>
                        <td><form:select path="condDto.status" items="${p0101Dto.condDto.statusList}" itemValue="code" itemLabel="codeName" /></td>
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
                    <table class="tablesorter" id="userResult">
                      <thead>
                        <tr>
                          <th width="10%">No</th>
                          <th width="50%">氏名</th>
                          <th width="25%">種類</th>
                          <th width="20%">状態</th>
                        </tr>
                      </thead>
                      <tbody>
                        <c:forEach items="${searchResult}" var="userInfo" varStatus="status">
                          <tr class="break-word">
                            <td align="left">${status.index + 1}</td>
                            <td align="left"><a href='javascript:void(0);'
                              onclick="doUserLink($(this), '${userInfo.lastUpdate}', '${userInfo.userType}');return false;">
                              <c:out value="${userInfo.userName}" escapeXml="false"></c:out></a>
                              <input type="hidden" value="${userInfo.loginID}" id="hdnLoginID"/>
                            </td>
                            <td align="left"><c:out value="${userInfo.userTypeName}"></c:out></td>
                            <td align="left"><c:out value="${userInfo.statusName}"></c:out></td>
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
  <!-- 指定されたUserのLastUpdate -->
  <form:hidden id="hidLastUpdate" path="userInfo.lastUpdate" />
  <!-- 指定されたUserのloginID -->
  <form:hidden id="hidLoginID" path="userInfo.loginID" />
  <!-- 指定されたUserのuserTyp -->
  <form:hidden id="hidUserType" path="userInfo.userType" />
</form:form>
