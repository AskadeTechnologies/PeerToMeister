<%--
  Created by IntelliJ IDEA.
  User: AdrianIonita
  Date: 4/29/2017
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Peer to Meister</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


  <!--   JQuery, AdminLTE and Bootstrap plugin styles -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/treegrid/jquery.treegrid.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/plugins/select2/select2.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/plugins/datepicker/datepicker3.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/plugins/iCheck/all.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/plugins/pace/pace.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/AdminLTE.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/dist/css/skins/skin-purple.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/gurrido/css/ui.jqgrid-bootstrap.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/gurrido/plugins/jquery.contextMenu.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/gurrido/scroll/perfect-scrollbar.min.css" />"/>
  <link rel="stylesheet" href="<c:url value="/resources/css/om.css" />"/>

</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- ce apare in header-->
<header class="main-header">
  <a href="#" class="logo bg-yellow-gradient">
    <span class="logo-mini bg-yellow-gradient"><b>PtM</b></span>
    <span class="logo-lg bg-yellow-gradient"><b>PeerTo</b>Meister</span>
  </a>

  <nav class="navbar navbar-static-top bg-yellow-gradient" role="navigation">
    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
      <span class="sr-only">Toggle navigation</span>
    </a>

    <div class="navbar-custom-menu">
      <ul class="nav navbar-nav">
        <li class="dropdown user user-menu">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span id="ptmUserName" class="hidden-xs">Welcome : ${pageContext.request.userPrincipal.name}</span>
          </a>
          <ul class="dropdown-menu transparent-bg">
            <li class="user-footer transparent-bg">
              <div class="pull-right">
                <a href="<c:url value="/j_spring_security_logout" var="logoutUrl"/>" class="btn btn-default btn-flat">Logout</a>
              </div>
            </li>
          </ul>
        </li>
        <li>
          <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
        </li>
      </ul>
    </div>
  </nav>
</header>

<!-- ce apare in side-bar-ul din stanga-->
<aside class="main-sidebar">
  <section class="sidebar">
    <ul class="sidebar-menu">
      <li class="header">Main Menu</li>
      <li class="treeview">
        <a href="#" onclick="workspace.showDashboard()">
          <i class="fa fa-wrench"></i> <span>Dashboard</span>
        </a>
      </li>
      <li class="treeview">
        <a href="#" onclick="workspace.showAppConfig();">
          <i class="fa fa-wrench"></i> <span>Application Config</span>
        </a>
      </li>
    </ul>
  </section>
</aside>

<div class="content-wrapper">

  <div id="success-message" style="display:none">
    <div class="row">
      <div class="col-xs-12">
        <div class="alert alert-success alert-dismissible">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <h4><i class="icon fa fa-check"></i> Succes!</h4>
          <div id="success-message-text">

          </div>
        </div>
      </div>
    </div>
  </div>
  <div id="error-message" style="display:none">
    <div class="row">
      <div class="col-xs-12">
        <div class="alert alert-danger alert-dismissible">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
          <h4><i class="icon fa fa-ban"></i> Eroare!</h4>
          <div id="error-message-text">

          </div>
        </div>
      </div>
    </div>
  </div>

  <div id="dashboard-page" style="display:none">
    <section class="content-header">
      <h1>
        Dashboard
      </h1>
    </section>

    <section class="content">
      <div class="h-divider"></div>
      <div>
        <h3><b>Dashboard</b></h3>
        <div class="h-spacer"></div>
      </div>
    </section>
  </div>

  <!--Application Config-->
  <div id="appConfig-page" style="display:none">
    <section class="content-header">
      <h1>
        Application Configuration
      </h1>
    </section>

    <section id="client-config" class="content" style="display:none">
      <div class="h-divider"></div>
      <div>
        <h3><b>Clienti</b></h3>
        <div class="h-spacer"></div>
          <button id="addNewDocumentType" onclick="workspace.addNewDocumentType()" class="btn icon-add">Add</button>
          <table id="documentType-table" class="table table-bordered table-striped"></table>
          <div id="documentTypeTablePager"></div>
      </div>
    </section>

    <section id="operation-config" class="content" style="display:none">
      <div class="h-divider"></div>
      <div>
        <h3><b>Operations Config</b></h3>
        <div class="h-spacer"></div>
      </div>
    </section>
  </div>
  <!--Application Config-->
</div>

  <!-- Footer-ul-->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      v.1.0.0
    </div>
    <strong>Copyright &copy; 2017 <a href="http://www.askade.ro" target="_blank">Askade Solutions</a>.</strong> All
    rights reserved.
  </footer>
  </body>
  <!-- JQuery, Bootstrap and AdminLTE plugins -->
  <script type="text/javascript" src='<c:url value="/resources/plugins/jQuery/jquery-2.2.3.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/jQueryUI/jquery-ui.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/treegrid/jquery.treegrid.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/treegrid/jquery.treegrid.bootstrap3.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/gurrido/js/jquery.jqGrid.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/gurrido/plugins/jquery.contextMenu.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/gurrido/js/i18n/grid.locale-en.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/gurrido/scroll/jquery.mousewheel.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/gurrido/scroll/perfect-scrollbar.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/slimScroll/jquery.slimscroll.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/fastclick/fastclick.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/select2/select2.full.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/datepicker/bootstrap-datepicker.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/iCheck/icheck.min.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/plugins/pace/pace.min.js"/>'></script>
  <!-- AdminLTE JS -->
  <script type="text/javascript" src='<c:url value="/resources/dist/js/app.js"/>'></script>

  <!--PDF Viewer JS-->
  <script type="text/javascript" src='<c:url value="/resources/pdfViewer/pdf.js"/>'></script>
  <!-- PTM App JS -->

  <script type="text/javascript" src='<c:url value="/resources/js/workspace.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/js/appConfig/action/documentTypeAction.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/js/appConfig/model/documentTypeObject.js"/>'></script>
  <script type="text/javascript" src='<c:url value="/resources/js/ptm.js"/>'></script>
</html>
