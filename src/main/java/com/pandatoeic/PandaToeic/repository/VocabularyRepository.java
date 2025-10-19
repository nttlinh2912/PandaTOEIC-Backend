package com.pandatoeic.PandaToeic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pandatoeic.PandaToeic.entity.Vocabulary;

@Repository
public interface VocabularyRepository extends JpaRepository<Vocabulary, Long>{
  Optional<Vocabulary> findByWork(String work);
}
