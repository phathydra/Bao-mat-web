package Models;

import java.io.Serializable;

public class Hoidong implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maHD;
    private String trangthaiHienThi;

	// for : hội đồng
	private Khoa khoa;

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	private  Giangvien giangvien;

	public Giangvien getGiangvien() {
		return giangvien;
	}

	public void setGiangvien(Giangvien giangvien) {
		this.giangvien = giangvien;
	}

	//
	public Hoidong() {
		super();
	}

	public Hoidong(String maHD, String trangthaiHienThi) {
		super();
		this.maHD = maHD;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}

