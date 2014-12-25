package ru.fizteh.fivt.students.elina_denisova.j_unit.commands;

import ru.fizteh.fivt.students.elina_denisova.j_unit.MyTableProvider;

import java.util.HashMap;
import java.util.NoSuchElementException;

public abstract class Commands {
    private static final HashMap<String, Commands> COMMANDS;

    static {
        COMMANDS = new HashMap<>();
        COMMANDS.put("create", new CreateCommand());
        COMMANDS.put("drop", new DropCommand());
        COMMANDS.put("use", new UseCommand());
        COMMANDS.put("show_tables", new ShowTablesCommand());
        COMMANDS.put("put", new PutCommand());
        COMMANDS.put("get", new GetCommand());
        COMMANDS.put("remove", new RemoveCommand());
        COMMANDS.put("list", new ListCommand());
        COMMANDS.put("exit", new ExitCommand());
        COMMANDS.put("commit", new CommitCommand());
        COMMANDS.put("rollback", new RollbackCommand());
        COMMANDS.put("size", new SizeCommand());
    }

    public static Commands fromString(String[] s) throws Exception {
        if (s[0].equals("")) {
            throw new NoSuchElementException("");
        }
        if (s[0].equals("show")) {
            s[0] += "_" + s[1];
        }

        if (COMMANDS.containsKey(s[0])) {
            Commands command = COMMANDS.get(s[0]);
            if (s.length - 1 != command.numberOfArguments()) {
                throw new NoSuchElementException("Unexpected number of arguments: "
                        + command.numberOfArguments() + " required");
            }
            command.putArguments(s);
            return command;
        } else {
            throw new NoSuchElementException(s[0] + " is unknown command");
        }
    }

    public abstract void execute(MyTableProvider provider);
    protected void putArguments(String[] args) {
    }
    protected abstract int numberOfArguments();
}
