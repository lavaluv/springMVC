<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE</title>
</head>
<body>
	<div id = "fromPush"></div>
	<script src="assets/js/jquery.js" type="text/javascript"></script>
	<script type="text/javascript">
		if(!!window.EventSource){
			var source= new EventSource('push');
			s='';
			source.addEventListener('message',function(e){
				s+=e.data+"<br/>";
				$("#fromPush").html(s);
			});
			source.addEventListener('open',function(e){
				console.log("connect");
			},false);
			source.addEventListener('error',function(e){
				if(e.readyState == EventSource.CLOSED){
					console.log("deconnect");
				}
				else{
					console.log(e.readyState);
				}
			},false);
		}
		else{
			console.log("not support SSE");
		}
	</script>
</body>
</html>