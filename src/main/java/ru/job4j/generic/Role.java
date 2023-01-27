package ru.job4j.generic;

public class Role extends Base {
    private final String roleName;

    public Role(String id, String role) {
        super(id);
        this.roleName = role;
    }

    public String getRoleName() {
        return roleName;
    }
}
