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
</head>
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
  crossorigin="anonymous"
/>
<body>
    <div class="container">
        <div>edit</div>
        <div>
            <c:set var="form_action" value="update"/>
            <c:if test="${empty resultMap}">
            <c:set var="form_action" value="uploadMultiImg"/>
            <%-- <c:set var="form_action" value="insert"/> --%>
            </c:if>

            <form action="/userData/${form_action}" method="post" enctype ="multipart/form-data">
                <%-- insert two file --%>
                <div class="form-group form-row">
                    <label class="form-label">File Upload</label>
                    <input type="file" name="file_first" class="form-control"> 
                </div>
                <div class="form-group form-row">
                    <label class="form-label">File Upload</label>
                    <input type="file" name="file_second" class="form-control"> 
                </div>

                <div class="form-group form-row">
                    <div class="col">
                        <label>UID</label> <input class="form-control" type="text"
                            name="USER_UID" value="${resultMap.USER_UID}"
                            required ${form_action == "update" ? "readonly" : ""} />
                        <div class="invalid-tooltip"></div>
                    </div>
                </div>
                <div class="form-group form-row">
                    <div class="col">
                       <label>이름 </label> <input class="form-control" type="text"
                            name="NAME" value="${resultMap.NAME}" placeholder="이름" required ${statusDisabled}/>
                        <div class="invalid-tooltip"></div>
                    </div>
                </div>
                    <div class="col">
                        <label>아이디 </label> <input class="form-control" type="text"
                            name="ID" value="${resultMap.ID}" placeholder="아이디" required ${statusDisabled}/>
                        <div class="invalid-tooltip"></div>
                    </div>
                </div>
                    <div class="col">
                        <label>비밀번호 </label> <input class="form-control" type="text"
                            name="PASSWORD" value="${resultMap.PASSWORD}" placeholder="비밀번호" required ${statusDisabled}/>
                        <div class="invalid-tooltip">
                            
                        </div>
                    </div>
                </div>
                    <div class="col">
                        <label>전화번호 </label> <input class="form-control" type="text"
                            name="PHONE_NUMBER" value="${resultMap.PHONE_NUMBER}" placeholder="전화번호" required ${statusDisabled}/>
                        <div class="invalid-tooltip">
                            
                        </div>
                    </div>
                </div>
                    <div class="col">
                        <label>생일 </label> <input class="form-control" type="text"
                            name="BIRTHDAY" value="${resultMap.BIRTHDAY}" placeholder="생일" required ${statusDisabled}/>
                        <div class="invalid-tooltip">
                            
                        </div>
                    </div>
                </div>
                    <div class="col">
                        <label>이메일 주소 </label> <input class="form-control" type="text"
                            name="EMAIL" value="${resultMap.EMAIL}" placeholder="이메일" required ${statusDisabled}/>
                        <div class="invalid-tooltip">
                            
                        </div>
                    </div>
                </div>

                    <div class="col">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" name="SMS_AD"
                                
                                ${resultMap.SMS_AD == '1' ? 'checked' : ''}
                                ${statusDisabled}> <label class="form-check-label">sms 수신여부</label>
                        </div>
                    </div>
                </div>
                    <div class="col">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" name="EMAIL_AD"
                                    ${resultMap.EMAIL_AD == '1' ? 'checked' : ''}
                                ${statusDisabled}> <label class="form-check-label">이메일 수신여부</label>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <button class="btn btn-primary">
                        ${form_action}
                    </button>
                    <button class="btn btn-outline-info">
                        List
                    </button>
                </div>
            <div>
        </form>
    <div>
</body>
</html>