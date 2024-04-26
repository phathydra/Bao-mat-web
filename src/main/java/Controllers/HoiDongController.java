package Controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicTreeUI;

import DAO.GiangVienDAO;
import DAO.HoiDongDAO;
import DAO.KhoaDAO;
import Models.Giangvien;
import Models.Hoidong;
import Models.Khoa;
import Models.Quanlyhoidong;

@WebServlet("/Hoidong/*")
public class HoiDongController extends HttpServlet  {
    private static final long serialVersionUID = 1L;
    private HoiDongDAO hoiDongDAO;
    private GiangVienDAO GiangvienDAO;
    private KhoaDAO khoaDAO;

    public void init() {
        hoiDongDAO = new HoiDongDAO();
        GiangvienDAO = new GiangVienDAO();
        khoaDAO = new KhoaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        try {
            if(action.equals("/list_HoiDongController")) {
                listqlHoidong(request, response);
            } else if(action.equals("/UpdateGiangVienHD")){
                updateGiangVienHD(request, response);
            } else if(action.equals("/ThongTinGVHD")){
                editThongTinGiangvienHD(request, response);
            } else if(action.equals("/insertGVHD")) {
                InsertGVHD(request, response);
            } else if(action.equals("/XoaTVKhoiHD")){
                XoaTVHD(request, response);
            } else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);}
        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listqlHoidong(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Hoidong> listqlHoidong = hoiDongDAO.getAllThanhVienHD();
        request.setAttribute("listqlHoidong", listqlHoidong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_QuanLyHoiDong.jsp");
        dispatcher.forward(request, response);
    }

    public void editThongTinGiangvienHD(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String msgv = request.getParameter("msgv");
        Giangvien gv = GiangvienDAO.ShowFormEditGiangvien(msgv);
        List<Hoidong> hoidong = GiangvienDAO.ListHoiDong();
        List<Khoa> khoa = khoaDAO.selectAllKhoa();
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_QuanLyThongTin.jsp");
        request.setAttribute("gv", gv);
        request.setAttribute("listhoidong", hoidong);
        request.setAttribute("listkhoa", khoa);
        dispatcher.forward(request, response);


    }
    private void updateGiangVienHD(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
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
        GiangvienDAO.UpdateGiangVien(updateGiangvien);
        response.sendRedirect(request.getContextPath() + "/Hoidong/list_HoiDongController");
    }
    private void InsertGVHD(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MSGV = request.getParameter("MSGV");
        String MaHD = request.getParameter("MaHD");
        GiangvienDAO.UpdateMaHDGiangVien(MaHD, MSGV);
        response.sendRedirect(request.getContextPath() + "/Hoidong/list_HoiDongController");
    }

    private void XoaTVHD(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String msgv = request.getParameter("msgv");
        hoiDongDAO.XoaTVHoiDong(msgv);
        response.sendRedirect(request.getContextPath() + "/Hoidong/list_HoiDongController");
    }


    /// me


}

