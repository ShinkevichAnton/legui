package org.liquidengine.legui.render.nvg.component;

import org.joml.Vector2f;
import org.liquidengine.legui.component.Component;
import org.liquidengine.legui.component.ProgressBar;
import org.liquidengine.legui.component.border.Border;
import org.liquidengine.legui.context.LeguiContext;
import org.liquidengine.legui.render.nvg.NvgLeguiComponentRenderer;
import org.liquidengine.legui.util.NVGUtils;
import org.lwjgl.nanovg.NVGColor;

import static org.liquidengine.legui.util.NvgRenderUtils.createScissor;
import static org.liquidengine.legui.util.NvgRenderUtils.resetScissor;
import static org.liquidengine.legui.util.Util.calculatePosition;
import static org.lwjgl.nanovg.NanoVG.*;

/**
 * Created by Shcherbin Alexander on 7/14/2016.
 */
public class NvgProgressBarRenderer extends NvgLeguiComponentRenderer {
    private NVGColor colorA = NVGColor.malloc();

    @Override
    public void render(Component component, LeguiContext leguiContext, long context) {
        createScissor(context, component);
        {
            nvgSave(context);
            ProgressBar progressBar = (ProgressBar) component;
            Vector2f pos = calculatePosition(component);
            Vector2f size = component.getSize();

            float cornerRadius = component.getCornerRadius();

            nvgBeginPath(context);
            nvgRoundedRect(context, pos.x, pos.y, size.x, size.y, cornerRadius);
            nvgFillColor(context, NVGUtils.rgba(component.getBackgroundColor(), colorA));
            nvgFill(context);

            nvgBeginPath(context);
            nvgRoundedRect(context, pos.x, pos.y, size.x * progressBar.getValue() / ProgressBar.MAX_VALUE, size.y, cornerRadius);
            nvgFillColor(context, NVGUtils.rgba(progressBar.getProgressColor(), colorA));
            nvgFill(context);

            Border border = component.getBorder();
            if (border != null) {
                border.render(leguiContext);
            }

        }
        resetScissor(context);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void destroy() {

    }
}
