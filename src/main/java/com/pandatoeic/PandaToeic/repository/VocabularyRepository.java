package com.pandatoeic.PandaToeic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pandatoeic.PandaToeic.entity.Vocabulary;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long>{
  Optional<Vocabulary> findByWord(String word);

  @Query("SELECT v FROM Vocabulary v ORDER BY v.created_at DESC")
    List<Vocabulary> findAllOrderByCreatedAtDesc();
}
