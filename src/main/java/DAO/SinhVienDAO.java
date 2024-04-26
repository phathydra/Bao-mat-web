package DAO;
import Models.*;
import Util.JDBCUtil;
import Util.HandleExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    // phân quyền sinh viên :
    String Select_SinhVien_By_MaTK = "SELECT s.*, t.TenDangNhap, t.Email, t.Password, t.HoTen, t.TenLoaiTK, k.TenKhoa " +
            "FROM sinhvien s " +
            "INNER JOIN taikhoan t ON s.MaTK = t.MaTK " +
            "INNER JOIN Khoa k ON s.MaKhoa = k.MaKhoa " +
            "WHERE s.MaTK = ? AND s.TrangthaiHienThi = 1";

    // Phân quyền giảng viên :
    String Select_SinhVien_By_MaDT = "SELECT *\n" +
            "FROM detai\n" +
            "JOIN dangky ON detai.MaDT = dangky.MaDT\n" +
            "JOIN sinhvien ON dangky.MaNhom = sinhvien.MaNhom where detai.MaDT = ? ";

    public Sinhvien selectSinhVienByMaTK(String matk) {
        Sinhvien sinhvien = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(Select_SinhVien_By_MaTK);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sinhvien = new Sinhvien();
                sinhvien.setMssv(rs.getString("MSSV"));
                sinhvien.setHoTen(rs.getString("HoTen"));
                sinhvien.setMaKhoa(rs.getString("MaKhoa"));
                sinhvien.setNgaySinh(rs.getDate("NgaySinh"));
                sinhvien.setCccd(rs.getInt("CCCD"));
                sinhvien.setStk(rs.getInt("STK"));
                sinhvien.setSdt(rs.getString("SDT"));
                sinhvien.setNienKhoa(rs.getString("NienKhoa"));
                sinhvien.setGioiTinh(rs.getString("GioiTinh"));
                sinhvien.setMaTK(rs.getString("MaTK"));
                sinhvien.setMaNhom(rs.getString("MaNhom"));

                Taikhoan taikhoan = new Taikhoan();
                taikhoan.setMaTK(rs.getString("MaTK"));
                taikhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taikhoan.setEmail(rs.getString("Email"));
                taikhoan.setPassword(rs.getString("Password"));
                taikhoan.setHoTen(rs.getString("HoTen"));
                taikhoan.setTenLoaiTK(rs.getString("TenLoaiTK"));
                // set tài khoản
                sinhvien.setTaikhoan(taikhoan);

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                sinhvien.setKhoa(khoa);


            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return sinhvien;
    }
    public List<Sinhvien> layNhomsinhvienbyMaDT(String madt) {
        List<Sinhvien> sinhvientheonhom = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(Select_SinhVien_By_MaDT);
            ps.setString(1, madt);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sinhvien sinhvien = new Sinhvien();
                sinhvien.setMssv(rs.getString("MSSV"));
                sinhvien.setHoTen(rs.getString("HoTen"));
                sinhvien.setMaKhoa(rs.getString("MaKhoa"));
                sinhvientheonhom.add(sinhvien);

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return sinhvientheonhom;
    }

    // AD: Ngọc

    String sqlGetAllSinhvien = "SELECT sv.*, k.TenKhoa FROM sinhvien sv INNER JOIN khoa k ON sv.MaKhoa = k.MaKhoa WHERE sv.TrangthaiHienThi = 1 ";
    String sqlEditSinhvien = "SELECT s.*, t.TenDangNhap, t.Email, t.Password, t.HoTen, t.TenLoaiTK, k.TenKhoa FROM sinhvien s " +
            "INNER JOIN taikhoan t ON s.MaTK = t.MaTK " +
            "INNER JOIN khoa k ON s.MaKhoa = k.MaKhoa WHERE MSSV = ?";

    String sqlUpdateSinhvien = "UPDATE sinhvien SET HoTen=?, CCCD=?, GioiTinh=?, STK=?, SDT=?, NienKhoa=?, NgaySinh=?, MaKhoa=? WHERE MSSV=?";
    String sqlInsertSinhVien = "INSERT INTO sinhvien (MSSV, HoTen, MaKhoa, NgaySinh, CCCD, STK, SDT, NienKhoa, GioiTinh, MaTK, MaNhom, TrangthaiHienThi) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

    public List<Sinhvien> getAllSinhvien() {
        List<Sinhvien> sinhviens = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllSinhvien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Sinhvien sinhvien = new Sinhvien();
                sinhvien.setMssv(rs.getString("MSSV"));
                sinhvien.setHoTen(rs.getString("HoTen"));
                sinhvien.setNienKhoa(rs.getString("NienKhoa"));
                sinhvien.setMaKhoa(rs.getString("MaKhoa"));

                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));

                sinhvien.setKhoa(khoa);
                sinhviens.add(sinhvien);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return sinhviens;
    }

    public Sinhvien GetAllThongTinGV(String mssv) {
        Sinhvien sv = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlEditSinhvien);
            ps.setString(1, mssv);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String mssv1 = rs.getString("MSSV");
                String hoTen = rs.getString("HoTen");
                String maKhoa = rs.getString("MaKhoa");
                Date ngaySinh = rs.getDate("NgaySinh");
                Integer cccd = rs.getInt("CCCD");
                Integer stk = rs.getInt("STK");
                String sdt = rs.getString("SDT");
                String nienKhoa = rs.getString("NienKhoa");
                String gioiTinh = rs.getString("GioiTinh");
                String maTK = rs.getString("MaTK");
                String maNhom = rs.getString("MaNhom");

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
                khoa = new Khoa(maKhoa1, tenKhoa);
                sv = new Sinhvien(mssv1, hoTen, maKhoa, ngaySinh, cccd, stk, sdt, nienKhoa, gioiTinh, maTK, maNhom, "TRUE");
                sv.setTaikhoan(taikhoan);
                sv.setKhoa(khoa);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return sv;
    }

    public boolean UpdateSinhVien(Sinhvien sinhvien) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlUpdateSinhvien);
            ps.setString(1, sinhvien.getHoTen());
            ps.setInt(2, sinhvien.getCccd());
            ps.setString(3, sinhvien.getGioiTinh());
            ps.setInt(4, sinhvien.getStk());
            ps.setString(5, sinhvien.getSdt());
            ps.setString(6, sinhvien.getNienKhoa());
            ps.setDate(7, new java.sql.Date(sinhvien.getNgaySinh().getTime()));
            ps.setString(8, sinhvien.getMaKhoa());
            ps.setString(9, sinhvien.getMssv());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

    public boolean insertSinhvien(Sinhvien sinhvien) throws SQLException {
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlInsertSinhVien);
            ps.setString(1, sinhvien.getMssv());
            ps.setString(2, sinhvien.getHoTen());
            ps.setString(3, sinhvien.getMaKhoa());
            ps.setDate(4, new java.sql.Date(sinhvien.getNgaySinh().getTime()));
            ps.setInt(5, sinhvien.getCccd());
            ps.setInt(6, sinhvien.getStk());
            ps.setString(7, sinhvien.getSdt());
            ps.setString(8, sinhvien.getNienKhoa());
            ps.setString(9, sinhvien.getGioiTinh());
            ps.setString(10, sinhvien.getMaTK());
            ps.setString(11, sinhvien.getMaNhom());
            ps.setString(12, sinhvien.getTrangthaiHienThi());

            int rowsInsert = ps.executeUpdate();
            return rowsInsert > 0;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }
    public List<Nhom> ListNhom() {
        List<Nhom> nhoms = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlListHoiDong = "SELECT * FROM nhom WHERE nhom.TrangthaiHienThi = 1 ";
            PreparedStatement ps = conn.prepareStatement(sqlListHoiDong);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nhom nhom = new Nhom();
                nhom.setMaNhom(rs.getString("MaNhom"));
                nhoms.add(nhom);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return nhoms;
    }



}


