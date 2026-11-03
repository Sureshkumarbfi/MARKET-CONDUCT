package com.bornfire.xbrl.entities;

import javax.persistence.*;

@Entity
@Table(name = "MIS_MENU_TABLE")
public class MisMenuTable_Entity {

    @Id
    @Column(name = "ID", length = 15)
    private String id;

    @Column(name = "MENU_NAME", length = 200)
    private String menuName;

    @Column(name = "SUB_MENU_NAME", length = 200)
    private String subMenuName;

    // Constructors
    public MisMenuTable_Entity() {}

    public MisMenuTable_Entity(String id, String menuName, String subMenuName) {
        this.id = id;
        this.menuName = menuName;
        this.subMenuName = subMenuName;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getSubMenuName() {
        return subMenuName;
    }

    public void setSubMenuName(String subMenuName) {
        this.subMenuName = subMenuName;
    }

    @Override
    public String toString() {
        return "MisMenuTable{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", subMenuName='" + subMenuName + '\'' +
                '}';
    }
}
