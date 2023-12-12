package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Sinhvien;
import DAO.SinhVienDAO;
import com.example.nhom221.HelloServlet;

@WebServlet("/sinhvien/*")
public class SinhVienController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static SinhVienDAO sinhVienDAO = new SinhVienDAO();

    public void init() {
        sinhVienDAO = new SinhVienDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getPathInfo(); // cách lấy đường dẫn con trong trường hợp servlet chia nhánh
        try {
            if (action.equals("/ThongTinSinhVien")) {
                showThongTinSinhVienForm(request, response);
            } else
        {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    public static void showThongTinSinhVienForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(matk);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_ThongTinSV.jsp");
        request.setAttribute("sinhvien", sinhvien);

        dispatcher.forward(request, response);
    }


}





