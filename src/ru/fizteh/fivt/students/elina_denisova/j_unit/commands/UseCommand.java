package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTable;
import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class UseCommand extends Commands {

    String tableName;

    @Override
    public void execute(MyTableProvider base) {
        if (base.getUsing() != null && ((MyTable) base.getUsing()).unsavedChanges() != 0) {
            System.out.println(((MyTable) base.getUsing()).unsavedChanges() + " unsaved changes");
        } else {
            if (base.getTable(tableName) == null) {
                System.out.println(tableName + " not exists");
            } else {
                base.changeUsingTable(tableName);
                System.out.println("using " + tableName);
            }
        }
    }

    @Override
    protected int numberOfArguments() {
        return 1;
    }

    @Override
    protected void putArguments(String[] args) {
        tableName = args[1];
    }
}
