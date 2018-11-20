<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8"/>
		
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		
	    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
	
	    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet"/>
	
	    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet"/>
	
	    <link href="<s:url value="/resources/css/style.css"/>" rel="stylesheet"/>
	
	    <title> Pesquisa Produtos </title>
	</head>
	
	<body>
		<section class="container">
			<h3 class="page-header">
				Pesquisa Produtos
			</h3>

			<s:url value="/produtos/pesquisa" var="acaoProdutos"/>
			
			<sf:form method="post" modelAttribute="produto" action="${acaoProdutos}">
				<div class="panel panel-default">
					<div class="panel-heading">
						Produtos
					</div>
					
					<div class="panel-body">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label class="control-label" for="codigo">
										Código: 
									</label>
									
									<sf:input path="id" cssClass="form-control" />
								</div>
							</div>
							
							<div class="col-sm-8">
								<div class="form-group">
									<label class="control-label" for="descricao">
										Descrição: 
									</label>
									
									<sf:input path="descricao" cssClass="form-control" />
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<button class="btn btn-default" type="submit">
								<span class="fa fa-search"></span>
								Pesquisar
							</button>
						</div>
					</div>
				</div>			
			</sf:form>						
			
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Código</th>
						<th>Descrição</th>
						<th>Preço</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${produtos}" var="produto">
						<tr>
							<td>${produto.id}</td>
							<td>${produto.descricao}</td>
							<td>
								<fmt:formatNumber value="${produto.valor}" type="currency"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
		
		<div class="container">
	    	<hr />
	    	
		    <footer>
		    	<h4>Exemplo de consulta em JSP</h4>
			</footer>	
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>		
	</body>
</html>