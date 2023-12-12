package DAO;
import Models.*;
import Util.JDBCUtil;
import Util.HandleExeption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DangKyDAO {

    String sqlSelectDangKiByMaDT = "SELECT dangky.*, sinhvien.*, khoa.* " +
            "FROM dangky " +
            "INNER JOIN sinhvien ON dangky.MaNhom = sinhvien.MaNhom " +
            "INNER JOIN khoa ON sinhvien.MaKhoa = khoa.MaKhoa " +
            "WHERE dangky.MaDT = ? AND dangky.TrangthaiHienThi = 1";

    String sqlListThanhVienNhomDangKiByMaTK =  "SELECT sinhvien.*, khoa.TenKhoa " +
            "FROM sinhvien " +
            "INNER JOIN khoa ON sinhvien.MaKhoa = khoa.MaKhoa " +
            "WHERE MaNhom IN (SELECT MaNhom FROM sinhvien WHERE MaTK = ?) AND sinhvien.TrangthaiHienThi = 1";

    String sqlListGiangVien =  "SELECT giangvien.*, khoa.TenKhoa " +
            "FROM giangvien " +
            "INNER JOIN khoa ON giangvien.MaKhoa = khoa.MaKhoa " +
            "WHERE giangvien.TrangthaiHienThi = 1";

    String sqlListDeTaiDangKy = "SELECT detai.*, nganh.TenNganh, trangthai.TenTrangThai " +
            "FROM detai " +
            "INNER JOIN nganh ON detai.MaNganh = nganh.MaNganh " +
            "INNER JOIN trangthai ON detai.MaTrangThai = trangthai.MaTrangThai " +
            "WHERE detai.MaTrangThai LIKE 'MTTCDK' AND detai.TrangthaiHienThi = 1";



    public List<Dangky> SelectNhomDangKiByMaDT(String maDT) {
        List<Dangky> nhomdangkys = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlSelectDangKiByMaDT);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            while  (rs.next()) {
                Dangky thanhviennhomdangky = new Dangky();
                thanhviennhomdangky.setMaDK(rs.getString("MaDK"));
                thanhviennhomdangky.setMaNhom(rs.getString("MaNhom"));

                Sinhvien sinhvienthamgia = new Sinhvien();
                sinhvienthamgia.setMssv(rs.getString("MSSV"));
                sinhvienthamgia.setHoTen(rs.getString("HoTen"));
                // be careful this is the way call the variables khoa in SinhVien extend  ***
                sinhvienthamgia.setMaKhoa(rs.getString("MaKhoa"));

                // không trỏ tới biến Khoa trong sinhvien khi gọi trên biến sql
                // mặc dù biến khoa đã được khởi tạo dưới Models
                Khoa khoa  = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                sinhvienthamgia.setKhoa(khoa);
                //
                sinhvienthamgia.setNgaySinh(rs.getDate("NgaySinh"));
                sinhvienthamgia.setNienKhoa(rs.getString("NienKhoa"));
                sinhvienthamgia.setGioiTinh(rs.getString("GioiTinh"));
                thanhviennhomdangky.setSinhvien(sinhvienthamgia);
                nhomdangkys.add(thanhviennhomdangky);

                // nhom.sinhvienthamgia
                // nhom.sinhvienthamgia.khoa.

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return nhomdangkys ;
    }
    public List<Sinhvien> ListThanhVienNhomDangKiByMaTK(String maTK) {
        List<Sinhvien> sinhviens = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlListThanhVienNhomDangKiByMaTK);
            ps.setString(1, maTK);
            ResultSet rs = ps.executeQuery();
            while  (rs.next()) {

                Sinhvien sinhvienthamgia = new Sinhvien();
                sinhvienthamgia.setMaNhom(rs.getString("MaNhom"));
                sinhvienthamgia.setMssv(rs.getString("MSSV"));
                sinhvienthamgia.setHoTen(rs.getString("HoTen"));
                // be careful this is the way call the variables khoa in SinhVien extend  ***
                sinhvienthamgia.setMaKhoa(rs.getString("MaKhoa"));

                // không trỏ tới biến Khoa trong sinhvien khi gọi trên biến sql
                // mặc dù biến khoa đã được khởi tạo dưới Models
                Khoa khoa  = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                sinhvienthamgia.setKhoa(khoa);
                //
                sinhvienthamgia.setNgaySinh(rs.getDate("NgaySinh"));
                sinhvienthamgia.setGioiTinh(rs.getString("GioiTinh"));
                sinhviens.add(sinhvienthamgia);

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return sinhviens ;
    }

    public List<Giangvien> ListGiangVienHuongDan()
    {
        List<Giangvien> giangviens = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlListGiangVien);
            ResultSet rs = ps.executeQuery();
            while  (rs.next()) {
                Giangvien giangvienhuongdan = new Giangvien();
                giangvienhuongdan.setMsgv(rs.getString("MSGV"));
                giangvienhuongdan.setTenGV(rs.getString("TenGV"));
                giangvienhuongdan.setNgaySinh(rs.getDate("NgaySinh"));
                // khoa
                Khoa khoa = new Khoa();
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                giangvienhuongdan.setKhoa(khoa);
                giangviens.add(giangvienhuongdan);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return giangviens;
    }
     // đăng ký đề tài mới
    public List<Detai> ListDeTaiDangKy() {
        List<Detai> detais = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlListDeTaiDangKy);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detai detai = new Detai();
                detai.setMaDT(rs.getString("MaDT"));
                detai.setTenDeTai(rs.getString("TenDeTai"));

                Trangthai trangthai = new Trangthai();
                trangthai.setTenTrangThai(rs.getString("TenTrangThai"));
                detai.setTrangthai(trangthai);

                Nganh nganh = new Nganh();
                nganh.setTenNganh(rs.getString("TenNganh"));
                detai.setNganh(nganh);
                detais.add(detai);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detais;
    }
    public boolean insertDangKyMoi(Dangky dangky) {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlInsertDangKyMoi = "INSERT INTO dangky " +
                    "(MaDK, MaDT, MaNhom, GhiChu, MaHD, LinkDeCuong, TrangThai, MSGV, NgayDangKy, TrangthaiHienThi) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sqlInsertDangKyMoi);
            ps.setString(1, dangky.getMaDK());
            ps.setString(2, dangky.getMaDT());
            ps.setString(3, dangky.getMaNhom());
            ps.setString(4, dangky.getGhiChu());
            ps.setString(5, dangky.getMaHD());
            ps.setString(6, dangky.getLinkDeCuong());
            String trangthaimd = "Chờ duyệt";
            ps.setString(7,trangthaimd);
            ps.setString(8, dangky.getMsgv());

            ps.setDate(9, new java.sql.Date(dangky.getNgayDangKy().getTime()));
            Boolean trangthaiHienThi = dangky.getTrangthaiHienThi();
            boolean boolTrangthaiHienThi = true;
            if (trangthaiHienThi != null) {
                ps.setBoolean(10, boolTrangthaiHienThi);
            } else
            {
                //ps.setBoolean(10, boolTrangthaiHienThi);
            }

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new registration was inserted successfully!");
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
            return false;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return true;
    }

    // huy de tai

        public List<Detai> ListDeTaiDaDK(String MaTK) {
            List<Detai> detais = new ArrayList<>();
            Connection conn = JDBCUtil.getConnection();
            try {
                String sqlLisDeTaiDaDK =
                        "SELECT dt.*, dk.*, nganh.TenNganh, trangthai.TenTrangThai, giangvien.TenGV " +
                                "FROM sinhvien sv " +
                                "JOIN nhom n ON sv.MaNhom = n.MaNhom " +
                                "JOIN dangky dk ON n.MaNhom = dk.MaNhom " +
                                "JOIN detai dt ON dk.MaDT = dt.MaDT " +
                                "INNER JOIN nganh ON dt.MaNganh = nganh.MaNganh " +
                                "INNER JOIN trangthai ON dt.MaTrangThai = trangthai.MaTrangThai " +
                                "INNER JOIN giangvien ON dt.MSGV = giangvien.MSGV " +
                                "WHERE sv.MaTK = ? AND " +
                                "(dt.MaTrangThai LIKE 'MTT001' OR dt.MaTrangThai LIKE 'MTT002') AND " +
                                "dt.TrangthaiHienThi = 1";


                PreparedStatement ps = conn.prepareStatement(sqlLisDeTaiDaDK);
                ps.setString(1, MaTK);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Detai detai = new Detai();
                    detai.setMaDT(rs.getString("MaDT"));
                    detai.setTenDeTai(rs.getString("TenDeTai"));

                    Trangthai trangthai = new Trangthai();
                    trangthai.setTenTrangThai(rs.getString("TenTrangThai"));
                    detai.setTrangthai(trangthai);

                    Nganh nganh = new Nganh();
                    nganh.setTenNganh(rs.getString("TenNganh"));
                    detai.setNganh(nganh);

                    Giangvien giangvien = new Giangvien();
                    giangvien.setTenGV(rs.getString("TenGV"));
                    detai.setGiangvien(giangvien);
                    detais.add(detai);
                }
            } catch (SQLException e) {
                HandleExeption.printSQLException(e);
            } finally {
                JDBCUtil.closeConnection(conn);
            }
            return detais;
        }

    }

