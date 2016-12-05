import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.lang.Math;
import java.util.Random;

public class Projecty implements ActionListener{

	private JFrame frame;
	private JTextField txtValsdvsdvasvdv;
	private JTextArea textArea;
	JCheckBox chckbxNewCheckBox;
	JCheckBox chckbxNewCheckBox_1;
	JCheckBox chckbxInstructorsAbilityTo;
	JCheckBox chckbxNewCheckBox_2 ;
	JCheckBox chckbxNewCheckBox_3;
	JCheckBox chckbxIntructorsConcernRegarding;
	JCheckBox chckbxYourSatisfactionLevel;
	JPanel panel;
	JButton btnNewButton ;
	JButton btnClickHereTo;
	JTextArea textArea1;
	public int rowindex;
	public int rowcount=0;
	BufferedReader br;
	BufferedWriter bw;
	int row;
	int col;
	Workbook wb;
	Sheet s;
	String s1;
	Random rand=new Random();
	File fOut;
	File fIn;
	WritableWorkbook fOutw;
	WritableSheet sheet1;
	Label l;
	Cell c;
	String cont;
	int submit;
	int skip;
	Random r ;
	public Projecty()
	{
		r = new Random();
		fOut=new File("C:\\Users\\haide\\Desktop\\Haider5.xls");
		fIn=new File("C:\\Users\\haide\\Desktop\\demo5.xls");
		try {
			fOutw=Workbook.createWorkbook(fOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet1=fOutw.createSheet("Task1",0);
		try {
			br=new BufferedReader(new FileReader(fIn));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb=Workbook.getWorkbook(fIn);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s=wb.getSheet(0);
		row=s.getRows();
		col=s.getColumns();
		frame = new JFrame();
		panel = new JPanel();
	}

	int [] count=new int[7] ;
	
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Projecty window = new Projecty();
					window.initialize();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 * @throws  
	 * @throws BiffException 
	 */
	
	private void initialize() throws Exception 
	{	
		for(int x=0;x<row;x++)
		{
			for(int i=0;i<col;i++)
			{
				l=new Label(i,x," ");
				sheet1.addCell(l);
			}
		}
		int j=1;
		c=s.getCell(1, 0);
		cont=c.getContents();
		//System.out.println(cont);
		while(!cont.equals(""))
		{
			c=s.getCell(1, j);
			cont=c.getContents();
			System.out.println(cont);
			rowcount++;
			j++;
		}
		for(int i=0;i<rowcount;i++)
		{
			c=s.getCell(0, i);
			l=new Label(0,i,c.getContents());	
			sheet1.addCell(l);		
		}
		for(int i=0;i<rowcount;i++)
		{
			c=s.getCell(2, i);
			l=new Label(1,i,c.getContents());
			sheet1.addCell(l);		
		}
		for(int x=0;x<rowcount;x++)
		{
			for(int i=2;i<9;i++)
			{
				l=new Label(i,x,"0");
				sheet1.addCell(l);
				
			}
		}
//		fOutw.write();
//		fOutw.close();
		System.out.println(rowcount);
		
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel.setBackground(new Color(153, 204, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtValsdvsdvasvdv = new JTextField();
		txtValsdvsdvasvdv.setText("Comments");
		txtValsdvsdvasvdv.setBounds(21, 65, 76, 20);
		panel.add(txtValsdvsdvasvdv);
		txtValsdvsdvasvdv.setColumns(10);	
		boolean sentence=false;
		do
		{
			rowindex=rand.nextInt(rowcount);
			Cell c1=s.getCell(2, rowindex);
			cont=c1.getContents();
			System.out.println(rowindex);
			
			sentence=true;
			System.out.println(rowindex);
		}while(false);
		
		textArea = new JTextArea(cont);
		textArea.setBounds(98, 23, 400, 80);
		textArea.setEditable(false);
		textArea.removeAll();
		panel.add(textArea);
		textArea.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("Accessibilty of teacher outside the class");
		chckbxNewCheckBox.setBackground(new Color(153, 204, 255));
		chckbxNewCheckBox.setBounds(33, 116, 309, 15);
		chckbxNewCheckBox.addActionListener(this);
		panel.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("Knowledge base/grip over the subject");
		chckbxNewCheckBox_1.setBackground(new Color(153, 204, 255));
		chckbxNewCheckBox_1.setBounds(33, 128, 347, 23);
		chckbxNewCheckBox_1.addActionListener(this);
		panel.add(chckbxNewCheckBox_1);
		
		chckbxInstructorsAbilityTo = new JCheckBox("Instructor's ability to motivate you towards subject");
		chckbxInstructorsAbilityTo.setBackground(new Color(153, 204, 255));
		chckbxInstructorsAbilityTo.setBounds(33, 148, 347, 20);
		chckbxInstructorsAbilityTo.addActionListener(this);
		panel.add(chckbxInstructorsAbilityTo);
		
		chckbxNewCheckBox_2 = new JCheckBox("Instructor's ability to integerate contents of module with the real-world");
		chckbxNewCheckBox_2.setBackground(new Color(153, 204, 255));
		chckbxNewCheckBox_2.setBounds(33, 165, 397, 20);
		chckbxNewCheckBox_2.addActionListener(this);
		panel.add(chckbxNewCheckBox_2);
		
		chckbxNewCheckBox_3 = new JCheckBox("Adherence to course outline?");
		chckbxNewCheckBox_3.setBackground(new Color(153, 204, 255));
		chckbxNewCheckBox_3.setBounds(33, 185, 285, 15);
		chckbxNewCheckBox_3.addActionListener(this);
		panel.add(chckbxNewCheckBox_3);
		
		chckbxIntructorsConcernRegarding = new JCheckBox("Intructor's concern regarding lab");
		chckbxIntructorsConcernRegarding.setBackground(new Color(153, 204, 255));
		chckbxIntructorsConcernRegarding.setBounds(33, 203, 230, 15);
		chckbxIntructorsConcernRegarding.addActionListener(this);
		panel.add(chckbxIntructorsConcernRegarding);
		
		chckbxYourSatisfactionLevel = new JCheckBox("Your satisfaction level with delivery method of the instructor");
		chckbxYourSatisfactionLevel.setForeground(new Color(0, 0, 0));
		chckbxYourSatisfactionLevel.setBackground(new Color(153, 204, 255));
		chckbxYourSatisfactionLevel.setBounds(33, 221, 338, 15);
		chckbxYourSatisfactionLevel.addActionListener(this);
		panel.add(chckbxYourSatisfactionLevel);
		
		btnClickHereTo = new JButton("Click here to submit");
		btnClickHereTo.setBackground(new Color(255, 255, 255));
		btnClickHereTo.setBounds(54, 274, 170, 23);
		btnClickHereTo.addActionListener(this);
		panel.add(btnClickHereTo);
		
		btnNewButton = new JButton("Skip");
		btnNewButton.setBounds(251, 274, 91, 23);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
	}
	boolean run=false;
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
	//	do{
			// random value 
				//rowindex=((int)Math.random()*rowcount+1)%9;
				
			//textArea1.setEditable(false);
		//	textArea1.removeAll();
		//	panel.add(textArea1);
		//	textArea.setColumns(10);
			// output file opening
			fOut=new File("C:\\Users\\haide\\Desktop\\Haider6.xls");
			try {
				fOutw=Workbook.createWorkbook(fOut);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				//e2.printStackTrace();
			}
			sheet1=fOutw.createSheet("Task1",0);
			for(int x=0;x<row;x++)
			{
				for(int i=0;i<col;i++)
				{
					l=new Label(i,x," ");
					try {
						sheet1.addCell(l);
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
					//	e1.printStackTrace();
					}
				}
			}
			c=s.getCell(1, 0);
			cont=c.getContents();
			//System.out.println(cont);
			for(int i=0;i<rowcount;i++)
			{
				c=s.getCell(0, i);
				l=new Label(0,i,c.getContents());	
				try {
					sheet1.addCell(l);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}		
			}
			for(int i=0;i<rowcount;i++)
			{
				c=s.getCell(2, i);
				l=new Label(1,i,c.getContents());
				try {
					sheet1.addCell(l);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
			//		e1.printStackTrace();
				}		
			}
			System.out.println(rowcount+" sdfdslkfmklxcm");
			for(int i=1;i<8;i++)
			{
				l=new Label(i+1,0,"checkbox"+i);
				try {
					sheet1.addCell(l);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
				//	e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
				}
				
			}
			for(int x=1;x<rowcount;x++)
			{
				for(int i=2;i<11;i++)
				{
					l=new Label(i,x,"0");
					try {
						sheet1.addCell(l);
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
//						e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
//						e1.printStackTrace();
					}
					
				}
			}
			//do
			{
				//rowindex=(int)Math.random()%rowcount+1;
				rowindex = 1+r.nextInt(rowcount);
				c=s.getCell(2, rowindex);
				cont=c.getContents();
				//textArea.setText(cont);
				if(e.getSource()==chckbxNewCheckBox)
				{
					count[0]=count[0]+1;
				}
				else if(e.getSource()==chckbxNewCheckBox_1)
				{
					count[1]=count[1]+1;
				}
				else if(e.getSource()==chckbxInstructorsAbilityTo)
				{
						count[2]=count[2]+1;
				}
				else if(e.getSource()==chckbxNewCheckBox_2)
				{
						count[3]=count[3]+1;
				}
				else if(e.getSource()==chckbxNewCheckBox_3)
				{
						count[4]=count[4]+1;
				}
				else if(e.getSource()==chckbxIntructorsConcernRegarding)
				{
						count[5]=count[5]+1;
				}
				else if(e.getSource()==chckbxYourSatisfactionLevel)
				{
					count[6]=count[6]+1;
				}
				else if(e.getSource()==btnClickHereTo)
				{
					submit++;
					//Random r = new Random();
					rowindex = 1+r.nextInt(rowcount);
					c=s.getCell(2, rowindex);
					cont=c.getContents();
					textArea.setEditable(true);
					textArea.setText(cont);
					textArea.setEditable(false);
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
					chckbxYourSatisfactionLevel.setSelected(false);
					chckbxIntructorsConcernRegarding.setSelected(false);
					chckbxInstructorsAbilityTo.setSelected(false);
					chckbxNewCheckBox_3.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);
					System.out.println("\n\n\n"+cont+" " + rowindex);
				}
				else if(e.getSource()==btnNewButton)
				{
					rowindex = 1+r.nextInt(rowcount);
					c=s.getCell(2, rowindex);
					cont=c.getContents();
					textArea.setEditable(true);
					textArea.setText(cont);
					textArea.setEditable(false);
					chckbxNewCheckBox.setSelected(false);
					chckbxNewCheckBox_1.setSelected(false);
					chckbxYourSatisfactionLevel.setSelected(false);
					chckbxIntructorsConcernRegarding.setSelected(false);
					chckbxInstructorsAbilityTo.setSelected(false);
					chckbxNewCheckBox_3.setSelected(false);
					chckbxNewCheckBox_2.setSelected(false);
					skip++;
				}
			}
			//while(run==false);
				
			for(int i=0;i<7;i++)
			{
				c=sheet1.getCell(i+2,rowindex);
				l=new Label(i+2,rowindex,(String.valueOf((Integer.valueOf(c.getContents())+(count[i])))));
				System.out.println(l.getContents()+"sddcscasdcv");
				try {
					sheet1.addCell(l);
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			c=sheet1.getCell(9,0);
			l=new Label(9,0,"Submit Count");
		//	System.out.println(l.getContents()+"sddcscasdcv");
			try {
				sheet1.addCell(l);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
			//	e1.printStackTrace();
			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			c=sheet1.getCell(10,0);
			l=new Label(10,0,"Skip Count");
		//	System.out.println(l.getContents()+"sddcscasdcv");
			try {
				sheet1.addCell(l);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			c=sheet1.getCell(9,rowindex);
			l=new Label(9,rowindex,(String.valueOf((Integer.valueOf(c.getContents())+submit))));
		//	System.out.println(l.getContents()+"sddcscasdcv");
			try {
				sheet1.addCell(l);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			c=sheet1.getCell(10,rowindex);
			l=new Label(10,rowindex,(String.valueOf((Integer.valueOf(c.getContents())+skip))));
		//	System.out.println(l.getContents()+"sddcscasdcv");
			try {
				sheet1.addCell(l);
			} catch (RowsExceededException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (WriteException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			try {
				System.err.println("\n\n\n\n"+rowindex);
				fOutw.write();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

				
			try {
				fOutw.close();
			} catch (WriteException e1) {
			// TODO Auto-generated catch block
				//e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
//	}while(run==false);
	}
	
}

