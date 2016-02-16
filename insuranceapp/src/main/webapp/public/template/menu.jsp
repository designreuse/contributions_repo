 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">SYSTEM NAVIGATION</li>
            <li class="active">
              <a href="<c:url value="/protected/home"/>">
                <i class="fa fa-dashboard"></i> <span>Dashboard</span> <i class="pull-right"></i>
              </a>
            </li>
            
             <li>
              <a href="<c:url value="/protected/home/orgsetups"/>">
                <i class="fa fa-cog"></i> <span>Org Set Ups</span> <i class="pull-right"></i>
              </a>
            </li>
            
             <li>
              <a href="<c:url value="/protected/home/setups"/>">
                <i class="fa fa-cog"></i> <span>U/W Set Ups</span> <i class="pull-right"></i>
              </a>
            </li>
            
            </ul>
        </section>
        <!-- /.sidebar -->
      </aside>