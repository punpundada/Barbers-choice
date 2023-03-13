package com.spring.practice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.entities.Order_details;
import com.spring.practice.exception.ResourceNotFoundException;
import com.spring.practice.repository.Order_detailsRepository;
import com.spring.practice.responce.Order_DetailsDto;
import com.spring.practice.service.Order_details_Service;
@Service
public class Order_details_Impl implements Order_details_Service {
	
	@Autowired
	private Order_detailsRepository order_detail_repo;
	
	@Autowired
	private ModelMapper modelmapper;
	

	@Override
	public Order_DetailsDto saveOrder_details(Order_DetailsDto order_detailsDto) {
		
		Order_details order_details = this.dtoToOrder_details(order_detailsDto);
		Order_details Order_detailsbrand = this.order_detail_repo.save(order_details);
		return this.Order_detailsToDto(Order_detailsbrand);
		
	}
	
	

	@Override
	public List<Order_DetailsDto> getAllOrder_details() {
		List<Order_details> order_detail = this.order_detail_repo.findAll();
		List<Order_DetailsDto> Order_detailsdto = order_detail.stream().map(Order_det-> this.Order_detailsToDto(Order_det)).collect(Collectors.toList());
		return Order_detailsdto;
		
	
	}

	@Override
	public Order_DetailsDto getOrder_detailsById(int id) {
		
		Order_details order_details =this.order_detail_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand", "id", id));
		return this.Order_detailsToDto(order_details);
		
		
	}

	@Override
	public Order_DetailsDto updateOrder_details(Order_DetailsDto order_detailsDto, int id){
		Order_details existingOrderDetails =  order_detail_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("order_details", "id", id));
		existingOrderDetails.setStatus(order_detailsDto.getStatus());
		Order_details updateOrder_details = this.order_detail_repo.save(existingOrderDetails);
		Order_DetailsDto Order_DetailsDtodto1 = this.Order_detailsToDto(updateOrder_details);
		
		return Order_DetailsDtodto1;
	}

	@Override
	public void deleteOrder_details(int id) {
		Order_details order_details =this.order_detail_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order_details", "id", id));	
		this.order_detail_repo.delete(order_details);
		
		
	}
	
	public Order_details dtoToOrder_details (Order_DetailsDto order_detailsDto) {
		Order_details order_details = this.modelmapper.map(order_detailsDto, Order_details.class);
		return order_details;
	}
	
	
	
	public Order_DetailsDto Order_detailsToDto(Order_details order_details) {
		Order_DetailsDto order_detail_dto =this.modelmapper.map(order_details, Order_DetailsDto.class);
		return order_detail_dto;
	}

}
