package cn.soe.boot.demo.controller;

import cn.soe.boot.core.bean.rest.ReturnT;
import cn.soe.boot.core.exception.BizException;
import cn.soe.boot.demo.bean.StudentParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiezhenxiang 2020/5/8
 */
@RestController
@Tag(name = "Swagger测试")
@RequestMapping(value = "/swagger")
public class SwaggerTestController {

    @Operation(summary = "异常测试")
    @GetMapping(value = "/error")
    public ReturnT<Object> error() {
        throw new BizException("抛异常了");
    }

    @GetMapping(value = "/error1")
    public ReturnT<Object> error1() {
        return ReturnT.error("error1");
    }

    // 校验、异常
    @PostMapping(value = "/student")
    @Operation(summary = "学生测试")
    public ReturnT<StudentParam> test(@Validated @RequestBody StudentParam param) {
        return ReturnT.success(param);
    }
}