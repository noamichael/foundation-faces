package org.foundationfaces.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import org.foundationfaces.component.select.ExtendedSelectItem;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
public final class ComponentUtil {

    public static void encodeStyledComponent(Styled styled, String defaultStyleClass, ResponseWriter writer) throws IOException {
        String style = styled.getStyle();
        String styleClass = styled.getStyleClass();
        if (!StringUtil.isNullOrEmpty(style)) {
            writer.writeAttribute("style", style, null);
        }
        if (!StringUtil.isNullOrEmpty(styleClass)) {
            writer.writeAttribute("class", defaultStyleClass + " " + styleClass, null);
        } else if (!StringUtil.isNullOrEmpty(defaultStyleClass)) {
            writer.writeAttribute("class", defaultStyleClass, null);
        }
    }

    /**
     * Finds the {@link SelectItem} for a given component via the f:selectItem
     * tag, or the f:selectItems tag. The f:selectItems tag can use a map or a
     * collection.
     *
     * @param component
     * @return
     */
    public static List<SelectItem> getSelectItems(UIComponent component) {
        List<SelectItem> selectItems = new ArrayList<>();
        for (UIComponent kid : component.getChildren()) {
            if (kid instanceof UISelectItem) {
                UISelectItem uISelectItem = (UISelectItem) kid;
                selectItems.add(new ExtendedSelectItem(uISelectItem));
            } else if (kid instanceof UISelectItems) {
                UISelectItems uISelectItems = (UISelectItems) kid;
                Object abstractSelectItems = uISelectItems.getValue();
                if (abstractSelectItems instanceof Collection) {
                    selectItems.addAll((Collection<? extends SelectItem>) uISelectItems.getValue());
                } else if (abstractSelectItems instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) abstractSelectItems;
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        selectItems.add(new ExtendedSelectItem(entry.getValue(), String.valueOf(entry.getKey())));
                    }
                }
            }
        }
        return selectItems;
    }

    /**
     * Encodes the {@link ClientBehavior} events for a given
     * {@link ClientBehaviorHolder}. Does not encode the event if the event is
     * not found by {@link getEventAttributeName(java.lang.String)}
     *
     * @param context
     * @param holder The holder of the events
     * @param component The component reference
     * @param writer The writer to add to the view
     * @throws IOException if an I/O exception occurs
     */
    public static void encodeEvents(FacesContext context,
            ClientBehaviorHolder holder,
            UIComponent component,
            ResponseWriter writer) throws IOException {
        for (Map.Entry<String, List<ClientBehavior>> eventEntries : holder.getClientBehaviors().entrySet()) {
            for (ClientBehavior behavior : eventEntries.getValue()) {
                ClientBehaviorContext clientBehaviorContext
                        = ClientBehaviorContext.createClientBehaviorContext(context,
                                component, eventEntries.getKey(), component.getClientId(context), null);
                StringBuilder builder = new StringBuilder();
                builder.append(behavior.getScript(clientBehaviorContext));
                builder.append(';');
                String htmlAttributeName = getEventAttributeName(eventEntries.getKey());
                if (htmlAttributeName != null) {
                    writer.writeAttribute(htmlAttributeName, builder.toString(), null);
                }
            }
        }
    }

    /**
     * Returns the HTML event name for the given common JSF identifier.
     *
     * @param event The name of the JSF event
     * @return The converted event name (if found) or else null
     */
    public static String getEventAttributeName(String event) {
        switch (event.trim().toLowerCase()) {
            case "blur":
                return "onblur";
            case "change":
            case "valueChange":
                return "onchange";
            case "focus":
                return "onfocus";
            case "click":
                return "onclick";
            case "dbclick":
                return "ondblclick";
            case "keydown":
                return "onkeydown";
            case "keypress":
                return "onkeypress";
            case "keyup":
                return "onkeyup";
            case "mousedown":
                return "onmousedown";
            case "mousemove":
                return "onmousemove";
            case "mouseout":
                return "onmouseout";
            case "mouseover":
                return "onmouseover";
            case "mouseup":
                return "onmouseup";
            default:
                return null;
        }
    }
}
