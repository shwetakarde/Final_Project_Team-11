package com.Sharecare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sharecare.model.Artistic;
import com.Sharecare.repository.ArtisticRepository;

@Service
public class ArtisticService {

	@Autowired
	private ArtisticRepository artisticrepo;
	
	public Artistic saveContent(Artistic artistic) {
		return artisticrepo.save(artistic);
	}

	public List<Artistic> getAllCreativity() {
		return artisticrepo.findAll();
	}
}
