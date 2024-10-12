package Family_tree.human;

import Family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeNode<Human> {
    protected int  id;
    private Gender gender;
    private String name;
    private LocalDate birthDate, deathDate;
    private List<Human> parents,children ;
    private Human spouse;

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    // Напишите метод, который будет возвращать информацию о супруге (если супруг нет, верните "нет"

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, Gender gender) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
//        this.children = children;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
// Вызов конструктора с применением this означает, что идёт обращение к текущему конструктору.
    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, null, null, gender);        
    }

    public Human (String name, LocalDate birthDate, Human father, Human mother, Gender gender) {
        this(name, birthDate, null, father, mother, gender);   
    }

    public boolean addChild(Human child) {
        if(!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public boolean addParent(Human parent) {
        if(!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.female) {
                return parent;
            }
        }
        return null;
    }

//    @Override
//    public boolean addChild(Human human) {
//        return false;
//    }
//
//    @Override
//    public boolean addParent(Human human) {
//        return false;
//    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod (birthDate, LocalDate.now());
        } else {
            return getPeriod (birthDate, deathDate);
        }
    }

    private int getPeriod (LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

//    public Human getSpouse() {
//        return spouse;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }
//    public int getId() {
//        return id;
//    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public List<Human> getParents() {
        return parents;
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public Human getSpose() {
        return null;
    }

    @Override
    public void setSpose(Human human) {
    }
//    public LocalDate getDeathDate() {
//        return deathDate;
//    }

//    public List<Human> getChildren() {
//        return children;
//    }

//    public List<Human> getParents() {
//        return parents;
//    }

//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }

//    public void setDeathDate(LocalDate deathDate) {
//        this.deathDate = deathDate;
//    }

    public Gender getGender() {
        return gender;
    }

/*   public void setName(String name) {
        this.name = name;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setFather(Human father) {
        this.parents.add(father);
    }

    public void setMother(Human mother) {
        this.parents.add(mother);
    }

    public void setGender(Gender gender) {

        this.gender = gender;
    }
*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Object)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(",name: ");
        sb.append(name);
        sb.append(",gender: ");
        sb.append(getGender());
        sb.append(",ages: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSposeInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSposeInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            return res += spouse.getName();
        }
        return res;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

//    @Override
//    public Human getFather() {
//        return null;
//    }
//
//    @Override
//    public Human getMother() {
//        return null;
//    }

    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDathDate() {
        return null;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = null;
        mother = getMother();
        if (mother == null) {
            res += "нет";
        } else {
            return res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = null;
        father = getFather();
        if (father == null) {
            res += "нет";
        } else {
            return res += father.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("детей: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        } else {
            sb.append("нет детей");
        }
        return sb.toString();
    }






}
    
    
