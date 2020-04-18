package com.gbet.licensingservice.controller;


import com.gbet.licensingservice.clients.ServiceClients;
import com.gbet.licensingservice.model.License;
import com.gbet.licensingservice.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicensingServiceController {

    @Autowired
    private ServiceClients.OrganizationClient organizationClient;

    @GetMapping(value = "/{licenseId}")
    public License getLicense(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId){
        Organization organization = organizationClient.getOrganization("id");

        License license = new License();
        license.setLicenseId(licenseId);
        license.setOrganizationId(organization.getId());
        return license;
    }

}
