/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.webapps.bookstore;

import dbsetup.DBsetup;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UDU
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id")
    , @NamedQuery(name = "Orders.findByBooktitle", query = "SELECT o FROM Orders o WHERE o.booktitle = :booktitle")})
public class Orders implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "booktitle")
    private String booktitle;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.me.webapps.bookstore.Orders[ id=" + id + " ]";
    }
    
        public boolean addNewUser(String bookTitle) {
            Statement stmt = null;
            try {
            Connection c = DBsetup.getConnection();
            //PreparedStatement userCreate;
            //userCreate = connection.prepareStatement("INSERT INTO \"public\".orders (booKtitle)VALUES(?)");
            //userCreate.setString(1, bookTitle);
            stmt = c.createStatement();
            String sql = "INSERT INTO \"public\".orders (booktitle) VALUES (BUY)";
            stmt.executeUpdate(sql);

            //if (results.next()) return false;
            //insert into authorISBN (authorID,isbn) values (3,'0130284181')
            return true;

        } // process exceptions during database setup        
        catch (SQLException sqlException) {
            return false;
        } // process problems locating data source		
        catch (Exception exception) {
            return false;
        }

    }
    
}
