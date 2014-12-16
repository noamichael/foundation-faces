package org.foundationfaces.component.messages;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlMessage;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.Styled;

/**
 *
 * @author Michael
 */
@FacesComponent(Message.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class Message extends HtmlMessage implements Styled{

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".Message";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".MessageRenderer";

    public static final String STYLE_CLASS = "alert-box";
    public static final String SUCCESS = "success";
    public static final String WARNING = "warning";
    public static final String INFO = "info";
    public static final String ALERT = "alert";

    /**
     * @return the closeable
     */
    public boolean isCloseable() {
        return (boolean) getStateHelper().eval(PropertyKeys.closeable, false);
    }

    /**
     * @param closeable the closeable to set
     */
    public void setCloseable(boolean closeable) {
        getStateHelper().put(PropertyKeys.closeable, closeable);
    }

    public static String getStyleForMessage(FacesMessage message) {
        Severity severity = message.getSeverity();
        if (FacesMessage.SEVERITY_INFO.equals(severity)) {
            return INFO;
        } else if (FacesMessage.SEVERITY_WARN.equals(severity)) {
            return WARNING;
        } else if (FacesMessage.SEVERITY_ERROR.equals(severity)) {
            return ALERT;
        } else if (FacesMessage.SEVERITY_FATAL.equals(severity)) {
            return ALERT;
        }
        return "";
    }

    protected enum PropertyKeys {

        closeable, component;
    }

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }
}
