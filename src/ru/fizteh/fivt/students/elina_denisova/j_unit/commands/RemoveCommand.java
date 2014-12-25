package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class RemoveCommand extends Commands {

    private String key;

    @Override
    public void execute(MyTableProvider base) {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            String result = base.getUsing().remove(key);
            if (result != null) {
                System.out.println("removed");
            } else {
                System.out.println("not found");
            }
        }
    }

    protected final void putArguments(String[] args) {
        key = args[1];
    }

    @Override
    protected int numberOfArguments() {
        return 1;
    }
}

