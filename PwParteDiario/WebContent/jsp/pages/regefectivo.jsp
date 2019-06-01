<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="box box-default">
	<c:if test="${msg==1}">
		<div class="col-md-12 container" align="center"
			style="text-align: center;">
			<div class="alert alert-success alert-dismissible">
				<button type="button" class="close" data-dismiss="alert"
					aria-hidden="true">×</button>
				<h4>
					<i class="icon fa fa-check"></i> Bien!
				</h4>
				Efectivo Grabado Correctamente
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
				No fue posible registrar, verifique que los datos sean vàlidos
			</div>
		</div>
	</c:if>
	<form action="Sefectivo" method="post">
		<input type="hidden" name="action" value="regefectivo"> <input
			type="hidden" name="idefectivo" value="${objefe.idefectivo}">
		<div class="box-header with-border" align="center">
			<div class="row">
				<div class="col-md-6">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Datos Personales</h3>
						</div>
						<div class="box-body">
							<div class="input-group">
								<span class="input-group-addon">Apellido Paterno</span> <input
									type="text" class="form-control" name="txtapepat"
									placeholder="Apellido Paterno" required="required"
									value="${objefe.apepat}">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Apellido Materno</span> <input
									type="text" class="form-control" name="txtapemat"
									placeholder="Apellido Materno" required="required"
									value="${objefe.apemat}">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nombres</span> <input
									type="text" class="form-control" name="txtnombres"
									placeholder="Nombres" required="required"
									value="${objefe.nombres}">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">DNI</span> <input type="text"
									class="form-control" name="txtdni" placeholder="Nombres"
									required="required" value="${objefe.dni}">
							</div>
							<br>

							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control" name="txtemail"
									placeholder="Email" required="required"
									value="${objefe.correo}">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Teléfono</span> <input
									type="text" class="form-control" name="txttelefono"
									placeholder="teléfono" required="required"
									value="${objefe.telefono}">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Domicilio</span> <input
									type="text" class="form-control" name="txtdomicilio"
									placeholder="domicilio" required="required"
									value="${objefe.domicilio}">
							</div>
							<br>
						</div>
						<!-- /.box-body -->
					</div>
				</div>
				<div class="col-md-6">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Datos Laborales</h3>
						</div>
						<div class="input-group">
							<span class="input-group-addon">CIP</span> <input type="text"
								class="form-control" name="txtcip" placeholder="Cip"
								required="required" value="${objefe.cip}">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Grado</span> <select id="grado"
								name="txtgrado" class="form-control" required="required">
								<option value="">Seleccione</option>
								<option value="21">CRNL PNP</option>
								<option value="20">CMDTE PNP</option>
								<option value="19">MAY PNP</option>
								<option value="18">CAP PNP</option>
								<option value="17">ALF PNP</option>
								<option value="16">SS PNP</option>
								<option value="15">SB PNP</option>
								<option value="14">ST1 PNP</option>
								<option value="13">ST2 PNP</option>
								<option value="12">ST3 PNP</option>
								<option value="11">S1 PNP</option>
								<option value="10">S2 PNP</option>
								<option value="9">S3 PNP</option>
								<option value="8">SS SPNP</option>
								<option value="7">SB SPNP</option>
								<option value="6">ST1 SPNP</option>
								<option value="5">ST2 SPNP</option>
								<option value="4">ST3 SPNP</option>
								<option value="3">S1 SPNP</option>
								<option value="2">S2 SPNP</option>
								<option value="1">S3 SPNP</option>
							</select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Jerarquia</span> <select
								id="jerarquia" name="txtjerarquia" class="form-control"
								required="required">
								<option value="">Seleccione</option>
								<option value="4">EMPLEADO CIVIL</option>
								<option value="3">SUBOFICIAL DE SERVICIOS</option>
								<option value="2">SUBOFICIAL DE ARMAS</option>
								<option value="1">OFICIAL DE ARMAS</option>
							</select>
						</div>
						<br>

						<div class="input-group">
							<span class="input-group-addon">Area</span> <select id="area"
								name="txtarea" class="form-control" required="required">
								<option value="">Seleccione</option>
								<option value="1">JEFATURA</option>
								<option value="2">SECRETARIA</option>
								<option value="3">OFAD</option>
								<option value="4">CAPTURAS</option>
								<option value="5">SECCOJUD</option>
								<option value="6">GRADO FUERZA</option>
								<option value="7">MENORES</option>
								<option value="8">SECPOJ LIMA NORTE</option>
							</select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Cargo</span> <select id="cargo"
								name="txtcargo" class="form-control" required="required">
								<option value="">Seleccione</option>
								<option value="1">JEFE DE DEPARTAMENTO</option>
								<option value="2">JEFE</option>
								<option value="3">SEC TM / MESA PARTES PROV T/T</option>
								<option value="4">MESA DE PARTES LIMA-CALLAO</option>
								<option value="5">REG.CAP.LC - SUSP CAP.</option>
								<option value="6">MESA DE PARTES PROVINCIA</option>
								<option value="7">SECRETARIO TT</option>
								<option value="8">REG.SUSP.CAP. Y CAP.L.N.</option>
								<option value="9">REGISTRO CAPTURA LIMA-CALLAO</option>
								<option value="10">ARCHIVO</option>
								<option value="11">CEOPOL Y PERSONAL</option>
								<option value="14">IMPLEMENTACION BASE DE DATOS</option>
								<option value="16">SECRETARIA</option>
								<option value="18">MESA PARTES</option>
								<option value="19">SECRETARIA/MESA PARTES</option>
								<option value="21">LIMA NORTE</option>
							</select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Modalidad</span> <select
								id="modalidad" name="txtmodalidad" class="form-control"
								required="required">
								<option value="">Seleccione</option>
								<option value="1">ALFA 24X24</option>
								<option value="2">BRAVO 24X24</option>
								<option value="3">ADMINISTRATIVO T1 (08:00 hrs - 17:00
									hrs)</option>
								<option value="4">ADMINISTRATIVO T2 (14:00 hrs - 22:00
									hrs)</option>
								<option value="5">ADMINISTRATIVO T3 (08:00 hrs - 15:45
									hrs)</option>
								<option value="6">ADMINISTRATIVO T4 (14:00 hrs - 21:45
									hrs)</option>
							</select>
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Estado</span> <select id="estado"
								name="txestado" class="form-control" required="required">
								<option value="">Seleccione</option>
								<option value="1">ACTIVADO</option>
								<option value="0">DESACTIVADO</option>
							</select>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.box-body -->
				</div>
			</div>
			<div class="container" align="center">
				<div class="col-md-12">
					<button type="submir" class="btn btn-block btn-primary btn-lg">REGISTRAR</button>
				</div>
			</div>
		</div>
	</form>
	<div class="box-body">
		<div class="container col-md-12" align="center">
			<BR>

			<div class="col-sm-12">
				<table id="example2"
					class="table table-bordered table-hover dataTable" role="grid"
					aria-describedby="example2_info">
					<thead>
						<tr>
							<th>Nº</th>
							<th>APELLIDO PAT</th>
							<th>APELLIDO MAT</th>
							<th>NOMBRES</th>
							<th>CIP</th>
							<th>DNI</th>
							<th>TELEFONO</th>
							<th>CORREO</th>
							<th>ESTADO</th>
							<th>Seleccionar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${lista}" var="element" varStatus="count">
							<tr>
								<td>${count.index+1}</td>
								<td>${element.apepat}</td>
								<td>${element.apemat}</td>
								<td>${element.nombres}</td>
								<td>${element.cip}</td>
								<td>${element.dni}</td>
								<td>${element.telefono}</td>
								<td>${element.correo}</td>
								<td><c:choose>
										<c:when test="${element.estado==1}">ACTIVADO</c:when>
										<c:otherwise>DESACTIVADO </c:otherwise>
									</c:choose></td>
								<td><a
									href="Sefectivo?action=getefe&id=${element.idefectivo}">
										Seleccionar</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		// 			function creartablita(lista){
		// 				var  objeto=lista;
		// 				var response = JSON.parse(objeto);
		// 				alert('gggg');
		// 				  var $table = $('<table id="example2" class="table table-bordered table-hover dataTable"  role="grid" aria-describedby="example2_info"><thead><tr><th>Nro</th><th>Grado</th><th>A. Paterno</th><th>A. Materno</th><th>Nombres</th><th>DNI</th><th>CIP</th><th>correo</th><th>telefono</th><th>domicilio</th><th>modalidad</th><th>area</th><th>cargo</th><th>jerarquia</th><th>estado</th><th>Actualizar</th></tr></thead><tbody></tbody></table>');
		// 				  $.each(response, function(i, item) {
		// 				      var botonvalidar='<a href="javascript:validar('+item.IDEFECTIVO+');">Validar</a>';
		// 					  var tr = $('<tr>').append(
		// 				        $('<td>').text(i+1),
		// 				          $('<td>').text(item.DESGRAD),
		// 				          $('<td>').text(item.APEPAT),
		// 				          $('<td>').text(item.APEMAT),
		// 				          $('<td>').text(item.NOMBRES),
		// 				          $('<td>').text(item.DNI),
		// 				          $('<td>').text(item.CIP),
		// 				          $('<td>').text(item.CORREO),
		// 				          $('<td>').text(item.TELEFONO),
		// 				          $('<td>').text(item.DOMICILIO),
		// 				          $('<td>').text(item.MODALIDAD),
		// 				          $('<td>').text(item.AREA),
		// 				          $('<td>').text(item.CARGO),
		// 				          $('<td>').text(item.JERARQUIA),
		// 				          $('<td>').text(item.ESTADO),
		// 				          $('<td>').html(botonvalidar)
		// 				      ); 
		// 				      $table.append(tr); 
		// 				  });
		// 				    $(".wrapper").html($table)

		// 			}

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
