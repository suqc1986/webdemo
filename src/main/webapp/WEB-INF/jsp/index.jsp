<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<%@ include file="/WEB-INF/jsp/include/head.jsp" %>
<head>
    <title>测试页面</title>
    <script type="text/javascript" src="${ctx}/js/jQuery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function changeLocal(lang){
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "${ctx}/setLocal.shtml",
                data: {"lang":lang},
                success: function(result) {
                    location.reload();
                }
            });
        }
    </script>
</head>
<body>
index.shtml
<hr/>
<a href="javascript://;" onclick="changeLocal('zh_CN');"><spring:message code="language.cn"/></a> &nbsp;&nbsp;&nbsp;
<a href="javascript://;" onclick="changeLocal('zh_CN');"><spring:message code="language.tw"/></a> &nbsp;&nbsp;&nbsp;
<a href="javascript://;" onclick="changeLocal('en_US');"><spring:message code="language.en"/></a>
</body>
</html>
