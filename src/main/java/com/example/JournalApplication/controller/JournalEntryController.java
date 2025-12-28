package com.example.JournalApplication.controller;

import com.example.JournalApplication.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping()
    public List<JournalEntry> getAll(){

        return new ArrayList<>(journalEntries.values());

    }
    @PostMapping()
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry findId(@PathVariable("myId") Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteId(@PathVariable("myId") Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateId(@PathVariable("myId") Long myId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(myId, myEntry);
    }

}
