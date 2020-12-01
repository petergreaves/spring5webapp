package guru.springframework.spring5webapp.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;
    private String addressLine1;
    private String addressLine2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String town;
    private String postCode;

    @OneToMany
    @JoinColumn(name="publisher_id")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String addressLine1, String addressLine2, String town, String postCode) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.postCode = postCode;
    }



    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }



    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", town='" + town + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return Id != null ? Id.equals(publisher.Id) : publisher.Id == null;
    }

    @Override
    public int hashCode() {
        return Id != null ? Id.hashCode() : 0;
    }
}
