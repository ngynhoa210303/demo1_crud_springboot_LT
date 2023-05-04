<%--
  Created by IntelliJ IDEA.
  User: thang
  Date: 2/16/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <form:form action="/may-tinh/store" method="POST" modelAttribute="mayTinhRequest">
            <form:input type="hidden" value="${mayTinh.getMa()}"  path="ma"/>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label >Tên: </label>
                        <form:input type="text" value="${mayTinh.getTen()}" path="ten" class="form-control"  />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label >giá: </label>
                        <form:input type="text" class="form-control"  path="gia"
                                    placeholder="Enter name" value=" ${mayTinh.getGia() }" />
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label >Bộ nhớ: </label>
                        <form:input type="text" class="form-control"  path="bonho"  value=" ${mayTinh.getBonho() } "/>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label class="form-label">Màu sắc: </label>
                        <form:radiobutton path="mauSac" name="mauSac" value="true" checked="${mayTinh.isMauSac()==true ? 'checked' : '' }" label="Đen"/>
                        <form:radiobutton path="mauSac" name="mauSac" value="false" checked="${mayTinh.isMauSac()== false? 'checked' : '' }" label="Bạc"/>
                        <br>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label>Hãng:</label>
                    <form:select class="form-select" aria-label="Default select example" path="hang">
                        <option value="MSI" <c:if test="${mayTinh.getHang()  == 'MSI'}">selected</c:if>>MSI</option>
                        <option value="ASUS" <c:if test="${mayTinh.getHang()  == 'ASUS'}">selected</c:if>>ASUS</option>
                        <option value="ACER" <c:if test="${mayTinh.getHang()  == 'ACER'}">selected</c:if>>ACER</option>
                        <option value="DELL" <c:if test="${mayTinh.getHang() == 'DELL'}">selected</c:if>>DELL</option>
                    </form:select>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div class="form-group">
                        <label>Mô tả: </label>
                        <form:input type="text" class="form-control"  path="moTa"  value=" ${mayTinh.getMoTa() } "/>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form:form>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Giá</th>
                <th scope="col">Bộ nhớ</th>
                <th scope="col">Màu sắc</th>
                <th scope="col">Hãng</th>
                <th scope="col">Mô Tả</th>
                <th scope="col">hành động</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listMayTinh.content }" var="mayTinh">
                <tr>
                    <td>${mayTinh.getMa()}</td>
                    <td>${mayTinh.getTen()}</td>
                    <td>${mayTinh.getGia() }</td>
                    <td>${mayTinh.getBoNho() }</td>
                    <td>${mayTinh.isMauSac() ? "Đen" : "Trắng"  }</td>
                    <td>${mayTinh.getHang()}</td>
                    <td>${mayTinh.getMoTa()}</td>
                    <td>
                        <a class="btn btn-primary" href="/may-tinh/detail?ma=${mayTinh.getMa()}">detail</a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/may-tinh/view-update?ma=${mayTinh.getMa()}">update</a>
                    </td>
                    <td>
                        <a class="btn btn-primary" href="/may-tinh/delete?ma=${mayTinh.getMa()}">xóa</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <div class="">

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:forEach  begin="0" end="${ listMayTinh.totalPages -1}" varStatus="loop">
                        <li class="page-item"><a class="page-link" href="/may-tinh/hien-thi?page= ${loop.begin + loop.count - 1}"> ${loop.begin + loop.count }</a></li>
                    </c:forEach>
                </ul>
            </nav>

        </div>
    </div>
</div>
</body>
</html>
