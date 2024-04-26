<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Đăng nhập</title>
    <style><%@include file="/css/style-login.css"%></style>
   <!-- <<link rel="stylesheet" href="css/style-login.css"> -->
    <script>
        function validateForm() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var radios = document.getElementsByName("user");
            var radioChecked = false;

            // Kiểm tra xem có radiobutton nào được chọn không
            for (var i = 0; i < radios.length; i++) {
                if (radios[i].checked) {
                    radioChecked = true;
                    break;
                }
            }

            // Kiểm tra xem username, password và radiobutton có được nhập không
            if (username.trim().length < 5) {
                alert("Tên đăng nhập phải có ít nhất 5 ký tự.");
                return false;
            }
            if (password.trim().length < 5) {
                alert("Mật khẩu phải có ít nhất 5 ký tự.");
                return false;
            }
            if (!radioChecked) {
                alert("Vui lòng chọn loại người dùng.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<main>
    <form id="loginForm" method="post" action="<%= request.getContextPath() %>/Taikhoan/login" >
            <legend><h2>ĐĂNG NHẬP</h2></legend>
            <div class="radio-group">
                <!-- Đặt id cho label và thay đổi 'for' tương ứng -->
                <input type="radio" id="sinhvien" name="sinhvien" value="sinhvien" class="radio-button">
                <label for="sinhvien" class="label-radio">Sinh viên</label>
                <!-- Thêm thuộc tính 'required' cho các trường input -->
                <input type="radio" id="giangvien" name="giangvien" value="giangvien" class="radio-button">
                <label for= "giangvien" class="label-radio">Giảng viên</label>
                <input type="radio" id="admin" name="admin" value="admin" class="radio-button">
                <label for="admin" class="label-radio">Admin</label>
                <input type="radio" id="quanly" name="user" value="quanly" class="radio-button">
                <label for="quanly" class="label-radio">Quản lý hội đồng</label>
            </div>
            <div class="form-group">
                <label for="tenDangNhap" class="demuc">Tài khoản:</label>
                <!-- Thêm thuộc tính 'title' để hiển thị thông báo khi hover chuột -->
                <input type="text" class="form-control" id="tenDangNhap" name="tenDangNhap" placeholder="Nhập tên đăng nhập" required title="Tên đăng nhập phải có ít nhất 5 ký tự." pattern=".{5,}">
            </div>
            <div class="form-group">
                <label for="password" class="demuc">Mật khẩu:</label>
                <input type="password" id="password" name="password" placeholder="Nhập mật khẩu" required title="Mật khẩu phải có ít nhất 5 ký tự." pattern=".{5,}">
            </div>
        <a>
            <button type="submit" class="login-button" onclick="loginAndRedirect()">Đăng nhập</button>
        </a>
    </form>
    <!--
    <a href="<%= request.getContextPath() %>/list_ThongBaoController" class="nav-link">Users</a>
    -->
</main>

<script>
    function loginAndRedirect() {
        // Thực hiện gọi danh sách thông báo ở đây
        fetch('<%= request.getContextPath() %>/list_ThongBaoController')
            .then(response => response.json())
            .then(data => {
                // Chuyển hướng đến trang SV_ThongBao.jsp và gửi thông báo lấy được qua session hoặc parameter
                window.location.href = 'SinhVien/SV_ThongBao.jsp'; // Thay thế bằng cách truyền dữ liệu thông báo nếu cần
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
</script>

</body>
</html>
