<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="box box-default">
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
								placeholder="Apellido Paterno">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Apellido Materno</span> <input
								type="text" class="form-control" name="txtapemat"
								placeholder="Apellido Materno">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Nombres</span> <input type="text"
								class="form-control" name="txtnombres" placeholder="Nombres">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">DNI</span> <input type="text"
								class="form-control" name="txtdni" placeholder="Nombres">
						</div>
						<br>

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
							<input type="email" class="form-control" name="txtemail"
								placeholder="Email">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Teléfono</span> <input
								type="text" class="form-control" name="txttelefono"
								placeholder="teléfono">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">Domicilio</span> <input
								type="text" class="form-control" name="txtdomicilio"
								placeholder="domicilio">
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
							class="form-control" name="txtcip" placeholder="Cip">
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon">Grado</span> <select id="grado"
							name="txtgrado" class="form-control" required="required">
							<option value="">Seleccione</option>
							<option value="25">CRNL PNP</option>
							<option value="24">CRNL PNP</option>
							<option value="23">CRNL PNP</option>
							<option value="22">CRNL PNP</option>
							<option value="21">CRNL PNP</option>
							<option value="20">CMDTE PNP</option>
							<option value="19">MAY PNP</option>
							<option value="18">SS PNP</option>
							<option value="17">SB PNP</option>
							<option value="16">ST1 PNP</option>
							<option value="15">ST2 PNP</option>
							<option value="14">ST3 PNP</option>
							<option value="13">S1 PNP</option>
							<option value="12">S2 PNP</option>
							<option value="11">CRNL PNP</option>
							<option value="10">CMDTE PNP</option>
							<option value="9">MAY PNP</option>
							<option value="8">SS PNP</option>
							<option value="7">SB PNP</option>
							<option value="6">ST1 PNP</option>
							<option value="5">ST2 PNP</option>
							<option value="4">ST3 PNP</option>
							<option value="3">S1 PNP</option>
							<option value="2">S2 PNP</option>
							<option value="1">S3 PNP</option>
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
						<span class="input-group-addon">Area</span> <select id="jerarquia"
							name="txtjerarquia" class="form-control" required="required">
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
							id="cargo" name="txtcargo" class="form-control"
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
				<div class="col-md-12" >
		<button type="button" class="btn btn-block btn-primary btn-lg">REGISTRAR</button>
		</div>
		</div>
	</div>
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
</div>
