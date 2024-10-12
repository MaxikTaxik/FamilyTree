import Family_tree.family_tree.FamilyTree;
import Family_tree.family_tree.TreeNode;
import Family_tree.human.Gender;
import Family_tree.human.Human;
import Family_tree.save.FileHandler;
import Family_tree.save.Writable;

import java.time.LocalDate;



public class Main {
    public static void main(String[] args) {
        String filPath = "text.txt";
        FamilyTree<Human> tree = testTree();
//        FamilyTree<Human> tree = load(filPath);
        System.out.print(tree);
        // save(tree, filPath);
    }

    private static FamilyTree<Human> load(String filPath) {
        Writable writable = new FileHandler();
        return (FamilyTree<Human>) writable.read(filPath);
    }

    private static void save(FamilyTree<Human> tree, String filPath) {
        Writable writable = new FileHandler();
        writable.save(tree, filPath);
    }

    private static FamilyTree<Human> testTree() {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Human father = new Human("Victor", LocalDate.of(1961, 12, 19), null, null, Gender.male);
        Human mother = new Human("Evgehiya", LocalDate.of(1964, 4, 7), LocalDate.of(2005, 12, 18), null, null, Gender.female);
        Human me = new Human("Maksim", LocalDate.of(1985, 4, 19), mother, father, Gender.male);
        Human brother = new Human("Oleg", LocalDate.of(1984, 4, 30), father, mother, Gender.male);

        familyTree.addElement(me);
        familyTree.addElement(brother);
        familyTree.addElement(father);
        familyTree.addElement(mother);



        return familyTree;
    }
}
