package com.zhengl.designmode.composite.safety;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hero良
 */
public class CompanyComposite extends CompanyComponent {

    private List<CompanyComponent> schoolList = new ArrayList<>();

    public CompanyComposite(Integer id, String name, int level) {
        super(id, name, level);
    }

    public void add(CompanyComponent component){
        schoolList.add(component);
    }

    public void remove(CompanyComponent component){
        schoolList.remove(component);
    }

    public List<CompanyComponent> getChild(){
        return schoolList;
    }

    @Override
    protected void print() {
        for (int i = 0; i < level; i++) System.out.print("--");

        System.out.println("id = " + id + "， name = " + name);

        for (CompanyComponent com : schoolList) {
            com.print();
        }
    }
}
