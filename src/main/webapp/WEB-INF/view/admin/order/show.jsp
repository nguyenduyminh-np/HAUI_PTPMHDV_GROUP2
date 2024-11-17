<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <title>Dashboard </title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <style>
                    .table th,
                    .table td {
                        text-align: left;
                        /* Hoặc center nếu bạn muốn căn giữa */
                    }

                    .table-sm th,
                    .table-sm td {
                        padding: 0.3rem;
                        /* Điều chỉnh khoảng cách giữa các ô */
                    }
                </style>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Orders</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Orders</li>
                                </ol>
                                <div class="mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="d-flex justify-content-between">
                                                <h3>Table </h3>

                                            </div>

                                            <hr />
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>ID</th>
                                                        <th>Total Price</th>
                                                        <th>User</th>
                                                        <th>Detail Order</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="order" items="${orders1}">
                                                        <tr>
                                                            <th>${order.id}</th>
                                                            <td>
                                                                <fmt:formatNumber value="${order.totalPrice}"
                                                                    type="number" maxFractionDigits="0" />
                                                            </td>
                                                            <td>${order.user.fullName}</td>
                                                            <td>
                                                                <!-- Hiển thị CartDetail trong cùng dòng -->
                                                                <table class="table  mb-0">
                                                                    <thead>
                                                                        <tr>
                                                                            <th scope="col" class="w-25">Product name
                                                                            </th>
                                                                            <th scope="col" class="w-25">Price</th>
                                                                            <th scope="col" class="w-25">Quantity</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <c:forEach var="detail"
                                                                            items="${order.orderDetails}">
                                                                            <tr>
                                                                                <td scope="col" class="w-25">
                                                                                    ${detail.product.name}</td>
                                                                                <td scope="col" class="w-25">
                                                                                    <fmt:formatNumber
                                                                                        value="${detail.price}"
                                                                                        type="number"
                                                                                        maxFractionDigits="0" />
                                                                                </td>
                                                                                <td scope="col" class="w-25">
                                                                                    ${detail.quantity}</td>
                                                                            </tr>
                                                                        </c:forEach>
                                                                    </tbody>
                                                                </table>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>

                                        </div>

                                    </div>

                                </div>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>

            </body>

            </html>