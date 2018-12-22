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
    })

    // 导航
    $('#nav>li').hover(
        function () {
            $(this).addClass("active");
    },
        function () {
            $(this).removeClass();
        })
});