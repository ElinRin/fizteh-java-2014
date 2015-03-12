package ru.fizteh.fivt.students.elina_denisova.j_unit;

public class Runner {
    public static void main(String[] args) {

        try {
            String path = System.getProperty("fizteh.db.dir");
            if (path == null) {
                throw new IllegalArgumentException("Directory doesn't exist");
            }
            MyTableProviderFactory factory = new MyTableProviderFactory();
            MyTableProvider base = factory.create(path);


            if (args.length == 0) {
                InteractiveParse.parse(base);
            } else {
                PackageParse.parse(base, args);
            }
        } catch (IllegalArgumentException e) {
            HandlerException.handler(e);
        }
    }

}

