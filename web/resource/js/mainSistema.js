
$(document).ready(function () {

    var btnToggle = document.querySelector('.toggle-btn');


    btnToggle.addEventListener('click', function (e) {
        document.getElementById('sideBar').classList.toggle('active');
        document.getElementById('navcont').classList.toggle('activa');
    });

    $('.menu li:has(ul)').click(function (e) {

        if ($(this).hasClass('activado')) {
            $(this).removeClass('activado');
            $(this).children('ul').slideUp();
        } else {
            $('.menu li ul').slideUp();
            $('.menu li').removeClass('activado');
            $(this).addClass('activado');
            $(this).children('ul').slideDown();

        }
    });

});

$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });
});









