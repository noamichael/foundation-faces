package org.foundationfaces.component.revealmodal;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.ComponentUtil;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = RevealModalButton.MY_RENDERER_TYPE)
public class RevealModalButtonRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        RevealModalButton button = (RevealModalButton) component;
        ResponseWriter writer = context.getResponseWriter();
        encodeButtonStart(context, button, writer);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        RevealModalButton button = (RevealModalButton) component;
        ResponseWriter writer = context.getResponseWriter();
        encodeButtonEnd(context, button, writer);
    }

    protected void encodeButtonStart(FacesContext context, RevealModalButton button, ResponseWriter writer) throws IOException {
        writer.startElement("a", button);
        writer.writeAttribute("href", "#", null);
        ComponentUtil.encodeStyledComponent(button, RevealModalButton.STYLE_CLASS, writer);
        writer.writeAttribute("data-reveal-id", button.getDataRevealId(), null);
        if (!StringUtil.isNullOrEmpty(button.getLabel())) {
            writer.write(button.getLabel());
        }

    }

    protected void encodeButtonEnd(FacesContext context, RevealModalButton button, ResponseWriter writer) throws IOException {
        writer.endElement("a");
    }

}
