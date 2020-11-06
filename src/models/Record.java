package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "records")
@NamedQueries({
    @NamedQuery(
            name = "getAllRecords",
            query = "SELECT r FROM Record AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getRecordsCount",
            query = "SELECT COUNT(r) FROM Record AS r"
            ),

    @NamedQuery(
            name = "getRecordsMoney",
            query = "SELECT SUM(r.money) FROM Record AS r WHERE r.person = :person"
            ),

    @NamedQuery(
            name = "getMyAllRecords",
            query = "SELECT r FROM Record AS r WHERE r.person = :person ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyRecordsCount",
            query = "SELECT COUNT(r) FROM Record AS r WHERE r.person = :person"
            )
})
@Entity
public class Record {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "money", nullable = false)
    private Integer money;

    @Column(name = "record_date", nullable = false)
    private Date record_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Date record_date) {
        this.record_date = record_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
