package com.admin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.admin.model.ChequebookRequest;
import com.admin.model.UserDisplay;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "Admin-banking")
public interface AdminServiceProxy {

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForSetUserFeatures")
    @GetMapping("user/{username}/features/{featureId}")
    void setUserFeatures(@PathVariable("username") String username, @PathVariable("featureId") int featureId);

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForGetAllUsers")
    @GetMapping("/user/all")
    List<UserDisplay> getAllUsers();

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForGetAllChequeBookRequests")
    @GetMapping("/chequebook/request/all")
    List<ChequebookRequest> getAllChequeBookRequests();

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForConfirmChequeBookRequest")
    @GetMapping("/user/{accNo}/chequebook/request/confirm")
    void confirmChequeBookRequest(@PathVariable("accNo") long accNo);

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForEnable")
    @GetMapping("/user/{username}/enable")
    void enableUser(@PathVariable("username") String username);

    @Retry(name = "Admin-banking")
    @CircuitBreaker(name = "Admin-banking", fallbackMethod = "fallbackMethodForDisableUser")
    @GetMapping("/user/{username}/disable")
    void disableUser(@PathVariable("username") String username);

    default void fallbackMethodForSetUserFeatures(String username, int featureId, Throwable throwable) {
        // Fallback logic for setUserFeatures
    }

    default List<UserDisplay> fallbackMethodForGetAllUsers(Throwable throwable) {
        // Fallback logic for getAllUsers
        return Collections.emptyList();
    }

    default List<ChequebookRequest> fallbackMethodForGetAllChequeBookRequests(Throwable throwable) {
        // Fallback logic for getAllChequeBookRequests
        return Collections.emptyList();
    }

    default void fallbackMethodForConfirmChequeBookRequest(long accNo, Throwable throwable) {
        // Fallback logic for confirmChequeBookRequest
    }

    default void fallbackMethodForEnable(String username, Throwable throwable) {
        // Fallback logic for enableUser
    }

    default void fallbackMethodForDisableUser(String username, Throwable throwable) {
        // Fallback logic for disableUser
    }
}
