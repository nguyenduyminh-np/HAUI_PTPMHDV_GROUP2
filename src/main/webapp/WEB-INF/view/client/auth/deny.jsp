<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>403 - Laptopshop</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <style>
                    /* Video Background */
                    .video-background {
                        position: fixed;
                        top: 0;
                        left: 0;
                        width: 100%;
                        height: 100%;
                        object-fit: cover;
                        z-index: -1;
                        /* Đặt video ở phía sau nội dung */
                    }

                    /* Định dạng nội dung */
                    .content-container {
                        position: relative;
                        z-index: 1;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        justify-content: center;
                        height: 100vh;
                        color: white;
                        background-color: rgba(0, 0, 0, 0.5);
                        /* Nền mờ cho nội dung */
                        padding: 20px;
                        text-align: center;
                        border-radius: 8px;
                    }

                    .footer-link {
                        font-size: 1.5rem;
                        /* Tăng kích thước chữ */
                        font-weight: bold;
                        /* Làm chữ đậm hơn */
                        color: #ffc107;
                        text-decoration: none;
                        transition: color 0.3s ease;
                        animation: linkColorChange 0.3s infinite;
                    }

                    .footer-link:hover {
                        color: #ff5733;
                        /* Màu khi hover */
                    }

                    .toggle-sound {
                        position: absolute;
                        top: 20px;
                        right: 20px;
                        z-index: 2;
                    }

                    @keyframes linkColorChange {

                        0%,
                        100% {
                            color: red;
                        }

                        66% {
                            color: navy;
                        }
                    }
                </style>
            </head>

            <body>
                <!-- Video Background -->
                <video autoplay loop muted id="backgroundVideo" class="video-background">
                    <source src="/images/product/backgroundvideo.mp4" type="video/mp4">
                    Trình duyệt của bạn không hỗ trợ video nền.
                </video>

                <button onclick="toggleMute()" class="btn btn-primary toggle-sound">Bật/Tắt Âm Thanh</button>



                <!-- Nội dung phía trên video -->
                <div class="content-container">
                    <div class="alert alert-danger" role="alert">
                        Bạn không có quyền truy cập nguồn tài nguyên này
                    </div>
                    <a href="/" class="btn btn-success">Trang Chủ</a>
                    <a href="https://www.facebook.com/duyminhnp/" target="_blank" class="footer-link">Contact for
                        help</a>
                </div>
                <script>
                    function toggleMute() {
                        const video = document.getElementById("backgroundVideo");
                        video.muted = !video.muted;
                    }

                </script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js">

                </script>
            </body>

            </html>