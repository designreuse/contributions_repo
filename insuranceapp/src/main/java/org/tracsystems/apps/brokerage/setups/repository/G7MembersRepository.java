package org.tracsystems.apps.brokerage.setups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tracsystems.apps.brokerage.setups.model.G7Members;
import org.tracsystems.apps.brokerage.setups.vo.G7MembersVO;

import java.lang.Long;

public interface G7MembersRepository extends JpaRepository<G7Members, Long> {

	@Query("select new org.tracsystems.apps.brokerage.setups.vo.G7MembersVO("
		+ "b.gmemCode,"
		+ "b.gmemOtherNames,"
		+ "b.gmemSurname,"
		+ "b.gmemOtherNames || ' ' ||b.gmemSurname,"
		+ "b.gmemTel,"
		+ "b.gmemEmail,"
		+ "b.gmemRegisterDate,"
		+ "b.gmemActive,"
		+ "CASE WHEN b.gmemActive = 'Y' THEN 'YES' ELSE 'NO' END)"
		+ "from G7Members b where b.gmemCode =:memId")
	G7MembersVO findG7MemberDetails(@Param("memId") Long memId);

}
