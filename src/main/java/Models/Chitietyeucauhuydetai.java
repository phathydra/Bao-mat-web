package Models;
import java.io.Serializable;
import java.util.Date;

public class Chitietyeucauhuydetai implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maHuyDT;
    private String maDT;
    private Date ngayYeuCau;
    private String lyDo;
    private String trangthaiHienThi;
    
	public Chitietyeucauhuydetai() {
		super();
	}

	public Chitietyeucauhuydetai(String maHuyDT, String maDT, Date ngayYeuCau, String lyDo, String trangthaiHienThi) {
		super();
		this.maHuyDT = maHuyDT;
		this.maDT = maDT;
		this.ngayYeuCau = ngayYeuCau;
		this.lyDo = lyDo;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaHuyDT() {
        return maHuyDT;
    }

    public void setMaHuyDT(String maHuyDT) {
        this.maHuyDT = maHuyDT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public Date getNgayYeuCau() {
        return ngayYeuCau;
    }

    public void setNgayYeuCau(Date ngayYeuCau) {
        this.ngayYeuCau = ngayYeuCau;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

	public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
