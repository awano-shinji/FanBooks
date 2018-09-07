<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function commonChk(aEdit, len, isMust, checkNo) {
  // チェック対象オブジェクトは存在しない場合、「true」を処理結果に設定して、処理を中止する。
  if (aEdit.length <= 0) {
     return true;
  }
  aEdit.val(trim(aEdit.val()));
  // 入力必須チェック有無が「1：必須チェックを行う」の場合
  if (isMust == 1) {
    if (!nullChk(aEdit, '<fmt:message key="W0002"/>')) {
      return false;
    }
  } else {
    if (trim(aEdit.val()) == "") {
      return true;
    }
  }
  // バイト数が1以上
  if (len > 0) {
    if (!byteChk(aEdit, len, '<fmt:message key="E0009"/>')) {
      return false;
    }
  }
  
  if (checkNo == 1) {
    // 1：半角文字チェック
    if (!hanChk(aEdit, '<fmt:message key="W0005"/>')) {
      return false;
    }
  } else if (checkNo == 2) {
    // 2：半角数字チェック(数字だけ)
    if (!numChk(aEdit, '<fmt:message key="W0004"/>')) {
      return false;
    }
  } else if (checkNo == 3) {
    // 3：整数チェック(正数、負数、零)
    if (!integerChk(aEdit, '<fmt:message key="W0012"/>')) {
      return false;
    }
  } else if (checkNo == 4) {
    // 4：金額チェック（小数2桁まで）
    if (!amountChk(aEdit, '<fmt:message key="W0014"/>')) {
      return false;
    }
  } else if (checkNo == 5) {
    // 5：数量チェック（小数3桁まで)
    if (!countChk(aEdit, '<fmt:message key="W0013"/>')) {
      return false;
    }
  } else if (checkNo == 6) {
    // 6：Ｅ-ＭＡＩＬチェック
    if (!sEmailChk(aEdit, '<fmt:message key="W0006"/>')) {
      return false;
    }
  } else if (checkNo == 7) {
    // 7：日付チェック
    if (!dateChk(aEdit, '<fmt:message key="W0003"/>')) {
      return false;
    }
  } else if (checkNo == 8) {
    // 8：電話番号チェック
    if (!sTelNumChk(aEdit, '<fmt:message key="W0015"/>')) {
      return false;
    }
  }
  return true;
}

/**
 * 関数概要：開始終了日チェック
  * @param String startObj <I> チェック対象(開始日) 
  * @param String endObj <I> チェック対象(終了日) 
  * @return : 処理結果 (True：正常 False：異常)
 */
function startEndDayChk(startObj, endObj, errorMsg){
    // 入力データ
    var startValue = startObj.val();
    var endValue = endObj.val();
    
    // 2.開始日入力された場合、日付チェック
    if ("" != startValue) {
        if (!commonChk(startObj, 0, 2, 7)) {
            return false;
        }
    }
    // 3.終了日入力された場合、日付チェック
    if ("" != endValue) {
        if (!commonChk(endObj, 0, 2, 7)) {
            return false;
        }
    }
    
    // 4.両方入力の場合、開始日 <= 終了日チェック(W00016)
    if ("" != startValue && "" != endValue) {
       startValue = startValue.substring(6,10) + "/" + startValue.substring(0,5);
       endValue = endValue.substring(6,10) + "/" + endValue.substring(0,5);
       if (startValue > endValue) {
    	   if (errorMsg == undefined) {
    		   alert('<fmt:message key="W0008"/>');
    	   } else {
    	       alert(errorMsg);
    	   }
          startObj.focus();
          startObj.select();
          return false;
        }
    }
    return true;
  }

  /**
   * 関数概要：ファイルサイズチェック
   * @param String startObj <I> チェック対象(開始日) 
   * @param String endObj <I> チェック対象(終了日) 
   * @return : 処理結果 (True：正常 False：異常)
   */
  function checkFileSize(fileObj) {
    if (fileObj.val() == '') {
      return true;
    }
    var ua = $.browser;
    var agent = window.navigator.userAgent; 
    var maxSize = 25 * 1024 * 1024;
    // IE6の場合、ファイルサイズチェック
    if (ua.msie && ua.version == 6) {
      var image = new Image();
      image.dynsrc = fileObj.val();
      if (image.fileSize > maxSize) {
        alert('<fmt:message key="E0017"/>');
        return false;
      } else {
        return true;
      }
    } else if (agent.indexOf("Firefox") >= 1) {
      if (fileObj[0].files[0].size > maxSize) {
        alert('<fmt:message key="E0017"/>');
        return false;
      } else {
        return true;
      }
    } else {
      return true;
    }
  }
   
   /**
    * 関数概要：きーの変更チェック
    * @param String drpObj <I> キーのドロップダウン対象 
    * @param String txtObj <I> キーのテキスト対象 
    * @param String txtLabel <I> キーのラベル名 
    * @return : 処理結果 (True：正常 False：異常)
    */
   function checkKeyModify(drpObj, txtObj, txtLabel) {
      if (drpObj.length > 0 && drpObj.val() != txtObj.val()) {
        alert('<fmt:message key="E0019" ><fmt:param value="' + txtLabel + '"/></fmt:message>');
        txtObj.focus();
        txtObj.select();
        return false;
      }
      return true;
   }
    
    /**
     * 関数概要：添付ファイルのチェック
     * @param String drpObj <I> キーのファイル対象 
     * @return : 処理結果 (True：正常 False：異常)
     */
    function checkPath(fileObj) {
       if (fileObj.val() == '') {
         return true;
       }
       var ua = $.browser;
       // IE6の場合、ファイルサイズチェック
       if (ua.msie && ua.version == 6) {
         var image = new Image();
         image.dynsrc = fileObj.val();
         if (image.fileSize < 0) {
           alert('<fmt:message key="E0020"/>');
           fileObj.focus();
           fileObj.select();
           return false;
         }
         return true;
       }
       return true;
    }
</script>
