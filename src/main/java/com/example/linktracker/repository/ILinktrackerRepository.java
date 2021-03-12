package com.example.linktracker.repository;

import com.example.linktracker.exception.LinkInvalidException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.model.LinkInputDTO;
import com.example.linktracker.model.LinkStatus;

public interface ILinktrackerRepository {
    Integer addLink(LinkInputDTO linkInputDTO);

    LinkStatus getLink(Integer linkId) throws LinkInvalidException, LinkNotFoundException;

    void invalidateLink(Integer linkId) throws LinkNotFoundException;

    Integer getMetrics(Integer linkId) throws LinkNotFoundException;
}
