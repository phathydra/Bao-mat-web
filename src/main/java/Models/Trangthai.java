

package Models;

	import java.io.Serializable;

	public class  Trangthai implements Serializable {
		private static final long serialVersionUID = 1L;
	    private String maTrangThai;
	    private String tenTrangThai;
	    private String trangthaiHienThi;
		public Trangthai() {
			super();
		}

		public Trangthai(String maTrangThai, String tenTrangThai, String trangthaiHienThi) {
			super();
			this.maTrangThai = maTrangThai;
			this.tenTrangThai = tenTrangThai;
			this.setTrangthaiHienThi(trangthaiHienThi);
		}


		public String getMaTrangThai() {
	        return maTrangThai;
	    }

	    public void setMaTrangThai(String maTrangThai) {
	        this.maTrangThai = maTrangThai;
	    }

	    public String getTenTrangThai() {
	        return tenTrangThai;
	    }

	    public void setTenTrangThai(String tenTrangThai) {
	        this.tenTrangThai = tenTrangThai;
	    }

		public String getTrangthaiHienThi() {
			return trangthaiHienThi;
		}

		public void setTrangthaiHienThi(String trangthaiHienThi) {
			this.trangthaiHienThi = trangthaiHienThi;
		}
	}
