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

public class DeTaiDAO {
    String sqlGetAllDetai = "SELECT * FROM detai WHERE TrangthaiHienThi = 1 ";
    //String sqlSelectDetaiByMaDT = "SELECT * FROM detai WHERE MaDT = ? AND TrangthaiHienThi = 1";
    String sqlSelectDetaiByMaDT = "SELECT detai.*, nganh.*, trangthai.*, giangvien.* " +
            "FROM detai " +
            "INNER JOIN nganh ON detai.MaNganh = nganh.MaNganh " +
            "INNER JOIN trangthai ON detai.MaTrangThai = trangthai.MaTrangThai " +
            "INNER JOIN giangvien ON detai.MSGV = giangvien.MSGV " +
            "WHERE detai.MaDT = ? AND detai.TrangthaiHienThi = 1";

    String sqlGetAllDetaiCuaToi = "SELECT dt.*, dk.* " +
            "FROM sinhvien sv " +
            "JOIN nhom n ON sv.MaNhom = n.MaNhom " +
            "JOIN dangky dk ON n.MaNhom = dk.MaNhom " +
            "JOIN detai dt ON dk.MaDT = dt.MaDT " +
            "WHERE sv.MaTK = ?";

    public List<Detai> getAllDetai() {
        List<Detai> detais = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllDetai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detai detai = new Detai();
                detai.setMaDT(rs.getString("MaDT"));
                detai.setTenDeTai(rs.getString("TenDeTai"));
                detai.setGhiChu(rs.getString("GhiChu"));
                detai.setMaNganh(rs.getString("MaNganh"));
                detai.setNgayThucHien(rs.getDate("NgayThucHien"));
                detai.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                detai.setKetQua(rs.getString("KetQua"));
                detai.setLinkDeTai(rs.getString("LinkDeTai"));
                detai.setMaTrangThai(rs.getString("MaTrangThai"));
                detai.setMsgv(rs.getString("MSGV"));
                detai.setMaHD(rs.getString("MaHD"));
                detais.add(detai);

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detais;
    }
    public Detai selectDetaiByMaDT(String maDT) {
        Detai detai = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlSelectDetaiByMaDT);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                detai = new Detai();
                detai.setMaDT(rs.getString("MaDT"));
                detai.setTenDeTai(rs.getString("TenDeTai"));
                detai.setGhiChu(rs.getString("GhiChu"));
                detai.setMaNganh(rs.getString("MaNganh"));
                detai.setNgayThucHien(rs.getDate("NgayThucHien"));
                detai.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                detai.setKetQua(rs.getString("KetQua"));
                detai.setLinkDeTai(rs.getString("LinkDeTai"));
                detai.setMaTrangThai(rs.getString("MaTrangThai"));
                detai.setMsgv(rs.getString("MSGV"));
                detai.setMaHD(rs.getString("MaHD"));

                Nganh nganh = new Nganh();
                nganh.setTenNganh(rs.getString("TenNganh"));
                detai.setNganh(nganh);

                Trangthai trangthai = new Trangthai();
                trangthai.setTenTrangThai(rs.getString("TenTrangThai"));
                detai.setTrangthai(trangthai);

                Giangvien giangvien = new Giangvien();
                giangvien.setTenGV(rs.getString("TenGV"));
                detai.setGiangvien(giangvien);


            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detai;
    }

    public List<Detai> getAllDetaiCuaToi(String MaTK) {
        List<Detai> detais = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlGetAllDetaiCuaToi);
            ps.setString(1, MaTK);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detai detai = new Detai();
                detai.setMaDT(rs.getString("MaDT"));
                detai.setTenDeTai(rs.getString("TenDeTai"));
                detai.setGhiChu(rs.getString("GhiChu"));
                detai.setMaNganh(rs.getString("MaNganh"));
                detai.setNgayThucHien(rs.getDate("NgayThucHien"));
                detai.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                detai.setKetQua(rs.getString("KetQua"));
                detai.setLinkDeTai(rs.getString("LinkDeTai"));
                detai.setMaTrangThai(rs.getString("MaTrangThai"));
                detai.setMsgv(rs.getString("MSGV"));
                detai.setMaHD(rs.getString("MaHD"));
                detais.add(detai);

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detais;
    }

    public boolean updateDeTaiDangKyMoi(Detai detai) {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlInsertDetaiMoi =  "UPDATE detai SET " +
                    "GhiChu = ?, MaTrangThai = ?, MSGV = ?, TrangthaiHienThi = ? " +
                    "WHERE MaDT = ?";

            PreparedStatement ps = conn.prepareStatement(sqlInsertDetaiMoi);
            ps.setString(1, detai.getGhiChu());
            ps.setString(2, detai.getMaTrangThai());
            ps.setString(3, detai.getMsgv());
            Boolean trangthaiHienThi = detai.getTrangthaiHienThi();
            boolean boolTrangthaiHienThi = true;
            if (trangthaiHienThi != null) {
                ps.setBoolean(4, boolTrangthaiHienThi);
            } else {

            }
            ps.setString(5, detai.getMaDT());
            System.out.println(ps);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Detai was inserted successfully!");
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
            return false;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return true;
    }


    public boolean update_HuyDeTai(Detai detai) {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlInsertDetaiMoi =  "UPDATE detai SET " +
                    "GhiChu = ?, NgayKetThuc = ?,  MaTrangThai = ?, TrangthaiHienThi = ? " +
                    "WHERE MaDT = ?";
            PreparedStatement ps = conn.prepareStatement(sqlInsertDetaiMoi);
            ps.setString(1, detai.getGhiChu());
            ps.setDate(2, new java.sql.Date(detai.getNgayKetThuc().getTime()));
            ps.setString(3, detai.getMaTrangThai());
            Boolean trangthaiHienThi = detai.getTrangthaiHienThi();
            boolean boolTrangthaiHienThi = true;
            if (trangthaiHienThi != null) {
                ps.setBoolean(4, boolTrangthaiHienThi);
            } else {
            }
            ps.setString(5, detai.getMaDT());
            System.out.println(ps);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Detai was inserted successfully!");
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
            return false;
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return true;
    }



}
