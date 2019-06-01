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
			<form action="Sefectivo" method="post">
				<div class="col-md-12">
					<input type="hidden" value=getefecip name="action">
					<div class="form-group">
						<label>Buscar por Cip</label> <input type="text"
							class="form-control pull-right" id="" value="" name="bcip">
					</div>
					<!-- /.form-group -->
					<button type="submit" class="btn btn-info">BUSCAR</button>
					<!-- /.form-group -->
				</div>
			</form>
		</div>
	</div>
	<form action="Sefectivo" method="post">
		<input type="hidden" name="action" value="regSituacion"> <input
			type="hidden" name="idefectivo" value="${objefe.idefectivo}"
			required="required" readonly="readonly">
		<div class="box-header with-border" align="center">
			<div class="row">
				<div class="col-md-6">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Datos Personales</h3>
						</div>
						<div class="box-body">
							<div class="input-group">
								<span class="input-group-addon">Grado</span> <select id="grado"
									name="txtgrado" class="form-control" disabled="disabled">
									<option value="">Seleccione</option>
									<option  value="21">CRNL PNP</option>
									<option  value="20">CMDTE PNP</option>
									<option  value="19">MAY PNP</option>
									<option  value="18">CAP PNP</option>
									<option  value="17">ALF PNP</option>
									<option  value="16">SS PNP</option>
									<option  value="15">SB PNP</option>
									<option  value="14">ST1 PNP</option>
									<option  value="13">ST2 PNP</option>
									<option  value="12">ST3 PNP</option>
									<option  value="11">S1 PNP</option>
									<option  value="10">S2 PNP</option>
									<option  value="9">S3 PNP</option>
									<option  value="8">SS SPNP</option>
									<option  value="7">SB SPNP</option>
									<option  value="6">ST1 SPNP</option>
									<option  value="5">ST2 SPNP</option>
									<option  value="4">ST3 SPNP</option>
									<option  value="3">S1 SPNP</option>
									<option  value="2">S2 SPNP</option>
									<option  value="1">S3 SPNP</option>
								</select>
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Apellido Paterno</span> <input
									type="text" class="form-control" name="txtapepat"
									placeholder="Apellido Paterno" value="${objefe.apepat} "
									disabled="disabled">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Apellido Materno</span> <input
									type="text" class="form-control" name="txtapemat"
									placeholder="Apellido Materno" value="${objefe.apemat}"
									disabled="disabled">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Nombres</span> <input
									type="text" class="form-control" name="txtnombres"
									placeholder="Nombres" value="${objefe.nombres}"
									disabled="disabled">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">CIP</span> <input type="text"
									class="form-control" name="txtcip" placeholder="Cip"
									value="${objefe.cip}" disabled="disabled">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">DNI</span> <input type="text"
									class="form-control" name="txtdni" placeholder="Nombres"
									value="${objefe.dni}" disabled="disabled">
							</div>
							<br>
							<div class="input-group">
								<span class="input-group-addon">Jerarquia</span> <select
									id="jerarquia" name="txtjerarquia" class="form-control"
									disabled="disabled">
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
									name="txtarea" class="form-control" disabled="disabled">
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
									name="txtcargo" class="form-control" disabled="disabled">
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
									disabled="disabled">
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
								<span class="input-group-addon">Estado</span> <select
									id="estado" name="txestado" class="form-control"
									disabled="disabled">
									<option value="">Seleccione</option>
									<option value="1">ACTIVADO</option>
									<option value="0">DESACTIVADO</option>
								</select>
							</div>

						</div>
						<!-- /.box-body -->
					</div>
				</div>
				<div class="col-md-6">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">Agregar situacion</h3>
						</div>

						<div class="input-group">
							<span class="input-group-addon">SITUACION</span> <select
								id="situacion" name="txtsituacion" class="form-control"
								required="required">
								<option value="">Seleccione</option>
								<option value="1">CURSO</option>
								<option value="2">VACACIONES</option>
								<option value="3">PERMISO</option>
								<option value="4">CONCURRENCIA</option>
								<option value="5">COMISION</option>
								<option value="6">SOMETIDO A LEY</option>
								<option value="7">DESTACADO</option>
								<option value="8">LICENCIA</option>
								<option value="9">ADAPTACION A LA VIDA CIVIL</option>
								<option value="10">FALTO</option>
								<option value="11">DISPONIBLE</option>
							</select>
						</div>
						<br>
						<div class="form-group">
                  <div class="checkbox">
                    <label>
                      <input type="checkbox" name="indeterminado" id="indet" onclick="checkindet()">
                      Indeterminada la fecha de finalización de la situación
                    </label>
                  </div>

                </div>
                
						<br>
						<div class="form-group" id="divfin" style="display: none;" >
							<label>Fecha Inicio:</label>

							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									id="datepicker" name="txtfechaini">
							</div>
							<!-- /.input group -->
						</div>
						<br>
              <div class="form-group" id="divran">
              <div class="form-group">
                <label>Rango de Fechas</label>

                <div class="input-group">
                  <div class="input-group-addon">
                    <i class="fa fa-calendar"></i>
                  </div>
                  <input type="text" class="form-control pull-right" id="reservation" name="txtfecharange">
                </div>
                <!-- /.input group -->
              </div>
              </div>
				<BR>
				<div class="input-group">
								<span class="input-group-addon">Observaciones</span> <input
									type="text" class="form-control" name="txtobservaciones"
									placeholder="Nombres" value=""
									required="required">
							</div>
							<br>
						<!-- /input-group -->
					</div>
					<!-- /.box-body -->
				</div>
			</div>
			<div class="container" align="center">
				<div class="col-md-12">
					<button type="submit" class="btn btn-block btn-primary btn-lg">REGISTRAR</button>
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
