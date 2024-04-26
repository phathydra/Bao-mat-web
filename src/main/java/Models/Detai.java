package Models;
import java.io.Serializable;
import java.util.Date;
public class  Detai implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maDT;
    private String tenDeTai;
    private String ghiChu;
    private String maNganh;
    private Date ngayThucHien;
    private Date ngayKetThuc;
    private String ketQua;
    private String linkDeTai;
    private String maTrangThai;
    private String msgv;
    private String maHD;
    private Boolean trangthaiHienThi;

    private  String maPhienTG;

    public String getMaPhienTG() {
        return maPhienTG;
    }

    public void setMaPhienTG(String maPhienTG) {
        this.maPhienTG = maPhienTG;
    }
    public Detai(String maDT, String tenDeTai, String ghiChu, String maNganh, Date ngayThucHien, Date ngayKetThuc,
                 String ketQua, String linkDeTai, String maTrangThai, String msgv, String maHD, boolean trangthaiHienThi , String maPhienTG) {
        super();
        this.maDT = maDT;
        this.tenDeTai = tenDeTai;
        this.ghiChu = ghiChu;
        this.maNganh = maNganh;
        this.ngayThucHien = ngayThucHien;
        this.ngayKetThuc = ngayKetThuc;
        this.ketQua = ketQua;
        this.linkDeTai = linkDeTai;
        this.maTrangThai = maTrangThai;
        this.msgv = msgv;
        this.maHD = maHD;
        this.trangthaiHienThi = trangthaiHienThi;
        this.maPhienTG = maPhienTG;
    }

    public Detai() {
        super();
    }

    public Detai(String maDT, String tenDeTai, String ghiChu, String maNganh, Date ngayThucHien, Date ngayKetThuc,
                 String ketQua, String linkDeTai, String maTrangThai, String msgv, String maHD, boolean trangthaiHienThi) {
        super();
        this.maDT = maDT;
        this.tenDeTai = tenDeTai;
        this.ghiChu = ghiChu;
        this.maNganh = maNganh;
        this.ngayThucHien = ngayThucHien;
        this.ngayKetThuc = ngayKetThuc;
        this.ketQua = ketQua;
        this.linkDeTai = linkDeTai;
        this.maTrangThai = maTrangThai;
        this.msgv = msgv;
        this.maHD = maHD;
        this.trangthaiHienThi = trangthaiHienThi;
    }

    public Detai(String maDT, String maTrangThai) {
        super();
        this.maDT = maDT;
        this.maTrangThai = maTrangThai;
    }

    public Detai(String maDT, String ghiChu, Date ngayKetThuc, String maTrangThai,boolean trangthaiHienThi) {
        super();
        this.maDT = maDT;
        this.ghiChu = ghiChu;
        this.ngayKetThuc = ngayKetThuc;
        this.maTrangThai = maTrangThai;
        this.trangthaiHienThi = trangthaiHienThi;
    }

    public Detai(String maDT, String tenDeTai, String ghiChu, String maNganh, Date ngayThucHien, Date ngayKetThuc,
                 String ketQua, String linkDeTai, String maTrangThai, String msgv, String maHD) {
        super();
        this.maDT = maDT;
        this.tenDeTai = tenDeTai;
        this.ghiChu = ghiChu;
        this.maNganh = maNganh;
        this.ngayThucHien = ngayThucHien;
        this.ngayKetThuc = ngayKetThuc;
        this.ketQua = ketQua;
        this.linkDeTai = linkDeTai;
        this.maTrangThai = maTrangThai;
        this.msgv = msgv;
        this.maHD = maHD;
    }

    public Detai(String maDT, String ghiChu, Date ngayKetThuc, String linkDeTai, String maTrangThai) {
        super();
        this.maDT = maDT;
        this.ghiChu = ghiChu;;
        this.ngayKetThuc = ngayKetThuc;
        this.linkDeTai = linkDeTai;
        this.maTrangThai = maTrangThai;
    }
    public Detai( String maDT,String ghiChu, String maTrangThai, String msgv,boolean trangthaiHienThi) {
        super();
        this.maDT = maDT;
        this.ghiChu = ghiChu;
        this.maTrangThai = maTrangThai;
        this.msgv = msgv;
        this.trangthaiHienThi = trangthaiHienThi;

    }

    private Nganh nganh;

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }
    private Trangthai trangthai;
    public Trangthai getTrangthai()
    {
        return trangthai;
    }
    public void setTrangthai(Trangthai trangthai)
    {
        this.trangthai = trangthai;
    }

    private Giangvien giangvien;

    public Giangvien getGiangvien() {
        return giangvien;
    }

    public void setGiangvien(Giangvien giangvien) {
        this.giangvien = giangvien;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDeTai() {
        return tenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
        this.tenDeTai = tenDeTai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public Date getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(Date ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getKetQua() {
        return ketQua;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
    }

    public String getLinkDeTai() {
        return linkDeTai;
    }

    public void setLinkDeTai(String linkDeTai) {
        this.linkDeTai = linkDeTai;
    }

    public String getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(String maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getMsgv() {
        return msgv;
    }

    public void setMsgv(String msgv) {
        this.msgv = msgv;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

	public Boolean getTrangthaiHienThi() {
		return trangthaiHienThi;
	}

	public void setTrangthaiHienThi(Boolean trangthaiHienThi) {
		this.trangthaiHienThi = trangthaiHienThi;
	}
    
}
