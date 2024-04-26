package Models;
import java.io.Serializable;
import java.util.Date;

public class Hoidongnghiemthu implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maHDNT;
    private String maHD;
    private String chuTichHD;
    private String phanBien1;
    private String phanBien2;
    private Date ngayNT;
    private String maKhoa;
    private String trangthaiHienThi;
    
	public Hoidongnghiemthu() {
		super();
	}

	public Hoidongnghiemthu(String maHDNT, String maHD, String chuTichHD, String phanBien1, String phanBien2,
			Date ngayNT, String maKhoa, String trangthaiHienThi) {
		super();
		this.maHDNT = maHDNT;
		this.maHD = maHD;
		this.chuTichHD = chuTichHD;
		this.phanBien1 = phanBien1;
		this.phanBien2 = phanBien2;
		this.ngayNT = ngayNT;
		this.maKhoa = maKhoa;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaHDNT() {
        return maHDNT;
    }

    public void setMaHDNT(String maHDNT) {
        this.maHDNT = maHDNT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getChuTichHD() {
        return chuTichHD;
    }

    public void setChuTichHD(String chuTichHD) {
        this.chuTichHD = chuTichHD;
    }

    public String getPhanBien1() {
        return phanBien1;
    }

    public void setPhanBien1(String phanBien1) {
        this.phanBien1 = phanBien1;
    }

    public String getPhanBien2() {
        return phanBien2;
    }

    public void setPhanBien2(String phanBien2) {
        this.phanBien2 = phanBien2;
    }

    public Date getNgayNT() {
        return ngayNT;
    }

    public void setNgayNT(Date ngayNT) {
        this.ngayNT = ngayNT;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
