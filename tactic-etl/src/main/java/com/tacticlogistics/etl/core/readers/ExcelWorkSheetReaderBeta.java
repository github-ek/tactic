package com.tacticlogistics.etl.core.readers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelWorkSheetReaderBeta implements Reader {

	private String workSheetName;

	public String getWorkSheetName() {
		return workSheetName;
	}

	public void setWorkSheetName(String value) {
		if(value == null){
			throw new IllegalArgumentException("WorkSheetName");
		}
		this.workSheetName = value;
	}

	@Override
	public String read(Path archivo) throws IOException {
		List<String> names = new ArrayList<>();
		InputStream in = new FileInputStream(archivo.toFile());
		Workbook workbook = null;

		try {
			workbook = WorkbookFactory.create(in);
		} catch (EncryptedDocumentException e1) {
			throw new RuntimeException(e1);
		} catch (InvalidFormatException e1) {
			throw new RuntimeException(e1);
		}

		int size = workbook.getNumberOfSheets();
		for (int i = 0; i < size; i++) {
			String name = workbook.getSheetName(i);
			if (!name.equalsIgnoreCase(getWorkSheetName())) {
				names.add(name);
			}
		}

		for (String name : names) {
			workbook.removeSheetAt(workbook.getSheetIndex(name));
		}

		String texto = "";

		if (workbook instanceof HSSFWorkbook) {
			try (ExcelExtractor extractor = new ExcelExtractor((HSSFWorkbook) workbook)) {
				extractor.setFormulasNotResults(false);
				extractor.setIncludeSheetNames(false);
				texto = extractor.getText();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			try (XSSFExcelExtractor extractor = new XSSFExcelExtractor((XSSFWorkbook) workbook)) {
				extractor.setFormulasNotResults(false);
				extractor.setIncludeSheetNames(false);
				texto = extractor.getText();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		workbook.close();

		return texto;
	}
}
