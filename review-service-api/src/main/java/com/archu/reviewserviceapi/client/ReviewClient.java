package com.archu.reviewserviceapi.client;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("review-service")
public interface ReviewClient {

}
