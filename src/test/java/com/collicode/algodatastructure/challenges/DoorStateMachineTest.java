package com.collicode.algodatastructure.challenges;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DoorStateMachineTest {

    @Test
    void testInitialState() {
        DoorStateMachine door = new DoorStateMachine();
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testOpenStopToOpen() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "stop");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }

    @Test
    void testOpenStopCloseStopToClosed() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "stop", "close", "stop");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testLockUnlockFlow() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("lock", "unlock");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testInvalidActionIgnored() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "jump", "stop");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }

    @Test
    void testInterruptedOpening() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "close", "stop");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testInterruptedClosing() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "stop", "close", "open", "stop");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }

    @Test
    void testDoubleLockAttempt() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("lock", "lock", "unlock");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testInvalidUnlockFromWrongState() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("unlock");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testRapidMixedSequence() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "close", "open", "stop", "close", "stop", "lock");
        assertEquals(DoorStateMachine.State.LOCKED, door.getCurrentState());
    }

    @Test
    void testStopWithoutMotion() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("stop");
        assertEquals(DoorStateMachine.State.CLOSED, door.getCurrentState());
    }

    @Test
    void testPartialTransitionChain() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "close", "open");
        assertEquals(DoorStateMachine.State.OPENING, door.getCurrentState());
    }

    @Test
    void testReentrantStates() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "stop", "open", "stop");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }

    @Test
    void testComplexLongChain() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("open", "stop", "close", "open", "close", "stop", "lock", "unlock", "open", "stop");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }

    @Test
    void testCaseInsensitiveCommands() {
        DoorStateMachine door = new DoorStateMachine();
        door.handleActions("OPEN", "STOP");
        assertEquals(DoorStateMachine.State.OPEN, door.getCurrentState());
    }
}
