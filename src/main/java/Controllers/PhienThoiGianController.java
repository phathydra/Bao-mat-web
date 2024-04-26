package Controllers;

import Models.Phienthoigian;
import DAO.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PhienThoiGian/*")
public class PhienThoiGianController extends HttpServlet  {
    private static final long serialVersionUID = 1L;
    private PhienthoigianDAO phienthoigianDAO;

    public void init() {
        phienthoigianDAO = new PhienthoigianDAO();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getPathInfo();
        System.out.println("Action: " + action); // Thêm dòng này để in ra giá trị của action
        try {
            if (action.equals("/QuanLyPhienThoiGian")) {
                dahsachphienthoigian(request, response);

            } else if (action.equals("/ThemPhienThoiGian")) {

                themphienthoigian(request, response);
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void dahsachphienthoigian(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Phienthoigian> danhsachphienthoigian = phienthoigianDAO.laydanhsachphienthoigian();
        request.setAttribute("danhsachphienthoigian", danhsachphienthoigian);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_QuanLyPhienThoiGian.jsp");
        dispatcher.forward(request, response);
    }

    private void themphienthoigian(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        String MaPhienTG = request.getParameter("MaPhienTG");
        Date NgayBatDau_DK = Date.valueOf(request.getParameter("NgayBatDau_DK"));
        Date NgayKetThuc_DK = Date.valueOf(request.getParameter("NgayKetThuc_DK"));
        Date NgayBatDau_XD = Date.valueOf(request.getParameter("NgayBatDau_XD"));
        Date NgayKetThuc_XD = Date.valueOf(request.getParameter("NgayKetThuc_XD"));
        Date NgayBatDau_NT = Date.valueOf(request.getParameter("NgayBatDau_NT"));
        Date NgayKetThuc_NT = Date.valueOf(request.getParameter("NgayKetThuc_NT"));

        System.out.println("Dòng  themphienthoigian: " + MaPhienTG +" " + NgayBatDau_DK);
        Phienthoigian phienthoigian = new Phienthoigian(MaPhienTG, NgayBatDau_DK, NgayKetThuc_DK, NgayBatDau_XD, NgayKetThuc_XD, NgayBatDau_NT, NgayKetThuc_NT);
        phienthoigianDAO.themphienthoigian(phienthoigian);

        response.sendRedirect("QuanLyPhienThoiGian");
    }
}
