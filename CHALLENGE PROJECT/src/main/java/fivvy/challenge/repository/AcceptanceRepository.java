package fivvy.challenge.repository;

import fivvy.challenge.entity.AcceptanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcceptanceRepository extends JpaRepository<AcceptanceEntity, Long> {
    @Query("select a from AcceptanceEntity a where a.id=?1")
    AcceptanceEntity findAcceptanceById(@Param("id") Long id);

    @Query("SELECT a FROM AcceptanceEntity a WHERE a.userId = :userId")
    List<AcceptanceEntity> findAcceptanceByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM AcceptanceEntity a WHERE a.id = :id")
    void deleteById(@Param("id") Long id);
}
