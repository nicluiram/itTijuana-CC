package com.example.aws;

import com.example.aws.model.Request;
import com.example.aws.model.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class DemoLambdaApplication extends SpringBootRequestHandler<Request, ResponseEntity<Response>> {

	public static void main(String[] args) {
		SpringApplication.run(DemoLambdaApplication.class, args);
	}

}
