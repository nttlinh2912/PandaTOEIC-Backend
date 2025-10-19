package com.pandatoeic.PandaToeic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pandatoeic.PandaToeic.entity.Vocabulary;
import com.pandatoeic.PandaToeic.repository.VocabularyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocabularyService {
  
  private final VocabularyRepository vocabularyRepository;

  // get all vocabulary
  public List<Vocabulary> getListVocabulary(){
    return vocabularyRepository.findAll();
  }

  // add vocabulary one word
  public Vocabulary addVocabulary(String word, String definition){
    // Check if the word exists
    if(vocabularyRepository.findByWord(word).isPresent()){
      throw new RuntimeException("You can’t invent that — this word already exists: " +word);
    }

    // add vocabulary
    Vocabulary vocabulary = new Vocabulary();
    vocabulary.setWord(word);
    vocabulary.setDefinition(definition);
    return vocabularyRepository.save(vocabulary);
  }

  //  update vocabulary
  public Vocabulary updateVocabulary(Long id, String word, String definition) {
    Vocabulary vocabulary = vocabularyRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Vocabulary not found with this ID: " + id));
    vocabulary.setWord(word);
    vocabulary.setDefinition(definition);
    return vocabularyRepository.save(vocabulary);
  }

  // delete vocabulary
  public void deleteVocabulary(Long id) {
    if (!vocabularyRepository.existsById(id)) {
      throw new RuntimeException("Vocabulary not found with this ID: " + id);
    }
    vocabularyRepository.deleteById(id);
  }
}
