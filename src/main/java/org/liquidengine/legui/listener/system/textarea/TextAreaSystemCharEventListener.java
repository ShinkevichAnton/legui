package org.liquidengine.legui.listener.system.textarea;

import org.liquidengine.legui.component.TextArea;
import org.liquidengine.legui.component.optional.TextState;
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
        if (gui.getState().isFocused() && gui.isEditable() && !leguiContext.getMouseButtonStates()[GLFW.GLFW_MOUSE_BUTTON_LEFT]) {
            String str = cpToStr(event.codepoint);
            TextState textState = gui.getTextState();
            int start = gui.getStartSelectionIndex();
            int end = gui.getEndSelectionIndex();
            if (start > end) {
                start = gui.getEndSelectionIndex();
                end = gui.getStartSelectionIndex();
            }
            if (start != end) {
                textState.delete(start, end);
                gui.setCaretPosition(start);
                gui.setStartSelectionIndex(start);
                gui.setEndSelectionIndex(start);
            }
            int caretPosition = gui.getCaretPosition();
            textState.insert(caretPosition, str);
            int newCaretPosition = caretPosition + str.length();
            gui.setCaretPosition(newCaretPosition);
            gui.setEndSelectionIndex(newCaretPosition);
            gui.setStartSelectionIndex(newCaretPosition);
        }
    }
}
