package org.foundationfaces.component.tree;

import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

/**
 *
 * @author mkucinski
 */
public class TreeRenderer extends Renderer {
    
    @Override
    public boolean getRendersChildren() {
        return super.getRendersChildren();
    }
    
    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        Tree tree = (Tree) component;
        ResponseWriter writer = context.getResponseWriter();
        List<TreeNode> nodes = tree.getNodes();
        encodeTreeContainerStart(tree, writer);
        for (TreeNode node : nodes) {
            encodeNode(node, writer);
        }
        encodeTreeContainerEnd(tree, writer);
        
    }
    
    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        //I search for the children I support in encode end.
    }
    
    protected void encodeTreeContainerStart(Tree tree, ResponseWriter writer) throws IOException {
        writer.startElement("div", tree);
    }
    
    protected void encodeTreeContainerEnd(Tree tree, ResponseWriter writer) throws IOException {
        writer.endElement("div");
    }

    /**
     * Recursive kick-off
     *
     * @param node
     * @param writer
     */
    protected void encodeNodes(TreeNode<?> node, ResponseWriter writer) throws IOException {
        for (TreeNode child : node.getChildren()) {
            encodeNode(child, writer);
        }
    }

    /**
     * Encode from this node, down
     *
     * @param node
     * @param writer
     */
    protected void encodeNode(TreeNode node, ResponseWriter writer) throws IOException {
        //encode myself node

        //Then my children
        encodeNodes(node, writer);

        //end myself
    }
    
}
