package Controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.KhoaDAO;
import DAO.TaiKhoanDAO;
import Models.Khoa;
import Models.Nhom;
import Models.Sinhvien;
import DAO.SinhVienDAO;
import Models.Taikhoan;
import com.example.nhom221.HelloServlet;
import com.google.protobuf.TextFormat;

@WebServlet("/sinhvien/*")
public class SinhVienController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SinhVienDAO sinhVienDAO;
    private TaiKhoanDAO taikhoanDAO;
    private KhoaDAO khoaDAO;

    public void init() {
        sinhVienDAO = new SinhVienDAO();
        taikhoanDAO = new TaiKhoanDAO();
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
                case "/ThongTinSinhVien":
                    showThongTinSinhVienForm(request, response);
                    break;
                case "/AD_ShowThongTinSinhVien":
                    AD_showThongTinSinhVienForm(request, response);
                    break;
                case "/AD_list_SinhVienController":
                    listsinhvien(request, response);
                    break;
                case "/AD_Update_thongtinSV":
                    UpdateSinhVien(request, response);
                    break;
                case "/AD_InsertSinhvien":
                    insertSinhvien(request, response);
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
    public void showThongTinSinhVienForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(matk);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_ThongTinSV.jsp");
        request.setAttribute("sinhvien", sinhvien);

        dispatcher.forward(request, response);
    }
    // Ngọc :
    public void AD_showThongTinSinhVienForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String mssv = request.getParameter("mssv");
        Sinhvien sinhvien = sinhVienDAO.GetAllThongTinGV(mssv);
        List<Khoa> khoa = khoaDAO .selectAllKhoa();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_TTSV.jsp");
        request.setAttribute("sv", sinhvien);
        request.setAttribute("listkhoa", khoa);
        dispatcher.forward(request, response);
    }

    private void listsinhvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Sinhvien> listsinhvien = sinhVienDAO.getAllSinhvien();
        List<Khoa> khoa = khoaDAO .selectAllKhoa();
        List<Nhom> nhom = sinhVienDAO.ListNhom();
        request.setAttribute("listkhoa", khoa);
        request.setAttribute("listnhom", nhom);
        request.setAttribute("listsinhvien", listsinhvien);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_QLSV.jsp");
        dispatcher.forward(request, response);
    }

    private void UpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String MSSV = sanitizeAndLimitLength(request.getParameter("MSSV"), 8);
            String HoTen = sanitizeAndLimitLength(request.getParameter("HoTen"), 50);
            HoTen = escapeXML(HoTen);
            String CCCDString = sanitizeAndLimitLength(request.getParameter("CCCD"), 12);
            int CCCD = Integer.parseInt(CCCDString);
            String GioiTinh = sanitizeAndLimitLength(request.getParameter("GioiTinh"), 3);
            String STKStr = sanitizeAndLimitLength(request.getParameter("STK"), 10);
            int STK = Integer.parseInt(STKStr);
            String SDT = sanitizeAndLimitLength(request.getParameter("SDT"), 10);
            String NienKhoa = sanitizeAndLimitLength(request.getParameter("NienKhoa"), 4);
            String MaTK = sanitizeAndLimitLength(request.getParameter("MaTK"), 50);
            String MaNhom = sanitizeAndLimitLength(request.getParameter("MaNhom"), 50);
            String ngaySinhStr = sanitizeAndLimitLength(request.getParameter("NgaySinh"), 10);
            ngaySinhStr = escapeXML(ngaySinhStr);
            String MaKhoa = sanitizeAndLimitLength(request.getParameter("MaKhoa"), 10);
            LocalDate ngaySinh = LocalDate.parse(ngaySinhStr);
            Date ngaySinhDate = java.sql.Date.valueOf(ngaySinh);

            Sinhvien updateSinhvien = new Sinhvien(MSSV, HoTen, MaKhoa, ngaySinhDate, CCCD, STK, SDT, NienKhoa, GioiTinh, MaTK, MaNhom);
            sinhVienDAO.UpdateSinhVien(updateSinhvien);
            response.sendRedirect(request.getContextPath() + "/sinhvien/AD_list_SinhVienController");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi!");
            // Handle the exception
        } catch (NullPointerException e){
            System.out.println("Loi!");
        }
    }

    private void insertSinhvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String MSSV = request.getParameter("MSSV");
            String HoTen = request.getParameter("HoTen");
            String MaKhoa = request.getParameter("MaKhoa");
            int CCCD = Integer.parseInt(request.getParameter("CCCD"));
            int STK = Integer.parseInt(request.getParameter("STK"));
            String SDT = request.getParameter("SDT");
            String NienKhoa = request.getParameter("NienKhoa");
            String GioiTinh = request.getParameter("GioiTinh");
            String MaNhom = request.getParameter("MaNhom");
            String NgaysinhString = request.getParameter("NgaySinh");
            String TrangthaiHienThi = request.getParameter("TrangthaiHienThi");
            java.sql.Date NgaysinhDate = java.sql.Date.valueOf(NgaysinhString);
            String MaTK = request.getParameter("MaTK");
            String TenDangNhap = request.getParameter("TenDangNhap");
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            String TenLoaiTK = request.getParameter("TenLoaiTK");
            Taikhoan insertTaikhoan = new Taikhoan(MaTK, TenDangNhap, Email, Password, HoTen, TenLoaiTK, TrangthaiHienThi);
            taikhoanDAO.createNewTaiKhoan(insertTaikhoan);
            Sinhvien insertsinhvien = new Sinhvien(MSSV, HoTen, MaKhoa, NgaysinhDate, CCCD, STK, SDT, NienKhoa, GioiTinh, MaTK, MaNhom, TrangthaiHienThi);
            sinhVienDAO.insertSinhvien(insertsinhvien);
            response.sendRedirect(request.getContextPath() + "/sinhvien/AD_list_SinhVienController");
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
                .replaceAll("'", "&apos;");
    }


}





