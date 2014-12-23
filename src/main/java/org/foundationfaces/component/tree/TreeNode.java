package org.foundationfaces.component.tree;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author mkucinski
 * @param <T>
 */
public interface TreeNode<T> extends Serializable {

    TreeNode<T> getParent();

    void setParent(TreeNode<T> parent);

    List<TreeNode<T>> getChildren();

    void setChildren(List<TreeNode<T>> children);

    T getData();

    void setData(T data);
    
    public boolean isRoot();
}
