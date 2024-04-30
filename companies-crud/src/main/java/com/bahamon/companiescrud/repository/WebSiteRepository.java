package com.bahamon.companiescrud.repository;

import com.bahamon.companiescrud.entity.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebSiteRepository extends JpaRepository<WebSite, Long> {
}
