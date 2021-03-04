package com.example.linktracker.repository;

import com.example.linktracker.exception.LinkInvalidException;
import com.example.linktracker.exception.LinkNotFoundException;
import com.example.linktracker.model.LinkInputDTO;
import com.example.linktracker.model.LinkStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinktrackerReporitory implements ILinktrackerRepository{
    private static List<LinkStatus> linkMemory=new ArrayList<>();


    @Override
    public Integer addLink(LinkInputDTO linkInputDTO) {
        LinkStatus link=new LinkStatus();
        link.setLinkId(linkMemory.size());
        link.setStatus(true);
        link.setUrl(linkInputDTO.getUrl());
        link.setPassword(linkInputDTO.getPassword());
        link.setMetric(0);
        linkMemory.add(link);
        return link.getLinkId();
    }
    public void invalidateLink(Integer linkId) throws LinkNotFoundException {
        try {
             linkMemory.get(linkId).setStatus(false);
        }catch (Exception e){
            throw new LinkNotFoundException();
        }
    }

    @Override
    public Integer getMetrics(Integer linkId) throws LinkNotFoundException {
         try{
             return linkMemory.get(linkId).getMetric();
         }catch (Exception e){
            throw new LinkNotFoundException();
         }
    }

    @Override
    public LinkStatus getLink(Integer linkId) throws  LinkNotFoundException {
        try {
            linkMemory.get(linkId).setMetric(linkMemory.get(linkId).getMetric()+1);
            return linkMemory.get(linkId);
        }catch (Exception e){
            throw  new LinkNotFoundException();
        }
    }


}
