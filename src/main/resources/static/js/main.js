$(document).ready(function(){
    console.log("FUNCIONANDO");
    $('.nBtn, .eBtn').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();
        console.log("TEXTO " + text);
        //for update user
        if (text == 'Edit') {
            $.get(href, function (client, status) {
                $('.formUpdate #id').val(client.id);
                $('.formUpdate #username').val(client.username);
                $('.formUpdate #password').val(client.password);
                $('.formUpdate #email').val(client.email);
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