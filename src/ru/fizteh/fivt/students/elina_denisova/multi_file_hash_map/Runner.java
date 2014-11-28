package ru.fizteh.fivt.students.elina_denisova.multi_file_hash_map;

public class Runner {
    public static void main(String[] args) throws Exception {

        try {
            String path = System.getProperty("fizteh.db.dir");
            if (path == null) {
                throw new NullPointerException("Runner: Directory doesn't exist");
            }
            TableProviderFactory base = new TableProviderFactory(path);


            if (args.length == 0) {
                    InteractiveParse.parse(base);
                } else {
                    PackageParse.parse(base, args);
                }
            } catch (NullPointerException e) {
                HandlerException.handler(e);
            } catch (Exception e) {
                HandlerException.handler("Runner: Unknown error", e);
            }
    }
}

