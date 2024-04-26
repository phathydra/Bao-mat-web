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

import DAO.DangKyDAO;
import DAO.SinhVienDAO;
import Models.*;
import DAO.DeTaiDAO;
import com.example.nhom221.HelloServlet;
@WebServlet("/DETAI/*")
public class DeTaiController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeTaiDAO detaiDao;
    private DangKyDAO dangKyDAO;
    private SinhVienDAO sinhVienDAO;

    public void init() {
        dangKyDAO = new DangKyDAO();
        detaiDao = new DeTaiDAO();
        sinhVienDAO = new SinhVienDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        System.out.println("Action: " + action); // Thêm dòng này để in ra giá trị của action
        try {
            switch (action) {
                // Function for : sinh vien
                case "/list_DeTaiController":
                    listdetai_SinhVien(request, response);
                    break;
                case "/Xemchitietdetai":
                    SV_ShowFormXemChiTietDeTai(request, response);
                    break;
                case "/list_DeTaiCuaToi":
                    listdetaiCuaToi(request, response);
                    break;
                case "/ShowDangky_detai":
                    ShowFormDangkyDetai(request, response);
                    break;
                case "/Detai_DangKy":
                    insertDangKyMoiController(request, response);
                    break;
                case "/Detai_ShowFormHuy":
                    ShowFormHuyDetai(request, response);
                    break;
                case "/Detai_Huy":
                    HuyDeTaiController(request, response);
                    break;
                case "/Detai_ShowFormNopBC":
                    ShowFormNopBaoCao(request, response);
                    break;
                case "/Detai_BaoCao":
                    NopBaoCaoDeTai(request, response);
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

    private void listdetai_SinhVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Detai> listdetai = detaiDao.getAllDetai();
        request.setAttribute("listdetai", listdetai);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DSDT.jsp");
        dispatcher.forward(request, response);

    }

    private void SV_ShowFormXemChiTietDeTai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String MaDT = request.getParameter("MaDT");
        Detai existdetai = detaiDao.selectDetaiByMaDT(MaDT);
        List<Dangky> existnhomdangky = dangKyDAO.SelectNhomDangKiByMaDT(MaDT);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_XemChiTietDT.jsp");
        request.setAttribute("exdetai", existdetai);
        request.setAttribute("listthanhviennhom", existnhomdangky);
        dispatcher.forward(request, response);

    }

    private void listdetaiCuaToi(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        List<Detai> listdetaicuatoi = detaiDao.getAllDetaiCuaToi(MaTK);
        request.setAttribute("listdetaicuatoi", listdetaicuatoi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DTcuatoi.jsp");
        dispatcher.forward(request, response);
    }

    private void ShowFormDangkyDetai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        // lấy thông tin mặc định sinh viên thông qua mã tài khoản
        Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(MaTK);
        // lấy danh sách thành viên nhóm cho trước
        List<Sinhvien> thanhviennhom = dangKyDAO.ListThanhVienNhomDangKiByMaTK(MaTK);
        // lấy dữ liệu đăng ký : list giảng viên hướng dẫn
        List<Giangvien> giangvienhuongdans = dangKyDAO.ListGiangVienHuongDan();
        // lấy dữ liệu đăng ký : list đề tài đăng ký
        List<Detai> detaidangky = dangKyDAO.ListDeTaiDangKy();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DKDT.jsp");
        request.setAttribute("sinhvien", sinhvien);
        request.setAttribute("listthanhviennhom", thanhviennhom);
        request.setAttribute("listgvhuongdan",giangvienhuongdans );
        request.setAttribute("listdetaidangky", detaidangky );
        dispatcher.forward(request, response);
    }
    // note here for important
    private void insertDangKyMoiController(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaDK = request.getParameter("MaDK");
        String MaDT = request.getParameter("MaDT");
        String MaNhom = request.getParameter("MaNhom");
        String GhiChu = request.getParameter("GhiChu");
        String MaHD = "HD0000"; // set hoi dong rong cho dang ky
        String LinkDeCuong = request.getParameter("LinkDeCuong");
        String TrangThai = "Chờ duyệt";
        String MSGV = request.getParameter("MSGV");
        String NgayDangKyString = request.getParameter("NgayDangKy");
        java.sql.Date NgayDangKy = java.sql.Date.valueOf(NgayDangKyString);
        Boolean TrangthaiHienThi = Boolean.valueOf(request.getParameter("TrangthaiHienThi"));
        // insert :
        Dangky dangky = new Dangky(MaDK, MaDT, MaNhom, GhiChu, MaHD, LinkDeCuong, TrangThai, MSGV, NgayDangKy, TrangthaiHienThi);
        dangKyDAO.insertDangKyMoi(dangky);

        String MaTrangThai = "MTT002";
        // update bảng đề tài đẩy lên list detaicuatoi
        Detai detai = new Detai(MaDT, GhiChu, MaTrangThai, MSGV, TrangthaiHienThi);
        detaiDao.updateDeTaiDangKyMoi(detai);
        // list dt của tôi
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        List<Detai> listdetaicuatoi = detaiDao.getAllDetaiCuaToi(MaTK);
        request.setAttribute("listdetaicuatoi", listdetaicuatoi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DTcuatoi.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    // huy de tai
    private void ShowFormHuyDetai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        // lấy thông tin mặc định sinh viên thông qua mã tài khoản
        Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(MaTK);
        // lấy danh sách thành viên nhóm cho trước
        List<Sinhvien> thanhviennhom = dangKyDAO.ListThanhVienNhomDangKiByMaTK(MaTK);
        // lấy dữ liệu đăng ký : list đề tài đã đăng ký có trạng thái chờ duyệt hoặc đã duyệt
        List<Detai> detaidaDK = dangKyDAO.ListDeTaiDaDK(MaTK);
        request.setAttribute("sinhvien", sinhvien);
        request.setAttribute("listthanhviennhom", thanhviennhom);
        request.setAttribute("listdetaidangky", detaidaDK);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_HuyDT.jsp");
        dispatcher.forward(request, response);
    }

    private void HuyDeTaiController(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaDT = request.getParameter("MaDT");
        String GhiChu = request.getParameter("GhiChu");
        String NgayHuyString = request.getParameter("NgayHuy");
        java.sql.Date NgayKetThuc = java.sql.Date.valueOf(NgayHuyString);
        Boolean TrangthaiHienThi = Boolean.valueOf(request.getParameter("TrangthaiHienThi"));
        String MaTrangThai = "MTT003";
        // update bảng đề tài đẩy lên list detaicuatoi
        Detai detai = new Detai(MaDT, GhiChu,  NgayKetThuc, MaTrangThai, TrangthaiHienThi);
        detaiDao.update_HuyDeTai(detai);
        // controller -> con
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        List<Detai> listdetaicuatoi = detaiDao.getAllDetaiCuaToi(MaTK);
        request.setAttribute("listdetaicuatoi", listdetaicuatoi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DTcuatoi.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    // báo cáo đề tài :
    private void ShowFormNopBaoCao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        // lấy thông tin mặc định sinh viên thông qua mã tài khoản
        Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(MaTK);
        // lấy danh sách thành viên nhóm cho trước
        List<Sinhvien> thanhviennhom = dangKyDAO.ListThanhVienNhomDangKiByMaTK(MaTK);
        // lấy dữ liệu đăng ký : list đề tài có trạng thái đã duyệt mới có thể nộp báo cáo
        List<Detai> deTaiNopBaoCao = dangKyDAO.ListDeTaiNopBaoCao(MaTK);
        request.setAttribute("sinhvien", sinhvien);
        request.setAttribute("listthanhviennhom", thanhviennhom);
        request.setAttribute("listdetaidangky", deTaiNopBaoCao );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_BaoCao.jsp");
        dispatcher.forward(request, response);
    }

    private void NopBaoCaoDeTai(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaDT = request.getParameter("MaDT");
        String GhiChu = request.getParameter("GhiChu");
        String NgayHuyString = request.getParameter("NgayNop");
        java.sql.Date NgayNop = java.sql.Date.valueOf(NgayHuyString);
        String MaTrangThai = "MTT006"; // cho nghiem thu
        String LinkNopBaoCao = request.getParameter("LinkDeTai");
        // update bảng đề tài
        Detai detai = new Detai(MaDT, GhiChu,  NgayNop, LinkNopBaoCao, MaTrangThai);
        detaiDao.NopBaoCaoDeTai(detai);
        // controller -> con
        HttpSession session = request.getSession();
        String MaTK = (String) session.getAttribute("matk");
        List<Detai> listdetaicuatoi = detaiDao.getAllDetaiCuaToi(MaTK);
        request.setAttribute("listdetaicuatoi", listdetaicuatoi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/SinhVien/SV_DTcuatoi.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}


