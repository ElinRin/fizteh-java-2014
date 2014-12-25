package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTable;
import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class ExitCommand extends Commands {
    @Override
    public void execute(MyTableProvider base) {
        if (base.getUsing() == null || ((MyTable) base.getUsing()).unsavedChanges() == 0) {
            throw new IllegalMonitorStateException("Exit");
        } else {
            System.err.println(((MyTable) base.getUsing()).unsavedChanges() + "  unsaved changes");
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
