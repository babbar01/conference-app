package com.example.conference.repositories;

import com.example.conference.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session,Long> {


}
