package com.blz.hotelreservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HotelReservation {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
		
	public ArrayList<Hotel> getHotel(){
		return hotelList;
	}

	public static void addhotel(String hotel, int price) {
		Hotel hotels = new Hotel(hotel,price);
		hotelList.add(hotels);
	}
	
	public static int countNoOfHotels() {
		return hotelList.size();
	}

	public static void main(String[] args) {
		System.out.println("WELCOME TO HOTEL RESERVATION PROGRAM");
		Hotel lakeWood=new Hotel("Lakewood",110);
		Hotel bridgeWood=new Hotel("Bridgewood",160);
		Hotel ridgeWood=new Hotel("Ridgewood",220);
		hotelList.add(lakeWood);
		hotelList.add(bridgeWood);
		hotelList.add(ridgeWood);
		System.out.println(hotelList);
	}
}