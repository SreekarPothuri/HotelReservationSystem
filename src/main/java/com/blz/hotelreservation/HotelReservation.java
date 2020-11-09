package com.blz.hotelreservation;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public static LocalDate convertStringToDate(String dateString) {
		LocalDate date = null;
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("ddMMMyyyy");
		try {
			date = LocalDate.parse(dateString, dateTimeFormat);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public static ArrayList<String> findCheapestHotel(String startDate, String endDate) {
		LocalDate startDateInput = convertStringToDate(startDate);
		LocalDate endDateInput = convertStringToDate(endDate);
		
		hotelList.add(new Hotel("Lakewood", 110, 90));
		hotelList.add(new Hotel("Bridgewood", 150, 50));
		hotelList.add(new Hotel("Ridgewood", 220, 150));
		ArrayList<String> cheapestHotelNameList = new ArrayList<>();
		
		int minRate = Integer.MAX_VALUE;
		for (Hotel hotelDetail : hotelList) {
			LocalDate startDay = startDateInput;
			LocalDate endDay = endDateInput.plusDays(1);
			int hotelRent = 0;
			while (!(startDay.equals(endDay))) {
				int day = startDay.getDayOfWeek().getValue();
				if (day == 6 || day == 7) {
					hotelRent = hotelRent + hotelDetail.getWeekendRoomRate();
				} else {
					hotelRent = hotelRent + hotelDetail.getWeekdayRoomRate();
				}
				startDay = startDay.plusDays(1);
			}
			if (hotelRent <= minRate) {
				minRate = hotelRent;
				cheapestHotelNameList.add(hotelDetail.getHotelName());
			}
		}
		return cheapestHotelNameList;
	}
}