package ru.serik.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "positions")
public class Position {
    private int idPosition;
    private String namePosition;
    private List<Person> people;

    //Конструктор по умолчанию
    public Position() {
    }

    //Параметризованный конструктор
    public Position(String namePosition) {
        this.namePosition = namePosition;
        people = new ArrayList<>();
    }

    //Getters
    @Column(name = "name_position")
    public String getNamePosition() {
        return namePosition;
    }

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    public List<Person> getPeople() {
        return people;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_position")
    public int getIdPosition() {
        return idPosition;
    }

    //Setters
    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }
    public void setPeople(List<Person> people) {
        this.people = people;
    }


    //toString
    @Override
    public String toString() {
        String listPeople = "";
        if(this.people.isEmpty()) {
            listPeople = " empty ";
        }else {
            for(int i = 0; i <= this.people.size() - 1; i++) {
                if (i == this.people.size() - 1) {
                    listPeople += this.people.get(i).getNamePerson() + "(id=" + this.people.get(i).getIdPerson() + ")";
                }else {
                    listPeople += this.people.get(i).getNamePerson() + "(id=" + this.people.get(i).getIdPerson() + "), ";
                }
            }
        }
        return "Position{" + "idPosition=" + this.idPosition + ", namePosition='" + this.namePosition + "'" + ", listPeople={" + listPeople + "}" + "}";
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return idPosition == position.idPosition &&
                Objects.equals(namePosition, position.namePosition);
    }

    //Additional methods
    public void addPersonInList(Person person) {
        people.add(person);
    }

}
