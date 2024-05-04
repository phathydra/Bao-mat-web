package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

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
        // Tạo một cookie
        Cookie myCookie = new Cookie("myCookieName", "myCookieValue");

        // Đặt các thuộc tính cho cookie (tuỳ chọn)
        myCookie.setMaxAge(3600);  // Thời gian sống của cookie (ví dụ: 1 giờ)
        myCookie.setPath("/");     // Phạm vi của cookie (ví dụ: toàn bộ trang web)
        myCookie.setHttpOnly(true); // Đặt HttpOnly flag
        myCookie.setSecure(true);   // Set Secure flag

        // Thêm cookie vào response
        response.addCookie(myCookie);
        // Set the SameSite attribute in the Set-Cookie header
        String cookieHeader = response.getHeader("Set-Cookie");
        if (cookieHeader != null) {
            cookieHeader += "; SameSite=Strict";
        } else {
            cookieHeader = "SameSite=Strict";
        }
        response.setHeader("Set-Cookie", cookieHeader);
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
        // Tạo một cookie
        Cookie myCookie = new Cookie("myCookieName", "myCookieValue");

        // Đặt các thuộc tính cho cookie (tuỳ chọn)
        myCookie.setMaxAge(3600);  // Thời gian sống của cookie (ví dụ: 1 giờ)
        myCookie.setPath("/");     // Phạm vi của cookie (ví dụ: toàn bộ trang web)
        myCookie.setHttpOnly(true); // Đặt HttpOnly flag
        myCookie.setSecure(true);   // Set Secure flag

        // Thêm cookie vào response
        response.addCookie(myCookie);
        // Set the SameSite attribute in the Set-Cookie header
        String cookieHeader = response.getHeader("Set-Cookie");
        if (cookieHeader != null) {
            cookieHeader += "; SameSite=Strict";
        } else {
            cookieHeader = "SameSite=Strict";
        }
        response.setHeader("Set-Cookie", cookieHeader);
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
            throws SQLException, IOException, ServletException {
        // Lấy thông tin về thông báo từ request hoặc cơ sở dữ liệu
        String MaTB = request.getParameter("MaTB");
        Thongbao existthongbao = thongBaoDAO.selectThongBaoByMaTB(MaTB);
        Cookie myCookie = new Cookie("myCookieName", "myCookieValue");

        // Đặt các thuộc tính cho cookie (tuỳ chọn)
        myCookie.setMaxAge(3600);  // Thời gian sống của cookie (ví dụ: 1 giờ)
        myCookie.setPath("/");     // Phạm vi của cookie (ví dụ: toàn bộ trang web)
        myCookie.setHttpOnly(true); // Đặt HttpOnly flag
        myCookie.setSecure(true);   // Set Secure flag

        // Thêm cookie vào response
        response.addCookie(myCookie);
        // Set the SameSite attribute in the Set-Cookie header
        String cookieHeader = response.getHeader("Set-Cookie");
        if (cookieHeader != null) {
            cookieHeader += "; SameSite=Strict";
        } else {
            cookieHeader = "SameSite=Strict";
        }
        response.setHeader("Set-Cookie", cookieHeader);
        // Các đoạn mã khác trong phương thức
        request.setAttribute("existthongbao", existthongbao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_XemThongBao.jsp");
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
        try {
            request.setCharacterEncoding("UTF-8");
            String MaTB = request.getParameter("MaTB");
            String TenThongBao = request.getParameter("TenThongBao");
            String NoiDungTB = request.getParameter("NoiDungTB");
            String NgayGuiString = request.getParameter("NgayGui");
            java.sql.Date NgayGui = java.sql.Date.valueOf(NgayGuiString);
            //String MaSoQL = request.getParameter("MaSoQL");
            HttpSession session = request.getSession();
            String matk = (String) session.getAttribute("matk");

            System.out.println("Dòng themThongBao: " + MaTB + " " + matk);
            //Thongbao thongbao = new Thongbao(MaTB, TenThongBao, NoiDungTB, NgayGui, MaSoQL, matk);
            thongBaoDAO.themthongbao(MaTB, TenThongBao, NoiDungTB, NgayGui, matk);

            response.sendRedirect("DanhSachThongBao");
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid sqlDate format. Possible tampering attempt.");
        }
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
