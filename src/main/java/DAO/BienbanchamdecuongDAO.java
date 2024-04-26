package DAO;
import Models.Bienbanchamdecuong;
import Models.Bienbannghiemthu;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BienbanchamdecuongDAO {
    public void updatebienbanchamdecuong(String xetduyet, String linkbb, String madt) throws SQLException {
        String UpdateDuyet = "UPDATE bienbanchamdecuong\n" +
                "INNER JOIN dangky ON bienbanchamdecuong.MaDK = dangky.MaDK\n" +
                "INNER JOIN detai ON dangky.MaDT = detai.MaDT\n" +
                "SET bienbanchamdecuong.XetDuyet = ? , bienbanchamdecuong.LinkBB = ? \n" +
                "WHERE detai.MaDT = ? ;";

        String updateTrangThai = "UPDATE detai SET MaTrangThai = 'MTT001' WHERE MaDT = ?";
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(UpdateDuyet);
            ps.setString(1, xetduyet);
            ps.setString(2, linkbb);
            ps.setString(3, madt);

            int rowsUpdated = ps.executeUpdate();
            if (xetduyet.equals("duyet")) {
                PreparedStatement ps2 = conn.prepareStatement(updateTrangThai);
                ps2.setString(1, madt);
                ps2.executeUpdate();
            }

        }  catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }

    }
    public Bienbanchamdecuong SelectBienBanCDDCByMaDT(String maDT) {
        Bienbanchamdecuong bbcdc = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlSelectBienBanCDDCByMaDT = "SELECT bbcdc.* FROM "+
                    "bienbanchamdecuong bbcdc JOIN dangky dk ON bbcdc.MaDK = dk.MaDK "+
                    "JOIN detai dt ON dk.MaDT = dt.MaDT WHERE dt.MaDT = ? AND bbcdc.TrangthaiHienThi = 1 ";

            PreparedStatement ps = conn.prepareStatement(sqlSelectBienBanCDDCByMaDT);
            ps.setString(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                bbcdc = new Bienbanchamdecuong();
                bbcdc.setXetDuyet(rs.getString("XetDuyet"));
                bbcdc.setLinkBB(rs.getString("LinkBB"));

            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return  bbcdc;
    }



}
