package org.foundationfaces.component.button;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.WrappedRenderer;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = Foundation.COMPONENT_FAMILY, rendererType = CommandButton.MY_RENDERER_TYPE)
public class CommandButtonRenderer extends WrappedRenderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        CommandButton button = (CommandButton) component;
        String styleClasses = button.getStyleClass();
        if (styleClasses == null) {
            styleClasses = "";
        } else {
            styleClasses += " ";
        }
        button.setStyleClass(styleClasses + CommandButton.STYLE_CLASS);
        getDefaultRenderer(context).encodeBegin(context, button);
    }

    @Override
    protected Renderer getDefaultRenderer(FacesContext context) {
        return context.getRenderKit()
                .getRenderer(HtmlCommandButton.COMPONENT_FAMILY,
                        "javax.faces.Button");
    }

}
