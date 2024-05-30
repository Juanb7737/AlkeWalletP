<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="model.Cuenta"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h1>Bienvenido a la Wallet </h1>
		<%
		List<Cuenta> lista = (List) request.getAttribute("cuenta");
		out.print("Hay un total de " + lista.size() + " una cuenta asociada al cliente");
		%>
		<table class="table table-striped table-hover">
			<thead class="table-light">
				<tr>
					<th>ID</th>
					<th>saldo</th>
					<th>banco</th>
					<th>numcuenta</th>
					<th>run_cliente</th>

				</tr>
			</thead>
			<%
			for (int i = 0; i < lista.size(); i++) {
				out.print("<tr><td>" + lista.get(i).getIdcuenta() + "</td><td>" + lista.get(i).getSaldo() + "</td><td>"
				+ lista.get(i).getBanco() + "</td><td>" + lista.get(i).getNumcuenta() + "</td><td>"
				+ lista.get(i).getRun_cliente() + "</td></tr>");
			}
			%>

		</table>
		<hr>
		<h3>Depositar</h3>
		<br>
		<form action="deposito" method="post">
			<div class="form-group">
				<label for="saldo">Saldo</label> <input type="number"
					class="form-control" id="monto" name="monto"
					placeholder="Ingrese Monto" min="1" required="required">

			</div>

			<button type="submit" class="btn btn-primary">Depositar</button>

		</form>

		<hr>
		<h3>Retirar</h3>
		<br>
		<form action="retiro" method="post">
			<div class="form-group">
				<label for="montoretiro">Retirar Saldo</label> <input type="number"
					class="form-control" id="montoretiro" name="montoretiro"
					placeholder="Ingrese Monto" min="1" required="required">

			</div>

			<button type="submit" class="btn btn-primary">Retiro</button>
		</form>
	</div>
</body>
</html>