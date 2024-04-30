package com.bahamon.companiescrud.service;

import com.bahamon.companiescrud.entity.Category;
import com.bahamon.companiescrud.entity.Company;
import com.bahamon.companiescrud.repository.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public Company readByName(String name) {

        return this.companyRepository.findByName( name )
                .orElseThrow( () -> new NoSuchElementException(" -----> Company not found") );
    }

    @Override
    public Company createCompany(Company company) {
        company.getWebSites().forEach( webSite -> {
            if ( Objects.isNull( webSite.getCategory() ) ) {
                webSite.setCategory( Category.NONE );
            }
        });

        return companyRepository.save( company );
    }

    @Override
    public Company updateCompany( Company company, String name ) {

        Company existingCompany = this.companyRepository.findByName( name )
                .orElseThrow(() -> new RuntimeException("La compania no existe") );

        existingCompany.setName(company.getName() );
        existingCompany.setFounder(company.getFounder());
        existingCompany.setLogo(company.getLogo());
        existingCompany.setFoundationDate(company.getFoundationDate());
//        existingCompany.setWebSites( company.getWebSites() );

        return this.companyRepository.save( existingCompany );
    }

    @Override
    public void deleteCompany( String name ) {
        var company = this.companyRepository.findByName( name )
                .orElseThrow(() -> new RuntimeException("La compania no existe") );

        this.companyRepository.delete( company );
    }
}
