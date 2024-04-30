package com.bahamon.companiescrud.service;

import com.bahamon.companiescrud.entity.Company;

public interface CompanyService {
    Company readByName( String name );

    Company createCompany( Company company );

    Company updateCompany( Company company, String name );

    void deleteCompany( String name );
}
