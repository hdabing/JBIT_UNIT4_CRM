package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class SimpleExcelWrite {
	/**
	 * 生成EXCEL
	 * @param os 
	 * @param title 标题数组，3位
	 * @param list 需要写入的数据,list为二维数组
	 * @throws WriteException
	 * @throws IOException
	 */
    @SuppressWarnings("rawtypes")
	public void createExcel(OutputStream os,String[] title, List list) throws WriteException,IOException{
        //创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("Sheet1",0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        for(int j=0;j<title.length;j++){
        	//添加标题
        	Label labeltitle=new Label(j,0,title[j]);
        	sheet.addCell(labeltitle);
        }
        
        //将list数据写入到excel表格中
        if(list!=null){
	        for(int i=0;i<list.size();i++){
	        	Object[] obj=(Object[]) list.get(i);
	        	Label labeldatai=new Label(0,i+1,Integer.toString((i+1)));
	    		sheet.addCell(labeldatai);
	        	for(int k=0;k<2;k++){
	        		Label labeldata=new Label(k+1,i+1,obj[k].toString());
	        		sheet.addCell(labeldata);
	        	}
	        }
        }
        
        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        os.close();
        
    }
    
}