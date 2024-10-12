package Family_tree.family_tree;
import Family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int humansId;
    public List<E> humanList;
    
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public void addElement(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
        }
    }
    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getSiblings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWeedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpose() == null && human2.getSpose() == null) {
                human1.setSpose(human2);
                human2.setSpose(human1);
            } else {
                return false;
            }

        }
        return false;
    }

    public boolean setDivorce(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpose() != null && human2.getSpose() != null) {
                human1.setSpose(null);
                human2.setSpose(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(int humansId) {
        if (checkId(humansId)) {
            E human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }
    
    private boolean checkId(int id) {
        return id < humansId && id >= 0;
    }

    private E getById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void removeHuman(Human human) {
        humanList.remove(human);
    }

   
    @Override
    public String toString() {
        return getInfo();
    }
    
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByBirthDate(){
        humanList.sort(new FamilyTreeComporatorByBirthDate<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }

}
