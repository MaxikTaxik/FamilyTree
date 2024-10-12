package Family_tree.family_tree;

import Family_tree.human.Human;

import java.util.Comparator;

public class FamilyTreeComporatorByBirthDate <E extends TreeNode<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
