package Models;
import java.io.Serializable;
public class Hoidongduyetdecuong implements Serializable {
	  private static final long serialVersionUID = 1L;
	    private String maDDC;
	    private String maHD;
	    private String tenHD;
	    private String maKhoa;
	    private Integer soLuongTV;
	    private String trangthaiHienThi;
		
		public Hoidongduyetdecuong() {
			super();
		}

		public Hoidongduyetdecuong(String maDDC, String maHD, String tenHD, String maKhoa, Integer soLuongTV,
				String trangthaiHienThi) {
			super();
			this.maDDC = maDDC;
			this.maHD = maHD;
			this.tenHD = tenHD;
			this.maKhoa = maKhoa;
			this.soLuongTV = soLuongTV;
			this.trangthaiHienThi = trangthaiHienThi;
		}

		public String getMaDDC() {
	        return maDDC;
	    }

	    public void setMaDDC(String maDDC) {
	        this.maDDC = maDDC;
	    }

	    public String getMaHD() {
	        return maHD;
	    }

	    public void setMaHD(String maHD) {
	        this.maHD = maHD;
	    }

	    public String getTenHD() {
	        return tenHD;
	    }

	    public void setTenHD(String tenHD) {
	        this.tenHD = tenHD;
	    }

	    public String getMaKhoa() {
	        return maKhoa;
	    }

	    public void setMaKhoa(String maKhoa) {
	        this.maKhoa = maKhoa;
	    }

	    public Integer getSoLuongTV() {
	        return soLuongTV;
	    }

	    public void setSoLuongTV(Integer soLuongTV) {
	        this.soLuongTV = soLuongTV;
	    }

		public String getTrangthaiHienThi() {
			return trangthaiHienThi;
		}

		public void setTrangthaiHienThi(String trangthaiHienThi) {
			this.trangthaiHienThi = trangthaiHienThi;
		}
	    
	}
