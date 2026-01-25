package com.abc.fitness;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FitnessApplicationTests {

	@Test
	void contextLoads() {
	}


    /*
    * If Participation date is not in the Class's availability dates - Throw Business Error: Participation Date not possible
    *
    * (Do not allow same booking more than once)
    * If similar booking exists for the same member Name & Date - Throw Business error: Booking Already exists & Return Existing booking
    *
    *
    * */

}
