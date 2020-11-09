package com.blz.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import com.blz.hotelreservation.*;

public class HotelReservationTest {

	@Test
	public void givendetailsOf3Hotels_WhenAddedToHotelList_SizeOfListIs3(){
		
		HotelReservation.addhotel("Lakewood",110);
		HotelReservation.addhotel("Bridgewood",160);
		HotelReservation.addhotel("Ridgewood",220);
		Assert.assertEquals(6, HotelReservation.countNoOfHotels());
	}
	
	@Test
	public void givenDetailsOf3Hotels_InAGivenDataRage_shouldReturnCheapesthotel() {
		
		HotelReservation.addhotel("Lakewood",110);
		HotelReservation.addhotel("Bridgewood",160);
		HotelReservation.addhotel("Ridgewood",220);
		String cheapestHotelInfo = HotelReservation.findCheapestHotel("10 Sep 2020","11 Sep 2020");
		Assert.assertEquals("Lakewood Total Cost: $220",cheapestHotelInfo);
	}
}
