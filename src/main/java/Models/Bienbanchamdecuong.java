package Models;
import java.io.Serializable;

public class Bienbanchamdecuong implements Serializable {
	private static final long serialVersionUID = 1L;
    private String maChamDC;
    private String maDDC;
    private String maDK;
    private String xetDuyet;
    private String linkBB;
    private String trangthaiHienThi;
    
	public Bienbanchamdecuong() {
		super();
	}

	public Bienbanchamdecuong(String maChamDC, String maDDC, String maDK, String xetDuyet, String linkBB,
			String trangthaiHienThi) {
		super();
		this.maChamDC = maChamDC;
		this.maDDC = maDDC;
		this.maDK = maDK;
		this.xetDuyet = xetDuyet;
		this.linkBB = linkBB;
		this.trangthaiHienThi = trangthaiHienThi;
	}

	public String getMaChamDC() {
        return maChamDC;
    }

    public void setMaChamDC(String maChamDC) {
        this.maChamDC = maChamDC;
    }

    public String getMaDDC() {
        return maDDC;
    }

    public void setMaDDC(String maDDC) {
        this.maDDC = maDDC;
    }

    public String getMaDK() {
        return maDK;
    }

    public void setMaDK(String maDK) {
        this.maDK = maDK;
    }

    public String getXetDuyet() {
        return xetDuyet;
    }

    public void setXetDuyet(String xetDuyet) {
        this.xetDuyet = xetDuyet;
    }

    public String getLinkBB() {
        return linkBB;
    }

    public void setLinkBB(String linkBB) {
        this.linkBB = linkBB;
    }
    public String getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(String trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}

}
