package com.api.helper;

import com.api.entity.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of Employees

    public static List<Employee> convertExcelToListOfEmployee(InputStream is) {
        List<Employee> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Employee e = new Employee();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            CellType cellType = cell.getCellType();
                            if (cellType == CellType.NUMERIC) {
                                double numericValue = cell.getNumericCellValue();
                                String stringValue = String.valueOf((int) numericValue);
                                e.setEmployeeID((float) Integer.parseInt(stringValue.replaceAll("\\D+", "")));
                            } else if (cellType == CellType.STRING) {
                                String cellValue = cell.getStringCellValue();
                                String numericPart = cellValue.replaceAll("\\D+", "");
                                e.setEmployeeID((float) Integer.parseInt(numericPart));
                            }
                            break;


                        case 1:
                                e.setFullName(cell.getStringCellValue());
                                break;

                            case 2:
                                e.setJobTitle(cell.getStringCellValue());
                                break;

                            case 3:
                                e.setDepartment(cell.getStringCellValue());
                                break;

                            case 4:
                                e.setBusinessUnit(cell.getStringCellValue());
                                break;

                            case 5:
                                e.setGender(cell.getStringCellValue());
                                break;

                            case 6:
                                e.setEthnicity(cell.getStringCellValue());
                                break;

                            case 7:
                                e.setAge((int)cell.getNumericCellValue());
                                break;

                            case 8:
                                e.setHiringDate(cell.getDateCellValue());
                                break;

                            case 9:
                                e.setAnnualSalary(cell.getNumericCellValue());
                                break;

                        case 10:
                            cellType = cell.getCellType();
                            if (cellType == CellType.NUMERIC) {

                                double numericValue = cell.getNumericCellValue();
                                e.setBonus(numericValue);

                            } else if (cellType == CellType.STRING) {

                                String cellValue = cell.getStringCellValue().trim();

                                if (cellValue.endsWith("%")) {
                                    String numericPart = cellValue.substring(0, cellValue.length() - 1);
                                    double numericValue = Double.parseDouble(numericPart);
                                    e.setBonus(numericValue / 100); // Divide by 100 to convert the percentage to a decimal value
                                } else {

                                    // Handle the case where the cell does not contain a valid percentage value
                                    e.setBonus(null); // Set the bonus to null or any other appropriate default value
                                }
                            } else {

                                // Handle the case where the cell does not contain a numeric or string value
                                e.setBonus(null); // Set the bonus to null or any other appropriate default value
                            }
                            break;



                        case 11:
                                e.setCountry(cell.getStringCellValue());
                                break;

                            case 12:
                                e.setCity(cell.getStringCellValue());
                                break;

                        case 13:
                            cellType = cell.getCellType();
                            if (cellType == CellType.NUMERIC) {
                                // Check if the cell contains a valid date value
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    Date exitDate = cell.getDateCellValue();
                                    e.setExitDate(exitDate);
                                } else {
                                    // Handle the case where the cell does not contain a valid date value
                                    e.setExitDate(null); // Set the exit date to null or any other appropriate default value
                                }
                            } else {
                                // Handle the case where the cell does not contain a numeric value (e.g., it is empty or contains a string)
                                e.setExitDate(null); // Set the exit date to null or any other appropriate default value
                            }
                            break;


                        default:
                                break;
                        }
                    cid++;

                }

                list.add(e);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}
