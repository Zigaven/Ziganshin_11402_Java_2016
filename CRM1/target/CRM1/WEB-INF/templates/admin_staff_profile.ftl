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

    <!-- Custom styles for our template -->
    <link rel="stylesheet" href="/css/bootstrap-theme.css" media="screen">
    <link rel="stylesheet" href="/css/main.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/css">

        @import url(http://fonts.googleapis.com/css?family=Lato:400,700);

        body {
            font-family: 'Lato', 'sans-serif';
        }

        .profile {
            min-height: 355px;
            display: inline-block;
        }

        figcaption.ratings {
            margin-top: 20px;
        }

        figcaption.ratings a {
            color: #f1c40f;
            font-size: 11px;
        }

        figcaption.ratings a:hover {
            color: #f39c12;
            text-decoration: none;
        }

        .divider {
            border-top: 1px solid rgba(0, 0, 0, 0.1);
        }

        .emphasis {
            border-top: 4px solid transparent;
        }

        .emphasis:hover {
            border-top: 4px solid #1abc9c;
        }

        .emphasis h2 {
            margin-bottom: 0;
        }

        span.tags {
            background: #1abc9c;
            border-radius: 2px;
            color: #f5f5f5;
            font-weight: bold;
            padding: 2px 4px;
        }

        .dropdown-menu {
            background-color: #34495e;
            box-shadow: none;
            -webkit-box-shadow: none;
            width: 250px;
            margin-left: -125px;
            left: 50%;
        }

        .dropdown-menu .divider {
            background: none;
        }

        .dropdown-menu > li > a {
            color: #f5f5f5;
        }

        .dropup .dropdown-menu {
            margin-bottom: 10px;
        }

        .dropup .dropdown-menu:before {
            content: "";
            border-top: 10px solid #34495e;
            border-right: 10px solid transparent;
            border-left: 10px solid transparent;
            position: absolute;
            bottom: -10px;
            left: 50%;
            margin-left: -10px;
            z-index: 10;
        }


    </script>
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
                <li><a href="/admin/comics">Comics</a></li>
            <#--<li class="dropdown">-->
            <#--<a href="#" class="dropdown-toggle" data-toggle="dropdown">Your Side<b class="caret"></b></a>-->
            <#--<ul class="dropdown-menu">-->
            <#--<li><a href="/marvel">MARVEL</a></li>-->
            <#--<li><a href="/dc">DC</a></li>-->
            <#--</ul>-->
            <#--</li>-->
            <#--<li><a href="contact">Contact</a></li>-->
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
        <li><a href="/admin/staff">Staff</a></li>
        <li class="active">Profile Staff</li>
    </ol>

    <div class="row">

        <!-- Article main content -->
        <article class="col-sm-8 maincontent">
            <header class="page-header">
                <h1 class="page-title">Profile</h1>
            </header>
        </article>
        <!-- /Article -->

        <!-- Sidebar -->

        <!-- /Sidebar -->

    </div>
</div>    <!-- /container -->
<!--profile-->

<div class="row">
    <div class="col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6" style="min-height:20px;padding:19px;margin-bottom:20px;background-color:#f5f5f5;border:1px solid #e3e3e3;border-radius:4px;-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.05);box-shadow:inset 0 1px 1px rgba(0,0,0,.05)>
        <div class=" well profile
    ">
    <div class="col-sm-12">
        <div class="col-xs-12 col-sm-8">
        <#--<p><strong>Specialty: </strong> Веб-дизайнер. </p>-->
        <#--<p><strong>Hobby: </strong> Книги, природа, активный отдых, сайтостроение, дизайн, верстка </p>-->
        <#--<p><strong>Favourite: </strong>-->
        <#--<span class="tags">HTML5</span>-->
        <#--<span class="tags">CSS3</span>-->
        <#--<span class="tags">jQuery</span>-->
        <#--<span class="tags">Bootstrap</span>-->
        <#--</p>-->
        <#if personnel??>
            <p>Name: ${personnel.firstName}</p>
            <p>Lastname: ${personnel.lastName}</p>
            <p>Email: ${personnel.email}</p>

        </#if>
        <#if profile??>
            <p>Favourite: ${profile.favourite}</p>
            <p>Hobby: ${profile.hobby}</p>
            <p>Phone: ${profile.phone}</p>

        </#if>
        </div>
        <div class="col-xs-12 col-sm-4 text-center">
            <figure>
                <img src="/images/prof.jpg" alt="user" class="img-circle img-responsive">
            <#--<figcaption class="ratings">-->
            <#--<p>Рейтинг-->
            <#--<a href="#">-->
            <#--<span class="fa fa-star"></span>-->
            <#--</a>-->
            <#--<a href="#">-->
            <#--<span class="fa fa-star"></span>-->
            <#--</a>-->
            <#--<a href="#">-->
            <#--<span class="fa fa-star"></span>-->
            <#--</a>-->
            <#--<a href="#">-->
            <#--<span class="fa fa-star"></span>-->
            <#--</a>-->
            <#--<a href="#">-->
            <#--<span class="fa fa-star-o"></span>-->
            <#--</a>-->
            <#--</p>-->
            <#--</figcaption>-->
            </figure>
        </div>
    </div>
    <div class="col-xs-12 divider text-center">
    <#--<div class="col-xs-12 col-sm-4 emphasis">-->
    <#--<h2><strong> 32,4K </strong></h2>-->
    <#--<p>-->
    <#--<small>Подписчиков</small>-->
    <#--</p>-->
    <#--<button class="btn btn-success btn-block"><span class="fa fa-plus-circle"></span> Подписатся-->
    <#--</button>-->
    <#--</div>-->
    <#--<div class="col-xs-12 col-sm-4 emphasis">-->
    <#--<h2><strong>723</strong></h2>-->
    <#--<p>-->
    <#--<small>Записей</small>-->
    <#--</p>-->
    <#--<button class="btn btn-info btn-block"><span class="fa fa-user"></span> Профиль</button>-->
    <#--</div>-->
    <#--<div class="col-xs-12 col-sm-4 emphasis">-->
    <#--<h2><strong>74</strong></h2>-->
    <#--<p>-->
    <#--<small>Работы</small>-->
    <#--</p>-->

    <div class="btn-group dropup btn-block">
        <a href="/admin/staff/profile/edit/${id}"><button class="btn btn-info" type="button"><span class="fa fa-gear"></span> Edit Profile</button></a>
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
        </div>
            <#--<ul class="dropdown-menu text-left" role="menu">-->
                <#--<li><a href="#"><span class="fa fa-envelope pull-right"></span>Edit Profile</a></li>-->

            <#--</ul>-->
        </div>
    </div>
</div>
</div>
</div>
</div>
<br>
<br>
<br>
<br>
<br>
<!--profile-->


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
                            <a href="/admin">Home</a> |
                            <a href="/admin/shop">Shops</a> |
                            <a href="/admin/profit">Choose</a> |
                            <a href="#">Staff</a> |
                            <b><a href="/admin/comics">Comics</a></b>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="text-right">
                            Copyright &copy; 2016, Ziganshin Ruslan.</p>
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