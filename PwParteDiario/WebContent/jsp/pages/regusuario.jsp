<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   <div class="box box-default"> 
   <div class="box-header with-border" align="center">
    <div class="container col-md-12" align="center"> 
    <c:if test="${msg==1}">  
    <div class="col-md-12 container" align="center" style="text-align: center;">
        <div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-check"></i> Correcto!</h4>
                Usuario Creado.
              </div>
              </div>
    </c:if>
     <c:if test="${msg==0}">  
    <div class="col-md-12 container" align="center" style="text-align: center;">
        <div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-ban"></i> Error!</h4>
                Datos no validos
              </div>
              </div>
    </c:if>
<form action="Sregistrar" method="post">

 <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>CIP</label>
                 <input type="text" class="form-control pull-right" id="" value="${objusu.cip}" name="txtcip" required="required">
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                <label>PASSWORD</label>
                 <input type="password" class="form-control pull-right" id="" value="${objusu.password}" name="txtpass" required="required">
              </div>
              <div class="form-group">
                <label>CONFIRMAR PASSWORD</label>
                 <input type="password" class="form-control pull-right" id=""value="${objusu.password}" name="txtpass2" required="required">
              </div>
              <div class="form-group">
                <label>GRADO</label>
                 <select id="grado" name="txtgrado" class="form-control" required="required">
                                    <option  value="" >Seleccione</option>         
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
              <!-- /.form-group -->
            </div>
            <!-- /.col -->
            <div class="col-md-6">
              <div class="form-group">
                <label>APELLIDO PATERNO</label>
                 <input type="text" class="form-control pull-right" id="" value="${objusu.apepat}"name="txtapepat" required="required">
              </div>
              <!-- /.form-group -->
              <div class="form-group">
                <label>APELLIDO MATERNO</label>
                 <input type="text" class="form-control pull-right" id="" value="${objusu.apemat}"name="txtapemat" required="required">
              </div>
              <div class="form-group">
                <label>NOMBRES</label>
                 <input type="text" class="form-control pull-right" id="" value="${objusu.nombres}" name="txtnom" required="required">
              </div>
              <div class="form-group">
                <label>ESTADO</label>
                <select class="form-control select2" id="estado" style="width: 100%;" name="txtest" required="required">
                <option value="">SELECCIONE</option>
                  <option value="1">ACTIVADO</option>
                  <option value="0">DESACTIVADO</option>
                </select>
              </div>
             
              <!-- /.form-group -->
            </div>
             
            <!-- /.col -->
          </div>
          <button type="submit" class="btn btn-success">REGISTRAR</button>
          <!-- /.row -->
        </div><br>
         <br>    
        </form>
       </div>
       </div>
       </div>
<script type="text/javascript">
$(document).ready(function() {
document.getElementById("estado").value =${objusu.estado};
document.getElementById("grado").value =${objusu.grado};
});
</script>
    
    
    
    