package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tracsystems.apps.brokerage.setups.model.G7Members;

public interface G7MembersRepository extends JpaRepository<G7Members, Long> {

}
