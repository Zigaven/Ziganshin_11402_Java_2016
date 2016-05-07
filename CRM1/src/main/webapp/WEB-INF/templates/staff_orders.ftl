<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

    <title>Profile Client</title>

    <link rel="shortcut icon" href="/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/orders.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="/css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand"><img src="/images/logo.png" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li class="active"><a href="/staff/orders">Orders</a></li>
            <li><a href="/staff/profile">Profile</a></li>
            <#--<li><a class="btn" href="login.ftl">SIGN IN / SIGN UP</a></li>-->
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!-- /.navbar -->

<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <ol class="breadcrumb">
        <li class="active">Orders</li>
    </ol>

    <div class="row">

        <!-- Article main content -->
        <article class="col-sm-8 maincontent">
            <header class="page-header">
                <h1 class="page-title">Orders</h1>
            </header>
        </article>
        <!-- /Article -->

        <!-- Sidebar -->

        <!-- /Sidebar -->

    </div>
</div>    <!-- /container -->
<!--orders-->

<#--<pre>-->
<div id="dd" class="wrapper-dropdown-4">
    Сделать сегодня
    <ul class="dropdown">
        <li><input id="el-1" type="checkbox" name="el-1" value="donut" /><label for="el-1">Съесть пончик</label></li>
        <li><input id="el-2" type="checkbox" name="el-2" value="neighbour" /><label for="el-2">Шпионить за соседями</label></li>
        <li><input id="el-3" type="checkbox" name="el-3" value="T-rex" /><label for="el-3">Сходить в магазин</label></li>
    </ul>
</div>

<footer id="footer" class="top-space">
<#--</pre>-->

<!--orders-->



<footer id="footer">

    <div class="footer1">
        <div class="container">
            <div class="row">


                <div class="col-md-3 widget">
                    <h3 class="widget-title">Follow me</h3>
                    <div class="widget-body">
                        <p class="follow-me-icons clearfix">
                            <a href="https://twitter.com"><i class="fa fa-twitter fa-2"></i></a>
                            <a href="https://github.com"><i class="fa fa-github fa-2"></i></a>
                            <a href="https://dribbble.com"><i class="fa fa-dribbble fa-2"></i></a>
                            <a href="https://facebook.com"><i class="fa fa-facebook fa-2"></i></a>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <h3 class="widget-title">Text widget</h3>
                    <div class="widget-body">
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi, dolores, quibusdam
                            architecto voluptatem amet fugiat nesciunt placeat provident cumque accusamus itaque
                            voluptate modi quidem dolore optio velit hic iusto vero praesentium repellat commodi ad id
                            expedita cupiditate repellendus possimus unde?</p>
                        <p>Eius consequatur nihil quibusdam! Laborum, rerum, quis, inventore ipsa autem repellat
                            provident assumenda labore soluta minima alias temporibus facere distinctio quas adipisci
                            nam sunt explicabo officia tenetur at ea quos doloribus dolorum voluptate reprehenderit
                            architecto sint libero illo et hic.</p>
                    </div>
                </div>

            </div> <!-- /row of widgets -->
        </div>
    </div>

    <div class="footer2">
        <div class="container">
            <div class="row">

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="simplenav">
                            <a href="#">Orders</a> |
                            <b><a href="/staff/profile">Profile</a></b>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="text-right">
                            Copyright &copy; 2016, Ziganshin Ruslan.
                        </p>
                    </div>
                </div>

            </div> <!-- /row of widgets -->
        </div>
    </div>
</footer>


<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="/js/headroom.min.js"></script>
<script src="/js/jQuery.headroom.min.js"></script>
<script src="/js/template.js"></script>
<script src="/js/orders.js"></script>


</body>
</html>