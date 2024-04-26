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

import DAO.SinhVienDAO;
import Models.Sinhvien;
import Models.Taikhoan;
import DAO.TaiKhoanDAO;
import com.example.nhom221.HelloServlet;

@WebServlet("/Taikhoan/*")
public class TaiKhoanController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private  TaiKhoanDAO taiKhoanDAO;
    public void init()
    {
        taiKhoanDAO = new TaiKhoanDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getPathInfo(); // cách lấy đường dẫn con trong trường hợp servlet chia nhánh
        try {
            if (action.equals("/login")) {
                login(request, response);
            }else if(action.equals("/AD_ShowThongTinTK")){
                showThongTinTK(request, response);
            } else if(action.equals("/AD_list_qlTaiKhoanController")){
                listqlTaikhoan(request, response);
            } else if(action.equals("/AD_UpdateThongtinTK")){
                updateTaikhoan(request, response);
            } else if(action.equals("/AD_DeleteThongtinTK")){
                deleteTaikhoan(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    // nhớ đổi lại tên file index sang login cho file main index sau khi xong function
    //@SuppressWarnings("CallToPrintStackTrace")
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String TenDangNhap = request.getParameter("tenDangNhap");
        String Password = request.getParameter("password");
        Taikhoan taikhoan = new Taikhoan();
        taikhoan.setTenDangNhap(TenDangNhap);
        taikhoan.setPassword(Password);
        String matk = TaiKhoanDAO.LOGIN(taikhoan);
        if(matk != null)
        {
            taikhoan = taiKhoanDAO.selectTaiKhoanByMaTK(matk);
            HttpSession session = request.getSession();
            session.setAttribute("matk", matk);
            if(taikhoan.getTenLoaiTK().equals("Sinh viên"))
            {
                // session for sv : way 1 to get session to jsp
                /*
                SinhVienDAO sinhVienDAO = new SinhVienDAO();
                Sinhvien sinhvien = sinhVienDAO.selectSinhVienByMaTK(matk);
                HttpSession session_sv = request.getSession();
                session_sv.setAttribute("sinhvien", sinhvien);

                 */

                // way 2 to test : get another Controller function to this Controller class
                //SinhVienController.showThongTinSinhVienForm(request, response);

                //response.sendRedirect(request.getContextPath() + "/SinhVien/SV_ThongBao.jsp");
                response.sendRedirect(request.getContextPath() + "/ThongBao/list_ThongBaoSinhVienController");
            }
            else if (taikhoan.getTenLoaiTK().equals("Giảng viên"))
                //response.sendRedirect(request.getContextPath()+"/GiangVien/GV_ThongBao.jsp");
                response.sendRedirect(request.getContextPath() + "/ThongBao/list_ThongBaoGiangVienController");
            else if (taikhoan.getTenLoaiTK().equals("Quản lý hội đồng"))
                //response.sendRedirect(request.getContextPath()+"/HoiDong/HD_ThongBao.jsp");
                response.sendRedirect(request.getContextPath() + "/ThongBao/list_ThongBaoHoiDongController");
            else if (taikhoan.getTenLoaiTK().equals("Admin"))
                //response.sendRedirect(request.getContextPath()+"/Admin/AD_ThongBao.jsp");
                response.sendRedirect(request.getContextPath() + "/ThongBao/list_ThongBaoAdminController");
        }
        else {
            request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            try{
                dispatcher.forward(request, response);
            }catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
    private void listqlTaikhoan(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        List<Taikhoan> listqlTaikhoan = taiKhoanDAO.getAllTK();
        request.setAttribute("listqlTaikhoan", listqlTaikhoan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_QLTK.jsp");
        dispatcher.forward(request, response);
    }

    private void showThongTinTK(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String maTK = request.getParameter("maTK");
        Taikhoan tk = taiKhoanDAO.SelectTaiKhoan(maTK);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Admin/AD_TTTK.jsp");
        request.setAttribute("tk", tk);
        dispatcher.forward(request,response);
    }

    private void updateTaikhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        String MaTK = request.getParameter("MaTK");
        String TenDangNhap = request.getParameter("TenDangNhap");
        String Email = request.getParameter("Email");
        String Password = request.getParameter("Password");
        String HoTen = request.getParameter("HoTen");
        String TenLoaiTK = request.getParameter("TenLoaiTK");

        Taikhoan updateTaikhoan = new Taikhoan(MaTK, TenDangNhap, Email, Password, HoTen, TenLoaiTK, "TRUE");
        taiKhoanDAO.UpdateTaikhoan(updateTaikhoan);
        response.sendRedirect(request.getContextPath() + "/Taikhoan/AD_list_qlTaiKhoanController");
    }

    private void deleteTaikhoan(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String MaTK = request.getParameter("MaTK");
        taiKhoanDAO.deleteUser(MaTK);
        response.sendRedirect(request.getContextPath() + "/Taikhoan/AD_list_qlTaiKhoanController");
    }
}
