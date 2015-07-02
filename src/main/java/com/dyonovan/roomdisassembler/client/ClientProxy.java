package com.dyonovan.roomdisassembler.client;

import com.dyonovan.roomdisassembler.client.renderers.BlockDisassemblerRenderer;
import com.dyonovan.roomdisassembler.client.renderers.TileEntityDisassemblerRenderer;
import com.dyonovan.roomdisassembler.common.CommonProxy;
import com.dyonovan.roomdisassembler.common.tileentities.TileDisassembler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        BlockDisassemblerRenderer.renderID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockDisassemblerRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileDisassembler.class,
                new TileEntityDisassemblerRenderer());
    }
}
