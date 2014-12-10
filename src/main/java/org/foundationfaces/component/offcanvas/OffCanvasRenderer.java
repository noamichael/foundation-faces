package org.foundationfaces.component.offcanvas;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

/**
 *
 * @author Michael
 */
@FacesRenderer(componentFamily = OffCanvas.COMPONENT_FAMILY, rendererType = OffCanvas.MY_RENDERER_TYPE)
public class OffCanvasRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        OffCanvas offCanvas = (OffCanvas) component;
        encodeCanvasStart(context, offCanvas, writer);
        encodeTabBar(context, offCanvas, writer);
        encodeLeftMenu(context, offCanvas, writer);
        encodeRightMenu(context, offCanvas, writer);
        encodeMainSection(context, offCanvas, writer);
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        OffCanvas offCanvas = (OffCanvas) component;
        encodeCanvasEnd(context, offCanvas, writer);
    }

    protected void encodeCanvasStart(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.startElement("div", offCanvas);
        writer.writeAttribute("data-offcanvas", "data-offcanvas", null);
        writer.writeAttribute("class", OffCanvas.OFF_CANVAS_WRAP_STYLE_CLASS, null);
        writer.startElement("div", null);
        writer.writeAttribute("class", OffCanvas.INNER_WRAP_STYLE_CLASS, null);

    }

    protected void encodeLeftMenu(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.startElement("aside", null);
        writer.writeAttribute("class", OffCanvas.LEFT_OFF_CANVAS_MENU_STYLE_CLASS, null);
        encodeMenuList(context, offCanvas, writer, "left-menu");
        writer.endElement("aside");
    }

    protected void encodeRightMenu(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.startElement("aside", null);
        writer.writeAttribute("class", OffCanvas.RIGHT_OFF_CANVAS_MENU_STYLE_CLASS, null);
        encodeMenuList(context, offCanvas, writer, "right-menu");
        writer.endElement("aside");
    }

    protected void encodeMainSection(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.startElement("section", null);
        writer.writeAttribute("class", OffCanvas.MAIN_SECTION_STYLE_CLASS, null);
    }

    protected void encodeTabBar(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.startElement("nav", null);
        writer.writeAttribute("class", OffCanvas.TAB_BAR_STYLE_CLASS, null);
        encodeLeftTabMenu(context, offCanvas, writer);
        encodeMiddleTabMenu(context, offCanvas, writer);
        encodeRightTabMenu(context, offCanvas, writer);
        writer.endElement("nav");
    }

    protected void encodeLeftTabMenu(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        encodeTabSection(context, offCanvas, writer, OffCanvas.LEFT_TAB_BAR_SECTION, "tab-left");
    }

    protected void encodeMiddleTabMenu(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        encodeTabSection(context, offCanvas, writer, OffCanvas.MIDDLE_TAB_BAR_SECTION, "tab-middle");
    }

    protected void encodeRightTabMenu(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        encodeTabSection(context, offCanvas, writer, OffCanvas.RIGHT_TAB_BAR_SECTION_STYLE_CLASS, "tab-right");
    }

    protected void encodeCanvasEnd(FacesContext context, OffCanvas offCanvas, ResponseWriter writer) throws IOException {
        writer.write("<a class=\"exit-off-canvas\"></a>");
        writer.endElement("section");
        writer.endElement("div");
        writer.endElement("div");
    }

    protected void encodeMenuList(FacesContext context, OffCanvas offCanvas, ResponseWriter writer, String facetName) throws IOException {
        UIComponent menuList = offCanvas.getFacet(facetName);
        if (menuList != null) {
            writer.startElement("ul", menuList);
            writer.writeAttribute("class", OffCanvas.OFF_CANVAS_LIST_STYLE_CLASS, null);
            menuList.encodeAll(context);
            writer.endElement("ul");
        }
    }

    protected void encodeTabSection(FacesContext context,
            OffCanvas offCanvas,
            ResponseWriter writer,
            String styleClass,
            String facetName) throws IOException {
        UIComponent facet = offCanvas.getFacet(facetName);
        if (facet != null) {
            writer.startElement("div", facet);
            writer.writeAttribute("class", styleClass, null);
            facet.encodeAll(context);
            writer.endElement("div");
        }
    }
}
