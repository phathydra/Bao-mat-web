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

import Models.Thongbao;
import DAO.ThongBaoDAO;
import com.example.nhom221.HelloServlet;


@WebServlet("/ThongBao/*")
public class ThongBaoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ThongBaoDAO thongBaoDAO;

    public void init() {
        thongBaoDAO = new ThongBaoDAO();
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
            if (action.equals("/list_ThongBaoSinhVienController")) {
                listthongbaosinhvien(request, response);
            } else if (action.equals("/list_ThongBaoGiangVienController"))
            {
                listthongbaogiangvien(request, response);
            }
            else if (action.equals("/list_ThongBaoHoiDongController"))
            {
                listthongbaohoidong(request, response);
            }
            else if ( action.equals("/list_ThongBaoAdminController"))
            {
                listthongbaoadmin(request, response);
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

    private void  listthongbaosinhvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Thongbao> listthongbao = thongBaoDAO.geAllThongBao();
        request.setAttribute("listthongbao", listthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_ThongBao.jsp");
        dispatcher.forward(request, response);

    }
    private void  listthongbaogiangvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Thongbao> listthongbao = thongBaoDAO.geAllThongBao();
        request.setAttribute("listthongbao", listthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_ThongBao.jsp");
        dispatcher.forward(request, response);

    }
    private void  listthongbaohoidong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Thongbao> listthongbao = thongBaoDAO.geAllThongBao();
        request.setAttribute("listthongbao", listthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_XemThongBao.jsp");
        dispatcher.forward(request, response);

    }
    private void  listthongbaoadmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Thongbao> listthongbao = thongBaoDAO.geAllThongBao();
        request.setAttribute("listthongbao", listthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_ThongBao.jsp");
        dispatcher.forward(request, response);

    }

}
