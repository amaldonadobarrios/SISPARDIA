<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var = "now" value = "<%= new java.util.Date()%>" />
<div class="box box-default">
	<c:if test="${msg==1}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-check"></i> Encontrado!
				</h4>
				Efectivo existe
			</div>
		</div>
	</c:if>
	<c:if test="${msg==6}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-check"></i> Grabado!
				</h4>
				Situacion registrada
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
				No existe o cip no coincide o no esta activado
			</div>
		</div>
	</c:if>
	<c:if test="${msg==4}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Error!
				</h4>
				Fecha no valida
			</div>
		</div>
	</c:if>
	<c:if test="${msg==7}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Error!
				</h4>
				Fecha  no puede ser pasada
			</div>
		</div>
	</c:if>
	<c:if test="${msg==5}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Error!
				</h4>
				No fue posible registrar una situacion
			</div>
		</div>
	</c:if>
	<c:if test="${msg==4}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Error!
				</h4>
				Fecha no valida
			</div>
		</div>
	</c:if>
	<c:if test="${msg==3}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-danger alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-ban"></i> Error!
				</h4>
				Seleccione un Efectivo antes
			</div>
		</div>
	</c:if>
	<div class="box-header with-border" align="center">
		<div class="container" align="center">
				<div class="col-md-12">
					<input type="hidden" value=getefecip name="action">
					<div class="form-group">
						<label><p>Generar Parte Diario  del  dia: <fmt:formatDate pattern = "dd/MM/yyyy"  value = "${now}"/></p></label> 
						<a type="button" href="SParte?action=genParte" target="_blank" class="btn bg-orange btn-flat margin form-control pull-right">Generar</a>
					</div>
				</div>	
		</div>
	</div>
	<div class="box-body" align="center">
		<div class="container col-md-12" align="center">
			<BR>
			<h4>Partes  Diarios Generados</h4>
			<div class="col-sm-12">
				<table id="example2"
					class="table table-bordered table-hover dataTable" role="grid"
					aria-describedby="example2_info">
					<thead>
						<tr>
							<th>Nº</th>
							<th>FECHA REGISTRO</th>
							<th>SITUACION</th>
							<th>FECHA INICIO</th>
							<th>FECHA FIN</th>
							<th>RANGO</th>
							<th>OBSERVACIONES</th>
							<th>ESTADO</th>
							<th>VIGENCIA</th>
							<th>USUARIO REGISTRO</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="element" varStatus="count">
							<tr>
								<td>${count.index+1}</td>
								<td>${element.fechareg}</td>
								<td>${element.situacion}</td>
								<td>${element.fini}</td>
								<td>${element.ffin}</td>
								<td>${element.rango}</td>
								<td>${element.obs}</td>
								<td>${element.estado}</td>
								<td>${element.vigencia}</td>
								<td>${element.usureg}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>

		</div>
	</div>

	<script type="text/javascript">
	function checkindet() {
		  var checkBox = document.getElementById("indet");
		  var fini = document.getElementById("divfin");
		  var frange = document.getElementById("divran");
		  if (checkBox.checked == false){
			  frange.style.display = "block";
			  fini.style.display = "none";
		  } else {
			  fini.style.display = "block";
			  frange.style.display = "none";
		  }
		}
		window.onload = function() {
			 
			document.getElementById("grado").value = ${objefe.grado};
			document.getElementById("area").value = ${objefe.idarea};
			document.getElementById("cargo").value = ${objefe.idcargo};
			document.getElementById("jerarquia").value = ${objefe.idjerarquia};
			document.getElementById("modalidad").value = ${objefe.idmodalidad};
			document.getElementById("estado").value = ${objefe.estado};
		};
	</script>
</div>
