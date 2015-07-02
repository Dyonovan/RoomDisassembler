package com.dyonovan.roomdisassembler.client.renderers;

import com.dyonovan.roomdisassembler.common.tileentities.TileRoomDisassembler;
import com.dyonovan.roomdisassembler.lib.Constants;
import com.dyonovan.roomdisassembler.util.Location;
import com.sun.prism.util.tess.Tess;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
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

        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        Tessellator.instance.setTranslation(-player.posX, -player.posY, -player.posZ);

        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":textures/blocks/displayArea.png"));


        renderAABB(AxisAlignedBB.getBoundingBox(begin.x + 0.5, begin.y + 0.5, begin.z + 0.5, end.x + 0.5, end.y + 0.5, end.z + 0.5));
        renderAABB(AxisAlignedBB.getBoundingBox(end.x + 0.5, end.y + 0.5, end.z + 0.5, begin.x + 0.5, begin.y + 0.5, begin.z + 0.5));

        Tessellator.instance.setTranslation(0, 0, 0);
        GL11.glPopMatrix();
    }

    public static void renderAABB(AxisAlignedBB paramAxisAlignedBB)
    {
        double d = 0.006D;

        Tessellator localTessellator = Tessellator.instance;
        localTessellator.startDrawingQuads();
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);

        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);

        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);

        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);

        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);

        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        localTessellator.addVertex(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        localTessellator.draw();
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
