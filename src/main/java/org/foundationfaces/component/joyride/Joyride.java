package org.foundationfaces.component.joyride;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIPanel;
import org.foundationfaces.component.Foundation;

/**
 *
 * @author Michael
 */
@FacesComponent(Joyride.MY_COMPONENT_TYPE)
@ResourceDependencies({
    @ResourceDependency(name = "/foundationfaces/css/foundation.min.css"),
    @ResourceDependency(name = "/foundationfaces/css/normalize.css"),
    @ResourceDependency(name = "/foundationfaces/js/vendor/jquery.js"),
    @ResourceDependency(name = "/foundationfaces/js/foundation.min.js")
})
public class Joyride extends UIPanel {

    public static final String MY_COMPONENT_TYPE = Foundation.COMPONENT_FAMILY + ".Joyride";
    public static final String MY_RENDERER_TYPE = Foundation.RENDERER_TYPE + ".JoyrideRenderer";
    
    public static final String STYLE_CLASS = "joyride-list";

}
