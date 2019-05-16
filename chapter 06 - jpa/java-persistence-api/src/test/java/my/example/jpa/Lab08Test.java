package my.example.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import my.example.jpa.lab06.Movie;
import my.example.jpa.lab06.SuperHero;
import my.example.jpa.lab08.MovieMapping;

@Slf4j
public class Lab08Test {

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

		SuperHero superHero1 =	new SuperHero("Clark","Superman");
		SuperHero superHero2 =	new SuperHero("Bruce","Batman");
		SuperHero superHero3 =	new SuperHero("Diana","Wonder Women");
		 
		Movie movie1	=	new Movie("Man Of Steel");
		Movie movie2	=	new Movie("Batman vs Superman");
		Movie movie3	=	new Movie("Justice League");
		
		movie1.addSuperHero(superHero1);
		
		movie2.addSuperHero(superHero1);
		movie2.addSuperHero(superHero2);
		
		movie3.addSuperHero(superHero1);
		movie3.addSuperHero(superHero2);
		movie3.addSuperHero(superHero3);
		
		
		em.persist(superHero1);
		em.persist(superHero2);
		em.persist(superHero3);

		em.persist(movie1);
		em.persist(movie2);
		em.persist(movie3);
		
		em.getTransaction().commit();
        
		Query query = em.createNativeQuery("Select m.name movieName,h.name superHeroName "
				+ "From movie_superhero mh, movie m , superhero h "
				+ "WHERE mh.movie_id = m.id and mh.superhero_id = h.id "
				+ "order by m.id" ,"NameMapping");
        
		@SuppressWarnings("unchecked")
		List<MovieMapping> result = (List<MovieMapping>)query.getResultList();
				
		for (MovieMapping movieMapping : result) {
			log.info(movieMapping.getMovieName()  + " : " + movieMapping.getSuperHeroName());	
		} 
	}
}
