package net.minestom.server.instance.block.states;
import net.minestom.server.instance.block.BlockAlternative;
import static net.minestom.server.instance.block.Block.*;
/**
 * Completely internal. DO NOT USE. IF YOU ARE A USER AND FACE A PROBLEM WHILE USING THIS CODE, THAT'S ON YOU.
 */
@Deprecated(forRemoval = false, since = "forever")
public class WarpedStem {
	public static void initStates() {
		WARPED_STEM.addBlockAlternative(new BlockAlternative((short) 14958, "axis=x"));
		WARPED_STEM.addBlockAlternative(new BlockAlternative((short) 14959, "axis=y"));
		WARPED_STEM.addBlockAlternative(new BlockAlternative((short) 14960, "axis=z"));
	}
}
