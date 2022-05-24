<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 24/05/2022
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: thienduc
  Date: 17/02/2022
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" itemscope itemtype="http://schema.org/WebPage">
<head>
    <title>Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>

<body>

<div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
    <div class="container">
        <div class="row">
            <div class="col-md-8 text-start mb-5">
                <h1 class="z-index-1 position-relative">Product</h1>
            </div>
        </div>
        <div class="row align-items-center justify-content-center">
            <div class="col-md-6 align-self-center">
                <form role="form" class="text-start" action="product" method="post">
                    <div class="container d-flex">
                        <input type="hidden" name="action" value="search"/>
                        <div class="input-group input-group-outline my-3">
                            <label class="form-label">Search product</label>

                            <input type="text" class="form-control" name="searchName"/>
                        </div>
                        <button type="submit" class="btn btn-primary my-3">
                            <i class="fas fa-search"></i>
                        </button>
                    </div>
                </form>
            </div>
            <div class="col-md-2">
                <div class="nav-item dropdown dropdown-hover mx-2 ms-lg-6">
                    <a
                            class="nav-link ps-2 d-flex justify-content-between cursor-pointer align-items-center"
                            id="dropdownMenuPages8"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                    >
                        <i class="material-icons opacity-6 me-2 text-md">dashboard</i>
                        Categories
                        <img
                                src="../assets/img/down-arrow-white.svg"
                                alt="down-arrow"
                                class="arrow ms-2 d-lg-block d-none"
                        />
                        <img
                                src="../assets/img/down-arrow-dark.svg"
                                alt="down-arrow"
                                class="arrow ms-2 d-lg-none d-block"
                        />
                    </a>
                    <div
                            class="dropdown-menu dropdown-menu-animation ms-n3 dropdown-md p-3 border-radius-lg mt-0 mt-lg-3"
                            aria-labelledby="dropdownMenuPages8"
                    >
                        <div class="d-none d-lg-block">
                            <c:forEach items="${requestScope.CATEGORIES}" var="item">
                                <a
                                        href="/product?category=${item.categoryID}"
                                        class="dropdown-item border-radius-md"
                                >
                                    <span class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1">${item.categoryName}</span>
                                </a>

                            </c:forEach>


                        </div>
                        <div class="d-lg-none">
                            <h6
                                    class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1"
                            >
                                Landing Pages
                            </h6>
                            <a
                                    href="../pages/about-us.html"
                                    class="dropdown-item border-radius-md"
                            >
                                <span>About Us</span>
                            </a>
                            <a
                                    href="../pages/contact-us.html"
                                    class="dropdown-item border-radius-md"
                            >
                                <span>Contact Us</span>
                            </a>
                            <a
                                    href="../pages/author.html"
                                    class="dropdown-item border-radius-md"
                            >
                                <span>Author</span>
                            </a>
                            <h6
                                    class="dropdown-header text-dark font-weight-bolder d-flex align-items-center px-1 mt-3"
                            >
                                Account
                            </h6>
                            <a
                                    href="../pages/sign-in.html"
                                    class="dropdown-item border-radius-md"
                            >
                                <span>Sign In</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${requestScope.PRODUCTS.size() == 0}">
            <h3>There is no product match with '${requestScope.searchKeyword}' keyword</h3>
        </c:if>
        <div class="row align-items-center">
            <c:set var="count" scope="request" value="0"/>
            <c:forEach items="${requestScope.PRODUCTS}" var="product">

                <div class="col-lg-3 ms-auto mt-lg-0 mt-3 mb-3"
                     id="${requestScope.productID == product.ID ? 'addedProduct': null}">
                    <div class="card" style="width: 18rem">
                        <img
                                src="${product.imgUrl}"
                                class="card-img-top embed-responsive-item"
                                alt="..."
                        />


                        <form action="/Cart" method="post">
                            <div class="card-body">
                                <h5 class="card-title">${product.getName()}</h5>
                                <input name="productName" value="${product.getName()}" type="hidden"/>
                                <input name="action" value="addToCart" type="hidden">
                                <c:if test="${requestScope.productID == product.ID}">
                                    <c:choose>
                                        <c:when test="${requestScope.status == true}">
                                            <div class="d-flex justify-content-center align-items-center alert alert-success alert-dismissible fade show text-white mx-3"
                                                 role="alert">
                                                                <span class="material-icons mx-2">
                                                                    check_circle
                                                                </span>
                                                <span class="alert-text">Success!</span>
                                                <button type="button" class="btn-close" data-bs-dismiss="alert"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                        </c:when>
                                    </c:choose>
                                </c:if>

                                <p class="card-text">
                                        ${product.description}
                                </p>

                                <div class="input-group input-group-outline mb-4">
                                    <label class="form-label">Quantity</label>
                                    <input class="form-control" type="number" min="1" name="quantity" required/>
                                </div>
                                <p>${product.formatedPrice} VND</p>
                                <button
                                        class="btn bg-gradient-primary btn-icon"
                                        type="submit"
                                >
                                    <div class="d-flex align-items-center">
                                        Add to cart
                                        <i class="material-icons ms-2" aria-hidden="true"
                                        >add_shopping_cart
                                        </i>
                                    </div>
                                </button>
                            </div>
                        </form>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>

<c:import url="component/footer.jspf"/>

<c:import url="component/scripts.jspf"/>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script>
    document.getElementById("addedProduct").scrollIntoView();
</script>
</html>
