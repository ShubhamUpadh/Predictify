package com.Predictify.www.Repository;

import com.Predictify.www.Model.OpinionPoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PollRepository extends JpaRepository<OpinionPoll, Long> {
    List<OpinionPoll> findByActive(boolean active);
    @Query("SELECT o.active FROM OpinionPoll o WHERE o.id = :id")
    Boolean isPollActive(@Param("id") Long id);

}
