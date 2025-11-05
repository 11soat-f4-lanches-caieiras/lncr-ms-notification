package br.com.tp.lncr.notification.handlers;

import br.com.tp.lncr.commons.utils.ExceptionHandlerUtil;
import br.com.tp.lncr.core.exceptions.NotificationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotificationInboundHandler {

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<Object> handlerNotificationException(NotificationException ex) {
        return ExceptionHandlerUtil.handleException(ex.getMessage(), ex.getCode(), ex);
    }
}


