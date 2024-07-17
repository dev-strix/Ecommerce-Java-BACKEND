package com.prjct.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.prjct.entity.Assignments;
import com.prjct.entity.Clients;
import com.prjct.entity.OrderProduct;
import com.prjct.entity.Vouchers;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_orders;

    private double total_discount;
    private double total_price;
    private double final_price;
    private String purchase_date;
    private String pay_date;
    private String reception_date;
    private String shipped_state;
    private String is_canceled;
    private String is_payed;
    private String created_at;
    private String updated_at;
    
    // Relación con Clientes (muchos a uno)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_clients", nullable = false)
    private Clients clients;

    // Relación con Vouchers (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<Vouchers> vouchers;

    // Relación con Productos de Orden (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<OrderProduct> orderProducts;

    // Relación con Asignaciones (uno a muchos)
    @JsonIgnore
    @OneToMany(mappedBy = "orders")
    private List<Assignments> assignments;

    
	public Orders() {
		super();
	}

	public Orders(int id_orders, double total_discount, double total_price, double final_price, String purchase_date,
			String pay_date, String reception_date, String shipped_state, String is_canceled, String is_payed,
			String created_at, String updated_at, Clients clients, List<Vouchers> vouchers,
			List<OrderProduct> orderProducts, List<Assignments> assignments) {
		super();
		this.id_orders = id_orders;
		this.total_discount = total_discount;
		this.total_price = total_price;
		this.final_price = final_price;
		this.purchase_date = purchase_date;
		this.pay_date = pay_date;
		this.reception_date = reception_date;
		this.shipped_state = shipped_state;
		this.is_canceled = is_canceled;
		this.is_payed = is_payed;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.clients = clients;
		this.vouchers = vouchers;
		this.orderProducts = orderProducts;
		this.assignments = assignments;
	}

	public int getId_orders() {
		return id_orders;
	}

	public void setId_orders(int id_orders) {
		this.id_orders = id_orders;
	}

	public double getTotal_discount() {
		return total_discount;
	}

	public void setTotal_discount(double total_discount) {
		this.total_discount = total_discount;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public double getFinal_price() {
		return final_price;
	}

	public void setFinal_price(double final_price) {
		this.final_price = final_price;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public String getReception_date() {
		return reception_date;
	}

	public void setReception_date(String reception_date) {
		this.reception_date = reception_date;
	}

	public String getShipped_state() {
		return shipped_state;
	}

	public void setShipped_state(String shipped_state) {
		this.shipped_state = shipped_state;
	}

	public String getIs_canceled() {
		return is_canceled;
	}

	public void setIs_canceled(String is_canceled) {
		this.is_canceled = is_canceled;
	}

	public String getIs_payed() {
		return is_payed;
	}

	public void setIs_payed(String is_payed) {
		this.is_payed = is_payed;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public List<Vouchers> getVouchers() {
		return vouchers;
	}

	public void setVouchers(List<Vouchers> vouchers) {
		this.vouchers = vouchers;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public List<Assignments> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignments> assignments) {
		this.assignments = assignments;
	}

    // Getters y Setters para las relaciones
    
}