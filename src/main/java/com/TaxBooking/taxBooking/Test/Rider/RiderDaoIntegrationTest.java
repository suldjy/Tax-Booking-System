package com.TaxBooking.taxBooking.Test.Rider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.TaxBooking.taxBooking.Domain.Rider;
import com.TaxBooking.taxBooking.Service.RiderSerivce;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RiderDaoIntegrationTest {

	//@Autowired
    //private TestEntityManager entityManager;
	
	@Autowired
	private RiderSerivce riderSerivce;
	
	@Test
	public void whenFindByName_thenReturnRider() {
	    // given
	    Rider rider = new Rider();
	    rider.setName("RIDER 1");
	  //  entityManager.persist(rider);
	   // entityManager.flush();
	 
	    // when
	    Rider r = riderSerivce.findByName(rider.getName());
	 
	    // then
	    assertThat(r.getName())
	      .isEqualTo(rider.getName());
	}
 
 
	
}
