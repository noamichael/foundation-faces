package org.foundationfaces.component.messages;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = Messages.MY_RENDERER_TYPE)
public class MessagesRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        Messages messagesComponent = (Messages) component;
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", component);
        writer.writeAttribute("class", "message-container", null);
        Iterator<FacesMessage> messages = messagesComponent.isGlobalOnly() ? context.getMessages(null) : context.getMessages();
        int i = 0;
        while (messages.hasNext()) {
            FacesMessage facesMessage = messages.next();
            encodeSingleMessage(context, messagesComponent, facesMessage, writer, i);
            messages.remove();
            i++;
        }
        writer.endElement("div");
    }

    protected void encodeSingleMessage(FacesContext context,
            Messages messages,
            FacesMessage facesMessage,
            ResponseWriter writer, int i) throws IOException {
        writer.startElement("div", null);
        String styleClass = messages.getStyleClass();
        if (StringUtil.isNullOrEmpty(styleClass)) {
            styleClass = Messages.STYLE_CLASS + " " + messages.getStyleForMessage(facesMessage);
        } else {
            styleClass = Messages.STYLE_CLASS + " " + messages.getStyleForMessage(facesMessage) + " " + styleClass;
        }
        writer.writeAttribute("class", styleClass, null);
        writer.writeAttribute("data-alert", "data-alert", null);
        if (messages.getStyle() != null) {
            writer.writeAttribute("style", messages.getStyle(), null);
        }
        writer.writeAttribute("id", messages.getClientId(context) + ":" + i, styleClass);
        String errorMessage = facesMessage.getSummary();
        writer.write(errorMessage);
        if (messages.isCloseable()) {
            writer.write("<a href=\"#\" class=\"close\">&times;</a>");
        }
        writer.endElement("div");

    }

}
