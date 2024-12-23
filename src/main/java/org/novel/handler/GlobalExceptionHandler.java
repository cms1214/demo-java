package org.novel.handler;

import lombok.extern.slf4j.Slf4j;
import org.novel.model.vo.ResponseVO;
import org.novel.utils.BusinessException;
import org.novel.utils.ResponseEnum;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice //默认响应结果转为json
//@ControllerAdvice//默认转发重定向
public class GlobalExceptionHandler {
    /**
     * 未定义异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO exception(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseVO.error();
    }

    /**
     * 指定异常拦截
     */
    @ExceptionHandler(BindException.class)
    public ResponseVO handleBindException(BindException e){
        return ResponseVO.error().message(e.getMessage());
    }


    /**
     * 拦截ArithmeticException异常
     */
    @ExceptionHandler(ArithmeticException.class)
    public ResponseVO handleArithmeticException(ArithmeticException e) {
        return ResponseVO.error().message("除零异常");
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseVO handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e.getCause());
        return ResponseVO.error().message(e.getMessage()).code(e.getCode());
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public ResponseVO handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return ResponseVO.error().message(ResponseEnum.SERVLET_ERROR.getMessage()).code(ResponseEnum.SERVLET_ERROR.getCode());
    }
}