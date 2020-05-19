package com.example.filmes.controller;

import java.util.ArrayList;

import com.example.filmes.entities.Filme;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/filme")
public class FilmesController {
  ArrayList<Filme> filmes = new ArrayList<Filme>();

  // GET
  public ArrayList<Filme> getFilme() {

    return this.filmes;
  }

  // POST
  @PostMapping
  public Filme postFilme(@RequestBody Filme filme) {
    filmes.add(filme);

    return filme;
  }

  // DELETE
  @DeleteMapping("/{id}")
  public Filme deleteFilme(@PathVariable String id) {
    Filme newFilme = null;

    for (Filme filme: this.filmes) {
      if(filme.getId().equals(id)) {

        newFilme = filme;
      }
    }
    if(newFilme != null) {
      filmes.remove(newFilme);

      return newFilme;
    }
    else return null;
  }

  // UPDATE
  @PutMapping
  public Filme updateFilme(@RequestBody Filme newFilme) {
      
    for (Filme filme: this.filmes) {
      if(filme.getId().equals(newFilme.getId())) {
        int indexExist = this.filmes.indexOf(filme);

        this.filmes.set(indexExist, newFilme);

        return newFilme;
      }
    }
    return null;

  }
}