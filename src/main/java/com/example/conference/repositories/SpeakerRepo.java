package com.example.conference.repositories;

import com.example.conference.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepo extends JpaRepository<Speaker,Long> {
}
