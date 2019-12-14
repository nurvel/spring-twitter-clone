package projekti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projekti.entity.Follower;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {


}
