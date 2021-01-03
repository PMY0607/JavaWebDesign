<%@ page import="org.pmy.bean.Resume" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.pmy.Dao.CompanyDAO" %>
<%@ page import="org.pmy.Dao.JobDao" %>
<%@ page import="org.pmy.bean.Company" %>
<%@ page import="org.pmy.bean.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="org.pmy.Dao.ResumeDAO" %>
<%@ page import="org.pmy.bean.Invate" %><%--
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
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Resume Info</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${appPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${appPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${appPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>

<%
    int applicantId = Integer.valueOf(request.getParameter("applicantId"));

    ResumeDAO dao = new ResumeDAO();
    Resume resume = dao.getResumeByApplicantId(applicantId);

    request.getSession().setAttribute("resume",resume);
    request.getSession().setAttribute("applicantId",applicantId);
%>

<body>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">简历信息</h3>
    <form action="${appPath}/resumeOpServlet?applicantId=${applicantId}&method=invate" method="post" >

        <div class="form-group">
            <label for="realname">姓名</label>
            <input type="text" class="form-control" id="realname" name="realname" value="${resume.realName}"  disabled   />
        </div>
        <div class="form-group">
            <label for="gender">性别</label>
            <input type="text" class="form-control" id="gender" name="gender"  value="${resume.gender}" disabled  />
        </div>

        <div class="form-group">
            <label for="age">年龄</label>
            <input type="text" class="form-control" id="age" name="age"  value="${resume.age}" disabled  />
        </div>

        <div class="form-group">
            <label for="telphone">手机</label>
            <input type="text" class="form-control" id="telphone"  name="telphone" value="${resume.telephone}"   disabled  />
        </div>

        <div class="form-group">
            <label for="email">邮箱</label>
            <input type="text" class="form-control" id="email"  name="email" value="${resume.email}"   disabled  />
        </div>
        <div class="form-group">
            <label for="jobintension">求职意向</label>
            <input type="text" class="form-control" id="jobintension"  name="jobintension"  value="${resume.jobIntension}"  disabled  />
        </div>
        <div class="form-group">
            <label for="jobexper">工作经验</label>
            <input type="text" class="form-control" id="jobexper"  name="jobexper"  value="${resume.jobExperience}"  disabled  />
        </div>


        <div class="form-group" style="text-align: center">

            <input class="btn btn-default" type="button" onclick="window.location.href='${appPath}/company/applyManager.jsp'"  value="返回"/>
        </div>
    </form>
</div>

</body>

</html>