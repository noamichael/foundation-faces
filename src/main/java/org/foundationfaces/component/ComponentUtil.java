package org.foundationfaces.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.UISelectItems;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import org.foundationfaces.component.select.ExtendedSelectItem;
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

    public static List<SelectItem> getSelectItems(UIComponent component) {
        List<SelectItem> selectItems = new ArrayList<>();
        for (UIComponent kid : component.getChildren()) {
            if (kid instanceof UISelectItem) {
                UISelectItem uISelectItem = (UISelectItem) kid;
                selectItems.add(new ExtendedSelectItem(uISelectItem));
            } else if (kid instanceof UISelectItems) {
                UISelectItems uISelectItems = (UISelectItems) kid;
                Object abstractSelectItems = uISelectItems.getValue();
                if (abstractSelectItems instanceof Collection) {
                    selectItems.addAll((Collection<? extends SelectItem>) uISelectItems.getValue());
                } else if (abstractSelectItems instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) abstractSelectItems;
                    for (Map.Entry<?, ?> entry : map.entrySet()) {
                        selectItems.add(new ExtendedSelectItem(entry.getValue(), String.valueOf(entry.getKey())));
                    }
                }
            }
        }
        return selectItems;
    }
}
