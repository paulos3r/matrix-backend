package com.paulos3r.matrix.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class internacionalizacao {

    @Bean  //configurando uma mensagem para os https de retorno RESTFull
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource mensage = new ReloadableResourceBundleMessageSource();
        mensage.setBasename("classpath:menssages");//menssages.properties
        mensage.setDefaultEncoding("ISO-8859-1"); //reconhece os caracteres brasileiros
        mensage.setDefaultLocale(Locale.getDefault()); //detecta a localidade
        return  mensage;
    }

    @Bean //objeto que faz integração das mensagem
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());//carrega a bean da mensagem configurada
        return bean;
    }
}
