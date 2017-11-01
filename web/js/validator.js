/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// JavaScript Validación
$('document').ready(function () {
// Validación para campos de texto exclusivo, sin caracteres especiales ni números
    var nameregex = /^[a-zA-Z ]+$/;

    $.validator.addMethod("validname", function (value, element) {
        return this.optional(element) || nameregex.test(value);
    });

// Máscara para validación de Email
    var eregex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    $.validator.addMethod("validemail", function (value, element) {
        return this.optional(element) || eregex.test(value);
    });

    $("#formulario-registro-cliente").validate({

        rules:
                {
                    nombres: {
                        required: true
                    },
                    apellidos: {
                        required: true
                    },
                    usuario: {
                        required: true
                    },
                    contraseña: {
                        required: true
                    },
                    ciudad: {
                        required: true
                    },
                    identificacion: {
                        required: true,
                        maxlength: 10
                    },
                    telefono: {
                        required: true,
                        maxlength: 10
                    },
                    genero: {
                        required: true
                    }
                },
        messages:
                {
                    nombre: {
                        required: "Tu Nombre es importantes"
                    },
                    apellidos: {
                        required: "Tu apellido es importantes"
                    },
                    usuario: {
                        required: "Necesario usuario"
                    },
                    contraseña: {
                        required: "Necesaria contraseña"
                    },
                    ciudad: {
                        required: "Necesaria ciudad"
                    },
                    identificacion: {
                        required: "Necesaria identificación",
                        maxlength: "Longitud máxima de 10 caracteres"
                    },
                    telefono: {
                        required: "necesaria identificación",
                        maxlength: "Longitud máxima de 10 caracteres"
                    },
                    genero: {
                        required: "Necesario género"
                    }
                },
        errorPlacement: function (error, element) {
            $(element).closest('.form-group').find('.help-block').html(error.html());
        },
        highlight: function (element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
            $(element).closest('.form-group').find('.help-block').html('');
        },

        submitHandler: function (form) {
            form.submit();

            alert('ok');
        }
    });
});


