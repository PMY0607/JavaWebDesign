<%@ page import="org.pmy.bean.Job" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.pmy.Dao.JobDao" %>
<%@ page import="org.pmy.bean.Company" %>
<%@ page import="org.pmy.Dao.PageBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/app.jsp"%>
<html>

<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Company Info</title>

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
    <title>Company Info</title>
    <link rel="stylesheet" href="${appPath}/css/companyInfo.css" />

</head>

<body>

<div class="company">

    <div class="container">

    <div class="company_info">
        <h1 class="company_name">${company.companyName}</h1>
        <div class="headpic">
            <c:if test="${company.companyPic==null}">
                <img width="100px" src="${appPath}/images/company/1.jpg"/>
            </c:if>
            <c:if test="${company.companyPic!=null}">
                <img width="100px" src="${appPath}/images/company/${company.companyPic}"/>
            </c:if>
        </div>
        <div class="fun_bt">
                <a  href="${appPath}/company/companyUpdate.jsp">
                    修改
                </a >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="${appPath}/company/companyIndex.jsp">
                    功能列表
                </a>
        </div>

        <table class="company_info_tb table table-bordered table-hover" cellpadding="20px" cellspacing="10px">
            <tr>
                <td><span>公司类型</span>&nbsp;&nbsp;&nbsp;
                    <input type="text" value="${company.companyType}" disabled/></td>
                <td><span>公司地址</span>&nbsp;&nbsp;&nbsp;
                    <input type="text" value="${company.companyAddress}" disabled/></td>
            </tr>
            <tr>
                <td><span>公司大小</span>&nbsp;&nbsp;&nbsp;
                    <input type="text" value="${company.companyViewnum}" disabled/></td>
                <td><span>公司规模</span>&nbsp;&nbsp;&nbsp;
                    <input type="text" value="${company.companySize}" disabled/></td>
            </tr>
            <tr>
                <td colspan="2"><span style="vertical-align:top;">公司简介</span>&nbsp;&nbsp;&nbsp;
                    <textarea class="brief"  disabled>${company.companyBrief}</textarea></td>
            </tr>
        </table>
    </div>

        <h3 style="text-align: center">公司岗位信息列表</h3>
        <table border="1" class="table table-bordered table-hover">
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
                    <td>
                        ${job.jobState}
                    </td>
                    <td>
                        <a class="btn btn-default btn-sm" href="${appPath}/company/jobUpdate.jsp?index=${state.index}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="${appPath}/upDateJobServlet?index=${state.index}&method=delete">删除</a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="8" align="center"><a class="btn btn-primary" href="${appPath}/company/jobAdd.jsp">添加岗位</a></td>
            </tr>
        </table>

    </div>

</div>
</body>

</html>
