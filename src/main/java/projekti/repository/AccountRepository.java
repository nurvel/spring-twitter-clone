package projekti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projekti.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByUsername(String username);

	@Query("SELECT a FROM Account a WHERE a.name LIKE %:searchString%")
	List<Account> findWithName(@Param("searchString") String searchString);
}
