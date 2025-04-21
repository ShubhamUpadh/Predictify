package com.Predictify.www.Repository;

import com.Predictify.www.Model.OpinionPoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PollRepository extends JpaRepository<OpinionPoll, Long> {
    List<OpinionPoll> findByActive(boolean active);
    @Query("SELECT o.active FROM OpinionPoll o WHERE o.id = :id")
    Boolean isPollActive(@Param("id") Long id);

    @Query("SELECT o.expiryTime FROM OpinionPoll o WHERE o.id = :id")
    LocalDateTime expiryTime(@Param("id") Long id);

    @Query("SELECT p FROM OpinionPoll p WHERE p.expiryTime <= :now AND p.expired = false")
    List<OpinionPoll> findPollsToExpire(@Param("now") LocalDateTime now);
}
