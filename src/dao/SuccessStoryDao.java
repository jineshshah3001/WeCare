package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.success_storiesVO;


public class SuccessStoryDao {
	
	
	public boolean insertSuccessStory(success_storiesVO objSuccessStory)
	{
		boolean status = false;
		Transaction tr = null;
		try
		{
			SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			tr = s.beginTransaction();
			Integer id  = (Integer)s.save(objSuccessStory);
			if(id.equals(0))
			{
				tr.rollback();
				
			}
			else
			{
				tr.commit();
				status = true;
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return status;
	}
	
	public List getSuccessStories() {
		List l= null;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		
		try{
			
			Query q= s.createQuery("from success_storiesVO " );
			l=q.list();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return l;
		

	}


}
