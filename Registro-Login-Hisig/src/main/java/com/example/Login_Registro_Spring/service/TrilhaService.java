package com.example.Login_Registro_Spring.service;

import com.example.Login_Registro_Spring.entity.Trilha;
import com.example.Login_Registro_Spring.repository.TrilhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@Service
public class TrilhaService {
    @Autowired
    private TrilhaRepository trilhaRepository;

    public Trilha Add(Trilha trilha) {
        return trilhaRepository.save(trilha);
    }
    public void deleteTrilhaById(Integer id) {
    	trilhaRepository.deleteById(id);
    }
    public Collection<Trilha> getAll(){
    	return (Collection<Trilha>) trilhaRepository.findAll();
    }
    public void saveFile(Integer trilhaId, MultipartFile file) throws IOException {
        Trilha trilha = trilhaRepository.findById(trilhaId)
                .orElseThrow(() -> new IllegalArgumentException("Trilha ID Invalida: " + trilhaId));

        trilha.setResumo_Envio(file.getBytes());

        trilhaRepository.save(trilha);
    }
    public Trilha getTrilhaById(Integer id) {
        Optional<Trilha> optionalTrilha = trilhaRepository.findById(id);
        return optionalTrilha.orElse(null);
    }
}
