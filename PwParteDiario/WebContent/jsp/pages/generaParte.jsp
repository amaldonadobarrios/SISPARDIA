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
						<a type="button" href="SParte?action=genParte"  onclick="refrescar(5000);" target="_blank" class="btn bg-orange btn-flat margin form-control pull-right">Generar</a>
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
							<th>FECHA PARTE</th>
							<th>USUARIO REGISTRA</th>
							<th>DESCARGAR PARTE</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="element" varStatus="count">
							<tr>
								<td>${count.index+1}</td>
								<td><fmt:formatDate  type = "both"  dateStyle = "short" timeStyle = "short" value = "${element.fechareg}" /></td>
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${element.fechaparte}" /></td>
								<td>${element.usureg}</td>
								<td><a href="SParte?action=conParte&id=${element.idpartediario}"> Descargar</a></td>
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
	 function refrescar(tiempo){
		    setTimeout("location.reload(true);", tiempo);
		  }
		window.onload = function() {
			 
				 // refrescar(10000);
		};
	</script>
</div>
