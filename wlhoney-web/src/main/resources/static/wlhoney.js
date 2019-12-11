function home(){
    let contextPath = $("#contextPath").attr("href");
    window.location.href = contextPath + "/";
}

$(function () {
    // Mobiscroll Date &amp; Time initialization
    $('#datetimeDate-demo').mobiscroll().date({
        animate: "flip",
        theme: 'wp', // Specify theme like: theme: 'ios' or omit setting to use default
        lang: $('#language').val(), // Specify language like: lang: 'pl' or omit setting to use default
        display: $('#display').val(), // Specify display mode like: display: 'bottom' or omit setting to use default
        mode: $('#mode').val(), // More info about mode: https://docs.mobiscroll.com/3-0-0_beta5/datetime#!opt-mode
        height: 65,
        closeOnOverlayTap: true,
        dateFormat: 'yy-mm',
        min: new Date(2015, 0, 1),
        max: new Date(2025, 0, 1),
        onSet: function (event, inst) {
            let contextPath = $("#contextPath").attr("href");
            let year = inst._wheelArray[0];
            window.location.href = contextPath + "/albums/"+year;
        }
    });
});

function footerUpload() {
    let contextPath = $("#contextPath").attr("href");
    layer.open({
        scrollbar: false,
        type: 2,
        shade: 0.1,
        area: ['100%', '500px'],
        title: '上传图片',
        content: contextPath + "/upload/multipart-page/" + $("#albumsId").val()
    });
}