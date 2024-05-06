package org.example.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface ExcelConvertService {
    void convetExcelToXml();
    void upExcel(MultipartFile file);
}
