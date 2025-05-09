package com.Predictify.www.Service;

import com.Predictify.www.Model.OpinionPoll;
import com.Predictify.www.Repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PollService {
    @Autowired
    PollRepository pollRepository;
    @Autowired
    ExpirePollService expirePollService;

    public OpinionPoll createPoll(OpinionPoll poll) {
        poll.setCreatedAt(LocalDateTime.now()); // Set creation time
        poll.setActive(true); // Default to active
        poll.setTransactionSettled(false); // Default to unsettled transactions

        return pollRepository.save(poll);
    }

    public List<OpinionPoll> getActivePolls() {
        return pollRepository.findByActive(true);
    }

    public OpinionPoll getPollById(Long id) {
        return pollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poll not found with ID: " + id));
    }

    public List<OpinionPoll> getAllPolls() {
        return pollRepository.findAll();
    }

    @Scheduled(fixedRate = 300000)
    public void runExpiryJob(){
        expirePollService.expirePolls();
    }


}
