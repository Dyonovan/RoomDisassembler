package com.dyonovan.roomdisassembler.managers;

import com.dyonovan.roomdisassembler.common.blocks.BlockDisassembler;
import com.dyonovan.roomdisassembler.common.tileentities.TileRoomDisassembler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class BlockManager {

    public static Block blockRoomDisassembler;

    public static void init() {

        //Room Disassembler
        registerBlock(blockRoomDisassembler = new BlockDisassembler(), "blockRoomDisassembler", TileRoomDisassembler.class);
    }

    public static void registerBlock(Block block, String name, Class<? extends TileEntity> tileEntity) {
        GameRegistry.registerBlock(block, name);
        if (tileEntity != null)
            GameRegistry.registerTileEntity(tileEntity, name);
    }
}
