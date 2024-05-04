package Models;
import java.io.Serializable;
import java.util.Date;
public class Giangvien implements Serializable {
	private static final long serialVersionUID = 1L;
    private String msgv;
    private String tenGV;
    private String maKhoa;
    private String maTK;
    private Date ngaySinh;
    private int cccd;
    private String maHD;
    private String trangthaiHienThi;

    private String gioiTinh;
    private String sdt;
   

	public Giangvien() {
		super();
	}

    public Giangvien(String msgv, String tenGV, String maKhoa, String maTK, Date ngaySinh, int cccd, String maHD,
                     String trangthaiHienThi) {
        super();
        this.msgv = msgv;
        this.tenGV = tenGV;
        this.maKhoa = maKhoa;
        this.maTK = maTK;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.maHD = maHD;
        this.trangthaiHienThi = trangthaiHienThi;
    }
    public Giangvien(String tenGV,Integer cccd, String maKhoa,
                     Date ngaySinh, String gioiTinh, String sdt, String maHD, String msgv  ) {
        super();
        this.msgv = msgv;
        this.tenGV = tenGV;
        this.maKhoa = maKhoa;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.maHD = maHD;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
    }

	public Giangvien(String msgv, String tenGV, String maKhoa, String maTK, Date ngaySinh, int cccd, String maHD,
			 String gioiTinh,String sdt, String trangthaiHienThi ) {
		super();
		this.msgv = msgv;
		this.tenGV = tenGV;
		this.maKhoa = maKhoa;
		this.maTK = maTK;
		this.ngaySinh = ngaySinh;
		this.cccd = cccd;
		this.maHD = maHD;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.trangthaiHienThi = trangthaiHienThi;
	}

    // extends : Sinh vien
    private Khoa khoa;

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    // extends : Giảng viên
    private Taikhoan taikhoan;
    public void setTaikhoan(Taikhoan taikhoan){ this.taikhoan = taikhoan;}
    public Taikhoan getTaikhoan(){ return  taikhoan;}

    public String getMsgv() {
        return msgv;
    }

    public void setMsgv(String msgv) {
        this.msgv = msgv;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getCccd() {
        return cccd;
    }

    public void setCccd(int cccd) {
        this.cccd = cccd;
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

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
