<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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



<title>FantasyBookshelf</title>
</head>
<body style="width: 90%; height: 100%">
<script type="text/javascript">
$(document).ready(function() {
	$.extend(jQuery.fn.dataTableExt.oSort, {
		"date-eu-asc" : function(aa, bb) {
			var a = preSortDate(aa);
			var b = preSortDate(bb)
			return ((a < b) ? -1 : ((a > b) ? 1 : 0));
		},
		"date-eu-desc" : function(aa, bb) {
			var a = preSortDate(aa);
			var b = preSortDate(bb)
			return ((a < b) ? 1 : ((a > b) ? -1 : 0));
		}
		});
	});
/*********************************************************************
 * BackSpaceの禁止
 *********************************************************************/
$(document).keydown(function(e){   

  var target = e.target;
  var tag = e.target.tagName.toUpperCase();
  if (e.keyCode == 8) {
    if ((tag == 'INPUT' && !$(target).attr("readonly"))
        || (tag == 'TEXTAREA' && !$(target).attr("readonly"))) {
      if ((target.type.toUpperCase() == "RADIO")
          || (target.type.toUpperCase() == "CHECKBOX")) {
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }
});
</script>
  <tiles:insertAttribute name="check" />
  <table>
    <tr>
      <td colspan=2>
        <div id="head" style="background:url(<%=request.getContextPath()%>/img/fbooks/headbk1.jpg) no-repeat top left;">
          <div id="fl_menu">
            <ul>
              <li id="menu"><a>MENU</a></li>
            </ul>
            <div id="subNavi">
              <tiles:insertAttribute name="menu" />
              <iframe class="T_iframe" frameborder="no" border="0"  src="<c:url value='/blank.jsp'/>"></iframe>
            </div>
          </div>
        </div>
      </td>
    </tr>
    <tr>
      <td colspan=2 valign="top" align="center" id="rightcontrol"><tiles:insertAttribute name="body" /> 
      <input id="comParamTokenKey" type="hidden" value="${tokenKey}" /></td>
    </tr>
    <tr>
      <td colspan=2>
        <div id="footer">
          <br>
        </div>
      </td>
    </tr>
  </table>


  <script>
      //config
      $float_speed = 1500; //milliseconds
      $float_easing = "easeOutQuint";
      $menu_fade_speed = 500; //milliseconds
      $closed_menu_opacity = 0.75;

      //cache vars
      $fl_menu = $("#fl_menu");
      $fl_menu_menu = $("#fl_menu #subNavi");
      $fl_menu_label = $("#fl_menu #menu");
      $fl_menu_frame = $("#fl_menu #subNavi .T_iframe");

      $(window).load(function() {

        menuPosition = $('#fl_menu').position().top;

        $fl_menu.hover(function() { //mouse over

          $fl_menu_label.fadeTo($menu_fade_speed, 1);
          $fl_menu_frame.fadeIn(0);
          $fl_menu_menu.fadeIn($menu_fade_speed);

        }, function() { //mouse out
          $fl_menu_label.fadeTo($menu_fade_speed, $closed_menu_opacity);
          $fl_menu_frame.fadeOut(0);
          $fl_menu_menu.fadeOut($menu_fade_speed);

        });
      });


    </script>
</body>
</html>
