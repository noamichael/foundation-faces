package org.foundationfaces.component;

import java.io.IOException;
import javax.faces.context.ResponseWriter;
import org.foundationfaces.util.StringUtil;

/**
 *
 * @author Michael
 */
public final class ComponentUtil {

    public static void encodeStyledComponent(Styled styled, String defaultStyleClass, ResponseWriter writer) throws IOException {
        String style = styled.getStyle();
        String styleClass = styled.getStyleClass();
        if (!StringUtil.isNullOrEmpty(style)) {
            writer.writeAttribute("style", style, null);
        }
        if (!StringUtil.isNullOrEmpty(styleClass)) {
            writer.writeAttribute("class", defaultStyleClass + " " + styleClass, null);
        } else if (!StringUtil.isNullOrEmpty(defaultStyleClass)) {
            writer.writeAttribute("class", defaultStyleClass, null);
        }
    }
}
