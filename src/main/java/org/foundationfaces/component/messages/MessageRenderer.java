package org.foundationfaces.component.messages;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
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
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = Message.MY_RENDERER_TYPE)
public class MessageRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        Message message = (Message) component;
        UIForm parentForm = ComponentUtil.getForm(component);
        if (parentForm != null) {
            String forComponentId = message.getFor();
            UIComponent forComponent = parentForm.findComponent(forComponentId);
            if (forComponent != null) {
                ResponseWriter writer = context.getResponseWriter();
                writer.startElement("div", component);
                writer.writeAttribute("class", "message-container", null);
                Iterator<FacesMessage> messageForComponent = context.getMessages((forComponent.getClientId(context)));
                int i = 0;
                while (messageForComponent.hasNext()) {
                    FacesMessage facesMessage = messageForComponent.next();
                    encodeSingleMessage(context, message, facesMessage, writer, i);
                    messageForComponent.remove();
                    i++;
                }
                writer.endElement("div");
            }
        }
    }

    protected void encodeSingleMessage(FacesContext context,
            Message message,
            FacesMessage facesMessage,
            ResponseWriter writer, int i) throws IOException {
        writer.startElement("div", null);
        String styleClass = message.getStyleClass();
        if (StringUtil.isNullOrEmpty(styleClass)) {
            styleClass = Message.STYLE_CLASS + " " + Message.getStyleForMessage(facesMessage);
        } else {
            styleClass = Message.STYLE_CLASS + " " + Message.getStyleForMessage(facesMessage) + " " + styleClass;
        }
        writer.writeAttribute("class", styleClass, null);
        writer.writeAttribute("data-alert", "data-alert", null);
        if (message.getStyle() != null) {
            writer.writeAttribute("style", message.getStyle(), null);
        }
        writer.writeAttribute("id", message.getClientId(context) + ":" + i, styleClass);
        String errorMessage = facesMessage.getSummary();
        writer.write(errorMessage);
        if (message.isCloseable()) {
            writer.write("<a href=\"#\" class=\"close\">&times;</a>");
        }
        writer.endElement("div");

    }

}
