<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="box box-default">
	<div class="box-header with-border" align="center">
		<div class="container col-md-12" align="center">
			<c:if test="${msg==1}">
				<div class="col-md-12 container" align="center"
					style="text-align: center;">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<h4>
							<i class="icon fa fa-check"></i> Correcto!
						</h4>
						Lista actualizada
					</div>
				</div>
			</c:if>
			<c:if test="${msg==0}">
				<div class="col-md-12 container" align="center"
					style="text-align: center;">
					<div class="alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						<h4>
							<i class="icon fa fa-ban"></i> Error!
						</h4>
						No Carga Lista
					</div>
				</div>
			</c:if>
			<div class="box-body">
				<div class="container col-md-12" align="center">
					<BR>

					<div class="col-sm-12">
						<table id="example2"
							class="table table-bordered table-hover dataTable" role="grid"
							aria-describedby="example2_info">
							<thead>
								<tr>
									<th>CIP</th>
									<th>GRADO</th>
									<th>APELLIDO PAT</th>
									<th>APELLIDO MAT</th>
									<th>NOMBRES</th>
									<th>ESTADO</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${lista}" var="element">
									<tr>
										<td>${element.cip}</td>
										<td>${element.grado}</td>
										<td>${element.apepat}</td>
										<td>${element.apemat}</td>
										<td>${element.nombres}</td>
										<td><c:choose>
												<c:when test="${element.estado==1}">ACTIVADO</c:when>
												<c:otherwise>DESACTIVADO </c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>

				</div>
			</div>
			<br> <br>

		</div>
	</div>
</div>



