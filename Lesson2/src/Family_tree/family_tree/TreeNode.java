package Family_tree.family_tree;

import Family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable {
    void setId (int id);
    int getId();
    T getFather();
    T getMother();
//    boolean addChild(T human);
//    boolean addParent(T human);

    boolean addChild(T human);

    boolean addParent(T human);

    String getName();
    LocalDate getDathDate();
    LocalDate getBirthDate();
    abstract List<T> getParents();
    List<T> getChildren();
    T getSpose();
    void setSpose(T human);
}
