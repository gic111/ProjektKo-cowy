package org.example.app.service;

import org.example.app.model.Lending;


import java.util.List;

public interface LendingService {
    Lending getLendingById(Long id);

    void addLending(Lending lendingToAdd);

    void editLending(Lending lendingToEdit);

    void deleteLending(Long id);

    List<Lending> findAllLendings();
}
