package org.github.playerautoteleport.autoteleport;

public class AutoTeleportSetup {

    private int blocksNorth, blocksWest, blocksSouth, blocksEast;

    public void reset() {
        blocksNorth = 0;
        blocksWest = 0;
        blocksSouth = 0;
        blocksEast = 0;
    }

    public void addBlockNorth() {
        blocksNorth++;
    }

    public void addBlockWest() {
        blocksWest++;
    }

    public void addBlockSouth() {
        blocksSouth++;
    }

    public void addBlockEast() {
        blocksEast++;
    }

    public void removeBlockNorth() {
        blocksNorth--;
    }

    public void removeBlockWest() {
        blocksWest--;
    }

    public void removeBlockSouth() {
        blocksSouth--;
    }

    public void removeBlockEast() {
        blocksEast--;
    }

    public int getBlocksNorth() {
        return blocksNorth;
    }

    public int getBlocksWest() {
        return blocksWest;
    }

    public int getBlocksSouth() {
        return blocksSouth;
    }

    public int getBlocksEast() {
        return blocksEast;
    }
}
