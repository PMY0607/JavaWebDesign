<%@ page import="java.util.ArrayList" %>
<%@ page import="org.pmy.bean.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/app.jsp"%>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>添加岗位</title>

    <link href="${appPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${appPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${appPath}/js/bootstrap.min.js"></script>


</head>
<body>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">添加岗位</h3>
    <form action="${appPath}/upDateJobServlet?method=add" method="post" name="upload" >

        <div class="form-group">
            <label for="jobname">岗位名称</label>
            <input type="text" class="form-control" id="jobname" name="jobname"   required   />
        </div>
        <div class="form-group">
            <label for="jobadd">工作地点</label>
            <input type="text" class="form-control" id="jobadd" name="jobadd" required  />
        </div>

        <div class="form-group">
            <label for="salary">薪资</label>
            <input type="text" class="form-control" id="salary" name="salary"  required   />
        </div>

        <div class="form-group">
            <label for="hiringnum">招聘人数</label>
            <input type="text" class="form-control" id="hiringnum"   name="hiringnum" required   />
        </div>

        <div class="form-group">
            <label for="jobstate">招聘状态</label>
            <input type="text" class="form-control" id="jobstate"  name="jobstate" required   />
        </div>

        <div class="form-group">
            <label for="jobdesc">岗位描述</label>
            <textarea class="form-control" id="jobdesc" name="jobdesc" ></textarea>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit"  value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="window.location.href='${appPath}/company/companyInfo.jsp'"  value="返回"/>
        </div>
    </form>
</div>

</body>
</html>