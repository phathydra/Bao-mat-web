package DAO;

import Models.*;
import Util.JDBCUtil;
import Util.HandleExeption;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ThongBaoDAO {
    String sqlGetAllThongBao = "SELECT * FROM thongbao WHERE TrangthaiHienThi = 1 ";
    public List<Thongbao> geAllThongBao()
    {
        List<Thongbao> thongbaos = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
         try {
             PreparedStatement ps = conn.prepareStatement(sqlGetAllThongBao);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 Thongbao thongbao = new Thongbao();
                 thongbao.setMaTB(rs.getString("MaTB"));
                 thongbao.setTenThongBao(rs.getString("TenThongBao"));
                 thongbao.setNgayGui(rs.getDate("NgayGui"));
                 thongbaos.add(thongbao);
             }
         }catch (SQLException e) {
             HandleExeption.printSQLException(e);
         } finally {
             JDBCUtil.closeConnection(conn);
         }
             return thongbaos;
         }
    public Thongbao selectThongBaoByMaTB(String maDT) {
        Thongbao  thongbao = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlSelectThongBaoByMaTB = "SELECT * FROM qlnckh.thongbao WHERE MaTB = ?";
            PreparedStatement ps = conn.prepareStatement(sqlSelectThongBaoByMaTB);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thongbao  = new Thongbao();
                thongbao .setMaTB(rs.getString("MaTB"));
                thongbao .setTenThongBao(rs.getString("TenThongBao"));
                thongbao .setNoiDungTB(rs.getString("NoiDungTB"));
                thongbao .setNgayGui(rs.getDate("NgayGui"));
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return thongbao ;
    }
    public boolean themthongbao(String MaTB, String TenThongBao, String NoiDungTB, Date NgayGui, String matk) throws SQLException {
        String sqlthemthongbao = "INSERT INTO thongbao (MaTB, TenThongBao, NoiDungTB, NgayGui, MaSoQL, MaTK, TrangthaiHienThi)\n" +
                "                VALUES (?, ?, ?, ?, (SELECT MaNQL FROM quanlyhoidong WHERE MaTK = ? ), ?, '1');";
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlthemthongbao);
            ps.setString(1, MaTB);
            ps.setString(2, TenThongBao);
            ps.setString(3, NoiDungTB);
            ps.setDate(4, new java.sql.Date(NgayGui.getTime()));
            ps.setString(5, matk);
            ps.setString(6, matk);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        }  catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return false;
    }
}


