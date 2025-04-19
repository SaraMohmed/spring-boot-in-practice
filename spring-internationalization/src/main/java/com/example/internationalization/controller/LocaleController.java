package com.example.internationalization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("locale")
public class LocaleController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(value = "/greeting")
    public String getGreeting(@RequestParam(defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
        LocaleContextHolder.setLocale(locale);
        return messageSource.getMessage("greeting", null, locale);
    }
}
