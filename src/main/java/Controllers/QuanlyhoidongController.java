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

import DAO.*;
import Models.*;
import com.example.nhom221.HelloServlet;
@WebServlet("/QuanLyHoiDong/*")
public class QuanlyhoidongController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeTaiDAO detaiDao;
    private DangKyDAO dangKyDAO;
    private SinhVienDAO sinhVienDAO;
    private BienbanchamdecuongDAO bbcdcDAO;
    private BienbannghiemthuDAO bbntDAO;
    private QuanlyhoidongDAO quanlyhoidongDAO;


    public void init() {
        dangKyDAO = new DangKyDAO();
        detaiDao = new DeTaiDAO();
        sinhVienDAO = new SinhVienDAO();
        bbcdcDAO = new BienbanchamdecuongDAO();
        bbntDAO = new BienbannghiemthuDAO();
        quanlyhoidongDAO = new QuanlyhoidongDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            switch (action) {
                case "/ShowFormQuanLyDeTai":
                    ShowFormQuanLyDanhSachDeTai(request, response);
                    break;
                case "/ShowFormXemChiTietDeTai":
                    ShowFormXemChiTietDeTai(request, response);
                    break;
                case "/XetDuyetDeTaiChung":
                    XetDuyetDeTaiChung(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index1.jsp");
                    dispatcher.forward(request, response);
                    break;
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void ShowFormQuanLyDanhSachDeTai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Detai> listdetai = detaiDao.getAllDetai();
        request.setAttribute("listdetai", listdetai);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_DSDeTai.jsp");
        dispatcher.forward(request, response);

    }


    private void ShowFormXemChiTietDeTai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        HttpSession session = request.getSession();
        String MaDT = request.getParameter("MaDT");
        Bienbanchamdecuong bbcdc = bbcdcDAO.SelectBienBanCDDCByMaDT(MaDT);
        Detai existdetai = detaiDao.selectDetaiByMaDT(MaDT);
        List<Dangky> existnhomdangky = dangKyDAO.SelectNhomDangKiByMaDT(MaDT);
        Bienbannghiemthu bbnt = bbntDAO.SelectBienBanNTByMaDT(MaDT);
        List<Trangthai> trangthais = quanlyhoidongDAO.listtrangthai();
        request.setAttribute("bbnt", bbnt);
        request.setAttribute("exdetai", existdetai);
        request.setAttribute("listthanhviennhom", existnhomdangky);
        request.setAttribute("bbcdc", bbcdc);
        request.setAttribute("trangthais", trangthais);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/HoiDong/HD_XetDuyetDeTai.jsp");
        dispatcher.forward(request, response);

    }
    private void XetDuyetDeTaiChung(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaDT = request.getParameter("MaDT");
        String MaTrangThai = request.getParameter("MaTrangThai_change");

        // update bảng đề tài đẩy lên list detaicuatoi
        Detai detai = new Detai(MaDT, MaTrangThai);
        quanlyhoidongDAO.update_MaTrangThaiXetDuyet(detai);
        // controller -> con
        HttpSession session = request.getSession();
        List<Detai> listdetai = detaiDao.getAllDetai();
        request.setAttribute("listdetai", listdetai);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_DSDeTai.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}