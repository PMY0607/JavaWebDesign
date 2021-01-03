<%@ page import="org.pmy.bean.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/app.jsp"%>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改公司</title>

    <link href="${appPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${appPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${appPath}/js/bootstrap.min.js"></script>

</head>
<body>
<%
    Company company = (Company) request.getSession().getAttribute("company");
%>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改公司信息</h3>
    <form action="${appPath}/updateCompanyInfoServlet" method="post" name="upload" enctype="multipart/form-data">

        <div class="form-group">
            <label for="companyPic">公司图片</label>
            <c:if test="${company.companyPic==null}">
                <img width="100px" src="${appPath}/images/company/1.jpg"/>
            </c:if>
            <c:if test="${company.companyPic!=null}">
                <img width="100px" src="${appPath}/images/company/${company.companyPic}"/>
            </c:if>

            <input type="file" class="form-control" id="companyPic" name="companyPic"  placeholder="请选择公司头像" />
        </div>

        <div class="form-group">
            <label for="name">公司名称</label>
            <input type="text" class="form-control" id="name" name="name" value="${company.companyName}"  required  placeholder="请输入公司名称" />
        </div>
        <div class="form-group">
            <label for="type">公司类型</label>
            <input type="text" class="form-control" id="type" name="type" value="${company.companyType}"  required  placeholder="请输入公司类型" />
        </div>

        <div class="form-group">
            <label for="address">公司地址</label>
            <input type="text" class="form-control" id="address" name="address" value="${company.companyAddress}" required placeholder="请输入公司地址" />
        </div>

        <div class="form-group">
            <label for="viewnum">公司大小</label>
            <input type="text" class="form-control" id="viewnum"  name="viewnum" value="${company.companyViewnum}" required placeholder="请输入公司大小" />
        </div>

        <div class="form-group">
            <label for="size">规模</label>
            <select name="size" id="size" class="form-control" >
                <c:if test='${company.companySize.equals("小型企业")}'>
                    <option value="小型企业" selected>小型企业</option>
                    <option value="中型企业">中型企业</option>
                    <option value="大型企业">大型企业</option>
                </c:if>
                <c:if test='${company.companySize.equals("中型企业")}'>
                    <option value="小型企业" >小型企业</option>
                    <option value="中型企业" selected>中型企业</option>
                    <option value="大型企业">大型企业</option>
                </c:if>
                <c:if test='${company.companySize.equals("大型企业")}'>
                    <option value="小型企业" >小型企业</option>
                    <option value="中型企业">中型企业</option>
                    <option value="大型企业" selected>大型企业</option>
                </c:if>
                <c:if test='<%=company.getCompanySize()==null||company.getCompanySize().length()==0%>'>
                    <option value="小型企业" selected>小型企业</option>
                    <option value="中型企业">中型企业</option>
                    <option value="大型企业">大型企业</option>
                </c:if>
            </select>
        </div>

        <div class="form-group">
            <label for="brief">公司简介</label>
            <textarea class="form-control" id="brief" name="brief" placeholder="请输入公司简介">${company.companyBrief}</textarea>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit"  value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="window.location.href='companyInfo.jsp'"  value="返回"/>
        </div>
    </form>
</div>


</body>
</html>