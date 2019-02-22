<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<script type="text/javascript" src="js/j.js"></script>
<script type="text/javascript" src="js/jqueryui/jquery.ui.resizable.js"></script>
<div class="addVote">
    <h2>发布新投票</h2>
    <div class="vote-content">
        <form method="post" action="subject!save.action" onsubmit="return validate();">
            <dl>
                <dt>投票内容：</dt>
                <dd>
                    <input id="voteTitle" type="text" class="input-text" name="subject.title" value="" title="填入投票内容"/>
                </dd>
                <dt>投票类型：</dt>
                <dd>
                    <input type="radio" name="subject.type" value="1" checked=checked/>单选
                    <input type="radio" name="subject.type" value="2"/>多选
                </dd>
                <dt>投票选项：</dt>
                <dd id="voteoptions">
                    <p><input type="text" class="input-text" name="options"/></p>
                    <p><input type="text" class="input-text" name="options"/></p>
                </dd>
                <dt></dt>
                <dd class="button">
                    <input type="image" src="images/button_submit.gif"/>
                    <a id="addOption" href="javascript:void(0);">增加选项</a>
                    <a href="subject!list.action">取消操作</a>
                </dd>
            </dl>
        </form>
    </div>
</div>
<div id="dialog-message" title="警告" style="height:80px;width:130px;display:none">
    <p>投票内容不能为空</p>
</div>
<script>
    $("#voteTitle").blur(function () {
        var v = $(this).val();
        validateTitle(v);
    });
    $("#addOption").click(function () {
        var $p = $('<p></p>');
        var $text = $('<input type="text" class="input-text" name="options" />');
        var $del = $('<input type="button" value="删除"/>');
        $del.click(function () {
            $(this).parent().remove();
        });
        $p.append($text).append($del);
        $("#voteoptions").append($p);
    });

    function validate() {
        var voteTitle = $('#voteTitle').val();

        return validateTitle(voteTitle);

    }

    function validateTitle(v) {
        if (null == v || '' == v) {
            $("#dialog-message").dialog({
                modal: true,
                buttons: {
                    Ok: function () {
                        $(this).dialog("close");
                    }
                }
            });
            return false;
        }
        return true;
    }
</script>
