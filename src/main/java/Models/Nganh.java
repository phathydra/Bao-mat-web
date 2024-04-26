package Models;
import java.io.Serializable;

public class Nganh implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maNganh;
    private String maKhoa;
    private String tenNganh;
    private String trangthaiHienThi;
    

	public Nganh() {
		super();
	}

	public Nganh(String maNganh, String maKhoa, String tenNganh, String trangthaiHienThi) {
		super();
		this.maNganh = maNganh;
		this.maKhoa = maKhoa;
		this.tenNganh = tenNganh;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }
}
