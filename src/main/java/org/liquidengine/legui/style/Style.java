package org.liquidengine.legui.style;

import org.joml.Vector2f;
import org.joml.Vector4f;
import org.liquidengine.legui.style.color.ColorConstants;
import org.liquidengine.legui.style.font.Font;
import org.liquidengine.legui.style.font.FontRegistry;
import org.liquidengine.legui.style.border.SimpleLineBorder;

/**
 * The type Style.
 *
 * @author Aliaksandr_Shcherbin.
 */
public class Style {

    private Background background = new Background();
    private Border border = new SimpleLineBorder(ColorConstants.gray(), 1);
    private Font font = FontRegistry.getFont(FontRegistry.DEFAULT);

    private Vector4f cornerRadius = new Vector4f(0, 0, 0, 0);

    private Vector4f padding;
    private Vector4f margin;

    private Vector2f minimumSize;
    private Vector2f maximumSize;
    private Vector2f preferredSize;

    /**
     * Stroke color. Used to render stroke if component is focused.
     */
    private Vector4f focusedStrokeColor = ColorConstants.lightBlue();

    /**
     * Gets background.
     *
     * @return the background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * Sets background.
     *
     * @param background the background
     */
    public void setBackground(Background background) {
        if (background != null) {
            this.background = background;
        } else {
            this.background = new Background();
        }
    }

    /**
     * Returns corner radius for all corners as vector <code>new Vector4f(topLeftCornerRadius, topRightCornerRadius, bottomRightCornerRadius,
     * bottomLeftCornerRadius)</code>.
     *
     * @return vector of corner radius for all corners.
     */
    public Vector4f getCornerRadius() {
        return cornerRadius;
    }

    /**
     * Sets corner radius.
     *
     * @param radius the radius
     */
    public void setCornerRadius(float radius) {
        cornerRadius.set(radius);
    }

    /**
     * Sets corner radius.
     *
     * @param cornerRadius the radius.
     */
    public void setCornerRadius(Vector4f cornerRadius) {
        if (cornerRadius != null) {
            this.cornerRadius = cornerRadius;
        } else {
            this.cornerRadius.set(0, 0, 0, 0);
        }
    }

    /**
     * Gets border.
     *
     * @return the border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * Sets border.
     *
     * @param border the border
     */
    public void setBorder(Border border) {
        this.border = border;
    }

    /**
     * Gets font.
     *
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * Sets font.
     *
     * @param font the font
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * Gets top left corner radius.
     *
     * @return the top left corner radius
     */
    public float getTopLeftCornerRadius() {
        return cornerRadius.x;
    }

    /**
     * Sets top left corner radius.
     *
     * @param topLeftCornerRadius the top left corner radius
     */
    public void setTopLeftCornerRadius(float topLeftCornerRadius) {
        cornerRadius.x = topLeftCornerRadius;
    }

    /**
     * Gets top right corner radius.
     *
     * @return the top right corner radius
     */
    public float getTopRightCornerRadius() {
        return cornerRadius.y;
    }

    /**
     * Sets top right corner radius.
     *
     * @param topRightCornerRadius the top right corner radius
     */
    public void setTopRightCornerRadius(float topRightCornerRadius) {
        cornerRadius.y = topRightCornerRadius;
    }

    /**
     * Gets bottom left corner radius.
     *
     * @return the bottom left corner radius
     */
    public float getBottomLeftCornerRadius() {
        return cornerRadius.w;
    }

    /**
     * Sets bottom left corner radius.
     *
     * @param bottomLeftCornerRadius the bottom left corner radius
     */
    public void setBottomLeftCornerRadius(float bottomLeftCornerRadius) {
        cornerRadius.w = bottomLeftCornerRadius;
    }

    /**
     * Gets bottom right corner radius.
     *
     * @return the bottom right corner radius
     */
    public float getBottomRightCornerRadius() {
        return cornerRadius.z;
    }

    /**
     * Sets bottom right corner radius.
     *
     * @param bottomRightCornerRadius the bottom right corner radius
     */
    public void setBottomRightCornerRadius(float bottomRightCornerRadius) {
        cornerRadius.z = bottomRightCornerRadius;
    }

    /**
     * Gets padding.
     *
     * @return the padding
     */
    public Vector4f getPadding() {
        return padding;
    }

    /**
     * Sets padding.
     *
     * @param padding the padding
     */
    public void setPadding(Vector4f padding) {
        this.padding = padding;
    }

    /**
     * Gets margin.
     *
     * @return the margin
     */
    public Vector4f getMargin() {
        return margin;
    }

    /**
     * Sets margin.
     *
     * @param margin the margin
     */
    public void setMargin(Vector4f margin) {
        this.margin = margin;
    }

    /**
     * Gets min size.
     *
     * @return the min size
     */
    public Vector2f getMinimumSize() {
        return minimumSize;
    }

    /**
     * Sets min size.
     *
     * @param minimumSize the min size
     */
    public void setMinimumSize(Vector2f minimumSize) {
        this.minimumSize = minimumSize;
    }

    /**
     * Gets max size.
     *
     * @return the max size
     */
    public Vector2f getMaximumSize() {
        return maximumSize;
    }

    /**
     * Sets max size.
     *
     * @param maximumSize the max size
     */
    public void setMaximumSize(Vector2f maximumSize) {
        this.maximumSize = maximumSize;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public Vector2f getPreferredSize() {
        return preferredSize;
    }

    /**
     * Sets size.
     *
     * @param preferredSize the size
     */
    public void setPreferredSize(Vector2f preferredSize) {
        this.preferredSize = preferredSize;
    }

    /**
     * Returns {@link Vector4f} focused stroke color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li>
     * <li>vector.z - blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @return background color vector.
     */
    public Vector4f getFocusedStrokeColor() {
        return focusedStrokeColor;
    }

    /**
     * Used to set focused stroke color vector where x,y,z,w mapped to r,g,b,a values. <ul> <li>vector.x - red.</li> <li>vector.y - green.</li> <li>vector.z -
     * blue.</li> <li>vector.a - alpha.</li> </ul>
     *
     * @param focusedStrokeColor focused stroke color vector.
     */
    public void setFocusedStrokeColor(Vector4f focusedStrokeColor) {
        this.focusedStrokeColor = focusedStrokeColor;
    }

    /**
     * Used to set focused stroke color vector.
     *
     * @param r red value.
     * @param g green value.
     * @param b blue value.
     * @param a alpha value.
     */
    public void setFocusedStrokeColor(float r, float g, float b, float a) {
        focusedStrokeColor.set(r, g, b, a);
    }

}
