package model;

import java.util.Objects;

public class Group {
    private String group_name;

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Group(String group_name) {
        this.group_name = group_name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "group_name='" + group_name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;
        Group group = (Group) o;
        return Objects.equals(group_name, group.group_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group_name);
    }
}
