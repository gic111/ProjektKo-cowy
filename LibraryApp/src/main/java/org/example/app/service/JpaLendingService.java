package org.example.app.service;

import org.example.app.model.Lending;
import org.example.repository.LendingRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class JpaLendingService implements LendingService{

    private final LendingRepository lendingRepository;

    public JpaLendingService(LendingRepository lendingRepository) {
        this.lendingRepository = lendingRepository;
    }

    @Override
    public Lending getLendingById(Long id) {
        return lendingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addLending(Lending lendingToAdd) {
        lendingRepository.save(lendingToAdd);

    }

    @Override
    public void editLending(Lending lendingToEdit) {
       lendingRepository.save(lendingToEdit);
    }

    @Override
    public void deleteLending(Long id) {
        lendingRepository.deleteById(id);

    }

    @Override
    public List<Lending> findAllLendings() {
        return lendingRepository.findAll();
    }
}
