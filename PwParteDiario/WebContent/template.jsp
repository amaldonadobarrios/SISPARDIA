<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="jsp/frag/head.jspf"%>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
   <%@include file="jsp/frag/header.jspf"%>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
   <%@include file="jsp/frag/menu.jspf"%>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>${breadcrumb}
      </h1>
      <ol class="breadcrumb">
        <li><a href="SPage?action=pagehome"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">${breadcrumb}</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

    	<c:import url="jsp/pages/${body}.jsp" /> 
      <!-- /.row -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <%@include file="jsp/frag/footer.jspf"%>
  </footer>
<%@include file="jsp/frag/menuright.jspf"%>
  <!-- Control Sidebar -->
  
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<%@include file="jsp/frag/footerlibrary.jspf"%>
<script type="text/javascript">
	   window.location.hash="no-back-button";
	   window.location.hash="Again-No-back-button" //chrome
	   window.onhashchange=function(){window.location.hash="no-back-button";}
</script>
</body>
</html>
