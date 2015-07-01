package com.dyonovan.roomdisassembler;

import com.dyonovan.roomdisassembler.common.CommonProxy;
import com.dyonovan.roomdisassembler.lib.Constants;
import com.dyonovan.roomdisassembler.managers.BlockManager;
import com.dyonovan.roomdisassembler.managers.GuiManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

@SuppressWarnings("unused")
@Mod(name = Constants.MODNAME, modid = Constants.MODID, version = Constants.VERSION, dependencies = Constants.DEPENDENCIES)

public class RoomDisassembler {

    @Instance(Constants.MODID)
    public static RoomDisassembler instance;

    @SidedProxy(clientSide = "com.dyonovan.roomdisassembler.client.ClientProxy",
            serverSide = "com.dyonovan.roomdisassembler.common.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabRoomDisassembler = new CreativeTabs("tabRoomDisassembler") {
        @Override
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Items.carrot_on_a_stick;
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        BlockManager.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiManager());

        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
