<%--
  Created by IntelliJ IDEA.
  User: PMY
  Date: 2020/12/29
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../app.jsp" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Resume Info</title>
    <link rel="stylesheet" href="${appPath}/css/resume.css"/>
    <script type="text/javascript" src="js/index.js" ></script>

</head>

<body>
    <form action="${appPath}/updateResumeServlet" method="post" enctype="multipart/form-data">
    <div class="_resume">
        <div class="_headpic">
            <c:if test="${resume.headShot==null}">
            <img class="headShot" src="${appPath}/images/applicant/1.jpg"  /><br>
            </c:if>
            <c:if test="${resume.headShot!=null}">
                <img class="headShot" src="${appPath}/images/applicant/${resume.headShot}"  /><br>
            </c:if>
            <input type="file" name="headShot" accept="image/*" placeholder="请选择头像">
        </div>
        <div class="fun_bt">
            <input type="submit" value="保存">&nbsp;&nbsp;
            <a href="${appPath}/applicant/resume.jsp">
                取消
            </a>
        </div>
        <div class="resume_info" align="center">
        <table class="resume_tb"  cellpadding="10px" cellspacing="10px" >
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="realName" height="10px"  value="${resume.realName}" required /></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <c:if test="${resume.gender.equals('男')||resume.gender==null}">
                       男: <input type="radio" name="gender" value="男" checked>
                       女：<input type="radio" name="gender" value="女" >
                    </c:if>
                    <c:if test="${resume.gender.equals('女')}">
                        男: <input type="radio" name="gender" value="男" >
                        女：<input type="radio" name="gender" value="女" checked>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age" value="${resume.age}" required/></td>
            </tr>
            <tr>
                <td>手机:</td>
                <td><input type="text" name="telephone" value="${resume.telephone}" required /></td>
            </tr>
            <tr>
                <td>邮件:</td>
                <td><input type="text" name="email" value="${resume.email}" required/></td>
            </tr>
            <tr>
                <td>求职意向:</td>
                <td><input type="text" name="jobIntension" value="${resume.jobIntension}" required/></td>
            </tr>
            <tr>
                <td>工作经验:</td>
                <td><input type="text" name="jobExperience" value="${resume.jobExperience}" required/></td>
            </tr>
        </table>
        </div>
    </div>
</form>
</body>

</html>