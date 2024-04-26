package Models;

import java.io.Serializable;

public class Khoa implements Serializable {
	private static final long serialVersionUID = 1L;
    private String maKhoa;
    private String tenKhoa;
    private String trangthaiHienThi;
    
    
	public Khoa() {
		super();
	}

	public Khoa(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}

	public Khoa(String maKhoa, String tenKhoa, String trangthaiHienThi) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
