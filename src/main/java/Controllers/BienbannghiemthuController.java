package Controllers;

import DAO.BienbannghiemthuDAO;
import Models.Bienbannghiemthu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/NghiemThu/*")
public class BienbannghiemthuController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BienbannghiemthuDAO bbntDAO;
    public void init()
    {
        bbntDAO = new BienbannghiemthuDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action  = request.getServletPath();
        try {
            if (action.equals("/NghiemThuDeTai")) {
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

    private void updateNghiemthu(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        request.setCharacterEncoding("UTF-8");
        Integer diem = Integer.valueOf(request.getParameter("Diem"));
        String nhanXet = request.getParameter("NhanXet");
        String linkBB = request.getParameter("LinkBB");
        String maDT = request.getParameter("MaDT");
        Bienbannghiemthu updatenghiemthu = new Bienbannghiemthu( maDT,diem, nhanXet,linkBB);
        bbntDAO.NghiemThu(updatenghiemthu );

        response.sendRedirect("GV_list_DeTaiNghiemThuController");
    }
}
