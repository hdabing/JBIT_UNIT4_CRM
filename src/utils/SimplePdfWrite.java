package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class SimplePdfWrite {
	/**
	 * 将List数据输出到PDF文件
	 * @param filename 文件的绝对路径
	 * @param title 文件的标题,3个
	 * @param list 要输出的数据内容，2维数组
	 * @throws DocumentException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public void ExportPDF(String filename,String[] title,List list) throws DocumentException, IOException{
		Document document=new Document();
		FileOutputStream fos=new FileOutputStream(filename);
		PdfWriter.getInstance(document, fos);
		BaseFont bfChinese = BaseFont.createFont("C:/WINDOWS/Fonts/SIMHEI.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED); 
		Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
		PdfPTable table=new PdfPTable(3);
		for(int i=0;i<title.length;i++){
			Paragraph ph=new Paragraph(title[i],FontChinese);
			table.addCell(ph);
		}
		for(int j=0;j<list.size();j++){
			Object[] obj=(Object[]) list.get(j);
			String rownum=Integer.toString(j+1);
			table.addCell(rownum);
			for(int k=0;k<2;k++){
				Paragraph ph2=new Paragraph(obj[k].toString(),FontChinese);
				table.addCell(ph2);
			}
		}
		document.open();
		document.add(table);
		document.close();
		fos.close();
	}
}
