<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sinh viên - Trang đăng kí đề tài </title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <style><%@include file="css/sb-admin-2.min.css"%></style>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
			
			<br><div class="sidebar-heading">
                Student
            </div>
            
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/ThongBao/list_ThongBaoSinhVienController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Thông báo</span></a>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/sinhvien/ThongTinSinhVien">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Thông tin cá nhân</span></a>
            </li>
            
            <br><div class="sidebar-heading">
                Đề tài sinh viên
            </div>
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DETAI/list_DeTaiController">
			        <i class="fas fa-fw fa-chart-area"></i>
			        <span>Danh sách đề tài</span>
			    </a>
			</li>
            
            <li  class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DETAI/list_DeTaiCuaToi">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Đề tài của tôi</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DETAI/ShowDangky_detai">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Đăng ký đề tài</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DETAI/Detai_ShowFormHuy">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Hủy đề tài</span></a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DETAI/Detai_ShowFormNopBC">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Nộp báo cáo đề tài</span></a>
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
                                <img class="img-profile rounded-circle" alt=""
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
                    <h1 class="h3 mb-2 text-gray-800">ĐĂNG KÝ ĐỀ TÀI</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Đăng ký đề tài sinh viên</h6>
                        </div>
                        
                        <div class="card-body">
						    <div class="text-center">
						        <h1>ĐĂNG KÝ ĐỀ TÀI</h1>
						        <h4>THAM GIA NGHIÊN CỨU KHOA HỌC NĂM 2023</h4>
						    </div>
						    <form  action="<%= request.getContextPath() %>/DETAI/Detai_DangKy" method= "post">
						        <div class="mb-3">
						            <h4>1. Thông tin sinh viên </h4>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="mssv" class="form-label">Mã số sinh viên:</label>
                                            <input type="text" id="mssv" value="${sinhvien.mssv}"  name="mssv" class="form-control" readonly>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="hoTen" class="form-label">Họ và tên:</label>
                                            <input type="text" id="hoTen" value="${sinhvien.hoTen}"  name="hoTen" class="form-control" readonly>
                                        </div>
                                    </div>
						        </div>
                                <div class="mb-3">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="TenKhoa" class="form-label">Khoa : </label>
                                            <input type="text" id="TenKhoa" value=" ${sinhvien.khoa.tenKhoa}"   name="TenKhoa" class="form-control" readonly >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="ngaySinh" class="form-label">Ngày sinh:</label>
                                            <input type="text" id="ngaySinh" name="ngaySinh" class="form-control"  value="<fmt:formatDate value='${sinhvien.ngaySinh}' pattern='dd/MM/yyyy'/>" readonly>
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="CCCD" class="form-label">Căn cước công dân:</label>
                                            <input type="text" id="CCCD" value=" ${sinhvien.cccd}"   name="CCCD" class="form-control" readonly >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="sdt" class="form-label">Số điện thoại: </label>
                                            <input type="text" id="sdt" value="${sinhvien.sdt}"  name="sdt" class="form-control" readonly >
                                        </div>
                                    </div>
                                </div>

                                <div class="mb-3">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label for="Email" class="form-label">Email: </label>
                                            <input type="text" id="Email" value="${sinhvien.taikhoan.email}"  name="Email" class="form-control" readonly >
                                        </div>
                                        <div class="col-md-6">
                                            <label for="Nienkhoa" class="form-label">Niên khóa: </label>
                                            <input type="text" id="Nienkhoa" value="${sinhvien.nienKhoa}"  name="Nienkhoa" class="form-control" readonly >
                                        </div>
                                    </div>
                                </div>

						        <div class="mb-3" >
                                    <h4>2. Thông tin nhóm tham gia đề tài :</h4>
						            <label for="MaNhom" class="form-label">Mã số nhóm thực hiện: </label>
                                    <input type="text" id="MaNhom" value="${sinhvien.maNhom}"  name="txtTenTV" class="form-control" readonly>
                                    <input type="hidden" name="MaNhom" value="${sinhvien.maNhom}">
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <!-- Table -->
                                        <label >Sinh viên thực hiện:</label>
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <th>Số thứ tự</th>
                                                <th>Mã nhóm</th>
                                                <th>Mã số sinh viên</th>
                                                <th>Họ tên sinh viên</th>
                                                <th>Ngày sinh</th>
                                                <th>Giới tính</th>
                                                <th>Mã khoa</th>
                                                <th>Khoa</th>

                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="sinhvien" items="${listthanhviennhom}" varStatus="status">
                                                <tr>
                                                    <td>${status.index + 1}</td>
                                                    <td>${sinhvien.maNhom}</td>
                                                    <td>${sinhvien.mssv}</td>
                                                    <td>${sinhvien.hoTen}</td>
                                                    <td>
                                                        <fmt:formatDate value="${sinhvien.ngaySinh}" pattern="dd/MM/yyyy" />
                                                    </td>
                                                    <td>${sinhvien.gioiTinh}</td>
                                                    <td>${sinhvien.maKhoa}</td>
                                                    <td>${sinhvien.khoa.tenKhoa}</td>

                                                    <!-- cẩn thận ở đây biến đều nằm trong models , ko phải dao -->
                                                </tr>
                                            </c:forEach>
                                            </tbody>

                                        </table>
                                    </div>
                                </div>
                                <!-- Đăng ký đề tài  -->
                                <!-- IMPORTAINT -->
						        <div class="mb-3">
                                    <!-- Insert du lieu vao bang DangKy va DeTai -->
                                    <div>
                                    <h4>3. Đăng ký đề tài : </h4>
                                    </div>
                                    <div>
                                        <label for="MaDK" class="form-label">Mã đăng ký: </label>
                                        <input type="text" id="MaDK" value="${dangky.maDK}" name="MaDK" class="form-control">
                                    </div>
						            <label for="MaDT" class="form-label">Tên đề tài đăng ký: </label>

                                    <div>
                                        <select id = "MaDT" name = "MaDT" style="width: 100%;" >
                                            <c:forEach var="detaidangky" items="${ listdetaidangky}">
                                                <option value="${detaidangky.maDT}">
                                                        ${detaidangky.maDT}&nbsp;&nbsp;&nbsp;&nbsp;
                                                        ${detaidangky.tenDeTai}&nbsp;&nbsp;&nbsp;&nbsp;
                                                        ${detaidangky.nganh.tenNganh}&nbsp;&nbsp;&nbsp;
                                                    ${detaidangky.trangthai.tenTrangThai}&nbsp;&nbsp;&nbsp;&nbsp;
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>

						        </div>
                                <div class="mb-3">
                                    <div>
                                        <label for="MSGV" class="form-label">Chọn giảng viên hướng dẫn:</label>
                                    </div>

                                    <div>
                                        <select id = "MSGV" name = "MSGV" style="width: 100%;" >
                                            <c:forEach var="gv" items="${ listgvhuongdan}">
                                                <option value="${gv.msgv}">${gv.msgv}&nbsp;&nbsp;&nbsp;&nbsp;${gv.tenGV} :${gv.khoa.tenKhoa} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <label for="LinkDeCuong" class="form-label">Link nộp file đề cương:</label>
                                    <input type="text" id="LinkDeCuong"  value = "${dangky.linkDeCuong}" name="LinkDeCuong" class="form-control">
                                </div>
                                <div class="mb-3">

                                    <label for="GhiChu" class="form-label">Ghi chú: </label>
                                    <textarea id="GhiChu" name="GhiChu" value = "${dangky.ghiChu}" class="form-control" rows="4"></textarea>
                                </div>

                                <div class="mb-3">
                                    <label for="NgayDangKy" class="form-label">Ngày đăng ký</label>
                                    <input type="date" id="NgayDangky" name="NgayDangKy" value="${dangky.ngayDangKy}" class="form-control" readonly>
                                </div>
                                <script>
                                    // Lấy ngày hiện tại
                                    let currentDate = new Date();

                                    // Định dạng ngày thành chuỗi "yyyy-mm-dd"
                                    let formattedDate = currentDate.toISOString().slice(0, 10);

                                    // Gán giá trị đã định dạng vào trường input
                                    document.getElementById('NgayDangky').value = formattedDate;
                                </script>



                                <div class="text-center mt-4">
                                    <button type="submit" class="btn btn-primary" style="width: 30%;">Gửi</button>
                                </div>
                            </form>
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
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>