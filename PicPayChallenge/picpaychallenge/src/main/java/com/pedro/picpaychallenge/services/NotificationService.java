package com.pedro.picpaychallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pedro.picpaychallenge.domain.User;
import com.pedro.picpaychallenge.dtos.NotificationDTO;

@Service
public class NotificationService {
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User user, String msg) {
	    try {
	        String url = "https://util.devi.tools/api/v1/notify";
	        String userEmail = user.getEmail();

	        NotificationDTO notificationRequest =
	            new NotificationDTO(userEmail, msg);

	        ResponseEntity<String> response =
	            restTemplate.postForEntity(url, notificationRequest, String.class);

	        if (!response.getStatusCode().is2xxSuccessful()) {
	            System.out.println("Erro no serviço de notificação");
	        }

	    } catch (Exception e) {
	        System.out.println("Serviço de notificação fora do ar, seguindo fluxo...");
	    }
	}

}
