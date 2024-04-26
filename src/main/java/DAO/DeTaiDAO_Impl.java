package DAO;

import Models.*;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeTaiDAO_Impl {

    //String sqlGetAllDeTai = "SELECT * FROM detai WHERE TrangthaiHienThi = 1 ";
    ///
    String sqlGetAllDeTaiHuongDan =
            "SELECT dt.*, gv.*, tk.* , trangthai.TenTrangThai " +
                    "FROM detai dt " +
                    "INNER JOIN giangvien gv ON dt.MSGV = gv.MSGV " +
                    "INNER JOIN trangthai ON dt.MaTrangThai = trangthai.MaTrangThai " +
                    "INNER JOIN taikhoan tk ON gv.MaTK = tk.MaTK " +
                    "WHERE tk.MaTK = ? AND dt.TrangthaiHienThi = 1 ";


    String sqlGetAllDeTaiDuyetDeCuong = "SELECT tk.*, gv.*, hddd.*, bbcdc.*, dk.*, dt.*\n" +
            "FROM taikhoan tk\n" +
            "INNER JOIN giangvien gv ON tk.MaTK = gv.MaTK\n" +
            "INNER JOIN hoidongduyetdecuong hddd ON gv.MaHD = hddd.MaHD\n" +
            "INNER JOIN bienbanchamdecuong bbcdc ON hddd.MaDDC = bbcdc.MaDDC\n" +
            "INNER JOIN dangky dk ON bbcdc.MaDK = dk.MaDK\n" +
            "INNER JOIN detai dt ON dk.MaDT = dt.MaDT Where tk.MaTK = ? AND dt.TrangthaiHienThi = 1";

    String sqlGetAllDeTaiNghiemThu = "SELECT tk.*, gv.*, hdnt.*, bbnt.*, dt.*\n" +
            "FROM taikhoan tk\n" +
            "INNER JOIN giangvien gv ON tk.MaTK = gv.MaTK\n" +
            "INNER JOIN hoidongnghiemthu hdnt ON gv.MaHD = hdnt.MaHD\n" +
            "INNER JOIN bienbannghiemthu bbnt ON hdnt.MaHDNT = bbnt.MaHDNT\n" +
            "INNER JOIN detai dt ON bbnt.MaDT = dt.MaDT Where tk.MaTK = ? ";
/*
    public List<Detai> geAllDetai()
    {
        List<Detai> detais = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Detai detai = new Detai();
                detai.setMaDT(rs.getString("MaDT"));
                detai.setTenDeTai(rs.getString("TenDeTai"));
                detai.setMsgv(rs.getString("MSGV"));
                detai.setKetQua(rs.getString("KetQua"));
                detais.add(detai);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detais;
    }
    */


    public List<Detai> geAllDetaiHuongDan(String matk)
    {
        List<Detai> detaihuongdans = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTaiHuongDan);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detai detaihuongdan = new Detai();
                detaihuongdan.setMaDT(rs.getString("MaDT"));
                detaihuongdan.setTenDeTai(rs.getString("TenDeTai"));

                Trangthai trangthai = new Trangthai();
                trangthai.setTenTrangThai(rs.getString("TenTrangThai"));
                detaihuongdan.setTrangthai(trangthai);
                detaihuongdans.add(detaihuongdan);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detaihuongdans;
    }

    public List<Detai> geAllDetaiDuyetdecuong(String matk)
    {
        List<Detai> detaiduyetdecuongs = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTaiDuyetDeCuong);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detai detaiduyetdecuong = new Detai();
                detaiduyetdecuong.setMaDT(rs.getString("MaDT"));
                detaiduyetdecuong.setTenDeTai(rs.getString("TenDeTai"));
                detaiduyetdecuong.setMsgv(rs.getString("MSGV"));
                detaiduyetdecuong.setKetQua(rs.getString("KetQua"));
                detaiduyetdecuongs.add(detaiduyetdecuong);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detaiduyetdecuongs;
    }

    public List<Detai> geAllDetaiNghiemthu(String matk)
    {
        List<Detai> detainghiemthus = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTaiNghiemThu);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detai detainghiemthu = new Detai();
                detainghiemthu.setMaDT(rs.getString("MaDT"));
                detainghiemthu.setTenDeTai(rs.getString("TenDeTai"));
                detainghiemthu.setMsgv(rs.getString("MSGV"));
                detainghiemthu.setKetQua(rs.getString("KetQua"));
                detainghiemthus.add(detainghiemthu);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detainghiemthus;
    }

    public List<Detai> laydetaiphancongnghiemthu()
    {
        List<Detai> detainghiemthus = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlGetAllDeTaiNghiemThu = "SELECT bbnt.*, dt.*\n" +
                    "FROM bienbannghiemthu bbnt\n" +
                    "INNER JOIN detai dt ON bbnt.MaDT = dt.MaDT";

            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTaiNghiemThu);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detai detainghiemthu = new Detai();
                detainghiemthu.setMaDT(rs.getString("MaDT"));
                detainghiemthu.setTenDeTai(rs.getString("TenDeTai"));
                detainghiemthu.setMsgv(rs.getString("MSGV"));
                detainghiemthu.setKetQua(rs.getString("KetQua"));
                detainghiemthus.add(detainghiemthu);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detainghiemthus;
    }
}
