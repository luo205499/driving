$(function () {

    // 左右键切换轮播图片
    $(document).on('keydown', function (e) {
        switch (e.which) {
            case 37:
                $('#slideshow').carousel('prev');
                break;
            case 39:
                $('#slideshow').carousel('next');
                break;
        }
    });

    // 导航
    $('#nav>li').hover(
        function () {
            $(this).addClass("active");
    },
        function () {
            $(this).removeClass();
        });



        //用户未登录，隐藏错题
        $(".wrongItem").hide();
        //申明localstorage
        var storage = window.localStorage;
        //从localstorage获得用户信息
        $(".usernamedisplay").text(storage.getItem("username"));
        //刷新当前用户
        setInterval(function () {
            displayuser();
        }, 1000);

        //登陆成功后隐藏登录注册按钮
        function displayuser() {
            a = $(".usernamedisplay").text();
            if (a != "") {
                /* $(".displaylogin").css('display', 'none');
                 $(".nowuser").css('display', 'block');*/
                $(".wrongItem").fadeIn(1000);
                $(".displaylogin").fadeOut(1000);
                $(".nowuser").fadeIn(2000);
            }
        }

        //登录
        $("#userLogin").on("click", function () {
            $.ajax({
                url: "/login",//url
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                data: {username: $("#username").val(), password: $("#password").val()},
                success: function (res) {
                    storage.setItem("username", res.username);
                    storage.setItem("id", res.id);
                    storage.setItem("type", res.type);
                    window.location.reload(); //刷新当前页面
                },
                error: function () {
                    alert("登录失败！");
                }
            });
        });

        //注册
        $("#userRegister").on("click", function () {
            $.ajax({
                url: "/register",
                type: "POST",
                dataType: "json",
                data: {username: $("#rusername").val(), password: $("#rpassword").val()},
                success: function (res) {
                    alert("注册成功");
                    storage.setItem("username", res.username);
                    storage.setItem("id", res.id);
                    storage.setItem("type", res.type);
                    window.location.reload(); //刷新当前页面
                }, error: function () {
                    alert("注册失败！");
                }

            });
        });
        //退出登录
        $("#loginOut").on("click", function () {
            localStorage.removeItem("username");
            localStorage.removeItem("id");
            localStorage.removeItem("type");
            window.location.reload(); //刷新当前页面
        });
        //显示\隐藏题库
        itemdisplay();

        function itemdisplay() {
            if (storage.getItem("type") == 1) {
                $(".itemdisplay").fadeIn(2000);
            }
        }
});