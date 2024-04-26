package DAO;

import Models.Detai;
import Models.Trangthai;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuanlyhoidongDAO {

    public List<Trangthai> listtrangthai() {
        List<Trangthai> trangthais = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
             String sqlListTrangThai = "SELECT * FROM trangthai WHERE trangthai.TrangthaiHienThi = 1";

            PreparedStatement ps = conn.prepareStatement(sqlListTrangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Trangthai trangthai = new Trangthai();
                trangthai.setMaTrangThai(rs.getString("MaTrangThai"));
                trangthai.setTenTrangThai(rs.getString("TenTrangThai"));

                trangthais.add(trangthai);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return trangthais;
    }

    public boolean update_MaTrangThaiXetDuyet(Detai detai) {
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlUpdate_MaTrangThaiXetDuyet =  "UPDATE detai SET " +
                    " MaTrangThai = ? " +
                    "WHERE MaDT = ?";
            PreparedStatement ps = conn.prepareStatement(sqlUpdate_MaTrangThaiXetDuyet);
            ps.setString(1, detai.getMaTrangThai());
            ps.setString(2, detai.getMaDT());
            System.out.println(ps);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A detai update matrangthai successfully!");
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
