package DAO;

import Models.Giangvien;
import Models.Hoidong;
import Models.Khoa;
import Models.Taikhoan;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoiDongDAO {
    String sqlGetAllHD = "SELECT hd.*, gv.MSGV, gv.TenGV, gv.MaKhoa, gv.MaHD, gv.CCCD, k.TenKhoa FROM hoidong hd " +
            "INNER JOIN giangvien gv ON hd.MaHD = gv.MaHD " +
            "INNER JOIN khoa k ON gv.MaKhoa = k.MaKhoa " +
            "WHERE hd.TrangthaiHienThi = 1";
    String sqlXoaTVHD = "UPDATE giangvien SET TrangthaiHienThi = '0' WHERE MSGV=?";


    public List<Hoidong> getAllThanhVienHD() {
        List<Hoidong> hoidongs = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllHD);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoidong hoidong = new Hoidong();
                hoidong.setMaHD(rs.getString("MaHD"));

                Giangvien giangvien = new Giangvien();
                giangvien.setMsgv(rs.getString("MSGV"));
                giangvien.setTenGV(rs.getString("TenGV"));
                giangvien.setMaHD(rs.getString("MaHD"));
                giangvien.setMaKhoa(rs.getString("MaKhoa"));
                giangvien.setCccd(rs.getInt("CCCD"));

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));

                hoidong.setKhoa(khoa);
                hoidong.setGiangvien(giangvien);
                hoidongs.add(hoidong);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return hoidongs;
    }

    public boolean XoaTVHoiDong(String msgv) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlXoaTVHD);
            ps.setString(1, msgv);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }


    // for : Ngọc
    public Giangvien GetThongTinGiangvien(String msgv) {
        Giangvien gv = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlEditGiangvien = "SELECT g.*, t.TenDangNhap, t.Email, t.Password, t.HoTen, t.TenLoaiTK, k.TenKhoa FROM giangvien g " +
                    "INNER JOIN taikhoan t ON g.MaTK = t.MaTK " +
                    "INNER JOIN khoa k ON g.MaKhoa = k.MaKhoa " +
                    "WHERE MSGV = ?";
            PreparedStatement ps = conn.prepareStatement(sqlEditGiangvien);
            ps.setString(1, msgv);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String msgv1 = rs.getString("MSGV");
                String tenGV = rs.getString("TenGV");
                String maKhoa = rs.getString("MaKhoa");
                Date ngaySinh = rs.getDate("NgaySinh");
                Integer cccd = rs.getInt("CCCD");
                String maHD = rs.getString("MaHD");
                String maTK = rs.getString("MaTK");

                Taikhoan taikhoan = null;
                String maTK1 = rs.getString("MaTK");
                String tenDangNhap = rs.getString("TenDangNhap");
                String email = rs.getString("Email");
                String password = rs.getString("Password");
                String hoTen1 = rs.getString("HoTen");
                String tenLoaiTK = rs.getString("TenLoaiTK");

                Khoa khoa = null;
                String maKhoa1 = rs.getString("MaKhoa");
                String tenKhoa = rs.getString("TenKhoa");

                taikhoan = new Taikhoan(maTK1, tenDangNhap, email, password, hoTen1, tenLoaiTK, "TRUE");
                khoa = new Khoa(maKhoa1, tenKhoa, "TRUE");
                gv = new Giangvien(msgv1, tenGV, maKhoa, maTK, ngaySinh, cccd, maHD, "TRUE");
                gv.setTaikhoan(taikhoan);
                gv.setKhoa(khoa);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return gv;
    }
    public boolean UpdateMaHDGiangVien(String MaHD, String MSGV) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlUpdateMaHDGV = "UPDATE giangvien SET MaHD=? WHERE MSGV=?";
            PreparedStatement ps = conn.prepareStatement(sqlUpdateMaHDGV);
            ps.setString(1, MaHD);
            ps.setString(2, MSGV);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }




}
