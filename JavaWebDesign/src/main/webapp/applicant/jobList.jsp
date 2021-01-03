<%@ page import="org.pmy.bean.Company" %>
<%@ page import="sun.security.pkcs11.Secmod" %>
<%@ page import="org.pmy.utils.DBUtils" %>
<%@ page import="org.pmy.Dao.JobDao" %>
<%@ page import="org.pmy.bean.Job" %>
<%@ page import="java.util.List" %>
<%@ page import="org.pmy.bean.Collect" %>
<%@ page import="org.pmy.bean.Applicant" %>
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
    <title>岗位查询界面</title>

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
    Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
    List<Collect> collectlist = new JobDao().getCollectJob(applicant.getApplicantId());
    request.getSession().setAttribute("collectlist",collectlist);
%>

<div class="container">
    <h3 style="text-align: center">岗位信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr>
            <td style="text-align: right" colspan="7"><a class="btn btn-primary" href="${appPath}/applicant/applicantIndex.jsp">返回主页</a></td>
        </tr>
        <tr class="success">
            <th>编号</th>
            <th>岗位名称</th>
            <th>工作地点</th>
            <th>薪资</th>
            <th>招聘人数</th>
            <th>招聘状态</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${joblist}" var="job" varStatus="state"  >
            <tr>
                <td>${state.count}</td>
                <td>${job.jobName}</td>
                <td>${job.jobAddress}</td>
                <td>${job.salary}</td>
                <td>${job.jobHiringNum}</td>
                <td>${job.jobState}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${appPath}/applicant/jobInfo.jsp?index=${state.index}">查看</a>&nbsp;

                    <c:if test="${job.apply==0||job.apply==null}">
                        <a class="btn btn-default btn-sm" href="${appPath}/jobOpServlet?index=${state.index}&method=putR">投递简历</a>
                    </c:if>
                    <c:if test="${job.apply==1}">
                        <a class="btn btn-default btn-sm" href="${appPath}/jobOpServlet?index=${state.index}&method=delR">取消投递</a>
                    </c:if>

                    <c:if test="${job.collect==0||job.collect==null}">
                        <a class="btn btn-default btn-sm" href="${appPath}/jobOpServlet?index=${state.index}&method=addcollect">收藏</a>
                    </c:if>
                    <c:if test="${job.collect==1}">
                        <a class="btn btn-default btn-sm" href="${appPath}/jobOpServlet?index=${state.index}&method=deletecollect">取消收藏</a>
                    </c:if>


                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
