package Family_tree.family_tree;

import java.util.Comparator;

public class FamilyTreeComparatorByName<E extends TreeNode<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
