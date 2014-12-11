package org.foundationfaces.component.select;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesComponent(SelectBoolean.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class SelectBoolean extends HtmlSelectBooleanCheckbox {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".SelectBoolean";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".SelectBooleanRenderer";

    public static final String STYLE_CLASS = "switch";

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }

    protected enum PropertyKeys {

        label;
    }
}
