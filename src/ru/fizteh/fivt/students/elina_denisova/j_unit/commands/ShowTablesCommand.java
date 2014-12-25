package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTable;
import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

import java.util.Map;

public class ShowTablesCommand extends Commands {
    @Override
    public void execute(MyTableProvider base) {
        for (Map.Entry<String, MyTable> entry: base.entrySet()) {
            String name = entry.getKey();

            int size = entry.getValue().size();
            System.out.println(name + " " + size);
        }
    }

    @Override
    protected int numberOfArguments() {
        return 1;
    }
}

