package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

public class PutCommand extends Commands {

    private String key;
    private String value;

    @Override
    public void execute(MyTableProvider base) {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            String result = base.getUsing().put(key, value);
            if (result == null) {
                System.out.println("new");
            } else {
                System.out.println("overwrite");
                System.out.println(result);
            }
        }
    }

    @Override
    protected int numberOfArguments() {
        return 2;
    }

    @Override
    protected void putArguments(String[] args) {
        key = args[1];
        value = args[2];
    }
}

