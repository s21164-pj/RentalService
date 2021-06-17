package pl.pjatk.RentalService.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.ErrorHandlers.RestTemplateResponseErrorHandler;
import pl.pjatk.RentalService.model.Movie;

@Service
public class MovieService {

    private RestTemplate restTemplate;

    public MovieService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }


    String baseUrl = "http://localhost:8080/movies/";

    public Movie getById(Long id) {

        return restTemplate.getForObject(baseUrl + id, Movie.class);
    }
}
