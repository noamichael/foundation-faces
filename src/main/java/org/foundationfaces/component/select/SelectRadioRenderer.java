package org.foundationfaces.component.select;

import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.ComponentUtil;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = SelectRadio.MY_RENDERER_TYPE)
public class SelectRadioRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        SelectRadio select = (SelectRadio) component;
        List<SelectItem> selectItems = ComponentUtil.getSelectItems(select);
        int i = 0;
        writer.startElement("div", component);
        writer.writeAttribute("class", "row", null);
        writer.writeAttribute("id", select.getClientId(context), null);
        for (SelectItem item : selectItems) {
            encodeSingleRadio(context,
                    select,
                    item,
                    i,
                    writer);
            i++;
        }
        writer.endElement("div");

    }

    protected void encodeSingleRadio(FacesContext context,
            SelectRadio select,
            SelectItem selectItem,
            int i,
            ResponseWriter writer) throws IOException {
        if (selectItem != null) {
            String clientId = select.getClientId(context);
            String styleClass = select.getStyleClass();
            styleClass = StringUtil.isNullOrEmpty(styleClass) ? "" : styleClass;
            writer.startElement("div", null);
            writer.writeAttribute("class", select.getColumnStyleClasses() + SelectRadio.STYLE_CLASS, null);
            writer.startElement("input", null);
            writer.writeAttribute("name", clientId, null);
            Object value = select.getValue();
            if (value != null && value.equals(selectItem.getValue())) {
                writer.writeAttribute("checked", "checked", null);
            }
            writer.writeAttribute("type", "radio", null);
            writer.writeAttribute("id", clientId + ":" + i, clientId);
            writer.writeAttribute("value", String.valueOf(selectItem.getValue()), null);
            encodeEvents(context, select, writer);
            writer.writeAttribute("class", styleClass, null);
            writer.endElement("input");
            writer.startElement("label", null);
            writer.writeAttribute("for", clientId + ":" + i, null);
            writer.endElement("label");
            writer.endElement("div");
        }
    }

    protected void encodeEvents(FacesContext context,
            SelectRadio select,
            ResponseWriter writer) throws IOException {
        List<ClientBehavior> changeBehaviors = select.getClientBehaviors().get("change");
        if (changeBehaviors != null && !changeBehaviors.isEmpty()) {
            ClientBehaviorContext clientBehaviorContext
                    = ClientBehaviorContext.createClientBehaviorContext(context,
                            select, "change", select.getClientId(context), null);
            StringBuilder builder = new StringBuilder();
            for (ClientBehavior behavior : changeBehaviors) {
                builder.append(behavior.getScript(clientBehaviorContext));
                builder.append(';');
            }
            writer.writeAttribute("onChange", builder.toString(), null);
        }
    }

    @Override
    public void decode(FacesContext context, UIComponent component) {
        SelectRadio selectRadio = (SelectRadio) component;
        String value = context.getExternalContext().
                getRequestParameterMap().get(selectRadio.getClientId(context));
        Converter converter = selectRadio.getConverter();
        if (converter != null) {
            Object convertedValue = converter.getAsObject(context, component, value);
            selectRadio.setSubmittedValue(convertedValue);
        } else {
            selectRadio.setSubmittedValue(value);
        }
    }

}
