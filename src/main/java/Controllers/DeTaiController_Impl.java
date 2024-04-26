package Controllers;
import DAO.*;
import Models.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/DetaiIMPLE/*")
public class DeTaiController_Impl extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeTaiDAO_Impl detaiDAO_impl;
    private DeTaiDAO detaiDAO;
    private SinhVienDAO sinhVienDAO;
    private BienbannghiemthuDAO bbntDAO;

    private BienbanchamdecuongDAO bbcdcDAO;

    private DangKyDAO dangKyDAO;

    public void init() {
        detaiDAO = new DeTaiDAO();
        detaiDAO_impl = new DeTaiDAO_Impl();
        sinhVienDAO = new SinhVienDAO();
        bbntDAO = new BienbannghiemthuDAO();
        bbcdcDAO = new BienbanchamdecuongDAO();

        // init lại hàm ở phân quyền sinh viên
        dangKyDAO = new DangKyDAO();

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
            if (action.equals("/GV_list_DeTaiController")) {
                listdetai_GiangVien(request, response);
            } else if (action.equals("/GV_list_DeTaiHuongDanController"))
            {
                listdetaihuongdan(request, response);
            } else if (action.equals("/GV_list_DeTaiXetDuyetDeCuongController"))
            {
                listdetaiduyetdecuong(request, response);
            }else if (action.equals("/GV_list_DeTaiNghiemThuController"))
            {
                listdetainghiemthu(request, response);
            }
            else if (action.equals("/GV_ChiTietDeTai"))
            {
                showChitietdetai(request, response);
            }else if (action.equals("/GV_ShowFormXetDuyetDeTai")) {
                showChitietdetaiduyet(request, response);
            } else if ( action.equals("/GV_XetDuyetDeTai")) {
                updateDuyetdecuong(request, response);
            } else if (action.equals("/GV_ShowFormNghiemThuDeTai"))
            {
                showChitietdetainghiemthu(request, response);
            }
            else if (action.equals("/GV_NghiemThuDeTai"))
            {
                updateNghiemthu(request, response);
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

    private void listdetai_GiangVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Detai> listdetai = detaiDAO.getAllDetai();
        request.setAttribute("listdetai", listdetai);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DSDeTai.jsp");
        dispatcher.forward(request, response);
    }

    private void listdetaihuongdan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        List<Detai> listdetaihuongdan = detaiDAO_impl.geAllDetaiHuongDan(matk);
        request.setAttribute("listdetaihuongdan", listdetaihuongdan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DTHuongDan.jsp");
        dispatcher.forward(request, response);
    }

    private void listdetaiduyetdecuong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        List<Detai> listdetaiduyetdecuong = detaiDAO_impl.geAllDetaiDuyetdecuong(matk);
        request.setAttribute("listdetaiduyetdecuong", listdetaiduyetdecuong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DTXetDuyetDC.jsp");
        dispatcher.forward(request, response);
    }

    private void listdetainghiemthu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        List<Detai> listdetainghiemthu = detaiDAO_impl.geAllDetaiNghiemthu(matk);
        request.setAttribute("listdetainghiemthu", listdetainghiemthu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DTNghiemThu.jsp");
        dispatcher.forward(request, response);
    }

    public void showChitietdetai(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        // đã fix lại
        HttpSession session = request.getSession();
        String MaDT = request.getParameter("maDT");
        Detai existdetai = detaiDAO.selectDetaiByMaDT(MaDT);
        List<Dangky> existnhomdangky = dangKyDAO.SelectNhomDangKiByMaDT(MaDT);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/GiangVien/GV_ThongTinDT.jsp");
        request.setAttribute("exdetai", existdetai);
        request.setAttribute("listthanhviennhom", existnhomdangky);
        dispatcher.forward(request, response);

    }

    // here //
    public void showChitietdetaiduyet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        HttpSession session = request.getSession();

        String maDT = request.getParameter("maDT");
        String MaTK = (String) session.getAttribute("matk");
        // lấy danh sách thành viên nhóm cho trước
        List<Dangky> existnhomdangky = dangKyDAO.SelectNhomDangKiByMaDT(maDT);
        request.setAttribute("listthanhviennhom", existnhomdangky);
        Detai chitietdetai = detaiDAO.selectDetaiByMaDT(maDT);

        Bienbanchamdecuong bbcdc = bbcdcDAO.SelectBienBanCDDCByMaDT(maDT);
        request.setAttribute("bbcdc", bbcdc);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/GiangVien/GV_DuyettDeCuong.jsp");
        request.setAttribute("exdetai", chitietdetai);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }

    public void showChitietdetainghiemthu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();

        String maDT = request.getParameter("maDT");
        String MaTK = (String) session.getAttribute("matk");
        // lấy danh sách thành viên nhóm cho trước
        List<Dangky> existnhomdangky = dangKyDAO.SelectNhomDangKiByMaDT(maDT);
        request.setAttribute("listthanhviennhom", existnhomdangky);
        Detai chitietdetai = detaiDAO.selectDetaiByMaDT(maDT);

        Bienbannghiemthu bbnt = bbntDAO.SelectBienBanNTByMaDT(maDT);
        request.setAttribute("bbnt", bbnt);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("/GiangVien/GV_NghiemThuDT.jsp");
        request.setAttribute("exdetai", chitietdetai);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    private void sinhvientheonhom1(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();

        String madt = (String) session.getAttribute("madt");
        madt = "DT00001";
        List<Sinhvien> sinhvientheonhom1 = sinhVienDAO.layNhomsinhvienbyMaDT(madt);
        if (!sinhvientheonhom1.isEmpty()) {
            Sinhvien firstSinhvien = sinhvientheonhom1.get(0);
            String ten = sinhvientheonhom1.get(0).getHoTen();
            String mssv = sinhvientheonhom1.get(0).getMssv();
            String khoa = sinhvientheonhom1.get(0).getMaKhoa();
            System.out.println("Dong du lieu sinhvientheonhom: " + firstSinhvien.toString() + " " + ten + " " + mssv + " " + khoa);

            String ten1 = sinhvientheonhom1.get(1).getHoTen();
            String mssv1 = sinhvientheonhom1.get(1).getMssv();
            String khoa1 = sinhvientheonhom1.get(1).getMaKhoa();
            System.out.println("Dong du lieu sinhvientheonhom: " + firstSinhvien.toString() + " " + ten1 + " " + mssv1 + " " + khoa1);

            String ten2 = sinhvientheonhom1.get(2).getHoTen();
            String mssv2 = sinhvientheonhom1.get(2).getMssv();
            String khoa2 = sinhvientheonhom1.get(2).getMaKhoa();
            System.out.println("Dong du lieu sinhvientheonhom: " + firstSinhvien.toString() + " " + ten2 + " " + mssv2 + " " + khoa2);
        } else {
            System.out.println("Không có dữ liệu.");
        }

        request.setAttribute("sinhvientheonhom1", sinhvientheonhom1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_ThongTinDT.jsp");
        dispatcher.forward(request, response);
    }



    private void nhomsinhvienxetduyet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();

        String madt = (String) session.getAttribute("madt");
        madt = "DT00001";
        List<Sinhvien> sinhvientheonhom = sinhVienDAO.layNhomsinhvienbyMaDT(madt);
        if (!sinhvientheonhom.isEmpty()) {
            Sinhvien firstSinhvien = sinhvientheonhom.get(0);
            System.out.println("Dong nhomsinhvienxetduyet: " + firstSinhvien.toString());
        } else {
            System.out.println("Không có dữ liệu.");
        }
        request.setAttribute("sinhvientheonhom", sinhvientheonhom);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DuyettDeCuong.jsp");
        dispatcher.forward(request, response);
    }

     */

    private void updateNghiemthu(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        Integer diem = Integer.valueOf(request.getParameter("Diem"));
        String nhanXet = request.getParameter("NhanXet");
        String linkBB = request.getParameter("LinkBB");
        String maDT = request.getParameter("MaDT");

        System.out.println("Dòng dữ updateNghiemthu: " + maDT +" " + diem);
        Bienbannghiemthu updatenghiemthu = new Bienbannghiemthu( maDT,diem, nhanXet,linkBB);
        bbntDAO.NghiemThu(updatenghiemthu);

        // gọi list đề tài nghiệm thu
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        List<Detai> listdetainghiemthu = detaiDAO_impl.geAllDetaiNghiemthu(matk);
        request.setAttribute("listdetainghiemthu", listdetainghiemthu);

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('NGHIEM THU THANH CONG !');");
            out.println("location='GV_list_DeTaiNghiemThuController';");
            out.println("</script>");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DTNghiemThu.jsp");
        dispatcher.forward(request, response);
    }


    private void updateDuyetdecuong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String xetduyet = request.getParameter("XetDuyet");
        String linkBB = request.getParameter("LinkBB");
        String maDT = request.getParameter("MaDT");
        System.out.println("Dòng  updateDuyetdecuong: " + maDT +" " + xetduyet);
        //Bienbanchamdecuong updatechamdecuong = new Bienbanchamdecuong(xetduyet, linkBB, maDT);
        bbcdcDAO.updatebienbanchamdecuong(xetduyet, linkBB, maDT);

       // response.sendRedirect("list_DeTaiNghiemThuController");
        // gọi list đề tài nghiệm thu
        HttpSession session = request.getSession();
        String matk = (String) session.getAttribute("matk");
        List<Detai> listdetaiduyetdc = detaiDAO_impl.geAllDetaiDuyetdecuong(matk);
        request.setAttribute("listdetaiduyetdc", listdetaiduyetdc);

        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('DUYET DE CUONG THANH CONG !');");
            out.println("location='GV_list_DeTaiXetDuyetDeCuongController';");
            out.println("</script>");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/GiangVien/GV_DTXetDuyetDC.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }


}
