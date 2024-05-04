package DAO;

import Models.Bienbannghiemthu;
import Models.Detai;
import Models.Phienthoigian;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Date;
//import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhienthoigianDAO {
    public List<Phienthoigian> laydanhsachphienthoigian()
    {
        List<Phienthoigian> phienthoigians = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        try {
            String sqllayphienthoigian = "SELECT * FROM phienthoigian;";

            PreparedStatement ps = conn.prepareStatement(sqllayphienthoigian);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Phienthoigian phienthoigian = new Phienthoigian();
                phienthoigian.setMaPhienTG(rs.getString("MaPhienTG"));
                phienthoigian.setNgayBatDauDK(rs.getDate("NgayBatDau_DK"));
                phienthoigian.setNgayKetThucDK(rs.getDate("NgayKetThuc_DK"));
                phienthoigian.setNgayBatDauXD(rs.getDate("NgayBatDau_XD"));
                phienthoigian.setNgayKetThucXD(rs.getDate("NgayKetThuc_XD"));
                phienthoigian.setNgayBatDauNT(rs.getDate("NgayBatDau_NT"));
                phienthoigian.setNgayKetThucNT(rs.getDate("NgayKetThuc_NT"));
                phienthoigians.add(phienthoigian);
            }
        }catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return phienthoigians;
    }

    public boolean themphienthoigian(Phienthoigian ptg) throws SQLException {
        String sqlthemphienthoigian = "INSERT INTO phienthoigian (MaPhienTG, NgayBatDau_DK, NgayKetThuc_DK, NgayBatDau_XD, NgayKetThuc_XD, NgayBatDau_NT, NgayKetThuc_NT, TrangthaiHienThi) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, '1');";
        Connection conn = JDBCUtil.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(sqlthemphienthoigian);
            ps.setString(1, ptg.getMaPhienTG());
            ps.setDate(2, ptg.getNgayBatDauDK());
            ps.setDate(3, ptg.getNgayKetThucDK());
            ps.setDate(4, ptg.getNgayBatDauXD());
            ps.setDate(5, ptg.getNgayKetThucXD());
            ps.setDate(6, ptg.getNgayBatDauNT());
            ps.setDate(7, ptg.getNgayKetThucNT());

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
