package com.semicolon.africa.electionManagementSystem.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoterRegistrationResponse {
    private Long voterId;
    private String message;
}
