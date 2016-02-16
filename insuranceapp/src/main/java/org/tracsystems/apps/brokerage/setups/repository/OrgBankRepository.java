package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.Bank;
import org.tracsystems.apps.brokerage.setups.vo.BankVO;

public interface OrgBankRepository extends JpaRepository<Bank, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.BankVO(b.bankCode,b.bankName,b.bankShtDesc) from Bank b where b.organization.orgCode =:orgCode and bankName like :bankName")
	Page<BankVO> findOrganizationBanks(@Param("orgCode") Long orgCode,@Param("bankName") String bankName,Pageable pageable);


}
