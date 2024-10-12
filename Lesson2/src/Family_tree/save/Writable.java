package Family_tree.save;

import java.io.Serializable;

public interface Writable {
    boolean save(Serializable tree, String path);
    Object read (String path); 
}
