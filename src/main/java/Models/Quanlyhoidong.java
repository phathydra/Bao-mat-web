package Models;
import java.io.Serializable;
import java.util.Date;
public class Quanlyhoidong implements Serializable {
	private static final long serialVersionUID = 1L;
    private String maSoQL;
    private String hoTen;
    private Date ngaySinh;
    private String msgv;
    private String maTK;
    private String trangthaiHienThi;
    
    
    public Quanlyhoidong() {
		super();
	}

	public Quanlyhoidong(String maSoQL, String hoTen, Date ngaySinh, String msgv, String maTK,
			String trangthaiHienThi) {
		super();
		this.maSoQL = maSoQL;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.msgv = msgv;
		this.maTK = maTK;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaSoQL() {
        return maSoQL;
    }

    public void setMaSoQL(String maSoQL) {
        this.maSoQL = maSoQL;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMsgv() {
        return msgv;
    }

    public void setMsgv(String msgv) {
        this.msgv = msgv;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }
}
