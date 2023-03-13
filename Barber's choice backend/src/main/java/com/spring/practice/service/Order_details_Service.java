package com.spring.practice.service;

import java.util.List;


import com.spring.practice.responce.Order_DetailsDto;

public interface Order_details_Service {
	
	Order_DetailsDto saveOrder_details(Order_DetailsDto order_detailsDto);
	List<Order_DetailsDto> getAllOrder_details();
	Order_DetailsDto getOrder_detailsById(int id);
	Order_DetailsDto updateOrder_details(Order_DetailsDto order_detailsDto, int id);
	void deleteOrder_details(int id);
	

}
