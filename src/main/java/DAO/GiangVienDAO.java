package DAO;

import Models.*;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiangVienDAO {
    String Select_GiangVien_By_MaTK = " SELECT giangvien.* , taikhoan.* , khoa.TenKhoa "+
            "FROM giangvien " +
            "INNER JOIN  taikhoan ON giangvien.MaTK = taikhoan.MaTK " +
            "INNER JOIN  khoa ON giangvien.MaKhoa = khoa.MaKhoa " +
            "WHERE giangvien.MaTK = ? AND giangvien.TrangthaiHienThi = 1" ;

    public Giangvien selectGiangVienByMaTK(String matk) {
        Giangvien giangvien = null;
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(Select_GiangVien_By_MaTK);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                giangvien = new Giangvien();
                giangvien.setMsgv(rs.getString("MSGV"));
                giangvien.setTenGV(rs.getString("TenGV"));
                giangvien.setNgaySinh(rs.getDate("NgaySinh"));
                giangvien.setCccd(rs.getInt("CCCD"));
                giangvien.setMaKhoa(rs.getString("MaKhoa"));
                giangvien.setSdt(rs.getString("Sdt"));
                giangvien.setGioiTinh(rs.getString("GioiTinh"));

                Taikhoan taikhoan = new Taikhoan();
                taikhoan.setEmail(rs.getString("Email"));
                taikhoan.setTenLoaiTK(rs.getString("TenLoaiTK"));
                giangvien.setTaikhoan(taikhoan);

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                giangvien.setKhoa(khoa);

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return giangvien;
    }


    // Ngọc :
    String sqlGetAllGV = "SELECT g.*, k.TenKhoa FROM giangvien g INNER JOIN khoa k ON g.MaKhoa = k.MaKhoa WHERE g.TrangthaiHienThi = 1 ";
    String sqlEditGiangvien = "SELECT g.*, t.Email,  t.TenLoaiTK, k.MaKhoa,  k.TenKhoa FROM giangvien g " +
            "INNER JOIN taikhoan t ON g.MaTK = t.MaTK " +
            "INNER JOIN khoa k ON g.MaKhoa = k.MaKhoa " +
            "WHERE MSGV = ?";
    String sqlUpdateGiangvien = "UPDATE giangvien SET TenGV = ?, CCCD = ?, MaKhoa = ?, NgaySinh = ?, GioiTinh = ? , Sdt = ? , MaHD = ? WHERE MSGV=? ";
    String sqlInsertGiangvien = "INSERT INTO giangvien (MSGV, TenGV, MaKhoa, MaTK, NgaySinh, CCCD, MaHD, GioiTinh, Sdt,  TrangthaiHienThi) VALUES(?,?,?,?,?,?,?,?, ?, ?)";

    String sqlUpdateMaHDGV = "UPDATE giangvien SET MaHD=? WHERE MSGV=?";
    public List<Giangvien> getAllGV() {
        List<Giangvien> giangviens = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllGV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Giangvien giangvien = new Giangvien();
                giangvien.setMsgv(rs.getString("MSGV"));
                giangvien.setTenGV(rs.getString("TenGV"));
                giangvien.setMaKhoa(rs.getString("MaKhoa"));
                giangvien.setMaHD(rs.getString("MaHD"));

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));

                giangvien.setKhoa(khoa);
                giangviens.add(giangvien);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return giangviens;
    }

    public Giangvien ShowFormEditGiangvien(String msgv) {
        Giangvien giangvien = null;
        Connection conn = JDBCUtil.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sqlEditGiangvien);
            ps.setString(1, msgv);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                giangvien = new Giangvien();

                giangvien.setMsgv(rs.getString("MSGV"));
                giangvien.setTenGV(rs.getString("TenGV"));
                giangvien.setMaKhoa(rs.getString("MaKhoa"));
                giangvien.setNgaySinh(rs.getDate("NgaySinh"));
                giangvien.setCccd(rs.getInt("CCCD"));
                giangvien.setMaTK(rs.getString("MaTK"));
                giangvien.setGioiTinh(rs.getString("GioiTinh"));
                giangvien.setSdt(rs.getString("Sdt"));

                Taikhoan taikhoan = new Taikhoan();
                taikhoan.setEmail(rs.getString("Email"));
                taikhoan.setTenLoaiTK(rs.getString("TenLoaiTK"));
                giangvien.setTaikhoan(taikhoan);

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                giangvien.setKhoa(khoa);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return giangvien;
    }

    public boolean UpdateGiangVien(Giangvien gv) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlUpdateGiangvien);
            preparedStatement.setString(1, gv.getTenGV());
            preparedStatement.setInt(2, gv.getCccd());
            preparedStatement.setString(3, gv.getMaKhoa());
            preparedStatement.setDate(4, new java.sql.Date(gv.getNgaySinh().getTime()));
            preparedStatement.setString(5, gv.getGioiTinh());
            preparedStatement.setString(6, gv.getSdt());
            preparedStatement.setString(7, gv.getMaHD());
            preparedStatement.setString(8, gv.getMsgv());
            preparedStatement.executeUpdate();

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("update thanh cong giang vien!");
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
            return false;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return true;
    }
    public List<Hoidong> ListHoiDong() {
        List<Hoidong> hoidongs = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlListHoiDong = "SELECT * FROM hoidong WHERE hoidong.TrangthaiHienThi = 1 ";
            PreparedStatement ps = conn.prepareStatement(sqlListHoiDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Hoidong hoidong = new Hoidong();
                hoidong.setMaHD(rs.getString("MaHD"));
                hoidongs.add(hoidong);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return hoidongs;
    }

    /*
    public boolean UpdateMaHDGiangVien(String MaHD, String MSGV) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlUpdateMaHDGV);
            ps.setString(1, MaHD);
            ps.setString(2, MSGV);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

     */

    public boolean insertGiangVien(Giangvien giangvien) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlInsertGiangvien);
            ps.setString(1, giangvien.getMsgv());
            ps.setString(2, giangvien.getTenGV());
            ps.setString(3, giangvien.getMaKhoa());
            ps.setString(4, giangvien.getMaTK());
            ps.setDate(5, new java.sql.Date(giangvien.getNgaySinh().getTime()));
            ps.setInt(6, giangvien.getCccd());
            ps.setString(7, giangvien.getMaHD());
            ps.setString(8, giangvien.getGioiTinh());
            ps.setString(9, giangvien.getSdt());
            ps.setString(10, giangvien.getTrangthaiHienThi());

            int rowsInsert = ps.executeUpdate();
            return rowsInsert > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    // Hội đồng : Ngọc
    public boolean UpdateMaHDGiangVien(String MaHD, String MSGV) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
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

