package com.example.Clinica.Odontologica.service;

import com.example.Clinica.Odontologica.dto.ConsultaDto;
import com.example.Clinica.Odontologica.model.ConsultaModel;
import com.example.Clinica.Odontologica.repository.ConsultaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ConsultaService {

    @Autowired
    ConsultaRepository consultaRepository;

    public ResponseEntity salvarConsulta(ConsultaModel consulta){
        try{
            ConsultaModel consultaSalva = consultaRepository.save(consulta);
            return new ResponseEntity(consultaSalva, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity("Não foi possível salvar a consulta", HttpStatus.BAD_REQUEST);
        }
    }

    public ConsultaModel buscarConsulta(Long id){
        return consultaRepository.findById_Id(id);
    }

    public ResponseEntity buscarTodasConsultas(){
        List<ConsultaModel> listConsultas = consultaRepository.findAll();
        if(listConsultas.isEmpty()){
            return new ResponseEntity<>("Nenhuma consulta cadastrada", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listConsultas, HttpStatus.OK);
    }
}

