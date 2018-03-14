<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>异步加载树</title>
    <link rel="stylesheet" href="${ctx}/ztree/css/zTreeStyle.css">
    <script type="text/javascript" src="${ctx}/ztree/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="${ctx}/ztree/js/jquery.ztree.all.min.js"></script>
    <script type="text/javascript">
        var setting = {
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
            async: {
                enable: true,
                url: "http://localhost:8080/webdemo/getTree.shtml",
                autoParam: ["id"]
            },
            // 回调函数
            callback : {
                onClick : function(event, treeId, treeNode, clickFlag) {
                    // 判断是否父节点
                    if(!treeNode.isParent){
                        alert("treeId自动编号：" + treeNode.tId + ", 节点id是：" + treeNode.id + ", 节点文本是：" + treeNode.name);
                    }
                }
            }
        };

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo"), setting);
        });
    </script>
</head>
<body>
<div>
    <ul id="treeDemo" class="ztree"></ul>
    <hr/>
</div>
</body>

</html>
