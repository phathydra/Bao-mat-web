package Models;
import java.io.Serializable;

public class Nhom implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maNhom;
	private String trangthaiHienThi;
    

	public Nhom() {
		super();
	}

	public Nhom(String maNhom, String trangthaiHienThi) {
		super();
		this.maNhom = maNhom;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(String maNhom) {
        this.maNhom = maNhom;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
