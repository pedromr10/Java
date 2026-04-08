package com.pedro.picpaychallenge.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public boolean authorize() {
	    String url = "https://util.devi.tools/api/v2/authorize";

	    try {
	    	//map.class -> converte o json em map
	        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
	        
	        Map body = response.getBody();

	        Map data = (Map) body.get("data");

	        Boolean authorized = (Boolean) data.get("authorization");

	        return Boolean.TRUE.equals(authorized);

	    } catch (Exception e) {
	        return false;
	    }
	}

}
