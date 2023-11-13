package com.picpaysimplificado.services;


import com.picpaysimplificado.dto.NotificationDTO;
import com.picpaysimplificado.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    public static final String ULR_REQUEST = "https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6"
    @Autowired
    public RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(ULR_REQUEST, notificationRequest, String.class);

        if (!(responseEntity.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Error for send notifcation");
            throw new Exception("Service offline.");
        }
    }

}
