<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

      <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>        	
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-start">
			<b>이름:</b><input type="text" id="name" class="form-control col-3  ml-2" placeholder="이름을 입력해주세요.">
			<button type="button" id="nameCheckBtn" class="btn btn-info ml-2">중복확인</button>
		</div>
		<div id="statusArea">
			<span class="text-danger"></span>
		</div>
		<button type="submit" class="btn btn-success mt-4">가입하기</button>
	</div>
	
	<script>
		$(document).ready(function() {
			// 중복확인 버튼 클릭
			$('#nameCheckBtn').on('click', function(){
				
				$('#nameCheckBtn').empty();
				
				let name = $('#name').val().trim();
				
				
				if(name == ''){
					$('#statusArea').append("<small class='text-danger'>이름이 비어있습니다</span>");
					return;
				}
				
				
				$.ajax({
					type: 'get'
					, data: {'name' : name}
					, url: '/lesson06/ex02/is_duplication'
					, success: function(data){
						
					}
					, error : function(e){
						alert("error: " + e);
					}
					
				});
				
			});

		});
	</script>

</body>
</html>