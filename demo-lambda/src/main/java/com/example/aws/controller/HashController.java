package com.example.aws.controller;



import com.amazonaws.services.lambda.runtime.Context;
import com.example.aws.model.Request;
import com.example.aws.model.Response;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.aws.service.HashService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import java.security.NoSuchAlgorithmException;
import static com.example.aws.Constants.*;


public class HashController implements RequestHandler<Request, ResponseEntity<Response>> {

    private final HashService hashService;

    public HashController(HashService hashService) {
        this.hashService = hashService;
    }

    @Override
    @PostMapping("/hash")
    public ResponseEntity<Response> handleRequest(Request request, Context context) {

        Response response = new Response();
        if (request.getInput().length() < 8) {
            response.setResponse(INVALID_LENGTH_MESSAGE);
            return new ResponseEntity<>( response,HttpStatus.NOT_ACCEPTABLE);
        } else if (!request.getInput().matches(".*\\d.*")) {
            response.setResponse(INVALID_REGEX_INPUT_MESSAGE);
            return new ResponseEntity<>( response,HttpStatus.NOT_ACCEPTABLE);
        } else if (!request.getInput().matches(".*[!@#$%^&*()].*")) {
            response.setResponse( INVALID_CONTENT_MESSAGE);
            return new ResponseEntity<>( response, HttpStatus.NOT_ACCEPTABLE);
        } else {
            try {
                String hash = hashService.calculateSHA256(request.getInput());
                response.setResponse(hash);
            } catch (NoSuchAlgorithmException e) {
                response.setResponse(INVALID_CONTENT_MESSAGE);
                return new ResponseEntity<>( response,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>( response,HttpStatus.OK);
    }
}
