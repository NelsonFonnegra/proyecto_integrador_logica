package com.example.application.views;

import com.example.application.views.grupo1.Grupo1View;
import com.example.application.views.grupo2.Grupo2View;
import com.example.application.views.grupo3.Grupo3View;
import com.example.application.views.grupo4.Grupo4View;
import com.example.application.views.grupo5.Grupo5View;
import com.example.application.views.grupo6.Grupo6View;
import com.example.application.views.grupo7.Grupo7View;
import com.example.application.views.grupo8.Grupo8View;
import com.example.application.views.grupo9.Grupo9View;
import com.example.application.views.grupo10.Grupo10View;

import com.example.application.views.inicio.InicioView;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;
    Scroller scroller;

    public MainLayout() {

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Proyecto Integrador");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Inicio", InicioView.class, LineAwesomeIcon.HOME_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 1", Grupo1View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 2", Grupo2View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 3", Grupo3View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 4", Grupo4View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 5", Grupo5View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 6", Grupo6View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 7", Grupo7View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 8", Grupo8View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 9", Grupo9View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));
        nav.addItem(new SideNavItem("Grupo 10", Grupo10View.class, LineAwesomeIcon.CHEVRON_CIRCLE_RIGHT_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

    @Override
    public void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        UI.getCurrent().getPage().executeJs("window.scrollTo(0,0);");
        System.out.println("ok");
    }

}
