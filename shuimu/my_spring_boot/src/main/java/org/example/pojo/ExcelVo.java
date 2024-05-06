package org.example.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExcelVo {
    @ExcelProperty("接口(文件)编码")
    private String keyCode;
    @ExcelProperty("接口(文件)名称")
    private String name;
    @ExcelProperty("文件名规则")
    private String fileRule;
    @ExcelProperty("新自动化分类")
    private String autoType;
    @ExcelProperty("新自动化分类码值")
    private String autoTypeCode;


}
