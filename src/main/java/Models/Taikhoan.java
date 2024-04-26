package Models;
import java.io.Serializable;
public class Taikhoan implements Serializable {
	private static final long serialVersionUID = 1L;
    private String maTK;
    private String tenDangNhap;
    private String email;
    private String password;
    private String hoTen;
    private String tenLoaiTK;
    private String trangthaiHienThi;
    
	public Taikhoan() {
		super();
	}

	public Taikhoan(String maTK, String tenDangNhap, String email, String password, String hoTen, String tenLoaiTK,
			String trangthaiHienThi) {
		super();
		this.maTK = maTK;
		this.tenDangNhap = tenDangNhap;
		this.email = email;
		this.password = password;
		this.hoTen = hoTen;
		this.tenLoaiTK = tenLoaiTK;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getTenLoaiTK() {
        return tenLoaiTK;
    }

    public void setTenLoaiTK(String tenLoaiTK) {
        this.tenLoaiTK = tenLoaiTK;
    }
}
