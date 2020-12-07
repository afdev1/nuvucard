$(document).ready(function(){
    console.log("FUNCIONANDO");
    $('.nBtn, .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var editor = $(this).hasClass("btn-primary");
        console.log("Editor " + editor);
        //for update user
        if (editor) {
            $.get(href, function (client) {
                $('.formUpdate #id').val(client.id);
                $('.formUpdate #username').val(client.username);
                $('.formUpdate #password').val(client.password);
                $('.formUpdate #email').val(client.email);
                $('.formUpdate #first_name').val(client.first_name);
                $('.formUpdate #last_name').val(client.last_name);
                $('.formUpdate #address').val(client.address);
                $('.formUpdate #telephone').val(client.telephone);
                $('.formUpdate #city').val(client.city);
                $('.formUpdate #country').val(client.country);
                $('.formUpdate #card_number').val(client.card_number);
                $('.formUpdate #card_month').val(client.card_month);
                $('.formUpdate #card_year').val(client.card_year);
                $('.formUpdate #card_security_code').val(client.card_security_code);
            });
            $('.formUpdate #editorModal').modal();
        } else {
            //for creating user
            $('.formCreate #username').val('');
            $('.formCreate #password').val('');
            $('.formCreate #email').val('');
            $('.formCreate #creatorModal').modal();
        }
    });
    //for delete user
    $('.table .delBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});