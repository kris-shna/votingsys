package com.voting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VotingEligibilitySystemTest {

    @Test
    void testEligibleVoter() {
        Voter voter = new Voter(
                "Krishna",
                20,
                "Indian",
                "V001",
                true
        );

        assertTrue(voter.isEligible());
    }

    @Test
    void testUnderageVoter() {
        Voter voter = new Voter(
                "Rahul",
                16,
                "Indian",
                "V002",
                true
        );

        assertFalse(voter.isEligible());
    }

    @Test
    void testNonIndianCitizen() {
        Voter voter = new Voter(
                "John",
                25,
                "American",
                "V003",
                true
        );

        assertFalse(voter.isEligible());
    }

    @Test
    void testInvalidVoterId() {
        Voter voter = new Voter(
                "Anu",
                25,
                "Indian",
                "V004",
                false
        );

        assertFalse(voter.isEligible());
    }
}