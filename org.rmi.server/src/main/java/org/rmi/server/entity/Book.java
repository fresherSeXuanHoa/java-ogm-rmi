package org.rmi.server.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Book implements Serializable {
	private static final long serialVersionUID = 8307629935988000912L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ObjectId id;

	@NonNull
	@Column(name = "name")
	private String name;

	@NonNull
	@Column(name = "price")
	private Double price;

	@NonNull
	@Column(name = "quantity_in_stock")
	private Integer quantityInStock;

	@NonNull
	@Column(name = "author")
	private String author;

	@NonNull
	@Column(name = "manufacturer")
	private String manufacturer;

	@NonNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "type")
	private BookType type;
}