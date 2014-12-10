package org.foundationfaces.component.panel;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author MKucinski
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = Panel.MY_RENDERER_TYPE)
public class PanelRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Panel panel = (Panel) component;
        encodePanelStart(context, writer, panel);
        encodePanelHeader(context, writer, panel);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Panel panel = (Panel) component;
        encodePanelEnd(context, writer, panel);
    }

    protected void encodePanelStart(FacesContext context, ResponseWriter writer, Panel panel) throws IOException {
        String sytleClass = StringUtil.isNullOrEmpty(panel.getStyleClass()) ? "" : " " + panel.getStyleClass();
        writer.startElement("div", panel);
        writer.writeAttribute("id", panel.getClientId(context), null);
        writer.writeAttribute("class", Panel.STYLE_CLASS + sytleClass, null);
        String style = panel.getStyle();
        if (!StringUtil.isNullOrEmpty(style)) {
            writer.writeAttribute("style", style, null);
        }
    }

    protected void encodePanelEnd(FacesContext context, ResponseWriter writer, Panel panel) throws IOException {
        writer.endElement("div");
    }

    protected void encodePanelHeader(FacesContext context, ResponseWriter writer, Panel panel) throws IOException {
        UIComponent headerFacet = panel.getFacet("header");
        String header = panel.getHeader();
        boolean shouldWrite = headerFacet != null || !StringUtil.isNullOrEmpty(header);
        if (shouldWrite) {
            writer.startElement("div", null);
            writer.writeAttribute("class", Panel.HEADER_STYLE_CLASS, null);
            if (headerFacet != null) {
                headerFacet.encodeAll(context);
            } else {
                if (!StringUtil.isNullOrEmpty(panel.getHeader())) {
                    writer.writeText(panel.getHeader(), null);
                } else {
                    writer.write("&nbsp;");
                }
            }
            writer.endElement("div");
        }
    }

}
