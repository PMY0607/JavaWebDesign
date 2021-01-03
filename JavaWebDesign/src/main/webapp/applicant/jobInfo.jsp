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
    <title>岗位信息</title>

    <link href="${appPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${appPath}/js/jquery-2.1.0.min.js"></script>
    <script src="${appPath}/js/bootstrap.min.js"></script>

    <%
        int index = Integer.valueOf(request.getParameter("index"));
        ArrayList<Job> joblist = (ArrayList<Job>) request.getSession().getAttribute("joblist");
        Job job = joblist.get(index);
        request.getSession().setAttribute("job",job);
    %>

</head>
<body>

<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">岗位信息</h3>
    <form action="${appPath}/upDateJobServlet?method=add" method="post" name="upload" >

        <div class="form-group">
            <label for="jobname">岗位名称</label>
            <input type="text" class="form-control" id="jobname" name="jobname" value="<%=job.getJobName()%>"   disabled   />
        </div>
        <div class="form-group">
            <label for="jobadd">工作地点</label>
            <input type="text" class="form-control" id="jobadd" name="jobadd"  value="<%=job.getJobAddress()%>" disabled  />
        </div>

        <div class="form-group">
            <label for="salary">薪资</label>
            <input type="text" class="form-control" id="salary" name="salary"  value="<%=job.getSalary()%>" disabled  />
        </div>

        <div class="form-group">
            <label for="hiringnum">招聘人数</label>
            <input type="text" class="form-control" id="hiringnum" value="<%=job.getJobHiringNum()%>"  name="hiringnum"  disabled  />
        </div>

        <div class="form-group">
            <label for="jobstate">招聘状态</label>
            <input type="text" class="form-control" id="jobstate"  value="<%=job.getJobState()%>" name="jobstate"  disabled  />
        </div>

        <div class="form-group">
            <label for="jobdesc">岗位描述</label>
            <textarea class="form-control" id="jobdesc" name="jobdesc" disabled ><%=job.getJobDesc()%></textarea>
        </div>

        <div class="form-group" style="text-align: center">
            <c:if test="${job.apply==null||job.apply==0}">
                <a class="btn btn-primary" href="${appPath}/jobOpServlet?index=<%=index%>&method=putR">投递简历</a>
            </c:if>
            <c:if test="${job.apply==1}">
                <a class="btn btn-primary" href="${appPath}/jobOpServlet?index=<%=index%>&method=delR">取消投递</a>
            </c:if>

            <c:if test="${job.collect==null||job.collect==0}">
                <a class="btn btn-primary" href="${appPath}/jobOpServlet?index=<%=index%>&method=addcollect">收藏</a>
            </c:if>
            <c:if test="${job.collect==1}">
                <a class="btn btn-primary" href="${appPath}/jobOpServlet?index=<%=index%>&method=deletecollect">取消收藏</a>
            </c:if>
            <%--<c:if test="${rePath.contains('jsp')}">
            <input class="btn btn-default" type="button" onclick="window.location.href='${rePath}'"  value="返回"/>
            </c:if>
            <c:if test="${rePath.contains('Servlet')}">
            <input class="btn btn-default" type="button" onclick="window.location.href='applicant/'+'${rePath}'"  value="返回"/>
            </c:if>--%>
            <input class="btn btn-default" type="button" onclick="window.location.href='${rePath}'"  value="返回"/>
        </div>
    </form>
</div>

</body>
</html>