package com.dyonovan.roomdisassembler.client.gui;

import com.dyonovan.roomdisassembler.common.container.ContainerRoomDisassembler;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiRoomDisassembler extends GuiBase<ContainerRoomDisassembler> {

    public GuiRoomDisassembler(InventoryPlayer invPlayer) {
        super(new ContainerRoomDisassembler(invPlayer), 175, 165, "inventory.trashBag.title");
    }

    @Override
    public void addComponents() {

    }
}
