package org.liquidengine.legui.event.system;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Shcherbin Alexander on 6/10/2016.
 */
public class FramebufferSizeEvent implements LeguiSystemEvent {
    public final long window;
    public final int width;
    public final int height;

    public FramebufferSizeEvent(long window, int width, int height) {

        this.window = window;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("window", window)
                .append("width", width)
                .append("height", height)
                .toString();
    }
}