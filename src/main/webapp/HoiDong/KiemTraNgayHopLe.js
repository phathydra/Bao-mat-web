
function kiemTraNgay() {
    var ngayBatDauDangKy = new Date(document.getElementById("ngayBatDauDangKy").value);
    var ngayKetThucDangKy = new Date(document.getElementById("ngayKetThucDangKy").value);

    if (ngayBatDauDangKy > ngayKetThucDangKy) {
        alert("Ngày kết thúc đăng ký phải sau ngày bắt đầu đăng ký");
        document.getElementById("ngayKetThucDangKy").value = "";
        return;
    }
}