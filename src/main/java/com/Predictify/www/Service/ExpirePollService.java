package com.Predictify.www.Service;


import com.Predictify.www.Model.OpinionPoll;
import com.Predictify.www.Repository.PollRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpirePollService {

    PollRepository pollRepository;

    public ExpirePollService(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }

    @Transactional
    public void expirePolls(){
        LocalDateTime now = LocalDateTime.now();
        List<OpinionPoll> pollsToExpire = pollRepository.findPollsToExpire(now);
        for (OpinionPoll poll : pollsToExpire){
            poll.setActive(false);
            pollRepository.save(poll);
        }
    }
}
