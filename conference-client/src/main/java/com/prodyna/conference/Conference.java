package com.prodyna.conference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Conference")
@Table(name = "conference")
@NamedQueries({
        @NamedQuery(name = "all", query = "select c from Conference c"),
        @NamedQuery(name = "byName", query = "select c from Conference c where c.name = :name")
})
public class Conference implements Serializable {
    private String id;
    private String name;
    private Date firstDate;
    private Date lastDate;

    public Conference() {
        // ok
    }

    public Conference(String id, String name, Date firstDate, Date lastDate) {
        this.id = id;
        this.name = name;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conference that = (Conference) o;

        if (firstDate != null ? !firstDate.equals(that.firstDate) : that.firstDate != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lastDate != null ? !lastDate.equals(that.lastDate) : that.lastDate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (firstDate != null ? firstDate.hashCode() : 0);
        result = 31 * result + (lastDate != null ? lastDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", firstDate=" + firstDate +
                ", lastDate=" + lastDate +
                '}';
    }
}
