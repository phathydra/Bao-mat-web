package DAO;

import Models.Khoa;
import Util.HandleExeption;
import Util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {

    public List<Khoa> selectAllKhoa() {
        List<Khoa> khoas = new ArrayList<>();
        Connection conn = JDBCUtil.getConnection();
        String sqlSelectAllKhoa = " SELECT khoa.* FROM khoa ";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllKhoa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khoa khoa = new Khoa();
                khoa.setMaKhoa(rs.getString("MaKhoa"));
                khoa.setTenKhoa(rs.getString("TenKhoa"));
                khoas.add(khoa);
            }
        } catch (SQLException e) {
            HandleExeption.printSQLException(e);
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return khoas;
    }

}
