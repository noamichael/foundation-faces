package org.foundationfaces.component.offcanvas;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.ComponentUtil;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = OffCanvasButton.MY_RENDERER_TYPE)
public class OffCanvasButtonRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        OffCanvasButton button = (OffCanvasButton) component;
        String side = button.getSide().trim().toLowerCase();
        switch (side) {
            case "left":
                encodeLeftSmall(context, button, writer);
                break;
            case "right":
                encodeRightSmall(context, button, writer);
                break;
            default:
                throw new RuntimeException("OffCanvas button requires the side attribute of either 'left' or 'right'.");
        }
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        OffCanvasButton button = (OffCanvasButton) component;
        writer.endElement("div");
    }

    protected void encodeLeftSmall(FacesContext context, OffCanvasButton button, ResponseWriter writer) throws IOException {
        writer.startElement("div", button);
        writer.writeAttribute("class", OffCanvasButton.LEFT_SMALL_STYLE_CLASS, null);
        ComponentUtil.encodeStyledComponent(button, null, writer);
        writer.write("<a class=\"left-off-canvas-toggle menu-icon\" href=\"#\"><span></span></a>");
        
    }

    protected void encodeRightSmall(FacesContext context, OffCanvasButton button, ResponseWriter writer) throws IOException {
        writer.startElement("div", button);
        writer.writeAttribute("class", OffCanvasButton.RIGHT_SMALL_STYLE_CLASS, null);
        ComponentUtil.encodeStyledComponent(button, null, writer);
        writer.write("<a class=\"right-off-canvas-toggle menu-icon\" href=\"#\"><span></span></a>");
    }

}
