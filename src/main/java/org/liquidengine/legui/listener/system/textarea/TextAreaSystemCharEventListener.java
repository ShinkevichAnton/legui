package org.liquidengine.legui.listener.system.textarea;

import org.liquidengine.legui.component.TextArea;
import org.liquidengine.legui.context.LeguiContext;
import org.liquidengine.legui.event.system.SystemCharEvent;
import org.liquidengine.legui.listener.SystemEventListener;
import org.lwjgl.glfw.GLFW;

import static org.liquidengine.legui.util.Util.cpToStr;

/**
 * Created by Alexander on 28.08.2016.
 */
public class TextAreaSystemCharEventListener implements SystemEventListener<TextArea, SystemCharEvent> {
    @Override
    public void update(SystemCharEvent event, TextArea gui, LeguiContext leguiContext) {
        if (gui.isFocused() && gui.isEditable() && !leguiContext.getMouseButtonStates()[GLFW.GLFW_MOUSE_BUTTON_LEFT]) {
            String str = cpToStr(event.codepoint);
            int caretPosition = gui.getCaretPosition();
            gui.getTextState().insert(caretPosition, str);
            gui.setCaretPosition(caretPosition + str.length());
        }
    }
}