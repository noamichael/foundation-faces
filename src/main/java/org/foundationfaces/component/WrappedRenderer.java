package org.foundationfaces.component;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.render.Renderer;

/**
 * Partially delegates tasks to a default renderer.
 *
 * @author Michael
 */
public abstract class WrappedRenderer extends Renderer {

    @Override
    public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
        return getDefaultRenderer(context).getConvertedValue(context, component, submittedValue);
    }

    @Override
    public boolean getRendersChildren() {
        return getDefaultRenderer(FacesContext.getCurrentInstance()).getRendersChildren();
    }

    @Override
    public String convertClientId(FacesContext context, String clientId) {
        return getDefaultRenderer(context).convertClientId(context, clientId);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        getDefaultRenderer(context).encodeEnd(context, component);
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        getDefaultRenderer(context).encodeChildren(context, component);
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        getDefaultRenderer(context).encodeBegin(context, component);
    }

    @Override
    public void decode(FacesContext context, UIComponent component) {
        getDefaultRenderer(context).decode(context, component);
    }

    protected abstract Renderer getDefaultRenderer(FacesContext context);

}
