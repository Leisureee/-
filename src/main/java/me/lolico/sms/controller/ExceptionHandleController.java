package me.lolico.sms.controller;

import me.lolico.sms.lang.InvalidActionException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

/**
 * @author lolico
 */
@ControllerAdvice
public class ExceptionHandleController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidActionException.class)
    public String handle(Exception ex, Model model) {
        model.addAttribute("error", ex.getClass().getName());
        model.addAttribute("status", HttpStatus.BAD_REQUEST);
        model.addAttribute("exception", ex.getClass().getName());
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("timestamp", new Date());
        return "error";
    }
}
