package org.pmy.servlet.company;

import org.pmy.Dao.CompanyDAO;
import org.pmy.bean.Company;
import org.pmy.bean.Resume;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/updateCompanyInfoServlet")
public class UpdateCompanyInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Company company = (Company)session.getAttribute("company");

        setCompany(request,company);
        System.out.println(company);

        CompanyDAO dao = new CompanyDAO();
        System.out.println(dao.updateCompany(company));

        //session保存公司信息
        request.getSession().setAttribute("company",company);
        request.getRequestDispatcher("/company/companyInfo.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private void setCompany(HttpServletRequest request, Company company) throws IOException, ServletException {

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String viewnum = request.getParameter("viewnum");
        String size = request.getParameter("size");
        String brief = request.getParameter("brief");
        String type = request.getParameter("type");

        //上传头像
        Part part = request.getPart("companyPic");
        //上传的文件名head1.jpg
        String fileName = part.getSubmittedFileName();

        if(fileName!=null&&fileName.length()!=0) {
            //创建保存文件目录
            String dir = this.getServletContext().getRealPath("/images/company");
            //判断 目录是否存在
            File imgDir = new File(dir);
            if (!imgDir.exists()) {
                imgDir.mkdirs();
            }
            //上传到服务器文件路径imgDir+'/'+fileName
            part.write(dir + "/" + fileName);
        }else{
            fileName=company.getCompanyPic();
        }

        //设置值
        company.setCompanyName(name);
        company.setCompanyAddress(address);
        company.setCompanyViewnum(viewnum);
        company.setCompanySize(size);
        company.setCompanyBrief(brief);
        company.setCompanyType(type);
        company.setCompanyPic(fileName);

    }

}
