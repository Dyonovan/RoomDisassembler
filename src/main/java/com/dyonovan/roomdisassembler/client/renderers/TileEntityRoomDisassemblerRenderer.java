package com.dyonovan.roomdisassembler.client.renderers;

import com.dyonovan.roomdisassembler.common.tileentities.TileRoomDisassembler;
import com.dyonovan.roomdisassembler.lib.Constants;
import com.dyonovan.roomdisassembler.util.Location;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class TileEntityRoomDisassemblerRenderer extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float f) {
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        GL11.glDisable(GL11.GL_LIGHTING);

        setColor(new Color(200, 4, 65));

        TileRoomDisassembler roomThing = (TileRoomDisassembler)tile;

        Location begin = new Location();
        begin.copyLocation(roomThing.loc1);

        Location end = new Location();
        end.copyLocation(roomThing.loc2);

        //Move to start Position
       // GL11.glTranslated(x, y, z);

        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":textures/blocks/displayArea.png"));

        renderCube(Tessellator.instance, begin.x + 0.001, begin.y + 0.001, begin.z + 0.001, end.x - 0.001, end.y - 0.001, end.z - 0.001);
        renderCube(Tessellator.instance, end.x - 0.001, end.y - 0.001, end.z - 0.001, begin.x + 0.001, begin.y + 0.001, begin.z + 0.001);

        GL11.glPopMatrix();
    }

    public static void renderCube(Tessellator tes, double x1, double y1, double z1, double x2, double y2, double z2) {
        tes.startDrawingQuads();

        tes.addVertexWithUV(x1, y1, z1, 0, 0);
        tes.addVertexWithUV(x1, y2, z1, 0, 1);
        tes.addVertexWithUV(x2, y2, z1, 1, 1);
        tes.addVertexWithUV(x2, y1, z1, 1, 0);

        tes.addVertexWithUV(x1, y1, z2, 0, 0);
        tes.addVertexWithUV(x2, y1, z2, 0, 1);
        tes.addVertexWithUV(x2, y2, z2, 1, 1);
        tes.addVertexWithUV(x1, y2, z2, 1, 0);

        tes.addVertexWithUV(x1, y1, z1, 0, 0);
        tes.addVertexWithUV(x1, y1, z2, 0, 1);
        tes.addVertexWithUV(x1, y2, z2, 1, 1);
        tes.addVertexWithUV(x1, y2, z1, 1, 0);

        tes.addVertexWithUV(x2, y1, z1, 0, 0);
        tes.addVertexWithUV(x2, y2, z1, 0, 1);
        tes.addVertexWithUV(x2, y2, z2, 1, 1);
        tes.addVertexWithUV(x2, y1, z2, 1, 0);

        tes.addVertexWithUV(x1, y1, z1, 0, 0);
        tes.addVertexWithUV(x2, y1, z1, 0, 1);
        tes.addVertexWithUV(x2, y1, z2, 1, 1);
        tes.addVertexWithUV(x1, y1, z2, 1, 0);

        tes.addVertexWithUV(x1, y2, z1, 0, 0);
        tes.addVertexWithUV(x1, y2, z2, 0, 1);
        tes.addVertexWithUV(x2, y2, z2, 1, 1);
        tes.addVertexWithUV(x2, y2, z1, 1, 0);

        tes.draw();
    }

    public static void setColor(Color color) {
        GL11.glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
    }
}
