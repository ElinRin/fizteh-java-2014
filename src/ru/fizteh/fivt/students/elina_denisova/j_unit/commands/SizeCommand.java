package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class SizeCommand extends Commands {
    @Override
    public void execute(MyTableProvider base) {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            System.out.println(base.getUsing().size());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
