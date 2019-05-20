package com.tools.mysql2mongodb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cms_program_bitrate")
public class ProgramUrl implements Serializable {
    @Id
    @Column(name = "PROGRAM_RATE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PROGRAM_RATE_ID;

    @Column(name = "PROGRAM_ID")
    private  Long programId;
    @Column(name = "play_url")
    private String playUrl;

    public Long getPROGRAM_RATE_ID() {
        return PROGRAM_RATE_ID;
    }

    public void setPROGRAM_RATE_ID(Long PROGRAM_RATE_ID) {
        this.PROGRAM_RATE_ID = PROGRAM_RATE_ID;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }
}
