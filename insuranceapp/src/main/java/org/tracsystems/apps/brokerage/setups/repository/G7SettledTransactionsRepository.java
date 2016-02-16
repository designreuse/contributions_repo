package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tracsystems.apps.brokerage.setups.model.G7SettledTransactions;

public interface G7SettledTransactionsRepository extends JpaRepository<G7SettledTransactions, Long> {

}
