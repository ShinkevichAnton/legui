package org.liquidengine.legui.system.processor;

import org.liquidengine.legui.component.Component;
import org.liquidengine.legui.component.Container;
import org.liquidengine.legui.component.Frame;
import org.liquidengine.legui.component.Layer;
import org.liquidengine.legui.event.WindowRefreshEvent;
import org.liquidengine.legui.system.context.Context;
import org.liquidengine.legui.system.event.SystemWindowRefreshEvent;

import java.util.List;

/**
 * Created by Aliaksandr_Shcherbin on 2/2/2017.
 */
public class WindowRefreshEventHandler extends AbstractSystemEventHandler<SystemWindowRefreshEvent> {

    @Override
    protected boolean handle(SystemWindowRefreshEvent event, Layer layer, Context context, Frame frame) {
        pushEvent(layer.getContainer(), context, frame);
        return false;
    }

    private void pushEvent(Component component, Context context, Frame frame) {
        if (!(component.isVisible())) return;
        context.getEventProcessor().pushEvent(new WindowRefreshEvent(component, context, frame));
        if (component instanceof Container) {
            List<Component> childs = ((Container) component).getChilds();
            for (Component child : childs) {
                pushEvent(child, context, frame);
            }
        }
    }
}