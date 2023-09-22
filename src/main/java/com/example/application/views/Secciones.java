package com.example.application.views;

import java.util.ArrayList;
import java.util.Map;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Secciones {

    public Section students(ArrayList<Map<String, String>> users) {
        Section section = new Section();
        section.setWidthFull();
        VerticalLayout vl = new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setWidthFull();

        H3 submodulo = new H3("Integrantes");
        vl.add(submodulo);

        HorizontalLayout hl = new HorizontalLayout();
        hl.setAlignItems(Alignment.CENTER);

        for (Map<String, String> user : users) {
            VerticalLayout vlp1 = new VerticalLayout();
            vlp1.setAlignItems(Alignment.CENTER);
            vlp1.add(new Image(user.get("image"), ""));
            vlp1.add(new H3(user.get("name")));
            hl.add(vlp1);
        }

        vl.add(hl);
        vl.add(new Hr());
        section.add(vl);
        return section;
    }

    public Section algoritmo(String titulo1, String titulo2, String descripcion, HorizontalLayout algoritmo,
            String gist,
            String replit, String diagrama) {
        Section section = new Section();
        section.setWidthFull();
        VerticalLayout vl = new VerticalLayout();
        vl.setAlignItems(Alignment.CENTER);
        vl.setWidthFull();
        vl.add(new H1(titulo1));
        vl.add(new H3(titulo2));
        vl.add(new Text(descripcion));
        algoritmo.setAlignItems(Alignment.CENTER);
        algoritmo.setWidthFull();
        algoritmo.getStyle().set("border", "1px solid");
        algoritmo.getStyle().set("border-radius", "10px");
        algoritmo.setPadding(true);
        vl.add(algoritmo);
        vl.add(new Div());

        Anchor link = new Anchor();
        link.setTarget("_blank<");
        link.setHref(replit);
        vl.add(link);
        link.add(new H2("Código Fuente"));

        IFrame iFrame = new IFrame();
        iFrame.setSrcdoc(gist);
        iFrame.setWidth("100%");
        iFrame.setHeight("500px");
        iFrame.setAllow("accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture");
        iFrame.getElement().setAttribute("allowfullscreen", true);
        iFrame.getElement().setAttribute("frameborder", "0");
        iFrame.getStyle().set("border-radius", "10px");
        vl.add(iFrame);

        vl.add(new Div());
        vl.add(new H2("Diagrama de flujo"));
        Image df = new Image(
                diagrama,
                "");
        df.setWidth("600px");
        df.getStyle().set("background-color", "white");
        vl.add(df);
        vl.add(new Hr());
        section.add(vl);
        return section;
    }

}
