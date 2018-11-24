package com.hackyeah.mainapp.config;

import com.hackyeah.mainapp.appointment.entities.AppointmentRegister;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ExcelView extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {

        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<Object[]> appointmentRegisters = (List<Object[]>) model.get("appointments");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("User Detail");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern((short)1);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);


        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("City");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Average time waiting for specialist");
        header.getCell(1).setCellStyle(style);



        int rowCount = 1;

        for(Object object[] : appointmentRegisters){
            Row userRow =  sheet.createRow(rowCount++);
            userRow.createCell(0).setCellValue(object[0].toString());
            userRow.createCell(1).setCellValue(object[1].toString());

        }

    }

}
