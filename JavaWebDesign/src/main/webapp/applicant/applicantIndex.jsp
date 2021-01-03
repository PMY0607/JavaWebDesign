<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/app.jsp"%>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<style type="text/css">
    .index {
        width: 770px;
        height: 100px;
        margin-top: auto;
        margin-bottom: auto;
        margin-left: auto;
        margin-right: auto;
        align-content: center;
    }
    a{
        text-decoration: none;
        font-size: 37px;
    }
</style>

<body>
<div class="index">
    <h1>您好！${applicant.applicantEmail}</h1>
    <table cellpadding="10px" cellspacing="10px">
        <tr>
            <td>
                <a href="${appPath}/applicant/resume.jsp">个人信息</a>
            </td>
            <td>
                <a href="${appPath}/displayJobServlet">岗位应聘</a>
            </td>
            <td>
                <a href="${appPath}/applicant/colletList.jsp">收藏夹</a>
            </td>
            <td>
                <a href="${appPath}/logOutServlete">退出登录</a>
            </td>
            <%--
            <td>
            <a href="${appPath}/login.jsp" onclick="function logOut() {
                <%
                     request.getSession().invalidate();
                    %>
                    }">退出登录</a>
            </td>--%>
        </tr>
    </table>
</div>
</body>

</html>