package com.paulos3r.matrix.rest.exception;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    //consiga capiturar os erros quando api erros ele tem acesso ao gat para retorno dos erros
    @Getter
    private List<String> errors;

    //recebe uma lista
    //Construtor para retornar as mensagem tratadas que vai receber da ApplicationControllerAdvice
    public ApiErrors(List<String> errors){
        this.errors = errors;
    }
    //transformando o objeto em list
    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }
}
