package tools;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;
import jxl.common.Logger;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcel {

	private String[] title;
	private int index = 0;
	private String sheetName;

	public static void main(String[] arg) {

		CreateExcel ce = new CreateExcel();
		ce.create("", 1, 1, 1);
	}

	private static WritableWorkbook book = null;
	private static WritableSheet sheet = null;

	private static Logger logger = Logger.getLogger(CreateExcel.class);
	private String testRoot = GeneralMethods.getTestRoot().replace("target/test-classes/", "src/test/resources/data/")
			+ "androidResource/";
	private File file = new File(testRoot + "resource.xls");

	public void create(String testname, double flow, double cpu, double memory) {

		title = new String[] { "测试名称", "流量消耗", "CPU占用", "内存占用" };

		try {
			Workbook wb = Workbook.getWorkbook(file);
			book = Workbook.createWorkbook(file, wb);
			// if (index<1)
			sheet = addTitle();

			addCellTitle(testname, flow, cpu, memory);

		} catch (Exception e) {
			logger.debug("CreateWorkbook failed !");
			e.printStackTrace();
		}
	}

	private String sheetName() {

		String date = GeneralMethods.getDate();
		sheetName = date + "资源消耗";

		return sheetName;
	}

	private WritableSheet addTitle() {

		sheet = book.createSheet(sheetName(), 0);
		sheet.getSettings().setDefaultColumnWidth(25);
		try {
			for (int i = 0; i < 4; i++) {
				sheet.addCell(new Label(i, 0, title[i]));
			}
		} catch (Exception e) {
		}
		index++;
		return sheet;
	}

	private void addCellTitle(String testname, double flow, double cpu, double memory) {

		try {
			String[] resource = getResource(testname, flow, cpu, memory);
			for (int i = 0; i < 4; i++) {
				sheet.addCell(new Label(i, index, resource[i]));
			}
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		index++;
	}

	private String[] getResource(String testname, double flow, double cpu, double memory) {

		String[] resource = new String[] { testname, flow + "KB", cpu + "%", memory + "MB" };

		return resource;
	}

	public void addExcel(String testname, double flow, double cpu, double memory, boolean blank) {

		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(sheetName);
			// 获取行
			int length = sheet.getRows();
			if (blank == true)
				length++;
			// System.out.println(length);
			WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象
			WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象

			String[] resource = getResource(testname, flow, cpu, memory);
			// 从最后一行开始加
			for (int i = 0; i < resource.length; i++) {
				Label label = new Label(i, length, resource[i]);
				sh.addCell(label);
			}
			wbook.write();
			wbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
