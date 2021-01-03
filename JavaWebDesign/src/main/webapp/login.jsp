<%--
  Created by IntelliJ IDEA.
  User: PMY
  Date: 2020/12/28
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login frame</title>
    <script type="text/javascript" src="js/index.js" ></script>
    <link rel="stylesheet" href="css/index.css" />
    <script crossorigin="anonymous" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>


</head>
<body>

<div class="index_frame" >
    <div class="tb_div">
        <form class="form" action="loginServlet"  method="post">
            <table class="tb_login" align="center" cellpadding="10px" cellspacing="2px">
                <tr>
                    <td style="font-size: 27px" align="center">用户名:</td>
                    <td >
                       <%-- <c:if test="${requestScope.email!=null}">
                            <input type="text" id="login_email" name="email" placeholder="Email" value="${email}" required autofocus />
                        </c:if>
                        <c:if test="${requestScope.email==null}">
                            <input type="text" id="login_email" name="email" placeholder="Email" required autofocus />
                        </c:if>--%>
                           <input type="text" id="login_email" name="email" placeholder="Email" value="${email}" required autofocus />
                    </td>
                    <td>
                         <span id="msg">${msg}</span>
                    </td>
                </tr>
                <tr>
                    <td style="font-size: 27px" align="center">密码:</td>
                    <td><input type="password" id="login_pwd" name="pwd" placeholder="密码" required  /></td>
                </tr>
                <tr>
                    <td style="size: 10px" align="center" colspan="2">
                        账号类型:
                        <c:if test="${chose.equals('applicant')||chose==null}">
                        求职者<input type="radio" name="chose" value="applicant" checked/>
                        公司<input type="radio" name="chose" value="company"/>
                        </c:if>
                        <c:if test="${chose.equals('company')}">
                            求职者<input type="radio" name="chose" value="applicant" />
                            公司<input type="radio" name="chose" value="company" checked/>
                        </c:if>
                    </td>
                </tr>
                <tr align="center">
                    <td><input type="submit" href="applicantLoginServlet" name="bt_login" value="登录" /></td>
                    <td><input type="button" onclick="jumpRegist()"  name="bt_regist" value="注册" /></td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script type="text/javascript">
    //失去焦点
    $(function () {
        $("#login_email").blur(function () {
            var value = $("#login_email").val();
            var chose = $('input:radio:checked').val();
            // 使用ajax发送请求
            $.ajax({
                //url，写要访问的地址，这里访问的是servlet映射地址
                url: "loginAjaxServlet",
                cache: false,  // 是否缓存
                //参数  相当于地址栏后面的参数
                data: "email=" + value+"&"+"chose="+chose,
                //请求类型
                type: 'POST',
                timeout: 2000,
                //成功的回调   问成功后，执行的方法，参数是后台的结果
                success: function (result) {
                    // 将获取到的数据写入span标签
                    $("#msg").text(result);
                }

            })
        })
    })

</script>

</body>
</html>