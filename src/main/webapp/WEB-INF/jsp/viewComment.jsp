<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

$(document).ready(function() {
  var comment = window.dialogArguments;
  $("p").html(html_encode(comment));
});
</script>
<table style="width:360px;word-wrap:break-word;word-break:break-all;">
<tr>
<td width="25%"><img src="<c:url value='/img/info.png'/>" style="width:50; "/></td>
<td width="75%" height="170">
<p id="lblComment"></p>
</td>
</tr>
<tr>
<td align="center" colspan=2>
${window.dialogArguments}
<br>
<input  value="OK" type="button" name="btnCopy" id="btnCopy3" onclick="window.close();"
                    style="width:80px">
</td>
</tr>
</table>
