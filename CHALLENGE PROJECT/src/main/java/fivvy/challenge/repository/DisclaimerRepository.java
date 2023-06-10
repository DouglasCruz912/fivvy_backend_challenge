package fivvy.challenge.repository;

import fivvy.challenge.entity.DisclaimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DisclaimerRepository extends JpaRepository<DisclaimerEntity, Long> {

    @Query("select d from DisclaimerEntity d where d.id=?1")
    DisclaimerEntity findDisclaimerById(@Param("id") Long id);

    @Query("SELECT d FROM DisclaimerEntity d WHERE d.text = :text")
    List<DisclaimerEntity> findDisclaimerByText(@Param("text") String text);

    @Modifying
    @Query("DELETE FROM DisclaimerEntity d WHERE d.id = :id")
    void deleteById(@Param("id") Long id);
}
