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

    String sqlGetAllTK = "SELECT * FROM taikhoan WHERE TenLoaiTK != 'Admin'";
    String sqlGetThongTinTK = "SELECT * FROM taikhoan WHERE MaTK=?";
    String sqlEditThongTinTK = "UPDATE taikhoan SET Hoten=?, TenDangNhap=?, Password=?, TenLoaiTK=?, Email=? WHERE MaTK=? ";
    String sqlDeleteThongTinTK = "UPDATE taikhoan SET TrangthaiHienThi= ? WHERE MaTK=? ";
    String insertTaiKhoanSql = "INSERT INTO taikhoan (MaTK, TenDangNhap, Email, Password, HoTen, TenLoaiTK, TrangthaiHienThi) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public List<Taikhoan> getAllTK() {
        List<Taikhoan> taikhoans = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Taikhoan taikhoan = new Taikhoan();
                taikhoan.setHoTen(rs.getString("HoTen"));
                taikhoan.setMaTK(rs.getString("MaTK"));
                taikhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoan.setPassword(rs.getString("Password"));
                taikhoan.setTenLoaiTK(rs.getString("TenLoaiTK"));
                taikhoans.add(taikhoan);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return taikhoans;
    }

    public Taikhoan SelectTaiKhoan(String maTK){
        Taikhoan tk = null;
        Connection conn = JDBCUtil.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement(sqlGetThongTinTK);
            ps.setString(1, maTK);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String hoTen = rs.getString("HoTen");
                String email = rs.getString("Email");
                String tenDangNhap = rs.getString("TenDangNhap");
                String password = rs.getString("Password");
                String tenLoaiTK = rs.getString("TenLoaiTK");
                String maTK1 = rs.getString("MaTK");
                tk = new Taikhoan(maTK1, tenDangNhap, email, password, hoTen, tenLoaiTK, "TRUE");
            }

        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        }finally {
            JDBCUtil.closeConnection(conn);
        }
        return tk;
    }

    public boolean UpdateTaikhoan(Taikhoan taikhoan) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlEditThongTinTK);
            ps.setString(1, taikhoan.getHoTen());
            ps.setString(2, taikhoan.getTenDangNhap());
            ps.setString(3, taikhoan.getPassword());
            ps.setString(4, taikhoan.getTenLoaiTK());
            ps.setString(5, taikhoan.getEmail());
            ps.setString(6, taikhoan.getMaTK());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    public boolean createNewTaiKhoan(Taikhoan taikhoan) throws SQLException {
        Connection conn = JDBCUtil.getConnection();

        try {
            PreparedStatement taiKhoanStatement = conn.prepareStatement(insertTaiKhoanSql);
            taiKhoanStatement.setString(1, taikhoan.getMaTK());
            taiKhoanStatement.setString(2, taikhoan.getTenDangNhap());
            taiKhoanStatement.setString(3, taikhoan.getEmail());
            taiKhoanStatement.setString(4, taikhoan.getPassword());
            taiKhoanStatement.setString(5, taikhoan.getHoTen());
            taiKhoanStatement.setString(6, taikhoan.getTenLoaiTK());
            taiKhoanStatement.setString(7, taikhoan.getTrangthaiHienThi());

            int rowsInsert = taiKhoanStatement.executeUpdate();
            return rowsInsert > 0;
        }finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    public boolean deleteUser(String maTK) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sqlDeleteThongTinTK);)
        {
            ps.setString(1, maTK);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }




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

