package projekti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projekti.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
