package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import vo.CreateEventVo;
import vo.available_thingsVO;
import vo.insertVO;
import vo.organization_needVO;
import vo.subscriptionVO;

public class subscriptionDAO {

	public List fetchNGO(){
     List li = new ArrayList();
		
		try{
			
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			Transaction tr = s.beginTransaction();
			
			Query q = s.createQuery("from insertVO where active='1'");
			li = q.list();
		}
		
	 catch(Exception e) {
		 e.printStackTrace();
		  }
			
		return li;
	}
	public List findunsubngos(String eins){
		 List li = new ArrayList();
		try{
			
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			Transaction tr = s.beginTransaction();
			
			Query q = s.createQuery("from insertVO where EIN not in("+eins+") and active='1'");
			li = q.list();
		}
		
	 catch(Exception e) {
		 e.printStackTrace();
		  }
		
		return li;
	}

	public void insert(subscriptionVO obj){
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(obj);

			tr.commit();
			System.out.println("insert Done :: ");
		} 

		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List getEmailForSubscription(String ein) {
		List l= null;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		
		try{
			
			Query q= s.createQuery("from subscriptionVO where EIN = '"+ein+"' ");
			l=q.list();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return l;
		

	}
	public List getSubscription(subscriptionVO objsubVO) {
		List l= null;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		
		try{
			
			Query q= s.createQuery("from subscriptionVO where email_id = '"+objsubVO.getEmail_id()+"' ");
			l=q.list();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return l;
		

	}
	
	public boolean deleteSubscription(String email_id) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		boolean status = false;
		Transaction tr = null;
		
		try{
			tr=s.beginTransaction();
			
			Query q= s.createQuery("delete subscriptionVO where email_id='"+email_id+"'");
			//q.setParameter("email_id", email_id);
			q.executeUpdate();
			tr.commit();
			
		}catch (Exception e ){
			e.printStackTrace();
		}
		return status;
	}

	
}
