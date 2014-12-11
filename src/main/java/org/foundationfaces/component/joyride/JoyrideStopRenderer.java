package org.foundationfaces.component.joyride;

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
 * @author Michael Kucinski
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = JoyrideStop.MY_RENDERER_TYPE)
public class JoyrideStopRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        JoyrideStop stop = (JoyrideStop) component;
        encodeJoyrideStopStart(context, stop, writer);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        JoyrideStop stop = (JoyrideStop) component;
        encodeJoyrideStopEnd(context, stop, writer);
    }

    protected void encodeJoyrideStopStart(FacesContext context, JoyrideStop stop, ResponseWriter writer) throws IOException {
        writer.startElement("li", stop);
        String dataText = stop.getDataText();
        if(!StringUtil.isNullOrEmpty(dataText)){
            writer.writeAttribute("data-text", dataText, null);
        }
        String dataId = stop.getDataId();
        if(!StringUtil.isNullOrEmpty(dataId)){
            writer.writeAttribute("data-id", dataId, null);
        }
        String dataClass = stop.getDataClass();
        if(!StringUtil.isNullOrEmpty(dataClass)){
            writer.writeAttribute("data-class", dataClass, null);
        }
        String dataPrevText = stop.getDataPrevText();
        if(!StringUtil.isNullOrEmpty(dataPrevText)){
            writer.writeAttribute("data-prev-text", dataPrevText, null);
        }
        String dataButton = stop.getDataButton();
        if(!StringUtil.isNullOrEmpty(dataButton)){
            writer.writeAttribute("data-button", dataButton, null);
        }
        String dataOptions = stop.buildDataOptionString();
        if(!StringUtil.isNullOrEmpty(dataOptions)){
            writer.writeAttribute("data-options", dataOptions, null);
        }
    }

    protected void encodeJoyrideStopEnd(FacesContext context, JoyrideStop stop, ResponseWriter writer) throws IOException {
        writer.endElement("li");
    }

}
