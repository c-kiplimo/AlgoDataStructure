package com.collicode.algodatastructure.challenges;


public class DoorStateMachine {

    private State currentState = State.CLOSED;

    public State getCurrentState() {
        return currentState;
    }

    /**
     * Process a single door action (open, close, lock, unlock, stop)
     */
    public void handleAction(String action) {
        if (action == null) return;

        String act = action.trim().toLowerCase();
        switch (currentState) {
            case CLOSED -> {
                if (act.equals("open")) currentState = State.OPENING;
                else if (act.equals("lock")) currentState = State.LOCKED;
            }
            case LOCKED -> {
                if (act.equals("unlock")) currentState = State.CLOSED;
            }
            case OPEN -> {
                if (act.equals("close")) currentState = State.CLOSING;
            }
            case OPENING -> {
                if (act.equals("stop")) currentState = State.OPEN;
                else if (act.equals("close")) currentState = State.CLOSING;
            }
            case CLOSING -> {
                if (act.equals("stop")) currentState = State.CLOSED;
                else if (act.equals("open")) currentState = State.OPENING;
            }
            default -> {
                // No change for invalid actions
            }
        }
    }

    /**
     * Utility to process multiple actions in sequence.
     */
    public void handleActions(String... actions) {
        if (actions == null) return;
        for (String action : actions) {
            handleAction(action);
        }
    }

    public enum State {
        CLOSED, LOCKED, OPENING, OPEN, CLOSING
    }
}

