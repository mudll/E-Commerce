package com.example.muril.e_commerce;



import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by muril on 04/04/2017.
 */

public class Produtos implements Serializable {

    public String prodNome;
    public String prodDepa;
    public int prodPrec;
    public String prodDesc;

    public Produtos(String prodNome, String prodDepa, int prodPrec, String prodDesc) {
        this.prodNome = prodNome;
        this.prodDepa = prodDepa;
        this.prodPrec = prodPrec;
        this.prodDesc = prodDesc;
    }

    public static ArrayList<Produtos> getProdutos(){
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();

        produtos.add(new Produtos("NoteBook Dell", "Notebook", 2600, "Notebook i7 Dell"));
        produtos.add(new Produtos("NoteBook iMac", "Notebook", 4500, "MacAir i3"));
        produtos.add(new Produtos("Desktop Dell", "Desktop", 3000, "Desktop i7 Dell"));
        produtos.add(new Produtos("Desktop Gamer Razor", "Desktop", 3800, "Razor Gamer Top de Linha "));
        produtos.add(new Produtos("Mouse Logitech", "Acessorios", 80, "Mouse Sem Fio LogiTech"));
        produtos.add(new Produtos("Teclado Microsoft", "Acessorios", 100, "Teclado sem Fio Microsoft"));
        produtos.add(new Produtos("iPhone 7", "Smartphone", 3500, "No iPhone Caro"));
        produtos.add(new Produtos("Galaxy S8", "Smartphone", 3000, "Lançamento Samsung"));
        produtos.add(new Produtos("Tv 50' Philips", "Tv", 2000, "SmartTv Philips 1 de Garantia"));
        produtos.add(new Produtos("Tv Led 48' CCE", "Tv", 1500, "Tv de Led CCE"));
        produtos.add(new Produtos("Camera 50mp Kodak", "Camera", 1600, "Kodak Version Plus"));
        produtos.add(new Produtos("GO Pro Black", "Camera", 2200, "GOPro Black com Case"));

        return produtos;

    }



}
