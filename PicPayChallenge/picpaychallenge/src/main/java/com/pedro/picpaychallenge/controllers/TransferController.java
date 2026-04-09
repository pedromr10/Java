package com.pedro.picpaychallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.picpaychallenge.dtos.TransferRequestDTO;
import com.pedro.picpaychallenge.services.TransferService;

@RestController
@RequestMapping("/transfer")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@PostMapping
	public ResponseEntity<Void> transfer(@RequestBody TransferRequestDTO request){
		transferService.transfer(request.getPayer(), request.getPayer(), request.getValue());
		return ResponseEntity.ok().build();
	}
}
