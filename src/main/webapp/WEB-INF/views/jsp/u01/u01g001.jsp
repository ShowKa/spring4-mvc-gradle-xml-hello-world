<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/jsp/header.jsp"%>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">顧客検索</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<form>
			<div class="form-group">
				<label for="exampleInputEmail1">顧客コード</label> <input
					type="text" class="form-control" id="kokyaku_code"
					placeholder="顧客コード">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">顧客名</label> <input
					type="text" class="form-control" id="kokyaku_mei"
					placeholder="顧客名">
			</div>
			<button type="submit" class="btn btn-default">検索</button>
		</form>
	</div>

	<%@ include file="/WEB-INF/views/jsp/footer.jsp"%>
</body>
</html>