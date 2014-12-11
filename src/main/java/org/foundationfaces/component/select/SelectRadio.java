package org.foundationfaces.component.select;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.html.HtmlSelectOneRadio;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesComponent(SelectRadio.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class SelectRadio extends HtmlSelectOneRadio {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".SelectRadio";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".SelectRadioRenderer";

    public static final String STYLE_CLASS = "switch";

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }

    /**
     * @return the containerStyleClass
     */
    public String getContainerStyleClass() {
        return (String) getStateHelper().get(PropertyKeys.containerStyleClass);
    }

    /**
     * @param containerStyleClass the containerStyleClass to set
     */
    public void setContainerStyleClass(String containerStyleClass) {
        getStateHelper().put(PropertyKeys.containerStyleClass, containerStyleClass);
    }

    protected enum PropertyKeys {

        containerStyleClass;
    }

}
