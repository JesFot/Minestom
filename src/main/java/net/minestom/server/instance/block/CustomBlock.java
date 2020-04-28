package net.minestom.server.instance.block;

import net.minestom.server.data.Data;
import net.minestom.server.entity.Player;
import net.minestom.server.instance.Instance;
import net.minestom.server.utils.BlockPosition;
import net.minestom.server.utils.time.UpdateOption;

/**
 * TODO
 * - option to set the global as "global breaking" meaning that multiple players mining the same block will break it faster (accumulation)
 */
public abstract class CustomBlock {

    private short blockId;
    private String identifier;

    public CustomBlock(short blockId, String identifier) {
        this.blockId = blockId;
        this.identifier = identifier;
    }

    public CustomBlock(Block block, String identifier) {
        this(block.getBlockId(), identifier);
    }

    public void update(Instance instance, BlockPosition blockPosition, Data data) {
        throw new UnsupportedOperationException("Update method not overridden");
    }

    public UpdateOption getUpdateOption() {
        return null;
    }

    public abstract void onPlace(Instance instance, BlockPosition blockPosition, Data data);

    public abstract void onDestroy(Instance instance, BlockPosition blockPosition, Data data);

    /**
     * Handles interactions with this block. Can also block normal item use (containers should block when opening the
     * menu, this prevents the player from placing a block when opening it for instance)
     *
     * @param player        the player interacting
     * @param hand          the hand used to interact
     * @param blockPosition the position of this block
     * @param data          the data at this position
     * @return true if this block blocks normal item use, false otherwise
     */
    public abstract boolean onInteract(Player player, Player.Hand hand, BlockPosition blockPosition, Data data);

    /**
     * This id can be serialized in chunk file, meaning no duplicate should exist
     * Changing this value halfway should mean potentially breaking the world
     *
     * @return the custom block id
     */
    public abstract short getCustomBlockId();

    /**
     * Called at digging start to check for custom breaking time
     * Can be set to < 0 to be cancelled, in this case vanilla time will be used
     *
     * @param player the player who is trying to break the block
     * @return the time in ms to break it
     */
    public abstract int getBreakDelay(Player player, BlockPosition position);

    public boolean hasUpdate() {
        UpdateOption updateOption = getUpdateOption();
        if (updateOption == null)
            return false;

        return updateOption.getValue() > 0;
    }

    public short getBlockId() {
        return blockId;
    }

    public String getIdentifier() {
        return identifier;
    }

    /**
     * Initialises data for this block
     *
     * @param blockPosition the position of the targeted block
     * @param data          data given to 'setBlock', can be null
     * @return Data for this block. Can be null, 'data', or a new object
     */
    public Data createData(Instance instance, BlockPosition blockPosition, Data data) {
        return data;
    }
}