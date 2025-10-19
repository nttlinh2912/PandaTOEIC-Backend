package com.pandatoeic.PandaToeic.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandatoeic.PandaToeic.entity.Vocabulary;
import com.pandatoeic.PandaToeic.service.VocabularyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vocabulary")
public class VocabularyController {
  
  private final VocabularyService vocabularyService;

  // get all vocabulary
  @GetMapping("/list")
  public ResponseEntity<List<Vocabulary>> getAllListVocabulary(){
    return ResponseEntity.ok(vocabularyService.getListVocabulary());
  }

  // add vocabulary
  @PostMapping("/add")
  public ResponseEntity<?> addVocabulary(@RequestBody Map<String,String> body){
    try {
      Vocabulary add = vocabularyService.addVocabulary(body.get("work"), body.get("definition"));
      return ResponseEntity.ok(add);
    } catch (RuntimeException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  // update vocabulary
  @PutMapping("/update/{id}")
  public ResponseEntity<Vocabulary> updateVocabulary(@PathVariable Long id, @RequestBody Map<String,String> body){
    String work = body.get("work");
    String definition = body.get("definition");
    Vocabulary update = vocabularyService.updateVocabulary(id, work, definition);
    return ResponseEntity.ok(update);
  }

  // delete vocabulary
   @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteVocabulary(@PathVariable Long id){
    vocabularyService.deleteVocabulary(id);
    return ResponseEntity.ok("Deleted successfully!");
  }
}
