<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <style>
        <%@include file="css/sb-admin-2.min.css"%>
        <%@include file="vendor/fontawesome-free/css/all.min.css"%>
    </style>
    <!-- Custom fonts for this template-->
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <br><div class="sidebar-heading">
        Admin
    </div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/ThongBao/list_ThongBaoAdminController">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Thông báo</span></a>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="AD_GuiTB.jsp">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Gửi thông báo</span></a>
        </li>


        <br><div class="sidebar-heading">
        Quản lý
    </div>

        <li class="nav-item">
            <a class="nav-link"  href="<%= request.getContextPath() %>/sinhvien/AD_list_SinhVienController">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Quản lý sinh viên</span>
            </a>
        </li>

        <li  class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/giangvien/AD_list_GiangVienController">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Quản lý giảng viên</span></a>
        </li>


        <li class="nav-item">
            <a class="nav-link" href="<%= request.getContextPath() %>/Taikhoan/AD_list_qlTaiKhoanController">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Quản lý tài khoản</span></a>
        </li>


        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter"></span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Thông báo mới
                            </h6>

                            <a class="dropdown-item text-center small text-gray-500" href="#">Hiển thị toàn bộ</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter"></span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Tin nhắn mới
                            </h6>

                            <a class="dropdown-item text-center small text-gray-500" href="#">Hiển thị toàn bộ</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">QUẢN LÝ SINH VIÊN</h1>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Quản lý sinh viên</h6>
                    </div>
                    <div class="card-body">

                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>MSSV</th>
                                    <th>Họ tên</th>
                                    <th>Niên khóa</th>
                                    <th>Khoa</th>
                                    <th>Chi tiết</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <c:forEach var="sinhvien" items="${listsinhvien}" varStatus="svStat">
                                <tr>
                                    <td>${svStat.index + 1}</td>
                                    <td>${sinhvien.mssv}</td>
                                    <td>${sinhvien.hoTen}</td>
                                    <td>${sinhvien.nienKhoa}</td>
                                    <td>${sinhvien.khoa.tenKhoa}</td>

                                    <td><a href="${pageContext.request.contextPath}/sinhvien/AD_ShowThongTinSinhVien?mssv=${sinhvien.mssv}">
                                        Xem chi tiết</a></td>
                                    </c:forEach>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="addUserModal" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content -->
                                <div class="modal-content">
                                    <div class="modal-header bg-warning text-white">
                                        <h5 class="modal-title">Thêm sinh viên </h5>
                                        <button class="close" data-dismiss="modal">
                                            <span>&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="<%= request.getContextPath() %>/sinhvien/AD_InsertSinhvien" method="post">
                                            <input type="hidden" id="TrangthaiHienThi" name="TrangthaiHienThi" value="1">
                                            <label >Thông tin sinh viên</label>
                                            <div class="form-group">
                                                <label for="MSSV">Mã số sinh viên</label>
                                                <input type="text" id="MSSV" name="MSSV" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="HoTen">Họ tên</label>
                                                <input type="text" id="HoTen" name="HoTen" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="MaKhoa">Mã khoa</label>
                                                <div>
                                                    <select id = "MaKhoa" name = "MaKhoa" style="width: 100%;">
                                                        <c:forEach var="khoa" items="${ listkhoa}" >
                                                            <option value="${khoa.maKhoa}">${khoa.tenKhoa}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="MaTK">Mã tài khoản</label>
                                                <input type="text" id="MaTK" name="MaTK" class="form-control">
                                            </div>
                                            <div class="mb-3">
                                                <label for="NgaySinh" class="form-label">Ngày sinh</label>
                                                <input type="date" id="NgaySinh" name="NgaySinh" class="form-control">
                                            </div>
                                            <script>
                                                // Lấy ngày hiện tại
                                                let currentDate = new Date();

                                                // Định dạng ngày thành chuỗi "yyyy-mm-dd"
                                                let formattedDate = currentDate.toISOString().slice(0, 10);

                                                // Gán giá trị đã định dạng vào trường input
                                                document.getElementById('NgaySinh').value = formattedDate;
                                            </script>
                                            <div class="form-group">
                                                <label for="CCCD">CCCD</label>
                                                <input type="text" id="CCCD" name="CCCD" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="STK">Số tài khoản</label>
                                                <input type="text" id="STK" name="STK" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="SDT">Số điện thoại</label>
                                                <input type="text" id="SDT" name="SDT" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="NienKhoa">Niên khóa</label>
                                                <input type="text" id="NienKhoa" name="NienKhoa" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="GioiTinh">Giới tính</label>
                                                <select id="GioiTinh" name="GioiTinh" class="form-control">
                                                    <option value="Nam">Nam</option>
                                                    <option value="Nữ">Nữ</option>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="MaNhom" >Mã nhóm</label>
                                                <div>
                                                    <select id = "MaNhom" name = "MaNhom" style="width: 100%;">
                                                        <c:forEach var="nhom" items="${ listnhom}" >
                                                            <option value="${nhom.maNhom}">${nhom.maNhom}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <label>Tài khoản</label>
                                            <div class="form-group">
                                                <label for="TenDangNhap">Tên đăng nhập</label>
                                                <input type="text" id="TenDangNhap" name="TenDangNhap" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Email">Email</label>
                                                <input type="text" id="Email" name="Email" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="Password">Password</label>
                                                <input type="text" id="Password" name="Password" class="form-control">
                                            </div>
                                            <div class="form-group">
                                                <label for="TenLoaiTK">Tên loại tài khoản</label>
                                                <select id="TenLoaiTK" name="TenLoaiTK" class="form-control">
                                                    <option value="Sinh viên">Sinh viên</option>
                                                </select>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-warning">Save Add</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-body">
                            <button onclick="showNewForm()" class="btn btn-success" data-toggle="modal" data-target="#addUserModal">Thêm mới</button>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span></span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script type="text/javascript"><%@include file="vendor/jquery/jquery.min.js" %></script>
<script type="text/javascript"><%@include file="vendor/bootstrap/js/bootstrap.bundle.min.js" %></script>

<script type="text/javascript"><%@include file="vendor/jquery-easing/jquery.easing.min.js" %></script>
<script type="text/javascript"><%@include file="js/sb-admin-2.min.js" %></script>
<script type="text/javascript"><%@include file="vendor/chart.js/Chart.min.js" %></script>

<script type="text/javascript"><%@include file="js/demo/chart-area-demo.js" %></script>
<script type="text/javascript"><%@include file="js/demo/chart-pie-demo.js" %></script>

</body>

</html>