package com.louis.mango.zuul.fallbackprovider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackProvider implements FallbackProvider{

	public String getRoute() {
		return "mango-consumer";
	}

	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		System.out.println("route:" + route);
		System.out.println("exception" + cause.getMessage());
		
		return new ClientHttpResponse() {

			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("sorry,the service is unavailable now".getBytes());
			}

			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}

			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}

			public int getRawStatusCode() throws IOException {
				return 200;
			}

			public String getStatusText() throws IOException {
				return "OK";
			}

			public void close() {}
			
		};
	}

}
