package shounak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shounak.entity.Policy;

import java.time.LocalDate;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByTitleContainsIgnoreCase(String title);

    List<Policy> findByPriceLessThan(Double price);

    List<Policy> findByPriceLessThanEqual(Double price);

    List<Policy> findByCategoryLikeIgnoreCase(String category);

    List<Policy> findByPublisherContainsIgnoreCase(String publisher);

    List<Policy> findByTitleLikeIgnoreCase(String title);

    List<Policy> findByAuthorId(Long authorId);

    List<Policy> findByBlockedFalse();

    List<Policy> findByPublisherLikeIgnoreCase(String publisher);

    List<Policy> findByPublishedDateAfter(LocalDate publishedDate);

}
