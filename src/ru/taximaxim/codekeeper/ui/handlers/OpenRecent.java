package ru.taximaxim.codekeeper.ui.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuItem;

public class OpenRecent {
    private MMenuItem menuItem;

    @CanExecute
    public boolean canExecute(@Optional MMenuItem menuItem) {
        this.menuItem = menuItem;
        return menuItem != null;
    }

    @Execute
    public void execute() {
        System.out.println(menuItem.getLabel() + " called");
    }

}
