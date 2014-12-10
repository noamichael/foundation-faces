package org.foundationfaces.component.panel;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.Styled;
import static org.foundationfaces.component.panel.Panel.MY_COMPONENT_TYPE;

/**
 *
 * @author MKucinski
 */
@FacesComponent(MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class Panel extends UIPanel implements Styled {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".Panel";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".PanelRenderer";
    public static final String STYLE_CLASS = "panel";
    public static final String HEADER_STYLE_CLASS = "foundation-panel-header";

    private String header;
    private String styleClass;
    private String style;

    /**
     * @return the header
     */
    public String getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(String header) {
        this.header = header;
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

}
