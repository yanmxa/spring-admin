function checkPermission() {
    var pers = [];
    var permissions = []
    if (localStorage.permission != undefined) {
        permissions = jQuery.parseJSON(localStorage.permission);
    }
    $("[permission]").each(function() {
        var per = $(this).attr("permission");
        if ($.inArray(per, permissions) < 0) {
            $(this).hide();
        }
    });

    return pers;
}

function checkPermissionForTable(){
    var permissions = jQuery.parseJSON(localStorage.permission);
    $("[permission]").each(function() {
        var per = $(this).attr("permission");
        if ($.inArray(per, permissions) >= 0) {
            return true;
        }
    });
    return false;
}