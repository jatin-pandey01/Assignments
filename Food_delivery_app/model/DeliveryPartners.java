package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartners {
	private static List<DeliveryPartner> deliveryPartners;
	static {
		deliveryPartners = new ArrayList<>();
		deliveryPartners.add(new DeliveryPartner("Zomato"));
		deliveryPartners.add(new DeliveryPartner("Swiggy"));
	}
	
	public List<DeliveryPartner> getDeliveryPartners() {
		return deliveryPartners;
	}
	
	public void addDeliveryPartners(DeliveryPartner deliveryPartner) {
		for(DeliveryPartner deliveryPartner1 : deliveryPartners) {
			if(deliveryPartner1.getName().equals(deliveryPartner.getName()))
				return;
		}
		deliveryPartners.add(deliveryPartner);
	}
	
	public void removerDeliveryPartner(String name) {
		if(deliveryPartners.size() == 1) {
			System.out.println("There should be at least two delivery partner.");
			return;
		}
		List<DeliveryPartner> temp = new ArrayList<>();
		for(DeliveryPartner deliveryPartner : deliveryPartners) {
			if(!deliveryPartner.getName().equals(name)) {
				temp.add(deliveryPartner);
			}
		}
		
		if(temp.size() != deliveryPartners.size()) {
			System.out.println("No delivery partner exist.");
			return;
		}
		deliveryPartners = temp;
	}
	
}
