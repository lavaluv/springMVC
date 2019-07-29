<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DemoConverter</title>
</head>
<body>
	<div id = "resq"></div><input id = "in" type="button" onclick="req();" value="request"/>
	<script src="assets/js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		function req(){
			$.ajax({
				url:"convert",
				data:"1-hbq",
				type:"POST",
				contentType:"application/x-wisely",
				success:function(data){
					$("#resp").html(data);
				}
			});
		}
	</script>
</body>
</html>