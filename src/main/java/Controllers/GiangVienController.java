package Controllers;

import DAO.GiangVienDAO;
import DAO.KhoaDAO;
import DAO.TaiKhoanDAO;
import Models.Giangvien;
import Models.Hoidong;
import Models.Taikhoan;
import Models.*;

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
            if (action.equals("/ThongTinGiangVien")) {
                showThongTinGiangVienForm(request, response);
            } else if(action.equals("/AD_list_GiangVienController")){
                listqlGiangVien(request, response);
            } else if (action.equals("/AD_editGiangVien")) {
                ShowFormEditThongTinGiangvien(request, response);
            }  else if (action.equals("/AD_updateGiangVien")) {
                UpdateThongTinGiangVien(request, response);
            }else if (action.equals("/AD_InsertGiangVien")) {
                insertGiangvien(request, response); }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        String MSGV = request.getParameter("MSGV");
        String MaKhoa = request.getParameter("MaKhoa");
        int CCCD = Integer.parseInt(request.getParameter("CCCD"));
        String MaHD = request.getParameter("MaHD");
        String TenGV = request.getParameter("TenGV");
        String ngaySinhStr = request.getParameter("NgaySinh");
        String sdt = request.getParameter("Sdt");
        String GioiTinh = request.getParameter("GioiTinh");
        LocalDate ngaySinh = LocalDate.parse(ngaySinhStr);
        java.sql.Date ngaySinhDate = java.sql.Date.valueOf(ngaySinh);
        Giangvien updateGiangvien = new Giangvien(TenGV, CCCD, MaKhoa, ngaySinhDate, GioiTinh, sdt, MaHD, MSGV);
        qlGiangvienDAO.UpdateGiangVien(updateGiangvien);
        response.sendRedirect(request.getContextPath() + "/giangvien/AD_list_GiangVienController");
    }

    private void insertGiangvien(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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
        Taikhoan insertTaikhoan = new Taikhoan(MaTK,TenDangNhap, Email, Password, HoTen, TenLoaiTK, TrangthaiHienThi);
        qlTaiKhoanDAO.createNewTaiKhoan(insertTaikhoan);
        Giangvien insertgiangvien = new Giangvien(MSGV, HoTen, MaKhoa, MaTK, NgaysinhDate , CCCD, MaHD, GioiTinh, Sdt,TrangthaiHienThi);
        qlGiangvienDAO.insertGiangVien(insertgiangvien);
        response.sendRedirect(request.getContextPath() + "/giangvien/AD_list_GiangVienController");
    }


}

