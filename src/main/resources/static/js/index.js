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


        //显示\隐藏题库
        itemdisplay();

        function itemdisplay() {
            if (storage.getItem("type") == 1) {
                $(".itemdisplay").fadeIn(2000);
            }
        }
});