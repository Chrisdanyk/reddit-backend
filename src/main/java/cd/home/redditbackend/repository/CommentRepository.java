package cd.home.redditbackend.repository;

import cd.home.redditbackend.model.Comment;
import cd.home.redditbackend.model.Post;
import cd.home.redditbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}