package ru.fizteh.fivt.students.elina_denisova.j_unit;

import ru.fizteh.fivt.students.elina_denisova.j_unit.commands.Commands;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PackageParse {
    public static void parse(MyTableProvider directory, String[] arg) {
        try {
            ArrayList<String> current = new ArrayList<String>();
            for (int i = 0; i < arg.length; ++i) {
                current.clear();
                while (i < arg.length) {
                    if (!(arg[i].contains(";"))) {
                        current.add(arg[i]);
                        i++;
                    } else {
                        current.add(arg[i].substring(0, arg[i].indexOf(";")));
                        break;
                    }
                }
                if (current.size() == 0) {
                    return;
                }
                String[] com = new String[current.size()];
                com = current.toArray(com);
                try {
                    Commands command = Commands.fromString(com);
                    command.execute(directory);
                } catch (NoSuchElementException e) {
                    System.err.println(e.getMessage());
                }
            }
            directory.getUsing().commit();
        } catch (IllegalMonitorStateException e) {
            System.out.println("Goodbye");
            System.exit(0);
        } catch (IllegalArgumentException e) {
            HandlerException.handler("PackageParse: Wrong arguments", e);
        } catch (Exception e) {
            HandlerException.handler("PackageParse: ", e);
        }
    }
}
