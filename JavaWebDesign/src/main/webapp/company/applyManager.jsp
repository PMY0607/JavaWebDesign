<%@ page import="sun.security.pkcs11.Secmod" %>
<%@ page import="org.pmy.utils.DBUtils" %>
<%@ page import="org.pmy.Dao.JobDao" %>
<%@ page import="java.util.List" %>
<%@ page import="org.pmy.Dao.CompanyDAO" %>
<%@ page import="org.pmy.Dao.ApplicantDAO" %>
<%@ page import="org.pmy.bean.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.pmy.Dao.ResumeDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/app.jsp"%>
<html lang="zh-CN">
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
    <title>求职者列表</title>

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
<body>
<%
    Company company = (Company) request.getSession().getAttribute("company");
    CompanyDAO dao = new CompanyDAO();
    List<Resume> resumelist = dao.getResumeList();
    List<Invate> invatelist = dao.getInvateList();

    List<JobApply> applylist = dao.getApplyResumeByCompanyId(company.getCompanyId());
    for (JobApply apply :applylist){
        apply.setResume(new ResumeDAO().getResumeByApplicantId(apply.getApplicantId()));
    }

    request.getSession().setAttribute("applylist",applylist);
%>
<div class="container">
    <h3 style="text-align: center">岗位申请信息</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr>
            <td style="text-align: right" colspan="8"><a class="btn btn-primary" href="${appPath}/company/companyIndex.jsp">返回主页</a></td>
        </tr>
        <tr class="success">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>求职意向</th>
            <th>工作经验</th>
            <th>求职岗位</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${applylist}" var="apply" varStatus="state"  >
            <tr>
                <td>${state.count}</td>
                <td>${apply.resume.realName}</td>
                <td>${apply.resume.gender}</td>
                <td>${apply.resume.age}</td>
                <td>${apply.resume.jobIntension}</td>
                <td>${apply.resume.jobExperience}</td>
                <td>${apply.jobName}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${appPath}/company/applyResume.jsp?applicantId=${apply.resume.applicantId}">查看</a>
                    <a class="btn btn-default btn-sm" href="${appPath}/applyOpServlet?applyId=${apply.applyId}&method=pass">通过</a>
                    <a class="btn btn-default btn-sm" href="${appPath}/applyOpServlet?applyId=${apply.applyId}&method=refuse">拒绝</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
