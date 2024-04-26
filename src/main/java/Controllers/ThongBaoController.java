package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Dangky;
import Models.Detai;
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
            switch (action) {
                case "/list_ThongBaoSinhVienController":
                    listthongbaosinhvien(request, response);
                    break;
                case "/list_ThongBaoGiangVienController":
                    listthongbaogiangvien(request, response);
                    break;
                case "/list_ThongBaoHoiDongController":
                    listthongbaohoidong(request, response);
                    break;
                case "/list_ThongBaoAdminController":
                    listthongbaoadmin(request, response);
                    break;
                case "/SV_Xemchitietthongbao":
                    SV_ShowFormXemChiTietThongBao(request, response);
                    break;
                case "/GV_Xemchitietthongbao" :
                    GV_ShowFormXemChiTietThongBao(request, response);
                    break;
                case "/HD_Xemchitietthongbao" :
                    HD_ShowFormXemChiTietThongBao(request, response);
                    break;
                case "/AD_Xemchitietthongbao" :
                    AD_ShowFormXemChiTietThongBao(request, response);
                    break;
                case "/DanhSachThongBao":
                    listthongbaothem(request, response);
                    break;
                case "/ThemThongBao":
                    themThongBao(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                    break;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_ThongBao.jsp");
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
    private void SV_ShowFormXemChiTietThongBao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String MaTB = request.getParameter("MaTB");
        Thongbao existthongbao = thongBaoDAO.selectThongBaoByMaTB(MaTB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_XemThongBao.jsp");
        request.setAttribute("existthongbao", existthongbao);
        dispatcher.forward(request, response);

    }
    private void GV_ShowFormXemChiTietThongBao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String MaTB = request.getParameter("MaTB");
        Thongbao existthongbao = thongBaoDAO.selectThongBaoByMaTB(MaTB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_XemThongBao.jsp");
        request.setAttribute("existthongbao", existthongbao);
        dispatcher.forward(request, response);

    }
    private void AD_ShowFormXemChiTietThongBao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String MaTB = request.getParameter("MaTB");
        Thongbao existthongbao = thongBaoDAO.selectThongBaoByMaTB(MaTB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_XemThongBao.jsp");
        request.setAttribute("existthongbao", existthongbao);
        dispatcher.forward(request, response);

    }
    private void HD_ShowFormXemChiTietThongBao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String MaTB = request.getParameter("MaTB");
        Thongbao existthongbao = thongBaoDAO.selectThongBaoByMaTB(MaTB);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_XemThongBao.jsp");
        request.setAttribute("existthongbao", existthongbao);
        dispatcher.forward(request, response);

    }

    private void themThongBao(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaTB = request.getParameter("MaTB");
        String TenThongBao = request.getParameter("TenThongBao");
        String NoiDungTB = request.getParameter("NoiDungTB");

        Date NgayGui = Date.valueOf(request.getParameter("NgayGui"));
        //String MaSoQL = request.getParameter("MaSoQL");
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");

        System.out.println("Dòng  themThongBao: " + MaTB +" " + matk);
        //Thongbao thongbao = new Thongbao(MaTB, TenThongBao, NoiDungTB, NgayGui, MaSoQL, matk);
        thongBaoDAO.themthongbao(MaTB, TenThongBao, NoiDungTB, NgayGui, matk);

        response.sendRedirect("DanhSachThongBao");
    }
    private void listthongbaothem(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Thongbao> listthongbao = thongBaoDAO.geAllThongBao();
        request.setAttribute("listthongbao", listthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_GuiThongBao.jsp");
        dispatcher.forward(request, response);
    }



}
