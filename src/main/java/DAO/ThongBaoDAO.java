package DAO;

import Models.Thongbao;
import Util.JDBCUtil;
import Util.HandleExeption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    }

