package my.example.dao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProgrammerJdbcImplTest.class, ProgrammerJpaImplTest.class })
public class AllDaoTests {

}
