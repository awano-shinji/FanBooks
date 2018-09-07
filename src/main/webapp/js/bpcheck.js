/*
*################################################################################
*# 機能名称: クライアント共通関数
*#-------------------------------------------------------------------------------
*# ﾌｧｲﾙ名称: bpcheck.js
*#-------------------------------------------------------------------------------
*# 収容関数: commonChk       --- 画面共通チェック
*#         : byteChk()       --- バイト数チェック
*#         : checkByteCore() --- 処理された入力データのバイト数をチェックする
*#         : hanChk()        --- 半角項目入力チェック（入力値が半角文字のみかどうかのチェック,半角英数のみOK（半角カナNG））
*#         : nullChk()       --- Ｎｕｌｌチェック
*#         : numChk()        --- 半角数字項目入力チェック(半角数字のみかどうか)
*#         : integerChk()    --- Numericチェック (整数チェック(正数、負数、零))
*#         : amountChk()     --- Numericチェック (金額チェック（小数2桁まで）)
*#         : countChk()      --- Numericチェック (数量チェック（小数3桁まで))
*#         : dateChk()       --- 日付チェック
*#         : passChk()       --- パスワード項目入力チェック
*#         : sTelNumChk()    --- 電話番号項目入力チェック(半角)
*#         : sEmailChk()     --- E-mailアドレスチェック
*#         : sEmailArrayChk()--- E-mailアドレスチェック(グループ)
*################################################################################
*/



/**
 * 関数名称: バイト数チェック
 * @param :  String aEdit <I> チェック対象
 * @param :  String aLimit <I> バイト数
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果（True：正常 False：異常）
 */
function byteChk(aEdit, aLimit, aStr) {

    // チェック対象の入力データ
    var aEditValue = aEdit.val();
    aEditValue = aEditValue.replace(/\r\n/g, "  ");
    aEditValue = aEditValue.replace(/\r/g, "  ");
    aEditValue = aEditValue.replace(/\n/g, "  ");
    return checkByteCore(aEdit, aLimit, aEditValue, aStr);
}

/**
 * 関数名称: 処理された入力データのバイト数をチェックする
 * @param :  String aEdit <I> チェック対象
 * @param :  String aLimit <I> バイト数
 * @param :  String aStr <I> エラーメッセージ
 * @param :  String aEditValue <I> 処理されたチェック対象入力データ
 * @return : 処理結果（True：正常 False：異常）
 */
function checkByteCore(aEdit, aLimit, aEditValue, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    // バイト数カウンタ
    var byteCounter = 0;

    // チェック結果
    var chkRst = false;

    // バイト数を取得する
    byteCounter = getBytesCnt(aEditValue);
        if (byteCounter > aLimit) {
            chkRst = false;
        } else {
            chkRst = true;
        }


    // エラーメッセージ出力
    if (!chkRst) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return chkRst;
}

/**
 * 関数名称: 半角項目入力チェック （入力値が半角文字のみかどうかのチェック,半角英数のみOK（半角カナNG））
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：正常 False：異常）
 */
function hanChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    // チェック対象の入力データ
    var aEditValue = chkObj.val();

    // 半角英数のみOK（半角カナNG）
    //var pattern = /^[A-Za-z0-9]*$/;
    var pattern = /^[\u0000-\u00FF]*$/;
    var result = pattern.test(aEditValue);

    // 半角英数以外が含む場合、エラーメッセージ出力
    if (!result) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return result;
}

/**
 * 関数名称: Nullチェック (入力項目が空欄かどうかのチェック)
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：正常 False：異常）
 */
function nullChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    // チェック対象の入力データ(「スペースのみ」は空欄とみなします)
    var aEditValue = trim(chkObj.val());

    if ("" == aEditValue) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
        return false;
    }
    return true;
}

/**
 * 関数名称: Numericチェック  (半角数字(0~9)のみで構成されているか)
 * @param :  String aEdit <I> チェック対象
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果（True：半角数字のみ False：半角数字以外を含む）
 */
function numChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    var aEditValue = chkObj.val();

    // 半角数字(0~9)のみで構成されている
    var pattern = /^\d*$/;
    var result = pattern.test(aEditValue);

    if (!result) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return result;
}

/**
 * 関数名称: Numericチェック (整数チェック(正数、負数、零))
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：半角数字のみ False：半角数字以外を含む）
 */
function integerChk(aEdit, sMsg) {

    // 判定対象変数
  var chkObj = aEdit;

  var aEditValue = chkObj.val();

    var pattern = /^-?(\d+)?$/;
    var result = pattern.test(aEditValue);

    if (!result) {
      alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return result;
}

/**
 * 関数名称: Numericチェック (金額チェック（小数2桁まで）)
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：半角数字のみ False：半角数字以外を含む）
 */
function amountChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    var aEditValue = chkObj.val();

    var pattern = /^(-?\d+(\.\d{1,2})?)?$/;
    var result = pattern.test(aEditValue);

    if (!result) {
      alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return result;
}

/**
 * 関数名称: Numericチェック (数量チェック（小数3桁まで))
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：半角数字のみ False：半角数字以外を含む）
 */
function countChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    var aEditValue = chkObj.val();

    var pattern = /^(-?\d+(\.\d{1,3})?)?$/;
    var result = pattern.test(aEditValue);
    if (!result) {
      alert(sMsg);
        chkObj.focus();
        chkObj.select();
    }
    return result;
}

/**
 * 関数名称:  日付チェック (mm/dd/yyyyとして実在する日付かどうか)
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果
 *           True：正常
 *           False：異常
 */
function dateChk(aEdit, sMsg) {
    // 判定対象変数
    var chkObj = aEdit;

    // 入力データ
    var aEditValue = chkObj.val();

    // チェック結果
    var result;

    // 日付の正規表現 (yyyy/MM/dd)
    var patternDate = /^\d{2}\/\d{2}\/\d{4}$/;

    // フォーマット判断
    result = patternDate.test(aEditValue);
    if (result) {
        // 日付の有効性判断
        result = isValidDate(aEditValue);
    }

    if (!result) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
        return false;
    }
    return result;
}

/**
 * 関数名称:  日付チェック (mm/dd/yyyyとして実在する日付かどうか)
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果
 *           True：正常
 *           False：異常
 */
function dateChkForBack(chkObj) {
    // 判定対象変数
    if (chkObj.length <= 0) {
      return true;
    }
    // 入力データ
    var aEditValue = chkObj.val();

    // チェック結果
    var result;

    // 日付の正規表現 (yyyy/MM/dd)
    var patternDate = /^\d{2}\/\d{2}\/\d{4}$/;

    // フォーマット判断
    result = patternDate.test(aEditValue);
    if (result) {
        // 日付の有効性判断
        result = isValidDate(aEditValue);
    }

    if (!result) {
        chkObj.val("");
        return false;
    }
    return result;
}

/**
 * 関数名称: パスワード項目入力チェック (半角英数字混在のみかどうかのチェック)
 * @param :  String aEdit <I> チェック対象
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果 (True：正常 False：異常)
 */
function passChk(chkObj, sMsg) {
    // 入力データ
    var aEditValue = chkObj.val();

    // チェック結果
    var result = false;;

    var chkLength = chkObj.val().length;
    if (chkLength < 8) {
      alert(sMsg);
      chkObj.focus();
      chkObj.select();
      return false;
    }

    var patternHan = /^[\u0000-\u00FF]*$/;
    var patternNum = /^\d*$/;
    var patternAlpha = /^[A-Za-z]*$/;
    if (patternHan.test(aEditValue)) {
      if (!patternNum.test(aEditValue) && !patternAlpha.test(aEditValue)) {
        result = true;
      }
    }
    // 半角英数字のみかどうか、それに混在かどうかの正規表現
    // var patternPsw = /^([0-9A-Za-z]*(([0-9]+[A-Za-z]+)|([A-Za-z]+[0-9]+))[0-9A-Za-z]*)*$/;
    // result = patternPsw.test(aEditValue);
    if (!result) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
        return false;
    }
    return result;
}

/**
 * 関数名称: 電話番号項目入力チェック (0~9,「-」のみで構成されているか)
 * @param :  String aEdit <I> チェック対象
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果 (True：半角数字または"-"のみ False：半角数字または"-"以外)
 */
function sTelNumChk(aEdit, sMsg) {

    // 判定対象変数
    var chkObj = aEdit;

    // 入力データ
    var aEditValue = chkObj.val();

    // チェック結果
    var result;

    // 0-9、-のみかどうかの正規表現
    var patternTel = /^[0-9-\s/]*$/;

    result = patternTel.test(aEditValue);
    if (!result) {
      alert(sMsg);
        chkObj.focus();
        chkObj.select();
        return false;
    }
    return result;
}

/**
 * 関数名称:  E-mailアドレスチェック
 * @param :  String aEditValue <I> チェック対象
 * @return : 処理結果
 *           True： 入力値が設定されていない。
 *                 または、半角英数字、"."、"-"、"_"、"@"のみ存在する。
 *           False：半角英数字"."、"-"、"_"、"@"以外が存在する。
 *                 または、"."、"@"が先頭/末尾に存在する。
 *                 または、"."がアカウント部分またはドメイン部分の先頭/末尾に存在する。
 *                 または、".."存在する場合。
 *                 または、"@"が2つ以上存在するまたは一つもない。
 *                 または、"."が1つもない。
 */
function sEmailChkInner(aEditValue) {
	if (aEditValue == '') {
		return true;
	}

    // チェック結果
    var result;

    var addr;    // アカウント部分
    var domain;  // ドメイン部分
    var idxMark; //アットマーク(@)の位置
    var dotFlg = false;
    var startStrA,endStrA,startStrD,endStrD;

    // 0-9、-のみかどうかの正規表現
    var patternEMail = /^([0-9A-Za-z-_.]+[@]{1}[0-9A-Za-z-_.]+){1}$/;
    result = patternEMail.test(aEditValue);

    // 追加チェック
    if(result) {
        // "."が一つもない
        if (aEditValue.indexOf(".") == -1) {
            result = false;
        }

        // ".."存在する場合
        if (aEditValue.indexOf("..") != -1) {
            result = false;
        }

        // "."がアカウント部分またはドメイン部分の先頭/末尾に存在する
        if (result) {
            addr = aEditValue.substring(0,aEditValue.indexOf("@"));
            startStrA = addr.substring(0,1);
            endStrA = addr.substring(addr.length-1,addr.length);
            domain = aEditValue.substring(aEditValue.indexOf("@")+1,aEditValue.length);
            startStrD = domain.substring(0,1);
            endStrD = domain.substring(domain.length-1,domain.length);
            if ("." == startStrA || "." == endStrA || "." == startStrD || "." == endStrD ) {
                result = false;
            }
        }
    }

    return result;
}

/**
 * 関数名称:  E-mailアドレスチェック
 * @param :  String aEdit <I> チェック対象
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果
 *           True： 入力値が設定されていない。
 *                 または、半角英数字、"."、"-"、"_"、"@"のみ存在する。
 *           False：半角英数字"."、"-"、"_"、"@"以外が存在する。
 *                 または、"."、"@"が先頭/末尾に存在する。
 *                 または、"."がアカウント部分またはドメイン部分の先頭/末尾に存在する。
 *                 または、".."存在する場合。
 *                 または、"@"が2つ以上存在するまたは一つもない。
 *                 または、"."が1つもない。
 */
function sEmailChk(aEdit, sMsg) {
     // 判定対象変数
    var chkObj = aEdit;

    // 入力データ
    var aEditValue = chkObj.val();
    aEditValue = aEditValue.replace(/,/g, ";");
    var valueArray = aEditValue.split(";");

    // チェック結果
    var result = false;
    var emptyEmail = true;
    $.each(valueArray, function (n, value)
            {
        	if (trim(value) == '') {
				return true;
			} else {
				emptyEmail = false;
			}
            result = sEmailChkInner(trim(value));
            if(!result){
                return false;
            }
    });

    if (!result || emptyEmail) {
        alert(sMsg);
        chkObj.focus();
        chkObj.select();
        return false;
    }
    return result;
}

/**
 * 関数名称:  日付有効性判断
 * @param :  String aEdit <I> チェック対象
 * @param :  String aStr <I> エラーメッセージ
 * @return : 処理結果
 *           True：有効な日付文字列
 *           False：無効な日付文字列
 */
function isValidDate(strDate) {

    var year,month,day;
    year = strDate.substring(6, 10);
    month = strDate.substring(0, 2);
    day = strDate.substring(3, 5);

    // 有効年月日は(0001/01/01 ~ 9999/12/31)
    if (year < 1 || year > 9999) {
        return false;
    } else if (month < 1 || month > 12) {
        return false;
    } else {

        // 4,6,9,11月は30日
        if ((month == 4 || month == 6 || month == 9 || month == 11)
                && (day<1 || day>30)) {
            return false;

        } else if (month == 2) {
            // 平年は28日、閏年は29日
            if (((year % 4 == 0)  &&  (year % 100 != 0)) || (year % 400 == 0)) {
                if (day<1 || day>29) {
                    return false;
                }
            } else {
                if (day<1 || day>28) {
                    return false;
                }
            }
        } else {
            // 1,3,5,7,8,10,12月は31日
            if (day<1 || day>31) {
                return false;
            }
        }
    }
    return true;
}


/**
 * 関数概要：文字列のバイト数を取得する（半角カタカナは1バイトとする）
 * @param String inStr <I> 計算文字列
 * @return 文字列のバイト数
 */
function getBytesCnt(inStr) {
	if (inStr == undefined) { return 0; }
    return inStr.replace(/[^\x00-\xff\uff61-\uff9f]/g, "***").length;
}

/**
 * 関数概要：文字列の左右側のスペースを切る
 * @param  String inStr <I> 計算文字列
 * @return 処理した文字列
 */
function trim(inStr){
	if (inStr == undefined) { return ""; }
    return inStr.replace(/^[\s\u3000\t]*|[\s\u3000\t]*$/g,"");
}

/**
 * 関数概要：文字列の左側のスペースを切る
 * @param  String inStr <I> 計算文字列
 * @return 処理した文字列
 */
function ltrim(inStr){
	if (inStr == undefined) { return ""; }
    return inStr.replace(/^[\s\u3000\t]*/g,"");
}

/**
 * 関数概要：文字列の右側のスペースを切る
 * @param  String inStr <I> 計算文字列
 * @return 処理した文字列
 */
function rtrim(inStr){
	if (inStr == undefined) { return ""; }
    return inStr.replace(/[\s\u3000\t]*$/g,"");
}

/**
 * 関数名称: 英字チェック
 * @param :  String aEdit <I> チェック対象
 * @return : 処理結果（True：英字 False：英字以外を含む）
 */
function alphaChk(aEdit) {
    if (aEdit.length <= 0) {
	     return true;
	}
    // 判定対象変数
    var chkObj = aEdit;

    var aEditValue = chkObj.val();
    if (trim(aEditValue) == "") {
    	return false;
    }
    var pattern = /[A-Za-z]+/;
    return pattern.test(aEditValue);
}
