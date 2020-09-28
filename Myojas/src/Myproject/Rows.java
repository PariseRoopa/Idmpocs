package Myproject;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Rows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RowSetFactory raf = RowSetProvider.newFactory();
			CachedRowSet crs = raf.createCachedRowSet();
			crs.setUrl("jdbc:mysql://localhost:3306/datamy");
			crs.setUsername("root");
			crs.setPassword("root");
			crs.setCommand("select * from employeee");
			crs.execute();
			while(crs.next()) {
				System.out.println(crs.getInt(1) + " "+ crs.getString(2) + " " + crs.getDouble(3) + " " + crs.getString(4));
				
				
			}
			  crs.absolute(1);
			  crs.updateDouble(3, crs.getDouble(3)+2000);
			  crs.updateRow();
			  System.out.println("backward direction");
			  crs.afterLast();
			  while(crs.previous()) {
			  System.out.println(crs.getInt(1) + " "+ crs.getString(2) + " " + crs.getDouble(3) + " " + crs.getString(4));
		}
			  crs.acceptChanges();
			  crs.commit();

	}
		catch(Exception e) {
			
		}

}

	}

