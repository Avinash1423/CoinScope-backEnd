package com.crypto.backend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/backend")
@CrossOrigin(origins = "http://localhost:5173")
public class NewsController {

RestTemplate restTemplate=new RestTemplate();

@Value("${newsApiKey}")
private String apikey;

@GetMapping("/news")
public ResponseEntity<Map<String,Object>> newFetcher(){

    String url="https://api.thenewsapi.net/crypto?apikey="+apikey;

    Map<String,Object> response=restTemplate.getForObject(url,Map.class);


    return ResponseEntity.ok(response);
}



//front end
    //http://localhost:8080/backend/news




}
