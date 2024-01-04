package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Collections.Ticket;
import com.example.demo.repository.Ticket_repo;
import com.example.demo.service.Ticket_service;import com.mongodb.internal.operation.AggregateResponseBatchCursor;

@RestController
@RequestMapping("/ticket")
public class Ticket_controller {

	@Autowired
	private Ticket_service service;
	
	@Autowired
	private Ticket_repo repo;
	
	//gives details of all passengers
	@GetMapping("/getall")
	public ResponseEntity<List<Ticket>> findallTicket_details()
	{
		return new ResponseEntity<List<Ticket>>(service.getallTicket_Details(), HttpStatus.ACCEPTED);
	}
	
	//create a new passenger
	@PostMapping("/saveTicket")
	public ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket)
	{
		return new ResponseEntity<Ticket>(service.saveorCreateTicket(ticket), HttpStatus.CREATED);
	}
	
	//search passenger above 40 years
	@GetMapping("/findByage")
	public ResponseEntity<List<Ticket>> findbyAge()
	{
		return new ResponseEntity<List<Ticket>>(service.findbyAge(), HttpStatus.OK);
	}
	
	//search by ticketId
	@GetMapping("/findbyid/{ticketId}")
	public ResponseEntity<?> findbyTicketId(@PathVariable String ticketId)
	{
		Optional<Ticket> checkStatus= service.findByticketId(ticketId);
		if(checkStatus.isPresent())
		{
		return new ResponseEntity<Optional<Ticket>>(service.findByticketId(ticketId), HttpStatus.OK);
		}else {
			return new ResponseEntity<Optional<Ticket>>(HttpStatus.NOT_ACCEPTABLE).ok("Wrong TicketId given or TicketId does not exist");
		}
	}
	
	//search using address and age above 40
	@GetMapping("/findbyAddress")
	public ResponseEntity<List<Ticket>> findbyaddress()
	{
		return new ResponseEntity<List<Ticket>>(service.findbyAddress(), HttpStatus.OK);
	}
	
	//search by names
	@GetMapping("/findbynames/{name}")
	public ResponseEntity<?> findbyNames(@PathVariable String name)
	{
		Optional<List<Ticket>> finddetails= service.findbynames(name);
		if(finddetails.isPresent())
		{
			return new ResponseEntity<Optional<List<Ticket>>>(service.findbynames(name), HttpStatus.OK);
		}else {
			return new ResponseEntity<Optional<List<Ticket>>>(HttpStatus.NOT_ACCEPTABLE).ok("No details available for this passenger");
		}
	}
	
	@GetMapping("/findtrainname")
	public ResponseEntity<List<Ticket>> findTrainnamebyAddress()
	{
		return new ResponseEntity<List<Ticket>>(service.findTrainbyaddress(),HttpStatus.OK);
	}
	
	@GetMapping("/findPricesbyAddress")
	public ResponseEntity<List<Ticket>> findPrices()
	{
		return new ResponseEntity<List<Ticket>>(service.findbyPrices(),HttpStatus.OK);
	}
	
	@PostMapping("/updateDetails")
	public ResponseEntity<Ticket> updateDetails(@RequestBody Ticket ticket)
	{
		return new ResponseEntity<Ticket>(service.updateDetails(ticket),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{ticketid}")
	public String deleteTicket(@PathVariable String ticketid)
	{
		return service.deleteTicket_Details(ticketid);
	}
}
