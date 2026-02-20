package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.List;

public class FinancialAdvisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int advisorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "advisor")
    private List<Client> clients;

    public FinancialAdvisor(String name, String email, String phone, List<Client> clients){
        this.name = name;
        this.email = email;
        this.phone =  phone;
        this.clients = clients;
    }

    public FinancialAdvisor(){}

    public int getAdvisorId() {
        return advisorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
