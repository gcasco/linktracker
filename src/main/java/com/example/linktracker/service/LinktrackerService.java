package com.example.linktracker.service;

import com.example.linktracker.exception.LinkInvalidException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.model.LinkInputDTO;
import com.example.linktracker.model.LinkStatus;
import com.example.linktracker.repository.ILinktrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinktrackerService implements ILinktrackerService {

    @Autowired
    private ILinktrackerRepository repository;

    @Override
    public Integer addLink(LinkInputDTO linkInputDTO) {
        return repository.addLink(linkInputDTO);
    }

    @Override
    public String getLink(Integer linkId, String password) throws LinkNotFoundException, LinkInvalidException {
        LinkStatus linkStatus = repository.getLink(linkId);
        if (linkStatus.getStatus() && linkStatus.getPassword().equals(password)) {
            return linkStatus.getUrl();
        } else {
            throw new LinkInvalidException();
        }
    }

    @Override
    public void invalidateLink(Integer linkId) throws LinkNotFoundException {
        repository.invalidateLink(linkId);
    }

    @Override
    public Integer getMetrics(Integer linkId) throws LinkNotFoundException {
        return repository.getMetrics(linkId);
    }
}
