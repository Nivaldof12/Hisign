package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.demo.domain.Teste;
import com.example.demo.repository.TesteRepository;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TesteService {
	@Autowired
    private TesteRepository testeRepository;


    // Método para salvar
    public Teste incluir(Teste teste) {
        return testeRepository.save(teste);
    }

    // Método para excluir com base no ID
    public void excluirTestePorId(Integer id) {
    	testeRepository.deleteById(id);
    }
    
    // Método para listar os Testes
	public Collection<Teste> obterLista(){
		return (Collection<Teste>) testeRepository.findAll();
	}
	
    public Teste obterTestePorId(Integer id) {
        return testeRepository.findById(id).orElse(null);
    }

    public Teste atualizar(Teste teste) {
        return testeRepository.save(teste);
    }
    public Teste saveFile(MultipartFile file){
        String docName = file.getOriginalFilename();
        try {
            Teste teste = new Teste(docName, file.getContentType(), file.getBytes());
            return testeRepository.save(teste);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Optional<Teste> getFile(Integer fileId) {
        return testeRepository.findById(fileId);
    }
    public List<Teste> getAllFiles() {
        return testeRepository.findAll();
    }
}
