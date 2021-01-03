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
    <title>修改岗位</title>

    <link href="${appPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${appPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${appPath}/js/bootstrap.min.js"></script>

</head>
<body>
<%
    int index = Integer.valueOf(request.getParameter("index"));
    ArrayList<Job> joblist = (ArrayList<Job>) request.getSession().getAttribute("joblist");
    Job job = joblist.get(index);
%>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改岗位信息</h3>
    <form action="${appPath}/upDateJobServlet?index=<%=index%>&method=update" method="post" name="upload" >

        <div class="form-group">
            <label for="jobname">岗位名称</label>
            <input type="text" class="form-control" id="jobname" name="jobname" value="<%=job.getJobName()%>"  required  placeholder="请输入岗位名称" />
        </div>
        <div class="form-group">
            <label for="jobadd">工作地点</label>
            <input type="text" class="form-control" id="jobadd" name="jobadd" value="<%=job.getJobAddress()%>"  required  placeholder="请输入工作地点" />
        </div>

        <div class="form-group">
            <label for="salary">薪资</label>
            <input type="text" class="form-control" id="salary" name="salary" value="<%=job.getSalary()%>" required placeholder="请输入岗位薪资" />
        </div>

        <div class="form-group">
            <label for="hiringnum">招聘人数</label>
            <input type="text" class="form-control" id="hiringnum"  name="hiringnum" value="<%=job.getJobHiringNum()%>" required placeholder="请输入招聘人数" />
        </div>

        <div class="form-group">
            <label for="jobstate">招聘状态</label>
            <input type="text" class="form-control" id="jobstate"  name="jobstate" value="<%=job.getJobState()%>" required placeholder="请输入招聘状态" />
        </div>

        <div class="form-group">
            <label for="jobdesc">岗位描述</label>
            <textarea class="form-control" id="jobdesc" name="jobdesc" placeholder="请输入岗位描述" ><%=job.getJobDesc()%></textarea>
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