package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.*;

public class insertDaoUser {

	public void insert(userVO v){
		
		try{
			SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			Transaction tr= s.beginTransaction();
			Integer id  = (Integer) s.save(v);
			if(id == 0)
				tr.rollback();
			else
			{
					tr.commit();
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
	}
public List fetchupcomingevents(CreateEventVo v){
		
		List l= null;
			SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
			org.hibernate.Session s= sessionfactory.openSession();
			
			
			try{
				//Query q= s.createQuery("from CreateEventVo as event inner join event.insertVO as org on (to_date(event.date ,'YYYY/MM/DD')) > (current_date())");
		//	Query q= s.createQuery("CreateEventVo.event_name,CreateEventVo.EIN,insertVO.name,CreateEventVo.description from CreateEventVo join insertVO on (to_date(CreateEventVo.date ,'MM/DD/YYYY')) > (current_date()) and CreateEventVo.EIN=insertVO.EIN");
				//select e.name, a.city from Employee e INNER JOIN e.address a
				//Query q= s.createQuery("Select c.event_name,c.EIN,c.date, a.name from CreateEventVo c inner join c.abc a on (to_date(c.date ,'YYYY/MM/DD')) > (current_date())");
				//Query q= s.createQuery(" from CreateEventVo where active=1");
				//Query q= s.createQuery("from CreateEventVo c inner join insertVO on (to_date(CreateEventVo.date ,'MM/DD/YYYY')) > CURRENT_TIMESTAMP and CreateEventVo.ein=insertVO.ein");
				Query q= s.createQuery("from CreateEventVo where (to_date(date ,'YYYY/MM/DD')) > (current_date()) and active=1");
				l=q.list();
			}
			catch(Exception e )
			{
				e.printStackTrace();
			}
			return l;
			
	}

public List fetchUserName(Integer user_id){
	List l=null;
	SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	org.hibernate.Session s= sessionfactory.openSession();
	
	
	try{
		
		Query q= s.createQuery("from userVO where user_id= :user_id");
		q.setParameter("user_id",user_id);
		l=q.list();
	}
	catch(Exception e )
	{
		e.printStackTrace();
	}
	
	return l;
}
public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes(StandardCharsets.UTF_8));
         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
        e.printStackTrace();
       }
    return generatedPassword;
}
}