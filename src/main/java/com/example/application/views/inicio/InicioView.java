package com.example.application.views.inicio;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Inicio")
@Route(value = "inicio", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class InicioView extends VerticalLayout {   

    public InicioView() {

        getStyle().set("background-position", "center");
        getStyle().set("background-repeat", "no-repeat");
        getStyle().set("background-size", "cover");
        getStyle().set("background",
                "url(https://images.unsplash.com/photo-1532190872407-280735d27e08?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80)");
               
        setAlignItems(Alignment.CENTER);
        setSizeFull();

        add(headerPage());
        add(video());
    }

    private Section headerPage() {
        Section section = new Section();
        section.setWidthFull();
        VerticalLayout vl = new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setWidthFull();
        H1 titulo = new H1("Proyecto Integrador");
        titulo.getStyle().set("color", "white");
        H3 submodulo = new H3("Lógica de Programación");
        submodulo.getStyle().set("color", "white");
        H3 nivel = new H3("Docente: Jhon Fredy Valencia Gómez");
        nivel.getStyle().set("color", "white");
        vl.add(titulo);
        vl.add(submodulo);
        vl.add(nivel);
        Hr divider = new Hr();
        vl.add(divider);
        section.add(vl);
        return section;
    }

    private Section video() {
        Section section = new Section();
        section.setWidthFull();
        VerticalLayout vl = new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setWidthFull();
        IFrame iFrame = new IFrame("https://www.youtube.com/embed/dQw4w9WgXcQ");
        iFrame.setHeight("315px");
        iFrame.setWidth("560px");
        iFrame.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        iFrame.getElement().setAttribute("allowfullscreen", true);
        iFrame.getElement().setAttribute("frameborder", "0");
        iFrame.getStyle().set("border-radius", "10px");
        vl.add(iFrame);
        section.add(vl);
        return section;
    }

}
