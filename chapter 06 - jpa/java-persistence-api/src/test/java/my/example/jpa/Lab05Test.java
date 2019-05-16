package my.example.jpa;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab05.Agent;
import my.example.jpa.lab05.Club;
import my.example.jpa.lab05.Footballer;
import my.example.jpa.lab05.Nation;

@Slf4j
public class Lab05Test {

	private EntityManager  em;
	@Before
	public void setUp() throws Exception {
		em = EMF.createLocalEntityManager(); 
	}

	@After
	public void tearDown() {
		em.close();
	}
	
	@Test
	public void testService() throws Exception {
		em.getTransaction().begin();
		 
		Footballer footballer1 =	new Footballer(10,"Messi");
		Footballer footballer2 =	new Footballer(11,"Neymar");
		
		Agent agent	=	new Agent("Wagner Ribeiro");
		
		Club club1		=	new Club("Barcelona");
		Nation nation1	=	new Nation("Argentina");
		Nation nation2	=	new Nation("Brazil");
		
		footballer1.setNation(nation1);
		footballer2.setNation(nation2);
		footballer2.setAgent(agent);
		
		club1.setFootballers(new ArrayList<Footballer>(
			    Arrays.asList(footballer1,footballer2))); 
		
		nation1.setFootballers(new ArrayList<Footballer>(
			    Arrays.asList(footballer1)));
		
		nation2.setFootballers(new ArrayList<Footballer>(
			    Arrays.asList(footballer2)));
		
		club1 = em.merge(club1);
    	em.persist(agent);
    	em.persist(nation1);
    	em.persist(nation2);
    	
    	em.getTransaction().commit();
          
        TypedQuery<Footballer> query = em.createNamedQuery("Footballer.findByNumber", Footballer.class);
               
        query.setParameter("numberId", 10);
		Footballer  footballer3 	= 	query.getSingleResult();
		query.setParameter("numberId", 11);
		Footballer  footballer4 	=	query.getSingleResult();
		
		log.info("find footballer3 : " + footballer3 );
		log.info("find footballer3.nation.name : " + footballer3.getNation().getName() );
		log.info("find footballer4 : " + footballer4 );
		log.info("find footballer4.nation.name : " + footballer4.getNation().getName() );
		log.info("find footballer5.agent.name : " + footballer4.getAgent().getName() );

        TypedQuery<Nation> query2 = em.createNamedQuery("Nation.findByName", Nation.class);
		
		query2.setParameter("name", "Argentina");
		Nation nation3	=	query2.getSingleResult();
		query2.setParameter("name", "Brazil");
		Nation nation4	=	query2.getSingleResult();

		log.info("find nation3 : " + nation3 );
		log.info("find nation4 : " + nation4 );
		
		Club club2		=	em.find(Club.class, club1.getId());
		log.info("find club2 : " + club2 );

		log.info("");
		log.info("");

		TypedQuery<Club> query3 = em.createNamedQuery("Club.findByFootballerName", Club.class);
		query3.setParameter("name", "Messi");
		Club club3	=	query3.getSingleResult();
		
		log.info("club3.name :"+club3.getName());
		
		em.getTransaction().begin();

		Nation nation5	=	new Nation("Uruguay");

		Footballer footballer5 =	new Footballer(9,"Suarez");
		footballer5.setNation(nation5);
		
//		List<Footballer> f2	=	club2.getFootballers();
//		f2.add(footballer5);
//		f2.remove(footballer4);
//		club2.setFootballers(f2);
		
		club2.addFootballer(footballer5);
		club2.removeFootballer(footballer4);
		
		em.merge(club2); 
		em.persist(nation5);
		em.getTransaction().commit();
		
		em.refresh(club2);
		
		Assert.assertEquals(2, club2.getFootballers().size());
	}
	
	public void testService2() throws Exception {
		em.getTransaction().begin();
		
		Footballer footballer7 =	new Footballer(7,"C. Ronaldo");
		Footballer footballer8 =	new Footballer(8,"Gerrard");
		 
		Nation nation7	=	new Nation("Portugal");
		Nation nation8	=	new Nation("England");
		
		footballer7.setNation(nation7);
		footballer8.setNation(nation8);
		
		nation7.setFootballers(new ArrayList<Footballer>(
			    Arrays.asList(footballer7)));
		
    	em.persist(footballer7);
    	em.persist(footballer8);
    	em.persist(nation7);
    	em.persist(nation8);
    	
    	em.getTransaction().commit();
          
        TypedQuery<Footballer> query = em.createNamedQuery("Footballer.findByNumber", Footballer.class);
               
        query.setParameter("numberId", 8);
		Footballer  footballer 	= 	query.getSingleResult();
		
		log.info("find footballer : " + footballer );
//		log.info("find footballer3.nation.name : " + footballer3.getNation().getName() );
//		log.info("find footballer4 : " + footballer4 );
//		log.info("find footballer4.nation.name : " + footballer4.getNation().getName() );
//
        TypedQuery<Nation> query2 = em.createNamedQuery("Nation.findByName", Nation.class);
//		
		query2.setParameter("name", "Portugal");
		Nation nation	=	query2.getSingleResult();
//		query2.setParameter("name", "Brazil");
//		Nation nation4	=	query2.getSingleResult();
//
		log.info("find nation : " + nation );
//		log.info("find nation4 : " + nation4 );
//		
//		Club club2		=	em.find(Club.class, 1);
//		log.info("find club2 : " + club2 );
//
//		log.info("");
//		log.info("");
//
//		em.getTransaction().begin();
//
//		Nation nation5	=	new Nation("Uruguay");
//
//		Footballer footballer5 =	new Footballer(9,"Suarez");
//		footballer5.setNation(nation5);
		
//		List<Footballer> f2	=	club2.getFootballers();
//		f2.add(footballer5);
//		f2.remove(footballer4);
//		club2.setFootballers(f2);
		
//		club2.addFootballer(footballer5);
//		club2.removeFootballer(footballer4);
//		
//		em.merge(club2); 
//		em.persist(nation5);
//		em.getTransaction().commit();
//		
//		em.refresh(club2);
		
		Assert.assertEquals(2, 2);
	}
}
