<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Sergey Pozhilov (GetTemplate.com)">

    <title>Sign up - Progressus Bootstrap template</title>

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
</head>

<body>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span></button>
            <a class="navbar-brand" href="home.ftl"><img src="/images/logo.png" alt="Progressus HTML5 template"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li><a href="/home">Home</a></li>
                <li><a href="/about">About</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Your Side<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="/marvel">MARVEL</a></li>
                        <li><a href="/dc">DC</a></li>
                    </ul>
                </li>
                <li><a href="/contact">Contact</a></li>
                <li><a class="btn" href="/login">SIGN IN / SIGN UP</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>
<!-- /.navbar -->

<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <ol class="breadcrumb">
        <li><a href="home.ftl">Home</a></li>
        <li class="active">Registration</li>
    </ol>

    <div class="row">
        <!-- Article main content -->
        <div class="container">
            <article class="col-xs-12 maincontent">
                <header class="page-header">
                    <h1 class="page-title">Registration</h1>
                </header>

                <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <h3 class="thin text-center">Register a new account</h3>
                            <p class="text-center text-muted">I you already have an account, <a href="/login">Login</a>
                                yourself. And order the best comics ever.
                            </p>
                            <hr>
                        <@sf.form class="form-horizontal" action="/register/client" method="post" modelAttribute="clientform" id="reg_form">
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>First Name<span class="text-danger">*</span></label>
                                    <@sf.input path="firstName" type="text" class="form-control" id="firstname" placeholder="Fill your First Name"/>
                                    <@sf.errors path="firstName" class = "form-control alert alert-warning text-center"/>
                                    <div class="firstname-error col-xs-2">
                                        <#if firstNameError??>
                                        ${firstNameError}
                                    </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>Last Name<span class="text-danger">*</span></label>
                                    <@sf.input path="lastName" type="text" class="form-control" id="lastName" placeholder="Fill your Last Name"/>
                                    <@sf.errors path="lastName" class = "form-control alert alert-warning text-center"/>
                                    <div class="lastName-error col-xs-2">
                                        <#if lastNameError??>
                                        ${lastNameError}
                                    </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>Login<span class="text-danger">*</span></label>
                                    <@sf.input path="login" type="text" class="form-control" id="login" placeholder="Fill your Login"/>
                                    <@sf.errors path="login" class = "form-control alert alert-warning text-center"/>
                                    <div class="login-error col-xs-2">
                                        <#if loginError??>
                                        ${loginError}
                                    </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>Email Address<span class="text-danger">*</span></label>
                                    <@sf.input path="email" type="text" class="form-control" id="email" placeholder="Fill your Email Address"/>
                                    <@sf.errors path="email" class = "form-control alert alert-warning text-center"/>
                                    <div class="email-error col-xs-2">
                                        <#if emailError??>
                                        ${emailError}
                                    </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>Password<span class="text-danger">*</span></label>
                                    <@sf.input path="password" type="password" class="form-control" id="password" placeholder="Fill your Password"/>
                                    <@sf.errors path="password" class = "form-control alert alert-warning text-center"/>
                                    <div class="password-error col-xs-2">
                                        <#if passwordError??>
                                        ${passwordError}
                                    </#if>
                                    </div>
                                </div>
                            </div>
                            <div class="top-margin">
                                <div class="col-xs-6">
                                    <label>Confirm Password<span class="text-danger">*</span></label>
                                    <@sf.input path="repassword" type="password" class="form-control" id="repassword" placeholder="Fill your Confirm Password"/>
                                    <@sf.errors path="repassword" class = "form-control alert alert-warning text-center"/>
                                    <div class="repassword-error col-xs-2">
                                        <#if repasswordError??>
                                        ${repasswordError}
                                    </#if>
                                    </div>
                                </div>
                            </div>

                            <hr>

                            <div class="row">
                                <div class="col-lg-8">
                                    <label class="checkbox">
                                        <input type="checkbox">
                                        I've read the <a href="page_terms.html">Terms and Conditions</a>
                                    </label>
                                </div>
                                <div class="col-lg-4 text-right">
                                    <button class="btn btn-action" type="submit">Register</button>
                                </div>
                            </div>
                        </@sf.form>
                        </div>
                    </div>
                </div>
            </article>
            <!-- /Article -->

        </div>
    </div>
</div>    <!-- /container -->


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
                        <p class="follow-me-icons clearfix">
                            <a href="https://twitter.com"><i class="fa fa-twitter fa-2"></i></a>
                            <a href="https://github.com"><i class="fa fa-github fa-2"></i></a>
                            <a href="https://dribbble.com"><i class="fa fa-github fa-2"></i></a>
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
                            <a href="/home">Home</a> |
                            <a href="/about">About</a> |
                            <a href="/marvel">Choose</a> |
                            <a href="/contact">Contact</a> |
                            <b><a href="#">Sign up</a></b>
                        </p>
                    </div>
                </div>

                <div class="col-md-6 widget">
                    <div class="widget-body">
                        <p class="text-right">
                            Copyright &copy; 2016, Ziganshin Ruslan. </p>
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
<script src="/js/registration-valid.js"></script>

</body>
</html>
