package DAO;
import Models.Khoa;
import Models.Sinhvien;
import Models.Taikhoan;
import Util.JDBCUtil;
import Util.HandleExeption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SinhVienDAO {

    /*
        public Sinhvien selectSinhVienByMaTK(String matk) {
            Sinhvien sinhvien = null;
            Connection conn = JDBCUtil.getConnection();
            try {
                String Select_SinhVien_By_MaTK = "SELECT * FROM sinhvien WHERE MaTK = ?";
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
                    sinhvien.setSdt(rs.getInt("SDT"));
                    sinhvien.setNienKhoa(rs.getString("NienKhoa"));
                    sinhvien.setGioiTinh(rs.getString("GioiTinh"));
                    sinhvien.setMaTK(rs.getString("MaTK"));
                    sinhvien.setMaNhom(rs.getString("MaNhom"));
                }
            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            } finally {
                JDBCUtil.closeConnection(conn);
            }
            return sinhvien;
        }

     */
    public Sinhvien selectSinhVienByMaTK(String matk) {
        Sinhvien sinhvien = null;
        Connection conn = JDBCUtil.getConnection();
        try {

            String Select_SinhVien_By_MaTK = "SELECT s.*, t.TenDangNhap, t.Email, t.Password, t.HoTen, t.TenLoaiTK, k.TenKhoa " +
                    "FROM sinhvien s " +
                    "INNER JOIN taikhoan t ON s.MaTK = t.MaTK " +
                    "INNER JOIN Khoa k ON s.MaKhoa = k.MaKhoa " +
                    "WHERE s.MaTK = ? AND s.TrangthaiHienThi = 1";

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
                sinhvien.setSdt(rs.getInt("SDT"));
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
}


