package com.gbet.licensingservice.clients;


import com.gbet.licensingservice.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public class ServiceClients {

    @FeignClient("organizationservice")
    public interface OrganizationClient {
        @GetMapping(value = "/v1/organizations/{organizationId}", consumes = "application/json")
        Organization getOrganization(@PathVariable("organizationId") String organizationId);

    }
}
