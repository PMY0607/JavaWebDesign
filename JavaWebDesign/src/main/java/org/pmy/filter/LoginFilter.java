package org.pmy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(value = "/*" ,dispatcherTypes={DispatcherType.FORWARD,DispatcherType.REQUEST})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String referPath = request.getHeader("Referer");


        String descPath = request.getServletPath();
        descPath = descPath.substring(descPath.lastIndexOf("/")+1);

        String rePath = (String) request.getSession().getAttribute("rePath");



        if(referPath!=null) {
            referPath = referPath.substring(referPath.indexOf(request.getContextPath())+request.getContextPath().length()+1);
            /*System.out.println("rePath1:"+(String)request.getSession().getAttribute("rePath"));
            System.out.println("referPath:"+referPath);
            System.out.println("descPath:"+descPath);*/

            //来的lu
            if (!referPath.contains("Servlet") && !referPath.contains("jobInfo.jsp")) {
                rePath = referPath.substring(referPath.lastIndexOf("/") + 1);
            } else if (!descPath.contains("Servlet") && !descPath.contains("jobInfo.jsp")) {
                rePath = descPath.substring(descPath.lastIndexOf("/") + 1);
            }
        }

        request.getSession().setAttribute("rePath",rePath);



//        chain.doFilter(request,response);
        String uri = request.getRequestURI();
       // System.out.println(uri);
//        chain.doFilter(request,response);
        //2.判断是否包含登录相关资源路径,要注意排除掉 css/js/图片/验证码等资源
        if (uri.contains("login") || uri.contains("regist") ||uri.contains("Login") || uri.contains("Regist") || uri.contains("/css/") || uri.contains("/js/")
                || uri.contains("/fonts/") ||uri.contains("Ajax")) {
            //包含，用户就是想登录。放行
            chain.doFilter(req, resp);
        } else {
            //3.从获取session中获取user
            Object applicant = request.getSession().getAttribute("applicant");
            Object company = request.getSession().getAttribute("company");
            if (applicant != null || company != null) {
                //登录了。放行
                chain.doFilter(req, resp);
            } else {
                //没有登录。跳转登录页面
                request.setAttribute("msg", "您尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
