package com.example.filmes.controller;

import java.util.ArrayList;

import com.example.filmes.entities.Filme;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/filme")
public class FilmesController {
  // GET

  ArrayList<Filme> filmes = new ArrayList<Filme>();

  @GetMapping
  public ArrayList<Filme> getFilme() {

    return this.filmes;
  }

  // POST
  @PostMapping
  public Filme postFilme(@RequestBody Filme filme) {
    filmes.add(filme);

    return filme;
  }

  @PutMapping(value="/api/filme/:id")
  public Filme putMethodName(@PathVariable String id, @RequestBody Filme filme) {
      //TODO: process PUT request
      
    return filme;
  }



  
}