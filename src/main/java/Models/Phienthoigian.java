package Models;
import java.io.Serializable;
//import java.util.Date;
import java.sql.Date;

public class Phienthoigian implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maPhienTG;
    private Date ngayBatDauDK;
    private Date ngayKetThucDK;
    private Date ngayBatDauXD;
    private Date ngayKetThucXD;
    private Date ngayBatDauNT;
    private Date ngayKetThucNT;
    private String trangthaiHienThi;
    
   

	public Phienthoigian() {
		super();
	}

    public Phienthoigian(String maPhienTG, java.sql.Date ngayBatDauDK, java.sql.Date ngayKetThucDK, java.sql.Date ngayBatDauXD, java.sql.Date ngayKetThucXD,
                         java.sql.Date ngayBatDauNT, java.sql.Date ngayKetThucNT, String trangthaiHienThi) {
        super();
        this.maPhienTG = maPhienTG;
        this.ngayBatDauDK = ngayBatDauDK;
        this.ngayKetThucDK = ngayKetThucDK;
        this.ngayBatDauXD = ngayBatDauXD;
        this.ngayKetThucXD = ngayKetThucXD;
        this.ngayBatDauNT = ngayBatDauNT;
        this.ngayKetThucNT = ngayKetThucNT;
        this.trangthaiHienThi = trangthaiHienThi;
    }
    public Phienthoigian(String maPhienTG, java.sql.Date ngayBatDauDK, java.sql.Date ngayKetThucDK, java.sql.Date ngayBatDauXD, java.sql.Date ngayKetThucXD,
                         java.sql.Date ngayBatDauNT, java.sql.Date ngayKetThucNT) {
        super();
        this.maPhienTG = maPhienTG;
        this.ngayBatDauDK = ngayBatDauDK;
        this.ngayKetThucDK = ngayKetThucDK;
        this.ngayBatDauXD = ngayBatDauXD;
        this.ngayKetThucXD = ngayKetThucXD;
        this.ngayBatDauNT = ngayBatDauNT;
        this.ngayKetThucNT = ngayKetThucNT;

    }

	public String getMaPhienTG() {
        return maPhienTG;
    }

    public void setMaPhienTG(String maPhienTG) {
        this.maPhienTG = maPhienTG;
    }

    public Date getNgayBatDauDK() {
        return ngayBatDauDK;
    }

    public void setNgayBatDauDK(Date ngayBatDauDK) {
        this.ngayBatDauDK = ngayBatDauDK;
    }

    public Date getNgayKetThucDK() {
        return ngayKetThucDK;
    }

    public void setNgayKetThucDK(Date ngayKetThucDK) {
        this.ngayKetThucDK = ngayKetThucDK;
    }

    public Date getNgayBatDauXD() {
        return ngayBatDauXD;
    }

    public void setNgayBatDauXD(Date ngayBatDauXD) {
        this.ngayBatDauXD = ngayBatDauXD;
    }

    public Date getNgayKetThucXD() {
        return ngayKetThucXD;
    }

    public void setNgayKetThucXD(Date ngayKetThucXD) {
        this.ngayKetThucXD = ngayKetThucXD;
    }

    public Date getNgayBatDauNT() {
        return ngayBatDauNT;
    }

    public void setNgayBatDauNT(Date ngayBatDauNT) {
        this.ngayBatDauNT = ngayBatDauNT;
    }

    public Date getNgayKetThucNT() {
        return ngayKetThucNT;
    }

    public void setNgayKetThucNT(Date ngayKetThucNT) {
        this.ngayKetThucNT = ngayKetThucNT;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
