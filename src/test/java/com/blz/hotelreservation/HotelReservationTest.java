package com.blz.hotelreservation;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.blz.hotelreservation.*;

public class HotelReservationTest {
	
	private static HotelReservation obj;

	@BeforeClass
	public static void createHotelReservationSystemObj() {
		obj = new HotelReservation();
	}

	@Test
	public void addHotelDetailsInHotelReservationSystem() throws ParseException {
		obj.addRatesForAllDays();
	}
	
	@Test
	public void givenHotelsFindTheCheapestOne() throws ParseException {
		Object[] resultHotelName = obj.findCheapestHotel("11Sep2020", "12Sep2020").toArray();
		Object[] expectedHotelName = { "Lakewood", "Bridgewood" };
		Assert.assertArrayEquals(expectedHotelName, resultHotelName);
	}
}

