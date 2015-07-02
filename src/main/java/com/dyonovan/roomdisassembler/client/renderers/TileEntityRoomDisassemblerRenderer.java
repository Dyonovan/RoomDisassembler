package com.dyonovan.roomdisassembler.client.renderers;

import com.dyonovan.roomdisassembler.common.tileentities.TileRoomDisassembler;
import com.dyonovan.roomdisassembler.lib.Constants;
import com.dyonovan.roomdisassembler.util.Location;
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

        EntityPlayer player = Minecraft.getMinecraft().thePlayer;

        double playerX = player.prevPosX + (player.posX - player.prevPosX) * f;
        double playerY = player.prevPosY + (player.posY - player.prevPosY) * f;
        double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * f;

        GL11.glTranslated(-playerX, -playerY, -playerZ);

        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Constants.MODID + ":textures/blocks/displayArea.png"));

        renderAABB(AxisAlignedBB.getBoundingBox(begin.x + 0.5, begin.y + 0.5, begin.z + 0.5, end.x + 0.5, end.y + 0.5, end.z + 0.5));
        renderAABB(AxisAlignedBB.getBoundingBox(end.x + 0.5, end.y + 0.5, end.z + 0.5, begin.x + 0.5, begin.y + 0.5, begin.z + 0.5));

        Tessellator.instance.setTranslation(0, 0, 0);
        GL11.glPopMatrix();
    }

    public static void renderAABB(AxisAlignedBB paramAxisAlignedBB) {
        double d = 0.001D;

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.minX + d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glEnd();

        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.minZ + d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.maxY - d, paramAxisAlignedBB.maxZ - d);
        GL11.glVertex3d(paramAxisAlignedBB.maxX - d, paramAxisAlignedBB.minY + d, paramAxisAlignedBB.maxZ - d);
        GL11.glEnd();
    }

    public static void setColor(Color color) {
        GL11.glColor4f(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
    }
}
