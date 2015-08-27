<%@ taglib tagdir="/WEB-INF/tags" prefix="tg"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Redirect</title>
</head>
<body>
	${controller} / ${action}
	<tg:view />
	
	<div id="content"></div>
	
	<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$.post('${linkTo[MyController].ajax}', function(response) {
				$('#content').append(JSON.stringify(response));
			}, 'json');
		});
	</script>
</body>
</html>