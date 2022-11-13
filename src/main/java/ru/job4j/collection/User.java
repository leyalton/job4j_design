package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        Calendar birthday = Calendar.getInstance();

        User user1 = new User("Alex", 21, birthday);
        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;

        User user2 = new User("Alex", 21, birthday);
        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;

        User user3 = new User("123", 21, birthday);
        int hashCode3 = user3.hashCode();
        int hash3 = hashCode3 ^ (hashCode3 >>> 16);
        int bucket3 = hash3 & 15;

        map.put(user1, new Object());
        map.put(user2, new Object());
        map.put(user3, new Object());

        System.out.printf("user1 - хешкод: %s, хеш: %s, бакет: %s, \n",
                hashCode1, hash1, bucket1);
        System.out.printf("user2 - хешкод: %s, хеш: %s, бакет: %s, \n",
                hashCode2, hash2, bucket2);
        System.out.printf("user3 - хешкод: %s, хеш: %s, бакет: %s, \n",
                hashCode3, hash3, bucket3);

        map.forEach((key, value) -> System.out.println(key + " --- " + value));
    }
}