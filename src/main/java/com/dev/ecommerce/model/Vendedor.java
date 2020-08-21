package com.dev.ecommerce.model;

import javax.persistence.ManyToOne;

public class Vendedor extends Usuario {

    @ManyToOne
    private Loja loja;

}
