package com.example.conference.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "sessions")
public class Session {

    public Session(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @ManyToMany
    @JoinTable(
            name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;


    @Column(name = "session_name")
    private String sessionName;

    @Column(name = "session_description")
    private String sessionDescription;

    @Column(name = "session_length")
    private Integer sessionLength;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    @JsonProperty("session_id")
    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    @JsonProperty("session_name")
    public String getSessionName() {
        return sessionName;
    }

    @JsonProperty("session_name")
    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @JsonProperty("session_description")
    public String getSessionDescription() {
        return sessionDescription;
    }


    @JsonProperty("session_description")
    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    @JsonProperty("session_length")
    public Integer getSessionLength() {
        return sessionLength;
    }

    @JsonProperty("session_length")
    public void setSessionLength(Integer sessionLength) {
        this.sessionLength = sessionLength;
    }




}
