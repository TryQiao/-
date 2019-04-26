<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>公司网页</title>
	<c:set var="basePath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" href="CSS/index.css" type="text/css"/>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="js/JS/jquery-3.3.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/JS/index.js"></script>
    
</head>
<body>
<div id="nav">
        <div class="dropdown">
            <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Helpful
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dLabel">
                <li>Overview</li>
                <li>Recent Event</li>
                <li>Upcoming Event</li>
            </ul>
        </div>
    <ul>
        <li>HOME</li>
        <li>ABOUT</li>
        <li>SEVICS</li>
        <li>GALLERY</li>
        <li class="nav_img"><img src="images/Images/logo.png" alt=""/></li>
        <li>EVENTS</li>
        <li>TEAM</li>
        <li>DONATE</li>
        <li>CONTACT</li>
    </ul>
</div>
<div id="nav_1"></div>
<div id="lunbo">
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/Images/slide1.jpg" alt="">
            <div class="carousel-caption">
                <div id="text1">
                Make Donation
                    </div>
            </div>
        </div>
        <div class="item">
            <img src="images/Images/slide2.jpg" alt="">
            <div class="carousel-caption">
                <div id="text2">
                Be a Donator
                    </div>
            </div>
        </div>
        <div class="item">
            <img src="images/Images/slide3.jpg" alt="">
            <div class="carousel-caption">
                <div id="text3">
                Be a volunteer
                </div>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
 </div>
</div>
<div id="lunbo_1"></div>
<div id="showtext">
    <div class="showt1">
        <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
    </div>
    <div class="showt2">
    <h1 class="main-text">Show your Love for the Humanity</h1>
    <p class="text-center sub-text">Lorem ipsum dolor sit amet, consectetur adipisiciSng elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.A<br/>
        sed do eiusmod tempor incididunt ut labore et dolore magna.</em></p></div>
</div>

<div id="showtext_1"></div>
<div id="centernav">
    <div class="header-text"><span><img src="images/Images/1.png"/></span> News</div>
</div>
<div id="main">
    <div class="main1">
        <div class="tt1"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Editor’s Choice</div>
        <img src="images/Images/sea.jpg" alt="" class="img1"/>
        <div class="maint1">
        <p>Discovering OM: A visit back to The<br/>
        Vedas</p>
        <br/>
        Gregor then turned to look out the window at the dull<br/>
        weather. Drops of rain could pane,which made
        </div>
        <div class="maint2">Read More</div>
        <ul>
            <li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span></li>
            <li>224</li>
            <li><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></li>
            <li>89</li>
        </ul>
    </div>
    <div class="main2">
        <div class="tt1"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Editor’s Choice</div>
        <img src="images/Images/sea.jpg" alt="" class="img2"/>
        <div class="maint1">
            <p>Discovering OM: A visit back to The<br/>
                Vedas</p>
            <br/>
            Gregor then turned to look out the window at the dull<br/>
            weather. Drops of rain could pane,which made
        </div>
        <div class="maint2">Read More</div>
        <ul>
            <li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span></li>
            <li>224</li>
            <li><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></li>
            <li>89</li>
        </ul>
    </div>
    <div class="main3">
        <div class="tt1"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>Editor’s Choice</div>
        <img src="images/Images/sea.jpg" alt="" class="img3"/>
        <div class="maint1">
            <p>Discovering OM: A visit back to The<br/>
                Vedas</p>
            <br/>
            Gregor then turned to look out the window at the dull<br/>
            weather. Drops of rain could pane,which made
        </div>
        <div class="maint2">Read More</div>
        <ul>
            <li><span class="glyphicon glyphicon-heart" aria-hidden="true"></span></li>
            <li>224</li>
            <li><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></li>
            <li>89</li>
        </ul>
    </div>
    <div class="basecol1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></div>
    <div class="basecol2"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div>
    <div class="basecol3"><span class="glyphicon glyphicon-send" aria-hidden="true"></span></div>
    <div class="showcontent"><img src="images/Images/child.png" alt=""/>
        <p>
        Enrichment Camps <br/>
        Nam consequat lacus purus, ac hendrerit ipsum pellentesque ut.
        Mauris orci ante, sodales ut lorem sed, semper aliquam diam. Sit
        amet tellus velit.</p>
        <span class="cc">×</span>
    </div>
    <script>
        var a=document.getElementsByClassName("basecol2")[0];
        var showcontent=document.getElementsByClassName("showcontent")[0];
        var cc=document.getElementsByClassName("cc")[0];
            a.onclick=function(){
                showcontent.style.display="block";
        }
        cc.onclick=function(){
            showcontent.style.display="none";
        }
    </script>

</div>
<div id="main_1"></div>
<div id="lnav">
    <div class="l-text"><span><img src="images/Images/3.png"/></span>Collected!</div>
</div>
<div id="lasts">
    <img src="images/Images/donate.jpg" alt=""/>
    <div class="show1">
        <i class="glyphicon glyphicon-user" aria-hidden="true"></i><br/>
        <span id="shown1">122</span>
        <div class="showtt">Happy Customers</div>
    </div>
    <div class="show2">
        <i class="glyphicon glyphicon-leaf" aria-hidden="true"></i><br/>
        <span id="shown2">0</span>
        <script type="text/javascript">
            var shown2=document.getElementById("shown2");
            var i=0;
            window.onscroll = function () {
                var scrollTop = document.body.scrollTop || document.documentElement.scrollTop || window.pageYOffset || 0;
                if(scrollTop =1700) {
                    window.setInterval(function () {
                        if (i< 4229) {
                            i++;
                            shown2.innerHTML = i;
                        }
                    }, 100);
                }
            }
        </script>
        <div class="showtt">Ordered Coffee's</div>
    </div>
    <div class="show3">
        <i class="glyphicon glyphicon-king" aria-hidden="true"></i><br/>
        <span id="shown3">14</span>
        <div class="showtt">Awards Win</div>
    </div>
    <div class="show4">
        <i class="glyphicon glyphicon-camera" aria-hidden="true"></i><br/>
        <span id="shown4">232</span>
        <div class="showtt">Photos Taken</div>
    </div>
</div>

<div id="lastnav">
    <div class="last-text">Our<span><img src="Images/2.png"/></span></div>
</div>
<div id="lastmain">
<div name="ban" id="leftlunbo">
    <div id="lii">
        <img src="images/Images/f1.png" alt="" class="image1"/>
        <img src="images/Images/f2.png" alt="" class="image2"/>
        <img src="images/Images/f3.png" alt="" class="image3"/>
        <img src="images/Images/f3.png" alt="" class="image3"/>
    </div>
    <div class="numbox">
        <ul class="num">
            <li class="current" style="background-color: #68ABBB"><</li>
            <li style="background-color: #68ABBB">></li>
            <li></li>
        </ul>
    </div>
</div>
    <div id="lefttext">
        <ul>
            <li style="background-image: url(images/Images/donor_01.jpg)"><div>Jake Smith </div></li>
            <li style="background-image: url(images/Images/donor_02.jpg)"><div>Marissa Swanson </div></li>
            <li style="background-image: url(images/Images/donor_03.jpg)"><div>Leo Recevuer</div></li>
            <li style="background-image: url(images/Images/donor_04.jpg)"><div>Nigel Doe </div></li>
        </ul>
    </div>

<div id="righttext">
    <div class=" firsttext">Subscribe to Newsletter</div>
    <form class="form-inline">
    <div class="form-group">
    <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Enter your emain...">
    </div>
    <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
    <button  data-placement="right" title="输入为空时点击重载页面" onclick="show()">Submit</button>
    </form>
    <div class="lasttext">We never spam :)</div>
</div>
    <div class="lastbtn">
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" >
        Know more about us
    </button>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">About Us</h4>
                </div>
                <div class="modal-body">
                    Pellentesquemattis arcu malesuada in. Donec urna sem,rutrum sit amet <br/> pellentesque vel, suscipit at metus.<br/>
                    Morbi rutrum massa eget mi gravida, sit amet mollis magna gravida. Morbi<br/>
                    sodales, ligula quis ornare bibendum, magna erat convallis ipsum, id posuere<br/>
                    ligula massa vitae leo.<br/>
                    <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>: humanity@gmail.com<br/><br/>
                    <span class="glyphicon glyphicon-earphone" aria-hidden="true"></span>: (+84) XXX-349-0600<br/><br/>
                    <span class="glyphicon glyphicon-print" aria-hidden="true"></span>: (+84) 740-349-0600<br/><br/>
                    <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>: Technext,Sylhe
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Copy</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="footer">
    <div class="footerleft">
        <p>
        Great love for humanity
        </p>
        <a href="">Home</a> <a href="">/ </a><a href="">About</a> <br/>
        <a href="">Service</a> <a href="">/</a><a href="">Gallery</a> <a href="">/</a> <a href="">Contact</a>
    </div>
    <div class="footercenter">
        <div class="lloo">f</div>
        <div class="lloo1"><span class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></span></div>
        <div class="lloo2">g+</div>
        <div class="lloo3"><span class="glyphicon glyphicon-modal-window" aria-hidden="true"></span></div>
        <div id="numm">123&nbsp;456&nbsp;7890</div>
        <p>humanity@shuvohabib.com</p>
    </div>
    <div class="footerright">
        <p>
        Copyright 2014 Theme. More Templates  -<br/>
        Collect from <a>QK</a><br/>
        All Rights Reserved
        </p>
    </div>
</div>

<!-- <div class="box">
    <div class="bcc"></div>
    <img src="images/Images/flikr2.jpg" alt="" width="700px" height="400px"/>
    <p>Join us in helping people survive <br/> and rebuild their lives.</p>
    <div class="bbtn">join</div>
    <div class="close"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></div>
</div> -->
</body>
</html>
