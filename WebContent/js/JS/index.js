/**
 * Created by qiao on 2018/1/30.
 */

$(document).ready(function(){
    $(".img1").mouseover(function(){
        $(".basecol1").fadeIn();
    });
    $(".basecol1").mouseout(function(){
        $(".basecol1").fadeOut();
    })
})
$(document).ready(function(){
    $(".img2").mouseover(function(){
        $(".basecol2").fadeIn();
    });
    $(".basecol2").mouseout(function(){
        $(".basecol2").fadeOut();
    })
})
$(document).ready(function(){
    $(".img3").mouseover(function(){
        $(".basecol3").fadeIn();
    });
    $(".basecol3").mouseout(function(){
        $(".basecol3").fadeOut();
    })
})

var isround ="ll";
var i=0;
$(function(){
    isround = setTimeout("change()",1000);
    /*setTimeout()函数从载入后延迟指定的时间去执行一个表达式或函数;*/
    $("div[name=ban] div img:eq(0)").show().siblings().hide();
    $(".num li:eq(0)").addClass("current").siblings().removeClass("current");
    $(".num li").click(function(){
        i=$(".num li").index(this);
        $(this).addClass("current").siblings().removeClass("current");
        $("div[name=ban] div img").eq($(".num li").index(this)).show().siblings().hide();
        isround = setTimeout("change()",1000);
    }).hover(function(){
        clearTimeout(isround)
    },function(){
        isround = setTimeout("change()",1000);
    })
});
function change(){
    if(i==$(".num li").length) i=0;
    $(".num li").eq(i).addClass("current").siblings().removeClass("current");
    $("div[name=ban] div img").eq(i).show().siblings().hide();
    i++;
    setTimeout("change()",1000);
}

$(function () {
    $("li").mouseover(function () {
        $(this).children("div").stop().slideDown();
    });
    $("li").mouseout(function () {
        $(this).children("div").stop().slideUp();
    })
})

function show(){
    var inn=document.getElementById("exampleInputEmail2");
    var pp=document.getElementById("pp");
    var ppp=document.getElementById("ppp");
    if(inn.text!=" "){
        show.innerHTML=inn.style.border="1px solid red";
    }
}

$(function () {
    $(".box").fadeIn(1000).children(".close").click(function () {
        $(this).parent().fadeOut();
    })
    console.log($(".box").offset().top);
    $(window).scroll(function(){
        var top=$(document).scrollTop();
        console.log(top);
        if(top>10){
            $(".box").css({"position":"fixed","top":101,"left":380});
        }
    })
})