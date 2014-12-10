package org.foundationfaces.component.offcanvas;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;
import org.foundationfaces.component.Foundation;
import org.foundationfaces.component.Styled;

/**
 *
 * @author Michael
 */
@FacesComponent(OffCanvas.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class OffCanvas extends UIPanel implements Styled {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".OffCanvas";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".OffCanvasRenderer";

    public static final String OFF_CANVAS_WRAP_STYLE_CLASS = "off-canvas-wrap";
    public static final String INNER_WRAP_STYLE_CLASS = "inner-wrap";
    public static final String LEFT_SMALL_STYLE_CLASS = "left-small";
    public static final String RIGHT_SMALL_STYLE_CLASS = "right-small";
    public static final String LEFT_OFF_CANVAS_MENU_STYLE_CLASS = "left-off-canvas-menu";
    public static final String RIGHT_OFF_CANVAS_MENU_STYLE_CLASS = "right-off-canvas-menu";
    public static final String OFF_CANVAS_LIST_STYLE_CLASS = "off-canvas-list";
    public static final String MAIN_SECTION_STYLE_CLASS = "main-section";
    public static final String EXIT_OFF_CANVAS_STYLE_CLASS = "exit-off-canvas";
    public static final String TAB_BAR_STYLE_CLASS = "tab-bar";
    public static final String MIDDLE_TAB_BAR_SECTION = "middle tab-bar-section";

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
