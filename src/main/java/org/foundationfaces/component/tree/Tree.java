package org.foundationfaces.component.tree;

import java.util.Collections;
import java.util.List;
import javax.faces.component.UINamingContainer;

/**
 *
 * @author mkucinski
 */
public class Tree extends UINamingContainer {
    
    public static final String STYLE_CLASS = "foundation-tree";

    /**
     * @return the nodes
     */
    public List<TreeNode> getNodes() {
        return (List<TreeNode>) getStateHelper().eval(PropertyKeys.value, Collections.<TreeNode>emptyList());
    }

    /**
     * @param nodes the nodes to set
     */
    public void setNodes(List<TreeNode> nodes) {
        getStateHelper().put(PropertyKeys.value, nodes);
    }

    /**
     * @return the responsive
     */
    public boolean isResponsive() {
        return (boolean) getStateHelper().eval(PropertyKeys.value, true);
    }

    /**
     * @param responsive the responsive to set
     */
    public void setResponsive(boolean responsive) {
        getStateHelper().put(PropertyKeys.responsive, responsive);
    }

    /**
     * @return the type
     */
    public String getType() {
        return (String) getStateHelper().eval(PropertyKeys.type, "side-nav");
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        getStateHelper().put(PropertyKeys.type, type);
    }
    
    protected enum PropertyKeys {
        
        value, responsive, type;
    }
}
