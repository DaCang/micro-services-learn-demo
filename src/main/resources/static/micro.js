/**
 * rest风格根据主键查找数据 v1.0
 * @param formId 表单Id
 * @param url
 */
function queryByKey(formId,url) {
    var form = document.getElementById(formId);
    var keyValue =operKeyValue(form);
   /* if(keyValue==''){
        document.getElementById("msg").setAttribute("value","主键不存在");
        return false;
    }*/
    form.action =url+keyValue;
    form.method = "POST";
    form.submit();
}

/**
 * 表单的主键值
 * @param form
 */
function operKeyValue(form) {
    var key = form.getAttribute("key");
    var elementById = document.getElementById(key);
    return elementById.value;
}