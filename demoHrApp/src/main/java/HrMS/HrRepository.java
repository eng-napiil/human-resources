package HrMS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrRepository extends JpaRepository<HrModel ,Long> {
    @Query(value = "SELECT * FROM employees WHERE id = ?1", nativeQuery = true)
    List<HrModel> search(@Param("keyword") Long id);
}
