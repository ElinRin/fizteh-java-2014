package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class DropCommand extends Commands {
    private String tableName;

    @Override
    public void execute(MyTableProvider base) {
        try {
            if (base.getTable(tableName) == base.getUsing()) {
                base.changeUsingTable(null);
            }
            base.removeTable(tableName);
            System.out.println("dropped");
        } catch (IllegalStateException e) {
            System.out.println(tableName + " not exists");
        }
    }

    protected final void putArguments(String[] args) {
        tableName = args[1];
    }

    protected final int numberOfArguments() {
        return 1;
    }
}
