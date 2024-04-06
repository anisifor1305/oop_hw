import java.util.ArrayList;
import java.util.List;

public class Person extends TreeNode implements Finder{

    private List<Person> children = new ArrayList<>();
    private List<Person> parents = new ArrayList<>();
    enum Sex {MALE, FEMALE}
    private Sex sex;

    public Person(String name, String surname, Sex sex, Person parent){
        this.setName(name);
        this.setSurname(surname);
        this.sex = sex;
        if (checkParent(parent))
        {
            this.parents.add(parent);
            parent.children.add(this);
        }

    }

    public String getSex(){
        return String.valueOf(this.sex);
    }

    private boolean checkParent(Person persona){
        return persona != null;
    }

    @Override
    public List<Person> getParents() {
        return parents;
    }

    @Override
    public List<Person> getChildren() {
        return children;
    }

    @Override
    public List<Person> getSubParents() {
        List<Person> result = new ArrayList<>();
        List<Person> subResult = this.getParents();
        for (Person per : subResult) {
            for (Person subPar : per.getParents()) {
                result.add(subPar);
            }
        }
        return result;
    }

    @Override
    public List<Person> getSubChildren() {
        List<Person> result = new ArrayList<>();
        List<Person> subResult = this.getChildren();
        for (Person per : subResult) {
            for (Person subChil : per.getChildren()) {
                result.add(subChil);
            }
        }
        return result;
    }
}
