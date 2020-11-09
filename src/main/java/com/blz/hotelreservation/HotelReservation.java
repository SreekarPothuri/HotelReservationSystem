package com.blz.hotelreservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotelReservation {

	public static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	public ArrayList<Hotel> getHotel() {
		return hotelList;
	}

	public static void addhotel(String name, int weekdayRoomRate, int weekendRoomRate) {
		Hotel hotels = new Hotel(name, weekdayRoomRate, weekendRoomRate);
		hotelList.add(hotels);
	}

	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static String findCheapestHotel(String startDate, String endDate) {
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate startDateInput = LocalDate.parse(startDate, dateformat);
		LocalDate endDateInput = LocalDate.parse(endDate, dateformat);
		int numOfBookingDays = (int) ChronoUnit.DAYS.between(startDateInput, endDateInput) + 1;
		Map<String, Integer> hotelNameToTotalCostMap = hotelList.stream().collect(Collectors
				.toMap(hotel -> hotel.getHotelName(), hotel -> hotel.getWeekdayRoomRate() * numOfBookingDays));

		String cheapestHotelName = hotelNameToTotalCostMap.keySet().stream()
				.min((hotel1, hotel2) -> hotelNameToTotalCostMap.get(hotel1) - hotelNameToTotalCostMap.get(hotel2))
				.orElse(null);

		String cheapestHotelInfo = cheapestHotelName + " Total Cost: $"
				+ hotelNameToTotalCostMap.get(cheapestHotelName);

		return cheapestHotelInfo;
	}
}