package org.foundationfaces.component.messages;

import javax.faces.application.FacesMessage;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIMessages;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.Styled;

/**
 *
 * @author Michael
 */
@FacesComponent(Messages.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class Messages extends UIMessages implements Styled {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".Messages";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".MessagesRenderer";

    public static final String STYLE_CLASS = "alert-box";
    public static final String SUCCESS = "success";
    public static final String WARNING = "warning";
    public static final String INFO = "info";
    public static final String ALERT = "alert";

    public String getStyleForMessage(FacesMessage message) {
        return Message.getStyleForMessage(message);
    }

    @Override
    public String getStyleClass() {
        return (String) getStateHelper().eval(PropertyKeys.styleClass);
    }

    @Override
    public void setStyleClass(String styleClass) {
        getStateHelper().put(PropertyKeys.styleClass, styleClass);
    }

    @Override
    public String getStyle() {
        return (String) getStateHelper().eval(PropertyKeys.style);
    }

    @Override
    public void setStyle(String style) {
        getStateHelper().put(PropertyKeys.style, style);
    }

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }

    /**
     * @return the closeable
     */
    public boolean isCloseable() {
        return (boolean) getStateHelper().eval(Message.PropertyKeys.closeable, false);
    }

    /**
     * @param closeable the closeable to set
     */
    public void setCloseable(boolean closeable) {
        getStateHelper().put(Message.PropertyKeys.closeable, closeable);
    }

    protected enum PropertyKeys {

        style, styleClass, closeable;
    }
}
