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
  public List<Vocabulary> getAllVocabularies() {
    return vocabularyService.getAllVocabularies();
  }

  // add vocabulary
  @PostMapping("/add")
  public ResponseEntity<?> addVocabulary(@RequestBody Vocabulary vocabulary) {
    try {
      Vocabulary saved = vocabularyService.addVocabulary(vocabulary);
      return ResponseEntity.ok(saved);
    } catch (RuntimeException e) {

      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {

      return ResponseEntity.internalServerError().body("Internal server error: " + e.getMessage());
    }
  }

  // update vocabulary
  @PutMapping("/update/{id}")
  public ResponseEntity<Vocabulary> updateVocabulary(@PathVariable Long id, @RequestBody Map<String, String> body) {
    String word = body.get("word");
    String definition = body.get("definition");
    Vocabulary update = vocabularyService.updateVocabulary(id, word, definition);
    return ResponseEntity.ok(update);
  }

  // delete vocabulary
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteVocabulary(@PathVariable Long id) {
    vocabularyService.deleteVocabulary(id);
    return ResponseEntity.ok("Deleted successfully!");
  }
}
