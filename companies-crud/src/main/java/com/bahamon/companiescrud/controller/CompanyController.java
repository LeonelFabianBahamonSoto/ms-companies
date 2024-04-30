package com.bahamon.companiescrud.controller;

import com.bahamon.companiescrud.entity.Company;
import com.bahamon.companiescrud.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping(path = "company")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping( path = "/getCompany/{name}")
    public ResponseEntity<Company> getCompany( @PathVariable String name ) {
        Company company = companyService.readByName( name );

        return new ResponseEntity<>( company, HttpStatus.OK );
    }

    @PostMapping( path = "/createCompany" )
    public ResponseEntity<Company> postCompany( @RequestBody Company company ) {
        Company companyCreated = companyService.createCompany( company );

        return ResponseEntity.status( HttpStatus.CREATED ).body( companyCreated );
    }

    @PutMapping( path = "/updateCompany/{name}")
    public ResponseEntity<Company> putCompany( @RequestBody Company company, @PathVariable String name ) {
        Company companyUpdated = companyService.updateCompany( company, name );

        return ResponseEntity.status( HttpStatus.OK ).body( companyUpdated );
    }

    @DeleteMapping( path = "/delete/{name}" )
    public ResponseEntity<?> deleteCompany( @PathVariable String name ) {
        companyService.deleteCompany( name );

        return ResponseEntity.noContent().build();
    }
}
