<%--
  Created by IntelliJ IDEA.
  User: PMY
  Date: 2020/12/28
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>regist frame</title>
    <script type="text/javascript" src="js/index.js" ></script>
    <link rel="stylesheet" href="css/index.css" />
    <script crossorigin="anonymous" src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript">
        //失去焦点
        $(function () {
            $("#email").blur(function () {
                var value = $("#email").val();
                var chose = $('input:radio:checked').val();
                // 使用ajax发送请求
                $.ajax({
                    //url，写要访问的地址，这里访问的是servlet映射地址
                    url: "registAjaxServlet?",
                    cache: false,  // 是否缓存
                    //参数  相当于地址栏后面的参数
                    data: "email=" + value+"&"+"chose="+chose,

                    //请求类型
                    type: 'POST',
                    timeout: 2000,
                    //成功的回调   问成功后，执行的方法，参数是后台的结果
                    success: function (result) {
                        // 将获取到的数据写入span标签
                        $("#email_msg").text(result);
                    }

                })
            })
        })

        function validate() {
            var email = document.getElementById("email").value;
            var password = document.getElementById("password").value;

            //验证邮箱合法性
            var pattern = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
            if (email == '') {
                alert("email不能为空！");
                return false;
            } else if (!pattern.test(email)) {
                alert("email格式不正确！");
                return false;
            }

            //验证password
            if (password == '') {
                alert("password不能为空！");
                return false;
            } else if (password.length < 6 && password.length > 12) {
                alert("密码长度在6-8个字符之间");
                return false;
            }

            return true;
        }
    </script>

</head>
<body>

<div class="index_frame" >
    <div class="tb_div">
        <form class="form" action="registServlet" method="post">
            <table class="tb_regist" align="center" cellpadding="10px" cellspacing="2px">
                <tr>
                    <td style="font-size: 27px" align="center">用户名:</td>
                    <td><input type="text" id="email" name="email" placeholder="Email" required autofocus /></td>
                    <td>
                        <span id="email_msg"></span>
                    </td>
                </tr>
                <tr>
                    <td style="font-size: 27px" align="center">密码:</td>
                    <td><input type="password" id="pwd" name="pwd" placeholder="密码" required  /></td>
                </tr>
                <tr>
                    <td style="font-size: 27px" align="center">确认密码:</td>
                    <td><input type="password" id="pwdcfr" name="pwdcfr" placeholder="确认密码" required  /></td>
                    <td>
                        <span id="pwdcfr_msg"></span>
                    </td>
                </tr>
                <tr>
                    <td style="size: 10px" align="center" colspan="2">
                        账号类型:
                        求职者<input type="radio" name="chose" value="applicant" checked/>
                        公司<input type="radio" name="chose" value="company"/>
                    </td>
                </tr>
                <tr align="center">
                    <td><input type="submit" name="bt_login" value="注册" /></td>
                    <td><input type="button" onclick="jumpLogin()"  name="bt_regist" value="登录" /></td>
                </tr>
            </table>
        </form>
        <span style="text-align: center;color: red">
            ${msg}
        </span>
    </div>
</div>

</body>
</html>
