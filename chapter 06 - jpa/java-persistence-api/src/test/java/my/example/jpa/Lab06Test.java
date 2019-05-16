package my.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab06.Movie;
import my.example.jpa.lab06.SuperHero;

@Slf4j
public class Lab06Test {

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

		SuperHero superHero1 =	new SuperHero("Steve","Captain America");
		SuperHero superHero2 =	new SuperHero("Tony","Iron Man");
		SuperHero superHero3 =	new SuperHero("Peter","Spider Man");
		 
		Movie movie1	=	new Movie("Captain America : First Avenger");
		Movie movie2	=	new Movie("Captain America : The Winter Soldier");
		Movie movie3	=	new Movie("Captain America : Civil War");
		Movie movie4	=	new Movie("Spiderman : Homecoming");
		
		movie1.addSuperHero(superHero1);
		
		movie2.addSuperHero(superHero1);
		
		movie3.addSuperHero(superHero1);
		movie3.addSuperHero(superHero2);
		movie3.addSuperHero(superHero3);
		
		movie4.addSuperHero(superHero2);
		movie4.addSuperHero(superHero3);
		
		em.persist(superHero1);
		em.persist(superHero2);
		em.persist(superHero3);

		em.persist(movie1);
		em.persist(movie2);
		em.persist(movie3);
		em.persist(movie4);
		
		em.getTransaction().commit();
         
        TypedQuery<SuperHero> query = em.createNamedQuery("SuperHero.findByName", SuperHero.class);
        
        query.setParameter("name", "Steve");
        SuperHero  steve 	= 	query.getSingleResult();
		query.setParameter("name", "Tony");
		SuperHero  tony 	=	query.getSingleResult();
		query.setParameter("name", "Peter");
		SuperHero  peter 	=	query.getSingleResult();
		
		log.info("find Steve's movies : " + steve +" "+ steve.getMovies() );
		log.info("find Tony's movies : " + tony +" "+ tony.getMovies() );
		log.info("find Peter's movies : " + peter +" "+ peter.getMovies() );
		
		Movie a = em.find(Movie.class, 1);
		Movie b = em.find(Movie.class, 2);
		Movie c = em.find(Movie.class, 3);
		Movie d = em.find(Movie.class, 4);
		
		log.info("find a : " + a );
		log.info("find b : " + b );
		log.info("find c : " + c );
		log.info("find d : " + d );

		TypedQuery<Movie> query2 = em.createNamedQuery("Movie.findBySuperHero", Movie.class);
        
        query2.setParameter("name", "Steve");
        
        List<Movie> movies	=	query2.getResultList();
        log.info("find Steve's : " + movies );
		
        Assert.assertEquals(3,movies.size());
		
	}
}
