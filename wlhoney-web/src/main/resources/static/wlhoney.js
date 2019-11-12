function home(){
    let contextPath = $("#contextPath").attr("href");
    window.location.href = contextPath + "/albums";
}
function upload(){
    alert("upload相片");
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
        min: new Date(2019, 0, 1),
        max: new Date(2025, 0, 1),
        onSet: function (event, inst) {
            alert(inst._value);
        }

    });
});