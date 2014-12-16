package org.foundationfaces.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import org.foundationfaces.component.select.ExtendedSelectItem;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
public final class ComponentUtil {

    /**
     * Returns the HTML event name for the given common JSF identifier.
     */
    public final static Map<String, String> HTML_JS_EVENT_NAMES = new HashMap();

    static {
        HTML_JS_EVENT_NAMES.put("blur", "onblur");
        HTML_JS_EVENT_NAMES.put("change", "onchange");
        HTML_JS_EVENT_NAMES.put("valuechange", "onchange");
        HTML_JS_EVENT_NAMES.put("focus", "onfocus");
        HTML_JS_EVENT_NAMES.put("click", "onclick");
        HTML_JS_EVENT_NAMES.put("dblclick", "ondblclick");
        HTML_JS_EVENT_NAMES.put("keydown", "onkeydown");
        HTML_JS_EVENT_NAMES.put("keypress", "onkeypress");
        HTML_JS_EVENT_NAMES.put("keyup", "onkeyup");
        HTML_JS_EVENT_NAMES.put("mousedown", "onmousedown");
        HTML_JS_EVENT_NAMES.put("mousemove", "onmousemove");
        HTML_JS_EVENT_NAMES.put("mouseout", "onmouseout");
        HTML_JS_EVENT_NAMES.put("mouseover", "onmouseover");
        HTML_JS_EVENT_NAMES.put("mouseup", "onmouseup");
    }

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

    public static UIForm getForm(UIComponent component) {
        if (component == null) {
            return null;
        }
        if (component instanceof UIForm) {
            return (UIForm) component;
        }
        UIForm form = null;
        UIComponent parent = component.getParent();
        while (parent != null && !(parent instanceof UIForm)) {
            parent = parent.getParent();
        }
        if(parent != null){
            form = (UIForm) parent;
        }
        return form;
    }

    /**
     * Finds the {@link SelectItem SelectItem(s)} for a given component via the
     * f:selectItem tag, or the f:selectItems tag. The f:selectItems tag can use
     * a map or a collection of items. If a collection is used, it must be a
     * collection of {@link SelectItem}. If a map is used, the key will be the
     * description.
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

    public static <T extends UIComponent & EditableValueHolder> String getValueAsString(FacesContext context, T component, Object value) {
        Converter converter = component.getConverter();
        String valueToEncode;
        if (converter != null) {
            valueToEncode = converter.getAsString(context, component, value);
        } else {
            valueToEncode = String.valueOf(component.getValue());
        }
        return valueToEncode;
    }

    /**
     * Encodes the {@link ClientBehavior} the default events for a given
     * {@link ClientBehaviorHolder}.
     *
     * <h3>The events that are encode are:</h3>
     * <p>
     * {@code "onblur", "onchange", "onchange", "onfocus", "onclick", "ondblclick",
     * "onkeydown", "onkeypress", "onkeyup", "onmousedown", "onmousemove",
     * "onmouseout", "onmouseover", "onmouseup"}
     * </p>
     *
     * @param <T>
     * @param context
     * @param component The component reference
     * @param writer The writer to add to the view
     * @throws IOException if an I/O exception occurs
     */
    public static <T extends UIComponent & ClientBehaviorHolder> void encodeEvents(FacesContext context,
            T component,
            ResponseWriter writer) throws IOException {
        Map<String, List<ClientBehavior>> componentBehaviorMap = component.getClientBehaviors();
        for (Map.Entry<String, String> events : HTML_JS_EVENT_NAMES.entrySet()) {
            String jsfEventName = events.getKey();
            String htmlAttributeName = events.getValue();
            StringBuilder builder = new StringBuilder();
            if (componentBehaviorMap.containsKey(jsfEventName)) {
                for (ClientBehavior behavior : componentBehaviorMap.get(jsfEventName)) {
                    ClientBehaviorContext clientBehaviorContext
                            = ClientBehaviorContext.createClientBehaviorContext(context,
                                    component, jsfEventName, component.getClientId(context), null);
                    String script = behavior.getScript(clientBehaviorContext);
                    if (!StringUtil.isNullOrEmpty(script)) {
                        builder.append(script);
                        builder.append(';');
                    }
                }
            }
            String additionalBehavior = (String) component.getAttributes().get(htmlAttributeName);
            if (!StringUtil.isNullOrEmpty(additionalBehavior)) {
                builder.append(additionalBehavior);
                builder.append(";");
            }
            String script = builder.toString();
            if (htmlAttributeName != null && !script.isEmpty()) {
                writer.writeAttribute(htmlAttributeName, builder.toString(), null);
            }
        }
    }
}
