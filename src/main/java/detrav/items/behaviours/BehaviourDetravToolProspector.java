package detrav.items.behaviours;

import static gregtech.api.enums.Mods.VisualProspecting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SplittableRandom;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fluids.FluidStack;

import com.gtnewhorizon.gtnhlib.chat.customcomponents.ChatComponentItemName;
import com.sinthoras.visualprospecting.VisualProspecting_API;

import detrav.DetravScannerMod;
import detrav.items.DetravMetaGeneratedTool01;
import gregtech.api.items.MetaBaseItem;
import gregtech.api.objects.ItemData;
import gregtech.api.util.GTOreDictUnificator;
import gregtech.api.util.GTUtility;
import gregtech.common.UndergroundOil;
import gregtech.common.items.behaviors.BehaviourNone;
import gregtech.common.ores.OreInfo;
import gregtech.common.ores.OreManager;
import gregtech.common.pollution.Pollution;

/**
 * Created by wital_000 on 19.03.2016.
 */
public class BehaviourDetravToolProspector extends BehaviourNone {

    static final int[] DISTANCEINTS = new int[] { 0, 4, 25, 64 };

    record OresKey(String name, int dist) {

        public IChatComponent getChatComp() {
            // FIXME: localize name
            return new ChatComponentText(name)
                .appendSibling(new ChatComponentTranslation("detrav.scanner.distance.texts." + dist));
        }
    }

    HashMap<OresKey, Integer> ores;
    int badluck;

    protected final int mCosts;

    static final String CHAT_MSG_SEPARATOR = EnumChatFormatting.STRIKETHROUGH + "--------------------";

    public BehaviourDetravToolProspector(int aCosts) {
        mCosts = aCosts;
    }

    @Override
    public boolean onItemUse(MetaBaseItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX, int aY,
        int aZ, int aSide, float hitX, float hitY, float hitZ) {

        SplittableRandom aRandom = new SplittableRandom();
        int chance = Math.min(((1 + aStack.getItemDamage()) * 8), 100);

        if (aWorld.isRemote) return false;

        Block block = aWorld.getBlock(aX, aY, aZ);
        int meta = aWorld.getBlockMetadata(aX, aY, aZ);

        if (block == Blocks.bedrock) {
            if (!aWorld.isRemote && aRandom.nextInt(100) < chance) {
                FluidStack fStack = UndergroundOil.undergroundOil(aWorld.getChunkFromBlockCoords(aX, aZ), -1);
                addChatMassageByValue(
                    aPlayer,
                    fStack.amount / 2,
                    new ChatComponentTranslation("detrav.scanner.found.name.fluid"));

                if (!aPlayer.capabilities.isCreativeMode)
                    ((DetravMetaGeneratedTool01) aItem).doDamage(aStack, this.mCosts);

                if (VisualProspecting.isModLoaded()) {
                    VisualProspecting_API.LogicalServer.sendProspectionResultsToClient(
                        (EntityPlayerMP) aPlayer,
                        new ArrayList<>(),
                        VisualProspecting_API.LogicalServer
                            .prospectUndergroundFluidsWithingRadius(aWorld, (int) aPlayer.posX, (int) aPlayer.posZ, 0));
                }
            }
            return true;
        }

        if (block.getMaterial() == Material.rock || block.getMaterial() == Material.ground
            || GTUtility.isOre(block, meta)) {
            prospectChunks(aItem, aStack, aPlayer, aWorld, aX, aY, aZ, aRandom, chance);

            return true;
        }

        return false;
    }

    protected void prospectChunks(MetaBaseItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX,
        int aY, int aZ, SplittableRandom aRandom, int chance) {
        int bX = aX;
        int bZ = aZ;

        badluck = 0;
        ores = new HashMap<>();

        int range = aItem.getHarvestLevel(aStack, "") / 2 + (aStack.getItemDamage() / 4);
        if (range % 2 == 0) {
            range += 1; // kinda not needed here, divide takes it out, but we put it back in with the range+1 in the
                        // loop
        }
        range = range / 2; // Convert range from diameter to radius

        GTUtility.sendChatTrans(aPlayer, "detrav.scanner.prospecting.at", bX, bZ);
        for (int x = -range; x < range + 1; ++x) {
            aX = bX + x * 16;
            for (int z = -range; z < range + 1; ++z) {

                aZ = bZ + z * 16;
                int dist = x * x + z * z;

                int distTextIndex;
                for (distTextIndex = 0; distTextIndex < DISTANCEINTS.length; distTextIndex++) {
                    if (dist <= DISTANCEINTS[distTextIndex]) {
                        break;
                    }
                }

                if (DetravScannerMod.DEBUG_ENABLED) {
                    GTUtility.sendChatTrans(
                        aPlayer,
                        "detrav.scanner.chat.debug.chunk_at",
                        aX,
                        aZ,
                        aX + 16,
                        aZ + 16,
                        new ChatComponentTranslation("detrav.scanner.distance.texts." + distTextIndex));
                }

                processOreProspecting(
                    (DetravMetaGeneratedTool01) aItem,
                    aStack,
                    aPlayer,
                    aWorld,
                    aX,
                    aY,
                    aZ,
                    aRandom,
                    chance,
                    distTextIndex);
            }
        }

        // Define sort order by distance
        int[] sortOrder = { 4, 3, 2, 1, 0 };

        List<IChatComponent> oreMessagesSorted = new ArrayList<>();
        oreMessagesSorted.add(new ChatComponentText(CHAT_MSG_SEPARATOR));

        // Sort ore messages by distance, separated by -----
        for (int oreFrequency : sortOrder) {
            List<IChatComponent> messages = ores.entrySet()
                .stream()
                .filter(entry -> entry.getKey().dist == oreFrequency)
                .map(
                    entry -> getChatMessageByValue(
                        entry.getValue(),
                        entry.getKey()
                            .getChatComp()))
                .toList();
            oreMessagesSorted.addAll(messages);

            // Only append ----- separator if text has been added
            if (!messages.isEmpty()) {
                oreMessagesSorted.add(new ChatComponentText(CHAT_MSG_SEPARATOR));
            }
        }

        if (badluck == 0) {
            oreMessagesSorted.add(
                new ChatComponentTranslation("detrav.scanner.success")
                    .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.WHITE)));
        } else {
            oreMessagesSorted.add(
                new ChatComponentTranslation("detrav.scanner.fail", badluck)
                    .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.WHITE)));
        }

        // Print the sorted messages
        for (IChatComponent msg : oreMessagesSorted) {
            aPlayer.addChatMessage(msg);
        }

        if (VisualProspecting.isModLoaded()) {
            VisualProspecting_API.LogicalServer.sendProspectionResultsToClient(
                (EntityPlayerMP) aPlayer,
                VisualProspecting_API.LogicalServer.prospectOreVeinsWithinRadius(
                    aWorld.provider.dimensionId,
                    (int) aPlayer.posX,
                    (int) aPlayer.posZ,
                    range * 16),
                new ArrayList<>());
        }
    }

    // Used by Electric scanner when scanning the chunk whacked by the scanner. 100% chance find rate
    protected void prospectSingleChunk(MetaBaseItem aItem, ItemStack aStack, EntityPlayer aPlayer, World aWorld, int aX,
        int aY, int aZ) {
        ores = new HashMap<>();
        GTUtility.sendChatTrans(aPlayer, "detrav.scanner.prospecting.at", aX, aZ);
        processOreProspecting(
            (DetravMetaGeneratedTool01) aItem,
            aStack,
            aPlayer,
            aWorld,
            aX,
            aY,
            aZ,
            new SplittableRandom(),
            1000,
            0);

        for (OresKey key : ores.keySet()) {
            int value = ores.get(key);
            addChatMassageByValue(aPlayer, value, key.getChatComp());
        }

        if (VisualProspecting.isModLoaded()) {
            VisualProspecting_API.LogicalServer.sendProspectionResultsToClient(
                (EntityPlayerMP) aPlayer,
                VisualProspecting_API.LogicalServer.prospectOreVeinsWithinRadius(
                    aWorld.provider.dimensionId,
                    (int) aPlayer.posX,
                    (int) aPlayer.posZ,
                    0),
                new ArrayList<>());
        }
    }

    protected void processOreProspecting(DetravMetaGeneratedTool01 aItem, ItemStack aStack, EntityPlayer aPlayer,
        World world, int x, int y, int z, SplittableRandom aRandom, int chance, int distTextIndex) {
        Chunk chunk = world.getChunkFromBlockCoords(x, z);

        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);

        ItemStack blockStack = new ItemStack(block, 1, meta);

        if (GTUtility.isOre(block, meta)) {
            addOreToHashMap(blockStack.getDisplayName(), aPlayer, distTextIndex);
            if (!aPlayer.capabilities.isCreativeMode) aItem.doDamage(aStack, this.mCosts);
            return;
        }

        ItemData itemData = GTOreDictUnificator.getAssociation(blockStack);

        if (itemData != null) {
            try {
                // Why display `ItemData.toString()` here?
                aPlayer.addChatMessage(
                    new ChatComponentTranslation(
                        "detrav.scanner.found.texts.with_id",
                        new ChatComponentItemName(blockStack),
                        itemData.toString()));
                if (!aPlayer.capabilities.isCreativeMode) aItem.doDamage(aStack, this.mCosts);
            } catch (Exception e) {
                aPlayer.addChatMessage(new ChatComponentTranslation("detrav.scanner.found.texts.error"));
            }

            return;
        }

        if (aRandom.nextInt(100) < chance) {
            final int data = DetravMetaGeneratedTool01.INSTANCE.getToolGTDetravData(aStack)
                .intValue();

            for (int cx = 0; cx < 16; cx++) {
                for (int cz = 0; cz < 16; cz++) {
                    int ySize = chunk.getHeightValue(cx, cz);
                    for (int cy = 1; cy < ySize; cy++) {

                        Block tBlock = chunk.getBlock(cx, cy, cz);
                        short tMetaID = (short) chunk.getBlockMetadata(cx, cy, cz);

                        try (OreInfo<?> info = OreManager.getOreInfo(tBlock, tMetaID)) {
                            if (info != null) {
                                if (!info.isNatural) continue;
                                if (data != DetravMetaGeneratedTool01.MODE_ALL_ORES && info.isSmall) continue;

                                ItemStack oreStack = new ItemStack(tBlock, 1, tMetaID);
                                addOreToHashMap(oreStack.getDisplayName(), aPlayer, distTextIndex);
                                continue;
                            }
                        }

                        if (data == DetravMetaGeneratedTool01.MODE_ALL_ORES) {
                            ItemStack oreStack = new ItemStack(tBlock, 1, tMetaID);

                            itemData = GTOreDictUnificator.getAssociation(oreStack);
                            if (itemData != null && itemData.mPrefix.toString()
                                .startsWith("ore")) {
                                addOreToHashMap(oreStack.getDisplayName(), aPlayer, distTextIndex);
                            }
                        }
                    }
                }
            }

            if (!aPlayer.capabilities.isCreativeMode) aItem.doDamage(aStack, this.mCosts);

            return;
        }

        if (DetravScannerMod.DEBUG_ENABLED)
            aPlayer.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + " Failed on this chunk"));
        badluck++;
        if (!aPlayer.capabilities.isCreativeMode) aItem.doDamage(aStack, this.mCosts / 4);
    }

    void addOreToHashMap(String orename, EntityPlayer aPlayer, int distTextIndex) {
        OresKey key = new OresKey(orename, distTextIndex);
        if (!ores.containsKey(key)) {
            if (DetravScannerMod.DEBUG_ENABLED)
                GTUtility.sendChatTrans(aPlayer, "detrav.scanner.chat.debug.adding", key.getChatComp());
            ores.put(key, 1);
        } else {
            int val = ores.get(key);
            ores.put(key, val + 1);
        }
    }

    void addChatMassageByValue(EntityPlayer aPlayer, int value, IChatComponent name) {
        if (value < 0) {
            GTUtility.sendChatTrans(aPlayer, "detrav.scanner.found.texts.6", name);
        } else if (value < 1) {
            GTUtility.sendChatTrans(aPlayer, "detrav.scanner.found.texts.0");
        } else if (value < 10) GTUtility
            .sendChatComp(aPlayer, name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.1")));
        else if (value < 30) GTUtility
            .sendChatComp(aPlayer, name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.2")));
        else if (value < 60) GTUtility
            .sendChatComp(aPlayer, name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.3")));
        else if (value < 100) GTUtility
            .sendChatComp(aPlayer, name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.4")));
        else GTUtility
            .sendChatComp(aPlayer, name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.5")));
    }

    // Same as addChatMassageByValue but appends to a list of chat messages and spelled correctly
    IChatComponent getChatMessageByValue(int value, IChatComponent name) {
        if (value < 0) {
            return new ChatComponentTranslation("detrav.scanner.found.texts.6", name);
        } else if (value < 1) {
            return new ChatComponentTranslation("detrav.scanner.found.texts.0");
        } else if (value < 10) return name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.1"));
        else if (value < 30) return name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.2"));
        else if (value < 60) return name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.3"));
        else if (value < 100) return name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.4"));
        else return name.appendSibling(new ChatComponentTranslation("detrav.scanner.found.texts.5"));
    }

    public static int getPollution(World aWorld, int aX, int aZ) {
        return Pollution.getPollution(aWorld.getChunkFromBlockCoords(aX, aZ));
    }
}
