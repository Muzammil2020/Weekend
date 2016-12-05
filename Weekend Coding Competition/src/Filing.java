import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.awt.Label;
import java.io.File;
import java.nio.channels.WritableByteChannel;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class Filing 
{
	@SuppressWarnings("resource")
	public void read() throws Exception
	{
		BufferedReader br;
		BufferedWriter bw;
		int row=0;
		int col;
		Workbook wb;
		Sheet s;
		String s1;
		String userid;
		int sentId=1;
		int tsentPart=0;
		int temp=1;
		int countPart=0;
		String cont;
		//for input file
		File fIn=new File("E:\\3.xls");
		br=new BufferedReader(new FileReader(fIn));
		wb=Workbook.getWorkbook(fIn);
		s=wb.getSheet(0);
		Cell cr=s.getCell(1, 1);
		cont=cr.getContents();
		// Calculating total number of rows filled
		while(!cont.equals(""))
		{
			cr=s.getCell(0, row);
			cont=cr.getContents();
			row++;
		}
		//row=s.getRows();
		col=s.getColumns(); // Calculating total number of columns filled
		jxl.write.Label l;
		
		//
		//for output file handling/creating
		File fOut=new File("E:\\demo5.xls");
		WritableWorkbook fOutw=Workbook.createWorkbook(fOut);
		WritableSheet sheet1=fOutw.createSheet("Task1", 0);
		
		//
		int a=1;
		int iCal=1;
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				Cell c=s.getCell(j, i);
	
				if(j==0)
				{	
					// Placing Headings like row id, sentence id and comment
					if(a==1)
					{
						Cell c1=s.getCell(0, i-1);
						String head=c1.getContents();
						l=new jxl.write.Label(1,i-1,head);
						sheet1.addCell(l);
						c1=s.getCell(1, i-1);
						head=c1.getContents();
						l=new jxl.write.Label(2,i-1,head);
						sheet1.addCell(l);
						l=new jxl.write.Label(0,i-1,"Sentence-Id");
						sheet1.addCell(l);
						a++;
					}
					Cell c1=s.getCell(1, i);
					String rawS=c1.getContents();	// rawS is a sentence to be split
					
					String [] sParts=rawS.split("(\\.)|(\\?)");
					countPart=sParts.length;
					//tsentPart=tsentPart+countPart;
					
					for(int x=0;x<sParts.length;x++)
					{
						l=new jxl.write.Label(j+2,iCal+x,sParts[x]);
						sheet1.addCell(l);
						//System.out.println(iCal);
						//iCal++;
						tsentPart++;
					}
					
					//System.out.println(i);
					int dw=iCal;
				//	temp=i;
				// user id same for split sentence	
					while(dw<countPart+iCal){
						userid=c.getContents();
						l=new jxl.write.Label(j+1,dw,userid);
						sheet1.addCell(l);
						//System.out.println(sentId);
						//System.out.println(l.getContents());
						dw++;
						
					}
					iCal=iCal+countPart;
					
					
					//i=i+countPart-1;
					row=row+countPart-1;
					
				}
				
			}
		}
		while(temp<row-1){
			l=new jxl.write.Label(0,temp,String.valueOf(sentId));
			sheet1.addCell(l);
			sentId++;
			temp++;		
		}
		//System.out.println(iCal);
		
		fOutw.write();
		fOutw.close();

	}
	public static void main(String [] args)
	{
		Filing f=new Filing();
		try {
			f.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

}
