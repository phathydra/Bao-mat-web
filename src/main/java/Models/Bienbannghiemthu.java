package Models;

import java.io.Serializable;

public class Bienbannghiemthu  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String maChamNT;
    private String maHDNT;
    private String maDT;
    private Integer diem;
    private String nhanXet;
    private String linkBB;
    private String trangthaiHienThi;

    public Bienbannghiemthu() {
		super();
	}

	public Bienbannghiemthu(String maChamNT, String maHDNT, String maDT, Integer diem, String nhanXet, String linkBB,
			String trangthaiHienThi) {
		super();
		this.maChamNT = maChamNT;
		this.maHDNT = maHDNT;
		this.maDT = maDT;
		this.diem = diem;
		this.nhanXet = nhanXet;
		this.linkBB = linkBB;
		this.trangthaiHienThi = trangthaiHienThi;
	}
    public Bienbannghiemthu(String maDT, Integer diem, String nhanXet, String linkBB) {
        super();
        this.maDT = maDT;
        this.diem = diem;
        this.nhanXet = nhanXet;
        this.linkBB = linkBB;
    }
    public Bienbannghiemthu(String maChamNT, String maHDNT, String maDT) {
        super();
        this.maChamNT = maChamNT;
        this.maHDNT = maHDNT;
        this.maDT = maDT;
    }


	public String getMaChamNT() {
        return maChamNT;
    }

    public void setMaChamNT(String maChamNT) {
        this.maChamNT = maChamNT;
    }

    public String getMaHDNT() {
        return maHDNT;
    }

    public void setMaHDNT(String maHDNT) {
        this.maHDNT = maHDNT;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public Integer getDiem() {
        return diem;
    }

    public void setDiem(Integer diem ) {
        this.diem = diem;
    }

    public String getNhanXet() {
        return nhanXet;
    }

    public void setNhanXet(String nhanXet) {
        this.nhanXet = nhanXet;
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
