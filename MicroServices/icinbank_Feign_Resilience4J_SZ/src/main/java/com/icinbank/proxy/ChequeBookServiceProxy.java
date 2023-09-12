package com.icinbank.proxy;

import com.icinbank.model.ChequebookRequest;
import com.icinbank.response.ChequeResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "online-banking")
public interface ChequeBookServiceProxy {

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForCreateRequest")
    @PostMapping("/cheque/request")
    ChequeResponse createRequest(@RequestBody ChequebookRequest chequebook);

    @Retry(name = "online-banking")
    @CircuitBreaker(name = "online-banking", fallbackMethod = "fallbackMethodForGetRequests")
    @GetMapping("/cheque/getbyAccount/{account}")
    List<ChequebookRequest> getRequests(@RequestParam("account") long account);

    default ChequeResponse fallbackMethodForCreateRequest(ChequebookRequest chequebook, Throwable throwable) {
        // Handle the fallback logic here for createRequest
        ChequeResponse response = new ChequeResponse();
        response.setStatus(false);
        response.setResponseMessage("Fallback: Request creation failed");
        return response;
    }

    default List<ChequebookRequest> fallbackMethodForGetRequests(long account, Throwable throwable) {
        // Handle the fallback logic here for getRequests
        return Collections.emptyList();
    }
}
