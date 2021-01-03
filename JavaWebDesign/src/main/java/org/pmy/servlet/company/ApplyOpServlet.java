package org.pmy.servlet.company;

import org.pmy.Dao.CompanyDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/applyOpServlet")
public class ApplyOpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer applyId = Integer.valueOf(request.getParameter("applyId"));
        String method = request.getParameter("method");
        CompanyDAO dao = new CompanyDAO();

        if(method.equals("pass")){
            dao.setApplyState(1,applyId);
        }else if(method.equals("refuse")){
            dao.setApplyState(0,applyId);
        }

        request.getRequestDispatcher("company/applyManager.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
