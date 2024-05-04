package Models;
import java.io.Serializable;
import java.util.Date;

public class Thongbao implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maTB;
    private String tenThongBao;
    private String noiDungTB;
    private Date ngayGui;
    private String maSoQL;
    private String maTK;
    private String trangthaiHienThi;

	public Thongbao() {
		super();
	}
	
	public Thongbao(String maTB, String tenThongBao, String noiDungTB, Date ngayGui, String maSoQL, String maTK,
			String trangthaiHienThi) {
		super();
		this.maTB = maTB;
		this.tenThongBao = tenThongBao;
		this.noiDungTB = noiDungTB;
		this.ngayGui = ngayGui;
		this.maSoQL = maSoQL;
		this.maTK = maTK;
		this.trangthaiHienThi = trangthaiHienThi;
	}
    public Thongbao(String maTB, String tenThongBao, Date ngayGui) {
        super();
        this.maTB = maTB;
        this.tenThongBao = tenThongBao;
        this.ngayGui = ngayGui;
    }
	public String getMaTB() {
        return maTB;
    }

    public void setMaTB(String maTB) {
        this.maTB = maTB;
    }

    public String getTenThongBao() {
        return tenThongBao;
    }

    public void setTenThongBao(String tenThongBao) {
        this.tenThongBao = tenThongBao;
    }

    public String getNoiDungTB() {
        return noiDungTB;
    }

    public void setNoiDungTB(String noiDungTB) {
        this.noiDungTB = noiDungTB;
    }

    public Date getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(Date ngayGui) {
        this.ngayGui = ngayGui;
    }

    public String getMaSoQL() {
        return maSoQL;
    }

    public void setMaSoQL(String maSoQL) {
        this.maSoQL = maSoQL;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
