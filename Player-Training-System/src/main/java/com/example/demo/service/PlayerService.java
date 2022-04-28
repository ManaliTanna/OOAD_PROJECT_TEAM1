package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Player;
import com.example.demo.repository.PlayerRepo;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepo repo;
	
	public void addPlayer(Player p)
	{
		repo.save(p);
	}
	
	public List<Player> getAllPlayers()
	{
		return repo.findAll();
	}
	
	public Player getPlayerById(int id)
	{
		Optional<Player> p = repo.findById(id);
		if(p.isPresent())
		{
			return p.get();
		}
		return null;
	}
	
	public void deletePlayer(int id)
	{
		repo.deleteById(id);
	}

}
