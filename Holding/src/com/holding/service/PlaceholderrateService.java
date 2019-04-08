package com.holding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.holding.po.Placeholderrate;
import com.holding.po.PlaceholderrateExample;

@Service
public interface PlaceholderrateService {
		
	List<Placeholderrate> getAll() throws Exception;
}
