package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.available_thingsVO;
import vo.organization_needVO;

public class AvailableThingsDao {
	
	public boolean insertAvailThings(available_thingsVO objAvailThingsVO)
	{
		boolean status = false;
		Transaction tr = null;
		try
		{
			SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			tr = s.beginTransaction();
			Integer id  = (Integer)s.save(objAvailThingsVO);
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
	public List getAvailThings(available_thingsVO objAvailThingsVO) {
		List l= null;
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		
		try{
			
			Query q= s.createQuery("from available_thingsVO where user_id = '"+objAvailThingsVO.getUser_id()+"' ");
			l=q.list();
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return l;
		

	}
	public boolean updateAvailThings(available_thingsVO objAvailThingsVO) {
		SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
		org.hibernate.Session s= sessionfactory.openSession();
		
		boolean status = false;
		Transaction tr = null;
		
		try{
			tr=s.beginTransaction();
			String querystring="update available_thingsVO set elec = "+objAvailThingsVO.getElec()+", edu = "+objAvailThingsVO.getEdu()+" , health = "+objAvailThingsVO.getHealth()+", hunger = "+objAvailThingsVO.getHunger()
			+" , sports = "+objAvailThingsVO.getSports() + ", household = "+objAvailThingsVO.getHousehold() + 
			", electext= '" +objAvailThingsVO.getElectext()+"'" + ", edutext= '" +objAvailThingsVO.getEdutext()+"'" +
			", healthtext= '" +objAvailThingsVO.getHealthtext()+"'" + ", hungertext='" +objAvailThingsVO.getHungertext()+"'" + 
			", sportstext= '" +objAvailThingsVO.getSportstext()+"'" + ", housetext= '" +objAvailThingsVO.getHousetext()+"'";
			/*if (objAvailThingsVO.getElec()==1)
			{	querystring=querystring+" , electext= '" +objAvailThingsVO.getElectext()+"'";
			
			}
			if (objAvailThingsVO.getEdu()==1)
			{	querystring=querystring+" , edutext= '" +objAvailThingsVO.getEdutext()+"'";
			
			}
			if (objAvailThingsVO.getHealth()==1)
			{	querystring=querystring+" , healthtext= '" +objAvailThingsVO.getHealthtext()+"'";
			
			}
			if (objAvailThingsVO.getHunger()==1)
			{	querystring=querystring+" , hungertext='" +objAvailThingsVO.getHungertext()+"'";
			
			}
			if (objAvailThingsVO.getSports()==1)
			{	querystring=querystring+" , sportstext= '" +objAvailThingsVO.getSportstext()+"'";
			
			}
			if (objAvailThingsVO.getHousehold()==1)
			{	querystring=querystring+" , housetext= '" +objAvailThingsVO.getHousetext()+"'";
			
			}	
			*/				
			querystring=querystring+	", other = '"+objAvailThingsVO.getOther()+"' where user_id = "+objAvailThingsVO.getUser_id();
			
			Query q= s.createQuery(querystring);
			int id = q.executeUpdate();
			if(id==0)
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

	public List getUserAndAvailableThings(available_thingsVO objAvailThingsVO){
		
		List l= null;
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			
			try{
				
				Query q= s.createQuery("from available_thingsVO a, userVO u where a.user_id = u.user_id "
						+ "and "+objAvailThingsVO.getCategory()+" =1");
				l=q.list();
			}
			catch(Exception e )
			{
				e.printStackTrace();
			}
			return l;
			
		}

	
}
