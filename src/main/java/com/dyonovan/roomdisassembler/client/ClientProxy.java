package com.dyonovan.roomdisassembler.client;

import com.dyonovan.roomdisassembler.client.renderers.BlockRoomDisassemblerRenderer;
import com.dyonovan.roomdisassembler.client.renderers.TileEntityRoomDisassemblerRenderer;
import com.dyonovan.roomdisassembler.common.CommonProxy;
import com.dyonovan.roomdisassembler.common.tileentities.TileRoomDisassembler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        BlockRoomDisassemblerRenderer.renderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockRoomDisassemblerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileRoomDisassembler.class,
                new TileEntityRoomDisassemblerRenderer());
    }
}
