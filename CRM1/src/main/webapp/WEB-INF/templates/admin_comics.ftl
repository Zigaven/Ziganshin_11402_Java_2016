<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"    content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author"      content="Sergey Pozhilov (GetTemplate.com)">

    <title>ADMIN PAGE</title>

    <link rel="shortcut icon" href="/images/gt_favicon.png">

    <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/list.css">

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="/css/bootstrap-theme.css" media="screen" >
    <link rel="stylesheet" href="/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="home">
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom" >
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="index.html"><img src="/images/logo.png" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li><a href="/admin">Home</a></li>
                <li><a href="/admin/shop">Shops</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Your Side<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/expense">Expenses</a></li>
                        <li><a href="/admin/profit">Profit</a></li>
                    </ul>
                </li>
                <li><a href="/admin/staff">Staff</a></li>
                <li class="active"><a href="#">Comics</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!-- /.navbar -->
<header id="head" class="secondary"></header>
<br>
<br>

<a class="btn btn-default btn-lg" role="button" href="/admin/add_comics">Add new comics</a>

<div class="row">

    <!-- Sidebar -->
    <aside class="col-md-4 sidebar sidebar-right">
    <#list comics as comic>
        <#if comic.name == "Superman">
    <div class="row widget">
            <div class="col-xs-12">
            </div>
        </div>
        <div class="row widget">
            <div class="col-xs-12">
                <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                <p><img src="${comic.path}" alt=""></p>
                <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
            </div>
        </div>
        </#if>
        <#if comic.name == "Batman">

        <div class="row widget">
            <div class="col-xs-12">
                <h4><b>${comic.publisher}</b> </h4>
                <br>
                <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                <p><img src="${comic.path}" alt=""></p>
                <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
                </div>
               </div>

        </#if>

        </#list>

    </aside>

    <aside class="col-md-4 sidebar sidebar-left">
    <#list comics as comic>
        <#if comic.name == "Avengers">

    <div class="row widget">
            <div class="col-xs-12">
                <h4><b>${comic.publisher}</b></h4>
            </div>
        </div>
        <div class="row widget">
            <div class="col-xs-12">
                    <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                    <p><img src="${comic.path}" alt=""></p>
                    <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                    <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
            </div>
        </div>
        </#if>
        <#if comic.name == "Spider-Man">

        <div class="row widget">
            <div class="col-xs-12">
                <br>
                <br>
                <br>
                <br>
                    <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                    <p><img src="${comic.path}" alt=""></p>
                    <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                    <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
                </div>
        </div>
        </#if>
        </#list>

    </aside>

    <!-- /Sidebar -->
    <aside class="col-md-4 sidebar sidebar-center">
<#list comics as comic>
    <#if comic.name == "Sin-City">

        <div class="row widget">
            <div class="col-xs-12">

                <h4><b>${comic.publisher}</b></h4>
            </div>
        </div>
        <div class="row widget">
            <div class="col-xs-12">
                    <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                    <p><img src="${comic.path}" alt=""></p>
                    <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                    <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
            </div>
        </div>
    </#if>
    <#if comic.name == "Hellboy">

    <div class="row widget">
            <div class="col-xs-12">
                <br>
                    <h4>Name:</h4><h3><b>${comic.name}</b></h3>
                    <p><img src="${comic.path}" alt=""></p>
                    <p> <h4>Price:</h4><h3><b>${comic.price}</b></h3></p>
                    <p> <h4>Description:</h4><h3><b>${comic.description}</b></h3></p>
                </div>
        </div>
    </#if>

</#list>

</aside>

    <!-- Article main content -->
    <!-- /Article -->
</div>


<footer id="footer" class="top-space">

    <div class="footer1">
        <div class="container">
            <div class="row">

                <div class="col-md-3 widget">
                    <h3 class="widget-title">Contact</h3>
                    <div class="widget-body">
                        <p>+234 23 9873237<br>
                            <a href="mailto:#">some.email@somewhere.com</a><br>
                            <br>
                            Russia, Kazan, KFU
                        </p>
                    </div>
                </div>

                <div class="col-md-3 widget">
                    <h3 class="widget-title">Follow me</h3>
                    <div class="widget-body">
                        <p class="follow-me-icons">
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
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Excepturi, dolores, quibusdam architecto voluptatem amet fugiat nesciunt placeat provident cumque accusamus itaque voluptate modi quidem dolore optio velit hic iusto vero praesentium repellat commodi ad id expedita cupiditate repellendus possimus unde?</p>
                        <p>Eius consequatur nihil quibusdam! Laborum, rerum, quis, inventore ipsa autem repellat provident assumenda labore soluta minima alias temporibus facere distinctio quas adipisci nam sunt explicabo officia tenetur at ea quos doloribus dolorum voluptate reprehenderit architecto sint libero illo et hic.</p>
                    </div>
                </div>

            </div> <!-- /row of widgets -->
        </div>
    </div>

    <div class="footer2">
        <div class="container">
            <div class="row">

            <#--<div class="col-md-6 widget">-->
            <#--<div class="widget-body">-->
            <#--<p class="simplenav">-->
            <#--<a href="#">Home</a> |-->
            <#--<a href="/about">About</a> |-->
            <#--<a href="/smth2">Sidebar</a> |-->
            <#--<a href="/contact">Contact</a> |-->
            <#--<b><a href="/register/client">Sign up</a></b>-->
            <#--</p>-->
            <#--</div>-->
            <#--</div>-->

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="text-right">
                            Copyright &copy; 2016, Ziganshin Rulsan.</p>
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
</body>
</html>