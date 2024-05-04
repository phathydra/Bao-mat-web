package DAO;

import Models.*;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BienbannghiemthuDAO {
    public boolean NghiemThu(Bienbannghiemthu bbcdc) throws SQLException {
        String UpdateDuyet = "UPDATE bienbannghiemthu SET Diem = ?, NhanXet = ?, LinkBB = ? WHERE MaDT = ?";

        String updateTrangThai = "UPDATE detai SET MaTrangThai = 'MTT007' WHERE MaDT = ?";
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(UpdateDuyet);
            ps.setInt(1, bbcdc.getDiem());
            ps.setString(2, bbcdc.getNhanXet());
            ps.setString(3, bbcdc.getLinkBB());
            ps.setString(4, bbcdc.getMaDT());


            PreparedStatement ps2 = conn.prepareStatement(updateTrangThai);
            ps2.setString(1, bbcdc.getMaDT());
            ps2.executeUpdate();

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        }  catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean PhanCongNghiemThu(Bienbannghiemthu bbcdc) throws SQLException {
        String phancongnghiemthu = "INSERT INTO bienbannghiemthu (FullName, BirthDate, Address, Phone, Email, Password, Role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(phancongnghiemthu);
            ps.setInt(1, bbcdc.getDiem());
            ps.setString(2, bbcdc.getNhanXet());
            ps.setString(3, bbcdc.getLinkBB());
            ps.setString(4, bbcdc.getMaDT());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        }  catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return false;
    }

    public Bienbannghiemthu SelectBienBanNTByMaDT(String maDT) {
        Bienbannghiemthu bbnt = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlSelectBienBanNTByMaDT = "SELECT bbnt.* FROM "+
                    "bienbannghiemthu bbnt "+
                    "WHERE bbnt.MaDT = ? ";

            PreparedStatement ps = conn.prepareStatement(sqlSelectBienBanNTByMaDT);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bbnt = new Bienbannghiemthu();
                bbnt.setDiem(rs.getInt("Diem"));
                bbnt.setLinkBB(rs.getString("LinkBB"));
                bbnt.setNhanXet(rs.getString("NhanXet"));

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return bbnt;
    }
}
