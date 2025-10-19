package com.pandatoeic.PandaToeic.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vocabulary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String word;

  String phonetic;

  @Enumerated(EnumType.STRING)
  Level level;
  String Topic;
  
  @ElementCollection(targetClass = PartOfSpeech.class)
  @Enumerated(EnumType.STRING)
  List<PartOfSpeech> partOfSpeech;

  String definition;
  String VN_definition;

  String definition_examples;

  String image_url;
  String difficulty_score;
  LocalDateTime created_at;
  LocalDateTime updated_at;

}
