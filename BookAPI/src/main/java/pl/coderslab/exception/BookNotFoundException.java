package pl.coderslab.exception;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BookNotFoundException {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public String handleException(HttpServletRequest req, Exception exception, Model model) {
        model.addAttribute("exception", exception);
        model.addAttribute("url", req.getRequestURL() );
        model.addAttribute("errorMessage", exception.getMessage());
        return "exception";
    }
}





//public class BookNotFoundException extends Exception {
//
//
//    private long id;
//
//    public BookNotFoundException(long id) {
//        super(String.format("Book is not found with id : '%s'", id));
//    }
//
//}