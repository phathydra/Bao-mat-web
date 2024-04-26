package Models;

import java.io.Serializable;
import java.util.Date;

public class Dangky implements Serializable {
	private static final long serialVersionUID = 1L;
    private String maDK;
    private String maDT;
    private String maNhom;
    private String ghiChu;
    private String maHD;
    private String linkDeCuong;
    private String trangThai;
    private String msgv;
    private Date ngayDangKy;
    private Boolean trangthaiHienThi;
    
	public Dangky() {
		super();
	}

	public Dangky(String maDK, String maDT, String maNhom, String ghiChu, String maHD, String linkDeCuong,
			String trangThai, String msgv, Date ngayDangKy, Boolean trangthaiHienThi) {
		super();
		this.maDK = maDK;
		this.maDT = maDT;
		this.maNhom = maNhom;
		this.ghiChu = ghiChu;
		this.maHD = maHD;
		this.linkDeCuong = linkDeCuong;
		this.trangThai = trangThai;
		this.msgv = msgv;
		this.ngayDangKy = ngayDangKy;
		this.trangthaiHienThi = trangthaiHienThi;
	}

    public Dangky(String maDK, String maDT, String maNhom, String ghiChu, String linkDeCuong,
                  String trangThai, String msgv, Date ngayDangKy, Boolean trangthaiHienThi) {
        super();
        this.maDK = maDK;
        this.maDT = maDT;
        this.maNhom = maNhom;
        this.ghiChu = ghiChu;
        this.linkDeCuong = linkDeCuong;
        this.trangThai = trangThai;
        this.msgv = msgv;
        this.ngayDangKy = ngayDangKy;
        this.trangthaiHienThi = trangthaiHienThi;
    }
    private Detai detai;


    public Detai getDetai() {
        return detai;
    }

    public void setDetai(Detai detai) {
        this.detai = detai;
    }
    private Sinhvien sinhvien;

    public Sinhvien getSinhvien() {
        return sinhvien;
    }

    public void setSinhvien(Sinhvien sinhvien) {
        this.sinhvien = sinhvien;
    }

    private Giangvien giangvien;

    public void setGiangvien(Giangvien giangvien) {
        this.giangvien = giangvien;
    }

    public Giangvien getGiangvien() {
        return giangvien;
    }
    private Trangthai trangthai;

    public Trangthai getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Trangthai trangthai) {
        this.trangthai = trangthai;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getLinkDeCuong() {
        return linkDeCuong;
    }

    public void setLinkDeCuong(String linkDeCuong) {
        this.linkDeCuong = linkDeCuong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMsgv() {
        return msgv;
    }

    public void setMsgv(String msgv) {
        this.msgv = msgv;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

	public Boolean getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(Boolean trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
