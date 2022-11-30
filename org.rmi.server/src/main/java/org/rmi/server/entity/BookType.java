package org.rmi.server.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "type")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class BookType implements Serializable {
	private static final long serialVersionUID = 1451149522296177311L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;

	@NonNull
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "type")
	private List<Book> books;
}
