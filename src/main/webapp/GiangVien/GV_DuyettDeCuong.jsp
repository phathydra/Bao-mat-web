<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Giảng viên - Duyệt đề cương </title>

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

            <li class="nav-item active">
                <a class="nav-link" href="<%= request.getContextPath() %>/ThongBao/list_ThongBaoGiangVienController">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Thông báo</span></a>
            </li>                 
            <hr class="sidebar-divider my-0">    

            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/giangvien/ThongTinGiangVien">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Thông tin cá nhân</span></a>
            </li>
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DetaiIMPLE/GV_list_DeTaiController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Danh sách đề tài</span></a>
            </li>
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DetaiIMPLE/GV_list_DeTaiHuongDanController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Đề tài hướng dẫn</span></a>
            </li>
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DetaiIMPLE/GV_list_DeTaiNghiemThuController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Đề tài nghiệm thu</span></a>
            </li>
            <hr class="sidebar-divider my-0">
            
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/DetaiIMPLE/GV_list_DeTaiXetDuyetDeCuongController">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Đề tài xét duyệt đề cương</span></a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>

    
    	<div id="content-wrapper" class="d-flex flex-column">
    		<div id = "content">
    		
    			<nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <form class="form-inline">
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
        </button>
    </form>

    <!-- Topbar Search -->
    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
        <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
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
            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
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
            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
            </a>
            <!-- Dropdown - Alerts -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                    Alerts Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle bg-primary">
                            <i class="fas fa-file-alt text-white"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">December 12, 2019</div>
                        <span class="font-weight-bold">A new monthly report is ready to download!</span>
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle bg-success">
                            <i class="fas fa-donate text-white"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">December 7, 2019</div>
                        $290.29 has been deposited into your account!
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="mr-3">
                        <div class="icon-circle bg-warning">
                            <i class="fas fa-exclamation-triangle text-white"></i>
                        </div>
                    </div>
                    <div>
                        <div class="small text-gray-500">December 2, 2019</div>
                        Spending Alert: We've noticed unusually high spending for your account.
                    </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
            </div>
        </li>

        <!-- Nav Item - Messages -->
        <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
            </a>
            <!-- Dropdown - Messages -->
            <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                    Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="dropdown-list-image mr-3">
                        <img class="rounded-circle" src="img/undraw_profile_1.svg" alt="...">
                        <div class="status-indicator bg-success"></div>
                    </div>
                    <div class="font-weight-bold">
                        <div class="text-truncate">Hi there! I am wondering if you can help me with a
                            problem I've been having.</div>
                        <div class="small text-gray-500">Emily Fowler · 58m</div>
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="dropdown-list-image mr-3">
                        <img class="rounded-circle" src="img/undraw_profile_2.svg" alt="...">
                        <div class="status-indicator"></div>
                    </div>
                    <div>
                        <div class="text-truncate">I have the photos that you ordered last month, how
                            would you like them sent to you?</div>
                        <div class="small text-gray-500">Jae Chun · 1d</div>
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="dropdown-list-image mr-3">
                        <img class="rounded-circle" src="img/undraw_profile_3.svg" alt="...">
                        <div class="status-indicator bg-warning"></div>
                    </div>
                    <div>
                        <div class="text-truncate">Last month's report looks great, I am very happy with
                            the progress so far, keep up the good work!</div>
                        <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                    </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                    <div class="dropdown-list-image mr-3">
                        <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="...">
                        <div class="status-indicator bg-success"></div>
                    </div>
                    <div>
                        <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                            told me that people say this to all dogs, even if they aren't good...</div>
                        <div class="small text-gray-500">Chicken the Dog · 2w</div>
                    </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
            </div>
        </li>

        <div class="topbar-divider d-none d-sm-block"></div>

        <!-- Nav Item - User Information -->
        <li class="nav-item dropdown no-arrow">
            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas McGee</span>
                <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
            </a>
            <!-- Dropdown - User Information -->
            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
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
                <!-- MAIN -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">VĂN BẢN DUYỆT ĐỀ CƯƠNG ĐỀ TÀI</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Duyệt đề cương đề tài</h6>
                        </div>

                        <div class="card-body">
                            <div class="text-center">
                                <h1>QUY TRÌNH DUYỆT ĐỀ CƯƠNG ĐỀ TÀI</h1>
                                <h4>THAM GIA NGHIÊN CỨU KHOA HỌC NĂM 2023</h4>
                            </div>
                            <form action="<%= request.getContextPath() %>/DetaiIMPLE/GV_XetDuyetDeTai" method= "post">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="MaDT">Mã số đề tài:</label>
                                                <input type="text"  value = "${exdetai.maDT}" class="form-control" id="MaDT" name = "MaDT">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="TenDeTai">Tên đề tài:</label>
                                                <textarea class="form-control" id="TenDeTai" name="TenDeTai">${exdetai.tenDeTai}</textarea>
                                            </div>
                                        </div>

                                    </div>
                                    <div class= "row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="MSGV">Mã số giảng viên hướng dẫn:</label>
                                                <input type="text"  value = "${exdetai.msgv}" class="form-control" id="MSGV" name = "MSGV">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="tenGV">Tên giảng viên hướng dẫn:</label>
                                                <input type="text"  value = "${exdetai.giangvien.tenGV}" class="form-control" id="tenGV" name = "tenGV">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="MaNganh" >Mã Ngành:</label>
                                                <input type="text"  value = "${exdetai.maNganh}" class="form-control" id="MaNganh" name = "MaNganh" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="TenNganh">Ngành :</label>
                                                <input type="text" value = "${exdetai.nganh.tenNganh}" class="form-control" id="TenNganh" name = "TenNganh">
                                            </div>
                                        </div>
                                    </div>

                                    <div class= "row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="MaTrangThai">Mã số trạng thái:</label>
                                                <input type="text"  value = "${exdetai.maTrangThai}" class="form-control" id="MaTrangThai" name = "MaTrangThai">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="TenTrangThai">Tên trạng thái:</label>
                                                <input type="text" value = "${exdetai.trangthai.tenTrangThai}" class="form-control" id="TenTrangThai" name = "TenTrangThai">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="GhiChu">Ghi chú:</label>
                                                <textarea class="form-control" id="GhiChu" name="GhiChu">${exdetai.ghiChu}</textarea>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="NgayThucHien">Ngày thực hiện:</label>
                                                <input type="text" class="form-control" id="NgayThucHien" value='<fmt:formatDate value="${exdetai.ngayThucHien}" pattern="dd/MM/yyyy" />'>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="NgayKetThuc">Ngày hoàn thành:</label>
                                                <input type="text" class="form-control" id="NgayKetThuc" value='<fmt:formatDate value="${exdetai.ngayKetThuc}" pattern="dd/MM/yyyy" />'>
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="LinkDeTai">Link đề tài:</label>
                                                <input type="text" class="form-control" id="LinkDeTai" value="${exdetai.linkDeTai}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-group">
                                                <label for="XetDuyetDC">Trạng thái duyệt đề cương đề tài:</label>
                                                <textarea class="form-control" id="XetDuyetDC" name="XetDuyetDC" rows="4" cols="100">${bbcdc.xetDuyet}</textarea>
                                            </div>
                                        </div>
                                        <div class ="row">
                                            <div class="form-group">
                                                <label for="LinkBBDC">Link BB đề cương :</label>
                                                <input type="text" class="form-control" id="LinkBBDC" name="LinkBBDC" value = "${bbcdc.linkBB}" readonly>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <!-- Table -->
                                            <label >Sinh viên thực hiện:</label>
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>Số thứ tự</th>
                                                    <th>Mã đăng kí</th>
                                                    <th>Mã nhóm</th>
                                                    <th>Mã số sinh viên</th>
                                                    <th>Họ tên sinh viên</th>
                                                    <th>Giới tính</th>
                                                    <th>Mã khoa</th>
                                                    <th>Khoa</th>
                                                    <th>Ngày sinh</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="nhom" items="${listthanhviennhom}" varStatus="status">
                                                    <tr>
                                                        <td>${status.index + 1}</td>
                                                        <td name="MaDK" value="${nhom.maDK}">${nhom.maDK}</td>
                                                        <td>${nhom.maNhom}</td>
                                                        <td>${nhom.sinhvien.mssv}</td>
                                                        <td>${nhom.sinhvien.hoTen}</td>
                                                        <td>${nhom.sinhvien.gioiTinh}</td>
                                                        <td>${nhom.sinhvien.maKhoa}</td>
                                                        <td>${nhom.sinhvien.khoa.tenKhoa}</td>
                                                        <td>
                                                            <fmt:formatDate value="${nhom.sinhvien.ngaySinh}" pattern="dd/MM/yyyy" />
                                                        </td>
                                                        <!-- cẩn thận ở đây biến đều nằm trong models , ko phải dao -->
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                                </tbody>

                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <!-- Đăng ký đề tài  -->
                                <!-- IMPORTAINT -->
                                <div class="mb-3">
                                    <!-- Insert du lieu vao bang DangKy va DeTai -->
                                    <div>
                                        <h4>3. Tiến hành đánh giá đề tài : </h4>
                                    <label for="XetDuyet">Xét duyệt đề cương đề tài:</label>
                                    <div class="row">
                                        <div class="col-md-12">
                                        <div class="form-group">
                                            <select class="form-control" id="XetDuyet" name="XetDuyet">
                                                <option value="duyet">Duyệt</option>
                                                <option value="khongduyet">Không duyệt</option>
                                            </select>
                                        </div>
                                        </div>
                                    </div>
                                        <label for="LinkBB">Link biên bản chấm duyệt đề cương :</label>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <!-- Textbox 4 -->
                                                <div class="form-group">
                                                    <textarea class="form-control" id="LinkBB" name="LinkBB" rows="4" cols="50"></textarea>
                                            </div>
                                        </div>
                                        </div>

                                    <br>

                                    <div class="text-center mt-6">
                                        <button type="submit" class="btn btn-primary" style="width: 30%;">Xác nhận duyệt đề cương</button>
                                    </div>
                                </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

    
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