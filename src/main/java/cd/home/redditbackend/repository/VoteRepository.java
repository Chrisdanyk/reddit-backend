package cd.home.redditbackend.repository;

import cd.home.redditbackend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
}