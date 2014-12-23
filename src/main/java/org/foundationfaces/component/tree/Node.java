package org.foundationfaces.component.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michael
 */
public class Node<T> implements TreeNode<T> {

    private List<TreeNode<T>> children = new ArrayList();
    private TreeNode<T> parent;
    private String label;
    private T data;

    @SuppressWarnings("LeakingThisInConstructor")
    public Node(Node parent, String label) {
        this.parent = parent;
        this.label = label;
        this.parent.getChildren().add(this);
    }

    @Override
    public boolean isRoot() {
        return parent == null;
    }

    @Override
    public TreeNode<T> getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public List<TreeNode<T>> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the label
     */
    @Override
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    @Override
    public void setLabel(String label) {
        this.label = label;
    }
}
