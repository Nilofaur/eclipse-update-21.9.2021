<!DOCTYPE html>
<html lang="en">
  <head>
 
    
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta http-equiv="x-ua-compatible" content="ie=edge" />
    <title>Lifestyle</title>
    <!-- MDB icon -->
    <link rel="icon" href="img/mdb-favicon.ico" type="image/x-icon" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
    <!-- Google Fonts Roboto -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
    />
    <!-- MDB -->
    <link rel="stylesheet" href="css/mdb.min.css" />
  </head>
  
  
<%

//SESSION
HttpSession sess = request.getSession(false); //use false to use the existing session
Object username=sess.getAttribute("username");//this will return username anytime in the session


%>

  
  
  
  <body>
    <!-- Start your project here-->
   
    <!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container-fluid">
    <!-- Navbar brand -->
    <a class="navbar-brand" href="#">Brand</a>

    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="programme.jsp">Programmes</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="http://localhost:9091/">Payment Gateway</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" href="aboutme.jsp?name=${username}">About you</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="plan.jsp?name=${username}">Plans</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="manualupdate.jsp?name=${username}">Manual Update</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="report.jsp?name=${username}">Report</a>
        </li>
        
         <li class="nav-item">
          <a class="nav-link" href="http://localhost:9778/shopping-cart/index.jsp">Products</a>
        </li>
        
   
        
        <li class="nav-item">
          <a class="nav-link" href="aboutme.jsp">Fill the form</a>
        </li>
    

        
      
      </ul>
      <!-- Left links -->

      <!-- Search form -->
      <form class="d-flex input-group w-auto">
        <input
          type="search"
          class="form-control"
          placeholder="Type query"
          aria-label="Search"
        />
        <button
          class="btn btn-outline-primary"
          type="button"
          data-mdb-ripple-color="dark"
        >
          Search
        </button>
      </form>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->



    <!-- End your project here-->

    <!-- MDB -->
    <script type="text/javascript" src="js/mdb.min.js"></script>
    <!-- Custom scripts -->
    <script type="text/javascript"></script>
    











</body>
</html>