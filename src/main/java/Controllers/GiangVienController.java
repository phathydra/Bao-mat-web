package Controllers;

import DAO.GiangVienDAO;
import DAO.KhoaDAO;
import DAO.TaiKhoanDAO;
import Models.Giangvien;
import Models.Hoidong;
import Models.Taikhoan;
import Models.*;
import com.google.protobuf.TextFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@WebServlet("/giangvien/*")
public class GiangVienController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  GiangVienDAO giangVienDAO = new GiangVienDAO();
    private GiangVienDAO qlGiangvienDAO;
    private TaiKhoanDAO qlTaiKhoanDAO;

    private KhoaDAO khoaDAO;
    public void init() {
        giangVienDAO = new GiangVienDAO();
        qlGiangvienDAO = new GiangVienDAO();
        qlTaiKhoanDAO = new TaiKhoanDAO();
        khoaDAO = new KhoaDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getPathInfo(); // cách lấy đường dẫn con trong trường hợp servlet chia nhánh
        try {
            switch (action) {
                case "/ThongTinGiangVien":
                    showThongTinGiangVienForm(request, response);
                    break;
                case "/AD_list_GiangVienController":
                    listqlGiangVien(request, response);
                    break;
                case "/AD_editGiangVien":
                    ShowFormEditThongTinGiangvien(request, response);
                    break;
                case "/AD_updateGiangVien":
                    UpdateThongTinGiangVien(request, response);
                    break;
                case "/AD_InsertGiangVien":
                    insertGiangvien(request, response);
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

    public void showThongTinGiangVienForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        Giangvien giangvien = giangVienDAO.selectGiangVienByMaTK(matk);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_ThongTinCaNhan.jsp");
        request.setAttribute("thongtingiangvien", giangvien);

        dispatcher.forward(request, response);
    }

    private void listqlGiangVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Giangvien> listqlGiangVien = qlGiangvienDAO.getAllGV();
        List<Khoa> khoa = khoaDAO .selectAllKhoa();
        List<Hoidong> hoidong = giangVienDAO.ListHoiDong();
        request.setAttribute("listqlGiangVien", listqlGiangVien);
        request.setAttribute("listkhoa", khoa);
        request.setAttribute("listhoidong", hoidong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_QLGV.jsp");
        dispatcher.forward(request, response);
    }

    public void ShowFormEditThongTinGiangvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String msgv = request.getParameter("msgv");
        Giangvien gv = qlGiangvienDAO.ShowFormEditGiangvien(msgv);
        List<Hoidong> hoidong = giangVienDAO.ListHoiDong();
        List<Khoa> khoa = khoaDAO.selectAllKhoa();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_TTGV.jsp");
        request.setAttribute("gv", gv);
        request.setAttribute("listhoidong", hoidong);
        request.setAttribute("listkhoa", khoa);
        dispatcher.forward(request, response);
    }

    private void UpdateThongTinGiangVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String MSGV = sanitizeAndLimitLength(request.getParameter("MSGV"), 10);
            MSGV = escapeXML(MSGV);
            String MaKhoa = sanitizeAndLimitLength(request.getParameter("MaKhoa"), 10);
            String CCCDString = sanitizeAndLimitLength(request.getParameter("CCCD"), 12);
            int CCCD = Integer.parseInt(CCCDString);
            String MaHD = sanitizeAndLimitLength(request.getParameter("MaHD"), 10);
            String TenGV = sanitizeAndLimitLength(request.getParameter("TenGV"), 50);
            TenGV = escapeXML(TenGV);
            String ngaySinhStr = sanitizeAndLimitLength(request.getParameter("NgaySinh"), 10);
            ngaySinhStr = escapeXML(ngaySinhStr);
            String sdt = sanitizeAndLimitLength(request.getParameter("Sdt"), 10);
            String GioiTinh = sanitizeAndLimitLength(request.getParameter("GioiTinh"), 3);
            java.sql.Date ngaySinhDate = java.sql.Date.valueOf(ngaySinhStr);
            Giangvien updateGiangvien = new Giangvien(TenGV, CCCD, MaKhoa, ngaySinhDate, GioiTinh, sdt, MaHD, MSGV);
            qlGiangvienDAO.UpdateGiangVien(updateGiangvien);
            response.sendRedirect(request.getContextPath() + "/giangvien/AD_list_GiangVienController");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi!");
            // Handle the exception
        } catch (NullPointerException e){
            System.out.println("Loi!");
        }
    }

    private void insertGiangvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String MSGV = request.getParameter("MSGV");
            String HoTen = request.getParameter("TenGV");
            String MaKhoa = request.getParameter("MaKhoa");
            int CCCD = Integer.parseInt(request.getParameter("CCCD"));
            String MaHD = request.getParameter("MaHD");
            String NgaysinhString = request.getParameter("NgaySinh");
            String TrangthaiHienThi = request.getParameter("TrangthaiHienThi");
            java.sql.Date NgaysinhDate = java.sql.Date.valueOf(NgaysinhString);
            String MaTK = request.getParameter("MaTK");
            String TenDangNhap = request.getParameter("TenDangNhap");
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String TenLoaiTK = request.getParameter("TenLoaiTK");
            String GioiTinh = request.getParameter("GioiTinh");
            String Sdt = request.getParameter("Sdt");
            Taikhoan insertTaikhoan = new Taikhoan(MaTK, TenDangNhap, Email, Password, HoTen, TenLoaiTK, TrangthaiHienThi);
            qlTaiKhoanDAO.createNewTaiKhoan(insertTaikhoan);
            Giangvien insertgiangvien = new Giangvien(MSGV, HoTen, MaKhoa, MaTK, NgaysinhDate, CCCD, MaHD, GioiTinh, Sdt, TrangthaiHienThi);
            qlGiangvienDAO.insertGiangVien(insertgiangvien);
            response.sendRedirect(request.getContextPath() + "/giangvien/AD_list_GiangVienController");
        } catch (NumberFormatException e){
            System.out.println("Thong tin nhap vao khong dung");
        }
    }

    private String sanitizeAndLimitLength(String input, int maxLength) {
        if (input == null) {
            return ""; // Return empty string if input is null
        }
        if (input.length() > maxLength) {
            return input.substring(0, maxLength - 1); // Limit length if input exceeds maxLength
        }
        return input;
    }


    // Method to escape XML special characters
    private String escapeXML(String input) {
        if (input == null) {
            return ""; // Return empty string if input is null
        }
        return input.replaceAll("&", "&amp;")
                .replaceAll("<", "&lt;")
                .replaceAll(">", "&gt;")
                .replaceAll("\"", "&quot;")
                .replaceAll("'", "&apos;")
                .replaceAll("&amp;#", "&amp;amp;#")
                .replaceAll("&amp;lt;", "&amp;amp;lt;")
                .replaceAll("&amp;gt;", "&amp;amp;gt;");
    }

}

