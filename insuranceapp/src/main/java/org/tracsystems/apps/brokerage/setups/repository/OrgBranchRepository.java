package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.OrgBranch;
import org.tracsystems.apps.brokerage.setups.model.Organization;
import org.tracsystems.apps.brokerage.setups.vo.OrgBranchVO;

import java.util.List;

public interface OrgBranchRepository extends JpaRepository<OrgBranch, Long> {
	
	@Query("select new org.tracsystems.apps.brokerage.setups.vo.OrgBranchVO(b.obId,b.obName,b.obShtDesc) from OrgBranch b where b.organization.orgCode =:orgCode and obName like :obName")
	Page<OrgBranchVO> findOrganizationBranches(@Param("orgCode") Long orgCode,@Param("obName") String obName,Pageable pageable);

}
