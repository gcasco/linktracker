package com.example.linktracker.service;

import com.example.linktracker.exception.LinkInvalidException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.model.LinkInputDTO;

public interface ILinktrackerService {
    Integer addLink(LinkInputDTO linkInputDTO);
    String getLink(Integer linkId, String password) throws LinkNotFoundException, LinkInvalidException;
    void invalidateLink(Integer linkId) throws LinkNotFoundException;
    Integer getMetrics(Integer linkId) throws LinkNotFoundException;
}
