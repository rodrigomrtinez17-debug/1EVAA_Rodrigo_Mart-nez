package org.example;

import java.util.ArrayList;
import java.util.List;

public class birthday_repository {

    private List<birthday_agenda> LIST = new ArrayList<>();

    public List<birthday_agenda> GetList() {
        return LIST;
    }

    public void AddCumple(birthday_agenda birthday) {
        LIST.add(birthday);
    }

    public birthday_agenda FindByNmae(String name) {
        for (birthday_agenda c : LIST) {
            if (c.GetName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public List<birthday_agenda> FindByDay(int day) {
        List<birthday_agenda> result = new ArrayList<>();
        for (birthday_agenda c : LIST) {
            if (c.GetDay() == day) {
                result.add(c);
            }
        }
        return result;
    }

    public boolean DeleteByName(String name) {
        birthday_agenda found = FindByNmae(name);
        if (found != null) {
            LIST.remove(found);
            return true;
        }
        return false;
    }
}
