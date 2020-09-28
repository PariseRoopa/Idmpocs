package Myproject;

import java.io.FileWriter;
import java.io.StringWriter;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class Webdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        try {
		            RowSetFactory raf =RowSetProvider.newFactory();
		            WebRowSet wrs=raf.createWebRowSet();
		            wrs.setUrl("jdbc:mysql://localhost:3306/datamy");
		            wrs.setUsername("root");
		            wrs.setPassword("root");
		            wrs.setCommand("select * from employeee");
		            wrs.execute();
		            FileWriter fw = new FileWriter("employee.xml");
		            wrs.writeXml(fw);
		            wrs.close();
		            System.out.println("XML is created");    
		            StringWriter sw = new StringWriter();
		            wrs.writeXml(sw);
		            System.out.println("===========");
		            System.out.println(sw.toString());
		            System.out.println("=============");
		            fw.flush();
		            fw.close();
		        }
		        catch(Exception e) {
		            System.out.println(e);
		        }
	}
}