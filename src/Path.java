import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;

public class Path {
    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
        if (newPath.startsWith("/")) {
            path = newPath;
            return;
        }

        String[] paths = path.split("/");
        ArrayDeque<String> deq = new ArrayDeque<>(Arrays.asList(paths));
        String[] newPaths = newPath.split("/");
        for (int i = 0; i < newPaths.length; i++) {
            if (newPaths[i].equals("..")) {
                String last = deq.pollLast();
            } else
                deq.offerLast(newPaths[i]);
        }

        if (!deq.peekFirst().equals(""))
            deq.offerFirst("");

        Iterator<String> it = deq.iterator();
        StringJoiner sj = new StringJoiner("/");
        while(it.hasNext())
            sj.add(it.next());

        path = sj.toString();
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../x");
        System.out.println(path.getPath()); // /a/b/c/x

        path = new Path("/a/b/c/d");
        path.cd("x/y");
        System.out.println(path.getPath()); // /a/b/c/d/x/y

        path = new Path("/a/b");
        path.cd("../../../../x/y");
        System.out.println(path.getPath()); // /x/y

        path = new Path("/a/b/c");
        path.cd("/x/y");
        System.out.println(path.getPath()); // /x/y
    }
}
