package com.example.demo.Collections;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Ticket_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

	@Id
	private String ticket_id;
	private double price;
	private String address;
	private String name;
	private int age;
	private boolean status;
	private long pnr_no;
	private String train_name;
	
}
