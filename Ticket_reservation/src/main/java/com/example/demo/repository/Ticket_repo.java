package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Collections.Ticket;

@Repository
public interface Ticket_repo extends MongoRepository<Ticket, String>{

	
	@Query(value = "{'age':{'$gt':40}}")
	public List<Ticket> findAgeabovecriteria();
		
	@Query(value = "{'$and':[{'age':{'$gte':40}},{'address':'USA'}]}")
	public List<Ticket> findpassengeratUSAandaboveage();
	
	@Query(value = "{ '$and':[{'train_name':'Duronto'},{'address':'USA'}]}")
	public List<Ticket> findbytrainNameandAddress();
	
	@Query(value = "{'$and':[{'address':'USA'},{'price':{'$gt':1000}}]}")
	public List<Ticket> findpricesbyAddress();

	@Query(value= "{name:?0}")
	public Optional<List<Ticket>> findByIdNames(String name);
}
