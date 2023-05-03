package cn.soe.boot.demo.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

/**
 * @author xiezhenxiang 2023/4/26
 */
@Schema(description = "学生参数")
@Getter
@Setter
public class StudentParam {

    @Schema(description = "学生姓名")
    private String name;
    @Schema(description = "学生年龄")
    @Max(value = 100, message = "年龄不能大于100")
    private Integer age;
}
