package com.banjvduo.demo.exception;

import com.banjvduo.demo.dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "error";

    /**
     * 返回错误的页面
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /**
     * 返回错误的 JSON 格式信息
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = DemoException.class)
    @ResponseBody
    public ResultDTO<String> jsonErrorHandler(HttpServletRequest req, DemoException e){
        ResultDTO<String> result = new ResultDTO<>();
        result.setMsg(e.getMessage());
        result.setCode(500);
        result.setData("Test");
        result.setUrl(req.getRequestURL().toString());
        return result;
    }



}
