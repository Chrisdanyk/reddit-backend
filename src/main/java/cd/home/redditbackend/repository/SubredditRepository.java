package cd.home.redditbackend.repository;

import cd.home.redditbackend.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
}