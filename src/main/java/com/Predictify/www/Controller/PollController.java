package com.Predictify.www.Controller;

import com.Predictify.www.Model.OpinionPoll;
import com.Predictify.www.Service.PollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {

    @Autowired
    PollService pollService;

    @PostMapping("/add")
    public ResponseEntity<OpinionPoll> createPoll(@Valid @RequestBody OpinionPoll poll) {
        OpinionPoll createdPoll = pollService.createPoll(poll);
        return ResponseEntity.ok(createdPoll);
    }

    @GetMapping("/active")
    public ResponseEntity<List<OpinionPoll>> getActivePolls() {
        List<OpinionPoll> activePolls = pollService.getActivePolls();
        return ResponseEntity.ok(activePolls);
    }

    @GetMapping
    public ResponseEntity<List<OpinionPoll>> getAllPolls() {
        List<OpinionPoll> allPolls = pollService.getAllPolls();
        return ResponseEntity.ok(allPolls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpinionPoll> getPollById(@PathVariable Long id) {
        OpinionPoll poll = pollService.getPollById(id);
        return ResponseEntity.ok(poll);
    }
}



//create a poll
//get active polls
//get a specific poll with id
