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
    <title>Resume Info</title>
    <link rel="stylesheet" href="${appPath}/css/resume.css"/>
    <script type="text/javascript" src="js/index.js" ></script>

</head>

<body>
<div class="_resume">
    <div class="_headpic">
        <c:if test="${resume.headShot==null}">
            <img class="headShot" src="${appPath}/images/applicant/1.jpg"  />
        </c:if>
        <c:if test="${resume.headShot!=null}">
            <img class="headShot" src="${appPath}/images/applicant/${resume.headShot}"/>
        </c:if>
    </div>
    <div class="fun_bt">
        <a href="${appPath}/applicant/resumeUpdate.jsp">
            修改
       &nbsp;</a>&nbsp;&nbsp;
        <a href="${appPath}/applicant/applicantIndex.jsp">
            功能列表
        </a>
    </div>
    <div class="resume_info" align="center">
    <table class="resume_tb"  cellpadding="10px" cellspacing="10px" >
        <tr>
            <td>姓名:</td>
            <td><input type="text" height="10px"  value="${resume.realName}" disabled/></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="text" value="${resume.gender}" disabled/></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text"  value="${resume.age}" disabled/></td>
        </tr>
        <tr>
            <td>手机:</td>
            <td><input type="text" value="${resume.telephone}" disabled/></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" value="${resume.email}" disabled/></td>
        </tr>
        <tr>
            <td>求职意向:</td>
            <td><input type="text" value="${resume.jobIntension}" disabled/></td>
        </tr>
        <tr>
            <td>工作经验:</td>
            <td><input type="text" value="${resume.jobExperience}" disabled/></td>
        </tr>
    </table>
    </div>
</div>

</body>

</html>