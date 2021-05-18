package cn.woodwhales.rbac.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.woodwhales.common.model.vo.RespVO;

import static cn.woodwhales.rbac.common.enums.GlobalErrorEnum.NPE;
import static cn.woodwhales.rbac.common.enums.GlobalErrorEnum.REQUEST_METHOD_ERROR;

/**
 * @author woodwhales on 2021-05-18 16:07
 * @description 全局 controller 异常捕获类
 */
@Slf4j
@RestController
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({Exception.class })
    public RespVO<Void> exception(Exception exception) {
        log.error("exception = {}", exception.getMessage(), exception);
        if(exception instanceof NullPointerException) {
            return RespVO.error(NPE);
        }

        if(exception instanceof HttpRequestMethodNotSupportedException) {
            return RespVO.error(REQUEST_METHOD_ERROR);
        }

        return RespVO.errorWithErrorMsg(exception.getMessage());
    }

    @ExceptionHandler({ BindException.class })
    public RespVO<Void> bindException(BindException exception) {
        log.error("exception = {}", exception.getMessage(), exception);
        String defaultMessage = exception.getAllErrors()
                                         .get(0)
                                         .getDefaultMessage();
        return RespVO.errorWithErrorMsg(defaultMessage);
    }

}
