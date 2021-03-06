package org.foundationfaces.component.select;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.WrappedRenderer;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = SelectBoolean.MY_RENDERER_TYPE)
public class SelectBooleanRenderer extends WrappedRenderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        SelectBoolean select = (SelectBoolean) component;
        writer.startElement("div", component);
        String containerStyleClass = select.getContainerStyleClass();
        if (!StringUtil.isNullOrEmpty(containerStyleClass)) {
            writer.writeAttribute("class", SelectRadio.STYLE_CLASS + " " + containerStyleClass, null);
        } else {
            writer.writeAttribute("class", SelectRadio.STYLE_CLASS, null);
        }
        getDefaultRenderer(context).encodeBegin(context, component);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        SelectBoolean select = (SelectBoolean) component;
        getDefaultRenderer(context).encodeEnd(context, component);
        writer.startElement("label", null);
        writer.writeAttribute("for", select.getClientId(context), null);
        writer.endElement("label");
        writer.endElement("div");
    }

    @Override
    protected Renderer getDefaultRenderer(FacesContext context) {
        return context.getRenderKit()
                .getRenderer(HtmlSelectBooleanCheckbox.COMPONENT_FAMILY,
                        "javax.faces.Checkbox");
    }

}
