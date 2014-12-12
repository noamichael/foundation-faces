package org.foundationfaces.component.select;

import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
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
        /**
         * The row containing the radio buttons
         */
        writer.startElement("div", component);
        writer.writeAttribute("class", "row", null);
        writer.writeAttribute("id", select.getClientId(context), null);
        /**
         * The individual radio buttons
         */
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

    /**
     * Encodes a single radio button
     *
     * @param context
     * @param select The concrete component
     * @param selectItem The select item, containing the item value and
     * description
     * @param i The index of the select item (used to generate id)
     * @param writer
     * @throws IOException
     */
    protected void encodeSingleRadio(FacesContext context,
            SelectRadio select,
            SelectItem selectItem,
            int i,
            ResponseWriter writer) throws IOException {
        if (selectItem != null) {
            String clientId = select.getClientId(context);
            String styleClass = select.getStyleClass();
            styleClass = StringUtil.isNullOrEmpty(styleClass) ? "" : styleClass;
            /**
             * Container
             */
            writer.startElement("div", null);
            writer.writeAttribute("class", select.getColumnStyleClasses(), null);
            /**
             * Label
             */
            writer.startElement("span", null);
            writer.writeText(selectItem.getLabel(), null);
            writer.endElement("span");
            /**
             * Switch
             */
            writer.startElement("div", null);
            writer.writeAttribute("class", SelectRadio.STYLE_CLASS, null);
            /**
             * Input
             */
            writer.startElement("input", null);
            writer.writeAttribute("name", clientId, null);
            Object value = select.getValue();
            if (value != null && value.equals(selectItem.getValue())) {
                writer.writeAttribute("checked", "checked", null);
            }
            writer.writeAttribute("type", "radio", null);
            writer.writeAttribute("id", clientId + ":" + i, clientId);
            writer.writeAttribute("value", ComponentUtil.getValueAsString(context, select), null);
            ComponentUtil.encodeEvents(context, select, select, writer);
            if (!styleClass.isEmpty()) {
                writer.writeAttribute("class", styleClass, null);
            }
            /**
             * Label (Actual slider)
             */
            writer.endElement("input");
            writer.startElement("label", null);
            writer.writeAttribute("for", clientId + ":" + i, null);
            writer.endElement("label");
            writer.endElement("div");//switch div
            writer.endElement("div");//responsive container
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
