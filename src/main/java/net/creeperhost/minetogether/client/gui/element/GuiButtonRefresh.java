package net.creeperhost.minetogether.client.gui.element;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButtonRefresh extends Button
{
    protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation("creeperhost", "textures/gui.png");
    private final int index;

    public GuiButtonRefresh(int xPos, int yPos, int index, Button.IPressable onPress)
    {
        super(xPos, yPos, 20, 20, "", onPress);
        this.index = index;
    }

    public GuiButtonRefresh(int xPos, int yPos, Button.IPressable onPress)
    {
        this(xPos, yPos, 0, onPress);
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float tick)
    {
        super.renderButton(x, y, tick);

        if (this.visible)
        {
            Minecraft.getInstance().getTextureManager().bindTexture(BUTTON_TEXTURES);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.blit(this.x, this.y, index * 20, isHovered ? this.height : 0, this.width, this.height);
        }
    }
}
