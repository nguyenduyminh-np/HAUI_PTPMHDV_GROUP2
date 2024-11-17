<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!-- Footer Start -->

        <style>
            @keyframes blink {

                0%,
                100% {
                    opacity: 1;
                }

                50% {
                    opacity: 0;
                }
            }

            .footer-link h4 {
                color: beige;
                transition: color 0.3s;
                animation: blink 0.3s infinite;
                /* Thêm hiệu ứng blink */
            }

            .footer-link h4:hover {
                color: darkorange;
                animation: none;
                /* Dừng hiệu ứng khi hover */
            }

            .footer-item a {
                color: white;
                /* Màu chữ mặc định */
                transition: transform 0.3s, color 0.3s;
                /* Thêm hiệu ứng chuyển tiếp */
            }

            .footer-item a:hover {
                transform: scale(1.1);
                /* Phóng to một chút khi hover */
                color: darkorange;
                /* Đổi màu khi hover */
            }


            .header-icon {
                height: 100%;
                max-height: 80px;
                object-fit: cover;
                padding: 0;
                margin: 0;
            }
        </style>

        <div class="container-fluid bg-dark text-white-50 footer pt-5 mt-5">
            <div class="container py-5">
                <div class="pb-4 mb-4" style="border-bottom: 1px solid rgba(226, 175, 24, 0.5) ;">
                    <div class="row g-4">
                        <div class="col-lg-3">
                            <a href="#" target="_self">
                                <h1 class="text-primary mb-0">Laptopshop</h1>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row g-5">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <img src="/images/product/haui.png" alt="HAUI icon" class="header-icon me-2">
                            <img src="/images/product/vietnam.png" alt="Vietnam Flag" class="header-icon me-2">

                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Shop Info</h4>
                            <a class="btn-link" href="#">About Us - GROUP 2 HAUI</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="d-flex flex-column text-start footer-item">
                            <h4 class="text-light mb-3">Email</h4>
                            <a class="btn-link" href="#">nguyenduyminh300kg@gmail.com</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-item">
                            <a href="https://www.facebook.com/duyminhnp/" target="_blank" class="footer-link">
                                <h4 class="text-light mb-3 green">Contact for help</h4>
                            </a>
                            <!-- <a class="btn-link" href="https://www.facebook.com/duyminhnp/" target="_blank">Click
                                here</a> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->

        <!-- Copyright Start -->
        <div class="container-fluid copyright bg-dark py-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                        <span class="text-light"><a href="#" target="_self"><i
                                    class="fas fa-copyright text-light me-2"></i>Laptopshop</a>, All right
                            reserved.</span>
                    </div>
                    <div class="col-md-6 my-auto text-center text-md-end text-white">
                        Grateful for your help -> <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a>
                        and <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Copyright End -->