package org.foundationfaces.component.revealmodal;

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
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = RevealModal.RENDERER_TYPE)
public class RevealModalRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        RevealModal revealModal = (RevealModal) component;
        encodeModalStart(context, writer, revealModal);
        encodeModalHeader(context, writer, revealModal);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        RevealModal revealModal = (RevealModal) component;
        encodeModalEnd(context, writer, revealModal);
    }

    protected void encodeModalStart(FacesContext context, ResponseWriter writer, RevealModal revealModal) throws IOException {
        String sytleClass = StringUtil.isNullOrEmpty(revealModal.getStyleClass()) ? "" : " " + revealModal.getStyleClass();
        writer.startElement("div", revealModal);
        writer.writeAttribute("class", RevealModal.STYLE_CLASS + sytleClass, null);
        writer.writeAttribute("id", revealModal.getDataRevealId(), null);
        writer.writeAttribute("data-reveal", "data-reveal", null);
        String style = revealModal.getStyle();
        if (!StringUtil.isNullOrEmpty(style)) {
            writer.writeAttribute("style", style, null);
        }
    }

    protected void encodeModalEnd(FacesContext context, ResponseWriter writer, RevealModal revealModal) throws IOException {
        writer.endElement("div");
    }

    protected void encodeModalHeader(FacesContext context, ResponseWriter writer, RevealModal revealModal) throws IOException {
        UIComponent headerFacet = revealModal.getFacet("header");
        String header = revealModal.getHeader();
        boolean shouldWrite = headerFacet != null || !StringUtil.isNullOrEmpty(header);
        if (shouldWrite) {
            writer.startElement("div", null);
            writer.writeAttribute("class", RevealModal.HEADER_STYLE_CLASS, null);
            if (headerFacet != null) {
                headerFacet.encodeAll(context);
            } else {
                if (!StringUtil.isNullOrEmpty(revealModal.getHeader())) {
                    writer.writeText(revealModal.getHeader(), null);
                } else {
                    writer.write("&nbsp;");
                }
            }
            writer.endElement("div");
        }
    }
}
