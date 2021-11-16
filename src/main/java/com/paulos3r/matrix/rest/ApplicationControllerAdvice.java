package com.paulos3r.matrix.rest;


import com.paulos3r.matrix.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationControllerAdvice {

    /*Quando ocorrer uma exception na api o erro é tratado
    toda vez que tiver um erro de VALIDAÇÃO vamos capiturar o getBindingResult que tem todas mensagem de erro
    retorna com objeto padronizado*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST) //retorna o status do codigo do erro
    public ApiErrors hendleValidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();  //resultado da validação
        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map( objectError -> objectError.getDefaultMessage()) //retorna qual foi o erro que gerou
                .collect(Collectors.toList()); //transforma em uma lista
        return new ApiErrors(messages);
    }

        /* exception de tratamento NÃO ENCONTRADO
        toda vez que não for ENCONTRADO objeto retorna mensagem tratada*/
    @ExceptionHandler({ResponseStatusException.class})
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
        String mensagemErro = ex.getMessage(); // obtem a mensagem de erro retornada do ResponseStatusException caso não for encontrato o objeto
        HttpStatus codigoStatus = ex.getStatus(); // obtem o codigo do status de erro
        ApiErrors apiErrors = new ApiErrors(mensagemErro);

        return new ResponseEntity(apiErrors, codigoStatus);

    }
}
