<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>参与投票</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="top.jsp"/>
<div id="vote" class="wrap">
    <h2>参与投票</h2>
    <ul class="list">
        <li>
            <h4></h4>
            <p class="info">共有 个选项，已有 个网友参与了投票。</p>
            <form method="post" action="#" onsubmit="return validate();">
                <ol>
                    <li><input <%--<s:if test="subject.type==2">--%>type="checkbox"
                               <%--</s:if><s:else>--%>type="radio"<%--</s:else>--%> name="options"
                               value="<%--<s:property value='id'/>--%>"/><%--<s:property value="name"/>--%></li>
                </ol>
                <p class="voteView">
                    <button>投票</button>
                    <a href="#">查看</a>
                </p>
            </form>
        </li>
    </ul>
</div>
<div id="footer" class="wrap">
    百知 &copy; 版权所有
</div>
<link type="text/css" rel="stylesheet" href="js/jqueryui/themes/base/jquery-ui.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jqueryui/jquery-ui.js"></script>
<script>
    $(function () {
        $(".voteView").children("button").button({
            icons: {
                primary: "ui-icon-locked"
            }
        }).next().button({
            icons: {
                primary: "ui-icon-locked"
            }
        });
    })

    function validate() {
        var options = $("input[name='options']:checked").val();
        if (options == null || options == "undefined" || options.length == 0) {
            alert("请至少选择一个投票项！");
            return false;
        }
        return true;
    }
</script>
</body>
</html>
