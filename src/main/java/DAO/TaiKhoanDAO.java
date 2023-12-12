package DAO;
import Models.Taikhoan;
import Util.JDBCUtil;
import Util.HandleExeption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Models.Sinhvien;

import javax.servlet.http.HttpSession;

public class TaiKhoanDAO {
    static String sqlLogin = "SELECT MaTK FROM taikhoan WHERE TenDangNhap = ? and Password = ? and TrangthaiHienThi = 1 ";
    static String id = null;
    public Taikhoan selectTaiKhoanByMaTK(String maTK) {
        Taikhoan taikhoan = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM taikhoan WHERE MaTK = ? and TrangthaiHienThi = 1");
            ps.setString(1, maTK);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                taikhoan = new Taikhoan();
                taikhoan.setMaTK(rs.getString("MaTK"));
                taikhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoan.setEmail(rs.getString("Email"));
                taikhoan.setPassword(rs.getString("Password"));
                taikhoan.setHoTen(rs.getString("HoTen"));
                taikhoan.setTenLoaiTK(rs.getString("TenLoaiTK"));
                taikhoan.setTrangthaiHienThi(rs.getString("TrangthaiHienThi"));
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return taikhoan;
    }

    public static String LOGIN(Taikhoan taikhoan) throws SQLException{

        Connection conn = JDBCUtil.getConnection();
        try
        {
            PreparedStatement statement = conn.prepareStatement(sqlLogin);
            statement.setString(1, taikhoan.getTenDangNhap());
            statement.setString(2, taikhoan.getPassword());
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                id = rs.getString("MaTK");
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
            return null;
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return id;

    }

}

