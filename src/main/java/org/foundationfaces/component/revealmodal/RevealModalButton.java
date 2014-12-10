package org.foundationfaces.component.revealmodal;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.Styled;

/**
 *
 * @author Michael
 */
@FacesComponent(RevealModalButton.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class RevealModalButton extends UIOutput implements Styled {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".RevealModalButton";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".RevealModalButtonRenderer";

    private String dataRevealId;
    private String styleClass;
    private String style;
    private String label;

    @Override
    public String getFamily() {
        return Foundation.COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return MY_RENDERER_TYPE;
    }

    /**
     * @return the dataRevealId
     */
    public String getDataRevealId() {
        return dataRevealId;
    }

    /**
     * @param dataRevealId the dataRevealId to set
     */
    public void setDataRevealId(String dataRevealId) {
        this.dataRevealId = dataRevealId;
    }

    /**
     * @return the styleClass
     */
    @Override
    public String getStyleClass() {
        return styleClass;
    }

    /**
     * @param styleClass the styleClass to set
     */
    @Override
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    /**
     * @return the style
     */
    @Override
    public String getStyle() {
        return style;
    }

    /**
     * @param style the style to set
     */
    @Override
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
