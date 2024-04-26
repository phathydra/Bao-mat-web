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
            if (action.equals("/ThongTinSinhVien")) {
                showThongTinSinhVienForm(request, response);
            }else if (action.equals("/AD_ShowThongTinSinhVien")) {
                AD_showThongTinSinhVienForm(request, response);
            } else if(action.equals("/AD_list_SinhVienController")){
                listsinhvien(request, response);
            } else if(action.equals("/AD_Update_thongtinSV")){
                UpdateSinhVien(request, response);
            }else if(action.equals("/AD_InsertSinhvien")) {
                insertSinhvien(request, response);
            }else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String MSSV = request.getParameter("MSSV");
        String HoTen = request.getParameter("HoTen");
        int CCCD = Integer.parseInt(request.getParameter("CCCD"));
        String GioiTinh = request.getParameter("GioiTinh");
        int STK = Integer.parseInt(request.getParameter("STK"));
        String SDT = request.getParameter("SDT");
        String NienKhoa = request.getParameter("NienKhoa");
        String MaTK = request.getParameter("MaTK");
        String MaNhom = request.getParameter("MaNhom");
        String ngaySinhStr = request.getParameter("NgaySinh");
        String MaKhoa = request.getParameter("MaKhoa");
        LocalDate ngaySinh = LocalDate.parse(ngaySinhStr);
        Date ngaySinhDate = java.sql.Date.valueOf(ngaySinh);
        String ngaySinhFormatted = ngaySinhDate.toString();

        Sinhvien updateSinhvien = new Sinhvien(MSSV, HoTen, MaKhoa, ngaySinhDate, CCCD, STK, SDT, NienKhoa, GioiTinh, MaTK, MaNhom);
        sinhVienDAO.UpdateSinhVien(updateSinhvien);
        response.sendRedirect(request.getContextPath() + "/sinhvien/AD_list_SinhVienController");
    }

    private void insertSinhvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

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
        Taikhoan insertTaikhoan = new Taikhoan(MaTK,TenDangNhap, Email, Password, HoTen, TenLoaiTK, TrangthaiHienThi);
        taikhoanDAO.createNewTaiKhoan(insertTaikhoan);
        Sinhvien insertsinhvien = new Sinhvien(MSSV, HoTen, MaKhoa, NgaysinhDate , CCCD, STK, SDT, NienKhoa, GioiTinh, MaTK, MaNhom, TrangthaiHienThi);
        sinhVienDAO.insertSinhvien(insertsinhvien);
        response.sendRedirect(request.getContextPath() + "/sinhvien/AD_list_SinhVienController");
    }
}





