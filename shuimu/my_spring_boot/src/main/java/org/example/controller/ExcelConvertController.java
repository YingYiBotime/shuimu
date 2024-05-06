package org.example.controller;

import org.example.service.ExcelConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/excel")
public class ExcelConvertController {

    @Autowired
    ExcelConvertService excelConvertService;
    @PostMapping("/convert")
    private void convertExcel(){
        excelConvertService.convetExcelToXml();
    }

    @PostMapping("/up")
    private void upExcelFile(@RequestBody  MultipartFile file){
        excelConvertService.upExcel(file);
    }
}
