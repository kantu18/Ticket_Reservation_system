package com.example.demo.service;

import java.lang.StackWalker.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Collections.Ticket;
import com.example.demo.repository.Ticket_repo;

@Service
public class Ticket_service {

	@Autowired
	private Ticket_repo repo;
	
	public List<Ticket> getallTicket_Details()
	{
		return repo.findAll();
	}
	
	public Ticket saveorCreateTicket(Ticket ticket)
	{
		return repo.save(ticket);
	}
	
	public List<Ticket> findbyAge()
	{
		return repo.findAgeabovecriteria();
	}
	
	public Optional<Ticket> findByticketId(String ticketId)
	{
		return repo.findById(ticketId);
	}
	
	public List<Ticket> findbyAddress()
	{
		return repo.findpassengeratUSAandaboveage();
	}
	
	public Optional<List<Ticket>> findbynames(String name)
	{
		return repo.findByIdNames(name);
	}
	
	public List<Ticket> findTrainbyaddress()
	{
		return repo.findbytrainNameandAddress();
	}
	
	public List<Ticket> findbyPrices()
	{
		return repo.findpricesbyAddress();
	}
	
	public Ticket updateDetails(Ticket ticket) {
	    Optional<Ticket> optionalTicket = repo.findById(ticket.getTicket_id());
	    if (optionalTicket.isPresent()) {
	        Ticket fetchDetails = optionalTicket.get();
	        fetchDetails.setAddress(ticket.getAddress());
	        fetchDetails.setAge(ticket.getAge());
	        fetchDetails.setName(ticket.getName());
	        fetchDetails.setPnr_no(123456);
	        fetchDetails.setPrice(ticket.getPrice());
	        fetchDetails.setStatus(true);
	        fetchDetails.setTrain_name(ticket.getTrain_name());

	        return repo.save(fetchDetails);
	    } else {
	        Ticket defaultTicket = new Ticket();
	        defaultTicket.setTicket_id(ticket.getTicket_id());
	        defaultTicket.setAddress("Contact USA HELPDESK at 911");
	        defaultTicket.setPnr_no(911);
	        defaultTicket.setStatus(false);
	        defaultTicket.setTrain_name("NO TRAINS AVAILABLE");

	        return repo.save(defaultTicket);
	    }
	}

	
	public String deleteTicket_Details(String ticketId)
	{
		repo.deleteById(ticketId);
		return "Successfully Deleted ticket:" +ticketId;
	}
}
