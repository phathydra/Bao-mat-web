package Models;

import java.io.Serializable;
import java.util.Date;
public class Sinhvien implements Serializable {
	private static final long serialVersionUID = 1L;
    private String mssv;
    private String hoTen;
    private String maKhoa;
    private Date ngaySinh;
    private Integer cccd;
    private Integer stk;
    private String sdt;
    private String nienKhoa;
    private String gioiTinh;
    private String maTK;
    private String maNhom;
    private String trangthaiHienThi;
   
    

	public Sinhvien() {
		super();
	}

	public Sinhvien(String mssv, String hoTen, String maKhoa, Date ngaySinh, Integer cccd, Integer stk, String sdt,
			String nienKhoa, String gioiTinh, String maTK, String maNhom, String trangthaiHienThi) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.maKhoa = maKhoa;
		this.ngaySinh = ngaySinh;
		this.cccd = cccd;
		this.stk = stk;
		this.sdt = sdt;
		this.nienKhoa = nienKhoa;
		this.gioiTinh = gioiTinh;
		this.maTK = maTK;
		this.maNhom = maNhom;
		this.trangthaiHienThi = trangthaiHienThi;
	}
    public Sinhvien(String mssv, String hoTen, String maKhoa, Date ngaySinh, Integer cccd, Integer stk, String sdt,
                    String nienKhoa, String gioiTinh, String maTK, String maNhom) {
        super();
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.maKhoa = maKhoa;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.stk = stk;
        this.sdt = sdt;
        this.nienKhoa = nienKhoa;
        this.gioiTinh = gioiTinh;
        this.maTK = maTK;
        this.maNhom = maNhom;
    }

    private Taikhoan taikhoan;
    public Taikhoan getTaikhoan() {
        return taikhoan;
    }

    private Khoa khoa ;
    public Khoa getKhoa()
    {
        return khoa;
    }
    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
    public void setTaikhoan(Taikhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getCccd() {
        return cccd;
    }

    public void setCccd(Integer cccd) {
        this.cccd = cccd;
    }

    public Integer getStk() {
        return stk;
    }

    public void setStk(Integer stk) {
        this.stk = stk;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNienKhoa() {
        return nienKhoa;
    }

    public void setNienKhoa(String nienKhoa) {
        this.nienKhoa = nienKhoa;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }
}
