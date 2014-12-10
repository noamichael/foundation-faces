package org.foundationfaces.component.joyride;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael Kucinski
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = Joyride.MY_RENDERER_TYPE)
public class JoyrideRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Joyride joyride = (Joyride) component;
        encodeJoyrideStart(context, joyride, writer);

    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        Joyride joyride = (Joyride) component;
        encodeJoyrideEnd(context, joyride, writer);
    }

    protected void encodeJoyrideStart(FacesContext context, Joyride joyride, ResponseWriter writer) throws IOException {
        writer.startElement("ol", joyride);
        writer.writeAttribute("class", Joyride.STYLE_CLASS, PASSTHROUGH_RENDERER_LOCALNAME_KEY);
        writer.writeAttribute("data-joyride", "data-joyride", null);
    }

    protected void encodeJoyrideEnd(FacesContext context, Joyride joyride, ResponseWriter writer) throws IOException {
        writer.endElement("ol");
    }
}
