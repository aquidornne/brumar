export class Util{
    isEmpty(obj) {
        for(var prop in obj) {
            if(obj.hasOwnProperty(prop))
                return false;
        }
        return true;
    }
    validarCpf(cpf) {
        var add = 0;
        var rev = 0;
        cpf = cpf.replace(/[^\d]+/g,'');
        if(cpf == '') return false;	
        // Elimina CPFs invalidos conhecidos	
        if (cpf.length != 11 || 
            cpf == "00000000000" || 
            cpf == "11111111111" || 
            cpf == "22222222222" || 
            cpf == "33333333333" || 
            cpf == "44444444444" || 
            cpf == "55555555555" || 
            cpf == "66666666666" || 
            cpf == "77777777777" || 
            cpf == "88888888888" || 
            cpf == "99999999999")
                return false;
        // Valida 1o digito
        add = 0;
        for (var i = 0; i < 9; i ++)
            add += parseInt(cpf.charAt(i)) * (10 - i);
            rev = 11 - (add % 11);
            if (rev == 10 || rev == 11)
                rev = 0;
            if (rev != parseInt(cpf.charAt(9)))
                return false;
        // Valida 2o digito
        add = 0;
        for (var i = 0; i < 10; i ++)
            add += parseInt(cpf.charAt(i)) * (11 - i);
        rev = 11 - (add % 11);
        if (rev == 10 || rev == 11)
            rev = 0;
        if (rev != parseInt(cpf.charAt(10)))
            return false;		
        return true;
    }
    validarEmail(mail) {
        var er = new RegExp(/^[A-Za-z0-9_\-\.]+@[A-Za-z0-9_\-\.]{2,}\.[A-Za-z0-9]{2,}(\.[A-Za-z0-9])?/);
        if (typeof(mail) == "string") {
            if (er.test(mail)) {
                return true;
            }
        } else if (typeof(mail) == "object") {
            if (er.test(mail.value)) {
                return true;
            }
        } else {
            return false;
        }
    }
    buscaPosicisaoObj(data, ref) {
        var retorno = {};
        $.each(data, function(key, cont) {
            if(cont.value == ref){
                retorno = cont;
            }
        });
        return retorno;
    }
    isNullOrEmpty(data){
        if(data !== undefined && data !== null && data !== ""){
            return false;
        }
        return true
    }
}