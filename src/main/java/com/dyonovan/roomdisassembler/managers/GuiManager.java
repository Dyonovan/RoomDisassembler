package com.dyonovan.roomdisassembler.managers;

import com.dyonovan.roomdisassembler.client.gui.GuiRoomDisassembler;
import com.dyonovan.roomdisassembler.common.container.ContainerRoomDisassembler;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiManager implements IGuiHandler {

    public static final int ROOM_DISASSEMBLER_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch(ID) {
            case ROOM_DISASSEMBLER_ID:
                return new ContainerRoomDisassembler(player.inventory);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case ROOM_DISASSEMBLER_ID:
                return new GuiRoomDisassembler(player.inventory);
            default:
                return null;
        }
    }
}
