package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tracsystems.apps.brokerage.setups.model.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
