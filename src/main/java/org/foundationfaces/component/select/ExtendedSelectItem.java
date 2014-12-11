package org.foundationfaces.component.select;

import javax.faces.component.UISelectItem;
import javax.faces.model.SelectItem;

/**
 * A syntactically wonderful {@link SelectItem}
 *
 * @author Michael
 */
public class ExtendedSelectItem extends SelectItem {

    public ExtendedSelectItem() {
    }

    public ExtendedSelectItem(UISelectItem selectItem) {
        this(
                selectItem.getItemValue(),
                selectItem.getItemLabel(),
                selectItem.getItemDescription(),
                selectItem.isItemDisabled(),
                selectItem.isItemEscaped(),
                selectItem.isNoSelectionOption());
    }

    public ExtendedSelectItem(Object value) {
        super(value);
    }

    public ExtendedSelectItem(Object value, String label) {
        super(value, label);
    }

    public ExtendedSelectItem(Object value, String label, String description) {
        super(value, label, description);
    }

    public ExtendedSelectItem(Object value, String label, String description, boolean disabled) {
        super(value, label, description, disabled);
    }

    public ExtendedSelectItem(Object value, String label, String description, boolean disabled, boolean escape) {
        super(value, label, description, disabled, escape);
    }

    public ExtendedSelectItem(Object value, String label, String description, boolean disabled, boolean escape, boolean noSelectionOption) {
        super(value, label, description, disabled, escape, noSelectionOption);
    }

}
