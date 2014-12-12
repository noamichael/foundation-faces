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
    @ResourceDependency(library = "javax.faces", name = "jsf.js"),
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

    /**
     * @return the small
     */
    public String getSmall() {
        return (String) getStateHelper().eval(PropertyKeys.small, "2");
    }

    /**
     * @param small the small to set
     */
    public void setSmall(String small) {
        getStateHelper().put(PropertyKeys.small, small);
    }

    /**
     * @return the medium
     */
    public String getMedium() {
        return (String) getStateHelper().eval(PropertyKeys.medium, "4");
    }

    /**
     * @param medium the medium to set
     */
    public void setMedium(String medium) {
        getStateHelper().put(PropertyKeys.medium, medium);
    }

    /**
     * @return the large
     */
    public String getLarge() {
        return (String) getStateHelper().eval(PropertyKeys.large, "6");
    }

    /**
     * @param large the large to set
     */
    public void setLarge(String large) {
        getStateHelper().put(PropertyKeys.large, large);
    }

    public String getColumnStyleClasses() {
        String small = "small-" + getSmall();
        String medium = "medium-" + getMedium();
        String large = "large-" + getLarge();
        return "columns" + " " + small + " " + medium + " " + large + " ";
    }

    protected enum PropertyKeys {

        containerStyleClass, small, medium, large;
    }

}
