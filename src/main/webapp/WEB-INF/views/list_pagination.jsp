<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
  crossorigin="anonymous"
/>
</head>
<body>
  <div class="container">
    <div>list</div>
    <div>
    <form action="/userData/formMulti" method="get">
      <button class="btn btn-info">Upload Multi Image File</button>
    </form>
    </div>
    <%-- pagination --%>
    <nav aria-label="Page navigation example">
      <c:set var="_pagination" value="${resultMap.paginations}" />
      <span>총 갯수 : ${_pagination.totalCount}</span>
      <ul class="pagination">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
      <%-- for(int i=0;i > 9;i++){} --%>
      <c:forEach var="i" begin="${_pagination.blockStart}" end="${_pagination.blockEnd}">
        <li class="page-item"><a class="page-link" href="/userData/listPagination/${i}">${i}</a></li>
      </c:forEach>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>
    </nav>


    <table class="table table-striped table-hover table-bordered">
      <thead>
        <tr>
          <th>USER_UID</th>
          <th>NAME</th>
          <th>ID</th>
          <th>PASSWORD</th>
          <th>PHONE_NUMBER</th>
          <th>BIRTHDAY</th>
          <th>EMAIL</th>
          <th>SMS_AD</th>
          <th>EMAIL_AD</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${resultMap.resultList}" var="resultData" varStatus="loop">
          <tr>
            <td>${resultData.USER_UID}</td>
            <td>
              <form action="/userData/edit/${resultData.USER_UID}" method="get">
                <button class="btn btn-link viewPopup">
                  ${resultData.NAME}
                </button>
              </form>
            </td>
            <td>${resultData.ID}</td>
            <td>${resultData.PASSWORD}</td>
            <td>${resultData.PHONE_NUMBER}</td>
            <td>${resultData.BIRTHDAY}</td>
            <td>${resultData.EMAIL}</td>
            <td>${resultData.SMS_AD}</td>
            <td>${resultData.EMAIL_AD}</td>
            <td>
              <form
              action="/userData/delete/${resultData.USER_UID}" method="post">
              <button class="btn outline-info">Delete</button>
            </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <div>
      <form action="/userData/edit/insert" method="get">
        <button class="btn btn-link viewPopup">Insert User</button>
      </form>
    </div>
  </div>
</body>
</html>