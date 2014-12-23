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
    private String outcome;
    private T data;


    @SuppressWarnings("LeakingThisInConstructor")
    public Node(Node parent, String label, String outcome) {
        this.parent = parent;
        this.label = label;
        this.outcome = outcome;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setData(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
