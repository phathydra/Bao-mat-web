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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/HoiDongNghiemThu/*")
public class HoidongnghiemthuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DeTaiDAO detaiDAO;
    private BienbannghiemthuDAO bbntDAO;

    private BienbanchamdecuongDAO bbcdcDAO;


    private HoidongnghiemthuDAO hoidongnghiemthuDAO;


    public void init() {
        hoidongnghiemthuDAO = new HoidongnghiemthuDAO();
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
            if (action.equals("/DeTaiCanPhanCongNghiemThu"))
            {
                listdetaiphancongnghiemthu(request, response);
            }
            else if (action.equals("/ChiTietDeTaiPhanCongNghiemThu"))
            {
                chitietdetaiphancongnghiemthu(request, response);

            }
            else if (action.equals("/PhanCongNghiemThu"))
            {

                phancongnghiemthu(request, response);
            }
            else if (action.equals("/DeTaiCanPhanCongDuyet"))
            {
                listdetaiphancongduyet(request, response);
            }else if (action.equals("/ChiTietDeTaiPhanCongDuyet"))
            {
                chitietdetaiphancongduyet(request, response);

            }else if (action.equals("/PhanCongDuyet"))
            {

                phancongduyetdecuong(request, response);
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
    private void listdetaiphancongnghiemthu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();

        List<Detai> detaiphancongnghiemthu = hoidongnghiemthuDAO.laydetaiphancongnghiemthu();
        request.setAttribute("detaiphancongnghiemthu", detaiphancongnghiemthu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_DSDTNghiemThu.jsp");
        dispatcher.forward(request, response);
    }

    public void chitietdetaiphancongnghiemthu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        //String madt = (String) session.getAttribute("madt");

        String maDT = request.getParameter("maDT");
        Detai chitietdetai = hoidongnghiemthuDAO.selectDeTaiByMaDT(maDT);
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("/HoiDong/HD_PhanCongNghiemThu.jsp");
        request.setAttribute("chitietdetai", chitietdetai);
        dispatcher.forward(request, response);
    }

    private void phancongnghiemthu(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String macham = request.getParameter("MaChamNT");
        String mahdnt = request.getParameter("MaHDNT");
        String maDT = request.getParameter("MaDT");
        System.out.println("Dòng dữ phancongnghiemthu: " + macham + " " + mahdnt + " " + maDT);
        Bienbannghiemthu phancongnghiemthu = new Bienbannghiemthu( macham, mahdnt, maDT);
        hoidongnghiemthuDAO.PhanCongNghiemThu(phancongnghiemthu );
        response.sendRedirect("DeTaiCanPhanCongNghiemThu");
    }



    private void listdetaiphancongduyet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Detai> detaiphancongduyet = hoidongnghiemthuDAO.laydetaiphancongduyetdecuong();
        request.setAttribute("detaiphancongduyet", detaiphancongduyet);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/HoiDong/HD_DSDTPhanCongDuyet.jsp");
        dispatcher.forward(request, response);
    }

    public void chitietdetaiphancongduyet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        //String madt = (String) session.getAttribute("madt");

        String maDT = request.getParameter("maDT");
        Detai chitietdetai = hoidongnghiemthuDAO.selectDeTaiByMaDT(maDT);
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher("/HoiDong/HD_PhanCongDuyet.jsp");
        request.setAttribute("chitietdetai", chitietdetai);
        dispatcher.forward(request, response);
    }

    private void phancongduyetdecuong(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaChamDC = request.getParameter("MaChamDC");
        String MaDDC = request.getParameter("MaDDC");
        String maDT = request.getParameter("MaDT");
        System.out.println("Dòng  phancongduyetdecuong: " + maDT +" " + MaChamDC);
        //Bienbanchamdecuong updatechamdecuong = new Bienbanchamdecuong(xetduyet, linkBB, maDT);
        hoidongnghiemthuDAO.phancongduyetdecuong(MaChamDC, MaDDC, maDT);
        response.sendRedirect("DeTaiCanPhanCongDuyet");
    }

}
