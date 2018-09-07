var Working = false;
var Chktime = 0;


/*********************************************************************
 * フォームのサブミット処理
 *********************************************************************/
function doSubmit(formId) {
  var distTime = (new Date()).getTime() - Chktime;
  if (Working && distTime > 100 && distTime < 3000) {
    return false;
  } else {
    Working = true;
    Chktime = (new Date()).getTime();
    var tokenKey = $("#comParamTokenKey").attr("value");
    $('<input type="hidden" id="tokenKey" name="tokenKey" value="' + tokenKey + '"/>').prependTo($('#' + formId));
    $('#' + formId).submit();
  }
}

/*********************************************************************
 * ソート順の転換処理
 *********************************************************************/
function convertSortStr(obj) {
	var value = "[";
	var temp = "";
	var objLen = obj.length;
    $.each(obj, function(index, row){

    	value = value + "[" + row + "]";
    	if (objLen - 1 > index) {
        	value = value + ",";
    	} 
    })
    value = value.replace(/asc/g, "'asc'");
	value = value.replace(/desc/g, "'desc'");
	value = value + "]";
	return value;
}

function isCookieEnabled() {
  if (navigator.cookieEnabled) {
    return true;
  }
  return false;
}

/*********************************************************************
 * ドロップダウンの空行追加処理
 *********************************************************************/
function addDropDownEmpty()
{
  $("select").prepend($('<option class="first" value=" "></option>'));
  $("select.favorite option.first").html("My Favorite");
  setTimeout(function() {
    $("select").each(function (i, n) {
      if (trim(this.val()) == "") {
        this.val(" ");
      }
    })
    },1);
}

/*********************************************************************
 * ドロップダウンの連動処理
 *********************************************************************/
function fillDataForAjaxNoEmpty($e, objArray)
{
    $e.html("");
    var appendStr = '';
    $.each(objArray, function (i, n)
      {
            appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
      });
    $e.append(appendStr);
    $e.addClass("relateClass");
}

/*********************************************************************
 * ドロップダウンの連動処理
 *********************************************************************/
function fillDataForAjax($e, objArray, emptyStr)
{
    $e.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
    $.each(objArray, function (i, n)
      {
            appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
      });
    $e.append(appendStr);
    $e.addClass("relateClass");
}

/*********************************************************************
 * ドロップダウンの連動処理
 *********************************************************************/
function fillData($e, parentCode, objArray, emptyStr)
{
    $e.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
    if (trim(parentCode) != "") {
      $.each(objArray, function (i, n)
          {
              if (this.parentCode == parentCode)
              {
                appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
              }
          });
    }
    $e.append(appendStr);
    $e.addClass("relateClass");
}

/*********************************************************************
 * ドロップダウンの連動処理
 *********************************************************************/
function fillDataForPort($e1, $e2, $e3, objArray, emptyStr)
{
    $e1.html("");
    $e2.html("");
    $e3.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
	  $.each(objArray, function (i, n)
	      {
	         appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
	      });
    $e1.append(appendStr);
    $e1.addClass("relateClass");
    $e2.append(appendStr);
    $e2.addClass("relateClass");
    $e3.append(appendStr);
    $e3.addClass("relateClass");
}

/*********************************************************************
 * ドロップダウンの連動処理(Agent用）
 *********************************************************************/
function fillDataForAgent($e, parentCode, objArray, emptyStr)
{
    $e.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
    if (trim(parentCode) != "") {
      $.each(objArray, function (i, n)
        {
            if (this.parentCode == parentCode)
            {
              appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
            }
        });
    }
    $e.append(appendStr);
    $e.addClass("relateAgentClass");
}

/*********************************************************************
 * ドロップダウンの連動処理(検索条件用）
 *********************************************************************/
function fillDataForRegion($e, parentCode, objArray, emptyStr)
{
    $e.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
    $.each(objArray, function (i, n)
    {
    if (parentCode == "") {
          appendStr = appendStr + "<option value='" + html_encode(this.regionID) + "'>" + html_encode(this.regionName) + "</option>";
          } else {
          if (this.teamInCharge == parentCode)
          {
            appendStr = appendStr + "<option value='" + html_encode(this.regionID) + "'>" + html_encode(this.regionName) + "</option>";
          }
      }
    });
    $e.append(appendStr);
    $e.addClass("relateClass");
}

/*********************************************************************
 * Supplier HomePage画面のアクションクラスの連動処理(検索条件用）
 *********************************************************************/
function fillDataByTwo($e, parentCode1, parentCode2, objArray, emptyStr)
{
    $e.html("");
    if (emptyStr == undefined) {
      emptyStr = "";
    }
    var itRegion;
    var appendStr = '';
    appendStr = appendStr + "<option value=''>" + emptyStr + "</option>";
    $.each(objArray, function (i, n)
    {
        if (trim(parentCode1) == "") {
          if (trim(parentCode2) == "") {
            appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
          } else {
            if (this.parentCode.lastIndexOf(parentCode2) == this.parentCode.length - parentCode2.length) {
              appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
            }
          }
        } else {
          if (trim(parentCode2) == "") {
            itRegion = this.parentCode.substring(0, this.parentCode.indexOf("/"));
            if (itRegion == parentCode1) {
              appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
            }
          } else {
            if (this.parentCode == parentCode1 + "/" + parentCode2) {
              appendStr = appendStr + "<option value='" + html_encode(this.code) + "'>" + html_encode(this.codeName) + "</option>";
            }
          }
        }
    });
    $e.append(appendStr);
    $e.addClass("relateClass");
}

function saveDoc() {
  fileDialog.CancelError = true;
  try {
    fileDialog.Filter = "HTM   Files   (*.htm)|*.htm|Text   Files   (*.txt)|*.txt";
    fileDialog.ShowSave();
    var fso = new ActiveXObject("Scripting.FileSystemObject");
    var f = fso.CreateTextFile(fileDialog.filename, true);
    f.write(TxtBody.value);
    f.Close();
  } catch (e) {
  }
}

function html_encode(str)   
{   
  var s = "";   
  if (str == null || str.length == 0) return "";   
  s = str.replace(/&/g, "&amp;");   
  s = s.replace(/</g, "&lt;");   
  s = s.replace(/>/g, "&gt;");   
//  s = s.replace(/ /g, "&nbsp;");   
  s = s.replace(/\'/g, "&#39;");   
  s = s.replace(/\"/g, "&quot;");   
  s = s.replace(/\n/g, "<br>");   
  return s;   
}   

function html_decode(str)   
{   
  var s = "";   
  if (str == null || str.length == 0) return "";   
  s = str.replace(/&amp;/g, "&");   
  s = s.replace(/&lt;/g, "<");   
  s = s.replace(/&gt;/g, ">");   
  s = s.replace(/&nbsp;/g, " ");   
  s = s.replace(/&#39;/g, "\'");   
  s = s.replace(/&quot;/g, "\"");   
  s = s.replace(/<br>/g, "\n");   
  return s;   
}   

function sortDropDownListByText(obj) {  
   obj.html($("option", obj).sort(function(a, b) {  
      return a.text == b.text ? 0 : a.text < b.text ? -1 : 1  
   }));  
} 

function doExcel(url, data, excelUrl, loginUrl) {  
	htmlobj = $.ajax({
	  type: 'POST',
	  url: url,
	  data: data,
	  async:false,
	  dataType: 'json'
	});
	var result = htmlobj.responseText;
	// 0の場合、Excel出力する
	if (result == "0") {
      window.location = excelUrl;
    } else {
        if (result.indexOf("l0101Form") > -1 || result.length > 200) {
        	window.location = loginUrl;
        } else {
    	    alert(result);
    	}
    }
} 

/*********************************************************************
 * 「Grade」ドロップダウンのchange処理
 *********************************************************************/
function changeGrade(gradeItem, viscosityItem, viscosityObj) {
    fillData(viscosityItem, gradeItem.val(), viscosityObj);
    setTimeout(function() {
    	if (viscosityItem[0].options.length > 1) {
    		viscosityItem[0].options.selectedIndex = 1;
    	}
    	viscosityItem.triggerHandler("change");
    }, 1);
}

/*********************************************************************
 * 「Viscosity」ドロップダウンのchange処理
 *********************************************************************/
function changeViscosity(gradeItem, viscosityItem, specItem, remarkItem, specObj, qualityRemarkObj) {
    fillData(specItem, gradeItem.val() + "/" + viscosityItem.val(), specObj);
    fillData(remarkItem, gradeItem.val() + "/" + viscosityItem.val(), qualityRemarkObj);

    setTimeout(function() {
        if (specItem[0].options.length > 1) {
        	specItem[0].options.selectedIndex = 1;
        }
        if (remarkItem[0].options.length > 1) {
        	remarkItem[0].options.selectedIndex = 1;
        }
    }, 1);
}


/*********************************************************************
 * 時間処理
 *********************************************************************/
function preSortDate(dateIn) {
	var date = dateIn.replace("<BR>", "");
	if (date == "-"){
		return 0;
	}
	var eu_date = date.split('/');
	var year = eu_date[2];
	var month = eu_date[0];
	if (month.length == 1) {
		month = 0 + month;
	}
	var day = eu_date[1];
	if (day.length == 1) {
		day = 0 + day;
	}
	return (year + month + day) * 1;
}
