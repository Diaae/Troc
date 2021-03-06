package fr.dsc.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Troc {
    @Id @GeneratedValue
    private  int id;
    @Transient
    public static final String OFFRE = "offre";
    @Transient
    public static final String DEMANDE = "demande";

    @Transient
    public static final String CONTRE_PROP="1";
    @Transient
    public static final String MSG = "2";
    private String titre;
    private String type;
    @OneToMany(mappedBy = "offre")
    private List<Objet> offres;
    @OneToMany(mappedBy = "demande")
    private List<Objet> demandes;
    private String status;
    private String msgValid;
    @ManyToOne
    private Troc parent;

    @OneToMany(mappedBy="parent",fetch = FetchType.EAGER)
    private List<Troc> contreProps;

    public Troc(){status="0";}



}
