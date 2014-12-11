package org.foundationfaces.component.button;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlCommandButton;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesComponent(CommandButton.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class CommandButton extends HtmlCommandButton {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".CommandButton";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".CommandButtonRenderer";

    public static final String STYLE_CLASS = "button";

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }
}
