package org.foundationfaces.component.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Node implements Serializable {

    private List<Node> children = new ArrayList();
    private Node parent;
    private String label;
    private String outcome;

    public Node() {
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public Node(Node parent, String label, String outcome) {
        this.parent = parent;
        this.label = label;
        this.outcome = outcome;
        this.parent.children.add(this);
    }

    /**
     * @return the children
     */
    public List<Node> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Node> children) {
        this.children = children;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Node parent) {
        this.parent = parent;
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

    /**
     * @return the outcome
     */
    public String getOutcome() {
        return outcome;
    }

    /**
     * @param outcome the outcome to set
     */
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
