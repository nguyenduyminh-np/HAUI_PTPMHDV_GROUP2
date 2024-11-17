<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">
                <div class="d-flex align-items-center justify-content-between small">
                    <div>
                        <h5 class="footer-title">
                            GROUP 2-
                            <span class="haui-text">HAUI</span>
                        </h5>
                        <a href="https://www.facebook.com/duyminhnp/" target="_blank" class="footer-link">Contact for
                            help</a>
                    </div>
                </div>
            </div>
        </footer>

        <style>
            .footer-title {
                font-size: 1.5rem;
                font-weight: bold;
                letter-spacing: 2px;
                color: #333;
                animation: fadeIn 2s ease-in-out;
            }

            .footer-link {
                color: #333;
                text-decoration: none;
                transition: color 0.3s ease;
                animation: linkColorChange 0.3s infinite;
            }

            .footer-link:hover {
                color: #ffc107;
            }

            .haui-text {
                font-weight: bold;
                animation: colorChange 2s infinite;
            }

            @keyframes fadeIn {
                0% {
                    opacity: 0;
                    transform: translateY(-10px);
                }

                100% {
                    opacity: 1;
                    transform: translateY(0);
                }
            }

            @keyframes colorChange {

                0%,
                100% {
                    color: red;
                }

                33% {
                    color: yellow;
                }

                66% {
                    color: navy;
                }
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