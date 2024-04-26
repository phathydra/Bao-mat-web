package DAO;

import Models.*;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HoidongnghiemthuDAO {
    public List<Detai> laydetaiphancongnghiemthu()
    {
        List<Detai> detainghiemthus = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlGetAllDeTaiNghiemThu = "SELECT dt.*\n" +
                    "FROM \n" +
                    " detai dt  WHERE dt.MaTrangThai = 'MTT001' ";

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

    public Detai selectDeTaiByMaDT(String madt) {
        Detai chitietdetai = null;
        Connection conn = JDBCUtil.getConnection();
        try {
            String Select_DeTai_By_MaTK = "SELECT * From detai where MaDT = ? ";
            PreparedStatement ps = conn.prepareStatement(Select_DeTai_By_MaTK);
            ps.setString(1, madt);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                chitietdetai = new Detai();
                chitietdetai.setMaDT(rs.getString("MaDT"));
                chitietdetai.setTenDeTai(rs.getString("TenDeTai"));
                chitietdetai.setGhiChu(rs.getString("GhiChu"));
                chitietdetai.setNgayThucHien(rs.getDate("NgayThucHien"));
                chitietdetai.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                chitietdetai.setLinkDeTai(rs.getString("LinkDeTai"));
                chitietdetai.setKetQua(rs.getString("KetQua"));
                chitietdetai.setMsgv(rs.getString("MSGV"));
                chitietdetai.setMaNganh(rs.getString("MaNganh"));
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return chitietdetai;
    }
    public boolean PhanCongNghiemThu(Bienbannghiemthu bbcdc) throws SQLException {
        String phancongnghiemthu = "INSERT INTO bienbannghiemthu (MaChamNT, MaHDNT, MaDT, TrangthaiHienThi) " +
                "VALUES (?, ?, ?, '1')";
        String updateTrangThai = "UPDATE detai SET MaTrangThai = 'MTT010' WHERE MaDT = ?";

        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        boolean success = false;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            ps1 = conn.prepareStatement(phancongnghiemthu);
            ps1.setString(1, bbcdc.getMaChamNT());
            ps1.setString(2, bbcdc.getMaHDNT());
            ps1.setString(3, bbcdc.getMaDT());

            ps2 = conn.prepareStatement(updateTrangThai);
            ps2.setString(1, bbcdc.getMaDT());

            int rowsUpdated1 = ps1.executeUpdate();
            int rowsUpdated2 = ps2.executeUpdate();

            if (rowsUpdated1 > 0 && rowsUpdated2 > 0) {
                conn.commit(); // Xác nhận giao dịch thành công
                success = true;
            } else {
                conn.rollback(); // Hoàn tác giao dịch
            }
        } catch (SQLException e) {
            conn.rollback(); // Hoàn tác giao dịch trong trường hợp xảy ra lỗi
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }

        return success;
    }
    public List<Detai> laydetaiphancongduyetdecuong()
    {
        List<Detai> detaiduyetdecuongs = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqlGetAllDeTaiDuyet = "SELECT * FROM detai dt\n" +
                    " WHERE dt.MaTrangThai = 'MTT002'";

            PreparedStatement ps = conn.prepareStatement(sqlGetAllDeTaiDuyet);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Detai detaixetduyetdecuong = new Detai();
                detaixetduyetdecuong.setMaDT(rs.getString("MaDT"));
                detaixetduyetdecuong.setTenDeTai(rs.getString("TenDeTai"));
                detaixetduyetdecuong.setMsgv(rs.getString("MSGV"));
                detaixetduyetdecuong.setLinkDeTai(rs.getString("LinkDeTai"));
                detaixetduyetdecuong.setKetQua(rs.getString("KetQua"));
                detaiduyetdecuongs.add(detaixetduyetdecuong);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return detaiduyetdecuongs;
    }
    public void phancongduyetdecuong(String MaChamDC, String MaDDC, String madt) throws SQLException {
        String insertBienBan = "INSERT INTO bienbanchamdecuong (MaChamDC, MaDDC, MaDK, TrangthaiHienThi) " +
                "VALUES (?, ?, (SELECT dangky.MaDK FROM dangky INNER JOIN detai ON dangky.MaDT = detai.MaDT WHERE dangky.MaDT = ?), '1')";

        String updateTrangThai = "UPDATE detai SET MaTrangThai = 'MTT009' WHERE MaDT = ?";

        Connection conn = JDBCUtil.getConnection();
        try {
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            // Thực hiện lệnh INSERT
            PreparedStatement ps1 = conn.prepareStatement(insertBienBan);
            ps1.setString(1, MaChamDC);
            ps1.setString(2, MaDDC);
            ps1.setString(3, madt);
            ps1.executeUpdate();

            // Thực hiện lệnh UPDATE
            PreparedStatement ps2 = conn.prepareStatement(updateTrangThai);
            ps2.setString(1, madt);
            ps2.executeUpdate();

            conn.commit(); // Xác nhận giao dịch thành công
        } catch (SQLException e) {
            conn.rollback(); // Hoàn tác giao dịch trong trường hợp xảy ra lỗi
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
    }

}
