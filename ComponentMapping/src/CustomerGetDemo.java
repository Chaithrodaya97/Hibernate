import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class CustomerGetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c = new Configuration().configure();
		SessionFactory session = c.buildSessionFactory();
		Session s = session.openSession();
		Transaction t = s.beginTransaction();
		Customer cu = s.get(Customer.class, 6);
		System.out.println(cu.getCustomerId());
		System.out.println(cu.getAddress());
		System.out.println(cu.getDob());
		System.out.println(cu.getGender());
		Name name = cu.getCustomerName();
		System.out.println(name);
		
		Blob cupic = cu.getProfilePhoto();
		try {
			InputStream io = cupic.getBinaryStream();
			FileOutputStream fout = new FileOutputStream("./resources/newpic.jpg");
			
			int data=0;
			while((data = io.read())!=-1)
			{
				fout.write(data);
			}
			io.close();
			fout.close();
			
			Clob description = cu.getDescription();
			Reader r = description.getCharacterStream();
			PrintWriter pw = new PrintWriter("./resources/customerDbInfo.txt");
			int chardata = 0;
			while((chardata=r.read())!=-1)
			{
				pw.print((char)chardata);
			}
			r.close();
			pw.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		t.commit();
		session.close();

	}

}
