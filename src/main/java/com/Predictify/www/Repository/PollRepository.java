package com.Predictify.www.Repository;

import com.Predictify.www.Model.OpinionPoll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PollRepository extends JpaRepository<OpinionPoll, Long> {
    List<OpinionPoll> findByActive(boolean active);

}
